package com.bytedance.android.shopping.store.aggregate.presenter;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.r;
import com.bytedance.android.ec.store.sortbar.ECStoreSortBarBasePresenter;
import com.bytedance.android.ec.store.sortbar.HorizonSortBarAdapter;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageViewModel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopAggregatePageSortBarPresenter extends ECStoreSortBarBasePresenter {
    public static final /* synthetic */ int q = 0;
    public final Lazy k;
    public final Lazy l;
    public boolean m;
    public final a n;
    public final c o;
    public final d p;

    public static final class a implements com.bytedance.android.ec.store.sortbar.k {
        public final /* synthetic */ ShopAggregatePageSortBarPresenter a;

        public final void isInShop() {
        }

        public final void j() {
        }

        public final jm.a<LayoutTypes> a() {
            return this.a.k0().getLayoutType();
        }

        public final void b() {
            this.a.k0().setExchangeLayout(true);
        }

        public final boolean g() {
            return Intrinsics.areEqual(this.a.k0().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType());
        }

        public final jm.a<List<r>> i() {
            return this.a.k0().getSortTypes();
        }

        public final String l() {
            return this.a.k0().getStoreParam().getSecShopId();
        }

        public final void c() {
            if (com.bytedance.android.shopping.store.settings.c.a() != 1) goto L10;
            q r0 = q.a;
            LayoutTypes r1 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
            int r2 = r0.getInt("classification_local_product_card_layout_type", r1.getType());
            LayoutTypes r3 = LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE;
            if (r2 != r3.getType()) goto L7;
            r1 = r3;
        L8:
            this.a.k0().getLayoutType().setValue(r1);
            return;
        L7:
            r1.getType();
            goto L8
        }

        public final boolean h() {
            if (g() == true) goto L5;
        L7:
            return false;
        L5:
            if (com.bytedance.android.shopping.store.settings.c.a() != 1) goto L7;
            return true;
        }

        public final Boolean m() {
            return Boolean.FALSE;
        }

        public a(ShopAggregatePageSortBarPresenter r1) {
            this.a = r1;
        }

        public final void d(LayoutTypes r3) {
            Intrinsics.checkNotNullParameter(r3, "layoutType");
            if (com.bytedance.android.shopping.store.settings.c.a() != 1) goto L8;
            LayoutTypes r4 = (LayoutTypes) this.a.k0().getLayoutType().getValue();
            if (r4 == null) goto L9;
            int r5 = r4.getType();
            q.a.d("classification_local_product_card_layout_type", r5);
            return;
        L9:
            return;
        }

        public final void e(LayoutTypes r3) {
            Intrinsics.checkNotNullParameter(r3, "layoutType");
            jm.a<LayoutTypes> r0 = this.a.k0().getLayoutType();
            if (((LayoutTypes) r0.getValue()) == r3) goto L6;
            r0.setValue(r3);
            return;
        }

        public final void k(List<r> r4) {
            Intrinsics.checkNotNullParameter(r4, "sortTypes");
            Iterator<T> r0 = r4.iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            Object r1 = r0.next();
            if (((r) r1).c == false) goto L4;
        L10:
            if (r1 != null) goto L14;
            r r5 = (r) CollectionsKt.firstOrNull(r4);
            if (r5 == null) goto L14;
            r5.c = true;
        L14:
            ShopAggregatePageSortBarPresenter r6 = this.a;
            if (r6.m == true) goto L22;
            r6.m = true;
            r6.k0().getSortTypes().a(((QFragmentPresenter) r6).e, new m(r6), false);
            return;
        L22:
            return;
        L8:
            r1 = null;
            goto L10
        }

        public final void f(Long r3, Integer r4) {
            this.a.k0().getMmRvScrollY().setValue(0);
            this.a.k0().refreshBySortAndSortType(r3, r4);
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ShopAggregatePageSortBarPresenter a;

        public b(ShopAggregatePageSortBarPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            Unit r9 = (Unit) r8;
            ShopAggregatePageSortBarPresenter r10 = this.a;
            RecyclerView.Adapter r0 = ((RecyclerView) ((ECStoreSortBarBasePresenter) r10).f.getValue()).getAdapter();
            if ((r0 instanceof HorizonSortBarAdapter) == true) goto L5;
            r0 = null;
        L5:
            HorizonSortBarAdapter r1 = (HorizonSortBarAdapter) r0;
            if (r1 == null) goto L33;
            List r2 = r1.c;
            if (r2 == null) goto L15;
            r r3 = (r) CollectionsKt.firstOrNull(r2);
            if (r3 == null) goto L15;
            if (r3.c == true) goto L33;
        L15:
            List r4 = r1.c;
            if (r4 == null) goto L28;
            Iterator<T> r5 = r4.iterator();
            int r6 = 0;
        L19:
            if (r5.hasNext() == false) goto L28;
            T r7 = r5.next();
            int r11 = r6 + 1;
            if (r6 >= 0) goto L23;
            CollectionsKt.throwIndexOverflow();
        L23:
            r r12 = (r) r7;
            if (r6 != 0) goto L26;
            boolean r13 = true;
        L27:
            r12.c = r13;
            r6 = r11;
            goto L19
        L26:
            r13 = false;
        L28:
            r1.notifyDataSetChanged();
            List r14 = r1.c;
            if (r14 == null) goto L33;
            r r15 = (r) CollectionsKt.firstOrNull(r14);
            if (r15 == null) goto L33;
            r10.n.f(Long.valueOf(r15.a), Integer.valueOf(r15.e));
        L33:
            ShopAggregatePageSortBarPresenter r16 = this.a;
            r16.i0(((ShopAggregatePageViewModel) r16.l.getValue()).getLayoutType());
        }
    }

    public static final class c implements com.bytedance.android.ec.store.sortbar.j {
        public final /* synthetic */ ShopAggregatePageSortBarPresenter a;

        public c(ShopAggregatePageSortBarPresenter r1) {
            this.a = r1;
        }

        public final void a(r r8) {
            Intrinsics.checkNotNullParameter(r8, "sortType");
            this.a.k0().doAnyEventActionWithBtm("a1.b56317.c2429.d57203", PageFinder.via(this.a.a0()), "click_ecommerce_store_sort", MapsKt.mapOf(new Pair[]{TuplesKt.to("order_type", r8.b), TuplesKt.to("order_ascending", String.valueOf(r8.e))}), new Pair[0]);
        }
    }

    public static final class d implements com.bytedance.android.ec.store.sortbar.l {
        public final /* synthetic */ ShopAggregatePageSortBarPresenter a;

        public final void a() {
            ShopAggregatePageProductViewModel r0 = this.a.k0();
            Pair[] r1 = new Pair[10];
            r1[0] = TuplesKt.to("store_type", "shop");
            r1[1] = TuplesKt.to("author_id", this.a.k0().getStoreParam().getStoreAccountParam().getUserId());
            r1[2] = TuplesKt.to("shop_id", this.a.k0().getStoreParam().getShopId());
            r1[3] = TuplesKt.to("follow_status", String.valueOf(this.a.k0().getStoreParam().getFollowStatus()));
            r1[4] = TuplesKt.to("entrance_location", this.a.k0().getStoreParam().getEntranceLocation());
            r1[5] = TuplesKt.to("store_source_page", this.a.k0().getStoreParam().getStoreSourcePage());
            r1[6] = TuplesKt.to("store_source_method", this.a.k0().getStoreParam().getStoreSourceMethod());
            r1[7] = TuplesKt.to("store_group_type", this.a.k0().getStoreParam().getStoreGroupType());
            LayoutTypes r2 = (LayoutTypes) this.a.k0().getLayoutType().getValue();
            if (r2 == null) goto L8;
            int r3 = l.b[r2.ordinal()];
            if (r3 == 1) goto L10;
            if (r3 != 2) goto L8;
            String r4 = "double_product";
        L11:
            r1[8] = TuplesKt.to("switch_type", r4);
            r1[9] = TuplesKt.to("tab_name", "classification");
            r0.doEventAction("store_product_form_switch_show", r1);
            return;
        L10:
            r4 = "single_product";
        L8:
            r4 = null;
            goto L11
        }

        public final void onClick() {
            ShopAggregatePageProductViewModel r0 = this.a.k0();
            Pair[] r1 = new Pair[10];
            r1[0] = TuplesKt.to("author_id", this.a.k0().getStoreParam().getStoreAccountParam().getUserId());
            r1[1] = TuplesKt.to("store_type", "shop");
            r1[2] = TuplesKt.to("shop_id", this.a.k0().getStoreParam().getShopId());
            r1[3] = TuplesKt.to("follow_status", String.valueOf(this.a.k0().getStoreParam().getFollowStatus()));
            r1[4] = TuplesKt.to("entrance_location", this.a.k0().getStoreParam().getEntranceLocation());
            r1[5] = TuplesKt.to("store_source_page", this.a.k0().getStoreParam().getStoreSourcePage());
            r1[6] = TuplesKt.to("store_source_method", this.a.k0().getStoreParam().getStoreSourceMethod());
            r1[7] = TuplesKt.to("store_group_type", this.a.k0().getStoreParam().getStoreGroupType());
            LayoutTypes r2 = (LayoutTypes) this.a.k0().getLayoutType().getValue();
            if (r2 == null) goto L8;
            int r3 = l.a[r2.ordinal()];
            if (r3 == 1) goto L10;
            if (r3 != 2) goto L8;
            String r4 = "double_product";
        L11:
            r1[8] = TuplesKt.to("switch_type", r4);
            r1[9] = TuplesKt.to("tab_name", "classification");
            r0.doEventAction("store_product_form_switch_click", r1);
            return;
        L10:
            r4 = "single_product";
        L8:
            r4 = null;
            goto L11
        }

        public d(ShopAggregatePageSortBarPresenter r1) {
            this.a = r1;
        }
    }

    public final ShopAggregatePageProductViewModel k0() {
        return (ShopAggregatePageProductViewModel) this.k.getValue();
    }

    public final com.bytedance.android.ec.store.sortbar.j e0() {
        return this.o;
    }

    public final com.bytedance.android.ec.store.sortbar.l h0() {
        return this.p;
    }

    public final com.bytedance.android.ec.store.sortbar.k j0() {
        return this.n;
    }

    public ShopAggregatePageSortBarPresenter(final ShopAggregateProductListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.k = LazyKt.lazy(new ShopAggregatePageSortBarPresenter$viewModel$2(this, r2));
        this.l = LazyKt.lazy(new ShopAggregatePageSortBarPresenter$activityViewModel$2(this, r2));
        this.n = new a(this);
        this.o = new c(this);
        this.p = new d(this);
    }

    public final void b0(QModel r4) {
        super.b0(r4);
        ((ShopAggregatePageViewModel) this.l.getValue()).getOnPageSelect().a(ECQuickUtilKt.a(Y()), new b(this), false);
    }
}
