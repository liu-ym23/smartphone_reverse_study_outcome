package com.bytedance.android.shopping.store.home;

import com.bytedance.android.ec.store.common.bubble.BubbleShowStrategy;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.bytedance.android.shopping.store.repository.dto.StoreFollowGiftConfig;
import com.bytedance.android.shopping.store.repository.dto.StoreV3DeleteCommitDTO;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ ECShopFollowBasePresenter a;

    public e(ECShopFollowBasePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        StoreV3DeleteCommitDTO r10 = (StoreV3DeleteCommitDTO) r9;
        if (r10.getStatusCode() == 0) goto L5;
        ECShopFollowBasePresenter.q0(this.a);
        return;
    L5:
        ECShopFollowBasePresenter r0 = this.a;
        StoreFollowGiftConfig r11 = r10.getFollowGiftConfig();
        int r1 = ECShopFollowBasePresenter.J;
        r0.t0(false, r11);
        ECToast.showToast$default(ECToast.INSTANCE, this.a.u().c(), ag4.a.d(2131896841), null, 4, null);
        ECBubbleControllerManager.b.a(this.a.W()).b(BubbleShowStrategy.ONLY_ONE_ONCE);
    }
}
