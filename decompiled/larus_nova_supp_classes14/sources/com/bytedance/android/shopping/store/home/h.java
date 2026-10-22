package com.bytedance.android.shopping.store.home;

import com.bytedance.android.ui.ec.widget.toast.ECToast;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ ECShopFollowBasePresenter a;

    public h(ECShopFollowBasePresenter r1) {
        this.a = r1;
    }

    public final void accept(Object r7) {
        Throwable r8 = (Throwable) r7;
        ECShopFollowBasePresenter.q0(this.a);
        ECToast.showToast$default(ECToast.INSTANCE, this.a.u().c(), ag4.a.d(2131896864), null, 4, null);
    }
}
