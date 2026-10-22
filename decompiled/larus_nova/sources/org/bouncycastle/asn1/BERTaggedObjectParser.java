package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    private boolean _constructed;
    private ASN1StreamParser _parser;
    private int _tagNumber;

    public BERTaggedObjectParser(boolean r100, int r101, ASN1StreamParser r102) {
        this._constructed = r100;
        this._tagNumber = r101;
        this._parser = r102;
    }

    @Override // org.bouncycastle.asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.readTaggedObject(this._constructed, this._tagNumber);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public ASN1Encodable getObjectParser(int r100, boolean r101) throws IOException {
        if (r101 == false) goto L10;
        if (this._constructed == false) goto L8;
        return this._parser.readObject();
    L8:
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    L10:
        return this._parser.readImplicit(this._constructed, r100);
    }

    @Override // org.bouncycastle.asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this._tagNumber;
    }

    public boolean isConstructed() {
        return this._constructed;
    }

    @Override // org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return getLoadedObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException(e.getMessage());
    }
}
