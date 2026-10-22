package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.signers.Ed25519Signer;
import org.bouncycastle.crypto.signers.Ed448Signer;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureSpi extends java.security.SignatureSpi {
    private static final byte[] EMPTY_CONTEXT = null;
    private final String algorithm;
    private Signer signer;

    public static final class Ed25519 extends SignatureSpi {
        public Ed25519() {
            super(EdDSAParameterSpec.Ed25519);
        }
    }

    public static final class Ed448 extends SignatureSpi {
        public Ed448() {
            super(EdDSAParameterSpec.Ed448);
        }
    }

    public static final class EdDSA extends SignatureSpi {
        public EdDSA() {
            super(null);
        }
    }

    static {
        EMPTY_CONTEXT = new byte[0];
    }

    public SignatureSpi(String r100) {
        this.algorithm = r100;
    }

    private Signer getSigner(String r100) throws InvalidKeyException {
        String r101 = this.algorithm;
        if (r101 == null) goto L10;
        if (r100.equals(r101) == true) goto L10;
        throw new InvalidKeyException("inappropriate key for " + this.algorithm);
    L10:
        if (r100.equals(EdDSAParameterSpec.Ed448) == false) goto L14;
        return new Ed448Signer(EMPTY_CONTEXT);
    L14:
        return new Ed25519Signer();
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineGetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCEdDSAPrivateKey) == false) goto L11;
        AsymmetricKeyParameter r101 = ((BCEdDSAPrivateKey) r100).engineGetKeyParameters();
        if ((r101 instanceof Ed448PrivateKeyParameters) == false) goto L7;
        String r102 = EdDSAParameterSpec.Ed448;
    L8:
        this.signer = getSigner(r102);
        this.signer.init(true, r101);
        return;
    L7:
        r102 = EdDSAParameterSpec.Ed25519;
        goto L8
    L11:
        throw new InvalidKeyException("cannot identify EdDSA private key");
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCEdDSAPublicKey) == false) goto L11;
        AsymmetricKeyParameter r101 = ((BCEdDSAPublicKey) r100).engineGetKeyParameters();
        if ((r101 instanceof Ed448PublicKeyParameters) == false) goto L7;
        String r102 = EdDSAParameterSpec.Ed448;
    L8:
        this.signer = getSigner(r102);
        this.signer.init(false, r101);
        return;
    L7:
        r102 = EdDSAParameterSpec.Ed25519;
        goto L8
    L11:
        throw new InvalidKeyException("cannot identify EdDSA public key");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String r100, Object r101) throws InvalidParameterException {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        return this.signer.generateSignature();
    L4:
        e = move-exception;
        throw new SignatureException(e.getMessage());
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte r100) throws SignatureException {
        this.signer.update(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] r100, int r101, int r102) throws SignatureException {
        this.signer.update(r100, r101, r102);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] r100) throws SignatureException {
        return this.signer.verifySignature(r100);
    }
}
