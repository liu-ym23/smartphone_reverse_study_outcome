package org.bouncycastle.jcajce.provider.asymmetric.ec;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.SM2Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.spec.SM2ParameterSpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
public class GMSignatureSpi extends java.security.SignatureSpi {
    private AlgorithmParameters engineParams;
    private final JcaJceHelper helper;
    private SM2ParameterSpec paramSpec;
    private final SM2Signer signer;

    public static class sha256WithSM2 extends GMSignatureSpi {
        public sha256WithSM2() {
            super(new SM2Signer(new SHA256Digest()));
        }
    }

    public static class sm3WithSM2 extends GMSignatureSpi {
        public sm3WithSM2() {
            super(new SM2Signer());
        }
    }

    public GMSignatureSpi(SM2Signer r100) {
        this.helper = new BCJcaJceHelper();
        this.signer = r100;
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
        CipherParameters r101 = ECUtil.generatePrivateKeyParameter(r100);
        SecureRandom r102 = ((java.security.SignatureSpi) this).appRandom;
        if (r102 == null) goto L5;
        r101 = new ParametersWithRandom(r101, r102);
    L5:
        SM2ParameterSpec r103 = this.paramSpec;
        if (r103 == null) goto L8;
        this.signer.init(true, new ParametersWithID(r101, r103.getID()));
        return;
    L8:
        this.signer.init(true, r101);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        CipherParameters r101 = ECUtils.generatePublicKeyParameter(r100);
        SM2ParameterSpec r102 = this.paramSpec;
        if (r102 == null) goto L5;
        r101 = new ParametersWithID(r101, r102.getID());
    L5:
        this.signer.init(false, r101);
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String r100, Object r101) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec r100) throws InvalidAlgorithmParameterException {
        if ((r100 instanceof SM2ParameterSpec) == false) goto L7;
        this.paramSpec = (SM2ParameterSpec) r100;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("only SM2ParameterSpec supported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        return this.signer.generateSignature();
    L4:
        e = move-exception;
        throw new SignatureException("unable to create signature: " + e.getMessage());
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
