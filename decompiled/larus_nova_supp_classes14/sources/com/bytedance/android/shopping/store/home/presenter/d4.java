package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.LoadMoreStatusView;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d4 extends QFragmentPresenter implements View.OnClickListener {
    public ShopAggregatePageProductViewModel f;
    public String g;

    public static final class a<T> implements Observer {
        public final /* synthetic */ d4 a;

        public a(d4 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            LoadStatus r3 = (LoadStatus) r2;
            if (r3 == null) goto L19;
            this.a.d0(r3);
            if (r3 != LoadStatus.LoadMoreEnd) goto L17;
            ShopAggregatePageProductViewModel r4 = this.a.f;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L11:
            if (r4.getObserveFlag() == true) goto L18;
            ShopAggregatePageProductViewModel r5 = this.a.f;
            if (r5 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L15:
            r5.setObserveFlag(true);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public final void b0(QModel r7) {
        ShopAggregatePageProductViewModel r8 = Y().g(ShopAggregatePageProductViewModel.class);
        this.f = r8;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        d0((LoadStatus) r8.getLoadStatus().a());
        ShopAggregatePageProductViewModel r9 = this.f;
        if (r9 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        if (((LoadStatus) r9.getLoadStatus().a()) != LoadStatus.LoadMoreEnd) goto L33;
        ShopAggregatePageProductViewModel r10 = this.f;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L14:
        if (r10.getObserveFlag() == false) goto L33;
        ShopAggregatePageProductViewModel r11 = this.f;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        if (r11.getReportFlag() == true) goto L33;
        ShopAggregatePageProductViewModel r12 = this.f;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r1[1] = TuplesKt.to("enter_from", "store_page_bottom");
        ShopAggregatePageProductViewModel r2 = this.f;
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        r1[2] = TuplesKt.to("author_id", r2.getStoreParam().getStoreAccountParam().getUserId());
        r1[3] = TuplesKt.to("store_type", "window");
        r12.doEventAction("show_store_entrance", r1);
        ShopAggregatePageProductViewModel r13 = this.f;
        if (r13 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L29:
        r13.setReportFlag(true);
        ShopAggregatePageProductViewModel r14 = this.f;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L32:
        r14.setObserveFlag(false);
    L33:
        ShopAggregatePageProductViewModel r15 = this.f;
        if (r15 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        r15.getLoadStatus().b(ECQuickUtilKt.a(Y()), new a(this));
    }

    public final void d0(LoadStatus r13) {
        if (r13 == null) goto L9;
        int r14 = com.bytedance.android.shopping.store.product.d.a[r13.ordinal()];
        if (r14 == 1) goto L13;
        if (r14 == 2) goto L11;
        if (r14 != 3) goto L9;
        Z().b(2131387793).f().b();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        ECToast.showToast$default(ECToast.INSTANCE, Y().c(), 2131913855, null, 4, null);
        return;
    L11:
        LoadMoreStatusView r15 = Z().b(2131387793).f();
        r15.setVisibility(0);
        r15.a();
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
    L12:
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(8);
        return;
    L13:
        ShopAggregatePageProductViewModel r16 = this.f;
        if (r16 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        PagedList r17 = (PagedList) r16.getProducts().getValue();
        if (r17 == null) goto L19;
        Integer r18 = Integer.valueOf(r17.size());
    L21:
        if (com.bytedance.android.shopping.extensions.k.f(r18) >= 5) goto L37;
        ShopAggregatePageProductViewModel r19 = this.f;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L26:
        if (r19.getReportFlag() == true) goto L37;
        ShopAggregatePageProductViewModel r110 = this.f;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        Pair[] r8 = new Pair[4];
        r8[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r8[1] = TuplesKt.to("enter_from", "store_page_bottom");
        ShopAggregatePageProductViewModel r10 = this.f;
        if (r10 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        r8[2] = TuplesKt.to("author_id", r10.getStoreParam().getStoreAccountParam().getUserId());
        r8[3] = TuplesKt.to("store_type", "window");
        r110.doEventAction("show_store_entrance", r8);
        ShopAggregatePageProductViewModel r111 = this.f;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        r111.setReportFlag(true);
    L37:
        Lazy r112 = ECAppInfoService.a;
        if (we.a.a == true) goto L40;
        Z().b(2131387793).f().setVisibility(8);
    L41:
        ((RelativeLayout) Z().b(2131384703).f()).setVisibility(0);
        ShopAggregatePageProductViewModel r113 = this.f;
        if (r113 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        if (r113.getStoreParam().getStoreNaviParam().getProductShopEntry() == false) goto L65;
        ((TextView) Z().b(2131391174).f()).setVisibility(8);
        ((LinearLayout) Z().b(2131383173).f()).setVisibility(0);
        ((LinearLayout) Z().b(2131387429).f()).setVisibility(0);
        ShopAggregatePageProductViewModel r114 = this.f;
        if (r114 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        this.g = r114.getStoreParam().getStoreNaviParam().getShopUrl();
        ShopAggregatePageProductViewModel r115 = this.f;
        if (r115 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L53:
        if (r115.getStoreParam().getStoreNaviParam().getShopProductCount() == null) goto L64;
        ShopAggregatePageProductViewModel r116 = this.f;
        if (r116 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        if (com.bytedance.android.shopping.extensions.k.f(r116.getStoreParam().getStoreNaviParam().getShopProductCount()) < 4) goto L64;
        TextView r117 = (TextView) Z().b(2131387478).f();
        Z().b(2131387432).f().setImageDrawable(th.a.b(Y().c(), 2131248166));
        r117.setText(ag4.a.a(2131895805, CollectionsKt.emptyList()));
        TextView r118 = (TextView) Z().b(2131383172).f();
        int r2 = com.bytedance.android.shopping.utils.k0.a;
        ShopAggregatePageProductViewModel r3 = this.f;
        if (r3 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L63:
        r118.setText(ag4.a.a(2131914037, CollectionsKt.listOf(com.bytedance.android.shopping.utils.k0.a(com.bytedance.android.shopping.extensions.k.f(r3.getStoreParam().getStoreNaviParam().getShopProductCount())))));
        ((LinearLayout) Z().b(2131387429).f()).setOnClickListener(this);
    L64:
        ((LinearLayout) Z().b(2131387429).f()).setVisibility(8);
    L65:
        ((TextView) Z().b(2131391171).f()).setVisibility(8);
        return;
    L40:
        ((TextView) Z().b(2131389441).f()).setVisibility(8);
        goto L41
    L19:
        r18 = null;
    L9:
        Z().b(2131387793).f().b();
        goto L12
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        Context r0 = null;
        if (r10 == null) goto L5;
        Integer r11 = Integer.valueOf(r10.getId());
    L6:
        if (r11 != null) goto L9;
        return;
    L9:
        if (r11.intValue() != 2131387429) goto L30;
        String r12 = this.g;
        if (r12 == null) goto L22;
        com.bytedance.android.ec.core.utils.m0 r5 = new com.bytedance.android.ec.core.utils.m0(r12);
        r5.b("enter_from", "store_page_bottom");
        r5.b("entrance_location", "store_page_bottom");
        ShopAggregatePageProductViewModel r13 = this.f;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        r5.b("pass_through_api", (String) r13.getStoreParam().getPassThroughParam("pass_through_api"));
        String r14 = r5.c();
        com.bytedance.android.ec.sdk.helper.p r6 = com.bytedance.android.ec.sdk.helper.p.a;
        QContext r7 = Y();
        Context r8 = com.bytedance.android.ec.core.utils.l0.c(r7.c());
        if ((r8 instanceof FragmentActivity) == false) goto L19;
        r0 = r8;
    L19:
        if (r0 != null) goto L21;
        r0 = r7.a();
    L21:
        r6.openSchema(r0, r14);
    L22:
        ShopAggregatePageProductViewModel r15 = this.f;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        Pair[] r1 = new Pair[4];
        r1[0] = TuplesKt.to("entrance_location", "store_page_bottom");
        r1[1] = TuplesKt.to("enter_from", "store_page_bottom");
        ShopAggregatePageProductViewModel r2 = this.f;
        if (r2 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r1[2] = TuplesKt.to("author_id", r2.getStoreParam().getStoreAccountParam().getUserId());
        r1[3] = TuplesKt.to("store_type", "window");
        r15.doEventAction("click_store_entrance", r1);
        return;
    L30:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public d4(Fragment r2, RecyclerView r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        super(r2);
    }
}
