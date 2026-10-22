package org.bouncycastle.its.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class PsidSspRange extends ASN1Object {
    private ASN1Integer psid;
    private SspRange sspRange;

    public PsidSspRange() {
    }

    public static PsidSspRange getInstance(Object r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof PsidSspRange) == true) goto L8;
        ASN1Sequence r101 = ASN1Sequence.getInstance(r100);
        PsidSspRange r102 = new PsidSspRange();
        if (r101.size() < 1) goto L21;
        if (r101.size() > 2) goto L21;
        if (r101.size() != 1) goto L17;
        r102.psid = (ASN1Integer) r101.getObjectAt(0);
    L17:
        if (r101.size() != 2) goto L19;
        r102.sspRange = SspRange.getInstance(r101.getObjectAt(1));
    L19:
        return r102;
    L21:
        throw new IllegalStateException("expected sequences with one or optionally two items");
    L8:
        return (PsidSspRange) r100;
    }

    public ASN1Integer getPsid() {
        return this.psid;
    }

    public SspRange getSspRange() {
        return this.sspRange;
    }

    public void setPsid(ASN1Integer r100) {
        this.psid = r100;
    }

    public void setSspRange(SspRange r100) {
        this.sspRange = r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector();
        r100.add(this.psid);
        SspRange r101 = this.sspRange;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
