package com.bytedance.android.window.shop.holder.presenter;

import com.ss.android.ugc.aweme.kiwi.model.QModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class HeadAnimationPresenter extends ECWindowHolderBasePresenter {
    public final HeadAnimationPresenter$observer$1 g;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.window.shop.holder.presenter.HeadAnimationPresenter$observer$1] */
    public HeadAnimationPresenter() {
        this.g = new HeadAnimationPresenter$observer$1(this);
    }

    public final void C() {
        D().getSubCollapseProgress().removeObserver(this.g);
    }

    public final void A(QModel r3) {
        D().getSubCollapseProgress().observe(E(), this.g);
    }
}
