package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: classes33.dex */
public final class h extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f509532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f509533d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f509534e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f509535f;

    @Override // lja.d
    public final boolean c(float r100, float r101) {
        if (r100 >= (r101 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public h() {
        this.f509532c = 128.19f;
        this.f509533d = 83.62f;
        this.f509534e = new b();
        this.f509535f = "SketchSmoothCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.f509535f;
    }

    @Override // lja.d
    public final Path a(float r410, float r411, float r412, float r413, float r414) {
        Path r110 = new Path();
        float r100 = r412 - r410;
        float r101 = r413 - r411;
        float r102 = Math.min(r100, r101);
        if (r414 == 0.0f) goto L17;
        if (r414 >= (r102 * 0.5f)) goto L17;
        float r103 = r414 / (r102 / 2.0f);
        float r104 = 1.0f;
        if (r103 <= 0.5f) goto L10;
        float r105 = 1.0f - (Math.min(1.0f, (r103 - 0.5f) / 0.4f) * 0.13877845f);
    L12:
        if (r103 <= 0.6f) goto L14;
        r104 = 1.0f + (Math.min(1.0f, (r103 - 0.6f) / 0.3f) * 0.042454004f);
    L14:
        float r106 = r414 / 100.0f;
        float r107 = (this.f509532c * r106) * r105;
        float r108 = (this.f509533d * r106) * r104;
        b r109 = this.f509534e;
        float r111 = r109.f509512a * r106;
        float r112 = r109.f509513b * r106;
        float r113 = r109.f509514c * r106;
        float r114 = r109.f509515d * r106;
        float r115 = r109.f509516e * r106;
        float r116 = r106 * r109.f509517f;
        float r117 = (r100 / 2.0f) + r410;
        float r118 = r412 - r107;
        float r119 = Math.max(r117, r118);
        float r120 = r412 - r108;
        float r121 = r412 - r111;
        float r210 = r411 + r116;
        float r211 = r412 - r112;
        float r212 = r411 + r115;
        float r213 = r412 - r113;
        float r214 = r411 + r114;
        float r215 = r412 - r114;
        float r216 = r411 + r113;
        float r217 = r412 - r115;
        float r218 = r411 + r112;
        float r219 = r412 - r116;
        float r310 = r411 + r111;
        float r311 = r411 + r108;
        float r122 = r101 / 2.0f;
        float r123 = r411 + Math.min(r122, r107);
        float r124 = r122 + r411;
        float r125 = r413 - r107;
        float r126 = Math.max(r124, r125);
        float r312 = r413 - r108;
        float r313 = r413 - r111;
        float r314 = r413 - r112;
        float r315 = r413 - r113;
        float r316 = r413 - r114;
        float r317 = r413 - r115;
        float r318 = r413 - r116;
        float r319 = Math.max(r117, r118);
        float r127 = r410 + r107;
        float r128 = Math.min(r117, r127);
        float r415 = r410 + r108;
        float r129 = r111 + r410;
        float r130 = r112 + r410;
        float r131 = r113 + r410;
        float r416 = r410 + r114;
        float r132 = r115 + r410;
        float r417 = r410 + r116;
        float r133 = Math.max(r124, r125);
        float r134 = Math.min(r124, r107 + r411);
        float r418 = Math.min(r117, r127);
        r110.moveTo(r117, r411);
        r110.lineTo(r119, r411);
        r110.cubicTo(r120, r411, r121, r210, r211, r212);
        r110.cubicTo(r213, r214, r215, r216, r217, r218);
        r110.cubicTo(r219, r310, r412, r311, r412, r123);
        r110.lineTo(r412, r126);
        r110.cubicTo(r412, r312, r219, r313, r217, r314);
        r110.cubicTo(r215, r315, r213, r316, r211, r317);
        r110.cubicTo(r121, r318, r120, r413, r319, r413);
        r110.lineTo(r128, r413);
        r110.cubicTo(r415, r413, r129, r318, r130, r317);
        r110.cubicTo(r131, r316, r416, r315, r132, r314);
        r110.cubicTo(r417, r313, r410, r312, r410, r133);
        r110.lineTo(r410, r134);
        r110.cubicTo(r410, r311, r417, r310, r132, r218);
        r110.cubicTo(r416, r216, r131, r214, r130, r212);
        r110.cubicTo(r129, r210, r415, r411, r418, r411);
        r110.close();
        return r110;
    L10:
        r105 = 1.0f;
    L17:
        return d.b(r410, r411, r412, r413, r414);
    }
}
