package com.larus.bmhome.chat.component.bottom.core.inputtext.panel;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n extends FrameLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f299072n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function2<? super Float, ? super Boolean, Boolean> f299073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function2<? super Float, ? super Float, Boolean> f299074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f299075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super Float, Unit> f299076d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function2<? super Float, ? super Boolean, Unit> f299077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f299078f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f299079g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f299080h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f299081i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f299082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f299083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f299084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public VelocityTracker f299085m;

    public final void b() {
        this.f299083k = false;
        this.f299084l = false;
        VelocityTracker r100 = this.f299085m;
        if (r100 == null) goto L5;
        r100.recycle();
    L5:
        this.f299085m = null;
        ViewParent r101 = getParent();
        if (r101 == null) goto L9;
        r101.requestDisallowInterceptTouchEvent(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        if (this.f299083k == false) goto L5;
        a(true);
    L5:
        b();
        super.onDetachedFromWindow();
    }

    public final Function2<Float, Boolean, Boolean> getCanDrag() {
        return this.f299073a;
    }

    public final Function1<Float, Unit> getOnDragBy() {
        return this.f299076d;
    }

    public final Function2<Float, Boolean, Unit> getOnDragEnd() {
        return this.f299077e;
    }

    public final Function0<Unit> getOnDragStart() {
        return this.f299075c;
    }

    public n(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f299073a = new i();
        this.f299074b = new j();
        this.f299075c = new k();
        this.f299076d = new l();
        this.f299077e = new m();
        this.f299078f = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public final void a(boolean r100) {
        VelocityTracker r101 = this.f299085m;
        if (r101 == null) goto L5;
        r101.computeCurrentVelocity(1000);
    L5:
        this.f299083k = false;
        Function2<? super Float, ? super Boolean, Unit> r102 = this.f299077e;
        VelocityTracker r103 = this.f299085m;
        if (r103 == null) goto L8;
        float r104 = r103.getYVelocity();
    L9:
        r102.invoke(Float.valueOf(r104), Boolean.valueOf(r100));
        ViewParent r105 = getParent();
        if (r105 == null) goto L13;
        r105.requestDisallowInterceptTouchEvent(false);
        return;
    L13:
        return;
    L8:
        r104 = 0.0f;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getActionMasked();
        boolean r102 = true;
        if (r101 != 0) goto L5;
        b();
        this.f299079g = r100.getRawX();
        float r103 = r100.getRawY();
        this.f299080h = r103;
        this.f299081i = r103;
        this.f299082j = this.f299074b.invoke(Float.valueOf(r100.getX()), Float.valueOf(r100.getY())).booleanValue();
        this.f299085m = VelocityTracker.obtain();
    L11:
        MotionEvent r104 = MotionEvent.obtain(r100);
        r104.offsetLocation(r100.getRawX() - r100.getX(), r100.getRawY() - r100.getY());
        VelocityTracker r105 = this.f299085m;
        if (r105 == null) goto L14;
        r105.addMovement(r104);
    L14:
        r104.recycle();
        if (this.f299084l == true) goto L35;
        if (r100.getActionMasked() != 2) goto L35;
        float r106 = r100.getRawY() - this.f299081i;
        if (this.f299083k == true) goto L31;
        if (Math.abs(r100.getRawY() - this.f299080h) <= this.f299078f) goto L31;
        if (Math.abs(r100.getRawY() - this.f299080h) <= Math.abs(r100.getRawX() - this.f299079g)) goto L31;
        if (this.f299073a.invoke(Float.valueOf(r106), Boolean.valueOf(this.f299082j)).booleanValue() == false) goto L31;
        this.f299083k = true;
        MotionEvent r107 = MotionEvent.obtain(r100);
        r107.setAction(3);
        super.dispatchTouchEvent(r107);
        r107.recycle();
        ViewParent r108 = getParent();
        if (r108 == null) goto L29;
        r108.requestDisallowInterceptTouchEvent(true);
    L29:
        this.f299075c.invoke();
    L31:
        if (this.f299083k == false) goto L33;
        this.f299076d.invoke(Float.valueOf(r106));
    L33:
        this.f299081i = r100.getRawY();
    L35:
        if (this.f299083k == false) goto L37;
        boolean r109 = true;
    L39:
        if (r100.getActionMasked() == 1) goto L43;
        if (r100.getActionMasked() == 3) goto L43;
    L50:
        return r109;
    L43:
        if (this.f299083k == true) goto L45;
    L49:
        b();
        goto L50
    L45:
        if (r100.getActionMasked() == 3) goto L48;
        r102 = false;
    L48:
        a(r102);
        goto L49
    L37:
        r109 = super.dispatchTouchEvent(r100);
        goto L39
    L5:
        if (r101 != 5) goto L11;
        this.f299084l = true;
        if (this.f299083k == false) goto L11;
        a(true);
        goto L11
    }

    public final void setCanDrag(Function2<? super Float, ? super Boolean, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f299073a = r100;
    }

    public final void setHandleHit(Function2<? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f299074b = r100;
    }

    public final void setOnDragBy(Function1<? super Float, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f299076d = r100;
    }

    public final void setOnDragEnd(Function2<? super Float, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f299077e = r100;
    }

    public final void setOnDragStart(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f299075c = r100;
    }
}
