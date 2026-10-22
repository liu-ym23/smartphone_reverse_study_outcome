package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopGuessLikeCardGroupPresenter$adapter$1 implements sm.h {
    public final /* synthetic */ ECShopGuessLikeCardGroupPresenter a;

    public final Function3<String, String, Long, Unit> b() {
        return null;
    }

    public final String g() {
        return null;
    }

    public final boolean h(StoreV2ProductItemVO r1) {
        return false;
    }

    public final void i(View r1) {
    }

    public final qn.a<ECVideoPlayer> k() {
        return null;
    }

    public final long l() {
        return -1;
    }

    public final boolean m(StoreV2ProductItemVO r1) {
        return false;
    }

    public final com.bytedance.android.ec.core.imagex.r p(Integer r1) {
        return null;
    }

    public final jm.a<ej3.a> q() {
        return null;
    }

    public final String a() {
        return this.a.o0().getStoreParam().getStoreAccountParam().getUserId();
    }

    public final LayoutTypes c() {
        LayoutTypes r0 = (LayoutTypes) this.a.o0().getLayoutType().getValue();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    }

    public final String d() {
        return this.a.o0().getStoreParam().getStoreAccountParam().getSecUserId();
    }

    public final Function1<Integer, Unit> e() {
        return new ECShopGuessLikeCardGroupPresenter$adapter$1$addCartListener$1(this);
    }

    public final xm.c f() {
        return this.a.o0().getTagPools();
    }

    public final boolean isClickable() {
        return !this.a.o0().getStoreParam().isPreview();
    }

    public final Integer n() {
        return this.a.o0().getTitleMaxLines();
    }

    public final xm.c o() {
        ECStoreViewModel r0 = this.a.r;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getMultiLeveViewCache();
    }

    public ECShopGuessLikeCardGroupPresenter$adapter$1(ECShopGuessLikeCardGroupPresenter r1) {
        this.a = r1;
    }

    public final com.bytedance.android.ec.core.imagex.r j(Integer r1) {
        int r2 = com.bytedance.android.ec.core.imagex.r.h;
        return com.bytedance.android.ec.core.imagex.r.a.c("ec_shop_home_guess_like_product_card");
    }
}
