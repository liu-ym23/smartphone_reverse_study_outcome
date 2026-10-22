package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class JCERSAPrivateCrtKey extends JCERSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    public JCERSAPrivateCrtKey(RSAPrivateCrtKey r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
        this.privateExponent = r100.getPrivateExponent();
        this.primeP = r100.getPrimeP();
        this.primeQ = r100.getPrimeQ();
        this.primeExponentP = r100.getPrimeExponentP();
        this.primeExponentQ = r100.getPrimeExponentQ();
        this.crtCoefficient = r100.getCrtCoefficient();
    }

    public JCERSAPrivateCrtKey(RSAPrivateCrtKeySpec r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
        this.privateExponent = r100.getPrivateExponent();
        this.primeP = r100.getPrimeP();
        this.primeQ = r100.getPrimeQ();
        this.primeExponentP = r100.getPrimeExponentP();
        this.primeExponentQ = r100.getPrimeExponentQ();
        this.crtCoefficient = r100.getCrtCoefficient();
    }

    public JCERSAPrivateCrtKey(PrivateKeyInfo r100) throws IOException {
        this(RSAPrivateKey.getInstance(r100.parsePrivateKey()));
    }

    public JCERSAPrivateCrtKey(RSAPrivateKey r100) {
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
        this.privateExponent = r100.getPrivateExponent();
        this.primeP = r100.getPrime1();
        this.primeQ = r100.getPrime2();
        this.primeExponentP = r100.getExponent1();
        this.primeExponentQ = r100.getExponent2();
        this.crtCoefficient = r100.getCoefficient();
    }

    public JCERSAPrivateCrtKey(RSAPrivateCrtKeyParameters r100) {
        super(r100);
        this.publicExponent = r100.getPublicExponent();
        this.primeP = r100.getP();
        this.primeQ = r100.getQ();
        this.primeExponentP = r100.getDP();
        this.primeExponentQ = r100.getDQ();
        this.crtCoefficient = r100.getQInv();
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof RSAPrivateCrtKey) == true) goto L8;
        return false;
    L8:
        RSAPrivateCrtKey r101 = (RSAPrivateCrtKey) r100;
        if (getModulus().equals(r101.getModulus()) == true) goto L11;
    L25:
        return false;
    L11:
        if (getPublicExponent().equals(r101.getPublicExponent()) == false) goto L25;
        if (getPrivateExponent().equals(r101.getPrivateExponent()) == false) goto L25;
        if (getPrimeP().equals(r101.getPrimeP()) == false) goto L25;
        if (getPrimeQ().equals(r101.getPrimeQ()) == false) goto L25;
        if (getPrimeExponentP().equals(r101.getPrimeExponentP()) == false) goto L25;
        if (getPrimeExponentQ().equals(r101.getPrimeExponentQ()) == false) goto L25;
        if (getCrtCoefficient().equals(r101.getCrtCoefficient()) == false) goto L25;
        return true;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey, java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        return this.primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        return this.primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.jce.provider.JCERSAPrivateKey
    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("RSA Private CRT Key");
        String r101 = Strings.lineSeparator();
        r100.append(r101);
        r100.append("            modulus: ");
        r100.append(getModulus().toString(16));
        r100.append(r101);
        r100.append("    public exponent: ");
        r100.append(getPublicExponent().toString(16));
        r100.append(r101);
        r100.append("   private exponent: ");
        r100.append(getPrivateExponent().toString(16));
        r100.append(r101);
        r100.append("             primeP: ");
        r100.append(getPrimeP().toString(16));
        r100.append(r101);
        r100.append("             primeQ: ");
        r100.append(getPrimeQ().toString(16));
        r100.append(r101);
        r100.append("     primeExponentP: ");
        r100.append(getPrimeExponentP().toString(16));
        r100.append(r101);
        r100.append("     primeExponentQ: ");
        r100.append(getPrimeExponentQ().toString(16));
        r100.append(r101);
        r100.append("     crtCoefficient: ");
        r100.append(getCrtCoefficient().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
