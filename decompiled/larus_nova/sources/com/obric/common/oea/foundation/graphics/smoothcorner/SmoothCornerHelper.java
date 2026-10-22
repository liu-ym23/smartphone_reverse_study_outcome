package com.obric.common.oea.foundation.graphics.smoothcorner;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import lja.c;
import lja.d;
import lja.f;
import lja.g;
import lja.h;
import mja.b;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
public final class SmoothCornerHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f396560b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f396561a;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/common/oea/foundation/graphics/smoothcorner/SmoothCornerHelper$Companion$CurveType;", "", "QUADRATIC", "SKETCH", "FIGMA", "BASIC", "QUADRATIC_CAPSULE", "foundation_standardRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum CurveType extends Enum<CurveType> {
            public static final CurveType BASIC = null;
            public static final CurveType FIGMA = null;
            public static final CurveType QUADRATIC = null;
            public static final CurveType QUADRATIC_CAPSULE = null;
            public static final CurveType SKETCH = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ CurveType[] f396562a = null;

            static {
                CurveType r100 = new CurveType("QUADRATIC", 0);
                QUADRATIC = r100;
                CurveType r101 = new CurveType("SKETCH", 1);
                SKETCH = r101;
                CurveType r102 = new CurveType("FIGMA", 2);
                FIGMA = r102;
                CurveType r103 = new CurveType("BASIC", 3);
                BASIC = r103;
                CurveType r104 = new CurveType("QUADRATIC_CAPSULE", 4);
                QUADRATIC_CAPSULE = r104;
                f396562a = new CurveType[]{r100, r101, r102, r103, r104};
            }

            public static CurveType valueOf(String r100) {
                return (CurveType) a.a(CurveType.class, r100);
            }

            public static CurveType[] values() {
                return (CurveType[]) f396562a.clone();
            }

            public CurveType(String r100, int r101) {
                super(r100, r101);
            }
        }
    }

    static {
        f396560b = CollectionsKt.toList(RangesKt.step(new IntRange(8, 48), 2));
    }

    public SmoothCornerHelper() {
        new b();
        this.f396561a = new g();
    }

    public final void b(Companion.CurveType r100) {
        Intrinsics.checkNotNullParameter(r100, "curveType");
        Intrinsics.checkNotNullParameter(r100, "curveType");
        mja.a.C6822a r101 = mja.a.f514263a;
        mja.a.a("SmoothCornerHelper", "setCurveType: " + r100);
        int r102 = kja.a.f503728a[r100.ordinal()];
        if (r102 != 1) goto L5;
        d r103 = new lja.a();
    L22:
        this.f396561a = r103;
        return;
    L5:
        if (r102 == 2) goto L18;
        if (r102 != 3) goto L9;
        r103 = new h();
        goto L22
    L9:
        if (r102 != 4) goto L11;
        r103 = new c();
        goto L22
    L11:
        if (r102 != 5) goto L14;
        r103 = new f();
        goto L22
    L14:
        throw new NoWhenBranchMatchedException();
    L18:
        if ((-1.0f) <= 0) goto L20;
        r103 = new g(-1.0f);
        goto L22
    L20:
        r103 = new g();
        goto L22
    }

    public final void a(Canvas r110, Paint r111, float r112, float r113, float r114, float r115, float r210) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        float r116 = 0.0f;
        if (r210 >= 0.0f) goto L5;
        mja.a.C6822a r117 = mja.a.f514263a;
        mja.a.b("SmoothCornerHelper", "invalid radius: " + r210);
    L7:
        if (r116 <= (Math.min(r114 - r112, r115 - r113) / 2)) goto L9;
        d r100 = this.f396561a;
        int r118 = d.f509521b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        r100.f509522a.set(r112, r113, r114, r115);
        r110.drawRoundRect(r100.f509522a, r116, r116, r111);
        return;
    L9:
        this.f396561a.d(r110, r111, r112, r113, r114, r115, r116);
        return;
    L5:
        r116 = r210;
        goto L7
    }
}
