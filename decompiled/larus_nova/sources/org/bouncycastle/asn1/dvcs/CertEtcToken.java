package org.bouncycastle.asn1.dvcs;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.ess.ESSCertID;
import org.bouncycastle.asn1.ocsp.CertID;
import org.bouncycastle.asn1.ocsp.CertStatus;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.smime.SMIMECapabilities;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.asn1.x509.Extension;

/* JADX INFO: loaded from: classes42.dex */
public class CertEtcToken extends ASN1Object implements ASN1Choice {
    public static final int TAG_ASSERTION = 3;
    public static final int TAG_CAPABILITIES = 8;
    public static final int TAG_CERTIFICATE = 0;
    public static final int TAG_CRL = 4;
    public static final int TAG_ESSCERTID = 1;
    public static final int TAG_OCSPCERTID = 6;
    public static final int TAG_OCSPCERTSTATUS = 5;
    public static final int TAG_OCSPRESPONSE = 7;
    public static final int TAG_PKISTATUS = 2;
    private static final boolean[] explicit = null;
    private Extension extension;
    private int tagNo;
    private ASN1Encodable value;

    static {
        explicit = new boolean[]{false, true, false, true, false, true, false, false, true};
    }

    public CertEtcToken(int r100, ASN1Encodable r101) {
        this.tagNo = r100;
        this.value = r101;
    }

    private CertEtcToken(ASN1TaggedObject r100) {
        int r101 = r100.getTagNo();
        this.tagNo = r101;
        switch(r101) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        ASN1Encodable r102 = SMIMECapabilities.getInstance(r100.getObject());
    L15:
        this.value = r102;
        return;
    L7:
        r102 = OCSPResponse.getInstance(r100, false);
        goto L15
    L8:
        r102 = CertID.getInstance(r100, false);
        goto L15
    L9:
        r102 = CertStatus.getInstance(r100.getObject());
        goto L15
    L10:
        r102 = CertificateList.getInstance(r100, false);
        goto L15
    L11:
        r102 = ContentInfo.getInstance(r100.getObject());
        goto L15
    L12:
        r102 = PKIStatusInfo.getInstance(r100, false);
        goto L15
    L13:
        r102 = ESSCertID.getInstance(r100.getObject());
        goto L15
    L14:
        r102 = Certificate.getInstance(r100, false);
        goto L15
    L5:
        throw new IllegalArgumentException("Unknown tag: " + this.tagNo);
    }

    public CertEtcToken(Extension r100) {
        this.tagNo = -1;
        this.extension = r100;
    }

    public static CertEtcToken[] arrayFromSequence(ASN1Sequence r100) {
        int r101 = r100.size();
        CertEtcToken[] r102 = new CertEtcToken[r101];
        int r103 = 0;
    L3:
        if (r103 == r101) goto L5;
        r102[r103] = getInstance(r100.getObjectAt(r103));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static CertEtcToken getInstance(Object r100) {
        if ((r100 instanceof CertEtcToken) == false) goto L7;
        return (CertEtcToken) r100;
    L7:
        if ((r100 instanceof ASN1TaggedObject) == true) goto L9;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new CertEtcToken(Extension.getInstance(r100));
    L9:
        return new CertEtcToken((ASN1TaggedObject) r100);
    }

    public Extension getExtension() {
        return this.extension;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public ASN1Encodable getValue() {
        return this.value;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        Extension r100 = this.extension;
        if (r100 != null) goto L7;
        boolean[] r101 = explicit;
        int r102 = this.tagNo;
        return new DERTaggedObject(r101[r102], r102, this.value);
    L7:
        return r100.toASN1Primitive();
    }

    public String toString() {
        return "CertEtcToken {\n" + this.value + "}\n";
    }
}
