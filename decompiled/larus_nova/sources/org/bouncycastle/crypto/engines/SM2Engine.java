package org.bouncycastle.crypto.engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.FixedPointCombMultiplier;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class SM2Engine {
    private int curveLength;
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private boolean forEncryption;
    private final Mode mode;
    private SecureRandom random;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.engines.SM2Engine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode = null;

        static {
            int[] r100 = new int[Mode.values().length];
            $SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode = r100;
            r100[Mode.C1C3C2.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode C1C2C3 = null;
        public static final Mode C1C3C2 = null;

        static {
            Mode r100 = new Mode("C1C2C3", 0);
            C1C2C3 = r100;
            Mode r101 = new Mode("C1C3C2", 1);
            C1C3C2 = r101;
            $VALUES = new Mode[]{r100, r101};
        }

        private Mode(String r100, int r101) {
            super(r100, r101);
        }

        public static Mode valueOf(String r100) {
            return (Mode) a.a(Mode.class, r100);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public SM2Engine() {
        this(new SM3Digest());
    }

    public SM2Engine(Digest r100) {
        this(r100, Mode.C1C2C3);
    }

    public SM2Engine(Digest r100, Mode r101) {
        if (r101 == null) goto L7;
        this.digest = r100;
        this.mode = r101;
        return;
    L7:
        throw new IllegalArgumentException("mode cannot be NULL");
    }

    public SM2Engine(Mode r100) {
        this(new SM3Digest(), r100);
    }

    private void addFieldElement(Digest r100, ECFieldElement r101) {
        byte[] r102 = BigIntegers.asUnsignedByteArray(this.curveLength, r101.toBigInteger());
        r100.update(r102, 0, r102.length);
    }

    private byte[] decrypt(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        int r100 = (this.curveLength * 2) + 1;
        byte[] r101 = new byte[r100];
        System.arraycopy(r110, r111, r101, 0, r100);
        ECPoint r102 = this.ecParams.getCurve().decodePoint(r101);
        if (r102.multiply(this.ecParams.getH()).isInfinity() == true) goto L22;
        ECPoint r103 = r102.multiply(((ECPrivateKeyParameters) this.ecKey).getD()).normalize();
        int r104 = this.digest.getDigestSize();
        int r113 = (r112 - r100) - r104;
        byte[] r105 = new byte[r113];
        Mode r106 = this.mode;
        Mode r107 = Mode.C1C3C2;
        if (r106 != r107) goto L7;
        System.arraycopy(r110, (r111 + r100) + r104, r105, 0, r113);
    L8:
        kdf(this.digest, r103, r105);
        int r108 = this.digest.getDigestSize();
        byte[] r109 = new byte[r108];
        addFieldElement(this.digest, r103.getAffineXCoord());
        this.digest.update(r105, 0, r113);
        addFieldElement(this.digest, r103.getAffineYCoord());
        this.digest.doFinal(r109, 0);
        if (this.mode != r107) goto L13;
        int r114 = 0;
        int r115 = 0;
    L11:
        if (r114 == r108) goto L16;
        r115 = r115 | (r109[r114] ^ r110[(r111 + r100) + r114]);
        r114 = r114 + 1;
    L16:
        Arrays.fill(r101, (byte) 0);
        Arrays.fill(r109, (byte) 0);
        if (r115 != 0) goto L19;
        return r105;
    L19:
        Arrays.fill(r105, (byte) 0);
        throw new InvalidCipherTextException("invalid cipher text");
    L13:
        r115 = 0;
        int r116 = 0;
    L14:
        if (r116 == r108) goto L16;
        r115 = r115 | (r109[r116] ^ r110[((r111 + r100) + r113) + r116]);
        r116 = r116 + 1;
        goto L14
    L7:
        System.arraycopy(r110, r111 + r100, r105, 0, r113);
        goto L8
    L22:
        throw new InvalidCipherTextException("[h]C1 at infinity");
    }

    private byte[] encrypt(byte[] r100, int r101, int r110) throws InvalidCipherTextException {
        byte[] r102 = new byte[r110];
        System.arraycopy(r100, r101, r102, 0, r110);
        ECMultiplier r103 = createBasePointMultiplier();
    L3:
        BigInteger r104 = nextK();
        byte[] r105 = r103.multiply(this.ecParams.getG(), r104).normalize().getEncoded(false);
        ECPoint r106 = ((ECPublicKeyParameters) this.ecKey).getQ().multiply(r104).normalize();
        kdf(this.digest, r106, r102);
        if (notEncrypted(r102, r100, r101) == true) goto L3;
        byte[] r107 = new byte[this.digest.getDigestSize()];
        addFieldElement(this.digest, r106.getAffineXCoord());
        this.digest.update(r100, r101, r110);
        addFieldElement(this.digest, r106.getAffineYCoord());
        this.digest.doFinal(r107, 0);
        if (AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$engines$SM2Engine$Mode[this.mode.ordinal()] == 1) goto L10;
        return Arrays.concatenate(r105, r102, r107);
    L10:
        return Arrays.concatenate(r105, r107, r102);
    }

    private void kdf(Digest r110, ECPoint r111, byte[] r112) {
        int r100 = r110.getDigestSize();
        byte[] r101 = new byte[Math.max(4, r100)];
        if ((r110 instanceof Memoable) == false) goto L5;
        addFieldElement(r110, r111.getAffineXCoord());
        addFieldElement(r110, r111.getAffineYCoord());
        Memoable r102 = (Memoable) r110;
        Memoable r103 = r102.copy();
    L6:
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r112.length) goto L13;
        if (r102 == null) goto L11;
        r102.reset(r103);
    L12:
        r105 = r105 + 1;
        Pack.intToBigEndian(r105, r101, 0);
        r110.update(r101, 0, 4);
        r110.doFinal(r101, 0);
        int r106 = Math.min(r100, r112.length - r104);
        xor(r112, r101, r104, r106);
        r104 = r104 + r106;
        goto L8
    L11:
        addFieldElement(r110, r111.getAffineXCoord());
        addFieldElement(r110, r111.getAffineYCoord());
        goto L12
    L13:
        return;
    L5:
        r102 = null;
        r103 = null;
        goto L6
    }

    private BigInteger nextK() {
        int r100 = this.ecParams.getN().bitLength();
    L3:
        BigInteger r101 = BigIntegers.createRandomBigInteger(r100, this.random);
        if (r101.equals(BigIntegers.ZERO) == true) goto L3;
        if (r101.compareTo(this.ecParams.getN()) >= 0) goto L3;
        return r101;
    }

    private boolean notEncrypted(byte[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L9;
        if (r100[r103] != r101[r102 + r103]) goto L7;
        r103 = r103 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    private void xor(byte[] r100, byte[] r101, int r102, int r103) {
        int r104 = 0;
    L3:
        if (r104 == r103) goto L5;
        int r105 = r102 + r104;
        r100[r105] = (byte) (r100[r105] ^ r101[r104]);
        r104 = r104 + 1;
        goto L3
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public int getOutputSize(int r100) {
        return (((this.curveLength * 2) + 1) + r100) + this.digest.getDigestSize();
    }

    public void init(boolean r100, CipherParameters r101) {
        this.forEncryption = r100;
        if (r100 == false) goto L9;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        ECKeyParameters r103 = (ECKeyParameters) r102.getParameters();
        this.ecKey = r103;
        this.ecParams = r103.getParameters();
        if (((ECPublicKeyParameters) this.ecKey).getQ().multiply(this.ecParams.getH()).isInfinity() == true) goto L8;
        this.random = r102.getRandom();
    L10:
        this.curveLength = (this.ecParams.getCurve().getFieldSize() + 7) / 8;
        return;
    L8:
        throw new IllegalArgumentException("invalid key: [h]Q at infinity");
    L9:
        ECKeyParameters r104 = (ECKeyParameters) r101;
        this.ecKey = r104;
        this.ecParams = r104.getParameters();
        goto L10
    }

    public byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException {
        if (this.forEncryption == false) goto L7;
        return encrypt(r100, r101, r102);
    L7:
        return decrypt(r100, r101, r102);
    }
}
