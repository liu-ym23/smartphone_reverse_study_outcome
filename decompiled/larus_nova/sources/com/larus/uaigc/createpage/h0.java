package com.larus.uaigc.createpage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f372558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f372559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f372560c;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        View r101 = this.f372558a;
        boolean r102 = false;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.isShown() == true) goto L8;
        return false;
    L8:
        Rect r103 = new Rect();
        if (r101.getGlobalVisibleRect(r103) == true) goto L11;
    L12:
        r102 = true;
    L13:
        if (r102 == true) goto L17;
        super.dispatchTouchEvent(r100);
        return true;
    L17:
        if (r100.getActionMasked() == 0) goto L19;
    L21:
        return true;
    L19:
        if (this.f372560c == true) goto L21;
        this.f372560c = true;
        post(new g0(this));
        goto L21
    L11:
        if (r103.contains((int) r100.getRawX(), (int) r100.getRawY()) == true) goto L13;
        goto L12
    }
}
