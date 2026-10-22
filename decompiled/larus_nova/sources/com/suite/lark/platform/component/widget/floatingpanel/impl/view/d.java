package com.suite.lark.platform.component.widget.floatingpanel.impl.view;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends ViewGroup implements MessageQueue.IdleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f460784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<? extends View> f460785b;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (getChildCount() != 0) goto L11;
        Function0<? extends View> r100 = this.f460785b;
        if (r100 == null) goto L8;
        a(r100.invoke());
        return true;
    L8:
        Log.w("FloatingCardWrapperView", "lazyCard is not set");
        return false;
    L11:
        return false;
    }

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        b();
        return false;
    }

    public final String getCardId() {
        return this.f460784a;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        setId(View.generateViewId());
    }

    private final void setLazyCard(Function0<? extends View> r100) {
        if (this.f460785b == null) goto L5;
        return;
    L5:
        this.f460785b = r100;
    }

    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "cardView");
        if (r100.getParent() == null) goto L14;
        if (Intrinsics.areEqual(r100.getParent(), this) == false) goto L7;
        return;
    L7:
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L10;
        ViewGroup r102 = (ViewGroup) r101;
    L11:
        if (r102 == null) goto L14;
        r102.removeView(r100);
        goto L14
    L10:
        r102 = null;
    L14:
        if (r100.getLayoutParams() != null) goto L16;
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    L16:
        addView(r100);
    }

    public final void setCardId(String r100) {
        this.f460784a = r100;
    }

    public final void c(Function0<? extends View> r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lazyCard");
        setLazyCard(r100);
        if (r101 == false) goto L6;
        Looper.myQueue().addIdleHandler(this);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = View.MeasureSpec.getSize(r100);
        if (getChildCount() != 0) goto L6;
        setMeasuredDimension(r102, 0);
        return;
    L6:
        View r103 = getChildAt(0);
        measureChild(r103, r100, r101);
        setMeasuredDimension(r102, r103.getMeasuredHeight());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (getChildCount() != 0) goto L5;
        return;
    L5:
        View r105 = getChildAt(0);
        r105.layout(0, getHeight() - r105.getMeasuredHeight(), r105.getMeasuredWidth(), getHeight());
    }
}
