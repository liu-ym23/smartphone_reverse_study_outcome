package com.larus.common_ui.floatwindow.view;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleFloatBall f327563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f327564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f327565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f327566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f327567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f327568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f327569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f327570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f327571i;

    public z(SingleFloatBall r100) {
        Intrinsics.checkNotNullParameter(r100, "ball");
        this.f327563a = r100;
        ViewConfiguration r101 = ViewConfiguration.get(r100.getContext());     // Catch: Exception -> L5
        int r102 = r101.getScaledTouchSlop() * r101.getScaledTouchSlop();
    L6:
        this.f327565c = r102;
        this.f327566d = ViewConfiguration.getTapTimeout();
        return;
    L5:
        r102 = 576;
        goto L6
    }

    public final void a(View r100, MotionEvent r101) {
        this.f327567e = r101.getRawX();
        this.f327568f = r101.getRawY();
        ViewParent r102 = r100.getParent();
        boolean r103 = r102 instanceof ViewGroup;
        if (r103 == false) goto L5;
        int r104 = ((ViewGroup) r102).getWidth();
    L6:
        this.f327569g = r104;
        if (r103 == false) goto L9;
        ((ViewGroup) r102).getHeight();
    L11:
        if (this.f327564b == null) goto L13;
        this.f327570h = SystemClock.uptimeMillis();
    L13:
        this.f327571i = false;
        return;
    L9:
        int r105 = com.larus.utils.m0.f375450a;
        com.larus.utils.m0.a(r100.getContext());
        goto L11
    L5:
        r104 = com.larus.utils.i.d(r100.getContext());
        goto L6
    }
}
