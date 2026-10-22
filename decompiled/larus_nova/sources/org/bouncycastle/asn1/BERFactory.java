package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes42.dex */
class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = null;
    static final BERSet EMPTY_SET = null;

    static {
        EMPTY_SEQUENCE = new BERSequence();
        EMPTY_SET = new BERSet();
    }

    public BERFactory() {
    }

    public static BERSequence createSequence(ASN1EncodableVector r100) {
        if (r100.size() >= 1) goto L7;
        return EMPTY_SEQUENCE;
    L7:
        return new BERSequence(r100);
    }

    public static BERSet createSet(ASN1EncodableVector r100) {
        if (r100.size() >= 1) goto L7;
        return EMPTY_SET;
    L7:
        return new BERSet(r100);
    }
}
