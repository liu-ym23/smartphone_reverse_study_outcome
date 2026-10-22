package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.recommend.widget.ShopRecommendDividerView;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopRecommendDividerLinePresenter extends QFragmentPresenter {
    public final Lazy f;
    public final ShopRecommendDividerView g;

    public static final class a implements Runnable {
        public final /* synthetic */ ECShopRecommendDividerLinePresenter a;

        public a(ECShopRecommendDividerLinePresenter r1) {
            this.a = r1;
        }

        public final void a() {
            Object r0 = this.a.a0().getParent();
            if ((r0 instanceof View) == true) goto L5;
            r0 = null;
        L5:
            View r1 = (View) r0;
            if (r1 != null) goto L8;
            r1 = this.a.a0();
        L8:
            ECShopHybridProductViewModel r2 = (ECShopHybridProductViewModel) this.a.f.getValue();
            if (r2 == null) goto L24;
            PageFinder r4 = PageFinder.via(r1);
            Pair[] r3 = new Pair[2];
            r3[0] = TuplesKt.to("tab_name", "products");
            ECShopHybridProductViewModel r5 = (ECShopHybridProductViewModel) this.a.f.getValue();
            if (r5 == null) goto L21;
            jm.a<com.bytedance.android.ec.store.repository.vo.n> r6 = r5.getDiscountButton();
            if (r6 == null) goto L21;
            com.bytedance.android.ec.store.repository.vo.n r7 = (com.bytedance.android.ec.store.repository.vo.n) r6.getValue();
            if (r7 == null) goto L21;
            List r8 = r7.a;
            if (r8 == null) goto L21;
            if ((!r8.isEmpty()) != true) goto L21;
            String r9 = "shop_recommend";
        L22:
            r3[1] = TuplesKt.to("module_name", r9);
            r2.doAnyEventActionWithBtm("a1.b6269.c2429.d63444", r4, "show_ecom_component", MapsKt.mapOf(r3), new Pair[0]);
            return;
        L21:
            r9 = "feed_product";
            goto L22
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void b0(QModel r2) {
        if ((r2 instanceof pj3.a) == true) goto L5;
        r2 = null;
    L5:
        pj3.a r3 = (pj3.a) r2;
        if (r3 == null) goto L8;
        Lazy r0 = ECImageHelper.a;
        ECImageHelper.b(this.g.getImageView(), r3.a);
    L8:
        a0().post(new a(this));
    }

    public ECShopRecommendDividerLinePresenter(final Fragment r2, ShopRecommendDividerView r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "dividerView");
        super(r2);
        this.g = r3;
        this.f = LazyKt.lazy(new ECShopRecommendDividerLinePresenter$viewModel$2(this, r2));
    }
}
