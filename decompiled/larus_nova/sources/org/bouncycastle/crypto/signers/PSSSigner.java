package org.bouncycastle.crypto.signers;

import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSABlindingParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class PSSSigner implements Signer {
    public static final byte TRAILER_IMPLICIT = -68;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest contentDigest;
    private int emBits;
    private int hLen;
    private byte[] mDash;
    private Digest mgfDigest;
    private int mgfhLen;
    private SecureRandom random;
    private int sLen;
    private boolean sSet;
    private byte[] salt;
    private byte trailer;

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, int r102) {
        this(r100, r101, r102, TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, int r102, byte r110) {
        this(r100, r101, r101, r102, r110);
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, Digest r102, int r110) {
        this(r100, r101, r102, r110, TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, Digest r102, int r103, byte r104) {
        this.cipher = r100;
        this.contentDigest = r101;
        this.mgfDigest = r102;
        this.hLen = r101.getDigestSize();
        this.mgfhLen = r102.getDigestSize();
        this.sSet = false;
        this.sLen = r103;
        this.salt = new byte[r103];
        this.mDash = new byte[(r103 + 8) + this.hLen];
        this.trailer = r104;
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, Digest r102, byte[] r110) {
        this(r100, r101, r102, r110, TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, Digest r102, byte[] r103, byte r104) {
        this.cipher = r100;
        this.contentDigest = r101;
        this.mgfDigest = r102;
        this.hLen = r101.getDigestSize();
        this.mgfhLen = r102.getDigestSize();
        this.sSet = true;
        int r105 = r103.length;
        this.sLen = r105;
        this.salt = r103;
        this.mDash = new byte[(r105 + 8) + this.hLen];
        this.trailer = r104;
    }

    public PSSSigner(AsymmetricBlockCipher r100, Digest r101, byte[] r102) {
        this(r100, r101, r101, r102, TRAILER_IMPLICIT);
    }

    private void ItoOSP(int r100, byte[] r101) {
        r101[0] = (byte) (r100 >>> 24);
        r101[1] = (byte) (r100 >>> 16);
        r101[2] = (byte) (r100 >>> 8);
        r101[3] = (byte) (r100 >>> 0);
    }

    private void clearBlock(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 == r100.length) goto L6;
        r100[r101] = 0;
        r101 = r101 + 1;
        goto L4
    }

    private byte[] maskGeneratorFunction1(byte[] r100, int r110, int r111, int r112) {
        byte[] r101 = new byte[r112];
        byte[] r102 = new byte[this.mgfhLen];
        byte[] r103 = new byte[4];
        this.mgfDigest.reset();
        int r104 = 0;
    L3:
        int r105 = this.mgfhLen;
        if (r104 >= (r112 / r105)) goto L7;
        ItoOSP(r104, r103);
        this.mgfDigest.update(r100, r110, r111);
        this.mgfDigest.update(r103, 0, 4);
        this.mgfDigest.doFinal(r102, 0);
        int r106 = this.mgfhLen;
        System.arraycopy(r102, 0, r101, r104 * r106, r106);
        r104 = r104 + 1;
        goto L3
    L7:
        if ((r105 * r104) >= r112) goto L9;
        ItoOSP(r104, r103);
        this.mgfDigest.update(r100, r110, r111);
        this.mgfDigest.update(r103, 0, 4);
        this.mgfDigest.doFinal(r102, 0);
        int r107 = this.mgfhLen;
        System.arraycopy(r102, 0, r101, r104 * r107, r112 - (r104 * r107));
    L9:
        return r101;
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException, DataLengthException {
        Digest r100 = this.contentDigest;
        byte[] r101 = this.mDash;
        r100.doFinal(r101, (r101.length - this.hLen) - this.sLen);
        if (this.sLen != 0) goto L5;
    L8:
        int r102 = this.hLen;
        byte[] r103 = new byte[r102];
        Digest r104 = this.contentDigest;
        byte[] r105 = this.mDash;
        r104.update(r105, 0, r105.length);
        this.contentDigest.doFinal(r103, 0);
        byte[] r106 = this.block;
        int r107 = r106.length;
        int r108 = this.sLen;
        int r109 = this.hLen;
        r106[(((r107 - r108) - 1) - r109) - 1] = 1;
        System.arraycopy(this.salt, 0, r106, ((r106.length - r108) - r109) - 1, r108);
        byte[] r110 = maskGeneratorFunction1(r103, 0, r102, (this.block.length - this.hLen) - 1);
        int r111 = 0;
    L10:
        if (r111 == r110.length) goto L12;
        byte[] r112 = this.block;
        r112[r111] = (byte) (r112[r111] ^ r110[r111]);
        r111 = r111 + 1;
        goto L10
    L12:
        byte[] r113 = this.block;
        int r114 = r113.length;
        int r115 = this.hLen;
        System.arraycopy(r103, 0, r113, (r114 - r115) - 1, r115);
        byte[] r116 = this.block;
        r116[0] = (byte) ((255 >>> ((r116.length * 8) - this.emBits)) & r116[0]);
        r116[r116.length - 1] = this.trailer;
        byte[] r117 = this.cipher.processBlock(r116, 0, r116.length);
        clearBlock(this.block);
        return r117;
    L5:
        if (this.sSet == true) goto L7;
        this.random.nextBytes(this.salt);
    L7:
        byte[] r118 = this.salt;
        byte[] r119 = this.mDash;
        int r120 = r119.length;
        int r121 = this.sLen;
        System.arraycopy(r118, 0, r119, r120 - r121, r121);
        goto L8
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        ParametersWithRandom r102 = (ParametersWithRandom) r101;
        CipherParameters r103 = r102.getParameters();
        this.random = r102.getRandom();
    L9:
        if ((r103 instanceof RSABlindingParameters) == false) goto L11;
        RSAKeyParameters r104 = ((RSABlindingParameters) r103).getPublicKey();
        this.cipher.init(r100, r101);
    L12:
        int r105 = r104.getModulus().bitLength() - 1;
        this.emBits = r105;
        if (r105 < (((this.hLen * 8) + (this.sLen * 8)) + 9)) goto L17;
        this.block = new byte[(r105 + 7) / 8];
        reset();
        return;
    L17:
        throw new IllegalArgumentException("key too small for specified hash and salt lengths");
    L11:
        r104 = (RSAKeyParameters) r103;
        this.cipher.init(r100, r103);
        goto L12
    L5:
        if (r100 == false) goto L7;
        this.random = CryptoServicesRegistrar.getSecureRandom();
    L7:
        r103 = r101;
        goto L9
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.contentDigest.reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte r100) {
        this.contentDigest.update(r100);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] r100, int r101, int r102) {
        this.contentDigest.update(r100, r101, r102);
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] r100) {
        Digest r101 = this.contentDigest;
        byte[] r102 = this.mDash;
        r101.doFinal(r102, (r102.length - this.hLen) - this.sLen);
        byte[] r103 = this.cipher.processBlock(r100, 0, r100.length);     // Catch: Exception -> L41
        byte[] r104 = this.block;     // Catch: Exception -> L41
        Arrays.fill(r104, 0, r104.length - r103.length, (byte) 0);     // Catch: Exception -> L41
        byte[] r105 = this.block;     // Catch: Exception -> L41
        System.arraycopy(r103, 0, r105, r105.length - r103.length, r103.length);     // Catch: Exception -> L41
        byte[] r106 = this.block;
        int r107 = 255 >>> ((r106.length * 8) - this.emBits);
        byte r108 = r106[0];
        if ((r108 & UByte.MAX_VALUE) == (r108 & r107)) goto L7;
    L39:
        clearBlock(r106);
        goto L40
    L7:
        if (r106[r106.length - 1] != this.trailer) goto L39;
        int r109 = r106.length;
        int r110 = this.hLen;
        byte[] r111 = maskGeneratorFunction1(r106, (r109 - r110) - 1, r110, (r106.length - r110) - 1);
        int r112 = 0;
    L11:
        if (r112 == r111.length) goto L13;
        byte[] r113 = this.block;
        r113[r112] = (byte) (r113[r112] ^ r111[r112]);
        r112 = r112 + 1;
        goto L11
    L13:
        byte[] r114 = this.block;
        r114[0] = (byte) (r107 & r114[0]);
        int r115 = 0;
    L14:
        byte[] r116 = this.block;
        int r117 = r116.length;
        int r118 = this.hLen;
        int r119 = this.sLen;
        if (r115 == (((r117 - r118) - r119) - 2)) goto L22;
        if (r116[r115] != 0) goto L18;
        r115 = r115 + 1;
        goto L14
    L18:
        clearBlock(r116);
        return false;
    L22:
        if (r116[((r116.length - r118) - r119) - 2] == 1) goto L26;
        clearBlock(r116);
        return false;
    L26:
        if (this.sSet == false) goto L28;
        byte[] r120 = this.salt;
        byte[] r121 = this.mDash;
        System.arraycopy(r120, 0, r121, r121.length - r119, r119);
    L29:
        Digest r122 = this.contentDigest;
        byte[] r123 = this.mDash;
        r122.update(r123, 0, r123.length);
        Digest r124 = this.contentDigest;
        byte[] r125 = this.mDash;
        r124.doFinal(r125, r125.length - this.hLen);
        int r126 = this.block.length;
        int r127 = this.hLen;
        int r128 = (r126 - r127) - 1;
        int r129 = this.mDash.length - r127;
    L30:
        byte[] r130 = this.mDash;
        if (r129 == r130.length) goto L37;
        if ((this.block[r128] ^ r130[r129]) != 0) goto L34;
        r128 = r128 + 1;
        r129 = r129 + 1;
        goto L30
    L34:
        clearBlock(r130);
        clearBlock(this.block);
        return false;
    L37:
        clearBlock(r130);
        clearBlock(this.block);
        return true;
    L28:
        int r131 = ((r116.length - r119) - r118) - 1;
        byte[] r132 = this.mDash;
        System.arraycopy(r116, r131, r132, r132.length - r119, r119);
    L40:
        return false;
    }
}
