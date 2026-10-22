package org.bouncycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public class DERExternal extends ASN1External {
    public DERExternal(ASN1EncodableVector r100) {
        super(r100);
    }

    public DERExternal(ASN1ObjectIdentifier r100, ASN1Integer r101, ASN1Primitive r102, int r103, ASN1Primitive r104) {
        super(r100, r101, r102, r103, r104);
    }

    public DERExternal(ASN1ObjectIdentifier r100, ASN1Integer r101, ASN1Primitive r102, DERTaggedObject r110) {
        this(r100, r101, r102, r110.getTagNo(), r110.toASN1Primitive());
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream r100, boolean r101) throws IOException {
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        ASN1ObjectIdentifier r103 = this.directReference;
        if (r103 == null) goto L5;
        r102.write(r103.getEncoded(ASN1Encoding.DER));
    L5:
        ASN1Integer r104 = this.indirectReference;
        if (r104 == null) goto L8;
        r102.write(r104.getEncoded(ASN1Encoding.DER));
    L8:
        ASN1Primitive r105 = this.dataValueDescriptor;
        if (r105 == null) goto L11;
        r102.write(r105.getEncoded(ASN1Encoding.DER));
    L11:
        r102.write(new DERTaggedObject(true, this.encoding, this.externalContent).getEncoded(ASN1Encoding.DER));
        r100.writeEncoded(r101, 32, 8, r102.toByteArray());
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return getEncoded().length;
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.asn1.ASN1External, org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }
}
