package com.bytedance.assem.arch.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements AsyncLayoutInflater.OnInflateFinishedListener {
    public final /* synthetic */ UISlotAssem a;
    public final /* synthetic */ View b;

    public b(UISlotAssem r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    public final /* synthetic */ void onCancel(int r1) {
        AsyncLayoutInflater.OnInflateFinishedListener.-CC.$default$onCancel(this, r1);
    }

    public final void onInflateFinished(View r1, int r2, ViewGroup r3) {
        if (this.a.c.getCurrentState() != Lifecycle.State.DESTROYED) goto L5;
        return;
    L5:
        ((ViewGroup) this.b).addView(r1);
        UISlotAssem r4 = this.a;
        r4.k = r1;
        r4.h = this.b;
        r4.r(r1);
    }
}
