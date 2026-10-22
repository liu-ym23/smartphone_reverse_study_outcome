package ija;

import androidx.camera.video.AudioStats;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f490148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f490149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f490150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f490151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f490152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f490153f;

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f490150c) * 31) + Float.floatToIntBits(this.f490151d)) * 31) + Float.floatToIntBits(this.f490152e)) * 31) + Float.floatToIntBits(this.f490153f);
    }

    public final String toString() {
        return "CubicBezierEasing(a=" + this.f490150c + ", b=" + this.f490151d + ", c=" + this.f490152e + ", d=" + this.f490153f + ')';
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L13;
        a r101 = (a) r100;
        if (this.f490150c != r101.f490150c) goto L13;
        if (this.f490151d != r101.f490151d) goto L13;
        if (this.f490152e != r101.f490152e) goto L13;
        if (this.f490153f != r101.f490153f) goto L13;
        return true;
    L13:
        return false;
    }

    public a(float r210, float r211, float r212, float r213) {
        this.f490150c = r210;
        this.f490151d = r211;
        this.f490152e = r212;
        this.f490153f = r213;
        float[] r100 = new float[5];
        int r101 = b.f490154a;
        Intrinsics.checkNotNullParameter(r100, "roots");
        float r102 = (r211 - 0.0f) * 3.0f;
        float r103 = (r213 - r211) * 3.0f;
        float r104 = (1.0f - r213) * 3.0f;
        double r110 = r102;
        double r111 = r103;
        double r112 = r104;
        double r113 = r111 * 2.0d;
        double r214 = (r110 - r113) + r112;
        int r105 = 0;
        if (r214 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        double r114 = -Math.sqrt((r111 * r111) - (r112 * r110));
        double r115 = (-r110) + r111;
        int r116 = b.b((float) ((-(r114 + r115)) / r214), r100, 0) + 0;
        int r117 = b.b((float) ((r114 - r115) / r214), r100, 0 + r116) + r116;
        if (r117 <= 1) goto L16;
        float r118 = r100[0];
        float r119 = r100[1];
        if (r118 <= r119) goto L10;
        r100[0] = r119;
        r100[1] = r118;
        goto L16
    L10:
        if (r118 != r119) goto L16;
        r117 = r117 - 1;
    L16:
        float r120 = (r103 - r102) * 2.0f;
        int r121 = r117 + b.b((-r120) / (((r104 - r103) * 2.0f) - r120), r100, 0 + r117);
        float r106 = Math.min(0.0f, 1.0f);
        float r107 = Math.max(0.0f, 1.0f);
    L17:
        if (r105 >= r121) goto L19;
        float r122 = r100[r105];
        float r123 = (((((((((r211 - r213) * 3.0f) + 1.0f) - 0.0f) * r122) + (((r213 - (r211 * 2.0f)) + 0.0f) * 3.0f)) * r122) + r102) * r122) + 0.0f;
        r106 = Math.min(r106, r123);
        r107 = Math.max(r107, r123);
        r105 = r105 + 1;
        goto L17
    L19:
        jja.a r108 = new jja.a(r106, r107);
        this.f490148a = Float.intBitsToFloat((int) (r108.f499366a >> 32));
        this.f490149b = Float.intBitsToFloat((int) (r108.f499366a & BodyPartID.bodyIdMax));
        return;
    L13:
        if (r111 == r112) goto L15;
        r117 = b.b((float) ((r113 - r112) / (r113 - (r112 * 2.0d))), r100, 0) + 0;
        goto L16
    L15:
        r117 = 0;
        goto L16
    }
}
