package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1ParsingException;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes42.dex */
public class AuthEnvelopedDataParser {
    private EncryptedContentInfoParser authEncryptedContentInfoParser;
    private ASN1Encodable nextObject;
    private boolean originatorInfoCalled;
    private ASN1SequenceParser seq;
    private ASN1Integer version;

    public AuthEnvelopedDataParser(ASN1SequenceParser r100) throws IOException {
        this.seq = r100;
        ASN1Integer r101 = ASN1Integer.getInstance(r100.readObject());
        this.version = r101;
        if (r101.intValueExact() != 0) goto L6;
        return;
    L6:
        throw new ASN1ParsingException("AuthEnvelopedData version number must be 0");
    }

    public ASN1SetParser getAuthAttrs() throws IOException {
        if (this.nextObject != null) goto L5;
        this.nextObject = this.seq.readObject();
    L5:
        ASN1Encodable r100 = this.nextObject;
        if ((r100 instanceof ASN1TaggedObjectParser) == false) goto L10;
        this.nextObject = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) r100).getObjectParser(17, false);
    L10:
        if (this.authEncryptedContentInfoParser.getContentType().equals(CMSObjectIdentifiers.data) == false) goto L13;
        return null;
    L13:
        throw new ASN1ParsingException("authAttrs must be present with non-data content");
    }

    public EncryptedContentInfoParser getAuthEncryptedContentInfo() throws IOException {
        if (this.nextObject != null) goto L5;
        this.nextObject = this.seq.readObject();
    L5:
        ASN1Encodable r100 = this.nextObject;
        if (r100 == null) goto L9;
        this.nextObject = null;
        EncryptedContentInfoParser r101 = new EncryptedContentInfoParser((ASN1SequenceParser) r100);
        this.authEncryptedContentInfoParser = r101;
        return r101;
    L9:
        return null;
    }

    public ASN1OctetString getMac() throws IOException {
        if (this.nextObject != null) goto L5;
        this.nextObject = this.seq.readObject();
    L5:
        ASN1Encodable r100 = this.nextObject;
        this.nextObject = null;
        return ASN1OctetString.getInstance(r100.toASN1Primitive());
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this.originatorInfoCalled = true;
        if (this.nextObject != null) goto L5;
        this.nextObject = this.seq.readObject();
    L5:
        ASN1Encodable r100 = this.nextObject;
        if ((r100 instanceof ASN1TaggedObjectParser) == true) goto L8;
    L11:
        return null;
    L8:
        if (((ASN1TaggedObjectParser) r100).getTagNo() != 0) goto L11;
        ASN1SequenceParser r101 = (ASN1SequenceParser) ((ASN1TaggedObjectParser) this.nextObject).getObjectParser(16, false);
        this.nextObject = null;
        return OriginatorInfo.getInstance(r101.toASN1Primitive());
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if (this.originatorInfoCalled == true) goto L6;
        getOriginatorInfo();
    L6:
        if (this.nextObject != null) goto L8;
        this.nextObject = this.seq.readObject();
    L8:
        ASN1SetParser r100 = (ASN1SetParser) this.nextObject;
        this.nextObject = null;
        return r100;
    }

    public ASN1SetParser getUnauthAttrs() throws IOException {
        if (this.nextObject != null) goto L5;
        this.nextObject = this.seq.readObject();
    L5:
        ASN1Encodable r100 = this.nextObject;
        if (r100 == null) goto L9;
        this.nextObject = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) r100).getObjectParser(17, false);
    L9:
        return null;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }
}
