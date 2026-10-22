package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;

/* JADX INFO: loaded from: classes42.dex */
public class SignedDataParser {
    private boolean _certsCalled;
    private boolean _crlsCalled;
    private Object _nextObject;
    private ASN1SequenceParser _seq;
    private ASN1Integer _version;

    private SignedDataParser(ASN1SequenceParser r100) throws IOException {
        this._seq = r100;
        this._version = (ASN1Integer) r100.readObject();
    }

    public static SignedDataParser getInstance(Object r100) throws IOException {
        if ((r100 instanceof ASN1Sequence) == false) goto L7;
        return new SignedDataParser(((ASN1Sequence) r100).parser());
    L7:
        if ((r100 instanceof ASN1SequenceParser) == false) goto L11;
        return new SignedDataParser((ASN1SequenceParser) r100);
    L11:
        throw new IOException("unknown object encountered: ".concat(r100.getClass().getName()));
    }

    public ASN1SetParser getCertificates() throws IOException {
        this._certsCalled = true;
        ASN1Encodable r100 = this._seq.readObject();
        this._nextObject = r100;
        if ((r100 instanceof ASN1TaggedObjectParser) == true) goto L5;
    L8:
        return null;
    L5:
        if (((ASN1TaggedObjectParser) r100).getTagNo() != 0) goto L8;
        ASN1SetParser r101 = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
        this._nextObject = null;
        return r101;
    }

    public ASN1SetParser getCrls() throws IOException {
        if (this._certsCalled == false) goto L15;
        this._crlsCalled = true;
        if (this._nextObject != null) goto L7;
        this._nextObject = this._seq.readObject();
    L7:
        Object r100 = this._nextObject;
        if ((r100 instanceof ASN1TaggedObjectParser) == true) goto L10;
    L13:
        return null;
    L10:
        if (((ASN1TaggedObjectParser) r100).getTagNo() != 1) goto L13;
        ASN1SetParser r101 = (ASN1SetParser) ((ASN1TaggedObjectParser) this._nextObject).getObjectParser(17, false);
        this._nextObject = null;
        return r101;
    L15:
        throw new IOException("getCerts() has not been called.");
    }

    public ASN1SetParser getDigestAlgorithms() throws IOException {
        ASN1Encodable r100 = this._seq.readObject();
        if ((r100 instanceof ASN1Set) == false) goto L7;
        return ((ASN1Set) r100).parser();
    L7:
        return (ASN1SetParser) r100;
    }

    public ContentInfoParser getEncapContentInfo() throws IOException {
        return new ContentInfoParser((ASN1SequenceParser) this._seq.readObject());
    }

    public ASN1SetParser getSignerInfos() throws IOException {
        if (this._certsCalled == false) goto L12;
        if (this._crlsCalled == false) goto L12;
        if (this._nextObject != null) goto L10;
        this._nextObject = this._seq.readObject();
    L10:
        return (ASN1SetParser) this._nextObject;
    L12:
        throw new IOException("getCerts() and/or getCrls() has not been called.");
    }

    public ASN1Integer getVersion() {
        return this._version;
    }
}
