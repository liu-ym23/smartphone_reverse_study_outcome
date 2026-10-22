package org.bouncycastle.jcajce.provider.asymmetric.rsa;

import com.alipay.sdk.m.n.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class BCRSAPublicKey implements RSAPublicKey {
    static final AlgorithmIdentifier DEFAULT_ALGORITHM_IDENTIFIER = null;
    static final long serialVersionUID = 2675817738516720772L;
    private transient AlgorithmIdentifier algorithmIdentifier;
    private BigInteger modulus;
    private BigInteger publicExponent;
    private transient RSAKeyParameters rsaPublicKey;

    static {
        DEFAULT_ALGORITHM_IDENTIFIER = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
    }

    public BCRSAPublicKey(RSAPublicKey r100) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(RSAPublicKeySpec r100) {
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        this.modulus = r100.getModulus();
        this.publicExponent = r100.getPublicExponent();
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
    }

    public BCRSAPublicKey(AlgorithmIdentifier r100, RSAKeyParameters r101) {
        this.algorithmIdentifier = r100;
        this.modulus = r101.getModulus();
        this.publicExponent = r101.getExponent();
        this.rsaPublicKey = r101;
    }

    public BCRSAPublicKey(SubjectPublicKeyInfo r100) {
        populateFromPublicKeyInfo(r100);
    }

    public BCRSAPublicKey(RSAKeyParameters r100) {
        this(DEFAULT_ALGORITHM_IDENTIFIER, r100);
    }

    private void populateFromPublicKeyInfo(SubjectPublicKeyInfo r100) {
        org.bouncycastle.asn1.pkcs.RSAPublicKey r101 = org.bouncycastle.asn1.pkcs.RSAPublicKey.getInstance(r100.parsePublicKey());     // Catch: IOException -> L4
        this.algorithmIdentifier = r100.getAlgorithm();     // Catch: IOException -> L4
        this.modulus = r101.getModulus();     // Catch: IOException -> L4
        this.publicExponent = r101.getPublicExponent();     // Catch: IOException -> L4
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);     // Catch: IOException -> L4
        return;
    L5:
        throw new IllegalArgumentException("invalid info structure in RSA public key");
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(r100.readObject());     // Catch: Exception -> L5
    L6:
        this.rsaPublicKey = new RSAKeyParameters(false, this.modulus, this.publicExponent);
        return;
    L5:
        this.algorithmIdentifier = DEFAULT_ALGORITHM_IDENTIFIER;
        goto L6
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        if (this.algorithmIdentifier.equals(DEFAULT_ALGORITHM_IDENTIFIER) == true) goto L6;
        r100.writeObject(this.algorithmIdentifier.getEncoded());
        return;
    }

    public RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPublicKey;
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
        if (this.algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS) == false) goto L6;
        return "RSASSA-PSS";
    L6:
        return d.f25615a;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return KeyUtil.getEncodedSubjectPublicKeyInfo(this.algorithmIdentifier, new org.bouncycastle.asn1.pkcs.RSAPublicKey(getModulus(), getPublicExponent()));
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
        StringBuffer r100 = new StringBuffer("RSA Public Key [");
        String r101 = Strings.lineSeparator();
        r100.append(RSAUtil.generateKeyFingerprint(getModulus()));
        r100.append("],[");
        r100.append(RSAUtil.generateExponentFingerprint(getPublicExponent()));
        r100.append("]");
        r100.append(r101);
        r100.append("        modulus: ");
        r100.append(getModulus().toString(16));
        r100.append(r101);
        r100.append("public exponent: ");
        r100.append(getPublicExponent().toString(16));
        r100.append(r101);
        return r100.toString();
    }
}
