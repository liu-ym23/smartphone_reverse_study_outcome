package org.bouncycastle.asn1.dvcs;

import java.util.Date;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.cms.ContentInfo;

/* JADX INFO: loaded from: classes42.dex */
public class DVCSTime extends ASN1Object implements ASN1Choice {
    private final ASN1GeneralizedTime genTime;
    private final ContentInfo timeStampToken;

    public DVCSTime(Date r100) {
        this(new ASN1GeneralizedTime(r100));
    }

    public DVCSTime(ASN1GeneralizedTime r100) {
        this.genTime = r100;
        this.timeStampToken = null;
    }

    public DVCSTime(ContentInfo r100) {
        this.genTime = null;
        this.timeStampToken = r100;
    }

    public static DVCSTime getInstance(Object r100) {
        if ((r100 instanceof DVCSTime) == false) goto L7;
        return (DVCSTime) r100;
    L7:
        if ((r100 instanceof ASN1GeneralizedTime) == true) goto L9;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new DVCSTime(ContentInfo.getInstance(r100));
    L9:
        return new DVCSTime(ASN1GeneralizedTime.getInstance(r100));
    }

    public static DVCSTime getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public ASN1GeneralizedTime getGenTime() {
        return this.genTime;
    }

    public ContentInfo getTimeStampToken() {
        return this.timeStampToken;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1GeneralizedTime r100 = this.genTime;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.timeStampToken.toASN1Primitive();
    }

    public String toString() {
        ASN1GeneralizedTime r100 = this.genTime;
        if (r100 == null) goto L7;
        return r100.toString();
    L7:
        return this.timeStampToken.toString();
    }
}
