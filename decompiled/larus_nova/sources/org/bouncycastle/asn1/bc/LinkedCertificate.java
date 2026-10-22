package org.bouncycastle.asn1.bc;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;

/* JADX INFO: loaded from: classes42.dex */
public class LinkedCertificate extends ASN1Object {
    private GeneralNames cACerts;
    private X500Name certIssuer;
    private final GeneralName certLocation;
    private final DigestInfo digest;

    private LinkedCertificate(ASN1Sequence r100) {
        this.digest = DigestInfo.getInstance(r100.getObjectAt(0));
        this.certLocation = GeneralName.getInstance(r100.getObjectAt(1));
        int r101 = 2;
        if (r100.size() > 2) goto L5;
        return;
    L5:
        if (r101 == r100.size()) goto L19;
        ASN1TaggedObject r102 = ASN1TaggedObject.getInstance(r100.getObjectAt(r101));
        int r103 = r102.getTagNo();
        if (r103 == 0) goto L12;
        if (r103 != 1) goto L11;
        this.cACerts = GeneralNames.getInstance(r102, false);
    L13:
        r101 = r101 + 1;
        goto L5
    L11:
        throw new IllegalArgumentException("unknown tag in tagged field");
    L12:
        this.certIssuer = X500Name.getInstance(r102, false);
        goto L13
    }

    public LinkedCertificate(DigestInfo r100, GeneralName r101) {
        this(r100, r101, null, null);
    }

    public LinkedCertificate(DigestInfo r100, GeneralName r101, X500Name r102, GeneralNames r103) {
        this.digest = r100;
        this.certLocation = r101;
        this.certIssuer = r102;
        this.cACerts = r103;
    }

    public static LinkedCertificate getInstance(Object r100) {
        if ((r100 instanceof LinkedCertificate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LinkedCertificate(ASN1Sequence.getInstance(r100));
    L5:
        return (LinkedCertificate) r100;
    }

    public GeneralNames getCACerts() {
        return this.cACerts;
    }

    public X500Name getCertIssuer() {
        return this.certIssuer;
    }

    public GeneralName getCertLocation() {
        return this.certLocation;
    }

    public DigestInfo getDigest() {
        return this.digest;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.digest);
        r100.add(this.certLocation);
        X500Name r101 = this.certIssuer;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        GeneralNames r102 = this.cACerts;
        if (r102 == null) goto L9;
        r100.add(new DERTaggedObject(false, 1, r102));
    L9:
        return new DERSequence(r100);
    }
}
