package oj3;

import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.jvm.internal.Intrinsics;
import pj3.b;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qj3.a f523509e;

    public a(qj3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "dividerView");
        this.f523509e = r100;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        if (r100 == null) goto L16;
        b r101 = (b) r100;
        this.f523509e.getTextView().setText(r101.R);
        if (r101.T == false) goto L6;
        this.f523509e.getTextView().setVisibility(0);
    L8:
        if (r101.S.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        this.f523509e.getRecommendHeader().setVisibility(0);
        this.f523509e.getRecommendHeader().getTextView().setText(r101.S);
        return;
    L13:
        this.f523509e.getRecommendHeader().setVisibility(8);
        return;
    L10:
        r102 = false;
        goto L11
    L6:
        this.f523509e.getTextView().setVisibility(8);
        goto L8
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.store.recommend.vo.ShopAggregateDividerVO");
    }
}
