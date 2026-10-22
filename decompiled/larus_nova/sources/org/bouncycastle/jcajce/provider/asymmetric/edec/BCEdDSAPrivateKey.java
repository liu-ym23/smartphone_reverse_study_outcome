package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed448PrivateKeyParameters;
import org.bouncycastle.crypto.util.PrivateKeyInfoFactory;
import org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Properties;

/* JADX INFO: loaded from: classes42.dex */
public class BCEdDSAPrivateKey implements EdDSAPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    transient AsymmetricKeyParameter eddsaPrivateKey;
    private final boolean hasPublicKey;

    public BCEdDSAPrivateKey(PrivateKeyInfo r100) throws IOException {
        this.hasPublicKey = r100.hasPublicKey();
        if (r100.getAttributes() == null) goto L5;
        byte[] r101 = r100.getAttributes().getEncoded();
    L6:
        this.attributes = r101;
        populateFromPrivateKeyInfo(r100);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public BCEdDSAPrivateKey(AsymmetricKeyParameter r100) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.eddsaPrivateKey = r100;
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo r100) throws IOException {
        ASN1Encodable r101 = r100.parsePrivateKey();
        if (EdECObjectIdentifiers.id_Ed448.equals(r100.getPrivateKeyAlgorithm().getAlgorithm()) == false) goto L5;
        AsymmetricKeyParameter r102 = new Ed448PrivateKeyParameters(ASN1OctetString.getInstance(r101).getOctets(), 0);
    L6:
        this.eddsaPrivateKey = r102;
        return;
    L5:
        r102 = new Ed25519PrivateKeyParameters(ASN1OctetString.getInstance(r101).getOctets(), 0);
        goto L6
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        populateFromPrivateKeyInfo(PrivateKeyInfo.getInstance((byte[]) r100.readObject()));
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(getEncoded());
    }

    public AsymmetricKeyParameter engineGetKeyParameters() {
        return this.eddsaPrivateKey;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PrivateKey) == true) goto L10;
        return false;
    L10:
        return Arrays.areEqual(((PrivateKey) r100).getEncoded(), getEncoded());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if ((this.eddsaPrivateKey instanceof Ed448PrivateKeyParameters) == false) goto L5;
        return EdDSAParameterSpec.Ed448;
    L5:
        return EdDSAParameterSpec.Ed25519;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1Set r100 = ASN1Set.getInstance(this.attributes);     // Catch: IOException -> L10
        PrivateKeyInfo r101 = PrivateKeyInfoFactory.createPrivateKeyInfo(this.eddsaPrivateKey, r100);     // Catch: IOException -> L10
        if (this.hasPublicKey == false) goto L9;
        if (Properties.isOverrideSet("org.bouncycastle.pkcs8.v1_info_only") == true) goto L9;
        return r101.getEncoded();
    L9:
        return new PrivateKeyInfo(r101.getPrivateKeyAlgorithm(), r101.parsePrivateKey(), r100).getEncoded();
    L10:
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.jcajce.interfaces.EdDSAPrivateKey
    public EdDSAPublicKey getPublicKey() {
        AsymmetricKeyParameter r100 = this.eddsaPrivateKey;
        if ((r100 instanceof Ed448PrivateKeyParameters) == false) goto L7;
        return new BCEdDSAPublicKey(((Ed448PrivateKeyParameters) r100).generatePublicKey());
    L7:
        return new BCEdDSAPublicKey(((Ed25519PrivateKeyParameters) r100).generatePublicKey());
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        AsymmetricKeyParameter r100 = this.eddsaPrivateKey;
        if ((r100 instanceof Ed448PrivateKeyParameters) == false) goto L5;
        AsymmetricKeyParameter r101 = ((Ed448PrivateKeyParameters) r100).generatePublicKey();
    L7:
        return Utils.keyToString("Private Key", getAlgorithm(), r101);
    L5:
        r101 = ((Ed25519PrivateKeyParameters) r100).generatePublicKey();
        goto L7
    }
}
