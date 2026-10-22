package org.bouncycastle.jce.provider;

import com.alipay.sdk.m.n.d;
import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class JCERSAPublicKey implements RSAPublicKey {
    static final long serialVersionUID = 2675817738516720772L;
    private BigInteger modulus;
    private BigInteger publicExponent;

    public JCERSAPublicKey(RSAPublicKey r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
    }

    public JCERSAPublicKey(RSAPublicKeySpec r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
    }

    public JCERSAPublicKey(SubjectPublicKeyInfo r100) {
        org.bouncycastle.asn1.pkcs.RSAPublicKey r101 = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(r100.parsePublicKey());     // Catch: IOException -> L5
        this.modulus = r101.getModulus();     // Catch: IOException -> L5
        this.publicExponent = r101.getPublicExponent();     // Catch: IOException -> L5
        return;
    L6:
        throw new IllegalArgumentException("invalid info structure in RSA public key");
    }

    public JCERSAPublicKey(RSAKeyParameters r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getExponent();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RSAPublicKey) == true) goto L8;
        return false;
    L8:
        RSAPublicKey r101 = (RSAPublicKey) r100;
        if (getModulus().equals(r101.getModulus()) == true) goto L11;
    L13:
        return false;
    L11:
        if (getPublicExponent().equals(r101.getPublicExponent()) == false) goto L13;
        return true;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return d.f25615a;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.modulus;
    }

    @Override // java.security.interfaces.RSAPublicKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int hashCode() {
        return getModulus().hashCode() ^ getPublicExponent().hashCode();
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("RSA Public Key");
        String r101 = Strings.lineSeparator();
        r100.append(r101);
        r100.append("            modulus: ");
        r100.append(getModulus().toString(16));
        r100.append(r101);
        r100.append("    public exponent: ");
        r100.append(getPublicExponent().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
