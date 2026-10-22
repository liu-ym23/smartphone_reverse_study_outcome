package com.bytedance.android.shopping.store.home.slice;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.shopping.store.home.module.b {
    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        r0.a(new c(this.l));
        r0.a(new ECShopSliceProfilePresenter(this.l));
        r0.a(new ECShopFollowBubbleSlicePresenter(this.l));
        return r0;
    }

    public a(Fragment r2) {
        super(2131371098, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r4) {
        FrameLayout r5 = new FrameLayout(a().getContext());
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r5.setClipChildren(false);
        r5.setClipToPadding(false);
        return r5;
    }
}
