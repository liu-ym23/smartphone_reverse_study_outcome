package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class X931Signer implements Signer {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;
    private byte[] block;
    private AsymmetricBlockCipher cipher;
    private Digest digest;
    private RSAKeyParameters kParam;
    private int keyBits;
    private int trailer;

    public X931Signer(AsymmetricBlockCipher r100, Digest r101) {
        this(r100, r101, false);
    }

    public X931Signer(AsymmetricBlockCipher r100, Digest r101, boolean r102) {
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

    private void createSignatureBlock(int r100) {
        int r101 = this.digest.getDigestSize();
        if (r100 != 188) goto L5;
        byte[] r102 = this.block;
        int r103 = (r102.length - r101) - 1;
        this.digest.doFinal(r102, r103);
        byte[] r104 = this.block;
        r104[r104.length - 1] = PSSSigner.TRAILER_IMPLICIT;
    L6:
        this.block[0] = 107;
        int r105 = r103 - 2;
    L7:
        if (r105 == 0) goto L9;
        this.block[r105] = -69;
        r105 = r105 - 1;
        goto L7
    L9:
        this.block[r103 - 1] = -70;
        return;
    L5:
        byte[] r106 = this.block;
        int r107 = (r106.length - r101) - 2;
        this.digest.doFinal(r106, r107);
        byte[] r108 = this.block;
        r108[r108.length - 2] = (byte) (r100 >>> 8);
        r108[r108.length - 1] = (byte) r100;
        r103 = r107;
        goto L6
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() throws CryptoException {
        createSignatureBlock(this.trailer);
        AsymmetricBlockCipher r100 = this.cipher;
        byte[] r101 = this.block;
        BigInteger r102 = new BigInteger(1, r100.processBlock(r101, 0, r101.length));
        clearBlock(this.block);
        BigInteger r103 = r102.min(this.kParam.getModulus().subtract(r102));
        return BigIntegers.asUnsignedByteArray(BigIntegers.getUnsignedByteLength(this.kParam.getModulus()), r103);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean r100, CipherParameters r101) {
        RSAKeyParameters r102 = (RSAKeyParameters) r101;
        this.kParam = r102;
        this.cipher.init(r100, r102);
        int r103 = this.kParam.getModulus().bitLength();
        this.keyBits = r103;
        this.block = new byte[(r103 + 7) / 8];
        reset();
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        this.digest.reset();
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
        boolean r101 = false;
        this.block = this.cipher.processBlock(r100, 0, r100.length);     // Catch: Exception -> L15
        BigInteger r102 = new BigInteger(1, this.block);
        if ((r102.intValue() & 15) == 12) goto L9;
        r102 = this.kParam.getModulus().subtract(r102);
        if ((r102.intValue() & 15) != 12) goto L14;
    L9:
        createSignatureBlock(this.trailer);
        byte[] r103 = BigIntegers.asUnsignedByteArray(this.block.length, r102);
        r101 = Arrays.constantTimeAreEqual(this.block, r103);
        if (this.trailer != 15052) goto L13;
        if (r101 == true) goto L13;
        byte[] r104 = this.block;
        r104[r104.length - 2] = 64;
        r101 = Arrays.constantTimeAreEqual(r104, r103);
    L13:
        clearBlock(this.block);
        clearBlock(r103);
    L14:
        return r101;
    }
}
