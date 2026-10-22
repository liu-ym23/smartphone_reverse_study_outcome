package org.bouncycastle.asn1.cmp;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class ErrorMsgContent extends ASN1Object {
    private ASN1Integer errorCode;
    private PKIFreeText errorDetails;
    private PKIStatusInfo pkiStatusInfo;

    private ErrorMsgContent(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.pkiStatusInfo = PKIStatusInfo.getInstance(r101.nextElement());
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        Object r102 = r101.nextElement();
        if ((r102 instanceof ASN1Integer) == true) goto L7;
        this.errorDetails = PKIFreeText.getInstance(r102);
        goto L4
    L7:
        this.errorCode = ASN1Integer.getInstance(r102);
        goto L4
    }

    public ErrorMsgContent(PKIStatusInfo r100) {
        this(r100, null, null);
    }

    public ErrorMsgContent(PKIStatusInfo r100, ASN1Integer r101, PKIFreeText r102) {
        if (r100 == null) goto L7;
        this.pkiStatusInfo = r100;
        this.errorCode = r101;
        this.errorDetails = r102;
        return;
    L7:
        throw new IllegalArgumentException("'pkiStatusInfo' cannot be null");
    }

    private void addOptional(ASN1EncodableVector r100, ASN1Encodable r101) {
        if (r101 == null) goto L5;
        r100.add(r101);
        return;
    }

    public static ErrorMsgContent getInstance(Object r100) {
        if ((r100 instanceof ErrorMsgContent) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ErrorMsgContent(ASN1Sequence.getInstance(r100));
    L5:
        return (ErrorMsgContent) r100;
    }

    public ASN1Integer getErrorCode() {
        return this.errorCode;
    }

    public PKIFreeText getErrorDetails() {
        return this.errorDetails;
    }

    public PKIStatusInfo getPKIStatusInfo() {
        return this.pkiStatusInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(3);
        r100.add(this.pkiStatusInfo);
        addOptional(r100, this.errorCode);
        addOptional(r100, this.errorDetails);
        return new DERSequence(r100);
    }
}
