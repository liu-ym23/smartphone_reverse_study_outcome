package org.bouncycastle.asn1.ocsp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extensions;

/* JADX INFO: loaded from: classes42.dex */
public class TBSRequest extends ASN1Object {
    private static final ASN1Integer V1 = null;
    Extensions requestExtensions;
    ASN1Sequence requestList;
    GeneralName requestorName;
    ASN1Integer version;
    boolean versionSet;

    static {
        V1 = new ASN1Integer(0);
    }

    private TBSRequest(ASN1Sequence r100) {
        int r101 = 0;
        if ((r100.getObjectAt(0) instanceof ASN1TaggedObject) == true) goto L5;
    L7:
        this.version = V1;
    L9:
        if ((r100.getObjectAt(r101) instanceof ASN1TaggedObject) == false) goto L11;
        int r102 = r101 + 1;
        this.requestorName = GeneralName.getInstance((ASN1TaggedObject) r100.getObjectAt(r101), true);
        r101 = r102;
    L11:
        int r103 = r101 + 1;
        this.requestList = (ASN1Sequence) r100.getObjectAt(r101);
        if (r100.size() != (r103 + 1)) goto L15;
        this.requestExtensions = Extensions.getInstance((ASN1TaggedObject) r100.getObjectAt(r103), true);
        return;
    L15:
        return;
    L5:
        if (((ASN1TaggedObject) r100.getObjectAt(0)).getTagNo() != 0) goto L7;
        this.versionSet = true;
        this.version = ASN1Integer.getInstance((ASN1TaggedObject) r100.getObjectAt(0), true);
        r101 = 1;
        goto L9
    }

    public TBSRequest(GeneralName r100, ASN1Sequence r101, Extensions r102) {
        this.version = V1;
        this.requestorName = r100;
        this.requestList = r101;
        this.requestExtensions = r102;
    }

    public TBSRequest(GeneralName r100, ASN1Sequence r101, X509Extensions r102) {
        this.version = V1;
        this.requestorName = r100;
        this.requestList = r101;
        this.requestExtensions = Extensions.getInstance(r102);
    }

    public static TBSRequest getInstance(Object r100) {
        if ((r100 instanceof TBSRequest) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new TBSRequest(ASN1Sequence.getInstance(r100));
    L5:
        return (TBSRequest) r100;
    }

    public static TBSRequest getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public Extensions getRequestExtensions() {
        return this.requestExtensions;
    }

    public ASN1Sequence getRequestList() {
        return this.requestList;
    }

    public GeneralName getRequestorName() {
        return this.requestorName;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        if (this.version.equals(V1) == true) goto L5;
    L6:
        r100.add(new DERTaggedObject(true, 0, this.version));
    L7:
        GeneralName r101 = this.requestorName;
        if (r101 == null) goto L10;
        r100.add(new DERTaggedObject(true, 1, r101));
    L10:
        r100.add(this.requestList);
        Extensions r102 = this.requestExtensions;
        if (r102 == null) goto L14;
        r100.add(new DERTaggedObject(true, 2, r102));
    L14:
        return new DERSequence(r100);
    L5:
        if (this.versionSet == false) goto L7;
        goto L6
    }
}
