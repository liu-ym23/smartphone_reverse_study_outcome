package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class NoticeReference extends ASN1Object {
    private ASN1Sequence noticeNumbers;
    private DisplayText organization;

    public NoticeReference(String r100, Vector r101) {
        this(r100, convertVector(r101));
    }

    public NoticeReference(String r100, ASN1EncodableVector r101) {
        this(new DisplayText(r100), r101);
    }

    private NoticeReference(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.organization = DisplayText.getInstance(r100.getObjectAt(0));
        this.noticeNumbers = ASN1Sequence.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public NoticeReference(DisplayText r100, ASN1EncodableVector r101) {
        this.organization = r100;
        this.noticeNumbers = new DERSequence(r101);
    }

    private static ASN1EncodableVector convertVector(Vector r100) {
        ASN1EncodableVector r101 = new ASN1EncodableVector(r100.size());
        Enumeration r102 = r100.elements();
    L4:
        if (r102.hasMoreElements() == false) goto L14;
        Object r103 = r102.nextElement();
        if ((r103 instanceof BigInteger) == false) goto L9;
        ASN1Integer r104 = new ASN1Integer((BigInteger) r103);
    L11:
        r101.add(r104);
        goto L4
    L9:
        if ((r103 instanceof Integer) == false) goto L13;
        r104 = new ASN1Integer(((Integer) r103).intValue());
        goto L11
    L13:
        throw new IllegalArgumentException();
    L14:
        return r101;
    }

    public static NoticeReference getInstance(Object r100) {
        if ((r100 instanceof NoticeReference) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new NoticeReference(ASN1Sequence.getInstance(r100));
    L5:
        return (NoticeReference) r100;
    }

    public ASN1Integer[] getNoticeNumbers() {
        ASN1Integer[] r100 = new ASN1Integer[this.noticeNumbers.size()];
        int r101 = 0;
    L4:
        if (r101 == this.noticeNumbers.size()) goto L6;
        r100[r101] = ASN1Integer.getInstance(this.noticeNumbers.getObjectAt(r101));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public DisplayText getOrganization() {
        return this.organization;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.organization);
        r100.add(this.noticeNumbers);
        return new DERSequence(r100);
    }
}
