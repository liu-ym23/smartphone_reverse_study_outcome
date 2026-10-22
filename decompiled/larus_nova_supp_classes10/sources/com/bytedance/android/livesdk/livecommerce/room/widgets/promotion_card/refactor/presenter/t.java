package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t implements Runnable {
    public final /* synthetic */ ExtendInfoRootPresenter.a a;
    public final /* synthetic */ ECUIPromotion b;

    public t(ExtendInfoRootPresenter.a r1, ECUIPromotion r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        this.a.a.u().d().q(rk2.i.class, 0);
        ExplainCardViewModel r0 = this.a.a.e;
        if (r0 == null) goto L8;
        QLiveData<pk2.d> r1 = r0.getCardExtendInfoState();
        if (r1 == null) goto L9;
        r1.e(new pk2.d(this.b.extendInfo, 2));
        return;
    L9:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
