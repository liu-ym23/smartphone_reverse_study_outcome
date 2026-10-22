package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DLSequenceParser implements ASN1SequenceParser {
    private ASN1StreamParser _parser;

    public DLSequenceParser(ASN1StreamParser r100) {
        this._parser = r100;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DLSequence(this._parser.readVector());
    }

    @Override // org.bouncycastle.asn1.ASN1SequenceParser
    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new IllegalStateException(e.getMessage());
    }
}
