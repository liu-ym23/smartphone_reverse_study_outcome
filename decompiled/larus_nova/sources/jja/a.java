package jja;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f499366a;

    public final String toString() {
        return "(" + Float.intBitsToFloat((int) (this.f499366a >> 32)) + ", " + Float.intBitsToFloat((int) (this.f499366a & BodyPartID.bodyIdMax)) + ')';
    }

    public a(float r100, float r101) {
        long r102 = Float.floatToRawIntBits(r100);
        this.f499366a = (((long) Float.floatToRawIntBits(r101)) & BodyPartID.bodyIdMax) | (r102 << 32);
    }
}
