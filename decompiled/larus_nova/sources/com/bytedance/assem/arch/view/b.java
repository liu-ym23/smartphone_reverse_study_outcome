package com.bytedance.assem.arch.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements AsyncLayoutInflater.OnInflateFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UISlotAssem f193064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f193065b;

    public b(UISlotAssem r100, View r101) {
        this.f193064a = r100;
        this.f193065b = r101;
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final /* synthetic */ void onCancel(int r100) {
        AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
    }

    @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
    public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
        if (this.f193064a.f192854c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        ((ViewGroup) this.f193065b).addView(r100);
        UISlotAssem r103 = this.f193064a;
        r103.f193062k = r100;
        r103.f192883h = this.f193065b;
        r103.r(r100);
    }
}
