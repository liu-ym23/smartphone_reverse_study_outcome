package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DERExternalParser implements ASN1Encodable, InMemoryRepresentable {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser r100) {
        this._parser = r100;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return new DLExternal(this._parser.readVector());
    L4:
        e = move-exception;
        throw new ASN1Exception(e.getMessage(), e);
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L8:
        e = move-exception;
        throw new ASN1ParsingException("unable to get DER object", e);
    L5:
        e = move-exception;
        throw new ASN1ParsingException("unable to get DER object", e);
    }
}
