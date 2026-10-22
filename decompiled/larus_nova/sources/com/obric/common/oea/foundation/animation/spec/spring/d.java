package com.obric.common.oea.foundation.animation.spec.spring;

import android.graphics.Color;
import cja.e;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class d implements gja.a<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f396395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f396396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f396397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f396398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f396399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f396400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f396401g;

    @Override // gja.a
    public final String dump() {
        return "IntSpringSpec(dampingRatio: " + this.f396397c + ", stiffness: " + this.f396398d + ", delay: " + this.f396399e + ", visibilityThreshold: " + this.f396400f + ", delta: " + this.f396396b + ')';
    }

    @Override // gja.a
    public final boolean a(long r100, long r101) {
        if (r100 < (r101 + (((long) this.f396399e) * 1000000))) goto L5;
        return true;
    L5:
        return false;
    }

    public d(float r100, float r101, int r102) {
        this.f396397c = r100;
        this.f396398d = r101;
        this.f396399e = r102;
        this.f396400f = 0.01f;
        this.f396401g = false;
        e r103 = new e();
        if (r100 < 0) goto L7;
        r103.f23997f = r100;
        r103.f23993b = false;
        r103.a(r101);
        Unit r104 = Unit.INSTANCE;
        this.f396395a = r103;
        this.f396396b = 1.0f;
        return;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    @Override // gja.a
    public final /* bridge */ /* synthetic */ long b(Integer r100, Integer r101, float r102) {
        return f(r100.intValue(), r101.intValue(), r102);
    }

    public final long f(int r110, int r111, float r112) {
        float r100 = Color.alpha(r110);
        float r101 = Color.alpha(r111);
        float r102 = Color.red(r110);
        float r103 = Color.red(r111);
        float r104 = Color.green(r110);
        float r105 = Color.green(r111);
        float r113 = Color.blue(r110);
        float r114 = Color.blue(r111);
        e r106 = this.f396395a;
        double r107 = r106.f23992a;
        float r108 = r106.f23997f;
        float r109 = r100 - r101;
        float r115 = this.f396400f;
        long r116 = c.b((float) (r107 * r107), r108, r112 / r115, r109 / r115, this.f396396b);
        e r117 = this.f396395a;
        double r118 = r117.f23992a;
        float r119 = r117.f23997f;
        float r120 = r102 - r103;
        float r121 = this.f396400f;
        long r122 = c.b((float) (r118 * r118), r119, r112 / r121, r120 / r121, this.f396396b);
        e r123 = this.f396395a;
        double r124 = r123.f23992a;
        float r125 = r123.f23997f;
        float r126 = r104 - r105;
        float r127 = this.f396400f;
        long r128 = c.b((float) (r124 * r124), r125, r112 / r127, r126 / r127, this.f396396b);
        e r129 = this.f396395a;
        double r130 = r129.f23992a;
        float r131 = r129.f23997f;
        float r132 = r113 - r114;
        float r133 = this.f396400f;
        return ComparisonsKt.maxOf(r116, new long[]{r122, r128, c.b((float) (r130 * r130), r131, r112 / r133, r132 / r133, this.f396396b)}) * 1000000;
    }

    @Override // gja.a
    public final Integer c(long r100, Integer r110, Integer r111, float r112) {
        int r113 = r110.intValue();
        int r114 = r111.intValue();
        long r101 = e(r100, r113, r114, r112) / 1000000;
        if (this.f396401g == false) goto L5;
        int r102 = Color.alpha(r113);
        int r103 = Color.red(r113);
        int r104 = Color.green(r113);
        int r115 = Color.blue(r113);
        int r105 = Color.alpha(r114);
        int r106 = Color.red(r114);
        int r107 = Color.green(r114);
        int r116 = Color.blue(r114);
        e r108 = this.f396395a;
        r108.f23998g = r105;
        int r109 = (int) r108.b(r102, r112, r101).a();
        e r117 = this.f396395a;
        r117.f23998g = r106;
        int r118 = (int) r117.b(r103, r112, r101).a();
        e r119 = this.f396395a;
        r119.f23998g = r107;
        int r120 = (int) r119.b(r104, r112, r101).a();
        e r121 = this.f396395a;
        r121.f23998g = r116;
        int r122 = Color.argb(r109, r118, r120, (int) r121.b(r115, r112, r101).a());
    L7:
        return Integer.valueOf(r122);
    L5:
        e r123 = this.f396395a;
        r123.f23998g = r114;
        r122 = (int) r123.b(r113, r112, r101).a();
        goto L7
    }

    @Override // gja.a
    public final float d(long r100, Integer r110, Integer r111, float r112) {
        int r113 = r110.intValue();
        int r114 = r111.intValue();
        long r101 = e(r100, r113, r114, r112) / 1000000;
        if (this.f396401g == false) goto L5;
        float r102 = Color.alpha(r113);
        float r103 = Color.red(r113);
        float r104 = Color.green(r113);
        float r115 = Color.blue(r113);
        float r105 = Color.alpha(r114);
        float r106 = Color.red(r114);
        float r107 = Color.green(r114);
        float r116 = Color.blue(r114);
        e r108 = this.f396395a;
        r108.f23998g = r105;
        float r109 = r108.b(r102, r112, r101).b();
        e r117 = this.f396395a;
        r117.f23998g = r106;
        float r118 = r117.b(r103, r112, r101).b();
        e r119 = this.f396395a;
        r119.f23998g = r107;
        float r120 = r119.b(r104, r112, r101).b();
        e r121 = this.f396395a;
        r121.f23998g = r116;
        float r122 = r121.b(r115, r112, r101).b();
        return (float) Math.sqrt((((r109 * r109) + (r118 * r118)) + (r120 * r120)) + (r122 * r122));
    L5:
        e r123 = this.f396395a;
        r123.f23998g = r114;
        return r123.b(r113, r112, r101).b();
    }

    public final long e(long r100, int r110, int r111, float r112) {
        long r113 = f(r110, r111, r112);
        long r101 = r100 - (((long) this.f396399e) * 1000000);
        if (r113 < 0) goto L5;
        long r102 = r113;
    L7:
        return RangesKt.coerceIn(r101, 0, r102);
    L5:
        r102 = 0;
        goto L7
    }
}
