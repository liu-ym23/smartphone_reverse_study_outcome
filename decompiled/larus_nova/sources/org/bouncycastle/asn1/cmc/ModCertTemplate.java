package org.bouncycastle.asn1.cmc;

import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.CertTemplate;

/* JADX INFO: loaded from: classes42.dex */
public class ModCertTemplate extends ASN1Object {
    private final BodyPartList certReferences;
    private final CertTemplate certTemplate;
    private final BodyPartPath pkiDataReference;
    private final boolean replace;

    private ModCertTemplate(ASN1Sequence r100) {
        if (r100.size() != 4) goto L5;
    L9:
        this.pkiDataReference = BodyPartPath.getInstance(r100.getObjectAt(0));
        this.certReferences = BodyPartList.getInstance(r100.getObjectAt(1));
        if (r100.size() != 4) goto L12;
        this.replace = ASN1Boolean.getInstance(r100.getObjectAt(2)).isTrue();
        ASN1Encodable r101 = r100.getObjectAt(3);
    L13:
        this.certTemplate = CertTemplate.getInstance(r101);
        return;
    L12:
        this.replace = true;
        r101 = r100.getObjectAt(2);
        goto L13
    L5:
        if (r100.size() == 3) goto L9;
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public ModCertTemplate(BodyPartPath r100, BodyPartList r101, boolean r102, CertTemplate r103) {
        this.pkiDataReference = r100;
        this.certReferences = r101;
        this.replace = r102;
        this.certTemplate = r103;
    }

    public static ModCertTemplate getInstance(Object r100) {
        if ((r100 instanceof ModCertTemplate) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new ModCertTemplate(ASN1Sequence.getInstance(r100));
    L5:
        return (ModCertTemplate) r100;
    }

    public BodyPartList getCertReferences() {
        return this.certReferences;
    }

    public CertTemplate getCertTemplate() {
        return this.certTemplate;
    }

    public BodyPartPath getPkiDataReference() {
        return this.pkiDataReference;
    }

    public boolean isReplacingFields() {
        return this.replace;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(4);
        r100.add(this.pkiDataReference);
        r100.add(this.certReferences);
        boolean r101 = this.replace;
        if (r101 == true) goto L5;
        r100.add(ASN1Boolean.getInstance(r101));
    L5:
        r100.add(this.certTemplate);
        return new DERSequence(r100);
    }
}
