package com.bytedance.android.shopping.store.hybridproduct.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.utils.playable.controller.playcontrol.PlayControlStrategy;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.SlcElementContainer;
import com.bytedance.android.shopping.store.home.datasource.ECShopDataStorageForRemote;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.slicecard.ShopSliceKey;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopSliceProductFilterPresenter extends QFragmentPresenter {
    public static final /* synthetic */ int q = 0;
    public final String f;
    public final Lazy g;
    public boolean h;
    public com.bytedance.android.ec.store.repository.vo.k i;
    public boolean j;
    public String k;
    public dj3.c l;
    public View m;
    public final Lazy n;
    public final com.bytedance.android.ecom.arch.slice.render.r o;
    public final ECStoreViewModel p;

    public static final class a {
    }

    public static final class b implements gk3.a {
        public final /* synthetic */ ShopSliceProductFilterPresenter a;

        @Override // gk3.a
        public final void d(ECTagListView r1) {
        }

        @Override // gk3.a
        public final LifecycleOwner getLifecycleOwner() {
            return null;
        }

        @Override // gk3.a
        public final ECStoreViewModel a() {
            return this.a.p;
        }

        @Override // gk3.a
        public final ECShopHybridProductViewModel c() {
            return this.a.e0();
        }

        public b(ShopSliceProductFilterPresenter r1) {
            this.a = r1;
        }

        @Override // gk3.a
        public final com.bytedance.android.ec.store.view.j b(ECTagListDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "tagListVO");
            Intrinsics.checkNotNullParameter(r2, "tagListVO");
            return null;
        }

        @Override // gk3.a
        public final void e(ECTagListView r1, ECTagListDTO r2) {
            Intrinsics.checkNotNullParameter(r2, "tagListVO");
            Intrinsics.checkNotNullParameter(r2, "tagListVO");
        }

        @Override // gk3.a
        public final com.bytedance.android.ec.store.view.j f(ECTagListDTO r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "tagListVO");
            Intrinsics.checkNotNullParameter(r1, "tagListVO");
            return null;
        }
    }

    static {
    }

    public final ECShopHybridProductViewModel e0() {
        return (ECShopHybridProductViewModel) this.g.getValue();
    }

    public final void d0() {
        com.bytedance.android.ecom.arch.slice.render.r r0 = this.o;
        if (r0 == null) goto L14;
        com.bytedance.android.ec.store.repository.vo.k r1 = this.i;
        if (r1 == null) goto L11;
        Map<String, Object> r2 = this.p.getSliceService().a();
        LinkedHashMap r3 = new LinkedHashMap();
        r3.putAll(r1.d);
        if (r2 == null) goto L9;
        r3.putAll(r2);
    L9:
        LinkedHashMap r4 = new LinkedHashMap();
        r4.putAll(r1.a);
        r4.putAll(r1.b);
        r4.putAll(r1.c);
        r4.put("slice_item_states", r3);
        Unit r5 = Unit.INSTANCE;
        Map r6 = MapsKt.mapOf(TuplesKt.to("data", r4));
        if (r6 == null) goto L11;
    L12:
        r0.a(r6, ShopSliceUniqueId.SHOP_PRODUCT_TAB_FILTER.getId());
        return;
    L11:
        r6 = MapsKt.emptyMap();
        goto L12
    }

    public final void b0(QModel r13) {
        View r1 = null;
        if ((r13 instanceof com.bytedance.android.ec.store.repository.vo.k) == true) goto L5;
        r13 = null;
    L5:
        com.bytedance.android.ec.store.repository.vo.k r14 = (com.bytedance.android.ec.store.repository.vo.k) r13;
        if (r14 != null) goto L8;
        return;
    L8:
        dm.a.b r0 = dm.a.a;
        dm.a.a(this.f).a("onBind");
        this.i = r14;
        ej3.f r15 = r14.h;
        if (r15 == null) goto L37;
        Map<String, dj3.k> r16 = r15.f;
        if (r16 == null) goto L37;
        if (r16.containsKey("clothes_preview_button") == false) goto L29;
        this.j = true;
        dj3.k r4 = r16.get("clothes_preview_button");
        if (r4 != null) goto L18;
    L25:
        dj3.k r17 = r16.get("double_column_button");
        if (r17 == null) goto L36;
        h0(r17);
        this.k = "double_column_button";
        e0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ORDER_FIRST_IMAGE);
    L36:
        e0().doAnyEventActionWithBtm("a1.b6269.c2429.d57203", PageFinder.via(a0()), "store_product_form_switch_show", w.a(e0()), new Pair[0]);
        goto L37
    L18:
        if (r4.b() != true) goto L25;
        dj3.k r18 = r16.get("clothes_preview_button");
        if (r18 == null) goto L36;
        h0(r18);
        this.k = "clothes_preview_button";
        dj3.c r19 = r18.a();
        if (r19 == null) goto L24;
        this.l = r19;
    L24:
        e0().upDateSelectParams(r4.d());
        e0().isClothesSelected().setValue(Boolean.TRUE);
        e0().getCurrentPlayStrategy().setValue(PlayControlStrategy.ALL_SAME);
        goto L36
    L29:
        if (((LayoutTypes) e0().getLayoutType().getValue()) != LayoutTypes.RECYCLER_VIEW_ITEM_SINGLE) goto L33;
        dj3.k r110 = r16.get("single_column_button");
        if (r110 == null) goto L36;
        h0(r110);
        this.k = "single_column_button";
        goto L36
    L33:
        dj3.k r111 = r16.get("double_column_button");
        if (r111 == null) goto L36;
        h0(r111);
        this.k = "double_column_button";
    L37:
        com.bytedance.android.ec.store.repository.vo.k r112 = this.i;
        if (r112 == null) goto L42;
        ej3.f r113 = r112.h;
        if (r113 == null) goto L42;
        String r114 = r113.e;
    L43:
        if (r114 != null) goto L45;
    L48:
        boolean r115 = true;
    L49:
        if (r115 == true) goto L52;
        e0().setShowSelectPanelEntry(true);
        this.p.getSelectPanelState().a(ECQuickUtilKt.a(Y()), new z(this), false);
    L52:
        com.bytedance.android.ecom.arch.slice.render.r r116 = this.o;
        if (r116 == null) goto L55;
        r116.b((ShopSliceProductFilterPresenter$slcActionHandler$2.a) this.n.getValue());
    L55:
        com.bytedance.android.ecom.arch.slice.render.r r117 = this.o;
        if (r117 == null) goto L60;
        SlcTemplateContext r118 = r117.b;
        if (r118 == null) goto L60;
        r118.s(ShopSliceUniqueId.SHOP_PRODUCT_TAB_FILTER.getId(), new b(this));
    L60:
        d0();
        com.bytedance.android.ecom.arch.slice.render.r r119 = this.o;
        if (r119 == null) goto L78;
        View r2 = r119.c;
        if (r2 == null) goto L78;
        SlcTemplateContext r120 = r119.b;
        if (r120 != null) goto L67;
    L69:
        View r121 = null;
    L71:
        if ((r121 instanceof SlcElementContainer) == true) goto L73;
        r121 = null;
    L73:
        SlcElementContainer r122 = (SlcElementContainer) r121;
        if (r122 == null) goto L76;
        r1 = r122.getContentView();
    L76:
        this.m = r1;
        goto L78
    L67:
        if (r120.w == null) goto L69;
        r121 = SlcRenderContext.f(r2, ShopSliceKey.SHORT_TERM_INDICATORS.getKey());
    L78:
        if (this.h == true) goto L91;
        dj3.c r123 = this.l;
        if (r123 == null) goto L92;
        View r3 = this.m;
        if (r3 != null) goto L86;
        return;
    L86:
        if (r3.getVisibility() == 8) goto L93;
        r3.post(new a0(r3, this, r123));
        ECShopDataStorageForRemote.b.d(r123.d());
        e0().refreshPassthroughApiForSql();
        this.h = true;
        return;
    L93:
        return;
    L92:
        return;
    L91:
        return;
    L45:
        if (r114.length() == 0) goto L48;
        r115 = false;
    L42:
        r114 = null;
        goto L43
    }

    public final void h0(dj3.k r3) {
        Map r4 = com.bytedance.android.ec.store.utils.m.c(r3);
        if (r4 == null) goto L10;
        com.bytedance.android.ec.store.repository.vo.k r0 = this.i;
        if (r0 == null) goto L11;
        Map<String, Object> r1 = r0.d;
        if (r1 == null) goto L12;
        r1.put("switch_button", r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    public ShopSliceProductFilterPresenter(Fragment r2, com.bytedance.android.ecom.arch.slice.render.r r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r2);
        this.o = r3;
        this.p = r4;
        this.f = "ShopSliceProductFilterPresenter";
        this.g = LazyKt.lazy(new ShopSliceProductFilterPresenter$viewModel$2(this));
        this.n = LazyKt.lazy(new ShopSliceProductFilterPresenter$slcActionHandler$2(this));
    }
}
