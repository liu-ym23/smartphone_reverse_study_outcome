package com.bytedance.android.shopping.store.home.module;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.home.presenter.ECStoreFloatGoTopPresenterV2;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends b {
    public final boolean d() {
        return true;
    }

    public final QIPresenter h() {
        return new ECStoreFloatGoTopPresenterV2(this.l);
    }

    public e(Fragment r2) {
        super(2131370877, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r3) {
        View r4 = new View(a().getContext());
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        r0.gravity = 17;
        Unit r1 = Unit.INSTANCE;
        r4.setLayoutParams(r0);
        r4.setBackgroundResource(2131234809);
        r4.setVisibility(8);
        return r4;
    }
}
