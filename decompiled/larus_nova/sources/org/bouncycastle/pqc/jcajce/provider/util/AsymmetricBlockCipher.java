package org.bouncycastle.pqc.jcajce.provider.util;

import java.io.ByteArrayOutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AsymmetricBlockCipher extends CipherSpiExt {
    protected ByteArrayOutputStream buf;
    protected int cipherTextSize;
    protected int maxPlainTextSize;
    protected AlgorithmParameterSpec paramSpec;

    public AsymmetricBlockCipher() {
        this.buf = new ByteArrayOutputStream();
    }

    public void checkLength(int r100) throws IllegalBlockSizeException {
        int r101 = r100 + this.buf.size();
        int r102 = this.opMode;
        if (r102 != 1) goto L10;
        if (r101 > this.maxPlainTextSize) goto L8;
        return;
    L8:
        throw new IllegalBlockSizeException("The length of the plaintext (" + r101 + " bytes) is not supported by the cipher (max. " + this.maxPlainTextSize + " bytes).");
    L10:
        if (r102 == 2) goto L12;
        return;
    L12:
        if (r101 != this.cipherTextSize) goto L15;
        return;
    L15:
        throw new IllegalBlockSizeException("Illegal ciphertext length (expected " + this.cipherTextSize + " bytes, was " + r101 + " bytes).");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int doFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        if (r103.length < getOutputSize(r102)) goto L7;
        byte[] r105 = doFinal(r100, r101, r102);
        System.arraycopy(r105, 0, r103, r104, r105.length);
        return r105.length;
    L7:
        throw new ShortBufferException("Output buffer too short.");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] doFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException {
        checkLength(r102);
        update(r100, r101, r102);
        byte[] r103 = this.buf.toByteArray();
        this.buf.reset();
        int r104 = this.opMode;
        if (r104 == 1) goto L11;
        if (r104 == 2) goto L9;
        return null;
    L9:
        return messageDecrypt(r103);
    L11:
        return messageEncrypt(r103);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getBlockSize() {
        if (this.opMode != 1) goto L6;
        return this.maxPlainTextSize;
    L6:
        return this.cipherTextSize;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] getIV() {
        return null;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getOutputSize(int r100) {
        if ((r100 + this.buf.size()) <= getBlockSize()) goto L7;
        return 0;
    L7:
        if (this.opMode != 1) goto L10;
        return this.cipherTextSize;
    L10:
        return this.maxPlainTextSize;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final AlgorithmParameterSpec getParameters() {
        return this.paramSpec;
    }

    public abstract void initCipherDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void initCipherEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public final void initDecrypt(Key r100) throws InvalidKeyException {
        initDecrypt(r100, null);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L6:
        throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void initDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 2;
        initCipherDecrypt(r100, r101);
    }

    public final void initEncrypt(Key r100) throws InvalidKeyException {
        initEncrypt(r100, null, CryptoServicesRegistrar.getSecureRandom());     // Catch: InvalidAlgorithmParameterException -> L4
        return;
    L5:
        throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
    }

    public final void initEncrypt(Key r100, SecureRandom r101) throws InvalidKeyException {
        initEncrypt(r100, null, r101);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L6:
        throw new InvalidParameterException("This cipher needs algorithm parameters for initialization (cannot be null).");
    }

    public final void initEncrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException {
        initEncrypt(r100, r101, CryptoServicesRegistrar.getSecureRandom());
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void initEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException {
        this.opMode = 1;
        initCipherEncrypt(r100, r101, r102);
    }

    public abstract byte[] messageDecrypt(byte[] r100) throws IllegalBlockSizeException, BadPaddingException;

    public abstract byte[] messageEncrypt(byte[] r100) throws IllegalBlockSizeException, BadPaddingException;

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void setMode(String r100) {
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void setPadding(String r100) {
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int update(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        update(r100, r101, r102);
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] update(byte[] r100, int r101, int r102) {
        if (r102 == 0) goto L5;
        this.buf.write(r100, r101, r102);
    L5:
        return new byte[0];
    }
}
