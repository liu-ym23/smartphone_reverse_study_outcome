package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseCipherSpi extends CipherSpi {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private final JcaJceHelper helper;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525369iv;
    private int ivSize;
    protected Wrapper wrapEngine;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        public ErasableOutputStream() {
        }

        public void erase() {
            Arrays.fill(((ByteArrayOutputStream) this).buf, (byte) 0);
            reset();
        }

        public byte[] getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public BaseCipherSpi() {
        this.availableSpecs = new Class[]{IvParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class};
        this.helper = new BCJcaJceHelper();
        this.engineParams = null;
        this.wrapEngine = null;
    }

    public final AlgorithmParameters createParametersInstance(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(r100);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        return r100.getEncoded().length;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String r100) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + r100);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + r100 + " unknown.");
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] r100, String r101, int r102) throws InvalidKeyException {
        Wrapper r103 = this.wrapEngine;     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
        if (r103 != null) goto L6;
        byte[] r104 = engineDoFinal(r100, 0, r100.length);     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
    L8:
        if (r102 != 3) goto L12;
        return new SecretKeySpec(r104, r101);
    L12:
        if (r101.equals("") == false) goto L50;
        if (r102 != 2) goto L50;
        PrivateKeyInfo r105 = PrivateKeyInfo.getInstance(r104);     // Catch: Exception -> L19
        PrivateKey r106 = BouncyCastleProvider.getPrivateKey(r105);     // Catch: Exception -> L19
        if (r106 == null) goto L18;
        return r106;
    L18:
        throw new InvalidKeyException("algorithm " + r105.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");     // Catch: Exception -> L19
    L20:
        throw new InvalidKeyException("Invalid key encoding.");
    L50:
        KeyFactory r107 = this.helper.createKeyFactory(r101);     // Catch: NoSuchProviderException -> L30 InvalidKeySpecException -> L33 NoSuchAlgorithmException -> L36
        if (r102 == 1) goto L24;
        if (r102 != 2) goto L29;
        return r107.generatePrivate(new PKCS8EncodedKeySpec(r104));
    L29:
        throw new InvalidKeyException("Unknown key type " + r102);
    L24:
        return r107.generatePublic(new X509EncodedKeySpec(r104));
    L36:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L30:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L33:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L6:
        r104 = r103.unwrap(r100, 0, r100.length);     // Catch: IllegalBlockSizeException -> L39 BadPaddingException -> L42 InvalidCipherTextException -> L45
    L42:
        e = move-exception;
        final String r108 = "unable to unwrap";
        throw new AnonymousClass1(this, r108, e);
    L39:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L45:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key r100) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] r101 = r100.getEncoded();
        if (r101 == null) goto L14;
        Wrapper r102 = this.wrapEngine;     // Catch: BadPaddingException -> L10
        if (r102 != null) goto L9;
        return engineDoFinal(r101, 0, r101.length);
    L9:
        return r102.wrap(r101, 0, r101.length);
    L10:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());
    L14:
        throw new InvalidKeyException("Cannot wrap key, null encoding.");
    }
}
