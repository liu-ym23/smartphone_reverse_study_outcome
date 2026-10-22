package com.bytedance.ee.bear.widgets;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends BaseItemAnimator.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f240153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorCompat f240154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator f240155c;

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View r100) {
        this.f240154b.setListener(null);
        this.f240155c.f(this.f240153a);
        this.f240155c.dispatchRemoveFinished(this.f240153a);
        this.f240155c.f240005j.remove(this.f240153a);
        this.f240155c.dispatchFinishedWhenDone();
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View r100) {
        this.f240155c.dispatchRemoveStarting(this.f240153a);
    }

    public c(BaseItemAnimator r100, RecyclerView.ViewHolder r101, ViewPropertyAnimatorCompat r102) {
        this.f240155c = r100;
        this.f240153a = r101;
        this.f240154b = r102;
    }
}
