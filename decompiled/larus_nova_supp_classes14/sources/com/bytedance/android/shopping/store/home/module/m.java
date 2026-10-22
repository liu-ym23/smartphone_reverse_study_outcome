package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECShopProductTabSlideHintPresenter;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class m extends b {
    public final QIPresenter h() {
        return new ECShopProductTabSlideHintPresenter(this.l);
    }

    public m(Fragment r2) {
        super(2131370953, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r2) {
        View r3 = q.a.a(this, 2131560906);
        r3.setAlpha(0.75f);
        ExtensionsKt.gone(r3);
        return r3;
    }
}
