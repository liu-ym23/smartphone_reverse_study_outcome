package com.bytedance.jedi.ext.adapter.decorator.internal;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f250986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<RecyclerView, Unit> f250987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<RecyclerView, Unit> f250988c;

    public e(int r100) {
        this.f250987b = null;
        this.f250988c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f250986a = (RecyclerView) r100;
        Function1<RecyclerView, Unit> r101 = this.f250987b;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke(r100);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f250986a = null;
        Function1<RecyclerView, Unit> r101 = this.f250988c;
        if (r101 == null) goto L6;
        Unit r102 = r101.invoke((RecyclerView) r100);
        return;
    }
}
