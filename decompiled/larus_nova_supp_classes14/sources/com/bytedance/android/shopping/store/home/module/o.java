package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopTopMarqueeUDSlidePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o extends b {
    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new ECShopTopMarqueeUDSlidePresenter(this.l);
    }

    public o(Fragment r2) {
        super(2131371062, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r1) {
        return q.a.a(this, 2131560963);
    }
}
