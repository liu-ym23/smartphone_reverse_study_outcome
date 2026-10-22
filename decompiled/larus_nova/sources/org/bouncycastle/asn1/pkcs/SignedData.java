package org.bouncycastle.asn1.pkcs;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class SignedData extends ASN1Object implements PKCSObjectIdentifiers {
    private ASN1Set certificates;
    private ContentInfo contentInfo;
    private ASN1Set crls;
    private ASN1Set digestAlgorithms;
    private ASN1Set signerInfos;
    private ASN1Integer version;

    public SignedData(ASN1Integer r100, ASN1Set r101, ContentInfo r102, ASN1Set r103, ASN1Set r104, ASN1Set r105) {
        this.version = r100;
        this.digestAlgorithms = r101;
        this.contentInfo = r102;
        this.certificates = r103;
        this.crls = r104;
        this.signerInfos = r105;
    }

    public SignedData(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.version = (ASN1Integer) r101.nextElement();
        this.digestAlgorithms = (ASN1Set) r101.nextElement();
        this.contentInfo = ContentInfo.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L16;
        ASN1Primitive r102 = (ASN1Primitive) r101.nextElement();
        if ((r102 instanceof ASN1TaggedObject) == true) goto L7;
        this.signerInfos = (ASN1Set) r102;
        goto L4
    L7:
        ASN1TaggedObject r103 = (ASN1TaggedObject) r102;
        int r104 = r103.getTagNo();
        if (r104 != 0) goto L10;
        this.certificates = ASN1Set.getInstance(r103, false);
        goto L4
    L10:
        if (r104 != 1) goto L13;
        this.crls = ASN1Set.getInstance(r103, false);
        goto L4
    L13:
        throw new IllegalArgumentException("unknown tag value " + r103.getTagNo());
    }

    public static SignedData getInstance(Object r100) {
        if ((r100 instanceof SignedData) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SignedData(ASN1Sequence.getInstance(r100));
    L5:
        return (SignedData) r100;
    }

    public ASN1Set getCRLs() {
        return this.crls;
    }

    public ASN1Set getCertificates() {
        return this.certificates;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public ASN1Set getDigestAlgorithms() {
        return this.digestAlgorithms;
    }

    public ASN1Set getSignerInfos() {
        return this.signerInfos;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(6);
        r100.add(this.version);
        r100.add(this.digestAlgorithms);
        r100.add(this.contentInfo);
        ASN1Set r101 = this.certificates;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(false, 0, r101));
    L5:
        ASN1Set r102 = this.crls;
        if (r102 == null) goto L8;
        r100.add(new DERTaggedObject(false, 1, r102));
    L8:
        r100.add(this.signerInfos);
        return new BERSequence(r100);
    }
}
