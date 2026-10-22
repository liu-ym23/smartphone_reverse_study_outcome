package com.bytedance.ies.xelement.viewpager.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.google.android.material.tabs.TabLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/xelement/viewpager/tabbar/LynxTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "", "enable", "", "setNewGesture", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getMaxScrollXOffset", "()I", "setMaxScrollXOffset", "(I)V", "maxScrollXOffset", "b", "Z", "isNewGestureEnable", "()Z", "setNewGestureEnable", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "x-element-fold-view_release"}, k = 1, mv = {1, 6, 0})
public final class LynxTabLayout extends TabLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f250583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f250584b;

    public final int getMaxScrollXOffset() {
        return this.f250583a;
    }

    public LynxTabLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getAction());
    L5:
        if (r101 == null) goto L17;
        if (r101.intValue() != 2) goto L17;
        if (this.f250584b == false) goto L17;
        if (getScrollX() < this.f250583a) goto L14;
    L15:
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L17
    L14:
        if (getScrollX() <= 0) goto L15;
    L17:
        return super.dispatchTouchEvent(r100);
    L4:
        r101 = null;
        goto L5
    }

    public final void setMaxScrollXOffset(int r100) {
        this.f250583a = r100;
    }

    public final void setNewGesture(boolean r100) {
        this.f250584b = r100;
    }

    public final void setNewGestureEnable(boolean r100) {
        this.f250584b = r100;
    }

    public LynxTabLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101);
        this.f250583a = Integer.MAX_VALUE;
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getChildCount() <= 0) goto L6;
        this.f250583a = getChildAt(0).getWidth() - getWidth();
        return;
    }
}
