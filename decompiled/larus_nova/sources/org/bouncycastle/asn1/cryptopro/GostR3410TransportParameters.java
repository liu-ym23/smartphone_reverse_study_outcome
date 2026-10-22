package org.bouncycastle.asn1.cryptopro;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GostR3410TransportParameters extends ASN1Object {
    private final ASN1ObjectIdentifier encryptionParamSet;
    private final SubjectPublicKeyInfo ephemeralPublicKey;
    private final byte[] ukm;

    public GostR3410TransportParameters(ASN1ObjectIdentifier r100, SubjectPublicKeyInfo r101, byte[] r102) {
        this.encryptionParamSet = r100;
        this.ephemeralPublicKey = r101;
        this.ukm = Arrays.clone(r102);
    }

    private GostR3410TransportParameters(ASN1Sequence r100) {
        if (r100.size() != 2) goto L6;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.ukm = ASN1OctetString.getInstance(r100.getObjectAt(1)).getOctets();
        this.ephemeralPublicKey = null;
        return;
    L6:
        if (r100.size() != 3) goto L10;
        this.encryptionParamSet = ASN1ObjectIdentifier.getInstance(r100.getObjectAt(0));
        this.ephemeralPublicKey = SubjectPublicKeyInfo.getInstance(ASN1TaggedObject.getInstance(r100.getObjectAt(1)), false);
        this.ukm = ASN1OctetString.getInstance(r100.getObjectAt(2)).getOctets();
        return;
    L10:
        throw new IllegalArgumentException("unknown sequence length: " + r100.size());
    }

    public static GostR3410TransportParameters getInstance(Object r100) {
        if ((r100 instanceof GostR3410TransportParameters) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(r100));
    L5:
        return (GostR3410TransportParameters) r100;
    }

    public static GostR3410TransportParameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return new GostR3410TransportParameters(ASN1Sequence.getInstance(r100, r101));
    }

    public ASN1ObjectIdentifier getEncryptionParamSet() {
        return this.encryptionParamSet;
    }

    public SubjectPublicKeyInfo getEphemeralPublicKey() {
        return this.ephemeralPublicKey;
    }

    public byte[] getUkm() {
        return Arrays.clone(this.ukm);
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.encryptionParamSet);
        SubjectPublicKeyInfo r101 = this.ephemeralPublicKey;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        r100.add(new DEROctetString(this.ukm));
        return new DERSequence(r100);
    }
}
