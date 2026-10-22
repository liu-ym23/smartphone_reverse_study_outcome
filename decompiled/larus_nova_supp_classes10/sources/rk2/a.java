package rk2;

import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends e {
    public final QIPresenter h() {
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_ATMOSPHERE_OPT_SWITCH() == false) goto L6;
        return new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.d();
    L6:
        return new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.a();
    }

    public a() {
    }
}
