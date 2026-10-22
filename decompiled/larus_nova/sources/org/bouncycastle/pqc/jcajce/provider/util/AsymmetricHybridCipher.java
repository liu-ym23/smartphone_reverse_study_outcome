package org.bouncycastle.pqc.jcajce.provider.util;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.ShortBufferException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AsymmetricHybridCipher extends CipherSpiExt {
    protected AlgorithmParameterSpec paramSpec;

    public AsymmetricHybridCipher() {
    }

    public abstract int decryptOutputSize(int r100);

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int doFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException, BadPaddingException {
        if (r103.length < getOutputSize(r102)) goto L7;
        byte[] r105 = doFinal(r100, r101, r102);
        System.arraycopy(r105, 0, r103, r104, r105.length);
        return r105.length;
    L7:
        throw new ShortBufferException("Output buffer too short.");
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public abstract byte[] doFinal(byte[] r100, int r101, int r102) throws BadPaddingException;

    public abstract int encryptOutputSize(int r100);

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final byte[] getIV() {
        return null;
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int getOutputSize(int r100) {
        if (this.opMode != 1) goto L6;
        return encryptOutputSize(r100);
    L6:
        return decryptOutputSize(r100);
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

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void setMode(String r100) {
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final void setPadding(String r100) {
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public final int update(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException {
        if (r103.length < getOutputSize(r102)) goto L7;
        byte[] r105 = update(r100, r101, r102);
        System.arraycopy(r105, 0, r103, r104, r105.length);
        return r105.length;
    L7:
        throw new ShortBufferException(BdpAppEventConstant.PARAMS_OUTPUT);
    }

    @Override // org.bouncycastle.pqc.jcajce.provider.util.CipherSpiExt
    public abstract byte[] update(byte[] r100, int r101, int r102);
}
