package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFlowLynxCardView;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopFlowShopListPresenter extends QPresenter {
    public static final /* synthetic */ int k = 0;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final ECShopFlowShopListPresenter$onScrollListener$1 i;
    public final Fragment j;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.shopping.store.shopfeed.presenter.ECShopFlowShopListPresenter$onScrollListener$1] */
    public ECShopFlowShopListPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.j = r2;
        this.e = LazyKt.lazy(new ECShopFlowShopListPresenter$viewModel$2(this));
        this.f = LazyKt.lazy(new ECShopFlowShopListPresenter$snapHelper$2(this));
        this.g = LazyKt.lazy(new ECShopFlowShopListPresenter$listAdapter$2(this));
        this.h = LazyKt.lazy(ECShopFlowShopListPresenter$itemDecoration$2.INSTANCE);
        this.i = new ECShopFlowShopListPresenter$onScrollListener$1(this);
    }

    public final void A(QModel r8) {
        RecyclerView r0 = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386237));
        if (r0 == null) goto L5;
        int r9 = k.a;
        k.a(r0, u().c(), "ECShopFeedShopListPresenter", this.i, (ShopFeedListAdapter) this.g.getValue(), (ShopFeedListSnapHelper) this.f.getValue(), (ECShopFlowShopListPresenter$itemDecoration$2.AnonymousClass1) this.h.getValue());
    L5:
        LiveData<PagedList<com.bytedance.android.shopping.store.shopfeed.list.a>> r10 = ((ECShopFeedViewModel) this.e.getValue()).getCardList();
        if (r10 == null) goto L8;
        r10.observe(ECQuickUtilKt.a(u()), new c(this));
    L8:
        ShopFeedParam r11 = ((ECShopFeedViewModel) this.e.getValue()).getShopFeedParam();
        if (r11 == null) goto L11;
        Integer r12 = r11.getTabType();
    L12:
        int r1 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
        if (r12 != null) goto L16;
        return;
    L16:
        if (r12.intValue() != r1) goto L19;
        w().b(2131386228).f().setVisibility(8);
        return;
    L19:
        return;
    L11:
        r12 = null;
        goto L12
    }

    public static double E(View r2, RecyclerView r3) {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((double) (RangesKt.coerceAtMost(r2.getBottom(), r3.getHeight()) - RangesKt.coerceAtLeast(r2.getTop(), 0))) / ((double) r2.getHeight()), 0.0d), 1.0d);
    }

    public static final void D(ECShopFlowShopListPresenter r11, ShopFlowLynxCardView r12, RecyclerView r13, String r14) {
        r11.getClass();
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L24
        double r0 = E(r12, r13);     // Catch: Throwable -> L24
        boolean r16 = false;
        if (r0 > 0) goto L7;
    L22:
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L24
        r17.put("show_percent", r0);     // Catch: Throwable -> L24
        r17.put("scroll_direction", r14);     // Catch: Throwable -> L24
        Unit r18 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r12.c("ecom.shop_flow.card_scroll", r17);     // Catch: Throwable -> L24
        r12.setShowPercent(r0);     // Catch: Throwable -> L24
        return;
    L7:
        if (r0 >= 1) goto L22;
        if (r0 > 0.5d) goto L12;
        boolean r3 = true;
    L14:
        if (r12.getShowPercent() > 0.5d) goto L16;
        r16 = true;
    L16:
        if (r3 == false) goto L18;
        if (r16 == true) goto L18;
    L20:
        JSONObject r19 = new JSONObject();     // Catch: Throwable -> L24
        r19.put("show_percent", r0);     // Catch: Throwable -> L24
        r19.put("scroll_direction", r14);     // Catch: Throwable -> L24
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r12.c("ecom.shop_flow.card_scroll", r19);     // Catch: Throwable -> L24
    L21:
        r12.setShowPercent(r0);     // Catch: Throwable -> L24
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
        return;
    L18:
        if (r3 == true) goto L21;
        if (r16 == false) goto L21;
    L12:
        r3 = false;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
