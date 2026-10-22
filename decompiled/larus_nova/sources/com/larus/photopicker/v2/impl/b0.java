package com.larus.photopicker.v2.impl;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.larus.common_ui.view.BottomOverlayViewAdapterPad;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b0 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f364329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BottomOverlayViewAdapterPad f364330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f364331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f364332d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f364333e;

    public b0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f364331c = true;
        View r101 = new View(r100);
        r101.setBackgroundColor(0);
        r101.setAlpha(0.0f);
        r101.setImportantForAccessibility(2);
        this.f364333e = r101;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (super.dispatchTouchEvent(r100) == false) goto L5;
        return true;
    L5:
        View r101 = this.f364329a;
        if (r101 != null) goto L8;
        return false;
    L8:
        Rect r102 = new Rect();
        r101.getGlobalVisibleRect(r102);
        if ((!r102.contains((int) r100.getRawX(), (int) r100.getRawY())) == true) goto L12;
        return true;
    L12:
        if (this.f364331c == false) goto L28;
        BottomOverlayViewAdapterPad r103 = this.f364330b;
        if (r103 != null) goto L17;
    L24:
        boolean r104 = false;
    L25:
        if (r104 == true) goto L29;
        return false;
    L29:
        return true;
    L17:
        if (r103.isShown() == false) goto L24;
        Rect r105 = new Rect();
        if (r103.getGlobalVisibleRect(r105) == false) goto L24;
        if (r105.contains((int) r100.getRawX(), (int) r100.getRawY()) == false) goto L24;
        r104 = true;
        goto L25
    L28:
        return true;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (this.f364332d == false) goto L14;
        if (r100.getActionMasked() != 0) goto L14;
        View r101 = this.f364329a;
        if (r101 == null) goto L14;
        Rect r102 = new Rect();
        r101.getGlobalVisibleRect(r102);
        if (r102.contains((int) r100.getRawX(), (int) r100.getRawY()) == false) goto L14;
        ViewParent r103 = getParent();
        if (r103 == null) goto L14;
        r103.requestDisallowInterceptTouchEvent(true);
    L14:
        return super.onInterceptTouchEvent(r100);
    }
}
