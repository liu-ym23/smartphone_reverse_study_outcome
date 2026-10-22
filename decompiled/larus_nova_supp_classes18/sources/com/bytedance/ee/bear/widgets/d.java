package com.bytedance.ee.bear.widgets;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends BaseItemAnimator.f {
    public final /* synthetic */ RecyclerView.ViewHolder a;
    public final /* synthetic */ ViewPropertyAnimatorCompat b;
    public final /* synthetic */ BaseItemAnimator c;

    @Override // com.bytedance.ee.bear.widgets.BaseItemAnimator.f
    public final void onAnimationCancel(View r2) {
        this.c.b(this.a);
    }

    public final void onAnimationEnd(View r2) {
        this.b.setListener(null);
        this.c.dispatchAddFinished(this.a);
        this.c.h.remove(this.a);
        this.c.b(this.a);
        this.c.dispatchFinishedWhenDone();
    }

    public final void onAnimationStart(View r2) {
        this.c.dispatchAddStarting(this.a);
    }

    public d(BaseItemAnimator r1, RecyclerView.ViewHolder r2, ViewPropertyAnimatorCompat r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
