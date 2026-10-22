package org.bouncycastle.crypto.signers;

import kotlin.UByte;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SignerWithRecovery;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class ISO9796d2Signer implements SignerWithRecovery {
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
    private int keyBits;
    private byte[] mBuf;
    private int messageLength;
    private byte[] preBlock;
    private byte[] preSig;
    private byte[] recoveredMessage;
    private int trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher r100, Digest r101) {
        this(r100, r101, false);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher r100, Digest r101, boolean r102) {
        this.cipher = r100;
        this.digest = r101;
        if (r102 == false) goto L6;
        int r103 = 188;
    L5:
        this.trailer = r103;
        return;
    L6:
        Integer r104 = ISOTrailers.getTrailer(r101);
        if (r104 == null) goto L11;
        r103 = r104.intValue();
        goto L5
    L11:
        throw new IllegalArgumentException("no valid trailer for digest: " + r101.getAlgorithmName());
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
        int r102 = this.messageLength;
        byte[] r103 = this.mBuf;
        boolean r104 = true;
        if (r102 <= r103.length) goto L15;
        if (r103.length <= r101.length) goto L7;
        r104 = false;
    L7:
        int r105 = 0;
    L9:
        if (r105 == this.mBuf.length) goto L24;
        if (r100[r105] == r101[r105]) goto L13;
        r104 = false;
    L13:
        r105 = r105 + 1;
    L24:
        return r104;
    L15:
        if (r102 == r101.length) goto L17;
        r104 = false;
    L17:
        int r106 = 0;
    L19:
        if (r106 == r101.length) goto L24;
        if (r100[r106] == r101[r106]) goto L23;
        r104 = false;
    L23:
        r106 = r106 + 1;
        goto L19
    }

    private boolean returnFalse(byte[] r100) {
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(r100);
        return false;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        int r100 = this.digest.getDigestSize();
        boolean r101 = true;
        if (this.trailer != 188) goto L5;
        byte[] r102 = this.block;
        int r103 = (r102.length - r100) - 1;
        this.digest.doFinal(r102, r103);
        byte[] r104 = this.block;
        r104[r104.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        int r105 = 8;
    L6:
        int r106 = this.messageLength;
        int r107 = ((((r100 + r106) * 8) + r105) + 4) - this.keyBits;
        if (r107 <= 0) goto L9;
        int r108 = r106 - ((r107 + 7) / 8);
        int r109 = r103 - r108;
        System.arraycopy(this.mBuf, 0, this.block, r109, r108);
        this.recoveredMessage = new byte[r108];
        int r110 = 96;
    L10:
        int r111 = r109 - 1;
        if (r111 <= 0) goto L16;
        int r112 = r111;
    L13:
        if (r112 == 0) goto L15;
        this.block[r112] = -69;
        r112 = r112 - 1;
        goto L13
    L15:
        byte[] r113 = this.block;
        r113[r111] = (byte) (r113[r111] ^ 1);
        r113[0] = 11;
        r113[0] = (byte) (11 | r110);
    L17:
        AsymmetricBlockCipher r114 = this.cipher;
        byte[] r115 = this.block;
        byte[] r116 = r114.processBlock(r115, 0, r115.length);
        if ((r110 & 32) == 0) goto L21;
        r101 = false;
    L21:
        this.fullMessage = r101;
        byte[] r117 = this.mBuf;
        byte[] r118 = this.recoveredMessage;
        System.arraycopy(r117, 0, r118, 0, r118.length);
        this.messageLength = 0;
        clearBlock(this.mBuf);
        clearBlock(this.block);
        return r116;
    L16:
        byte[] r119 = this.block;
        r119[0] = 10;
        r119[0] = (byte) (10 | r110);
        goto L17
    L9:
        r109 = r103 - r106;
        System.arraycopy(this.mBuf, 0, this.block, r109, r106);
        this.recoveredMessage = new byte[this.messageLength];
        r110 = 64;
        goto L10
    L5:
        byte[] r120 = this.block;
        r103 = (r120.length - r100) - 2;
        this.digest.doFinal(r120, r103);
        byte[] r121 = this.block;
        int r122 = r121.length - 2;
        int r123 = this.trailer;
        r121[r122] = (byte) (r123 >>> 8);
        r121[r121.length - 1] = (byte) r123;
        r105 = 16;
        goto L6
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
        RSAKeyParameters r102 = (RSAKeyParameters) r101;
        this.cipher.init(r100, r102);
        int r103 = r102.getModulus().bitLength();
        this.keyBits = r103;
        byte[] r104 = new byte[(r103 + 7) / 8];
        this.block = r104;
        int r105 = this.trailer;
        int r106 = r104.length;
        if (r105 != 188) goto L5;
        this.mBuf = new byte[(r106 - this.digest.getDigestSize()) - 2];
    L6:
        reset();
        return;
    L5:
        this.mBuf = new byte[(r106 - this.digest.getDigestSize()) - 3];
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
        this.messageLength = 0;
        clearBlock(this.mBuf);
        byte[] r100 = this.recoveredMessage;
        if (r100 == null) goto L5;
        clearBlock(r100);
    L5:
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.preSig == null) goto L9;
        this.preSig = null;
        clearBlock(this.preBlock);
        this.preBlock = null;
        return;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.digest.update(r100);
        int r101 = this.messageLength;
        byte[] r102 = this.mBuf;
        if (r101 >= r102.length) goto L5;
        r102[r101] = r100;
    L5:
        this.messageLength = r101 + 1;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
    L2:
        if (r102 <= 0) goto L6;
        if (this.messageLength >= this.mBuf.length) goto L6;
        update(r100[r101]);
        r101 = r101 + 1;
        r102 = r102 - 1;
    L6:
        this.digest.update(r100, r101, r102);
        this.messageLength += r102;
    }

    @Override // org.bouncycastle.crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] r100) throws InvalidCipherTextException {
        byte[] r101 = this.cipher.processBlock(r100, 0, r100.length);
        if (((r101[0] & 192) ^ 64) != 0) goto L42;
        if (((r101[r101.length - 1] & 15) ^ 12) != 0) goto L40;
        if (((r101[r101.length - 1] & UByte.MAX_VALUE) ^ 188) != 0) goto L9;
        int r102 = 1;
    L20:
        int r103 = 0;
    L22:
        if (r103 == r101.length) goto L27;
        if (((r101[r103] & 15) ^ 10) == 0) goto L27;
        r103 = r103 + 1;
    L27:
        int r104 = r103 + 1;
        int r105 = ((r101.length - r102) - this.digest.getDigestSize()) - r104;
        if (r105 <= 0) goto L36;
        if ((r101[0] & 32) != 0) goto L32;
        this.fullMessage = true;
        byte[] r106 = new byte[r105];
        this.recoveredMessage = r106;
        System.arraycopy(r101, r104, r106, 0, r106.length);
    L33:
        this.preSig = r100;
        this.preBlock = r101;
        Digest r107 = this.digest;
        byte[] r108 = this.recoveredMessage;
        r107.update(r108, 0, r108.length);
        byte[] r109 = this.recoveredMessage;
        this.messageLength = r109.length;
        System.arraycopy(r109, 0, this.mBuf, 0, r109.length);
        return;
    L32:
        this.fullMessage = false;
        byte[] r110 = new byte[r105];
        this.recoveredMessage = r110;
        System.arraycopy(r101, r104, r110, 0, r110.length);
        goto L33
    L36:
        throw new InvalidCipherTextException("malformed block");
    L9:
        r102 = 2;
        int r111 = ((r101[r101.length - 2] & UByte.MAX_VALUE) << 8) | (r101[r101.length - 1] & UByte.MAX_VALUE);
        Integer r112 = ISOTrailers.getTrailer(this.digest);
        if (r112 == null) goto L38;
        int r113 = r112.intValue();
        if (r111 == r113) goto L20;
        if (r113 != 15052) goto L19;
        if (r111 == 16588) goto L20;
    L19:
        throw new IllegalStateException("signer initialised with wrong digest for trailer " + r111);
    L38:
        throw new IllegalArgumentException("unrecognised hash in signature");
    L40:
        throw new InvalidCipherTextException("malformed signature");
    L42:
        throw new InvalidCipherTextException("malformed signature");
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r110) {
        byte[] r100 = this.preSig;
        if (r100 != null) goto L8;
        byte[] r111 = this.cipher.processBlock(r110, 0, r110.length);     // Catch: Exception -> L6
    L11:
        if (((r111[0] & 192) ^ 64) == 0) goto L15;
        return returnFalse(r111);
    L15:
        if (((r111[r111.length - 1] & 15) ^ 12) == 0) goto L19;
        return returnFalse(r111);
    L19:
        if (((r111[r111.length - 1] & UByte.MAX_VALUE) ^ 188) != 0) goto L21;
        int r101 = 1;
    L32:
        int r102 = 0;
    L34:
        if (r102 == r111.length) goto L39;
        if (((r111[r102] & 15) ^ 10) == 0) goto L39;
        r102 = r102 + 1;
    L39:
        int r103 = r102 + 1;
        int r104 = this.digest.getDigestSize();
        byte[] r105 = new byte[r104];
        int r106 = (r111.length - r101) - r104;
        int r107 = r106 - r103;
        if (r107 > 0) goto L44;
        return returnFalse(r111);
    L44:
        if ((r111[0] & 32) != 0) goto L59;
        this.fullMessage = true;
        if (this.messageLength > r107) goto L48;
        this.digest.reset();
        this.digest.update(r111, r103, r107);
        this.digest.doFinal(r105, 0);
        int r108 = 0;
        boolean r109 = true;
    L50:
        if (r108 == r104) goto L55;
        int r112 = r106 + r108;
        byte r113 = (byte) (r111[r112] ^ r105[r108]);
        r111[r112] = r113;
        if (r113 == 0) goto L54;
        r109 = false;
    L54:
        r108 = r108 + 1;
        goto L50
    L55:
        if (r109 == false) goto L57;
        byte[] r114 = new byte[r107];
        this.recoveredMessage = r114;
        System.arraycopy(r111, r103, r114, 0, r114.length);
    L70:
        if (this.messageLength != 0) goto L72;
    L75:
        clearBlock(this.mBuf);
        clearBlock(r111);
        this.messageLength = 0;
        return true;
    L72:
        if (isSameAs(this.mBuf, this.recoveredMessage) == true) goto L75;
        return returnFalse(r111);
    L57:
        return returnFalse(r111);
    L48:
        return returnFalse(r111);
    L59:
        this.fullMessage = false;
        this.digest.doFinal(r105, 0);
        int r115 = 0;
        boolean r116 = true;
    L60:
        if (r115 == r104) goto L65;
        int r117 = r106 + r115;
        byte r118 = (byte) (r111[r117] ^ r105[r115]);
        r111[r117] = r118;
        if (r118 == 0) goto L64;
        r116 = false;
    L64:
        r115 = r115 + 1;
        goto L60
    L65:
        if (r116 == false) goto L67;
        byte[] r119 = new byte[r107];
        this.recoveredMessage = r119;
        System.arraycopy(r111, r103, r119, 0, r119.length);
        goto L70
    L67:
        return returnFalse(r111);
    L21:
        r101 = 2;
        int r120 = ((r111[r111.length - 2] & UByte.MAX_VALUE) << 8) | (r111[r111.length - 1] & UByte.MAX_VALUE);
        Integer r121 = ISOTrailers.getTrailer(this.digest);
        if (r121 == null) goto L78;
        int r122 = r121.intValue();
        if (r120 == r122) goto L32;
        if (r122 != 15052) goto L31;
        if (r120 == 16588) goto L32;
    L31:
        throw new IllegalStateException("signer initialised with wrong digest for trailer " + r120);
    L78:
        throw new IllegalArgumentException("unrecognised hash in signature");
    L6:
        return false;
    L8:
        if (Arrays.areEqual(r100, r110) == false) goto L80;
        r111 = this.preBlock;
        this.preSig = null;
        this.preBlock = null;
        goto L11
    L80:
        throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
    }
}
