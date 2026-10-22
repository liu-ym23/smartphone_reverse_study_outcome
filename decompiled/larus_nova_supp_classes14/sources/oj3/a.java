package oj3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;
import pj3.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends QPresenter {
    public final qj3.a e;

    public a(qj3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dividerView");
        this.e = r2;
    }

    public final void A(QModel r4) {
        if (r4 == null) goto L16;
        b r5 = (b) r4;
        this.e.getTextView().setText(r5.R);
        if (r5.T == false) goto L6;
        this.e.getTextView().setVisibility(0);
    L8:
        if (r5.S.length() <= 0) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == false) goto L13;
        this.e.getRecommendHeader().setVisibility(0);
        this.e.getRecommendHeader().getTextView().setText(r5.S);
        return;
    L13:
        this.e.getRecommendHeader().setVisibility(8);
        return;
    L10:
        r0 = false;
        goto L11
    L6:
        this.e.getTextView().setVisibility(8);
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.recommend.vo.ShopAggregateDividerVO");
    }
}
