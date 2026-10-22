package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes42.dex */
class DERFactory {
    static final ASN1Sequence EMPTY_SEQUENCE = null;
    static final ASN1Set EMPTY_SET = null;

    static {
        EMPTY_SEQUENCE = new DERSequence();
        EMPTY_SET = new DERSet();
    }

    public DERFactory() {
    }

    public static ASN1Sequence createSequence(ASN1EncodableVector r100) {
        if (r100.size() >= 1) goto L7;
        return EMPTY_SEQUENCE;
    L7:
        return new DERSequence(r100);
    }

    public static ASN1Set createSet(ASN1EncodableVector r100) {
        if (r100.size() >= 1) goto L7;
        return EMPTY_SET;
    L7:
        return new DERSet(r100);
    }
}
