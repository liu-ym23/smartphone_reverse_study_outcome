package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListStyleDTO;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends BaseShopFeedStatusPresenter {

    public static final class a<T> implements Observer {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            ECHybridListStyleDTO r4 = (ECHybridListStyleDTO) r3;
            if (r4 == null) goto L13;
            int r0 = s.a;
            Integer r5 = s.b(r4.getBackgroundColor());
            if (r5 == null) goto L11;
            int r6 = r5.intValue();
            View r1 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.a.w().b(2131370872));
            if (r1 == null) goto L12;
            r1.setBackgroundColor(r6);
            return;
        L12:
            return;
        L11:
            return;
        }
    }

    public d(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.BaseShopFeedStatusPresenter
    public final void A(QModel r4) {
        super.A(r4);
        F().getListStyle().a(u().e(), new a(this), false);
    }

    @Override // com.bytedance.android.shopping.store.shopfeed.presenter.BaseShopFeedStatusPresenter
    public final View D(LazyStatusView r4) {
        Intrinsics.checkNotNullParameter(r4, "root");
        return th.a.c(u().c(), 2131560860, r4, false);
    }
}
