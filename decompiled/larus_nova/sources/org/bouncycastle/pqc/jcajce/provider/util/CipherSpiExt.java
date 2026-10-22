package org.bouncycastle.pqc.jcajce.provider.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class CipherSpiExt extends CipherSpi {
    public static final int DECRYPT_MODE = 2;
    public static final int ENCRYPT_MODE = 1;
    protected int opMode;

    public CipherSpiExt() {
    }

    public abstract int doFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException;

    public final byte[] doFinal() throws IllegalBlockSizeException, BadPaddingException {
        return doFinal(null, 0, 0);
    }

    public final byte[] doFinal(byte[] r100) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal(r100, 0, r100.length);
    }

    public abstract byte[] doFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException;

    @Override // javax.crypto.CipherSpi
    public final int engineDoFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        return doFinal(r100, r101, r102, r103, r104);
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineDoFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException {
        return doFinal(r100, r101, r102);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetBlockSize() {
        return getBlockSize();
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineGetIV() {
        return getIV();
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetKeySize(Key r100) throws InvalidKeyException {
        if ((r100 instanceof Key) == false) goto L7;
        return getKeySize(r100);
    L7:
        throw new InvalidKeyException("Unsupported key.");
    }

    @Override // javax.crypto.CipherSpi
    public final int engineGetOutputSize(int r100) {
        return getOutputSize(r100);
    }

    @Override // javax.crypto.CipherSpi
    public final AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int r100, Key r101, AlgorithmParameters r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r102 != null) goto L5;
        engineInit(r100, r101, r103);
        return;
    L5:
        engineInit(r100, r101, null, r103);
    }

    @Override // javax.crypto.CipherSpi
    public final void engineInit(int r100, Key r101, SecureRandom r102) throws InvalidKeyException {
        engineInit(r100, r101, null, r102);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidParameterException(e.getMessage());
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameterSpec r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r101 == null) goto L13;
        if ((r101 instanceof Key) == false) goto L13;
        this.opMode = r100;
        if (r100 != 1) goto L9;
        initEncrypt(r101, r102, r103);
        return;
    L9:
        if (r100 != 2) goto L15;
        initDecrypt(r101, r102);
        return;
    L15:
        return;
    L13:
        throw new InvalidKeyException();
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetMode(String r100) throws NoSuchAlgorithmException {
        setMode(r100);
    }

    @Override // javax.crypto.CipherSpi
    public final void engineSetPadding(String r100) throws NoSuchPaddingException {
        setPadding(r100);
    }

    @Override // javax.crypto.CipherSpi
    public final int engineUpdate(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException {
        return update(r100, r101, r102, r103, r104);
    }

    @Override // javax.crypto.CipherSpi
    public final byte[] engineUpdate(byte[] r100, int r101, int r102) {
        return update(r100, r101, r102);
    }

    public abstract int getBlockSize();

    public abstract byte[] getIV();

    public abstract int getKeySize(Key r100) throws InvalidKeyException;

    public abstract String getName();

    public abstract int getOutputSize(int r100);

    public abstract AlgorithmParameterSpec getParameters();

    public abstract void initDecrypt(Key r100, AlgorithmParameterSpec r101) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void initEncrypt(Key r100, AlgorithmParameterSpec r101, SecureRandom r102) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public abstract void setMode(String r100) throws NoSuchAlgorithmException;

    public abstract void setPadding(String r100) throws NoSuchPaddingException;

    public abstract int update(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException;

    public final byte[] update(byte[] r100) {
        return update(r100, 0, r100.length);
    }

    public abstract byte[] update(byte[] r100, int r101, int r102);
}
