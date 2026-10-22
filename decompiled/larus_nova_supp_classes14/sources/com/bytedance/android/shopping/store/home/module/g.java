package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopExplainCardPresenter;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopHeaderPreviewGroupPresenter;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopLivePreviewPresenter;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopPreviewBottomInfoPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class g extends b {
    public final QIPresenter h() {
        ECShopHeaderPreviewGroupPresenter r0 = new ECShopHeaderPreviewGroupPresenter(this.l);
        r0.d0(new ECShopLivePreviewPresenter(this.l));
        r0.d0(new ECShopPreviewBottomInfoPresenter(this.l));
        r0.d0(new ECShopExplainCardPresenter(this.l));
        return r0;
    }

    public g(Fragment r2) {
        super(2131371107, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r3) {
        FrameLayout r4 = new FrameLayout(a().getContext());
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
