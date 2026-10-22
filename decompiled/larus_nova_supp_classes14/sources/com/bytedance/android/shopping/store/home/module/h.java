package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopVideoPreviewGroupPresenter;
import com.bytedance.android.shopping.store.home.presenter.preview.ECShopVideoPreviewPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends b {
    public final QIPresenter h() {
        ECShopVideoPreviewGroupPresenter r0 = new ECShopVideoPreviewGroupPresenter(this.l);
        r0.d0(new ECShopVideoPreviewPresenter(this.l));
        return r0;
    }

    public h(Fragment r2) {
        super(2131371107, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r3) {
        FrameLayout r4 = new FrameLayout(a().getContext());
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return r4;
    }
}
