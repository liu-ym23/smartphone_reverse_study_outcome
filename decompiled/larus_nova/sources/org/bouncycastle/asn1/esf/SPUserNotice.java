package org.bouncycastle.asn1.esf;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.DisplayText;
import org.bouncycastle.asn1.x509.NoticeReference;

/* JADX INFO: loaded from: classes42.dex */
public class SPUserNotice extends ASN1Object {
    private DisplayText explicitText;
    private NoticeReference noticeRef;

    private SPUserNotice(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
    L4:
        if (r101.hasMoreElements() == false) goto L19;
        ASN1Encodable r102 = (ASN1Encodable) r101.nextElement();
        if ((r102 instanceof DisplayText) == true) goto L18;
        if ((r102 instanceof ASN1String) == true) goto L18;
        if ((r102 instanceof NoticeReference) == false) goto L13;
    L17:
        this.noticeRef = NoticeReference.getInstance(r102);
        goto L4
    L13:
        if ((r102 instanceof ASN1Sequence) == true) goto L17;
        throw new IllegalArgumentException("Invalid element in 'SPUserNotice': ".concat(r102.getClass().getName()));
    L18:
        this.explicitText = DisplayText.getInstance(r102);
        goto L4
    }

    public SPUserNotice(NoticeReference r100, DisplayText r101) {
        this.noticeRef = r100;
        this.explicitText = r101;
    }

    public static SPUserNotice getInstance(Object r100) {
        if ((r100 instanceof SPUserNotice) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SPUserNotice(ASN1Sequence.getInstance(r100));
    L5:
        return (SPUserNotice) r100;
    }

    public DisplayText getExplicitText() {
        return this.explicitText;
    }

    public NoticeReference getNoticeRef() {
        return this.noticeRef;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        NoticeReference r101 = this.noticeRef;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        DisplayText r102 = this.explicitText;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }
}
