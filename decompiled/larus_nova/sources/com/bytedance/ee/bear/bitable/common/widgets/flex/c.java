package com.bytedance.ee.bear.bitable.common.widgets.flex;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f209953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f209954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f209955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f209956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f209957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f209958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f209959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f209960h;

    public static final class a {
    }

    public interface b {
        void a(boolean r100);

        Context getContext();

        boolean p();

        boolean s();
    }

    static {
    }

    public c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "scrollView");
        this.f209953a = r100;
        this.f209960h = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }

    public final void a(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "ev");
        this.f209957e = r110.getX();
        this.f209958f = r110.getY();
        int r111 = r110.getAction();
        boolean r100 = false;
        if (r111 == 0) goto L41;
        if (r111 != 1) goto L6;
    L40:
        this.f209953a.a(false);
        return;
    L6:
        if (r111 != 2) goto L8;
        tt5.a.b("InnerScrollHelper", "move x=" + this.f209957e + ", y=" + this.f209958f + ", canScrollUp=" + this.f209953a.s() + ", canScrollBottom=" + this.f209953a.p() + ", lastY=" + this.f209956d + '}');
        if (this.f209959g != 0) goto L26;
        float r112 = Math.abs(this.f209957e - this.f209954b);
        float r113 = Math.abs(this.f209958f - this.f209955c);
        float r114 = this.f209960h;
        if (r112 > r114) goto L17;
        if (r113 <= r114) goto L26;
    L17:
        if (r113 <= r112) goto L19;
        int r115 = 1;
    L20:
        this.f209959g = r115;
        tt5.a.h("InnerScrollHelper", "move x=" + this.f209957e + ", y=" + this.f209958f + " absX=" + r112 + " absY=" + r113 + " canScrollUp=" + this.f209953a.s() + ", canScrollBottom=" + this.f209953a.p() + ", lastY=" + this.f209956d + "}, resolveInterceptMove disallowIntercept=" + this.f209959g);
        b r116 = this.f209953a;
        if (this.f209959g != 1) goto L23;
        boolean r101 = true;
    L24:
        r116.a(r101);
        goto L26
    L23:
        r101 = false;
        goto L24
    L19:
        r115 = 2;
    L26:
        if (this.f209959g == 1) goto L28;
    L39:
        this.f209956d = this.f209958f;
        return;
    L28:
        if (this.f209953a.s() == true) goto L32;
        if (this.f209956d >= (this.f209958f - this.f209960h)) goto L32;
    L35:
        this.f209959g = 2;
        tt5.a.h("InnerScrollHelper", "resolveContinueInterceptMove move x=" + this.f209957e + ", y=" + this.f209958f + " canScrollUp=" + this.f209953a.s() + ", canScrollBottom=" + this.f209953a.p() + ", lastY=" + this.f209956d + '}');
        b r117 = this.f209953a;
        if (this.f209959g != 1) goto L38;
        r100 = true;
    L38:
        r117.a(r100);
    L32:
        if (this.f209953a.p() == true) goto L39;
        if (this.f209956d <= (this.f209958f + this.f209960h)) goto L39;
    L8:
        if (r111 == 3) goto L40;
        return;
    L41:
        this.f209954b = this.f209957e;
        float r118 = this.f209958f;
        this.f209955c = r118;
        this.f209956d = r118;
        this.f209959g = 0;
        tt5.a.b("InnerScrollHelper", "down x=" + this.f209957e + ", y=" + this.f209958f + ", canScrollUp=" + this.f209953a.s() + ", canScrollBottom=" + this.f209953a.p() + ", lastY=" + this.f209956d + '}');
        this.f209953a.a(true);
    }
}
