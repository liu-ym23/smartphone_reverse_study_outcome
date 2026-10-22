package com.bytedance.ee.bear.widgets;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends BaseItemAnimator.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f240189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimatorCompat f240190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseItemAnimator f240191c;

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator.f, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationCancel(View r100) {
        this.f240191c.b(this.f240189a);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View r100) {
        this.f240190b.setListener(null);
        this.f240191c.dispatchAddFinished(this.f240189a);
        this.f240191c.f240003h.remove(this.f240189a);
        this.f240191c.b(this.f240189a);
        this.f240191c.dispatchFinishedWhenDone();
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View r100) {
        this.f240191c.dispatchAddStarting(this.f240189a);
    }

    public d(BaseItemAnimator r100, RecyclerView.ViewHolder r101, ViewPropertyAnimatorCompat r102) {
        this.f240191c = r100;
        this.f240189a = r101;
        this.f240190b = r102;
    }
}
