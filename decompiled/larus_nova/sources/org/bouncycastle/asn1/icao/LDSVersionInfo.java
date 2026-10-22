package org.bouncycastle.asn1.icao;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class LDSVersionInfo extends ASN1Object {
    private DERPrintableString ldsVersion;
    private DERPrintableString unicodeVersion;

    public LDSVersionInfo(String r100, String r101) {
        this.ldsVersion = new DERPrintableString(r100);
        this.unicodeVersion = new DERPrintableString(r101);
    }

    private LDSVersionInfo(ASN1Sequence r100) {
        if (r100.size() != 2) goto L7;
        this.ldsVersion = DERPrintableString.getInstance(r100.getObjectAt(0));
        this.unicodeVersion = DERPrintableString.getInstance(r100.getObjectAt(1));
        return;
    L7:
        throw new IllegalArgumentException("sequence wrong size for LDSVersionInfo");
    }

    public static LDSVersionInfo getInstance(Object r100) {
        if ((r100 instanceof LDSVersionInfo) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new LDSVersionInfo(ASN1Sequence.getInstance(r100));
    L5:
        return (LDSVersionInfo) r100;
    }

    public String getLdsVersion() {
        return this.ldsVersion.getString();
    }

    public String getUnicodeVersion() {
        return this.unicodeVersion.getString();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.ldsVersion);
        r100.add(this.unicodeVersion);
        return new DERSequence(r100);
    }
}
