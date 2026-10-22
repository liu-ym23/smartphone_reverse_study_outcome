package org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSalt;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ISO9796d2PSSSigner implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private boolean fullMessage;
    private int hLen;
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private int preMStart;
    private byte[] preSig;
    private int preTLength;
    private SecureRandom random;
    private byte[] recoveredMessage;
    private int saltLength;
    private byte[] standardSalt;
    private int trailer;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher r100, Digest r101, int r102) {
        this(r100, r101, r102, false);
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher r100, Digest r101, int r102, boolean r103) {
        this.cipher = r100;
        this.digest = r101;
        this.hLen = r101.getDigestSize();
        this.saltLength = r102;
        if (r103 == false) goto L6;
        int r104 = 188;
    L5:
        this.trailer = r104;
        return;
    L6:
        Integer r105 = ISOTrailers.getTrailer(r101);
        if (r105 == null) goto L11;
        r104 = r105.intValue();
        goto L5
    L11:
        throw new IllegalArgumentException("no valid trailer for digest: " + r101.getAlgorithmName());
    }

    private void ItoOSP(int r100, byte[] r101) {
        r101[0] = (byte) (r100 >>> 24);
        r101[1] = (byte) (r100 >>> 16);
        r101[2] = (byte) (r100 >>> 8);
        r101[3] = (byte) (r100 >>> 0);
    }

    private void LtoOSP(long r100, byte[] r101) {
        r101[0] = (byte) (r100 >>> 56);
        r101[1] = (byte) (r100 >>> 48);
        r101[2] = (byte) (r100 >>> 40);
        r101[3] = (byte) (r100 >>> 32);
        r101[4] = (byte) (r100 >>> 24);
        r101[5] = (byte) (r100 >>> 16);
        r101[6] = (byte) (r100 >>> 8);
        r101[7] = (byte) (r100 >>> 0);
    }

    private void clearBlock(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    private boolean isSameAs(byte[] r100, byte[] r101) {
        if (this.messageLength == r101.length) goto L5;
        boolean r102 = false;
    L6:
        int r103 = 0;
    L8:
        if (r103 == r101.length) goto L13;
        if (r100[r103] == r101[r103]) goto L12;
        r102 = false;
    L12:
        r103 = r103 + 1;
        goto L8
    L13:
        return r102;
    L5:
        r102 = true;
        goto L6
    }

    private byte[] maskGeneratorFunction1(byte[] r100, int r110, int r111, int r112) {
        byte[] r101 = new byte[r112];
        byte[] r102 = new byte[this.hLen];
        byte[] r103 = new byte[4];
        this.digest.reset();
        int r104 = 0;
    L3:
        int r105 = this.hLen;
        if (r104 >= (r112 / r105)) goto L7;
        ItoOSP(r104, r103);
        this.digest.update(r100, r110, r111);
        this.digest.update(r103, 0, 4);
        this.digest.doFinal(r102, 0);
        int r106 = this.hLen;
        System.arraycopy(r102, 0, r101, r104 * r106, r106);
        r104 = r104 + 1;
        goto L3
    L7:
        if ((r105 * r104) >= r112) goto L9;
        ItoOSP(r104, r103);
        this.digest.update(r100, r110, r111);
        this.digest.update(r103, 0, 4);
        this.digest.doFinal(r102, 0);
        int r107 = this.hLen;
        System.arraycopy(r102, 0, r101, r104 * r107, r112 - (r104 * r107));
    L9:
        return r101;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int r100 = this.digest.getDigestSize();
        byte[] r101 = new byte[r100];
        this.digest.doFinal(r101, 0);
        byte[] r102 = new byte[8];
        LtoOSP(this.messageLength * 8, r102);
        this.digest.update(r102, 0, 8);
        this.digest.update(this.mBuf, 0, this.messageLength);
        this.digest.update(r101, 0, r100);
        byte[] r103 = this.standardSalt;
        if (r103 != null) goto L6;
        r103 = new byte[this.saltLength];
        this.random.nextBytes(r103);
    L6:
        this.digest.update(r103, 0, r103.length);
        int r104 = this.digest.getDigestSize();
        byte[] r105 = new byte[r104];
        this.digest.doFinal(r105, 0);
        boolean r106 = true;
        if (this.trailer != 188) goto L9;
        int r107 = 1;
    L10:
        byte[] r108 = this.block;
        int r109 = r108.length;
        int r110 = this.messageLength;
        int r111 = ((((r109 - r110) - r103.length) - this.hLen) - r107) - 1;
        r108[r111] = 1;
        int r112 = r111 + 1;
        System.arraycopy(this.mBuf, 0, r108, r112, r110);
        System.arraycopy(r103, 0, this.block, r112 + this.messageLength, r103.length);
        byte[] r113 = maskGeneratorFunction1(r105, 0, r104, (this.block.length - this.hLen) - r107);
        int r114 = 0;
    L12:
        if (r114 == r113.length) goto L14;
        byte[] r115 = this.block;
        r115[r114] = (byte) (r115[r114] ^ r113[r114]);
        r114 = r114 + 1;
        goto L12
    L14:
        byte[] r116 = this.block;
        int r117 = r116.length;
        int r118 = this.hLen;
        System.arraycopy(r105, 0, r116, (r117 - r118) - r107, r118);
        int r119 = this.trailer;
        if (r119 != 188) goto L17;
        byte[] r120 = this.block;
        r120[r120.length - 1] = PSSSigner.TRAILER_IMPLICIT;
    L18:
        byte[] r121 = this.block;
        r121[0] = (byte) (r121[0] & ByteCompanionObject.MAX_VALUE);
        byte[] r122 = this.cipher.processBlock(r121, 0, r121.length);
        int r123 = this.messageLength;
        byte[] r124 = new byte[r123];
        this.recoveredMessage = r124;
        byte[] r125 = this.mBuf;
        if (r123 <= r125.length) goto L22;
        r106 = false;
    L22:
        this.fullMessage = r106;
        System.arraycopy(r125, 0, r124, 0, r124.length);
        clearBlock(this.mBuf);
        clearBlock(this.block);
        this.messageLength = 0;
        return r122;
    L17:
        byte[] r126 = this.block;
        r126[r126.length - 2] = (byte) (r119 >>> 8);
        r126[r126.length - 1] = (byte) r119;
        goto L18
    L9:
        r107 = 2;
        goto L10
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        int r102 = this.saltLength;
        if ((r101 instanceof ParametersWithRandom) == false) goto L9;
        ParametersWithRandom r103 = (ParametersWithRandom) r101;
        RSAKeyParameters r104 = (RSAKeyParameters) r103.getParameters();
        if (r100 == false) goto L18;
        SecureRandom r105 = r103.getRandom();
    L7:
        this.random = r105;
    L18:
        this.cipher.init(r100, r104);
        int r106 = r104.getModulus().bitLength();
        this.keyBits = r106;
        byte[] r107 = new byte[(r106 + 7) / 8];
        this.block = r107;
        int r108 = this.trailer;
        int r109 = r107.length;
        if (r108 != 188) goto L21;
        this.mBuf = new byte[(((r109 - this.digest.getDigestSize()) - r102) - 1) - 1];
    L22:
        reset();
        return;
    L21:
        this.mBuf = new byte[(((r109 - this.digest.getDigestSize()) - r102) - 1) - 2];
        goto L22
    L9:
        if ((r101 instanceof ParametersWithSalt) == false) goto L15;
        ParametersWithSalt r110 = (ParametersWithSalt) r101;
        r104 = (RSAKeyParameters) r110.getParameters();
        byte[] r111 = r110.getSalt();
        this.standardSalt = r111;
        r102 = r111.length;
        if (r111.length == this.saltLength) goto L18;
        throw new IllegalArgumentException("Fixed salt is of wrong length");
    L15:
        r104 = (RSAKeyParameters) r101;
        if (r100 == false) goto L18;
        r105 = CryptoServicesRegistrar.getSecureRandom();
        goto L7
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        byte[] r100 = this.mBuf;
        if (r100 == null) goto L5;
        clearBlock(r100);
    L5:
        byte[] r101 = this.recoveredMessage;
        if (r101 == null) goto L8;
        clearBlock(r101);
        this.recoveredMessage = null;
    L8:
        this.fullMessage = false;
        if (this.preSig == null) goto L12;
        this.preSig = null;
        clearBlock(this.preBlock);
        this.preBlock = null;
        return;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        if (this.preSig != null) goto L7;
        int r101 = this.messageLength;
        byte[] r102 = this.mBuf;
        if (r101 >= r102.length) goto L7;
        this.messageLength = r101 + 1;
        r102[r101] = r100;
        return;
    L7:
        this.digest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        if (this.preSig != null) goto L8;
    L4:
        if (r102 <= 0) goto L8;
        if (this.messageLength >= this.mBuf.length) goto L8;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
    L8:
        if (r102 <= 0) goto L13;
        this.digest.update(r100, r101, r102);
        return;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] r100) throws InvalidCipherTextException {
        byte[] r101 = this.cipher.processBlock(r100, 0, r100.length);
        int r102 = r101.length;
        int r103 = this.keyBits;
        if (r102 >= ((r103 + 7) / 8)) goto L5;
        int r104 = (r103 + 7) / 8;
        byte[] r105 = new byte[r104];
        System.arraycopy(r101, 0, r105, r104 - r101.length, r101.length);
        clearBlock(r101);
        r101 = r105;
    L5:
        boolean r106 = true;
        if (((r101[r101.length - 1] & UByte.MAX_VALUE) ^ 188) != 0) goto L8;
        int r107 = 1;
    L19:
        this.digest.doFinal(new byte[this.hLen], 0);
        int r108 = r101.length;
        int r109 = this.hLen;
        byte[] r110 = maskGeneratorFunction1(r101, (r108 - r109) - r107, r109, (r101.length - r109) - r107);
        int r111 = 0;
    L21:
        if (r111 == r110.length) goto L23;
        r101[r111] = (byte) (r101[r111] ^ r110[r111]);
        r111 = r111 + 1;
        goto L21
    L23:
        r101[0] = (byte) (r101[0] & ByteCompanionObject.MAX_VALUE);
        int r112 = 0;
    L25:
        if (r112 == r101.length) goto L30;
        if (r101[r112] == 1) goto L30;
        r112 = r112 + 1;
    L30:
        int r113 = r112 + 1;
        if (r113 < r101.length) goto L33;
        clearBlock(r101);
    L33:
        if (r113 > 1) goto L36;
        r106 = false;
    L36:
        this.fullMessage = r106;
        byte[] r114 = new byte[(r110.length - r113) - this.saltLength];
        this.recoveredMessage = r114;
        System.arraycopy(r101, r113, r114, 0, r114.length);
        byte[] r115 = this.recoveredMessage;
        System.arraycopy(r115, 0, this.mBuf, 0, r115.length);
        this.preSig = r100;
        this.preBlock = r101;
        this.preMStart = r113;
        this.preTLength = r107;
        return;
    L8:
        r107 = 2;
        int r116 = ((r101[r101.length - 2] & UByte.MAX_VALUE) << 8) | (r101[r101.length - 1] & UByte.MAX_VALUE);
        Integer r117 = ISOTrailers.getTrailer(this.digest);
        if (r117 == null) goto L39;
        int r118 = r117.intValue();
        if (r116 == r118) goto L19;
        if (r118 != 15052) goto L18;
        if (r116 == 16588) goto L19;
    L18:
        throw new IllegalStateException("signer initialised with wrong digest for trailer " + r116);
    L39:
        throw new IllegalArgumentException("unrecognised hash in signature");
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r110) {
        int r100 = this.hLen;
        byte[] r101 = new byte[r100];
        this.digest.doFinal(r101, 0);
        byte[] r102 = this.preSig;
        if (r102 != null) goto L8;
        updateWithRecoveredMessage(r110);     // Catch: Exception -> L6
    L9:
        byte[] r111 = this.preBlock;
        int r103 = this.preMStart;
        int r104 = this.preTLength;
        this.preSig = null;
        this.preBlock = null;
        byte[] r105 = new byte[8];
        LtoOSP(this.recoveredMessage.length * 8, r105);
        this.digest.update(r105, 0, 8);
        byte[] r106 = this.recoveredMessage;
        if (r106.length == 0) goto L12;
        this.digest.update(r106, 0, r106.length);
    L12:
        this.digest.update(r101, 0, r100);
        byte[] r107 = this.standardSalt;
        if (r107 == null) goto L15;
        this.digest.update(r107, 0, r107.length);
    L16:
        int r108 = this.digest.getDigestSize();
        byte[] r109 = new byte[r108];
        this.digest.doFinal(r109, 0);
        int r112 = (r111.length - r104) - r108;
        int r113 = 0;
        boolean r114 = true;
    L17:
        if (r113 == r108) goto L22;
        if (r109[r113] == r111[r112 + r113]) goto L21;
        r114 = false;
    L21:
        r113 = r113 + 1;
        goto L17
    L22:
        clearBlock(r111);
        clearBlock(r109);
        if (r114 == true) goto L27;
        this.fullMessage = false;
        this.messageLength = 0;
        clearBlock(this.recoveredMessage);
        return false;
    L27:
        if (this.messageLength != 0) goto L29;
    L32:
        this.messageLength = 0;
        clearBlock(this.mBuf);
        return true;
    L29:
        if (isSameAs(this.mBuf, this.recoveredMessage) == true) goto L32;
        this.messageLength = 0;
        clearBlock(this.mBuf);
        return false;
    L15:
        this.digest.update(r111, r103 + this.recoveredMessage.length, this.saltLength);
    L6:
        return false;
    L8:
        if (Arrays.areEqual(r102, r110) == true) goto L9;
        throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
    }
}
