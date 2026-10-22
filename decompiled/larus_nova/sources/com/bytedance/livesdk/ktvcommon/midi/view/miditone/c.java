package com.bytedance.livesdk.ktvcommon.midi.view.miditone;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f256282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f256283b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f256284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f256285b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Float.compare(this.f256284a, r101.f256284a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f256285b, r101.f256285b) == 0) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f256284a) * 31) + Float.floatToIntBits(this.f256285b);
        }

        public final String toString() {
            return "LineData(startX=" + this.f256284a + ", endX=" + this.f256285b + ")";
        }

        public a(float r100, float r101) {
            this.f256284a = r100;
            this.f256285b = r101;
        }
    }

    public final void b() {
        d r100 = this.f256283b;
        long r101 = r100.f256296k;
        if (r101 <= 0) goto L5;
        float r102 = r100.f256288c / r101;
    L6:
        this.f256282a = r102;
        if (r100.f256287b <= r100.f256286a) goto L10;
        int r103 = r100.f256289d;
    L10:
        if (r102 <= 0) goto L13;
        int r104 = r100.f256291f;
        return;
    L13:
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f256283b = r100;
    }

    public final a a(bl6.a r100, long r110) {
        r100.getClass();
        Long r101 = Long.valueOf(((long) 0) - r110);
        boolean r102 = true;
        if (r101.longValue() <= 0) goto L5;
        boolean r103 = true;
    L6:
        Long r104 = null;
        if (r103 == true) goto L10;
        r101 = null;
    L10:
        float r105 = 0.0f;
        if (r101 == null) goto L13;
        float r106 = RangesKt.coerceAtLeast(r101.longValue() * this.f256282a, 0.0f);
    L14:
        r100.getClass();
        Long r107 = Long.valueOf(((long) 0) - r110);
        if (r107.longValue() > 0) goto L18;
        r102 = false;
    L18:
        if (r102 == false) goto L20;
        r104 = r107;
    L20:
        if (r104 == null) goto L23;
        r105 = RangesKt.coerceAtLeast(r104.longValue() * this.f256282a, 0.0f);
    L23:
        return new a(r106, r105);
    L13:
        r106 = 0.0f;
        goto L14
    L5:
        r103 = false;
        goto L6
    }
}
