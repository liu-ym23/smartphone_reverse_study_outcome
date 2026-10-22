package org.bouncycastle.asn1.x509.qualified;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class TypeOfBiometricData extends ASN1Object implements ASN1Choice {
    public static final int HANDWRITTEN_SIGNATURE = 1;
    public static final int PICTURE = 0;
    ASN1Encodable obj;

    public TypeOfBiometricData(int r100) {
        if (r100 != 0) goto L5;
    L9:
        this.obj = new ASN1Integer(r100);
        return;
    L5:
        if (r100 == 1) goto L9;
        throw new IllegalArgumentException("unknow PredefinedBiometricType : " + r100);
    }

    public TypeOfBiometricData(ASN1ObjectIdentifier r100) {
        this.obj = r100;
    }

    public static TypeOfBiometricData getInstance(Object r100) {
        if (r100 == null) goto L17;
        if ((r100 instanceof TypeOfBiometricData) == true) goto L17;
        if ((r100 instanceof ASN1Integer) == false) goto L11;
        return new TypeOfBiometricData(ASN1Integer.getInstance(r100).intValueExact());
    L11:
        if ((r100 instanceof ASN1ObjectIdentifier) == false) goto L15;
        return new TypeOfBiometricData(ASN1ObjectIdentifier.getInstance(r100));
    L15:
        throw new IllegalArgumentException("unknown object in getInstance");
    L17:
        return (TypeOfBiometricData) r100;
    }

    public ASN1ObjectIdentifier getBiometricDataOid() {
        return (ASN1ObjectIdentifier) this.obj;
    }

    public int getPredefinedBiometricType() {
        return ((ASN1Integer) this.obj).intValueExact();
    }

    public boolean isPredefined() {
        return this.obj instanceof ASN1Integer;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.obj.toASN1Primitive();
    }
}
