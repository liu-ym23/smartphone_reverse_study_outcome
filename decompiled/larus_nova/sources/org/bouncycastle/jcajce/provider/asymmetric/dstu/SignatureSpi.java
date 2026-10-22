package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.GOST3411Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.signers.DSTU4145Signer;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jce.interfaces.ECKey;

/* JADX INFO: loaded from: classes42.dex */
public class SignatureSpi extends java.security.SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    private Digest digest;
    private DSAExt signer;

    public SignatureSpi() {
        this.signer = new DSTU4145Signer();
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String r100) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCDSTU4145PrivateKey) == false) goto L7;
        AsymmetricKeyParameter r101 = ECUtil.generatePrivateKeyParameter(r100);
        GOST3411Digest r102 = new GOST3411Digest(expandSbox(DSTU4145Params.getDefaultDKE()));
    L5:
        this.digest = r102;
    L10:
        SecureRandom r103 = ((java.security.SignatureSpi) this).appRandom;
        if (r103 == null) goto L13;
        this.signer.init(true, new ParametersWithRandom(r101, r103));
        return;
    L13:
        this.signer.init(true, r101);
        return;
    L7:
        if ((r100 instanceof ECKey) == false) goto L9;
        r101 = ECUtil.generatePrivateKeyParameter(r100);
        r102 = new GOST3411Digest(expandSbox(DSTU4145Params.getDefaultDKE()));
        goto L5
    L9:
        r101 = null;
        goto L10
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey r100) throws InvalidKeyException {
        if ((r100 instanceof BCDSTU4145PublicKey) == false) goto L5;
        BCDSTU4145PublicKey r101 = (BCDSTU4145PublicKey) r100;
        CipherParameters r102 = r101.engineGetKeyParameters();
        this.digest = new GOST3411Digest(expandSbox(r101.getSbox()));
    L6:
        this.signer.init(false, r102);
        return;
    L5:
        r102 = ECUtil.generatePublicKeyParameter(r100);
        this.digest = new GOST3411Digest(expandSbox(DSTU4145Params.getDefaultDKE()));
        goto L6
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
        BigInteger[] r101 = this.signer.generateSignature(r100);     // Catch: Exception -> L10
        byte[] r102 = r101[0].toByteArray();     // Catch: Exception -> L10
        byte[] r103 = r101[1].toByteArray();     // Catch: Exception -> L10
        if (r102.length <= r103.length) goto L7;
        int r104 = r102.length;     // Catch: Exception -> L10
    L6:
        int r105 = r104 * 2;     // Catch: Exception -> L10
        byte[] r106 = new byte[r105];     // Catch: Exception -> L10
        System.arraycopy(r103, 0, r106, (r105 / 2) - r103.length, r103.length);     // Catch: Exception -> L10
        System.arraycopy(r102, 0, r106, r105 - r102.length, r102.length);     // Catch: Exception -> L10
        return new DEROctetString(r106).getEncoded();
    L7:
        r104 = r103.length;     // Catch: Exception -> L10
    L10:
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
        byte[] r102 = ((ASN1OctetString) ASN1Primitive.fromByteArray(r100)).getOctets();     // Catch: Exception -> L6
        byte[] r103 = new byte[r102.length / 2];     // Catch: Exception -> L6
        byte[] r104 = new byte[r102.length / 2];     // Catch: Exception -> L6
        System.arraycopy(r102, 0, r104, 0, r102.length / 2);     // Catch: Exception -> L6
        System.arraycopy(r102, r102.length / 2, r103, 0, r102.length / 2);     // Catch: Exception -> L6
        BigInteger r105 = new BigInteger(1, r104);     // Catch: Exception -> L6
        return this.signer.verifySignature(r101, new BigInteger[]{new BigInteger(1, r103), r105}[0], r105);
    L7:
        throw new SignatureException("error decoding signature bytes.");
    }

    public byte[] expandSbox(byte[] r100) {
        byte[] r101 = new byte[128];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        int r103 = r102 * 2;
        r101[r103] = (byte) ((r100[r102] >> 4) & 15);
        r101[r103 + 1] = (byte) (r100[r102] & 15);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }
}
