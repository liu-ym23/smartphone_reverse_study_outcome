package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class CipherSpi extends BaseCipherSpi {
    private BaseCipherSpi.ErasableOutputStream bOut;
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper;
    private AlgorithmParameterSpec paramSpec;
    private boolean privateKeyOnly;
    private boolean publicKeyOnly;

    public static class ISO9796d1Padding extends CipherSpi {
        public ISO9796d1Padding() {
            super(new ISO9796d1Encoding(new RSABlindedEngine()));
        }
    }

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new RSABlindedEngine());
        }
    }

    public static class OAEPPadding extends CipherSpi {
        public OAEPPadding() {
            super(OAEPParameterSpec.DEFAULT);
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PrivateOnly extends CipherSpi {
        public PKCS1v1_5Padding_PrivateOnly() {
            super(false, true, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class PKCS1v1_5Padding_PublicOnly extends CipherSpi {
        public PKCS1v1_5Padding_PublicOnly() {
            super(true, false, new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public CipherSpi(OAEPParameterSpec r100) {
        this.helper = new BCJcaJceHelper();
        this.publicKeyOnly = false;
        this.privateKeyOnly = false;
        this.bOut = new BaseCipherSpi.ErasableOutputStream();
        initFromSpec(r100);     // Catch: NoSuchPaddingException -> L5
        return;
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage());
    }

    public CipherSpi(AsymmetricBlockCipher r100) {
        this.helper = new BCJcaJceHelper();
        this.publicKeyOnly = false;
        this.privateKeyOnly = false;
        this.bOut = new BaseCipherSpi.ErasableOutputStream();
        this.cipher = r100;
    }

    public CipherSpi(boolean r100, boolean r101, AsymmetricBlockCipher r102) {
        this.helper = new BCJcaJceHelper();
        this.publicKeyOnly = false;
        this.privateKeyOnly = false;
        this.bOut = new BaseCipherSpi.ErasableOutputStream();
        this.publicKeyOnly = r100;
        this.privateKeyOnly = r101;
        this.cipher = r102;
    }

    private byte[] getOutput() throws BadPaddingException {
        byte[] r100 = this.cipher.processBlock(this.bOut.getBuf(), 0, this.bOut.size());     // Catch: Throwable -> L6 ArrayIndexOutOfBoundsException -> L8 InvalidCipherTextException -> L11
        this.bOut.erase();
        return r100;
    L6:
        th = move-exception;
        this.bOut.erase();
        throw th;
    L8:
        e = move-exception;
        throw new BadBlockException("unable to decrypt block", e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new BadBlockException("unable to decrypt block", e);     // Catch: Throwable -> L6
    }

    private void initFromSpec(OAEPParameterSpec r100) throws NoSuchPaddingException {
        MGF1ParameterSpec r101 = (MGF1ParameterSpec) r100.getMGFParameters();
        Digest r102 = DigestFactory.getDigest(r101.getDigestAlgorithm());
        if (r102 == null) goto L7;
        this.cipher = new OAEPEncoding(new RSABlindedEngine(), r102, ((PSource.PSpecified) r100.getPSource()).getValue());
        this.paramSpec = r100;
        return;
    L7:
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + r101.getDigestAlgorithm());
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] r100, int r101, int r102, byte[] r103, int r104) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        if ((engineGetOutputSize(r102) + r104) > r103.length) goto L24;
        if (r100 == null) goto L7;
        this.bOut.write(r100, r101, r102);
    L7:
        if ((this.cipher instanceof RSABlindedEngine) == false) goto L14;
        if (this.bOut.size() > (this.cipher.getInputBlockSize() + 1)) goto L12;
    L15:
        byte[] r105 = getOutput();
        int r106 = 0;
    L17:
        if (r106 == r105.length) goto L20;
        r103[r104 + r106] = r105[r106];
        r106 = r106 + 1;
        goto L17
    L20:
        return r105.length;
    L12:
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    L14:
        if (this.bOut.size() <= this.cipher.getInputBlockSize()) goto L15;
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    L24:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException {
        if (r100 == null) goto L5;
        this.bOut.write(r100, r101, r102);
    L5:
        if ((this.cipher instanceof RSABlindedEngine) == false) goto L12;
        if (this.bOut.size() <= (this.cipher.getInputBlockSize() + 1)) goto L14;
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    L14:
        return getOutput();
    L12:
        if (this.bOut.size() <= this.cipher.getInputBlockSize()) goto L14;
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.cipher.getInputBlockSize();
    L5:
        throw new IllegalStateException("RSA Cipher not initialised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        if ((r100 instanceof RSAPrivateKey) == false) goto L8;
        BigInteger r101 = ((RSAPrivateKey) r100).getModulus();
    L6:
        return r101.bitLength();
    L8:
        if ((r100 instanceof RSAPublicKey) == false) goto L11;
        r101 = ((RSAPublicKey) r100).getModulus();
        goto L6
    L11:
        throw new IllegalArgumentException("not an RSA key!");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return this.cipher.getOutputBlockSize();
    L5:
        throw new IllegalStateException("RSA Cipher not initialised");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L12;
        if (this.paramSpec == null) goto L12;
        AlgorithmParameters r100 = this.helper.createAlgorithmParameters("OAEP");     // Catch: Exception -> L8
        this.engineParams = r100;     // Catch: Exception -> L8
        r100.init(this.paramSpec);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L12:
        return this.engineParams;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameters r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r102 != null) goto L11;
        AlgorithmParameterSpec r104 = null;
    L9:
        this.engineParams = r102;
        engineInit(r100, r101, r104, r103);
        return;
    L11:
        r104 = r102.getParameterSpec(OAEPParameterSpec.class);     // Catch: InvalidParameterSpecException -> L5
    L5:
        e = move-exception;
        throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString(), e);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, SecureRandom r102) throws InvalidKeyException {
        engineInit(r100, r101, null, r102);     // Catch: InvalidAlgorithmParameterException -> L5
        return;
    L5:
        e = move-exception;
        throw new InvalidKeyException("Eeeek! " + e.toString(), e);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int r100, Key r101, AlgorithmParameterSpec r102, SecureRandom r103) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (r102 == null) goto L9;
        if ((r102 instanceof OAEPParameterSpec) == true) goto L9;
        throw new InvalidAlgorithmParameterException("unknown parameter type: ".concat(r102.getClass().getName()));
    L9:
        if ((r101 instanceof RSAPublicKey) == false) goto L18;
        if (this.privateKeyOnly == false) goto L16;
        if (r100 != 1) goto L16;
        throw new InvalidKeyException("mode 1 requires RSAPrivateKey");
    L16:
        CipherParameters r104 = RSAUtil.generatePublicKeyParameter((RSAPublicKey) r101);
    L26:
        if (r102 == null) goto L48;
        OAEPParameterSpec r105 = (OAEPParameterSpec) r102;
        this.paramSpec = r102;
        if (r105.getMGFAlgorithm().equalsIgnoreCase("MGF1") == true) goto L35;
        if (r105.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId()) == true) goto L35;
        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
    L35:
        if ((r105.getMGFParameters() instanceof MGF1ParameterSpec) == false) goto L46;
        Digest r106 = DigestFactory.getDigest(r105.getDigestAlgorithm());
        if (r106 == null) goto L44;
        MGF1ParameterSpec r107 = (MGF1ParameterSpec) r105.getMGFParameters();
        Digest r108 = DigestFactory.getDigest(r107.getDigestAlgorithm());
        if (r108 == null) goto L42;
        this.cipher = new OAEPEncoding(new RSABlindedEngine(), r106, r108, ((PSource.PSpecified) r105.getPSource()).getValue());
        goto L48
    L42:
        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + r107.getDigestAlgorithm());
    L44:
        throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + r105.getDigestAlgorithm());
    L46:
        throw new InvalidAlgorithmParameterException("unkown MGF parameters");
    L48:
        if ((this.cipher instanceof RSABlindedEngine) == false) goto L50;
    L54:
        this.bOut.reset();
        if (r100 != 1) goto L57;
    L66:
        this.cipher.init(true, r104);
        return;
    L57:
        if (r100 != 2) goto L59;
    L65:
        this.cipher.init(false, r104);
        return;
    L59:
        if (r100 == 3) goto L66;
        if (r100 == 4) goto L65;
        throw new InvalidParameterException("unknown opmode " + r100 + " passed to RSA");
    L50:
        if (r103 == null) goto L52;
        ParametersWithRandom r109 = new ParametersWithRandom(r104, r103);
    L53:
        r104 = r109;
        goto L54
    L52:
        r109 = new ParametersWithRandom(r104, CryptoServicesRegistrar.getSecureRandom());
        goto L53
    L18:
        if ((r101 instanceof RSAPrivateKey) == false) goto L69;
        if (this.publicKeyOnly == false) goto L25;
        if (r100 != 1) goto L25;
        throw new InvalidKeyException("mode 2 requires RSAPublicKey");
    L25:
        r104 = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) r101);
        goto L26
    L69:
        throw new InvalidKeyException("unknown key type passed to RSA");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetMode(String r100) throws NoSuchAlgorithmException {
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals(UserProfileEvent.POSITION_NONE) == false) goto L5;
        return;
    L5:
        if (r101.equals("ECB") == false) goto L8;
        return;
    L8:
        if (r101.equals("1") == false) goto L12;
        this.privateKeyOnly = true;
        this.publicKeyOnly = false;
        return;
    L12:
        if (r101.equals("2") == false) goto L16;
        this.privateKeyOnly = false;
        this.publicKeyOnly = true;
        return;
    L16:
        throw new NoSuchAlgorithmException("can't support mode " + r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals("NOPADDING") == false) goto L7;
        AsymmetricBlockCipher r102 = new RSABlindedEngine();
    L5:
        this.cipher = r102;
        return;
    L7:
        if (r101.equals("PKCS1PADDING") == false) goto L10;
        r102 = new PKCS1Encoding(new RSABlindedEngine());
        goto L5
    L10:
        if (r101.equals("ISO9796-1PADDING") == false) goto L13;
        r102 = new ISO9796d1Encoding(new RSABlindedEngine());
        goto L5
    L13:
        if (r101.equals("OAEPWITHMD5ANDMGF1PADDING") == false) goto L17;
        OAEPParameterSpec r103 = new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT);
    L15:
        initFromSpec(r103);
        return;
    L17:
        if (r101.equals("OAEPPADDING") == false) goto L20;
    L18:
        r103 = OAEPParameterSpec.DEFAULT;
        goto L15
    L20:
        if (r101.equals("OAEPWITHSHA1ANDMGF1PADDING") == true) goto L18;
        if (r101.equals("OAEPWITHSHA-1ANDMGF1PADDING") == true) goto L18;
        if (r101.equals("OAEPWITHSHA224ANDMGF1PADDING") == false) goto L27;
    L61:
        r103 = new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT);
        goto L15
    L27:
        if (r101.equals("OAEPWITHSHA-224ANDMGF1PADDING") == true) goto L61;
        if (r101.equals("OAEPWITHSHA256ANDMGF1PADDING") == false) goto L32;
    L60:
        r103 = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        goto L15
    L32:
        if (r101.equals("OAEPWITHSHA-256ANDMGF1PADDING") == true) goto L60;
        if (r101.equals("OAEPWITHSHA384ANDMGF1PADDING") == false) goto L37;
    L59:
        r103 = new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
        goto L15
    L37:
        if (r101.equals("OAEPWITHSHA-384ANDMGF1PADDING") == true) goto L59;
        if (r101.equals("OAEPWITHSHA512ANDMGF1PADDING") == false) goto L42;
    L58:
        r103 = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
        goto L15
    L42:
        if (r101.equals("OAEPWITHSHA-512ANDMGF1PADDING") == true) goto L58;
        if (r101.equals("OAEPWITHSHA3-224ANDMGF1PADDING") == false) goto L48;
        r103 = new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT);
        goto L15
    L48:
        if (r101.equals("OAEPWITHSHA3-256ANDMGF1PADDING") == false) goto L51;
        r103 = new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT);
        goto L15
    L51:
        if (r101.equals("OAEPWITHSHA3-384ANDMGF1PADDING") == false) goto L54;
        r103 = new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT);
        goto L15
    L54:
        if (r101.equals("OAEPWITHSHA3-512ANDMGF1PADDING") == false) goto L57;
        r103 = new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT);
        goto L15
    L57:
        throw new NoSuchPaddingException(r100 + " unavailable with RSA.");
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        this.bOut.write(r100, r101, r102);
        if ((this.cipher instanceof RSABlindedEngine) == false) goto L10;
        if (this.bOut.size() > (this.cipher.getInputBlockSize() + 1)) goto L8;
        return 0;
    L8:
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    L10:
        if (this.bOut.size() > this.cipher.getInputBlockSize()) goto L14;
        return 0;
    L14:
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r100, int r101, int r102) {
        this.bOut.write(r100, r101, r102);
        if ((this.cipher instanceof RSABlindedEngine) == false) goto L10;
        if (this.bOut.size() > (this.cipher.getInputBlockSize() + 1)) goto L8;
        return null;
    L8:
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    L10:
        if (this.bOut.size() > this.cipher.getInputBlockSize()) goto L14;
        return null;
    L14:
        throw new ArrayIndexOutOfBoundsException("too much data for RSA block");
    }
}
