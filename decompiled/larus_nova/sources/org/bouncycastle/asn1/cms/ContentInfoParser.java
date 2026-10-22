package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes42.dex */
public class ContentInfoParser {
    private ASN1TaggedObjectParser content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfoParser(ASN1SequenceParser r100) throws IOException {
        this.contentType = (ASN1ObjectIdentifier) r100.readObject();
        this.content = (ASN1TaggedObjectParser) r100.readObject();
    }

    public ASN1Encodable getContent(int r100) throws IOException {
        ASN1TaggedObjectParser r101 = this.content;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getObjectParser(r100, true);
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }
}
