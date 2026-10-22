package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.product;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionReInShopProductStruct;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv3.repository.dto.RecommendInShopProductStruct;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.monitor.ImageMonitorMeta;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import fi3.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductDetailInfoViewModel extends ViewModel<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> {
    public tg3.a e;
    public com.bytedance.android.shopping.anchorv4.vm.j f;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<List<com.bytedance.android.ecom.arch.slice.adapter.b>> g;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d h;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Map<String, SlcElement>> i;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d j;
    public boolean k;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Integer> l;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<o0> m;
    public final Lazy n;
    public Integer o;
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e p;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ ProductDetailInfoViewModel a;
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.intf.j b;

        public a(ProductDetailInfoViewModel r1, com.bytedance.android.shopping.prepurchase.arch.container.intf.j r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            com.bytedance.android.shopping.anchorv4.vm.j r6 = (com.bytedance.android.shopping.anchorv4.vm.j) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            com.bytedance.android.shopping.prepurchase.arch.container.intf.k r0 = (com.bytedance.android.shopping.prepurchase.arch.container.intf.k) this.b.q0().a();
            if ((r0 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d) == true) goto L5;
        L7:
            boolean r1 = false;
        L8:
            com.bytedance.android.shopping.anchorv4.vm.j r2 = this.a.f;
            if (r2 == null) goto L11;
            List r3 = r2.i;
        L12:
            com.bytedance.android.shopping.anchorv4.vm.j r4 = com.bytedance.android.shopping.anchorv4.vm.j.a(r6, r3);
            ProductDetailInfoViewModel r7 = this.a;
            r7.f = r4;
            List<com.bytedance.android.ecom.arch.slice.adapter.b> r8 = ProductDetailInfoViewModel.g(r7, r4);
            this.a.g.g(r8);
            ProductDetailInfoViewModel r9 = this.a;
            r9.getContext().b().s1(new y(r9, r6, r1));
            return;
        L11:
            r3 = null;
            goto L12
        L5:
            if ((r0 instanceof com.bytedance.android.shopping.prepurchase.arch.container.intf.k.d.a) == false) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class b<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f a;

        public b(com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            if (r4 == null) goto L7;
            this.a.M0(MapsKt.mapOf(TuplesKt.to("detail_image_list", r4)));
            return;
        }
    }

    public static final class c<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f a;

        public c(com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r3) {
            String r4 = (String) r3;
            if (r4 == null) goto L7;
            this.a.M0(MapsKt.mapOf(TuplesKt.to("comment_preload_data", r4)));
            return;
        }
    }

    public static final class d<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ ProductDetailInfoViewModel a;
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f b;

        public d(ProductDetailInfoViewModel r1, com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r2) {
            Map<String, SlcElement> r3 = (Map) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.isEmpty() == true) goto L7;
            Map<String, SlcElement> r0 = r3;
        L8:
            if (r0 == null) goto L13;
            this.b.o1(r3);
            this.a.i.g(r3);
            return;
        L13:
            return;
        L7:
            r0 = null;
            goto L8
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.ViewModel
    public final void c() {
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o r0 = getContext().e().r();
        this.e = new tg3.a(r0);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.j<PdpDataStore> r1 = getContext().d();
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(r1.getData().H, this.p, new a(this, r1));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r1.getData().u.getValue(), this.p, new b(r0));
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r1.getData().y.getValue(), this.p, new c(r0));
        ((com.bytedance.android.shopping.prepurchase.arch.container.state.e) r1.getData().z.getValue()).b(this.p, com.bytedance.android.shopping.prepurchase.arch.container.state.j.a(), new d(this, r0));
        ViewModel.f(this, vg3.n.class, new ProductDetailInfoViewModel$onAttach$5(this, r1, null));
    }

    public ProductDetailInfoViewModel(com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.e r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        this.p = r2;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<List<com.bytedance.android.ecom.arch.slice.adapter.b>> r3 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.g = r3;
        this.h = r3;
        com.bytedance.android.shopping.prepurchase.arch.container.state.d<Map<String, SlcElement>> r4 = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.i = r4;
        this.j = r4;
        this.l = new com.bytedance.android.shopping.prepurchase.arch.container.state.d(0);
        this.m = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.n = LazyKt.lazy(ProductDetailInfoViewModel$theGULTitleVO$2.INSTANCE);
    }

    public final boolean h(com.bytedance.android.ecom.arch.slice.adapter.b r2) {
        if ((r2 instanceof VOIdentifier) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(((VOIdentifier) r2).identifier(), ComponentIDs.SHOP_CONFIGURED_GOODS.getId());
    }

    public final boolean i(com.bytedance.android.ecom.arch.slice.adapter.b r2) {
        if ((r2 instanceof VOIdentifier) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((VOIdentifier) r2).identifier(), ComponentIDs.SHOP_COUPONS.getId()) == false) goto L7;
        return true;
    }

    public final boolean j(com.bytedance.android.ecom.arch.slice.adapter.b r4) {
        if ((r4 instanceof VOIdentifier) == true) goto L5;
        return true;
    L5:
        com.bytedance.android.ecom.arch.slice.adapter.b r2 = null;
        if ((r4 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) == true) goto L8;
        com.bytedance.android.ecom.arch.slice.adapter.b r0 = null;
    L10:
        if (((com.bytedance.android.shopping.anchorv4.voavhs.lynx.a) r0) == null) goto L12;
    L18:
        String r5 = ((VOIdentifier) r4).identifier();
        if ((!Intrinsics.areEqual(r5, ComponentIDs.EP_REGISTER.getId())) == true) goto L21;
    L23:
        return false;
    L21:
        if ((!Intrinsics.areEqual(r5, ComponentIDs.ABOVE_GUL.getId())) == false) goto L23;
        return true;
    L12:
        if ((r4 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a) == false) goto L16;
        r2 = r4;
    L16:
        if (((com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a) r2) != null) goto L18;
        return true;
    L8:
        r0 = r4;
        goto L10
    }

    public static final List g(ProductDetailInfoViewModel r14, com.bytedance.android.shopping.anchorv4.vm.j r15) {
        r14.getClass();
        ArrayList r0 = new ArrayList();
        List r1 = r15.a;
        com.bytedance.android.shopping.anchorv4.vm.a r2 = r15.g;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r3 = r15.b;
        List r4 = r15.c;
        List r5 = r15.d;
        PromotionRecommendResponse r6 = r15.h;
        if (r2 != null) goto L5;
    L54:
        if (r1 == null) goto L72;
        ArrayList r10 = new ArrayList();
        Iterator r7 = r1.iterator();
    L57:
        if (r7.hasNext() == false) goto L68;
        Object r11 = r7.next();
        com.bytedance.android.ecom.arch.slice.adapter.b r12 = (com.bytedance.android.ecom.arch.slice.adapter.b) r11;
        if (r14.j(r12) == true) goto L61;
    L65:
        boolean r13 = false;
    L66:
        if (r13 == false) goto L57;
        r10.add(r11);
        goto L57
    L61:
        if (r14.h(r12) == true) goto L65;
        if (r14.i(r12) == true) goto L65;
        r13 = true;
        goto L66
    L68:
        Iterator r8 = r10.iterator();
    L70:
        if (r8.hasNext() == false) goto L72;
        r0.add((com.bytedance.android.ecom.arch.slice.adapter.b) r8.next());
    L72:
        if (r3 == null) goto L74;
        r0.add(r3);
    L74:
        if (r1 == null) goto L85;
        Iterator r9 = r1.iterator();
    L77:
        if (r9.hasNext() == false) goto L81;
        Object r16 = r9.next();
        if (r14.i((com.bytedance.android.ecom.arch.slice.adapter.b) r16) == false) goto L77;
    L82:
        com.bytedance.android.ecom.arch.slice.adapter.b r17 = (com.bytedance.android.ecom.arch.slice.adapter.b) r16;
        if (r17 == null) goto L85;
        r0.add(r17);
        goto L85
    L81:
        r16 = null;
    L85:
        if (r1 == null) goto L96;
        Iterator r18 = r1.iterator();
    L88:
        if (r18.hasNext() == false) goto L92;
        Object r19 = r18.next();
        if (r14.h((com.bytedance.android.ecom.arch.slice.adapter.b) r19) == false) goto L88;
    L93:
        com.bytedance.android.ecom.arch.slice.adapter.b r20 = (com.bytedance.android.ecom.arch.slice.adapter.b) r19;
        if (r20 == null) goto L96;
        r0.add(r20);
        goto L96
    L92:
        r19 = null;
    L96:
        if (r4 == null) goto L101;
        Iterator r21 = r4.iterator();
    L99:
        if (r21.hasNext() == false) goto L101;
        r0.add((com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d) r21.next());
    L101:
        if (r5 == null) goto L106;
        Iterator r22 = r5.iterator();
    L104:
        if (r22.hasNext() == false) goto L106;
        r0.add((d63.d) r22.next());
    L106:
        if (r1 == null) goto L124;
        ArrayList r23 = new ArrayList();
        Iterator r24 = r1.iterator();
    L109:
        if (r24.hasNext() == false) goto L120;
        Object r25 = r24.next();
        com.bytedance.android.ecom.arch.slice.adapter.b r26 = (com.bytedance.android.ecom.arch.slice.adapter.b) r25;
        if (r14.j(r26) == false) goto L113;
    L117:
        boolean r27 = false;
    L118:
        if (r27 == false) goto L109;
        r23.add(r25);
        goto L109
    L113:
        if (r14.h(r26) == true) goto L117;
        if (r14.i(r26) == true) goto L117;
        r27 = true;
        goto L118
    L120:
        Iterator r28 = r23.iterator();
    L122:
        if (r28.hasNext() == false) goto L124;
        r0.add((com.bytedance.android.ecom.arch.slice.adapter.b) r28.next());
    L124:
        if (r6 == null) goto L164;
        List r29 = r6.getProducts();
        List r30 = r29;
        if (r30 != null) goto L128;
    L131:
        boolean r31 = true;
    L132:
        if (r31 == true) goto L164;
        Iterator r32 = r0.iterator();
        int r33 = 0;
    L135:
        if (r32.hasNext() == false) goto L140;
        if ((((com.bytedance.android.ecom.arch.slice.adapter.b) r32.next()) instanceof com.bytedance.android.shopping.anchorv4.voavhs.shop.b) == true) goto L141;
        r33 = r33 + 1;
    L141:
        if (r33 < 0) goto L160;
        Object r34 = CollectionsKt.getOrNull(r0, r33);
        if ((r34 instanceof com.bytedance.android.shopping.anchorv4.voavhs.shop.b) == true) goto L145;
        r34 = null;
    L145:
        com.bytedance.android.shopping.anchorv4.voavhs.shop.b r35 = (com.bytedance.android.shopping.anchorv4.voavhs.shop.b) r34;
        if (r35 == null) goto L148;
        com.bytedance.android.shopping.anchorv4.voavhs.shop.b r36 = com.bytedance.android.shopping.anchorv4.voavhs.shop.b.a(r35, r29);
    L149:
        if (r36 == null) goto L151;
        ListProtector.set(r0, r33, r36);
    L151:
        if (r29 == null) goto L160;
        Iterator r37 = r29.iterator();
    L154:
        if (r37.hasNext() == false) goto L160;
        RecommendInShopProductStruct r38 = (RecommendInShopProductStruct) r37.next();
        if (r38 == null) goto L154;
        PromotionReInShopProductStruct r39 = r38.getBaseInfo();
        if (r39 == null) goto L154;
        r39.setImageMonitorMeta(new ImageMonitorMeta("ec_detail", "ec_store_recommend_image"));
        goto L154
    L148:
        r36 = null;
    L160:
        int r40 = ne7.d.a;
        Pair[] r41 = new Pair[2];
        r41[0] = TuplesKt.to("products", r29);
        String r42 = r6.getShopUrl();
        if (r42 != null) goto L163;
        r42 = "";
    L163:
        r41[1] = TuplesKt.to("shop_url", r42);
        Map r43 = ne7.d.b(com.bytedance.android.ec.hybrid.list.util.k.b(MapsKt.mapOf(r41)));
        int r44 = c0.e;
        r14.getContext().e().r().y0(c0.a.a("shop_recommend", r43, r1, 2), new com.bytedance.android.ecom.arch.slice.action.c(null, null), null);
        goto L164
    L140:
        r33 = -1;
        goto L141
    L128:
        if (r30.isEmpty() == true) goto L131;
        r31 = false;
    L164:
        List r45 = r15.e;
        j63.a r46 = r15.f;
        List r110 = r15.i;
        if (r45 != null) goto L167;
    L168:
        if (r46 != null) goto L170;
    L173:
        if (PdpAB.b == true) goto L179;
        if (r45 == null) goto L183;
        Iterator r47 = r45.iterator();
    L177:
        if (r47.hasNext() == false) goto L183;
        r0.add((j63.c) r47.next());
    L183:
        if (r110 != null) goto L185;
    L190:
        int r111 = com.bytedance.android.ecom.arch.slice.adapter.e.e;
        List r112 = com.bytedance.android.ecom.arch.slice.adapter.e.a.a(r0);
        ArrayList r48 = new ArrayList();
        Iterator r113 = r112.iterator();
    L192:
        if (r113.hasNext() == false) goto L216;
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r49 = (com.bytedance.android.ecom.arch.slice.adapter.b) r113.next();
        boolean r50 = r49 instanceof com.bytedance.android.shopping.anchorv4.voavhs.lynx.a;
        if (r50 == false) goto L204;
        ComponentDTO r51 = r49.f;
        if (r51 == null) goto L198;
        String r52 = r51.getComponentId();
    L200:
        if (Intrinsics.areEqual(r52, "id_above_pd") == false) goto L204;
        if (r14.k == false) goto L204;
        r48.add(r49);
        goto L192
    L198:
        r52 = null;
    L204:
        if (r50 == true) goto L206;
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r53 = null;
    L207:
        com.bytedance.android.shopping.anchorv4.voavhs.lynx.a r54 = r53;
        if (r54 == null) goto L212;
        ComponentDTO r55 = r54.f;
        if (r55 == null) goto L212;
        Boolean r56 = r55.isHide();
    L214:
        if ((!Intrinsics.areEqual(r56, Boolean.TRUE)) == false) goto L192;
        r48.add(r49);
    L212:
        r56 = null;
        goto L214
    L206:
        r53 = r49;
        goto L207
    L216:
        return r48;
    L185:
        if ((!r110.isEmpty()) != true) goto L190;
        Iterator r114 = r110.iterator();
    L188:
        if (r114.hasNext() == false) goto L190;
        r0.add((com.bytedance.android.ecom.arch.slice.adapter.b) r114.next());
        goto L188
    L179:
        if (r46 == null) goto L183;
        if (r46.b != true) goto L183;
        r0.add(r46);
        goto L183
    L170:
        if (r46.b != true) goto L173;
    L171:
        r0.add((com.bytedance.android.shopping.anchorv3.view.t) r14.n.getValue());
        goto L173
    L167:
        if ((!r45.isEmpty()) == true) goto L171;
    L5:
        if (r2.a != true) goto L54;
        if (r1 == null) goto L164;
        ArrayList r57 = new ArrayList();
        Iterator r58 = r1.iterator();
    L9:
        if (r58.hasNext() == false) goto L50;
        Object r59 = r58.next();
        com.bytedance.android.ecom.arch.slice.g r60 = (com.bytedance.android.ecom.arch.slice.adapter.b) r59;
        List r61 = r2.b;
        if ((r60 instanceof AnchorV4HeadVO) == false) goto L13;
    L18:
        boolean r115 = true;
    L19:
        if (r61 == null) goto L42;
        List r62 = r61;
        if ((r62 instanceof Collection) == true) goto L23;
    L25:
        Iterator r63 = r62.iterator();
    L27:
        if (r63.hasNext() == false) goto L39;
        String r116 = (String) r63.next();
        if ((r60 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L31;
        com.bytedance.android.ecom.arch.slice.g r117 = null;
    L32:
        com.bytedance.android.ecom.arch.slice.g r118 = r117;
        if (r118 == null) goto L35;
        String r119 = r118.getSliceId();
    L37:
        if (Intrinsics.areEqual(r116, r119) == false) goto L27;
        boolean r64 = true;
    L40:
        if (r64 != true) goto L42;
        boolean r65 = true;
    L43:
        if (r115 == true) goto L47;
        if (r65 == true) goto L47;
        boolean r66 = false;
    L48:
        if (r66 == false) goto L9;
        r57.add(r59);
    L47:
        r66 = true;
        goto L48
    L35:
        r119 = null;
        goto L37
    L31:
        r117 = r60;
    L39:
        r64 = false;
        goto L40
    L23:
        if (r62.isEmpty() == false) goto L25;
    L42:
        r65 = false;
        goto L43
    L13:
        if ((r60 instanceof com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c) == true) goto L18;
        if ((r60 instanceof AnchorV4HeadV2VO) == true) goto L18;
        r115 = false;
        goto L19
    L50:
        Iterator r67 = r57.iterator();
    L52:
        if (r67.hasNext() == false) goto L164;
        r0.add((com.bytedance.android.ecom.arch.slice.adapter.b) r67.next());
        goto L52
    }
}
