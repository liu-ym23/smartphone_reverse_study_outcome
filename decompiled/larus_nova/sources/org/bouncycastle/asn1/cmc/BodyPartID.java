package org.bouncycastle.asn1.cmc;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

/* JADX INFO: loaded from: classes42.dex */
public class BodyPartID extends ASN1Object {
    public static final long bodyIdMax = 4294967295L;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final long f525025id;

    public BodyPartID(long r100) {
        if (r100 < 0) goto L9;
        if (r100 > bodyIdMax) goto L9;
        this.f525025id = r100;
        return;
    L9:
        throw new IllegalArgumentException("id out of range");
    }

    private BodyPartID(ASN1Integer r100) {
        this(convert(r100.getValue()));
    }

    private static long convert(BigInteger r100) {
        if (r100.bitLength() > 32) goto L7;
        return r100.longValue();
    L7:
        throw new IllegalArgumentException("id out of range");
    }

    public static BodyPartID getInstance(Object r100) {
        if ((r100 instanceof BodyPartID) == true) goto L5;
        if (r100 != null) goto L8;
        return null;
    L8:
        return new BodyPartID(ASN1Integer.getInstance(r100));
    L5:
        return (BodyPartID) r100;
    }

    public long getID() {
        return this.f525025id;
    }

    @Override // org.bouncycastle.asn1.ASN1Object, org.bouncycastle.asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f525025id);
    }
}
