package org.bouncycastle.pqc.jcajce.provider.xmss;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.NullDigest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTSigner;
import org.bouncycastle.pqc.jcajce.interfaces.StateAwareSignature;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTSignatureSpi extends Signature implements StateAwareSignature {
    private Digest digest;
    private SecureRandom random;
    private XMSSMTSigner signer;
    private ASN1ObjectIdentifier treeDigest;

    public static class generic extends XMSSMTSignatureSpi {
        public generic() {
            super("XMSSMT", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha256 extends XMSSMTSignatureSpi {
        public withSha256() {
            super("XMSSMT-SHA256", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha256andPrehash extends XMSSMTSignatureSpi {
        public withSha256andPrehash() {
            super("SHA256withXMSSMT-SHA256", new SHA256Digest(), new XMSSMTSigner());
        }
    }

    public static class withSha512 extends XMSSMTSignatureSpi {
        public withSha512() {
            super("XMSSMT-SHA512", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withSha512andPrehash extends XMSSMTSignatureSpi {
        public withSha512andPrehash() {
            super("SHA512withXMSSMT-SHA512", new SHA512Digest(), new XMSSMTSigner());
        }
    }

    public static class withShake128 extends XMSSMTSignatureSpi {
        public withShake128() {
            super("XMSSMT-SHAKE128", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withShake128andPrehash extends XMSSMTSignatureSpi {
        public withShake128andPrehash() {
            super("SHAKE128withXMSSMT-SHAKE128", new SHAKEDigest(128), new XMSSMTSigner());
        }
    }

    public static class withShake256 extends XMSSMTSignatureSpi {
        public withShake256() {
            super("XMSSMT-SHAKE256", new NullDigest(), new XMSSMTSigner());
        }
    }

    public static class withShake256andPrehash extends XMSSMTSignatureSpi {
        public withShake256andPrehash() {
            super("SHAKE256withXMSSMT-SHAKE256", new SHAKEDigest(256), new XMSSMTSigner());
        }
    }

    public XMSSMTSignatureSpi(String r100) {
        super(r100);
    }

    public XMSSMTSignatureSpi(String r100, Digest r101, XMSSMTSigner r102) {
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
        if ((r100 instanceof BCXMSSMTPrivateKey) == false) goto L10;
        BCXMSSMTPrivateKey r101 = (BCXMSSMTPrivateKey) r100;
        CipherParameters r102 = r101.getKeyParams();
        this.treeDigest = r101.getTreeDigestOID();
        SecureRandom r103 = this.random;
        if (r103 == null) goto L7;
        r102 = new ParametersWithRandom(r102, r103);
    L7:
        this.digest.reset();
        this.signer.init(true, r102);
        return;
    L10:
        throw new InvalidKeyException("unknown private key passed to XMSSMT");
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100, SecureRandom r101) throws InvalidKeyException {
        this.random = r101;
        engineInitSign(r100);
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCXMSSMTPublicKey) == false) goto L7;
        CipherParameters r101 = ((BCXMSSMTPublicKey) r100).getKeyParams();
        this.treeDigest = null;
        this.digest.reset();
        this.signer.init(false, r101);
        return;
    L7:
        throw new InvalidKeyException("unknown public key passed to XMSSMT");
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
        byte[] r100 = DigestUtil.getDigestResult(this.digest);
        return this.signer.generateSignature(r100);
    L5:
        e = move-exception;
        if ((e instanceof IllegalStateException) == false) goto L11;
        throw new SignatureException(e.getMessage(), e);
    L11:
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

    @Override // org.bouncycastle.pqc.jcajce.interfaces.StateAwareSignature
    public PrivateKey getUpdatedPrivateKey() {
        ASN1ObjectIdentifier r100 = this.treeDigest;
        if (r100 == null) goto L7;
        BCXMSSMTPrivateKey r101 = new BCXMSSMTPrivateKey(r100, (XMSSMTPrivateKeyParameters) this.signer.getUpdatedPrivateKey());
        this.treeDigest = null;
        return r101;
    L7:
        throw new IllegalStateException("signature object not in a signing state");
    }

    @Override // org.bouncycastle.pqc.jcajce.interfaces.StateAwareSignature
    public boolean isSigningCapable() {
        if (this.treeDigest != null) goto L5;
    L7:
        return false;
    L5:
        if (this.signer.getUsagesRemaining() == 0) goto L7;
        return true;
    }
}
