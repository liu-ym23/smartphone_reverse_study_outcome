package org.bouncycastle.pqc.jcajce.provider.qtesla;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASecurityCategory;
import org.bouncycastle.pqc.crypto.qtesla.QTESLASigner;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureSpi extends Signature {
    private Digest digest;
    private SecureRandom random;
    private QTESLASigner signer;

    public static class PI extends SignatureSpi {
        public PI() {
            super(QTESLASecurityCategory.getName(5), new NullDigest(), new QTESLASigner());
        }
    }

    public static class PIII extends SignatureSpi {
        public PIII() {
            super(QTESLASecurityCategory.getName(6), new NullDigest(), new QTESLASigner());
        }
    }

    public static class qTESLA extends SignatureSpi {
        public qTESLA() {
            super("qTESLA", new NullDigest(), new QTESLASigner());
        }
    }

    public SignatureSpi(String r100) {
        super(r100);
    }

    public SignatureSpi(String r100, Digest r101, QTESLASigner r102) {
        super(r100);
        this.digest = r101;
        this.signer = r102;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCqTESLAPrivateKey) == false) goto L10;
        CipherParameters r101 = ((BCqTESLAPrivateKey) r100).getKeyParams();
        SecureRandom r102 = this.random;
        if (r102 == null) goto L7;
        r101 = new ParametersWithRandom(r101, r102);
    L7:
        this.signer.init(true, r101);
        return;
    L10:
        throw new InvalidKeyException("unknown private key passed to qTESLA");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException {
        this.random = r101;
        engineInitSign(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCqTESLAPublicKey) == false) goto L7;
        CipherParameters r101 = ((BCqTESLAPublicKey) r100).getKeyParams();
        this.digest.reset();
        this.signer.init(false, r101);
        return;
    L7:
        throw new InvalidKeyException("unknown public key passed to qTESLA");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String r100, Object r101) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] r100 = DigestUtil.getDigestResult(this.digest);     // Catch: Exception -> L4
        return this.signer.generateSignature(r100);
    L4:
        e = move-exception;
        if ((e instanceof IllegalStateException) == false) goto L10;
        throw new SignatureException(e.getMessage());
    L10:
        throw new SignatureException(e.toString());
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte r100) throws SignatureException {
        this.digest.update(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] r100, int r101, int r102) throws SignatureException {
        this.digest.update(r100, r101, r102);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] r100) throws SignatureException {
        byte[] r101 = DigestUtil.getDigestResult(this.digest);
        return this.signer.verifySignature(r101, r100);
    }
}
