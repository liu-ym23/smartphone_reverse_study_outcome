package org.bouncycastle.jcajce.provider.asymmetric.edec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.jcajce.interfaces.EdDSAPublicKey;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class BCEdDSAPublicKey implements EdDSAPublicKey {
    static final long serialVersionUID = 1;
    transient AsymmetricKeyParameter eddsaPublicKey;

    public BCEdDSAPublicKey(SubjectPublicKeyInfo r100) {
        populateFromPubKeyInfo(r100);
    }

    public BCEdDSAPublicKey(AsymmetricKeyParameter r100) {
        this.eddsaPublicKey = r100;
    }

    public BCEdDSAPublicKey(byte[] r100, byte[] r101) throws InvalidKeySpecException {
        int r102 = r100.length;
        if (Utils.isValidPrefix(r100, r101) == false) goto L15;
        if ((r101.length - r102) != 57) goto L9;
        AsymmetricKeyParameter r103 = new Ed448PublicKeyParameters(r101, r102);
    L7:
        this.eddsaPublicKey = r103;
        return;
    L9:
        if ((r101.length - r102) != 32) goto L13;
        r103 = new Ed25519PublicKeyParameters(r101, r102);
        goto L7
    L13:
        throw new InvalidKeySpecException("raw key data not recognised");
    L15:
        throw new InvalidKeySpecException("raw key data not recognised");
    }

    private void populateFromPubKeyInfo(SubjectPublicKeyInfo r100) {
        if (EdECObjectIdentifiers.id_Ed448.equals(r100.getAlgorithm().getAlgorithm()) == false) goto L5;
        AsymmetricKeyParameter r101 = new Ed448PublicKeyParameters(r100.getPublicKeyData().getOctets(), 0);
    L6:
        this.eddsaPublicKey = r101;
        return;
    L5:
        r101 = new Ed25519PublicKeyParameters(r100.getPublicKeyData().getOctets(), 0);
        goto L6
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        r100.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance((byte[]) r100.readObject()));
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.defaultWriteObject();
        r100.writeObject(getEncoded());
    }

    public AsymmetricKeyParameter engineGetKeyParameters() {
        return this.eddsaPublicKey;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PublicKey) == true) goto L10;
        return false;
    L10:
        return Arrays.areEqual(((PublicKey) r100).getEncoded(), getEncoded());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        if ((this.eddsaPublicKey instanceof Ed448PublicKeyParameters) == false) goto L5;
        return EdDSAParameterSpec.Ed448;
    L5:
        return EdDSAParameterSpec.Ed25519;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if ((this.eddsaPublicKey instanceof Ed448PublicKeyParameters) == false) goto L6;
        byte[] r100 = KeyFactorySpi.Ed448Prefix;
        byte[] r101 = new byte[r100.length + 57];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        ((Ed448PublicKeyParameters) this.eddsaPublicKey).encode(r101, r100.length);
        return r101;
    L6:
        byte[] r102 = KeyFactorySpi.Ed25519Prefix;
        byte[] r103 = new byte[r102.length + 32];
        System.arraycopy(r102, 0, r103, 0, r102.length);
        ((Ed25519PublicKeyParameters) this.eddsaPublicKey).encode(r103, r102.length);
        return r103;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return Arrays.hashCode(getEncoded());
    }

    public String toString() {
        return Utils.keyToString("Public Key", getAlgorithm(), this.eddsaPublicKey);
    }
}
