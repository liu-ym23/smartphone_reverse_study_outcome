package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class d0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f442016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f442017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<Integer, View> f442018c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f442016a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a0 r100 = this.f442017b;
        if (r100.f441993e != null) goto L5;
        return;
    L5:
        r100.f441997i.getParent().requestLayout();
        this.f442017b.a(this.f442018c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d0(View r100, a0 r101, Map<Integer, ? extends View> r102) {
        this.f442016a = r100;
        this.f442017b = r101;
        this.f442018c = r102;
    }
}
