package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Boolean;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

/* JADX INFO: loaded from: classes42.dex */
public class BasicConstraints extends ASN1Object {
    ASN1Boolean cA;
    ASN1Integer pathLenConstraint;

    public BasicConstraints(int r100) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        this.cA = ASN1Boolean.getInstance(true);
        this.pathLenConstraint = new ASN1Integer(r100);
    }

    private BasicConstraints(ASN1Sequence r100) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (r100.size() != 0) goto L6;
        this.cA = null;
        this.pathLenConstraint = null;
        return;
    L6:
        if ((r100.getObjectAt(0) instanceof ASN1Boolean) == false) goto L8;
        this.cA = ASN1Boolean.getInstance(r100.getObjectAt(0));
    L10:
        if (r100.size() > 1) goto L12;
        return;
    L12:
        if (this.cA == null) goto L15;
        this.pathLenConstraint = ASN1Integer.getInstance(r100.getObjectAt(1));
        return;
    L15:
        throw new IllegalArgumentException("wrong sequence in constructor");
    L8:
        this.cA = null;
        this.pathLenConstraint = ASN1Integer.getInstance(r100.getObjectAt(0));
        goto L10
    }

    public BasicConstraints(boolean r100) {
        this.cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (r100 == false) goto L5;
        this.cA = ASN1Boolean.getInstance(true);
    L6:
        this.pathLenConstraint = null;
        return;
    L5:
        this.cA = null;
        goto L6
    }

    public static BasicConstraints fromExtensions(Extensions r100) {
        return getInstance(Extensions.getExtensionParsedValue(r100, Extension.basicConstraints));
    }

    public static BasicConstraints getInstance(Object r100) {
        if ((r100 instanceof BasicConstraints) == false) goto L7;
        return (BasicConstraints) r100;
    L7:
        if ((r100 instanceof X509Extension) == true) goto L9;
        if (r100 != null) goto L12;
        return null;
    L12:
        return new BasicConstraints(ASN1Sequence.getInstance(r100));
    L9:
        return getInstance(X509Extension.convertValueToObject((X509Extension) r100));
    }

    public static BasicConstraints getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Sequence.getInstance(r100, r101));
    }

    public BigInteger getPathLenConstraint() {
        ASN1Integer r100 = this.pathLenConstraint;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getValue();
    }

    public boolean isCA() {
        ASN1Boolean r100 = this.cA;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isTrue() == false) goto L7;
        return true;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector r100 = new ASN1EncodableVector(2);
        ASN1Boolean r101 = this.cA;
        if (r101 == null) goto L5;
        r100.add(r101);
    L5:
        ASN1Integer r102 = this.pathLenConstraint;
        if (r102 == null) goto L9;
        r100.add(r102);
    L9:
        return new DERSequence(r100);
    }

    public String toString() {
        if (this.pathLenConstraint != null) goto L7;
        StringBuilder r100 = new StringBuilder("BasicConstraints: isCa(");
        r100.append(isCA());
        r100.append(")");
    L6:
        return r100.toString();
    L7:
        r100 = new StringBuilder("BasicConstraints: isCa(");
        r100.append(isCA());
        r100.append("), pathLenConstraint = ");
        r100.append(this.pathLenConstraint.getValue());
        goto L6
    }
}
