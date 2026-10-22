package com.bytedance.android.shopping.store.home;

import com.bytedance.android.ec.store.common.bubble.BubbleShowStrategy;
import com.bytedance.android.ec.store.common.bubble.ECBubbleControllerManager;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ ECShopFollowBasePresenter a;

    public f(ECShopFollowBasePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        ECToast r0 = ECToast.INSTANCE;
        ECShopFollowBasePresenter r9 = this.a;
        int r1 = ECShopFollowBasePresenter.J;
        ECToast.showToast$default(r0, r9.u().c(), ag4.a.d(2131896864), null, 4, null);
        ECShopFollowBasePresenter.q0(this.a);
        ECBubbleControllerManager.b.a(this.a.W()).b(BubbleShowStrategy.ONLY_ONE_ONCE);
    }
}
