package com.ss.android.lark.keyboard.ime;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImeWrapper f429390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f429391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f429392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f429393d;

    public static final class a {
    }

    public static final class b implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f429394a;

        public b(h r100) {
            this.f429394a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            h r100 = this.f429394a;
            r100.f429391b = false;
            r100.measure(View.MeasureSpec.makeMeasureSpec(r100.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r100.getMeasuredHeight(), 1073741824));
            r100.layout(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
            return false;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Looper.myQueue().removeIdleHandler(this.f429393d);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (this.f429390a.T() == true) goto L7;
        return;
    L7:
        if (this.f429391b == true) goto L12;
        Log.i("ImePanelContainer", "ImePanelContainer: requestLayout called, but keyboard is in animation. Measure and layout by self");
        this.f429391b = true;
        Looper.myQueue().addIdleHandler(this.f429393d);
        return;
    }

    public final void setExpectHeight(int r100) {
        if (r100 > 0) goto L4;
        return;
    L4:
        if (r100 == this.f429392c) goto L12;
        this.f429392c = r100;
        ViewGroup.LayoutParams r101 = getLayoutParams();
        if (r101 == null) goto L9;
        r101.height = r100;
    L9:
        requestLayout();
        return;
    }

    public h(Context r100, ImeWrapper r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imeWrapper");
        super(r100);
        this.f429390a = r101;
        this.f429392c = -1;
        this.f429393d = new b(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f429392c;
        if (r102 <= 0) goto L5;
        r101 = View.MeasureSpec.makeMeasureSpec(r102, 1073741824);
    L5:
        super.onMeasure(r100, r101);
    }
}
