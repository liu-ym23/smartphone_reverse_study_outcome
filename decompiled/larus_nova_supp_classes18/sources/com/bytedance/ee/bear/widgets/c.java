package com.bytedance.ee.bear.widgets;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends BaseItemAnimator.f {
    public final /* synthetic */ RecyclerView.ViewHolder a;
    public final /* synthetic */ ViewPropertyAnimatorCompat b;
    public final /* synthetic */ BaseItemAnimator c;

    public final void onAnimationEnd(View r2) {
        this.b.setListener(null);
        this.c.f(this.a);
        this.c.dispatchRemoveFinished(this.a);
        this.c.j.remove(this.a);
        this.c.dispatchFinishedWhenDone();
    }

    public final void onAnimationStart(View r2) {
        this.c.dispatchRemoveStarting(this.a);
    }

    public c(BaseItemAnimator r1, RecyclerView.ViewHolder r2, ViewPropertyAnimatorCompat r3) {
        this.c = r1;
        this.a = r2;
        this.b = r3;
    }
}
