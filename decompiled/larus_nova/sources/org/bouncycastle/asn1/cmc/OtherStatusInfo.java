package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

/* JADX INFO: loaded from: classes42.dex */
public class OtherStatusInfo extends ASN1Object implements ASN1Choice {
    private final ExtendedFailInfo extendedFailInfo;
    private final CMCFailInfo failInfo;
    private final PendInfo pendInfo;

    public OtherStatusInfo(CMCFailInfo r100) {
        this(r100, null, null);
    }

    private OtherStatusInfo(CMCFailInfo r100, PendInfo r101, ExtendedFailInfo r102) {
        this.failInfo = r100;
        this.pendInfo = r101;
        this.extendedFailInfo = r102;
    }

    public OtherStatusInfo(ExtendedFailInfo r100) {
        this(null, null, r100);
    }

    public OtherStatusInfo(PendInfo r100) {
        this(null, r100, null);
    }

    public static OtherStatusInfo getInstance(Object r100) {
        if ((r100 instanceof OtherStatusInfo) == false) goto L7;
        return (OtherStatusInfo) r100;
    L7:
        if ((r100 instanceof ASN1Encodable) == false) goto L21;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1Integer) == false) goto L13;
        return new OtherStatusInfo(CMCFailInfo.getInstance(r101));
    L13:
        if ((r101 instanceof ASN1Sequence) == false) goto L28;
        if ((((ASN1Sequence) r101).getObjectAt(0) instanceof ASN1ObjectIdentifier) == false) goto L19;
        return new OtherStatusInfo(ExtendedFailInfo.getInstance(r101));
    L19:
        return new OtherStatusInfo(PendInfo.getInstance(r101));
    L28:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L21:
        if ((r100 instanceof byte[]) == false) goto L28;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L24:
        e = move-exception;
        throw new IllegalArgumentException("parsing error: " + e.getMessage());
    }

    public boolean isExtendedFailInfo() {
        if (this.extendedFailInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFailInfo() {
        if (this.failInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isPendingInfo() {
        if (this.pendInfo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        PendInfo r100 = this.pendInfo;
        if (r100 != null) goto L5;
        CMCFailInfo r101 = this.failInfo;
        if (r101 == null) goto L11;
        return r101.toASN1Primitive();
    L11:
        return this.extendedFailInfo.toASN1Primitive();
    L5:
        return r100.toASN1Primitive();
    }
}
