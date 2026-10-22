package rjb;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Size;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f538224b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f538225a;

    public static final class a {
    }

    static {
    }

    public final Rect d() {
        return this.f538225a.b();
    }

    public final int e() {
        int r100 = this.f538225a.c();
        if (r100 != 1) goto L5;
        return 3;
    L5:
        if (r100 == 2) goto L12;
        if (r100 != 3) goto L8;
        return 5;
    L8:
        if (r100 == 4) goto L10;
        return 0;
    L10:
        return 80;
    L12:
        return 48;
    }

    public h(b r100) {
        Intrinsics.checkNotNullParameter(r100, "component");
        this.f538225a = r100;
    }

    public final Point a(LinearLayout r100, Size r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "containerWH");
        Intrinsics.checkNotNullParameter(r102, "anchorRect");
        int r103 = this.f538225a.c();
        this.f538225a.f();
        int r104 = this.f538225a.e(r100, r101, r102);
        int r105 = this.f538225a.g(r100, r101, r102);
        Point r106 = new Point();
        if (r103 != 1) goto L5;
        int r107 = c(r102, r104, r101, 32);
        r106.x = (r102.left - r101.getWidth()) - r105;
        r106.y = r107;
    L18:
        return r106;
    L5:
        if (r103 != 2) goto L7;
        r106.x = b(r102, r104, r101, 32);
        r106.y = (r102.top - r101.getHeight()) - r105;
        goto L18
    L7:
        if (r103 != 3) goto L9;
        int r108 = c(r102, r104, r101, 32);
        r106.x = r102.right + r105;
        r106.y = r108;
        goto L18
    L9:
        if (r103 != 4) goto L11;
        r106.x = b(r102, r104, r101, 32);
        r106.y = r102.bottom + r105;
        goto L18
    L11:
        if (r103 == 5) goto L13;
        Point r109 = new Point();
        r109.x = (r102.left + r102.right) / 2;
        r109.y = (r102.top + r102.bottom) / 2;
        goto L18
    L13:
        r106.x = ((r102.left + r102.right) / 2) + r104;
        r106.y = ((r102.top + r102.bottom) / 2) + r105;
        goto L18
    }

    public final void f(LinearLayout r100, Size r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "containerView");
        Intrinsics.checkNotNullParameter(r101, "containerWH");
        this.f538225a.d(r100, r101, r102);
    }

    public final void g(Context r100, LinearLayout r101, g r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerView");
        Intrinsics.checkNotNullParameter(r102, "guide");
        this.f538225a.a(r100, r101, r102);
    }

    public static final int b(Rect r100, int r101, Size r102, int r103) {
        if (r103 != 16) goto L5;
        int r104 = r100.left;
    L13:
        return r104 + r101;
    L5:
        if (r103 != 32) goto L7;
        int r105 = r100.left;
        r101 = r101 + r105;
        r104 = ((r100.right - r105) - r102.getWidth()) / 2;
        goto L13
    L7:
        if (r103 == 48) goto L9;
        r104 = r100.left;
        goto L13
    L9:
        int r106 = r100.left;
        r101 = r101 + r106;
        r104 = (r100.right - r106) - r102.getWidth();
        goto L13
    }

    public static final int c(Rect r100, int r101, Size r102, int r103) {
        if (r103 != 16) goto L5;
        int r104 = r100.top;
    L13:
        return r104 + r101;
    L5:
        if (r103 != 32) goto L7;
        int r105 = r100.top;
        r101 = r101 + r105;
        r104 = ((r100.bottom - r105) - r102.getHeight()) / 2;
        goto L13
    L7:
        if (r103 == 48) goto L9;
        r104 = r100.top;
        goto L13
    L9:
        int r106 = r100.top;
        r101 = r101 + r106;
        r104 = (r100.bottom - r106) - r102.getHeight();
        goto L13
    }
}
