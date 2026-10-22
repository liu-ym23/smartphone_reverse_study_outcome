package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class UserNotice extends ASN1Object {
    private final DisplayText explicitText;
    private final NoticeReference noticeRef;

    private UserNotice(ASN1Sequence r100) {
        if (r100.size() != 2) goto L6;
        this.noticeRef = NoticeReference.getInstance(r100.getObjectAt(0));
        this.explicitText = DisplayText.getInstance(r100.getObjectAt(1));
        return;
    L6:
        if (r100.size() != 1) goto L12;
        boolean r101 = r100.getObjectAt(0).toASN1Primitive() instanceof ASN1Sequence;
        ASN1Encodable r102 = r100.getObjectAt(0);
        if (r101 == false) goto L10;
        this.noticeRef = NoticeReference.getInstance(r102);
    L14:
        this.explicitText = null;
        return;
    L10:
        this.explicitText = DisplayText.getInstance(r102);
        this.noticeRef = null;
        return;
    L12:
        if (r100.size() != 0) goto L17;
        this.noticeRef = null;
        goto L14
    L17:
        throw new IllegalArgumentException("Bad sequence size: " + r100.size());
    }

    public UserNotice(NoticeReference r100, String r101) {
        this(r100, new DisplayText(r101));
    }

    public UserNotice(NoticeReference r100, DisplayText r101) {
        this.noticeRef = r100;
        this.explicitText = r101;
    }

    public static UserNotice getInstance(Object r100) {
        if ((r100 instanceof UserNotice) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new UserNotice(ASN1Sequence.getInstance(r100));
    L5:
        return (UserNotice) r100;
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
