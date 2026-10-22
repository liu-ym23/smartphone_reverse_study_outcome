package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.jcajce.provider.util.DigestFactory;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class PSSSignatureSpi extends SignatureSpi {
    private Digest contentDigest;
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper;
    private boolean isInitState;
    private boolean isRaw;
    private RSAKeyParameters key;
    private Digest mgfDigest;
    private PSSParameterSpec originalSpec;
    private PSSParameterSpec paramSpec;
    private PSSSigner pss;
    private SecureRandom random;
    private int saltLength;
    private AsymmetricBlockCipher signer;
    private byte trailer;

    public class NullPssDigest implements Digest {
        private ByteArrayOutputStream bOut;
        private Digest baseDigest;
        private boolean oddTime;
        final /* synthetic */ PSSSignatureSpi this$0;

        public NullPssDigest(PSSSignatureSpi r100, Digest r101) {
            this.this$0 = r100;
            this.bOut = new ByteArrayOutputStream();
            this.oddTime = true;
            this.baseDigest = r101;
        }

        @Override // org.bouncycastle.crypto.Digest
        public int doFinal(byte[] r100, int r101) {
            byte[] r102 = this.bOut.toByteArray();
            if (this.oddTime == false) goto L5;
            System.arraycopy(r102, 0, r100, r101, r102.length);
        L6:
            reset();
            this.oddTime = !this.oddTime;
            return r102.length;
        L5:
            this.baseDigest.update(r102, 0, r102.length);
            this.baseDigest.doFinal(r100, r101);
            goto L6
        }

        @Override // org.bouncycastle.crypto.Digest
        public String getAlgorithmName() {
            return "NULL";
        }

        public int getByteLength() {
            return 0;
        }

        @Override // org.bouncycastle.crypto.Digest
        public int getDigestSize() {
            return this.baseDigest.getDigestSize();
        }

        @Override // org.bouncycastle.crypto.Digest
        public void reset() {
            this.bOut.reset();
            this.baseDigest.reset();
        }

        @Override // org.bouncycastle.crypto.Digest
        public void update(byte r100) {
            this.bOut.write(r100);
        }

        @Override // org.bouncycastle.crypto.Digest
        public void update(byte[] r100, int r101, int r102) {
            this.bOut.write(r100, r101, r102);
        }
    }

    public static class PSSwithRSA extends PSSSignatureSpi {
        public PSSwithRSA() {
            super(new RSABlindedEngine(), null);
        }
    }

    public static class SHA1withRSA extends PSSSignatureSpi {
        public SHA1withRSA() {
            super(new RSABlindedEngine(), PSSParameterSpec.DEFAULT);
        }
    }

    public static class SHA224withRSA extends PSSSignatureSpi {
        public SHA224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA224), 28, 1));
        }
    }

    public static class SHA256withRSA extends PSSSignatureSpi {
        public SHA256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-256", "MGF1", new MGF1ParameterSpec("SHA-256"), 32, 1));
        }
    }

    public static class SHA384withRSA extends PSSSignatureSpi {
        public SHA384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384, "MGF1", new MGF1ParameterSpec(McElieceCCA2KeyGenParameterSpec.SHA384), 48, 1));
        }
    }

    public static class SHA3_224withRSA extends PSSSignatureSpi {
        public SHA3_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-224", "MGF1", new MGF1ParameterSpec("SHA3-224"), 28, 1));
        }
    }

    public static class SHA3_256withRSA extends PSSSignatureSpi {
        public SHA3_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-256", "MGF1", new MGF1ParameterSpec("SHA3-256"), 32, 1));
        }
    }

    public static class SHA3_384withRSA extends PSSSignatureSpi {
        public SHA3_384withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-384", "MGF1", new MGF1ParameterSpec("SHA3-384"), 48, 1));
        }
    }

    public static class SHA3_512withRSA extends PSSSignatureSpi {
        public SHA3_512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA3-512", "MGF1", new MGF1ParameterSpec("SHA3-512"), 64, 1));
        }
    }

    public static class SHA512_224withRSA extends PSSSignatureSpi {
        public SHA512_224withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(224)", "MGF1", new MGF1ParameterSpec("SHA-512(224)"), 28, 1));
        }
    }

    public static class SHA512_256withRSA extends PSSSignatureSpi {
        public SHA512_256withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512(256)", "MGF1", new MGF1ParameterSpec("SHA-512(256)"), 32, 1));
        }
    }

    public static class SHA512withRSA extends PSSSignatureSpi {
        public SHA512withRSA() {
            super(new RSABlindedEngine(), new PSSParameterSpec("SHA-512", "MGF1", new MGF1ParameterSpec("SHA-512"), 64, 1));
        }
    }

    public static class nonePSS extends PSSSignatureSpi {
        public nonePSS() {
            super(new RSABlindedEngine(), null, true);
        }
    }

    public PSSSignatureSpi(AsymmetricBlockCipher r100, PSSParameterSpec r101) {
        this(r100, r101, false);
    }

    public PSSSignatureSpi(AsymmetricBlockCipher r100, PSSParameterSpec r101, boolean r102) {
        this.helper = new BCJcaJceHelper();
        this.isInitState = true;
        this.signer = r100;
        this.originalSpec = r101;
        if (r101 != null) goto L5;
        this.paramSpec = PSSParameterSpec.DEFAULT;
    L6:
        this.mgfDigest = DigestFactory.getDigest(this.paramSpec.getDigestAlgorithm());
        this.saltLength = this.paramSpec.getSaltLength();
        this.trailer = getTrailer(this.paramSpec.getTrailerField());
        this.isRaw = r102;
        setupContentDigest();
        return;
    L5:
        this.paramSpec = r101;
        goto L6
    }

    private byte getTrailer(int r100) {
        if (r100 != 1) goto L7;
        return PSSSigner.TRAILER_IMPLICIT;
    L7:
        throw new IllegalArgumentException("unknown trailer field");
    }

    private void setupContentDigest() {
        if (this.isRaw == false) goto L5;
        Digest r100 = new NullPssDigest(this, this.mgfDigest);
    L6:
        this.contentDigest = r100;
        return;
    L5:
        r100 = this.mgfDigest;
        goto L6
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParams != null) goto L12;
        if (this.paramSpec == null) goto L12;
        AlgorithmParameters r100 = this.helper.createAlgorithmParameters("PSS");     // Catch: Exception -> L8
        this.engineParams = r100;     // Catch: Exception -> L8
        r100.init(this.paramSpec);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        throw new RuntimeException(e.toString());
    L12:
        return this.engineParams;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof RSAPrivateKey) == false) goto L11;
        this.key = RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) r100);
        PSSSigner r101 = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
        this.pss = r101;
        SecureRandom r102 = this.random;
        if (r102 == null) goto L7;
        r101.init(true, new ParametersWithRandom(this.key, r102));
    L8:
        this.isInitState = true;
        return;
    L7:
        r101.init(true, this.key);
        goto L8
    L11:
        throw new InvalidKeyException("Supplied key is not a RSAPrivateKey instance");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException {
        this.random = r101;
        engineInitSign(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof RSAPublicKey) == false) goto L7;
        this.key = RSAUtil.generatePublicKeyParameter((RSAPublicKey) r100);
        PSSSigner r101 = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
        this.pss = r101;
        r101.init(false, this.key);
        this.isInitState = true;
        return;
    L7:
        throw new InvalidKeyException("Supplied key is not a RSAPublicKey instance");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String r100, Object r101) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec r100) throws InvalidAlgorithmParameterException {
        if (r100 != null) goto L8;
        r100 = this.originalSpec;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.isInitState == false) goto L48;
        if ((r100 instanceof PSSParameterSpec) == false) goto L46;
        PSSParameterSpec r101 = (PSSParameterSpec) r100;
        PSSParameterSpec r102 = this.originalSpec;
        if (r102 == null) goto L19;
        if (DigestFactory.isSameDigest(r102.getDigestAlgorithm(), r101.getDigestAlgorithm()) == true) goto L19;
        throw new InvalidAlgorithmParameterException("parameter must be using " + this.originalSpec.getDigestAlgorithm());
    L19:
        if (r101.getMGFAlgorithm().equalsIgnoreCase("MGF1") == true) goto L26;
        if (r101.getMGFAlgorithm().equals(PKCSObjectIdentifiers.id_mgf1.getId()) == true) goto L26;
        throw new InvalidAlgorithmParameterException("unknown mask generation function specified");
    L26:
        if ((r101.getMGFParameters() instanceof MGF1ParameterSpec) == false) goto L44;
        MGF1ParameterSpec r103 = (MGF1ParameterSpec) r101.getMGFParameters();
        if (DigestFactory.isSameDigest(r103.getDigestAlgorithm(), r101.getDigestAlgorithm()) == false) goto L42;
        Digest r104 = DigestFactory.getDigest(r103.getDigestAlgorithm());
        if (r104 == null) goto L40;
        this.engineParams = null;
        this.paramSpec = r101;
        this.mgfDigest = r104;
        this.saltLength = r101.getSaltLength();
        this.trailer = getTrailer(this.paramSpec.getTrailerField());
        setupContentDigest();
        if (this.key == null) goto L49;
        this.pss = new PSSSigner(this.signer, this.contentDigest, this.mgfDigest, this.saltLength, this.trailer);
        if (this.key.isPrivate() == false) goto L36;
        PSSSigner r105 = this.pss;
        boolean r106 = true;
    L37:
        r105.init(r106, this.key);
        return;
    L36:
        r105 = this.pss;
        r106 = false;
        goto L37
    L49:
        return;
    L40:
        throw new InvalidAlgorithmParameterException("no match on MGF digest algorithm: " + r103.getDigestAlgorithm());
    L42:
        throw new InvalidAlgorithmParameterException("digest algorithm for MGF should be the same as for PSS parameters.");
    L44:
        throw new InvalidAlgorithmParameterException("unknown MGF parameters");
    L46:
        throw new InvalidAlgorithmParameterException("Only PSSParameterSpec supported");
    L48:
        throw new ProviderException("cannot call setParameter in the middle of update");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        this.isInitState = true;
        return this.pss.generateSignature();
    L5:
        e = move-exception;
        throw new SignatureException(e.getMessage());
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte r100) throws SignatureException {
        this.pss.update(r100);
        this.isInitState = false;
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] r100, int r101, int r102) throws SignatureException {
        this.pss.update(r100, r101, r102);
        this.isInitState = false;
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] r100) throws SignatureException {
        this.isInitState = true;
        return this.pss.verifySignature(r100);
    }
}
