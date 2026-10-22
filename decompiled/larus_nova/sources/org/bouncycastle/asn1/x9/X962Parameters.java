package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class X962Parameters extends ASN1Object implements ASN1Choice {
    private ASN1Primitive params;

    public X962Parameters(ASN1Null r100) {
        this.params = r100;
    }

    public X962Parameters(ASN1ObjectIdentifier r100) {
        this.params = r100;
    }

    private X962Parameters(ASN1Primitive r100) {
        this.params = r100;
    }

    public X962Parameters(X9ECParameters r100) {
        this.params = null;
        this.params = r100.toASN1Primitive();
    }

    public static X962Parameters getInstance(Object r100) {
        if (r100 == null) goto L20;
        if ((r100 instanceof X962Parameters) == true) goto L20;
        if ((r100 instanceof ASN1Primitive) == false) goto L11;
        return new X962Parameters((ASN1Primitive) r100);
    L11:
        if ((r100 instanceof byte[]) == false) goto L18;
        return new X962Parameters(ASN1Primitive.fromByteArray((byte[]) r100));
    L14:
        e = move-exception;
        throw new IllegalArgumentException("unable to parse encoded data: " + e.getMessage());
    L18:
        throw new IllegalArgumentException("unknown object in getInstance()");
    L20:
        return (X962Parameters) r100;
    }

    public static X962Parameters getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(r100.getObject());
    }

    public ASN1Primitive getParameters() {
        return this.params;
    }

    public boolean isImplicitlyCA() {
        return this.params instanceof ASN1Null;
    }

    public boolean isNamedCurve() {
        return this.params instanceof ASN1ObjectIdentifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.params;
    }
}
