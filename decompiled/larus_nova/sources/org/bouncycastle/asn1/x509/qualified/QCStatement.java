package org.bouncycastle.asn1.x509.qualified;

import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class QCStatement extends ASN1Object implements ETSIQCObjectIdentifiers, RFC3739QCObjectIdentifiers {
    ASN1ObjectIdentifier qcStatementId;
    ASN1Encodable qcStatementInfo;

    public QCStatement(ASN1ObjectIdentifier r100) {
        this.qcStatementId = r100;
        this.qcStatementInfo = null;
    }

    public QCStatement(ASN1ObjectIdentifier r100, ASN1Encodable r101) {
        this.qcStatementId = r100;
        this.qcStatementInfo = r101;
    }

    private QCStatement(ASN1Sequence r100) {
        Enumeration r101 = r100.getObjects();
        this.qcStatementId = ASN1ObjectIdentifier.getInstance(r101.nextElement());
        if (r101.hasMoreElements() == false) goto L6;
        this.qcStatementInfo = (ASN1Encodable) r101.nextElement();
        return;
    }

    public static QCStatement getInstance(Object r100) {
        if ((r100 instanceof QCStatement) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new QCStatement(ASN1Sequence.getInstance(r100));
    L5:
        return (QCStatement) r100;
    }

    public ASN1ObjectIdentifier getStatementId() {
        return this.qcStatementId;
    }

    public ASN1Encodable getStatementInfo() {
        return this.qcStatementInfo;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        r100.add(this.qcStatementId);
        ASN1Encodable r101 = this.qcStatementInfo;
        if (r101 == null) goto L6;
        r100.add(r101);
    L6:
        return new DERSequence(r100);
    }
}
