package com.bytedance.android.shopping.store.aggregate.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregatePageFragment;
import com.bytedance.android.shopping.store.aggregate.classification.CategoryInfo;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.bytedance.android.shopping.store.home.view.y;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/presenter/ShopAggregatePageGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageGroupPresenter extends QPresenter implements LifecycleObserver {
    public final Lazy e;
    public final ShopAggregatePageFragment f;

    public final ShopAggregatePageViewModel D() {
        return (ShopAggregatePageViewModel) this.e.getValue();
    }

    public ShopAggregatePageGroupPresenter(ShopAggregatePageFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.f = r2;
        this.e = LazyKt.lazy(new ShopAggregatePageGroupPresenter$viewModel$2(this));
    }

    public final void A(QModel r5) {
        View r6 = w().b(2131387282).f();
        SimpleDraweeView r0 = w().b(2131362314).f();
        ViewGroup.LayoutParams r1 = r6.getLayoutParams();
        r1.height = eh.b.b(r6.getContext());
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
        r2.height = eh.b.b(r6.getContext()) + vf4.a.a(u().c(), 34.0f);
        D().getStoreModuleDetail().b(ECQuickUtilKt.a(u()), new c(this));
        TextView r7 = (TextView) w().b(2131391172).f();
        CategoryInfo r3 = D().getStoreParam().getCategoryInfo();
        if (r3 != null) goto L5;
    L15:
        r7.setText(D().getStoreParam().getStoreUIParam().getMaterialTitle());
    L17:
        if (Intrinsics.areEqual(D().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == false) goto L20;
        View r8 = w().b(2131387435).f();
        r8.setVisibility(0);
        r8.setOnClickListener(new b(this));
    L20:
        if (D().getStoreParam().isPreview() == false) goto L22;
        FrameLayout r9 = (FrameLayout) w().b(2131387436).f();
        r9.setVisibility(0);
        r9.setBackgroundDrawable(new y(u().c(), ag4.a.d(2131914043)));
    L22:
        qi3.c r10 = new qi3.c();
        r10.d = D().getStoreParam().getStoreAccountParam().getUserId();
        r10.e = D().getStoreParam().getEntranceLocation();
        r10.a = D().getStoreParam().getEnterFrom();
        r10.f = "store_page";
        r10.b = "store_page";
        r10.c = "product_list";
        r10.g = "featured";
        r10.h = D().getStoreParam().getTempId();
        r10.i = D().getStoreParam().getProductBasicRequestParam().getMaterialId();
        if (D().getStoreParam().isPreview() == false) goto L25;
        String r4 = CommentScene.COMMENTSCENE_NO_AWEME;
    L26:
        r10.j = r4;
        r10.post(null, null);
        return;
    L25:
        r4 = "0";
        goto L26
    L5:
        if (r3.canClassificationPageShowFilterTab() != true) goto L15;
        CategoryInfo r11 = D().getStoreParam().getCategoryInfo();
        if (r11 == null) goto L13;
        Map<String, String> r12 = r11.getMainCategoryItem();
        if (r12 == null) goto L13;
        String r13 = com.bytedance.android.ecom.arch.slice.render.util.b.v(r12, "category_name", null);
        if (r13 == null) goto L13;
    L14:
        r7.setText(r13);
    L13:
        r13 = "";
        goto L14
    }
}
