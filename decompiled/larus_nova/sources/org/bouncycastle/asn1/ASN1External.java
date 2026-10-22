package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ASN1External extends ASN1Primitive {
    protected ASN1Primitive dataValueDescriptor;
    protected ASN1ObjectIdentifier directReference;
    protected int encoding;
    protected ASN1Primitive externalContent;
    protected ASN1Integer indirectReference;

    public ASN1External(ASN1EncodableVector r100) {
        int r101 = 0;
        ASN1Primitive r102 = getObjFromVector(r100, 0);
        if ((r102 instanceof ASN1ObjectIdentifier) == false) goto L6;
        this.directReference = (ASN1ObjectIdentifier) r102;
        r102 = getObjFromVector(r100, 1);
        r101 = 1;
    L6:
        if ((r102 instanceof ASN1Integer) == false) goto L9;
        this.indirectReference = (ASN1Integer) r102;
        r101 = r101 + 1;
        r102 = getObjFromVector(r100, r101);
    L9:
        if ((r102 instanceof ASN1TaggedObject) == true) goto L12;
        this.dataValueDescriptor = r102;
        r101 = r101 + 1;
        r102 = getObjFromVector(r100, r101);
    L12:
        if (r100.size() != (r101 + 1)) goto L20;
        if ((r102 instanceof ASN1TaggedObject) == false) goto L18;
        ASN1TaggedObject r103 = (ASN1TaggedObject) r102;
        setEncoding(r103.getTagNo());
        this.externalContent = r103.getObject();
        return;
    L18:
        throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
    L20:
        throw new IllegalArgumentException("input vector too large");
    }

    public ASN1External(ASN1ObjectIdentifier r100, ASN1Integer r101, ASN1Primitive r102, int r103, ASN1Primitive r104) {
        setDirectReference(r100);
        setIndirectReference(r101);
        setDataValueDescriptor(r102);
        setEncoding(r103);
        setExternalContent(r104.toASN1Primitive());
    }

    public ASN1External(ASN1ObjectIdentifier r100, ASN1Integer r101, ASN1Primitive r102, DERTaggedObject r110) {
        this(r100, r101, r102, r110.getTagNo(), r110.toASN1Primitive());
    }

    private ASN1Primitive getObjFromVector(ASN1EncodableVector r100, int r101) {
        if (r100.size() <= r101) goto L7;
        return r100.get(r101).toASN1Primitive();
    L7:
        throw new IllegalArgumentException("too few objects in input vector");
    }

    private void setDataValueDescriptor(ASN1Primitive r100) {
        this.dataValueDescriptor = r100;
    }

    private void setDirectReference(ASN1ObjectIdentifier r100) {
        this.directReference = r100;
    }

    private void setEncoding(int r100) {
        if (r100 < 0) goto L8;
        if (r100 > 2) goto L8;
        this.encoding = r100;
        return;
    L8:
        throw new IllegalArgumentException("invalid encoding value: " + r100);
    }

    private void setExternalContent(ASN1Primitive r100) {
        this.externalContent = r100;
    }

    private void setIndirectReference(ASN1Integer r100) {
        this.indirectReference = r100;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive r100) {
        if ((r100 instanceof ASN1External) == true) goto L5;
        return false;
    L5:
        if (this != r100) goto L8;
        return true;
    L8:
        ASN1External r101 = (ASN1External) r100;
        ASN1ObjectIdentifier r102 = this.directReference;
        if (r102 == null) goto L15;
        ASN1ObjectIdentifier r103 = r101.directReference;
        if (r103 != null) goto L13;
    L14:
        return false;
    L13:
        if (r103.equals(r102) == false) goto L14;
    L15:
        ASN1Integer r104 = this.indirectReference;
        if (r104 == null) goto L22;
        ASN1Integer r105 = r101.indirectReference;
        if (r105 != null) goto L20;
    L21:
        return false;
    L20:
        if (r105.equals(r104) == false) goto L21;
    L22:
        ASN1Primitive r106 = this.dataValueDescriptor;
        if (r106 == null) goto L30;
        ASN1Primitive r107 = r101.dataValueDescriptor;
        if (r107 != null) goto L27;
    L28:
        return false;
    L27:
        if (r107.equals(r106) == false) goto L28;
    L30:
        return this.externalContent.equals(r101.externalContent);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return getEncoded().length;
    }

    public ASN1Primitive getDataValueDescriptor() {
        return this.dataValueDescriptor;
    }

    public ASN1ObjectIdentifier getDirectReference() {
        return this.directReference;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public ASN1Primitive getExternalContent() {
        return this.externalContent;
    }

    public ASN1Integer getIndirectReference() {
        return this.indirectReference;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        ASN1ObjectIdentifier r100 = this.directReference;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        ASN1Integer r102 = this.indirectReference;
        if (r102 == null) goto L9;
        r101 = r101 ^ r102.hashCode();
    L9:
        ASN1Primitive r103 = this.dataValueDescriptor;
        if (r103 == null) goto L13;
        r101 = r101 ^ r103.hashCode();
    L13:
        return r101 ^ this.externalContent.hashCode();
    L5:
        r101 = 0;
        goto L6
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLExternal(this.directReference, this.indirectReference, this.dataValueDescriptor, this.encoding, this.externalContent);
    }
}
