package lja;

import android.graphics.Path;
import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f509525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f509526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f509527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f509528f;

    @Override // lja.d
    public final boolean c(float r100, float r101) {
        if (r100 != (r101 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public f() {
        this.f509525c = "QuadraticSmoothCornerExImpl";
        this.f509526d = 0.585786f;
        this.f509527e = 0.292893f;
        this.f509528f = 1.175f;
    }

    @Override // lja.d
    public String getType() {
        return this.f509525c;
    }

    @Override // lja.d
    public final Path a(float r110, float r111, float r112, float r113, float r114) {
        float r100 = r112 - r110;
        float r101 = r113 - r111;
        float r102 = Math.min(r100, r101);
        float r103 = Math.max(r100, r101);
        if (r114 == 0.0f) goto L22;
        float r104 = r102 * 0.5f;
        if (r114 != r104) goto L22;
        if (r114 != r104) goto L13;
        if (r100 != r101) goto L13;
        return d.b(r110, r111, r112, r113, r114);
    L13:
        if (r100 <= r101) goto L15;
        boolean r105 = true;
    L16:
        float r115 = RangesKt.coerceAtMost(r114, r104);
        float r106 = Math.min(this.f509528f * r115, r103 * 0.5f);
        if (r105 == false) goto L19;
        float r107 = this.f509526d * r115;
        float r108 = this.f509527e * r115;
        float r109 = r110 + r106;
        float r116 = r115 * 2.0f;
        RectF r117 = new RectF(r110, r111, r110 + r116, r113);
        RectF r118 = new RectF(r112 - r116, r111, r112, r113);
        float r119 = r112 - r106;
        float r120 = r112 - r107;
        float r121 = r112 - r108;
        float r122 = r111 + r108;
        float r123 = r113 - r108;
        float r124 = r107 + r110;
        float r125 = r110 + r108;
        Path r126 = new Path();
        r126.moveTo(r109, r111);
        r126.lineTo(r119, r111);
        r126.quadTo(r120, r111, r121, r122);
        r126.arcTo(r118, -45.0f, 90.0f);
        r126.quadTo(r120, r113, r119, r113);
        r126.lineTo(r109, r113);
        r126.quadTo(r124, r113, r125, r123);
        r126.arcTo(r117, 135.0f, 90.0f);
        r126.quadTo(r124, r111, r109, r111);
        r126.close();
        return r126;
    L19:
        float r127 = this.f509526d * r115;
        float r128 = this.f509527e * r115;
        float r129 = r111 + r106;
        float r130 = r115 * 2.0f;
        RectF r131 = new RectF(r110, r111, r112, r111 + r130);
        RectF r132 = new RectF(r110, r113 - r130, r112, r113);
        float r133 = r113 - r106;
        float r134 = r113 - r127;
        float r135 = r112 - r128;
        float r136 = r113 - r128;
        float r137 = r110 + r128;
        float r138 = r127 + r111;
        float r139 = r111 + r128;
        Path r140 = new Path();
        r140.moveTo(r112, r129);
        r140.lineTo(r112, r133);
        r140.quadTo(r112, r134, r135, r136);
        r140.arcTo(r132, 45.0f, 90.0f);
        r140.quadTo(r110, r134, r110, r133);
        r140.lineTo(r110, r129);
        r140.quadTo(r110, r138, r137, r139);
        r140.arcTo(r131, 225.0f, 90.0f);
        r140.quadTo(r112, r138, r112, r129);
        r140.close();
        return r140;
    L15:
        r105 = false;
    L22:
        return d.b(r110, r111, r112, r113, r114);
    }
}
