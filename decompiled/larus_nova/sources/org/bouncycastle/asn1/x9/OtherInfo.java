package org.bouncycastle.asn1.x9;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class OtherInfo extends ASN1Object {
    private KeySpecificInfo keyInfo;
    private ASN1OctetString partyAInfo;
    private ASN1OctetString suppPubInfo;

    private OtherInfo(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.keyInfo = KeySpecificInfo.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L11;
        ASN1TaggedObject r102 = (ASN1TaggedObject) r101.nextElement();
        if (r102.getTagNo() == 0) goto L7;
        if (r102.getTagNo() != 2) goto L4;
        this.suppPubInfo = (ASN1OctetString) r102.getObject();
        goto L4
    L7:
        this.partyAInfo = (ASN1OctetString) r102.getObject();
        goto L4
    }

    public OtherInfo(KeySpecificInfo r100, ASN1OctetString r101, ASN1OctetString r102) {
        this.keyInfo = r100;
        this.partyAInfo = r101;
        this.suppPubInfo = r102;
    }

    public static OtherInfo getInstance(Object r100) {
        if ((r100 instanceof OtherInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new OtherInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (OtherInfo) r100;
    }

    public KeySpecificInfo getKeyInfo() {
        return this.keyInfo;
    }

    public ASN1OctetString getPartyAInfo() {
        return this.partyAInfo;
    }

    public ASN1OctetString getSuppPubInfo() {
        return this.suppPubInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.keyInfo);
        ASN1OctetString r101 = this.partyAInfo;
        if (r101 == null) goto L5;
        r100.add(new DERTaggedObject(0, r101));
    L5:
        r100.add(new DERTaggedObject(2, this.suppPubInfo));
        return new DERSequence(r100);
    }
}
