package com.obric.miniapp.lynx;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e6 extends i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398079a;

    public static final class a {
    }

    static {
    }

    public final void a() {
        setClipChildren(false);
        setClipToPadding(false);
        ViewParent r100 = getParent();
        int r101 = 0;
    L4:
        if ((r100 instanceof ViewGroup) == false) goto L8;
        if (r101 >= 3) goto L11;
        ViewGroup r102 = (ViewGroup) r100;
        r102.setClipChildren(false);
        r102.setClipToPadding(false);
        r100 = r102.getParent();
        r101 = r101 + 1;
        goto L4
    L11:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
        post(new d6(this));
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        a();
        if ((r100 instanceof ViewGroup) == false) goto L5;
        ViewGroup r101 = (ViewGroup) r100;
    L6:
        if (r101 == null) goto L9;
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public e6(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f398079a = r101;
        a();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getMode(r101);
        if (r102 == Integer.MIN_VALUE) goto L8;
        if (r102 != 0) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec(this.f398079a, 1073741824);
    L10:
        super.onMeasure(r100, r101);
        return;
    L8:
        if (View.MeasureSpec.getSize(r101) != 0) goto L10;
        r101 = View.MeasureSpec.makeMeasureSpec(this.f398079a, 1073741824);
        goto L10
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        a();
    }
}
