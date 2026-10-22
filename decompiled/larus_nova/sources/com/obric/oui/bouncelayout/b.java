package com.obric.oui.bouncelayout;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f399039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Float> f399040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<BounceEdgeEffect[]> f399041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f399042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f399043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f399044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f399045g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f399046h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f399047i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f399048j;

    public final void a(MotionEvent r100) {
        if (r100.getActionMasked() != 1) goto L5;
    L6:
        this.f399043e = 0.0f;
        this.f399047i = false;
        this.f399048j = false;
        return;
    L5:
        if (r100.getActionMasked() == 3) goto L6;
    }

    public final void c(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        boolean r102 = false;
        if (r101 != 0) goto L5;
        this.f399045g = r100.getX();
        this.f399046h = r100.getY();
        this.f399048j = false;
        this.f399043e = this.f399040b.invoke().floatValue();
        if (this.f399042d == true) goto L24;
    L47:
        this.f399047i = r102;
        int r103 = c.f399049a;
        if (r102 == false) goto L60;
        ViewParent r104 = this.f399039a.getParent();
        if (r104 == null) goto L62;
        r104.requestDisallowInterceptTouchEvent(true);
        return;
    L62:
        return;
    L60:
        return;
    L24:
        if (r100.getActionMasked() != 0) goto L47;
        BounceEdgeEffect[] r105 = this.f399041c.invoke();
        int r106 = r105.length;
        int r107 = 0;
    L27:
        if (r107 >= r106) goto L47;
        BounceEdgeEffect r108 = r105[r107];
        if (r108 != null) goto L31;
    L43:
        boolean r109 = false;
    L44:
        if (r109 == true) goto L45;
        r107 = r107 + 1;
        goto L27
    L45:
        r102 = true;
        goto L47
    L31:
        if (r108.getDistance() != 0.0f) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == true) goto L36;
    L42:
        r109 = true;
        goto L44
    L36:
        if (r108.f398883f != 0.0f) goto L38;
        boolean r111 = true;
    L39:
        if (r111 == false) goto L42;
        if (r108.isFinished() == true) goto L43;
    L38:
        r111 = false;
        goto L39
    L33:
        r110 = false;
        goto L34
    L5:
        if (r101 == 2) goto L8;
        return;
    L8:
        if (this.f399047i == true) goto L10;
        return;
    L10:
        if (this.f399048j == true) goto L57;
        float r112 = r100.getX() - this.f399045g;
        float r113 = r100.getY() - this.f399046h;
        float r114 = (r112 * r112) + (r113 * r113);
        int r115 = this.f399044f;
        if (r114 <= (r115 * r115)) goto L14;
        boolean r116 = true;
    L15:
        if (r116 == false) goto L58;
        this.f399048j = true;
        ViewParent r117 = this.f399039a.getParent();
        if (r117 == null) goto L20;
        r117.requestDisallowInterceptTouchEvent(false);
    L20:
        int r118 = c.f399049a;
        return;
    L58:
        return;
    L14:
        r116 = false;
        goto L15
    }

    public final boolean d(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f399047i == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = c.f399049a;
        return r101;
    L5:
        if (this.f399048j == true) goto L7;
        r101 = true;
        goto L8
    }

    public b(View r100, Function0<Float> r101, Function0<BounceEdgeEffect[]> r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "translationProvider");
        Intrinsics.checkNotNullParameter(r102, "effectsProvider");
        this.f399039a = r100;
        this.f399040b = r101;
        this.f399041c = r102;
        this.f399042d = true;
        this.f399044f = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
    }

    public final Boolean b(MotionEvent r100, float r101, float r102, Function0<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r103, "dispatch");
        if (this.f399047i == true) goto L6;
        a(r100);
        return null;
    L6:
        int r104 = c.f399049a;
        boolean r105 = false;
        if (r101 != 0.0f) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L12;
    L18:
        r100.offsetLocation(r101, r102);
        boolean r107 = r103.invoke().booleanValue();
        r100.offsetLocation(-r101, -r102);
        a(r100);
        return Boolean.valueOf(r107);
    L12:
        if (r102 != 0.0f) goto L14;
        r105 = true;
    L14:
        if (r105 == false) goto L18;
        boolean r108 = r103.invoke().booleanValue();
        a(r100);
        return Boolean.valueOf(r108);
    L9:
        r106 = false;
        goto L10
    }
}
