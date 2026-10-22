package com.obric.oui.popover.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f402433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f402434b;

    public final float getOrientationAngle() {
        return this.f402433a;
    }

    public final FrameLayout getRotationLayer() {
        return this.f402434b;
    }

    public j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        FrameLayout r101 = new FrameLayout(r100);
        r101.setClipChildren(false);
        r101.setClipToPadding(false);
        this.f402434b = r101;
        setClipChildren(false);
        setClipToPadding(false);
        super.addView(r101, -1, new ViewGroup.LayoutParams(-2, -2));
    }

    public final void setOrientationAngle(float r100) {
        this.f402433a = r100;
        this.f402434b.setRotation(r100);
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        if ((this.f402433a % 180) != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        measureChild(this.f402434b, r101, r100);
        setMeasuredDimension(this.f402434b.getMeasuredHeight(), this.f402434b.getMeasuredWidth());
        return;
    L8:
        measureChild(this.f402434b, r100, r101);
        setMeasuredDimension(this.f402434b.getMeasuredWidth(), this.f402434b.getMeasuredHeight());
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        this.f402434b.addView(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = r103 - r101;
        int r106 = this.f402434b.getMeasuredWidth();
        int r107 = this.f402434b.getMeasuredHeight();
        int r108 = (r105 - r106) / 2;
        int r109 = ((r104 - r102) - r107) / 2;
        this.f402434b.layout(r108, r109, r108 + r106, r109 + r107);
        this.f402434b.setPivotX(r106 / 2.0f);
        this.f402434b.setPivotY(r107 / 2.0f);
    }
}
