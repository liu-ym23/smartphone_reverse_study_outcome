package org.bouncycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.signers.DSAEncoding;

/* JADX INFO: loaded from: classes42.dex */
public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    protected Digest digest;
    protected DSAEncoding encoding;
    protected DSAExt signer;

    public DSABase(Digest r100, DSAExt r101, DSAEncoding r102) {
        this.digest = r100;
        this.signer = r101;
        this.encoding = r102;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
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
        byte[] r100 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r100, 0);
        BigInteger[] r101 = this.signer.generateSignature(r100);     // Catch: Exception -> L5
        return this.encoding.encode(this.signer.getOrder(), r101[0], r101[1]);
    L5:
        e = move-exception;
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
        byte[] r101 = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(r101, 0);
        BigInteger[] r102 = this.encoding.decode(this.signer.getOrder(), r100);     // Catch: Exception -> L6
        return this.signer.verifySignature(r101, r102[0], r102[1]);
    L7:
        throw new SignatureException("error decoding signature bytes.");
    }
}
