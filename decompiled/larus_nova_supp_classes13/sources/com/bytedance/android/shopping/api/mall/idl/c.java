package com.bytedance.android.shopping.api.mall.idl;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public final Lazy a;
    public Integer b;
    public Integer c;
    public Integer d;
    public Float e;
    public Float f;
    public Integer g;
    public String h;
    public Integer i;
    public List<Integer> j;
    public Integer k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;

    public c() {
        this(null);
    }

    public final String toString() {
        return "MallScreenModel(mallMetricsWidth=" + this.b + ", favoriteFeedMetricsWidth=" + this.c + ", mallPageWidth=" + this.d + ", mallContainerMarginLeft=" + this.e + ", mallContainerMarginRight=" + this.f + ", mallLayoutBreakpoint=" + this.g + ", deviceOrientation=" + this.h + ", feedLayoutColumn=" + this.i + ", tileLayoutInfo=" + this.j + ", deviceScreenType=" + this.k + ", enableBigScreenAdapter=" + this.l + ", inMainSplitScreen=" + this.m + ", enableWidescreenStyle=" + this.n + ", isOpenPageFromMall=" + this.o + ")";
    }

    public final boolean a() {
        if (this.n == false) goto L5;
    L8:
        return true;
    L5:
        if (this.l == true) goto L8;
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.b;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        int r3 = r2 * 31;
        Float r4 = this.e;
        if (r4 == null) goto L9;
        int r5 = Float.floatToIntBits(r4.floatValue());
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.intValue();
    L14:
        int r9 = (r6 + r8) * 31;
        Float r10 = this.f;
        if (r10 == null) goto L17;
        int r11 = Float.floatToIntBits(r10.floatValue());
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.g;
        if (r13 == null) goto L21;
        int r14 = r13.intValue();
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.i;
        if (r16 == null) goto L25;
        int r17 = r16.intValue();
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.k;
        if (r19 == null) goto L29;
        int r20 = r19.intValue();
    L30:
        int r21 = (r18 + r20) * 31;
        int r22 = 1231;
        if (this.l == false) goto L33;
        int r23 = 1231;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.d;
        if (r25 == null) goto L37;
        int r26 = r25.intValue();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.h;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        List<Integer> r31 = this.j;
        if (r31 == null) goto L45;
        r1 = r31.hashCode();
    L45:
        int r32 = (r30 + r1) * 31;
        if (this.m == false) goto L48;
        int r33 = 1231;
    L49:
        int r34 = (r32 + r33) * 31;
        if (this.n == true) goto L54;
        r22 = 1237;
    L54:
        return r34 + r22;
    L48:
        r33 = 1237;
        goto L49
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 1237;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public c(Object r1) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.a = LazyKt.lazy(MallScreenModel$bigScreenConfig$2.INSTANCE);
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof c) == false) goto L32;
        c r5 = (c) r4;
        if (Intrinsics.areEqual(this.b, r5.b) == true) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(this.c, r5.c) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.e, r5.e) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(this.f, r5.f) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.d, r5.d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.g, r5.g) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(this.h, r5.h) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.i, r5.i) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.j, r5.j) == true) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.k, r5.k) == true) goto L25;
        return false;
    L25:
        if (this.l == r5.l) goto L27;
        return false;
    L27:
        if (this.m == r5.m) goto L29;
        return false;
    L29:
        if (this.n != r5.n) goto L45;
        return true;
    L45:
        return false;
    L32:
        return false;
    }

    public final void update(c r2) {
        Intrinsics.checkNotNullParameter(r2, "newModel");
        this.b = r2.b;
        this.c = r2.c;
        this.e = r2.e;
        this.f = r2.f;
        this.d = r2.d;
        this.g = r2.g;
        this.h = r2.h;
        this.i = r2.i;
        this.j = r2.j;
        this.k = r2.k;
        this.l = r2.l;
        this.m = r2.m;
        this.n = r2.n;
    }
}
