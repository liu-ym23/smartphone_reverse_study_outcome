package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 extends com.bytedance.android.shopping.store.home.module.b {
    public final QIPresenter h() {
        return new ECShopFloatLiveIndicatorPresenter(this.l);
    }

    public d0(Fragment r2) {
        super(2131371061, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r1) {
        return com.bytedance.android.shopping.store.home.module.q.a.a(this, 2131560894);
    }
}
