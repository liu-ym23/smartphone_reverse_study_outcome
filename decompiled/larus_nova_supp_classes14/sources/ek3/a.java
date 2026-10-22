package ek3;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.shopfeed.presenter.ECShopInnerTopInfoSlicePresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.shopping.store.home.module.b {
    public final QIPresenter h() {
        Fragment r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return new ECShopInnerTopInfoSlicePresenter(r0);
    }

    public a(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(2131386284, r2);
    }

    @Override // com.bytedance.android.shopping.store.home.module.b
    public final View k(ViewGroup r4) {
        FrameLayout r5 = new FrameLayout(a().getContext());
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return r5;
    }
}
