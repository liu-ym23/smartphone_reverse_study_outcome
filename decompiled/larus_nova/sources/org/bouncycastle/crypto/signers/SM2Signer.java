package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECAlgorithms;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SM2Signer implements Signer, ECConstants {
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private final DSAEncoding encoding;
    private final DSAKCalculator kCalculator;
    private ECPoint pubPoint;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private byte[] f525344z;

    public SM2Signer() {
        this(StandardDSAEncoding.INSTANCE, new SM3Digest());
    }

    public SM2Signer(Digest r100) {
        this(StandardDSAEncoding.INSTANCE, r100);
    }

    public SM2Signer(DSAEncoding r100) {
        this.kCalculator = new RandomDSAKCalculator();
        this.encoding = r100;
        this.digest = new SM3Digest();
    }

    public SM2Signer(DSAEncoding r100, Digest r101) {
        this.kCalculator = new RandomDSAKCalculator();
        this.encoding = r100;
        this.digest = r101;
    }

    private void addFieldElement(Digest r100, ECFieldElement r101) {
        byte[] r102 = r101.getEncoded();
        r100.update(r102, 0, r102.length);
    }

    private void addUserID(Digest r100, byte[] r101) {
        int r102 = r101.length * 8;
        r100.update((byte) ((r102 >> 8) & 255));
        r100.update((byte) (r102 & 255));
        r100.update(r101, 0, r101.length);
    }

    private byte[] digestDoFinal() {
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        reset();
        return r100;
    }

    private byte[] getZ(byte[] r100) {
        this.digest.reset();
        addUserID(this.digest, r100);
        addFieldElement(this.digest, this.ecParams.getCurve().getA());
        addFieldElement(this.digest, this.ecParams.getCurve().getB());
        addFieldElement(this.digest, this.ecParams.getG().getAffineXCoord());
        addFieldElement(this.digest, this.ecParams.getG().getAffineYCoord());
        addFieldElement(this.digest, this.pubPoint.getAffineXCoord());
        addFieldElement(this.digest, this.pubPoint.getAffineYCoord());
        byte[] r101 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r101, 0);
        return r101;
    }

    private boolean verifySignature(BigInteger r100, BigInteger r101) {
        BigInteger r102 = this.ecParams.getN();
        BigInteger r103 = ECConstants.ONE;
        if (r100.compareTo(r103) >= 0) goto L5;
    L20:
        return false;
    L5:
        if (r100.compareTo(r102) >= 0) goto L20;
        if (r101.compareTo(r103) < 0) goto L20;
        if (r101.compareTo(r102) >= 0) goto L20;
        BigInteger r104 = calculateE(r102, digestDoFinal());
        BigInteger r105 = r100.add(r101).mod(r102);
        if (r105.equals(ECConstants.ZERO) == false) goto L15;
        return false;
    L15:
        ECPoint r106 = ((ECPublicKeyParameters) this.ecKey).getQ();
        ECPoint r107 = ECAlgorithms.sumOfTwoMultiplies(this.ecParams.getG(), r101, r106, r105).normalize();
        if (r107.isInfinity() == false) goto L19;
        return false;
    L19:
        return r104.add(r107.getAffineXCoord().toBigInteger()).mod(r102).equals(r100);
    }

    public BigInteger calculateE(BigInteger r100, byte[] r101) {
        return new BigInteger(1, r101);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        byte[] r100 = digestDoFinal();
        BigInteger r101 = this.ecParams.getN();
        BigInteger r102 = calculateE(r101, r100);
        BigInteger r103 = ((ECPrivateKeyParameters) this.ecKey).getD();
        ECMultiplier r104 = createBasePointMultiplier();
    L3:
        BigInteger r105 = this.kCalculator.nextK();
        BigInteger r106 = r102.add(r104.multiply(this.ecParams.getG(), r105).normalize().getAffineXCoord().toBigInteger()).mod(r101);
        BigInteger r107 = ECConstants.ZERO;
        if (r106.equals(r107) == true) goto L3;
        if (r106.add(r105).equals(r101) == true) goto L3;
        BigInteger r108 = BigIntegers.modOddInverse(r101, r103.add(ECConstants.ONE)).multiply(r105.subtract(r106.multiply(r103)).mod(r101)).mod(r101);
        if (r108.equals(r107) == true) goto L3;
        return this.encoding.encode(this.ecParams.getN(), r106, r108);
    L11:
        e = move-exception;
        throw new CryptoException("unable to encode signature: " + e.getMessage(), e);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithID) == false) goto L9;
        ParametersWithID r102 = (ParametersWithID) r101;
        CipherParameters r103 = r102.getParameters();
        byte[] r104 = r102.getID();
        if (r104.length >= 8192) goto L8;
        byte[] r105 = r104;
        r101 = r103;
    L10:
        if (r100 == true) goto L12;
        ECKeyParameters r106 = (ECKeyParameters) r101;
        this.ecKey = r106;
        this.ecParams = r106.getParameters();
        ECPoint r107 = ((ECPublicKeyParameters) this.ecKey).getQ();
    L17:
        this.pubPoint = r107;
        byte[] r108 = getZ(r105);
        this.f525344z = r108;
        this.digest.update(r108, 0, r108.length);
        return;
    L12:
        if ((r101 instanceof ParametersWithRandom) == false) goto L14;
        ParametersWithRandom r109 = (ParametersWithRandom) r101;
        ECKeyParameters r110 = (ECKeyParameters) r109.getParameters();
        this.ecKey = r110;
        ECDomainParameters r111 = r110.getParameters();
        this.ecParams = r111;
        this.kCalculator.init(r111.getN(), r109.getRandom());
    L15:
        r107 = createBasePointMultiplier().multiply(this.ecParams.getG(), ((ECPrivateKeyParameters) this.ecKey).getD()).normalize();
        goto L17
    L14:
        ECKeyParameters r112 = (ECKeyParameters) r101;
        this.ecKey = r112;
        ECDomainParameters r113 = r112.getParameters();
        this.ecParams = r113;
        this.kCalculator.init(r113.getN(), CryptoServicesRegistrar.getSecureRandom());
        goto L15
    L8:
        throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
    L9:
        r105 = Hex.decodeStrict("31323334353637383132333435363738");
        goto L10
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        byte[] r100 = this.f525344z;
        if (r100 == null) goto L6;
        this.digest.update(r100, 0, r100.length);
        return;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.digest.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        BigInteger[] r101 = this.encoding.decode(this.ecParams.getN(), r100);     // Catch: Exception -> L5
        return verifySignature(r101[0], r101[1]);
    L5:
        return false;
    }
}
