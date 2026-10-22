package org.bouncycastle.jcajce.provider.asymmetric.elgamal;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.encodings.ISO9796d1Encoding;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.ElGamalEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.bouncycastle.jcajce.provider.util.BadBlockException;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jce.interfaces.ElGamalKey;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class CipherSpi extends BaseCipherSpi {
    private BaseCipherSpi.ErasableOutputStream bOut;
    private AsymmetricBlockCipher cipher;
    private AlgorithmParameters engineParams;
    private AlgorithmParameterSpec paramSpec;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher r100) {
        this.bOut = new BaseCipherSpi.ErasableOutputStream();
        this.cipher = r100;
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
        this.cipher = new OAEPEncoding(new ElGamalEngine(), r102, ((PSource.PSpecified) r100.getPSource()).getValue());
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
        if ((this.cipher instanceof ElGamalEngine) == false) goto L14;
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
        throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
    L14:
        if (this.bOut.size() <= this.cipher.getInputBlockSize()) goto L15;
        throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
    L24:
        throw new ShortBufferException("output buffer too short for input.");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] r100, int r101, int r102) throws IllegalBlockSizeException, BadPaddingException {
        if (r100 == null) goto L5;
        this.bOut.write(r100, r101, r102);
    L5:
        if ((this.cipher instanceof ElGamalEngine) == false) goto L12;
        if (this.bOut.size() <= (this.cipher.getInputBlockSize() + 1)) goto L14;
        throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
    L14:
        return getOutput();
    L12:
        if (this.bOut.size() <= this.cipher.getInputBlockSize()) goto L14;
        throw new ArrayIndexOutOfBoundsException("too much data for ElGamal block");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key r100) {
        if ((r100 instanceof ElGamalKey) == false) goto L8;
        BigInteger r101 = ((ElGamalKey) r100).getParameters().getP();
    L6:
        return r101.bitLength();
    L8:
        if ((r100 instanceof DHKey) == false) goto L11;
        r101 = ((DHKey) r100).getParams().getP();
        goto L6
    L11:
        throw new IllegalArgumentException("not an ElGamal key!");
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int r100) {
        return this.cipher.getOutputBlockSize();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L12;
        if (this.paramSpec == null) goto L12;
        AlgorithmParameters r100 = createParametersInstance("OAEP");     // Catch: Exception -> L8
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
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
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
        if ((r101 instanceof DHPublicKey) == false) goto L6;
        CipherParameters r104 = ElGamalUtil.generatePublicKeyParameter((PublicKey) r101);
    L9:
        if ((r102 instanceof OAEPParameterSpec) == false) goto L30;
        OAEPParameterSpec r105 = (OAEPParameterSpec) r102;
        this.paramSpec = r102;
        if (r105.getMGFAlgorithm().equalsIgnoreCase("MGF1") == true) goto L18;
        if (r105.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId()) == true) goto L18;
        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
    L18:
        if ((r105.getMGFParameters() instanceof MGF1ParameterSpec) == false) goto L29;
        Digest r106 = DigestFactory.getDigest(r105.getDigestAlgorithm());
        if (r106 == null) goto L27;
        MGF1ParameterSpec r107 = (MGF1ParameterSpec) r105.getMGFParameters();
        Digest r108 = DigestFactory.getDigest(r107.getDigestAlgorithm());
        if (r108 == null) goto L25;
        this.cipher = new OAEPEncoding(new ElGamalEngine(), r106, r108, ((PSource.PSpecified) r105.getPSource()).getValue());
    L31:
        if (r103 == null) goto L33;
        r104 = new ParametersWithRandom(r104, r103);
    L33:
        boolean r109 = true;
        if (r100 != 1) goto L36;
    L45:
        AsymmetricBlockCipher r110 = this.cipher;
    L46:
        r110.init(r109, r104);
        return;
    L36:
        if (r100 != 2) goto L38;
    L44:
        r110 = this.cipher;
        r109 = false;
        goto L46
    L38:
        if (r100 == 3) goto L45;
        if (r100 == 4) goto L44;
        throw new InvalidParameterException("unknown opmode " + r100 + " passed to ElGamal");
    L25:
        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + r107.getDigestAlgorithm());
    L27:
        throw new InvalidAlgorithmParameterException("no match on digest algorithm: " + r105.getDigestAlgorithm());
    L29:
        throw new InvalidAlgorithmParameterException("unkown MGF parameters");
    L30:
        if (r102 == null) goto L31;
        throw new InvalidAlgorithmParameterException("unknown parameter type.");
    L6:
        if ((r101 instanceof DHPrivateKey) == false) goto L51;
        r104 = ElGamalUtil.generatePrivateKeyParameter((PrivateKey) r101);
        goto L9
    L51:
        throw new InvalidKeyException("unknown key type passed to ElGamal");
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
        throw new NoSuchAlgorithmException("can't support mode " + r100);
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetPadding(String r100) throws NoSuchPaddingException {
        String r101 = Strings.toUpperCase(r100);
        if (r101.equals("NOPADDING") == false) goto L7;
        AsymmetricBlockCipher r102 = new ElGamalEngine();
    L5:
        this.cipher = r102;
        return;
    L7:
        if (r101.equals("PKCS1PADDING") == false) goto L10;
        r102 = new PKCS1Encoding(new ElGamalEngine());
        goto L5
    L10:
        if (r101.equals("ISO9796-1PADDING") == false) goto L13;
        r102 = new ISO9796d1Encoding(new ElGamalEngine());
        goto L5
    L13:
        if (r101.equals("OAEPPADDING") == false) goto L17;
    L14:
        OAEPParameterSpec r103 = OAEPParameterSpec.DEFAULT;
    L15:
        initFromSpec(r103);
        return;
    L17:
        if (r101.equals("OAEPWITHMD5ANDMGF1PADDING") == false) goto L20;
        r103 = new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT);
        goto L15
    L20:
        if (r101.equals("OAEPWITHSHA1ANDMGF1PADDING") == true) goto L14;
        if (r101.equals("OAEPWITHSHA224ANDMGF1PADDING") == false) goto L26;
        r103 = new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), PSource.PSpecified.DEFAULT);
        goto L15
    L26:
        if (r101.equals("OAEPWITHSHA256ANDMGF1PADDING") == false) goto L29;
        r103 = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
        goto L15
    L29:
        if (r101.equals("OAEPWITHSHA384ANDMGF1PADDING") == false) goto L32;
        r103 = new OAEPParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT);
        goto L15
    L32:
        if (r101.equals("OAEPWITHSHA512ANDMGF1PADDING") == false) goto L35;
        r103 = new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT);
        goto L15
    L35:
        if (r101.equals("OAEPWITHSHA3-224ANDMGF1PADDING") == false) goto L38;
        r103 = new OAEPParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), PSource.PSpecified.DEFAULT);
        goto L15
    L38:
        if (r101.equals("OAEPWITHSHA3-256ANDMGF1PADDING") == false) goto L41;
        r103 = new OAEPParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), PSource.PSpecified.DEFAULT);
        goto L15
    L41:
        if (r101.equals("OAEPWITHSHA3-384ANDMGF1PADDING") == false) goto L44;
        r103 = new OAEPParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), PSource.PSpecified.DEFAULT);
        goto L15
    L44:
        if (r101.equals("OAEPWITHSHA3-512ANDMGF1PADDING") == false) goto L48;
        r103 = new OAEPParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), PSource.PSpecified.DEFAULT);
        goto L15
    L48:
        throw new NoSuchPaddingException(r100 + " unavailable with ElGamal.");
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        this.bOut.write(r100, r101, r102);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] r100, int r101, int r102) {
        this.bOut.write(r100, r101, r102);
        return null;
    }
}
