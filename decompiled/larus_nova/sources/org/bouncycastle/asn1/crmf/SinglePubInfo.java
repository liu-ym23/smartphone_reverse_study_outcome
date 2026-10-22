package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.GeneralName;

/* JADX INFO: loaded from: classes42.dex */
public class SinglePubInfo extends ASN1Object {
    public static final ASN1Integer dontCare = null;
    public static final ASN1Integer ldap = null;

    /* JADX INFO: renamed from: web, reason: collision with root package name */
    public static final ASN1Integer f525032web = null;
    public static final ASN1Integer x500 = null;
    private GeneralName pubLocation;
    private ASN1Integer pubMethod;

    static {
        dontCare = new ASN1Integer(0);
        x500 = new ASN1Integer(1);
        f525032web = new ASN1Integer(2);
        ldap = new ASN1Integer(3);
    }

    public SinglePubInfo(ASN1Integer r100, GeneralName r101) {
        this.pubMethod = r100;
        this.pubLocation = r101;
    }

    private SinglePubInfo(ASN1Sequence r100) {
        this.pubMethod = ASN1Integer.getInstance(r100.getObjectAt(0));
        if (r100.size() != 2) goto L6;
        this.pubLocation = GeneralName.getInstance(r100.getObjectAt(1));
        return;
    }

    public static SinglePubInfo getInstance(Object r100) {
        if ((r100 instanceof SinglePubInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new SinglePubInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (SinglePubInfo) r100;
    }

    public GeneralName getPubLocation() {
        return this.pubLocation;
    }

    public ASN1Integer getPubMethod() {
        return this.pubMethod;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.pubMethod);
        GeneralName r101 = this.pubLocation;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
