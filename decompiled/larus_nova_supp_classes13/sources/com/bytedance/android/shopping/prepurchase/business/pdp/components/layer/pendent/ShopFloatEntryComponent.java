package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryDisplay;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreBusinessMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.shop.AnchorV4ShopAndStoreMeta;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.business.pdp.services.event.ProductDetailEventService;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.g0;
import vg3.i0;
import vg3.u;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ShopFloatEntryComponent extends com.bytedance.android.shopping.prepurchase.business.pdp.components.m implements g0 {
    public LongContentLabelComponentView m;
    public ShopFloatEntryVO n;
    public int o;
    public String p;
    public final ShopFloatEntryComponent$enterShopDepend$1 q;

    public static final class a {
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ ShopFloatEntryComponent a;

        public b(ShopFloatEntryComponent r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r4) {
            ShopFloatEntryVO r5 = (ShopFloatEntryVO) r4;
            ShopFloatEntryComponent r0 = this.a;
            r0.n = r5;
            LongContentLabelComponentView r1 = r0.m;
            if (r1 == null) goto L14;
            if (r5 != null) goto L7;
            r1.setVisibility(8);
            return;
        L7:
            ShopFloatEntryDisplay r2 = r5.getDisplay();
            if (r2 == null) goto L10;
            LongContentLabelComponent r3 = r2.getEntryContent();
        L11:
            r1.bind(r3);
            r1.setOnClickListener(new o(r0, r5, r1));
            r0.i2();
            return;
        L10:
            r3 = null;
            goto L11
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(new Class[]{i0.class, w.class, u.class});
    }

    public final void i2() {
        LongContentLabelComponentView r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        ShopFloatEntryVO r1 = this.n;
        if (r1 != null) goto L8;
    L12:
        boolean r5 = false;
    L13:
        if (r5 == false) goto L40;
        r0.setVisibility(0);
        if (r1 == null) goto L46;
        String r2 = new BtmItemBuilder("a1.b8094.c45662.d99516", Boolean.FALSE).withView(r0).createBtmId();
        Pair[] r6 = new Pair[4];
        r6[0] = TuplesKt.to("entrance_location", "product_detail_float");
        AnchorV4ShopAndStoreMeta r3 = r1.getMeta();
        String r4 = null;
        if (r3 == null) goto L22;
        AnchorV4ShopAndStoreBusinessMeta r7 = r3.getBusinessMeta();
        if (r7 == null) goto L22;
        Boolean r8 = Boolean.valueOf(r7.isStore());
    L23:
        r6[1] = TuplesKt.to("store_type", String.valueOf(r8));
        CommonMeta r9 = h2();
        if (r9 == null) goto L26;
        r4 = r9.getProductId();
    L26:
        r6[2] = TuplesKt.to("pre_product_id", r4);
        r6[3] = TuplesKt.to("btm_id", r2);
        Map<String, ? extends Object> r10 = MapsKt.mapOf(r6);
        w r11 = (w) N1(w.class);
        if (r11 == null) goto L33;
        ProductDetailEventService.b r12 = r11.m();
        if (r12 == null) goto L33;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r13 = r12.d(r10);
        if (r13 == null) goto L33;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r13, "pdp_module_show", false, "product_detail_float", null, 8);
    L33:
        w r14 = (w) N1(w.class);
        if (r14 == null) goto L42;
        ProductDetailEventService.b r15 = r14.m();
        if (r15 == null) goto L43;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m r16 = r15.d(r10);
        if (r16 == null) goto L44;
        com.bytedance.android.shopping.prepurchase.arch.container.ability.m.a.a(r16, "show_store_entrance", false, "product_detail_float", null, 8);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L22:
        r8 = null;
        goto L23
    L46:
        return;
    L40:
        r0.setVisibility(8);
        return;
    L8:
        if (this.o < 2) goto L10;
    L11:
        r5 = true;
        goto L13
    L10:
        if (Intrinsics.areEqual(this.p, "id_recommend") == false) goto L12;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.ShopFloatEntryComponent$enterShopDepend$1] */
    public ShopFloatEntryComponent() {
        this.q = new ShopFloatEntryComponent$enterShopDepend$1(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, g0.class, this, false, 12);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) O1().d().getData().q.getValue(), this, new b(this));
        Z1(i0.class, new ShopFloatEntryComponent$onAttach$2(this, null));
    }

    public final CommonMeta h2() {
        return O1().d().getData().a().a();
    }

    @Override // vg3.g0
    public final LongContentLabelComponentView r0() {
        return this.m;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final View c2(LayoutInflater r8, ViewGroup r9) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r9, "container");
        LongContentLabelComponentView r10 = new LongContentLabelComponentView(r8.getContext(), null, null, 6, null);
        r10.setId(2131386242);
        r10.setVisibility(8);
        this.m = r10;
        return r10;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.Component
    public final void b2(ViewGroup r2, ViewGroup.LayoutParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, -2);
        r5.gravity = 85;
        r5.bottomMargin = com.bytedance.android.shopping.extensions.b.b(332);
        Unit r0 = Unit.INSTANCE;
        super.b2(r2, r5, r4);
    }
}
