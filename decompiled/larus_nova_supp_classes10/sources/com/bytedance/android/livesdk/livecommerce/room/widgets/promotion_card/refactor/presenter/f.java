package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ AuctionCardPresenter a;

    public f(AuctionCardPresenter r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ExplainCardViewModel r4 = this.a.e;
        if (r4 == null) goto L8;
        QLiveData<bk2.a<Unit>> r5 = r4.getClickCloseAction();
        if (r5 == null) goto L9;
        r5.g(new bk2.a(Unit.INSTANCE));
        return;
    L9:
        return;
    }
}
