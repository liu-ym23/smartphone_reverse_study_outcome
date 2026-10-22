package lja;

import android.graphics.Path;

/* JADX INFO: loaded from: classes33.dex */
public final class c extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f509518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f509519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f509520e;

    @Override // lja.d
    public final boolean c(float r100, float r101) {
        if (r100 >= (r101 * 0.5f)) goto L5;
        return true;
    L5:
        return false;
    }

    public c() {
        this.f509518c = 0.017453292519943295d;
        this.f509519d = 0.6f;
        this.f509520e = "FigmaSmoothCornerImpl";
    }

    @Override // lja.d
    public String getType() {
        return this.f509520e;
    }

    @Override // lja.d
    public final Path a(float r410, float r411, float r412, float r413, float r414) {
        float r100 = r412 - r410;
        float r101 = Math.min(r100, r413 - r411);
        Path r110 = new Path();
        if (r414 == 0.0f) goto L14;
        if (r414 >= (0.5f * r101)) goto L14;
        float r102 = Math.min(r101 / 2.0f, (this.f509519d + 1.0f) * r414);
        float r103 = r101 / 4.0f;
        if (r414 <= r103) goto L10;
        float r111 = this.f509519d;
        float r112 = 1.0f - ((r414 - r103) / r103);
        float r104 = 90 * (1.0f - (r111 * r112));
        float r105 = 45 * r111;
    L11:
        float r106 = r105 * r112;
        float r113 = (90 - r104) / 2.0f;
        double r107 = r106;
        float r108 = (float) Math.tan(this.f509518c * r107);
        float r109 = ((float) Math.tan(((double) (r113 / 2.0f)) * this.f509518c)) * r414;
        float r114 = (float) ((Math.sin(((double) (r104 / 2.0f)) * this.f509518c) * ((double) r414)) * Math.sqrt(2.0d));
        float r115 = r109 * ((float) Math.cos(r107 * this.f509518c));
        float r116 = r115 * r108;
        float r117 = ((r102 - r114) - ((r108 + 1.0f) * r115)) / 3.0f;
        float r118 = r412 - r102;
        float r119 = r102 - (r117 * 2.0f);
        float r120 = r412 - r119;
        float r121 = r119 - r117;
        float r122 = r412 - r121;
        float r123 = r121 - r115;
        float r124 = r412 - r414;
        float r125 = r411 + r414;
        float r210 = r411 + r121;
        float r211 = r411 + r119;
        float r126 = r411 + r102;
        float r127 = r413 - r102;
        float r212 = r413 - r119;
        float r310 = r413 - r121;
        float r128 = r413 - r414;
        float r129 = r410 + r102;
        float r130 = r410 + r119;
        float r311 = r410 + r121;
        float r312 = r410 + r123;
        float r131 = r410 + r414;
        float r313 = r410 + r116;
        r110.moveTo((r100 / 2.0f) + r410, r411);
        r110.lineTo(r118, r411);
        r110.cubicTo(r120, r411, r122, r411, r412 - r123, r411 + r116);
        d.a.a(r110, new e(r124, r125), r414, r113 + 270.0f, 360.0f - r113);
        r110.cubicTo(r412, r210, r412, r211, r412, r126);
        r110.lineTo(r412, r127);
        r110.cubicTo(r412, r212, r412, r310, r412 - r116, r413 - r123);
        d.a.a(r110, new e(r124, r128), r414, r113, 90.0f - r113);
        r110.cubicTo(r122, r413, r120, r413, r118, r413);
        r110.lineTo(r129, r413);
        r110.cubicTo(r130, r413, r311, r413, r312, r413 - r116);
        d.a.a(r110, new e(r131, r128), r414, r113 + 90.0f, 180.0f - r113);
        r110.cubicTo(r410, r310, r410, r212, r410, r127);
        r110.lineTo(r410, r126);
        r110.cubicTo(r410, r211, r410, r210, r313, r411 + r123);
        d.a.a(r110, new e(r131, r125), r414, r113 + 180.0f, 270.0f - r113);
        r110.cubicTo(r311, r411, r130, r411, r129, r411);
        r110.close();
        return r110;
    L10:
        r112 = this.f509519d;
        r104 = 90 * (1.0f - r112);
        r105 = 45;
    L14:
        return d.b(r410, r411, r412, r413, r414);
    }
}
