package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SM2KeyExchange {
    private final Digest digest;
    private ECDomainParameters ecParams;
    private ECPrivateKeyParameters ephemeralKey;
    private ECPoint ephemeralPubPoint;
    private boolean initiator;
    private ECPrivateKeyParameters staticKey;
    private ECPoint staticPubPoint;
    private byte[] userID;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f525101w;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    public SM2KeyExchange(Digest r100) {
        this.digest = r100;
    }

    private byte[] S1(Digest r100, ECPoint r101, byte[] r102) {
        r100.update((byte) 2);
        addFieldElement(r100, r101.getAffineYCoord());
        r100.update(r102, 0, r102.length);
        return digestDoFinal();
    }

    private byte[] S2(Digest r100, ECPoint r101, byte[] r102) {
        r100.update((byte) 3);
        addFieldElement(r100, r101.getAffineYCoord());
        r100.update(r102, 0, r102.length);
        return digestDoFinal();
    }

    private void addFieldElement(Digest r100, ECFieldElement r101) {
        byte[] r102 = r101.getEncoded();
        r100.update(r102, 0, r102.length);
    }

    private void addUserID(Digest r100, byte[] r101) {
        int r102 = r101.length * 8;
        r100.update((byte) (r102 >>> 8));
        r100.update((byte) r102);
        r100.update(r101, 0, r101.length);
    }

    private byte[] calculateInnerHash(Digest r100, ECPoint r101, byte[] r102, byte[] r103, ECPoint r104, ECPoint r105) {
        addFieldElement(r100, r101.getAffineXCoord());
        r100.update(r102, 0, r102.length);
        r100.update(r103, 0, r103.length);
        addFieldElement(r100, r104.getAffineXCoord());
        addFieldElement(r100, r104.getAffineYCoord());
        addFieldElement(r100, r105.getAffineXCoord());
        addFieldElement(r100, r105.getAffineYCoord());
        return digestDoFinal();
    }

    private ECPoint calculateU(SM2KeyExchangePublicParameters r100) {
        ECDomainParameters r101 = this.staticKey.getParameters();
        ECPoint r102 = ECAlgorithms.cleanPoint(r101.getCurve(), r100.getStaticPublicKey().getQ());
        ECPoint r103 = ECAlgorithms.cleanPoint(r101.getCurve(), r100.getEphemeralPublicKey().getQ());
        BigInteger r104 = reduce(this.ephemeralPubPoint.getAffineXCoord().toBigInteger());
        BigInteger r105 = reduce(r103.getAffineXCoord().toBigInteger());
        BigInteger r106 = this.staticKey.getD().add(r104.multiply(this.ephemeralKey.getD()));
        BigInteger r107 = this.ecParams.getH().multiply(r106).mod(this.ecParams.getN());
        return ECAlgorithms.sumOfTwoMultiplies(r102, r107, r103, r107.multiply(r105).mod(this.ecParams.getN())).normalize();
    }

    private byte[] digestDoFinal() {
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        return r100;
    }

    private byte[] getZ(Digest r100, byte[] r101, ECPoint r102) {
        addUserID(r100, r101);
        addFieldElement(r100, this.ecParams.getCurve().getA());
        addFieldElement(r100, this.ecParams.getCurve().getB());
        addFieldElement(r100, this.ecParams.getG().getAffineXCoord());
        addFieldElement(r100, this.ecParams.getG().getAffineYCoord());
        addFieldElement(r100, r102.getAffineXCoord());
        addFieldElement(r100, r102.getAffineYCoord());
        return digestDoFinal();
    }

    private byte[] kdf(ECPoint r110, byte[] r111, byte[] r112, int r113) {
        int r100 = this.digest.getDigestSize();
        byte[] r101 = new byte[Math.max(4, r100)];
        int r114 = (r113 + 7) / 8;
        byte[] r102 = new byte[r114];
        Digest r103 = this.digest;
        if ((r103 instanceof Memoable) == false) goto L5;
        addFieldElement(r103, r110.getAffineXCoord());
        addFieldElement(this.digest, r110.getAffineYCoord());
        this.digest.update(r111, 0, r111.length);
        this.digest.update(r112, 0, r112.length);
        Memoable r104 = (Memoable) this.digest;
        Memoable r105 = r104.copy();
    L6:
        int r106 = 0;
        int r107 = 0;
    L7:
        if (r106 >= r114) goto L12;
        if (r104 == null) goto L10;
        r104.reset(r105);
    L11:
        r107 = r107 + 1;
        Pack.intToBigEndian(r107, r101, 0);
        this.digest.update(r101, 0, 4);
        this.digest.doFinal(r101, 0);
        int r108 = Math.min(r100, r114 - r106);
        System.arraycopy(r101, 0, r102, r106, r108);
        r106 = r106 + r108;
        goto L7
    L10:
        addFieldElement(this.digest, r110.getAffineXCoord());
        addFieldElement(this.digest, r110.getAffineYCoord());
        this.digest.update(r111, 0, r111.length);
        this.digest.update(r112, 0, r112.length);
        goto L11
    L12:
        return r102;
    L5:
        r104 = null;
        r105 = null;
        goto L6
    }

    private BigInteger reduce(BigInteger r100) {
        return r100.and(BigInteger.valueOf(1).shiftLeft(this.f525101w).subtract(BigInteger.valueOf(1))).setBit(this.f525101w);
    }

    public byte[] calculateKey(int r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithID) == false) goto L5;
        ParametersWithID r102 = (ParametersWithID) r101;
        SM2KeyExchangePublicParameters r103 = (SM2KeyExchangePublicParameters) r102.getParameters();
        byte[] r104 = r102.getID();
    L6:
        byte[] r105 = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] r106 = getZ(this.digest, r104, r103.getStaticPublicKey().getQ());
        ECPoint r107 = calculateU(r103);
        if (this.initiator == false) goto L10;
        return kdf(r107, r105, r106, r100);
    L10:
        return kdf(r107, r106, r105, r100);
    L5:
        r103 = (SM2KeyExchangePublicParameters) r101;
        r104 = new byte[0];
        goto L6
    }

    public byte[][] calculateKeyWithConfirmation(int r110, byte[] r111, CipherParameters r112) {
        if ((r112 instanceof ParametersWithID) == false) goto L5;
        ParametersWithID r100 = (ParametersWithID) r112;
        SM2KeyExchangePublicParameters r101 = (SM2KeyExchangePublicParameters) r100.getParameters();
        byte[] r102 = r100.getID();
    L7:
        if (this.initiator == false) goto L12;
        if (r111 != null) goto L12;
        throw new IllegalArgumentException("if initiating, confirmationTag must be set");
    L12:
        byte[] r103 = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] r104 = getZ(this.digest, r102, r101.getStaticPublicKey().getQ());
        ECPoint r113 = calculateU(r101);
        if (this.initiator == false) goto L20;
        byte[] r114 = kdf(r113, r103, r104, r110);
        byte[] r105 = calculateInnerHash(this.digest, r113, r103, r104, this.ephemeralPubPoint, r101.getEphemeralPublicKey().getQ());
        if (Arrays.constantTimeAreEqual(S1(this.digest, r113, r105), r111) == false) goto L19;
        return new byte[][]{r114, S2(this.digest, r113, r105)};
    L19:
        throw new IllegalStateException("confirmation tag mismatch");
    L20:
        byte[] r106 = kdf(r113, r104, r103, r110);
        byte[] r107 = calculateInnerHash(this.digest, r113, r104, r103, r101.getEphemeralPublicKey().getQ(), this.ephemeralPubPoint);
        return new byte[][]{r106, S1(this.digest, r113, r107), S2(this.digest, r113, r107)};
    L5:
        r101 = (SM2KeyExchangePublicParameters) r112;
        r102 = new byte[0];
        goto L7
    }

    public void init(CipherParameters r100) {
        if ((r100 instanceof ParametersWithID) == false) goto L5;
        ParametersWithID r101 = (ParametersWithID) r100;
        SM2KeyExchangePrivateParameters r102 = (SM2KeyExchangePrivateParameters) r101.getParameters();
        this.userID = r101.getID();
    L6:
        this.initiator = r102.isInitiator();
        this.staticKey = r102.getStaticPrivateKey();
        this.ephemeralKey = r102.getEphemeralPrivateKey();
        this.ecParams = this.staticKey.getParameters();
        this.staticPubPoint = r102.getStaticPublicPoint();
        this.ephemeralPubPoint = r102.getEphemeralPublicPoint();
        this.f525101w = (this.ecParams.getCurve().getFieldSize() / 2) - 1;
        return;
    L5:
        r102 = (SM2KeyExchangePrivateParameters) r100;
        this.userID = new byte[0];
        goto L6
    }
}
