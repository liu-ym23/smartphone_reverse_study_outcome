package com.larus.home.impl.main.side_bar.layout.drawer_impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC4320a f344743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f344744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f344745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f344746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f344747e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f344748f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f344749g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f344750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f344751i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f344752j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f344753k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f344754l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f344755m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f344756n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f344757o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public VelocityTracker f344758p;

    /* JADX INFO: renamed from: com.larus.home.impl.main.side_bar.layout.drawer_impl.a$a, reason: collision with other inner class name */
    public interface InterfaceC4320a {
        int getDistanceThreshold();

        View getDrawerMainContainer();
    }

    public final boolean e(float r100) {
        if (r100 <= 0.0f) goto L12;
        FullDraggableContainer r101 = (FullDraggableContainer) this.f344743a;
        if (r101.f344741b.getDrawerLockMode(3) == 0) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        return true;
    L7:
        if (r101.a(3) == null) goto L9;
        r102 = true;
    L12:
        if (r100 >= 0.0f) goto L21;
        FullDraggableContainer r103 = (FullDraggableContainer) this.f344743a;
        if (r103.f344741b.getDrawerLockMode(5) == 0) goto L16;
    L18:
        boolean r104 = false;
    L19:
        if (r104 == false) goto L21;
        return true;
    L16:
        if (r103.a(5) == null) goto L18;
        r104 = true;
    L21:
        return false;
    }

    public a(Context r100, InterfaceC4320a r101) {
        this.f344751i = 0;
        this.f344752j = false;
        this.f344753k = false;
        this.f344755m = false;
        this.f344756n = false;
        this.f344757o = false;
        this.f344758p = null;
        this.f344743a = r101;
        this.f344747e = ViewConfiguration.get(r100).getScaledTouchSlop();
        Resources r102 = r100.getResources();
        this.f344748f = (int) ((8 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
        Resources r103 = r100.getResources();
        this.f344749g = (int) ((150 * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density) + 0.5f);
        this.f344750h = ViewConfiguration.getLongPressTimeout();
    }

    public static boolean c(View r100, int r110, int r111) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 30) goto L13;
        if (r100.isLongClickable() == false) goto L16;
        if (r100.hasOnLongClickListeners() == false) goto L16;
        return true;
    L16:
        if ((r100 instanceof ViewGroup) == false) goto L33;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L18:
        if (r104 < 0) goto L33;
        View r105 = r101.getChildAt(r104);
        if (r105.getVisibility() != 0) goto L32;
        int r106 = (r110 + r102) - r105.getLeft();
        int r107 = (r111 + r103) - r105.getTop();
        if (r106 < 0) goto L32;
        if (r106 >= r105.getWidth()) goto L32;
        if (r107 < 0) goto L32;
        if (r107 >= r105.getHeight()) goto L32;
        if (c(r105, r106, r107) == false) goto L32;
        return true;
    L32:
        r104 = r104 - 1;
    L33:
        return false;
    L13:
        if (r100.isLongClickable() == false) goto L16;
        return true;
    }

    public final boolean b(MotionEvent r100, float r101, float r102) {
        if (this.f344757o == false) goto L6;
        return true;
    L6:
        if (this.f344755m == true) goto L9;
        return false;
    L9:
        if (this.f344756n == true) goto L21;
        float r103 = Math.abs(r101 - this.f344744b);
        float r104 = Math.abs(r102 - this.f344745c);
        int r105 = this.f344747e;
        if (r103 <= r105) goto L13;
    L20:
        this.f344756n = true;
        goto L21
    L13:
        if (r104 > r105) goto L20;
        if ((r100.getEventTime() - this.f344754l) < this.f344750h) goto L19;
        this.f344757o = true;
        return true;
    L19:
        return false;
    L21:
        return false;
    }

    public final boolean d(float r100, float r101, float r102) {
        if (Math.abs(r100) > r102) goto L5;
    L14:
        return false;
    L5:
        if ((Math.abs(r100) * 0.364f) <= Math.abs(r101)) goto L14;
        if (e(r100) == false) goto L14;
        FullDraggableContainer.a r103 = ((FullDraggableContainer) this.f344743a).f344742c;
        if (r103 != null) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        return true;
    L11:
        r104 = ((wb9.a) r103).f559028a.f344728e;
        goto L12
    }

    public static boolean a(View r100, boolean r110, int r111, int r112, int r113) {
        if ((r100 instanceof ViewGroup) == false) goto L21;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L21;
        View r105 = r101.getChildAt(r104);
        if (r105.getVisibility() != 0) goto L20;
        int r106 = r112 + r102;
        if (r106 < r105.getLeft()) goto L20;
        if (r106 >= r105.getRight()) goto L20;
        int r107 = r113 + r103;
        if (r107 < r105.getTop()) goto L20;
        if (r107 >= r105.getBottom()) goto L20;
        if (a(r105, true, r111, r106 - r105.getLeft(), r107 - r105.getTop()) == false) goto L20;
        return true;
    L20:
        r104 = r104 - 1;
    L21:
        if (r110 == true) goto L23;
    L25:
        return false;
    L23:
        if (r100.canScrollHorizontally(-r111) == false) goto L25;
        return true;
    }
}
