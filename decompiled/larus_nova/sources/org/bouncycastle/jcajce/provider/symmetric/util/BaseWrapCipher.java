package org.bouncycastle.jcajce.provider.symmetric.util;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.jcajce.spec.GOST28147WrapParameterSpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private boolean forWrapping;
    private final JcaJceHelper helper;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525381iv;
    private int ivSize;
    protected int pbeHash;
    protected int pbeIvSize;
    protected int pbeKeySize;
    protected int pbeType;
    protected Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

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

    public static class InvalidKeyOrParametersException extends InvalidKeyException {
        private final Throwable cause;

        public InvalidKeyOrParametersException(String r100, Throwable r101) {
            super(r100);
            this.cause = r101;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public BaseWrapCipher() {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
    }

    public BaseWrapCipher(Wrapper r100) {
        this(r100, 0);
    }

    public BaseWrapCipher(Wrapper r100, int r101) {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.pbeType = 2;
        this.pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.helper = new BCJcaJceHelper();
        this.wrapEngine = r100;
        this.ivSize = r101;
    }

    public final AlgorithmParameters createParametersInstance(String r100) throws NoSuchAlgorithmException, NoSuchProviderException {
        return this.helper.createAlgorithmParameters(r100);
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        ErasableOutputStream r105 = this.wrapStream;
        if (r105 == null) goto L28;
        r105.write(r100, r101, r102);
    L24:
        th = move-exception;
        this.wrapStream.erase();
        throw th;
    L7:
        if (this.forWrapping == false) goto L31;
        byte[] r106 = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: Exception -> L10 Throwable -> L24
    L15:
        if ((r106.length + r104) > r103.length) goto L20;
        System.arraycopy(r106, 0, r103, r104, r106.length);     // Catch: Throwable -> L24
        int r107 = r106.length;     // Catch: Throwable -> L24
        this.wrapStream.erase();
        return r107;
    L20:
        throw new ShortBufferException("output buffer too short for input.");     // Catch: Throwable -> L24
    L10:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());     // Catch: Throwable -> L24
    L31:
        r106 = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: InvalidCipherTextException -> L21 Throwable -> L24
    L21:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());     // Catch: Throwable -> L24
    L28:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException {
        ErasableOutputStream r103 = this.wrapStream;
        if (r103 == null) goto L24;
        if (r100 == null) goto L29;
        r103.write(r100, r101, r102);
    L29:
    L20:
        th = move-exception;
        this.wrapStream.erase();
        throw th;
    L8:
        if (this.forWrapping == false) goto L27;
        byte[] r104 = this.wrapEngine.wrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: Exception -> L12 Throwable -> L20
    L10:
        this.wrapStream.erase();
        return r104;
    L12:
        e = move-exception;
        throw new IllegalBlockSizeException(e.getMessage());     // Catch: Throwable -> L20
    L27:
        r104 = this.wrapEngine.unwrap(this.wrapStream.getBuf(), 0, this.wrapStream.size());     // Catch: InvalidCipherTextException -> L17 Throwable -> L20
    L17:
        e = move-exception;
        throw new BadPaddingException(e.getMessage());     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return Arrays.clone(this.f525381iv);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        return r100.getEncoded().length * 8;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L15;
        if (this.f525381iv == null) goto L15;
        String r100 = this.wrapEngine.getAlgorithmName();
        if (r100.indexOf(47) < 0) goto L16;
        r100 = r100.substring(0, r100.indexOf(47));
    L16:
        AlgorithmParameters r101 = createParametersInstance(r100);     // Catch: Exception -> L11
        this.engineParams = r101;     // Catch: Exception -> L11
        r101.init(new IvParameterSpec(this.f525381iv));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L15:
        return this.engineParams;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameters r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r102 == null) goto L8;
        AlgorithmParameterSpec r104 = SpecUtil.extractSpec(r102, this.availableSpecs);
        if (r104 == null) goto L7;
    L9:
        this.engineParams = r102;
        engineInit(r100, r101, r104, r103);
        return;
    L7:
        throw new InvalidAlgorithmParameterException("can't handle parameter " + r102.toString());
    L8:
        r104 = null;
        goto L9
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, SecureRandom r102) throws InvalidKeyException {
        engineInit(r100, r101, null, r102);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyOrParametersException(e.getMessage(), e);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameterSpec r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if ((r101 instanceof BCPBEKey) == false) goto L12;
        BCPBEKey r104 = (BCPBEKey) r101;
        if ((r102 instanceof PBEParameterSpec) == false) goto L8;
        CipherParameters r105 = PBE.Util.makePBEParameters(r104, r102, this.wrapEngine.getAlgorithmName());
    L14:
        if ((r102 instanceof IvParameterSpec) == false) goto L17;
        byte[] r106 = ((IvParameterSpec) r102).getIV();
        this.f525381iv = r106;
        r105 = new ParametersWithIV(r105, r106);
    L17:
        if ((r102 instanceof GOST28147WrapParameterSpec) == false) goto L23;
        GOST28147WrapParameterSpec r107 = (GOST28147WrapParameterSpec) r102;
        byte[] r108 = r107.getSBox();
        if (r108 == null) goto L21;
        r105 = new ParametersWithSBox(r105, r108);
    L21:
        r105 = new ParametersWithUKM(r105, r107.getUKM());
    L23:
        if ((r105 instanceof KeyParameter) == false) goto L29;
        int r109 = this.ivSize;
        if (r109 == 0) goto L29;
        if (r100 == 3) goto L28;
        if (r100 != 1) goto L29;
    L28:
        byte[] r110 = new byte[r109];
        this.f525381iv = r110;
        r103.nextBytes(r110);
        r105 = new ParametersWithIV(r105, this.f525381iv);
    L29:
        if (r103 == null) goto L51;
        r105 = new ParametersWithRandom(r105, r103);
    L51:
        if (r100 != 1) goto L33;
        this.wrapEngine.init(true, r105);     // Catch: Exception -> L48
        this.wrapStream = new ErasableOutputStream();     // Catch: Exception -> L48
    L43:
        this.forWrapping = true;     // Catch: Exception -> L48
        return;
    L33:
        if (r100 != 2) goto L35;
        this.wrapEngine.init(false, r105);     // Catch: Exception -> L48
        this.wrapStream = new ErasableOutputStream();     // Catch: Exception -> L48
    L39:
        this.forWrapping = false;     // Catch: Exception -> L48
        return;
    L35:
        if (r100 != 3) goto L37;
        this.wrapEngine.init(true, r105);     // Catch: Exception -> L48
        this.wrapStream = null;     // Catch: Exception -> L48
        goto L43
    L37:
        if (r100 != 4) goto L41;
        this.wrapEngine.init(false, r105);     // Catch: Exception -> L48
        this.wrapStream = null;     // Catch: Exception -> L48
        goto L39
    L41:
        throw new InvalidParameterException("Unknown mode parameter passed to init.");     // Catch: Exception -> L48
    L48:
        e = move-exception;
        throw new InvalidKeyOrParametersException(e.getMessage(), e);
    L8:
        if (r104.getParam() == null) goto L11;
        r105 = r104.getParam();
        goto L14
    L11:
        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
    L12:
        r105 = new KeyParameter(r101.getEncoded());
        goto L14
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
    public Key engineUnwrap(byte[] r100, String r101, int r102) throws InvalidKeyException, NoSuchAlgorithmException {
        Wrapper r103 = this.wrapEngine;     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
        if (r103 != null) goto L6;
        byte[] r104 = engineDoFinal(r100, 0, r100.length);     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
    L8:
        if (r102 != 3) goto L12;
        return new SecretKeySpec(r104, r101);
    L12:
        if (r101.equals("") == false) goto L47;
        if (r102 != 2) goto L47;
        PrivateKeyInfo r105 = PrivateKeyInfo.getInstance(r104);     // Catch: Exception -> L19
        PrivateKey r106 = BouncyCastleProvider.getPrivateKey(r105);     // Catch: Exception -> L19
        if (r106 == null) goto L18;
        return r106;
    L18:
        throw new InvalidKeyException("algorithm " + r105.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");     // Catch: Exception -> L19
    L20:
        throw new InvalidKeyException("Invalid key encoding.");
    L47:
        KeyFactory r107 = this.helper.createKeyFactory(r101);     // Catch: InvalidKeySpecException -> L30 NoSuchProviderException -> L33
        if (r102 == 1) goto L24;
        if (r102 != 2) goto L29;
        return r107.generatePrivate(new PKCS8EncodedKeySpec(r104));
    L29:
        throw new InvalidKeyException("Unknown key type " + r102);
    L24:
        return r107.generatePublic(new X509EncodedKeySpec(r104));
    L33:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L30:
        e = move-exception;
        throw new InvalidKeyException("Unknown key type " + e.getMessage());
    L6:
        r104 = r103.unwrap(r100, 0, r100.length);     // Catch: IllegalBlockSizeException -> L36 BadPaddingException -> L39 InvalidCipherTextException -> L42
    L39:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L36:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    L42:
        e = move-exception;
        throw new InvalidKeyException(e.getMessage());
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] r100, int r101, int r102, byte[] r103, int r104) throws ShortBufferException {
        ErasableOutputStream r105 = this.wrapStream;
        if (r105 == null) goto L7;
        r105.write(r100, r101, r102);
        return 0;
    L7:
        throw new IllegalStateException("not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r100, int r101, int r102) {
        ErasableOutputStream r103 = this.wrapStream;
        if (r103 == null) goto L7;
        r103.write(r100, r101, r102);
        return null;
    L7:
        throw new IllegalStateException("not supported in a wrapping mode");
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
