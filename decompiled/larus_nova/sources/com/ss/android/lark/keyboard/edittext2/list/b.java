package com.ss.android.lark.keyboard.edittext2.list;

import android.content.Context;
import androidx.core.util.Pools;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f429157f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f429159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Pools.SimplePool<y9b.c> f429160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Pools.SimplePool<y9b.b> f429161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C5095b f429162e;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.list.b$b, reason: collision with other inner class name */
    public static final class C5095b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Float f429163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f429164b;

        /* JADX INFO: renamed from: com.ss.android.lark.keyboard.edittext2.list.b$b$a */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Float f429165a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Integer f429166b;

            public a() {
            }
        }

        public C5095b(Float r100, Integer r101) {
            this.f429163a = r100;
            this.f429164b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f429167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f429168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f429169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f429170d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f429167a == r101.f429167a) goto L12;
            return false;
        L12:
            if (this.f429168b == r101.f429168b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f429169c, r101.f429169c) == 0) goto L18;
            return false;
        L18:
            if (this.f429170d == r101.f429170d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f429167a * 31) + this.f429168b) * 31) + Float.floatToIntBits(this.f429169c)) * 31) + this.f429170d;
        }

        public final String toString() {
            return "ListTheme(listTextSize=" + this.f429167a + ", labelColor=" + this.f429168b + ", listItemRightMargin=" + this.f429169c + ", floorWidth=" + this.f429170d + ')';
        }

        public c(int r100, int r101, float r102, int r103) {
            this.f429167a = r100;
            this.f429168b = r101;
            this.f429169c = r102;
            this.f429170d = r103;
        }
    }

    static {
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, new c(-1, UIUtils.getColor(r100, R.color.ud_B500), -1.0f, -1));
    }

    public final y9b.a a(y9b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "prefixSpan");
        if ((r100 instanceof y9b.c) == false) goto L8;
        y9b.c r101 = this.f429160c.acquire();
        if (r101 == null) goto L15;
        return r101;
    L15:
        return new y9b.c();
    L8:
        if ((r100 instanceof y9b.b) == false) goto L13;
        y9b.b r102 = this.f429161d.acquire();
        if (r102 == null) goto L17;
        return r102;
    L17:
        return new y9b.b();
    L13:
        return new y9b.c();
    }

    public final void b(y9b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        if ((r100 instanceof y9b.c) == false) goto L6;
        this.f429160c.release(r100);
        return;
    L6:
        if ((r100 instanceof y9b.b) == false) goto L10;
        this.f429161d.release(r100);
        return;
    }

    public final void d(y9b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "span");
        r100.f419934a.f419941d = com.ss.android.lark.coremd.utils.a.d(r100);
        r100.f419934a.f419940c = com.ss.android.lark.coremd.utils.a.b(this.f429158a, r100) + com.ss.android.lark.coremd.utils.a.a(this.f429158a, this.f429159b.f429170d, r100.b());
        r100.f419934a.f419942e = com.ss.android.lark.coremd.utils.a.c(this.f429158a, r100, this.f429159b.f429169c);
    }

    public b(Context r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listTheme");
        this.f429158a = r100;
        this.f429159b = r101;
        this.f429160c = new Pools.SimplePool(16);
        this.f429161d = new Pools.SimplePool(16);
        C5095b.a r102 = new C5095b.a();
        this.f429162e = new C5095b(r102.f429165a, r102.f429166b);
    }

    public static void c(y9b.a r100, y9b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "newSpan");
        Intrinsics.checkNotNullParameter(r101, "prefixSpan");
        r100.h(r101.c() + 1);
        r100.f(r101.b());
        CommonPrefixSpan.c r102 = r101.f419934a;
        float r103 = r102.f419942e;
        CommonPrefixSpan.c r104 = r100.f419934a;
        r104.f419942e = r103;
        r104.f419947j = r102.f419947j;
        r104.f419944g = r102.f419944g;
        r100.g(ListHeadType.None);
    }
}
