package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

/* JADX INFO: loaded from: classes42.dex */
public class DHPublicKey extends ASN1Object {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ASN1Integer f525089y;

    public DHPublicKey(BigInteger r100) {
        if (r100 == null) goto L7;
        this.f525089y = new ASN1Integer(r100);
        return;
    L7:
        throw new IllegalArgumentException("'y' cannot be null");
    }

    private DHPublicKey(ASN1Integer r100) {
        if (r100 == null) goto L7;
        this.f525089y = r100;
        return;
    L7:
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public static DHPublicKey getInstance(Object r100) {
        if (r100 == null) goto L13;
        if ((r100 instanceof DHPublicKey) == true) goto L13;
        if ((r100 instanceof ASN1Integer) == false) goto L11;
        return new DHPublicKey((ASN1Integer) r100);
    L11:
        throw new IllegalArgumentException("Invalid DHPublicKey: ".concat(r100.getClass().getName()));
    L13:
        return (DHPublicKey) r100;
    }

    public static DHPublicKey getInstance(ASN1TaggedObject r100, boolean r101) {
        return getInstance(ASN1Integer.getInstance(r100, r101));
    }

    public BigInteger getY() {
        return this.f525089y.getPositiveValue();
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f525089y;
    }
}
