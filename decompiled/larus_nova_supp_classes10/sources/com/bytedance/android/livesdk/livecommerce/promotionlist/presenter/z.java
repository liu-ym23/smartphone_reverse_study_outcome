package com.bytedance.android.livesdk.livecommerce.promotionlist.presenter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class z implements Runnable {
    public final /* synthetic */ LivePromotionListTabPresenter a;

    public z(LivePromotionListTabPresenter r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L13:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    L21:
        return;
    L3:
        if (LivePromotionListTabPresenter.h0(this.a).canScrollHorizontally(-1) == false) goto L5;
    L9:
        LivePromotionListTabPresenter r0 = this.a;     // Catch: Throwable -> L13
        r0.m = true;     // Catch: Throwable -> L13
        ConstraintLayout r1 = r0.l;     // Catch: Throwable -> L13
        if (r1 == null) goto L18;
        r1.setVisibility(0);     // Catch: Throwable -> L13
    L18:
        return;
    L5:
        if (LivePromotionListTabPresenter.h0(this.a).canScrollHorizontally(1) == true) goto L9;
        ConstraintLayout r2 = this.a.l;     // Catch: Throwable -> L13
        if (r2 == null) goto L18;
        r2.setVisibility(8);     // Catch: Throwable -> L13
        goto L18
    }
}
