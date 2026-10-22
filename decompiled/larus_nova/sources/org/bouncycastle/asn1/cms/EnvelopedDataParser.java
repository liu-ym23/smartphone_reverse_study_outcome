package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes42.dex */
public class EnvelopedDataParser {
    private ASN1Encodable _nextObject;
    private boolean _originatorInfoCalled;
    private ASN1SequenceParser _seq;
    private ASN1Integer _version;

    public EnvelopedDataParser(ASN1SequenceParser r100) throws IOException {
        this._seq = r100;
        this._version = ASN1Integer.getInstance(r100.readObject());
    }

    public EncryptedContentInfoParser getEncryptedContentInfo() throws IOException {
        if (this._nextObject != null) goto L5;
        this._nextObject = this._seq.readObject();
    L5:
        ASN1Encodable r100 = this._nextObject;
        if (r100 == null) goto L9;
        this._nextObject = null;
        return new EncryptedContentInfoParser((ASN1SequenceParser) r100);
    L9:
        return null;
    }

    public OriginatorInfo getOriginatorInfo() throws IOException {
        this._originatorInfoCalled = true;
        if (this._nextObject != null) goto L5;
        this._nextObject = this._seq.readObject();
    L5:
        ASN1Encodable r100 = this._nextObject;
        if ((r100 instanceof ASN1TaggedObjectParser) == true) goto L8;
    L11:
        return null;
    L8:
        if (((ASN1TaggedObjectParser) r100).getTagNo() != 0) goto L11;
        ASN1SequenceParser r101 = (ASN1SequenceParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(16, false);
        this._nextObject = null;
        return OriginatorInfo.getInstance(r101.toASN1Primitive());
    }

    public ASN1SetParser getRecipientInfos() throws IOException {
        if (this._originatorInfoCalled == true) goto L6;
        getOriginatorInfo();
    L6:
        if (this._nextObject != null) goto L8;
        this._nextObject = this._seq.readObject();
    L8:
        ASN1SetParser r100 = (ASN1SetParser) this._nextObject;
        this._nextObject = null;
        return r100;
    }

    public ASN1SetParser getUnprotectedAttrs() throws IOException {
        if (this._nextObject != null) goto L5;
        this._nextObject = this._seq.readObject();
    L5:
        ASN1Encodable r100 = this._nextObject;
        if (r100 == null) goto L9;
        this._nextObject = null;
        return (ASN1SetParser) ((ASN1TaggedObjectParser) r100).getObjectParser(17, false);
    L9:
        return null;
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}
