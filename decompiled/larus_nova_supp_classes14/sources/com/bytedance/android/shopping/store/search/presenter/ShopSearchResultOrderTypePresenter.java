package com.bytedance.android.shopping.store.search.presenter;

import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.sortbar.ECStoreSortBarBasePresenter;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSearchResultOrderTypePresenter extends ECStoreSortBarBasePresenter {
    public static final /* synthetic */ int p = 0;
    public final Lazy k;
    public boolean l;
    public final a m;
    public final b n;
    public final c o;

    public static final class a implements com.bytedance.android.ec.store.sortbar.k {
        public final /* synthetic */ ShopSearchResultOrderTypePresenter a;

        public final void c() {
        }

        public final void d(LayoutTypes r2) {
            Intrinsics.checkNotNullParameter(r2, "layoutType");
        }

        public final boolean g() {
            return true;
        }

        public final boolean h() {
            return false;
        }

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

        public final jm.a<List<com.bytedance.android.ec.store.repository.vo.r>> i() {
            return this.a.k0().getSortTypes();
        }

        public final String l() {
            return this.a.k0().getSearchParam().getSecShopId();
        }

        public final Boolean m() {
            return Boolean.FALSE;
        }

        public a(ShopSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }

        public final void e(LayoutTypes r3) {
            Intrinsics.checkNotNullParameter(r3, "layoutType");
            jm.a<LayoutTypes> r0 = this.a.k0().getLayoutType();
            if (((LayoutTypes) r0.getValue()) == r3) goto L6;
            r0.setValue(r3);
            return;
        }

        public final void k(List<com.bytedance.android.ec.store.repository.vo.r> r11) {
            Intrinsics.checkNotNullParameter(r11, "sortTypes");
            Iterator<T> r0 = r11.iterator();
        L3:
            int r2 = 1;
            if (r0.hasNext() == false) goto L10;
            com.bytedance.android.ec.store.repository.vo.r r1 = (com.bytedance.android.ec.store.repository.vo.r) r0.next();
            r1.c = false;
            if (r1.a == CastLongProtector.parseLong("3")) goto L9;
            r2 = 0;
        L9:
            r1.e = r2;
            goto L3
        L10:
            ((com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.first(r11)).c = true;
            ECShopSearchParam r3 = this.a.k0().getSearchParam();
            com.bytedance.android.ec.store.repository.vo.r r12 = (com.bytedance.android.ec.store.repository.vo.r) CollectionsKt.firstOrNull(r11);
            ShopSearchFragmentProductViewModel r4 = this.a.k0();
            PageFinder r6 = PageFinder.via(this.a.a0());
            Pair[] r5 = new Pair[9];
            r5[0] = TuplesKt.to("store_type", "shop");
            r5[1] = TuplesKt.to("author_id", r3.getAuthorId());
            r5[2] = TuplesKt.to("shop_id", r3.getShopId());
            r5[3] = TuplesKt.to("follow_status", String.valueOf(r3.getFollowStatus()));
            r5[4] = TuplesKt.to("entrance_info", r3.getEntranceInfo());
            r5[5] = TuplesKt.to("page_name", "store_search_result");
            Integer r7 = null;
            if (r12 == null) goto L13;
            String r8 = r12.b;
        L14:
            r5[6] = TuplesKt.to("order_type", r8);
            r5[7] = TuplesKt.to("click_type", CommentConstants$CmtLongPanelStrategy.DEFAULT);
            if (r12 == null) goto L17;
            r7 = Integer.valueOf(r12.e);
        L17:
            r5[8] = TuplesKt.to("order_ascending", String.valueOf(r7));
            r4.doAnyEventActionWithBtm("a1.b7881.c9580.d67356", r6, "click_ecommerce_store_sort", MapsKt.mapOf(r5), new Pair[0]);
            ShopSearchResultOrderTypePresenter r13 = this.a;
            if (r13.l == true) goto L25;
            r13.l = true;
            r13.k0().getSortTypes().a(((QFragmentPresenter) r13).e, new p(r13), false);
            return;
        L25:
            return;
        L13:
            r8 = null;
            goto L14
        }

        public final void f(Long r2, Integer r3) {
            this.a.k0().refreshBySortAndSortType(r2, r3);
        }
    }

    public static final class b implements com.bytedance.android.ec.store.sortbar.j {
        public final /* synthetic */ ShopSearchResultOrderTypePresenter a;

        public b(ShopSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.android.ec.store.repository.vo.r r18) {
            Intrinsics.checkNotNullParameter(r18, "sortType");
            ShopSearchFragmentProductViewModel r2 = this.a.k0();
            Pair[] r4 = new Pair[5];
            r4[0] = TuplesKt.to("enter_from", "search_store");
            r4[1] = TuplesKt.to("search_id", this.a.k0().getRequestParam().getSearchId());
            r4[2] = TuplesKt.to("search_type", "search_store");
            r4[3] = TuplesKt.to("search_keyword", this.a.k0().getSearchParam().getSearchKeyword());
            String r5 = r18.b;
            String r11 = "price_descend";
            switch(r5.hashCode()) {
                case 653349: goto L19;
                case 1219791: goto L16;
                case 621028900: goto L13;
                case 628553485: goto L10;
                case 629085383: goto L7;
                case 989933257: goto L5;
                default: goto L23;
            };
        L5:
            r5.equals("综合排序");
        L23:
            r11 = "general";
        L24:
            r4[4] = TuplesKt.to("sort_by", r11);
            r2.doEventAction("choose_search_sort", r4);
            ECShopSearchParam r3 = this.a.k0().getSearchParam();
            this.a.k0().doAnyEventActionWithBtm("a1.b7881.c9580.d67356", PageFinder.via(this.a.a0()), "click_ecommerce_store_sort", MapsKt.mapOf(new Pair[]{TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", r3.getAuthorId()), TuplesKt.to("shop_id", r3.getShopId()), TuplesKt.to("follow_status", String.valueOf(r3.getFollowStatus())), TuplesKt.to("entrance_info", r3.getEntranceInfo()), TuplesKt.to("page_name", "store_search_result"), TuplesKt.to("order_type", r18.b), TuplesKt.to("click_type", PinchEnterMethod.CLICK), TuplesKt.to("order_ascending", String.valueOf(r18.e))}), new Pair[0]);
            return;
        L7:
            if (r5.equals("价格降序") == false) goto L23;
        L10:
            if (r5.equals("价格升序") == false) goto L23;
        L11:
            r11 = "price_ascend";
            goto L24
        L13:
            if (r5.equals("上新时间") == false) goto L23;
            r11 = "newest";
            goto L24
        L16:
            if (r5.equals("销量") == false) goto L23;
            r11 = "sales";
            goto L24
        L19:
            if (r5.equals("价格") == false) goto L23;
            if (r18.e != 0) goto L11;
            goto L11
        }
    }

    public static final class c implements com.bytedance.android.ec.store.sortbar.l {
        public final /* synthetic */ ShopSearchResultOrderTypePresenter a;

        public final void a() {
            ShopSearchFragmentProductViewModel r0 = this.a.k0();
            Pair[] r1 = new Pair[10];
            r1[0] = TuplesKt.to("store_type", "shop");
            r1[1] = TuplesKt.to("author_id", this.a.k0().getSearchParam().getStoreAccountParam().getUserId());
            r1[2] = TuplesKt.to("shop_id", this.a.k0().getSearchParam().getShopId());
            r1[3] = TuplesKt.to("follow_status", String.valueOf(this.a.k0().getSearchParam().getFollowStatus()));
            r1[4] = TuplesKt.to("entrance_location", this.a.k0().getSearchParam().getEntranceLocation());
            r1[5] = TuplesKt.to("store_source_page", this.a.k0().getSearchParam().getStoreSourcePage());
            r1[6] = TuplesKt.to("store_source_method", this.a.k0().getSearchParam().getStoreSourceMethod());
            r1[7] = TuplesKt.to("store_group_type", this.a.k0().getSearchParam().getStoreGroupType());
            LayoutTypes r2 = (LayoutTypes) this.a.k0().getLayoutType().getValue();
            if (r2 == null) goto L8;
            int r3 = o.b[r2.ordinal()];
            if (r3 == 1) goto L10;
            if (r3 != 2) goto L8;
            String r4 = "double_product";
        L11:
            r1[8] = TuplesKt.to("switch_type", r4);
            r1[9] = TuplesKt.to("tab_name", "search_result");
            r0.doEventAction("store_product_form_switch_show", r1);
            return;
        L10:
            r4 = "single_product";
        L8:
            r4 = null;
            goto L11
        }

        public final void onClick() {
            ShopSearchFragmentProductViewModel r0 = this.a.k0();
            Pair[] r1 = new Pair[10];
            r1[0] = TuplesKt.to("author_id", this.a.k0().getSearchParam().getStoreAccountParam().getUserId());
            r1[1] = TuplesKt.to("store_type", "shop");
            r1[2] = TuplesKt.to("shop_id", this.a.k0().getSearchParam().getShopId());
            r1[3] = TuplesKt.to("follow_status", String.valueOf(this.a.k0().getSearchParam().getFollowStatus()));
            r1[4] = TuplesKt.to("entrance_location", this.a.k0().getSearchParam().getEntranceLocation());
            r1[5] = TuplesKt.to("store_source_page", this.a.k0().getSearchParam().getStoreSourcePage());
            r1[6] = TuplesKt.to("store_source_method", this.a.k0().getSearchParam().getStoreSourceMethod());
            r1[7] = TuplesKt.to("store_group_type", this.a.k0().getSearchParam().getStoreGroupType());
            LayoutTypes r2 = (LayoutTypes) this.a.k0().getLayoutType().getValue();
            if (r2 == null) goto L8;
            int r3 = o.a[r2.ordinal()];
            if (r3 == 1) goto L10;
            if (r3 != 2) goto L8;
            String r4 = "double_product";
        L11:
            r1[8] = TuplesKt.to("switch_type", r4);
            r1[9] = TuplesKt.to("tab_name", "search_result");
            r0.doEventAction("store_product_form_switch_click", r1);
            return;
        L10:
            r4 = "single_product";
        L8:
            r4 = null;
            goto L11
        }

        public c(ShopSearchResultOrderTypePresenter r1) {
            this.a = r1;
        }
    }

    public final ShopSearchFragmentProductViewModel k0() {
        return (ShopSearchFragmentProductViewModel) this.k.getValue();
    }

    public final com.bytedance.android.ec.store.sortbar.j e0() {
        return this.n;
    }

    public final com.bytedance.android.ec.store.sortbar.l h0() {
        return this.o;
    }

    public final com.bytedance.android.ec.store.sortbar.k j0() {
        return this.m;
    }

    public ShopSearchResultOrderTypePresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.k = LazyKt.lazy(new ShopSearchResultOrderTypePresenter$viewModel$2(this));
        this.m = new a(this);
        this.n = new b(this);
        this.o = new c(this);
    }
}
