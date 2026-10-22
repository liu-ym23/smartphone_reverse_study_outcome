package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopSliceTopBarPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l extends b {
    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new ECShopSliceTopBarPresenter(this.l));
        return r0;
    }

    public l(Fragment r2) {
        super(2131371158, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r4) {
        FrameLayout r5 = new FrameLayout(a().getContext());
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r5;
    }
}
