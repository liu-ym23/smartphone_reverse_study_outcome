package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.KeyEncapsulation;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class ECIESKeyEncapsulation implements KeyEncapsulation {
    private static final BigInteger ONE = null;
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;
    private DerivationFunction kdf;
    private ECKeyParameters key;
    private SecureRandom rnd;

    static {
        ONE = BigInteger.valueOf(1);
    }

    public ECIESKeyEncapsulation(DerivationFunction r100, SecureRandom r101) {
        this.kdf = r100;
        this.rnd = r101;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    public ECIESKeyEncapsulation(DerivationFunction r100, SecureRandom r101, boolean r102, boolean r103, boolean r104) {
        this.kdf = r100;
        this.rnd = r101;
        this.CofactorMode = r102;
        if (r102 == false) goto L5;
        this.OldCofactorMode = false;
    L6:
        this.SingleHashMode = r104;
        return;
    L5:
        this.OldCofactorMode = r103;
        goto L6
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public CipherParameters decrypt(byte[] r100, int r101) {
        return decrypt(r100, 0, r100.length, r101);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters decrypt(byte[] r100, int r101, int r110, int r111) throws IllegalArgumentException {
        ECKeyParameters r102 = this.key;
        if ((r102 instanceof ECPrivateKeyParameters) == false) goto L15;
        ECPrivateKeyParameters r103 = (ECPrivateKeyParameters) r102;
        ECDomainParameters r104 = r103.getParameters();
        ECCurve r105 = r104.getCurve();
        BigInteger r106 = r104.getN();
        BigInteger r107 = r104.getH();
        byte[] r108 = new byte[r110];
        System.arraycopy(r100, r101, r108, 0, r110);
        ECPoint r109 = r105.decodePoint(r108);
        if (this.CofactorMode == false) goto L7;
    L8:
        r109 = r109.multiply(r107);
    L9:
        BigInteger r112 = r103.getD();
        if (this.CofactorMode == false) goto L13;
        r112 = r112.multiply(r104.getHInv()).mod(r106);
    L13:
        return deriveKey(r111, r108, r109.multiply(r112).normalize().getAffineXCoord().getEncoded());
    L7:
        if (this.OldCofactorMode == false) goto L9;
    L15:
        throw new IllegalArgumentException("Private key required for encryption");
    }

    public KeyParameter deriveKey(int r100, byte[] r101, byte[] r102) {
        if (this.SingleHashMode == true) goto L11;
        byte[] r103 = Arrays.concatenate(r101, r102);
        Arrays.fill(r102, (byte) 0);
        r102 = r103;
    L11:
        this.kdf.init(new KDFParameters(r102, null));     // Catch: Throwable -> L8
        byte[] r104 = new byte[r100];     // Catch: Throwable -> L8
        this.kdf.generateBytes(r104, 0, r100);     // Catch: Throwable -> L8
        KeyParameter r105 = new KeyParameter(r104);     // Catch: Throwable -> L8
        Arrays.fill(r102, (byte) 0);
        return r105;
    L8:
        th = move-exception;
        Arrays.fill(r102, (byte) 0);
        throw th;
    }

    public CipherParameters encrypt(byte[] r100, int r101) {
        return encrypt(r100, 0, r101);
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public CipherParameters encrypt(byte[] r100, int r101, int r110) throws IllegalArgumentException {
        ECKeyParameters r102 = this.key;
        if ((r102 instanceof ECPublicKeyParameters) == false) goto L11;
        ECPublicKeyParameters r103 = (ECPublicKeyParameters) r102;
        ECDomainParameters r104 = r103.getParameters();
        ECCurve r105 = r104.getCurve();
        BigInteger r106 = r104.getN();
        BigInteger r107 = r104.getH();
        BigInteger r108 = BigIntegers.createRandomInRange(ONE, r106, this.rnd);
        if (this.OldCofactorMode == false) goto L7;
        BigInteger r109 = r108.multiply(r107).mod(r106);
    L8:
        ECPoint[] r111 = {createBasePointMultiplier().multiply(r104.getG(), r108), r103.getQ().multiply(r109)};
        r105.normalizeAll(r111);
        ECPoint r112 = r111[0];
        ECPoint r113 = r111[1];
        byte[] r114 = r112.getEncoded(false);
        System.arraycopy(r114, 0, r100, r101, r114.length);
        return deriveKey(r110, r114, r113.getAffineXCoord().getEncoded());
    L7:
        r109 = r108;
        goto L8
    L11:
        throw new IllegalArgumentException("Public key required for encryption");
    }

    @Override // org.bouncycastle.crypto.KeyEncapsulation
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof ECKeyParameters) == false) goto L7;
        this.key = (ECKeyParameters) r100;
        return;
    L7:
        throw new IllegalArgumentException("EC key required");
    }
}
