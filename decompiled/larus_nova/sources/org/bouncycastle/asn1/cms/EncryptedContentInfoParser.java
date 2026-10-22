package org.bouncycastle.asn1.cms;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1TaggedObjectParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

/* JADX INFO: loaded from: classes42.dex */
public class EncryptedContentInfoParser {
    private AlgorithmIdentifier _contentEncryptionAlgorithm;
    private ASN1ObjectIdentifier _contentType;
    private ASN1TaggedObjectParser _encryptedContent;

    public EncryptedContentInfoParser(ASN1SequenceParser r100) throws IOException {
        this._contentType = (ASN1ObjectIdentifier) r100.readObject();
        this._contentEncryptionAlgorithm = AlgorithmIdentifier.getInstance(r100.readObject().toASN1Primitive());
        this._encryptedContent = (ASN1TaggedObjectParser) r100.readObject();
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this._contentEncryptionAlgorithm;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this._contentType;
    }

    public ASN1Encodable getEncryptedContent(int r100) throws IOException {
        return this._encryptedContent.getObjectParser(r100, false);
    }
}
