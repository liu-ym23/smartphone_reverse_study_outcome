package org.bouncycastle.pqc.jcajce.provider.sphincs;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCS256Signer;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureSpi extends java.security.SignatureSpi {
    private Digest digest;
    private SecureRandom random;
    private SPHINCS256Signer signer;
    private final ASN1ObjectIdentifier treeDigest;

    public static class withSha3_512 extends SignatureSpi {
        public withSha3_512() {
            super(new SHA3Digest(512), NISTObjectIdentifiers.id_sha3_256, new SPHINCS256Signer(new SHA3Digest(256), new SHA3Digest(512)));
        }
    }

    public static class withSha512 extends SignatureSpi {
        public withSha512() {
            super(new SHA512Digest(), NISTObjectIdentifiers.id_sha512_256, new SPHINCS256Signer(new SHA512tDigest(256), new SHA512Digest()));
        }
    }

    public SignatureSpi(Digest r100, ASN1ObjectIdentifier r101, SPHINCS256Signer r102) {
        this.digest = r100;
        this.treeDigest = r101;
        this.signer = r102;
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCSphincs256PrivateKey) == false) goto L11;
        BCSphincs256PrivateKey r101 = (BCSphincs256PrivateKey) r100;
        if (this.treeDigest.equals(r101.getTreeDigest()) == false) goto L9;
        CipherParameters r102 = r101.getKeyParams();
        this.digest.reset();
        this.signer.init(true, r102);
        return;
    L9:
        throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + r101.getTreeDigest());
    L11:
        throw new InvalidKeyException("unknown private key passed to SPHINCS-256");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException {
        this.random = r101;
        engineInitSign(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCSphincs256PublicKey) == false) goto L11;
        BCSphincs256PublicKey r101 = (BCSphincs256PublicKey) r100;
        if (this.treeDigest.equals(r101.getTreeDigest()) == false) goto L9;
        CipherParameters r102 = r101.getKeyParams();
        this.digest.reset();
        this.signer.init(false, r102);
        return;
    L9:
        throw new InvalidKeyException("SPHINCS-256 signature for tree digest: " + r101.getTreeDigest());
    L11:
        throw new InvalidKeyException("unknown public key passed to SPHINCS-256");
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
        return this.signer.generateSignature(r100);
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
        return this.signer.verifySignature(r101, r100);
    }
}
