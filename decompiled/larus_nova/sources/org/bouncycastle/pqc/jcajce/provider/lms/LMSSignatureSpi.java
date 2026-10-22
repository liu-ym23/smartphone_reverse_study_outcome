package org.bouncycastle.pqc.jcajce.provider.lms;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.pqc.crypto.lms.LMSContext;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedSigner;
import org.bouncycastle.pqc.crypto.lms.LMSContextBasedVerifier;

/* JADX INFO: loaded from: classes42.dex */
public class LMSSignatureSpi extends Signature {
    private Digest digest;
    private LMSContextBasedSigner lmOtsSigner;
    private LMSContextBasedVerifier lmOtsVerifier;
    private SecureRandom random;
    private MessageSigner signer;

    public static class generic extends LMSSignatureSpi {
        public generic() {
            super("LMS", new NullDigest());
        }
    }

    public LMSSignatureSpi(String r100) {
        super(r100);
    }

    public LMSSignatureSpi(String r100, Digest r101) {
        super(r100);
        this.digest = r101;
    }

    private Digest getSigner() throws SignatureException {
        return this.lmOtsSigner.generateLMSContext();
    L4:
        e = move-exception;
        throw new SignatureException(e.getMessage(), e);
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCLMSPrivateKey) == false) goto L11;
        LMSContextBasedSigner r101 = (LMSContextBasedSigner) ((BCLMSPrivateKey) r100).getKeyParams();
        this.lmOtsSigner = r101;
        if (r101.getUsagesRemaining() == 0) goto L9;
        this.digest = null;
        return;
    L9:
        throw new InvalidKeyException("private key exhausted");
    L11:
        throw new InvalidKeyException("unknown private key passed to LMS");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException {
        this.random = r101;
        engineInitSign(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCLMSPublicKey) == false) goto L7;
        NullDigest r101 = new NullDigest();
        this.digest = r101;
        r101.reset();
        this.lmOtsVerifier = (LMSContextBasedVerifier) ((BCLMSPublicKey) r100).getKeyParams();
        return;
    L7:
        throw new InvalidKeyException("unknown public key passed to XMSS");
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
        if (this.digest != null) goto L14;
        this.digest = getSigner();
    L14:
        byte[] r100 = this.lmOtsSigner.generateSignature((LMSContext) this.digest);     // Catch: Exception -> L7
        this.digest = null;     // Catch: Exception -> L7
        return r100;
    L7:
        e = move-exception;
        if ((e instanceof IllegalStateException) == false) goto L13;
        throw new SignatureException(e.getMessage(), e);
    L13:
        throw new SignatureException(e.toString(), e);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte r100) throws SignatureException {
        if (this.digest != null) goto L5;
        this.digest = getSigner();
    L5:
        this.digest.update(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] r100, int r101, int r102) throws SignatureException {
        if (this.digest != null) goto L5;
        this.digest = getSigner();
    L5:
        this.digest.update(r100, r101, r102);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] r100) throws SignatureException {
        LMSContext r101 = this.lmOtsVerifier.generateLMSContext(r100);
        byte[] r102 = DigestUtil.getDigestResult(this.digest);
        r101.update(r102, 0, r102.length);
        return this.lmOtsVerifier.verify(r101);
    }
}
