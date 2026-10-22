package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class BCRSAPrivateCrtKey extends BCRSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;
    private BigInteger primeP;
    private BigInteger primeQ;
    private BigInteger publicExponent;

    public BCRSAPrivateCrtKey(RSAPrivateCrtKey r110) {
        super(new RSAPrivateCrtKeyParameters(r110.getModulus(), r110.getPublicExponent(), r110.getPrivateExponent(), r110.getPrimeP(), r110.getPrimeQ(), r110.getPrimeExponentP(), r110.getPrimeExponentQ(), r110.getCrtCoefficient()));
        this.modulus = r110.getModulus();
        this.publicExponent = r110.getPublicExponent();
        this.privateExponent = r110.getPrivateExponent();
        this.primeP = r110.getPrimeP();
        this.primeQ = r110.getPrimeQ();
        this.primeExponentP = r110.getPrimeExponentP();
        this.primeExponentQ = r110.getPrimeExponentQ();
        this.crtCoefficient = r110.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeySpec r110) {
        super(new RSAPrivateCrtKeyParameters(r110.getModulus(), r110.getPublicExponent(), r110.getPrivateExponent(), r110.getPrimeP(), r110.getPrimeQ(), r110.getPrimeExponentP(), r110.getPrimeExponentQ(), r110.getCrtCoefficient()));
        this.modulus = r110.getModulus();
        this.publicExponent = r110.getPublicExponent();
        this.privateExponent = r110.getPrivateExponent();
        this.primeP = r110.getPrimeP();
        this.primeQ = r110.getPrimeQ();
        this.primeExponentP = r110.getPrimeExponentP();
        this.primeExponentQ = r110.getPrimeExponentQ();
        this.crtCoefficient = r110.getCrtCoefficient();
    }

    public BCRSAPrivateCrtKey(PrivateKeyInfo r100) throws IOException {
        this(r100.getPrivateKeyAlgorithm(), RSAPrivateKey.getInstance(r100.parsePrivateKey()));
    }

    public BCRSAPrivateCrtKey(RSAPrivateKey r100) {
        this(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER, r100);
    }

    public BCRSAPrivateCrtKey(AlgorithmIdentifier r110, RSAPrivateKey r111) {
        super(r110, new RSAPrivateCrtKeyParameters(r111.getModulus(), r111.getPublicExponent(), r111.getPrivateExponent(), r111.getPrime1(), r111.getPrime2(), r111.getExponent1(), r111.getExponent2(), r111.getCoefficient()));
        this.modulus = r111.getModulus();
        this.publicExponent = r111.getPublicExponent();
        this.privateExponent = r111.getPrivateExponent();
        this.primeP = r111.getPrime1();
        this.primeQ = r111.getPrime2();
        this.primeExponentP = r111.getExponent1();
        this.primeExponentQ = r111.getExponent2();
        this.crtCoefficient = r111.getCoefficient();
    }

    public BCRSAPrivateCrtKey(AlgorithmIdentifier r100, RSAPrivateCrtKeyParameters r101) {
        super(r100, r101);
        this.publicExponent = r101.getPublicExponent();
        this.primeP = r101.getP();
        this.primeQ = r101.getQ();
        this.primeExponentP = r101.getDP();
        this.primeExponentQ = r101.getDQ();
        this.crtCoefficient = r101.getQInv();
    }

    public BCRSAPrivateCrtKey(RSAPrivateCrtKeyParameters r100) {
        super(r100);
        this.publicExponent = r100.getPublicExponent();
        this.primeP = r100.getP();
        this.primeQ = r100.getQ();
        this.primeExponentP = r100.getDP();
        this.primeExponentQ = r100.getDQ();
        this.crtCoefficient = r100.getQInv();
    }

    private void readObject(ObjectInputStream r110) throws IOException, ClassNotFoundException {
        r110.defaultReadObject();
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.rsaPrivateKey = new RSAPrivateCrtKeyParameters(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient());
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedPrivateKeyInfo(this.algorithmIdentifier, new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey, java.security.Key
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

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public int hashCode() {
        return (getModulus().hashCode() ^ getPublicExponent().hashCode()) ^ getPrivateExponent().hashCode();
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.rsa.BCRSAPrivateKey
    public String toString() {
        StringBuffer r100 = new StringBuffer("RSA Private CRT Key [");
        String r101 = Strings.lineSeparator();
        r100.append(RSAUtil.generateKeyFingerprint(getModulus()));
        r100.append("],[");
        r100.append(RSAUtil.generateExponentFingerprint(getPublicExponent()));
        r100.append("]");
        r100.append(r101);
        r100.append("             modulus: ");
        r100.append(getModulus().toString(16));
        r100.append(r101);
        r100.append("     public exponent: ");
        r100.append(getPublicExponent().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
