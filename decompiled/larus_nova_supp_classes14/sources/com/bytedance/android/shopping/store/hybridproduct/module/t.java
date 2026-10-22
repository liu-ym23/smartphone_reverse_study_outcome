package com.bytedance.android.shopping.store.hybridproduct.module;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopMemberCardPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends rm.a {
    public final Fragment m;

    public final QIPresenter h() {
        QGroupPresenter r0 = new QGroupPresenter();
        Fragment r2 = this.m;
        View r3 = ((rm.a) this).l;
        if (r3 == null) goto L7;
        r0.a(new ECShopMemberCardPresenter(r2, (ViewGroup) r3));
        return r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public t(Fragment r2, View r3, LayoutTypes r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "itemView");
        Intrinsics.checkNotNullParameter(r4, "layoutType");
        super(r3);
        this.m = r2;
    }
}
