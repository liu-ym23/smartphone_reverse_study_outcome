package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class BaseShopFeedStatusPresenter extends QPresenter {
    public static final /* synthetic */ int i = 0;
    public final Lazy e;
    public FrameLayout f;
    public final Lazy g;
    public final Fragment h;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BaseShopFeedStatusPresenter a;
        public final /* synthetic */ Map b;

        public b(BaseShopFeedStatusPresenter r1, Map r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r11) {
            LoadStatus r12 = (LoadStatus) r11;
            long r0 = System.currentTimeMillis();
            Long r2 = this.a.F().getRouterStartTime();
            if (r2 == null) goto L5;
            long r3 = r2.longValue();
        L6:
            long r1 = r0 - r3;
            if (r12 == null) goto L16;
            int r13 = com.bytedance.android.shopping.store.shopfeed.presenter.b.a[r12.ordinal()];
            if (r13 == 1) goto L32;
            if (r13 != 2) goto L13;
            FrameLayout r14 = this.a.f;
            if (r14 == null) goto L31;
            r14.setVisibility(8);
        L31:
            this.a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.b, new Pair[]{TuplesKt.to("status", "success"), TuplesKt.to("cost_time", Long.valueOf(r1))});
            return;
        L13:
            if (r13 != 3) goto L15;
            FrameLayout r15 = this.a.f;
            if (r15 == null) goto L27;
            r15.setVisibility(0);
        L27:
            this.a.E().b(com.bytedance.android.ec.store.status.b.b.a);
            this.a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.b, new Pair[]{TuplesKt.to("status", "error"), TuplesKt.to("cost_time", Long.valueOf(r1))});
            return;
        L15:
            if (r13 != 4) goto L16;
            FrameLayout r16 = this.a.f;
            if (r16 == null) goto L23;
            r16.setVisibility(0);
        L23:
            this.a.E().b(com.bytedance.android.ec.store.status.b.a.a);
            this.a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.b, new Pair[]{TuplesKt.to("status", "empty"), TuplesKt.to("cost_time", Long.valueOf(r1))});
            return;
        L32:
            FrameLayout r17 = this.a.f;
            if (r17 == null) goto L35;
            r17.setVisibility(0);
        L35:
            this.a.E().b(com.bytedance.android.ec.store.status.b.c.a);
            return;
        L16:
            FrameLayout r18 = this.a.f;
            if (r18 == null) goto L19;
            r18.setVisibility(8);
        L19:
            this.a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.b, new Pair[]{TuplesKt.to("status", "undefined"), TuplesKt.to("cost_time", Long.valueOf(r1))});
            return;
        L5:
            r3 = 0;
            goto L6
        }
    }

    static {
    }

    public final LazyStatusView E() {
        return (LazyStatusView) this.g.getValue();
    }

    public final ECShopFeedViewModel F() {
        return (ECShopFeedViewModel) this.e.getValue();
    }

    public BaseShopFeedStatusPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.h = r2;
        this.e = LazyKt.lazy(new BaseShopFeedStatusPresenter$viewModel$2(this));
        this.g = LazyKt.lazy(new BaseShopFeedStatusPresenter$statusView$2(this));
    }

    public void A(QModel r7) {
        FrameLayout r8 = (FrameLayout) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131386238));
        Integer r0 = null;
        if (r8 == null) goto L5;
        r8.addView(E());
        Unit r1 = Unit.INSTANCE;
    L6:
        this.f = r8;
        E().setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.b.a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$2(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.a.a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$3(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.c.a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$4(this), null, 6))}));
        ShopFeedParam r9 = F().getShopFeedParam();
        if (r9 == null) goto L9;
        r0 = r9.getTabType();
    L9:
        F().getLoadStatus().b(ECQuickUtilKt.a(u()), new b(this, MapsKt.mapOf(TuplesKt.to("tab_type", r0))));
        return;
    L5:
        r8 = null;
        goto L6
    }

    public View D(LazyStatusView r4) {
        Intrinsics.checkNotNullParameter(r4, "root");
        return th.a.c(u().c(), 2131560856, r4, false);
    }
}
