package com.bytedance.assem.arch.reused;

import android.view.View;
import android.view.ViewGroup;
import androidx.asynclayoutinflater.view.AsyncLayoutInflater;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q implements AsyncLayoutInflater.OnInflateFinishedListener {
    public final /* synthetic */ ReusedUISlotAssem a;
    public final /* synthetic */ View b;

    public q(ReusedUISlotAssem r1, View r2) {
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
        ReusedUISlotAssem r4 = this.a;
        r4.h = this.b;
        r4.A = r1;
        r4.p(r1);
        this.a.getClass();
    }
}
