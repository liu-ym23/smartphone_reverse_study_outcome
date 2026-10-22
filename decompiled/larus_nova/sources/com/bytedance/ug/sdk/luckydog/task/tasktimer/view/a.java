package com.bytedance.ug.sdk.luckydog.task.tasktimer.view;

import android.content.Context;
import android.widget.FrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f272282a;

    public abstract void a(TimerTaskPendantState r100, int r101, Function0<Unit> r102, Function0<Unit> r103);

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        e r100 = this.f272282a;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r100 = this.f272282a;
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    public a(Context r100) {
        super(r100);
    }
}
