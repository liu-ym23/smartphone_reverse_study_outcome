package org.bouncycastle.asn1.est;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.Attribute;

/* JADX INFO: loaded from: classes42.dex */
public class AttrOrOID extends ASN1Object implements ASN1Choice {
    private final Attribute attribute;
    private final ASN1ObjectIdentifier oid;

    public AttrOrOID(ASN1ObjectIdentifier r100) {
        this.oid = r100;
        this.attribute = null;
    }

    public AttrOrOID(Attribute r100) {
        this.oid = null;
        this.attribute = r100;
    }

    public static AttrOrOID getInstance(Object r100) {
        if ((r100 instanceof AttrOrOID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        if ((r100 instanceof ASN1Encodable) == false) goto L18;
        ASN1Primitive r101 = ((ASN1Encodable) r100).toASN1Primitive();
        if ((r101 instanceof ASN1ObjectIdentifier) == false) goto L14;
        return new AttrOrOID(ASN1ObjectIdentifier.getInstance(r101));
    L14:
        if ((r101 instanceof ASN1Sequence) == false) goto L18;
        return new AttrOrOID(Attribute.getInstance(r101));
    L18:
        if ((r100 instanceof byte[]) == false) goto L24;
        return getInstance(ASN1Primitive.fromByteArray((byte[]) r100));
    L22:
        throw new IllegalArgumentException("unknown encoding in getInstance()");
    L24:
        throw new IllegalArgumentException("unknown object in getInstance(): ".concat(r100.getClass().getName()));
    L5:
        return (AttrOrOID) r100;
    }

    public Attribute getAttribute() {
        return this.attribute;
    }

    public ASN1ObjectIdentifier getOid() {
        return this.oid;
    }

    public boolean isOid() {
        if (this.oid == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1ObjectIdentifier r100 = this.oid;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.attribute.toASN1Primitive();
    }
}
