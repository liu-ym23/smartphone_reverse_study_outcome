package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopFloatLynxPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f extends b {
    public final QIPresenter h() {
        return new ECShopFloatLynxPresenter(this.l);
    }

    public f(Fragment r2) {
        super(-1, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r2) {
        return new View(a().getContext());
    }
}
