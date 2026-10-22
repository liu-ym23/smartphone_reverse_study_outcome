package com.bytedance.android.shopping.prepurchase.business.pdp.services.sku;

import android.os.SystemClock;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ProductPriceInfo;
import com.bytedance.android.ec.model.PromotionDiscountPrice;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.shopping.anchorv4.dto.business.SkuSpecInfo;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.g;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.q;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.e;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.LynxAbilityImpl;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.f;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.android.shopping.utils.a0;
import fi3.c0;
import j73.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import ti.j;
import vg3.e0;
import vg3.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PdpSKUService extends b0 implements e0, Function1<SkuProductDetailInfo, Unit> {
    public static final /* synthetic */ int v = 0;
    public final Lazy i;
    public SkuRestoreState j;
    public final Set<Function1<SkuProductDetailInfo, Unit>> k;
    public String l;
    public boolean m;
    public boolean n;
    public String o;
    public c p;
    public boolean q;
    public int r;
    public final List<Function0<Unit>> s;
    public final b t;
    public final a u;

    public static final class a implements d {
        public final /* synthetic */ PdpSKUService a;

        public a(PdpSKUService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void b(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "param");
            int r0 = com.bytedance.android.shopping.anchorv3.utils.a.a;
            CommonMeta r1 = this.a.b2();
            Integer r2 = null;
            if (r1 == null) goto L5;
            ECAdLogExtra r3 = r1.getAdLogExtra();
        L6:
            CommonMeta r4 = this.a.b2();
            if (r4 == null) goto L9;
            String r5 = r4.getPromotionId();
        L10:
            CommonMeta r6 = this.a.b2();
            if (r6 == null) goto L13;
            r2 = Integer.valueOf((int) r6.getPromotionSource());
        L13:
            com.bytedance.android.shopping.anchorv3.utils.a.b(r3, r5, r2, Long.valueOf(r10.optLong("price")), SystemClock.uptimeMillis() - r10.optLong("sku_resume_time"), "large_stabilization");
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void c(JSONObject r4) {
            Intrinsics.checkNotNullParameter(r4, "param");
            PdpSKUService r5 = this.a;
            r5.o = r5.l;
            LynxAbilityImpl r6 = r5.O1().e().D0();
            JSONObject r0 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r0, "identifier", this.a.a2().getSessionId());
            KtSafeMethodExtensionKt.safePut(r0, "hide", "0");
            Unit r1 = Unit.INSTANCE;
            r6.B("ecom_pdp_sku_panel_status_change", r0);
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void a(JSONObject r21, a0 r22) {
            Intrinsics.checkNotNullParameter(r21, "params");
            String r2 = null;
            if (r22 == null) goto L5;
            vh3.a r3 = r22.b;
        L6:
            ArrayList r4 = new ArrayList();
            if (r3 == null) goto L23;
            List<String> r7 = r3.c();
            if (r7 == null) goto L23;
            Iterator<T> r8 = r7.iterator();
        L12:
            if (r8.hasNext() == false) goto L23;
            String r9 = (String) r8.next();
            if (r9 != null) goto L16;
        L19:
            boolean r10 = true;
        L20:
            if (r10 == true) goto L21;
            r4.add(r9);
            goto L12
        L21:
            r4.add(null);
            goto L12
        L16:
            if (r9.length() == 0) goto L19;
            r10 = false;
        L23:
            CommonMeta r11 = this.a.b2();
            if (r11 == null) goto L28;
            List r12 = r11.getSkuSpecInfo();
            if (r12 == null) goto L28;
            int r13 = r12.size();
        L29:
            SkuRestoreState r14 = new SkuRestoreState(r13);
            Object[] r5 = r4.toArray(new String[0]);
            if (r5 == null) goto L58;
            String[] r15 = (String[]) r5;
            if (r3 == null) goto L36;
            String r6 = r3.a();
            if (r6 == null) goto L36;
            Long r16 = StringsKt.toLongOrNull(r6);
        L37:
            if (r3 == null) goto L41;
            uh3.b r17 = r3.d();
            if (r17 == null) goto L41;
            String r18 = r17.h();
        L42:
            SkuRestoreState.saveSelectedSpec$default(r14, r15, r16, r18, null, null, null, 0, 120, null);
            this.a.d2(r14, true);
            if (com.bytedance.android.ec.core.abtest.d.D() == true) goto L45;
        L47:
            if (r22 == null) goto L50;
            r2 = r22.a;
        L50:
            if ((!Intrinsics.areEqual(r2, String.valueOf(102))) == false) goto L55;
            Iterator r1 = ((ArrayList) this.a.s).iterator();
        L53:
            if (r1.hasNext() == false) goto L55;
            ((Function0) r1.next()).invoke();
        L55:
            LynxAbilityImpl r19 = this.a.O1().e().D0();
            JSONObject r20 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r20, "identifier", this.a.a2().getSessionId());
            KtSafeMethodExtensionKt.safePut(r20, "hide", "1");
            Unit r23 = Unit.INSTANCE;
            r19.B("ecom_pdp_sku_panel_status_change", r20);
            return;
        L45:
            if (this.a.t.h0() == true) goto L47;
            this.a.t.f0();
        L41:
            r18 = null;
        L36:
            r16 = null;
            goto L37
        L58:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L28:
            r13 = 1;
            goto L29
        L5:
            r3 = null;
            goto L6
        }

        @Override // com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.d
        public final void d(JSONObject r25, vh3.a r26) {
            Intrinsics.checkNotNullParameter(r25, "params");
            Intrinsics.checkNotNullParameter(r26, "statusInfo");
            String r3 = r26.b();
            uh3.b r4 = r26.d();
            String r12 = null;
            if (r4 == null) goto L5;
            Long r5 = r4.d();
        L6:
            uh3.b r6 = r26.d();
            if (r6 == null) goto L9;
            Long r7 = r6.g();
        L10:
            uh3.b r8 = r26.d();
            if (r8 == null) goto L13;
            Long r14 = r8.b();
        L14:
            uh3.b r9 = r26.d();
            if (r9 == null) goto L18;
            String r10 = r9.c();
            if (r10 == null) goto L18;
        L19:
            ProductPriceInfo r1 = new ProductPriceInfo(r5, r7, new PromotionDiscountPrice(r14, null, r10, null, 10, null), null, null, 24, null);
            uh3.b r11 = r26.d();
            if (r11 == null) goto L24;
            uh3.a r13 = r11.a();
            if (r13 == null) goto L24;
            Object r15 = r13.a();
        L25:
            List<uh3.c> r16 = r26.f();
            if (r16 == null) goto L32;
            List<uh3.c> r17 = r16;
            ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
            Iterator<T> r19 = r17.iterator();
        L29:
            if (r19.hasNext() == false) goto L31;
            r18.add(((uh3.c) r19.next()).a());
            goto L29
        L31:
            String r20 = CollectionsKt.joinToString$default(r18, " ", null, null, 0, null, null, 62, null);
        L33:
            List<String> r2 = r26.c();
            int r110 = 0;
            if (r2 == null) goto L40;
            Object[] r21 = r2.toArray(new String[0]);
            if (r21 == null) goto L39;
            String[] r22 = (String[]) r21;
        L41:
            SkuProductDetailInfo r111 = new SkuProductDetailInfo(r3, r1, r15, r20, false, r22, false, 64, null);
            CommonMeta r23 = this.a.b2();
            if (r23 == null) goto L44;
            List r24 = r23.getSkuSpecInfo();
        L45:
            if (r24 == null) goto L74;
            CommonMeta r27 = this.a.b2();
            if (r27 == null) goto L49;
            String r28 = r27.getChoosePanelText();
        L51:
            if (a2.b(r28) == false) goto L55;
            PdpSKUService r29 = this.a;
            if (r29.n == true) goto L55;
            r29.l(r111);
            return;
        L55:
            String[] r30 = r111.getSpecArray();
            if (r30 == null) goto L86;
            int r31 = r30.length;
            int r32 = 0;
        L58:
            if (r110 >= r31) goto L88;
            String r33 = r30[r110];
            int r34 = r32 + 1;
            SkuRestoreState r35 = this.a.j;
            if (r35 == null) goto L64;
            String[] r36 = r35.getSelectSkuKeys();
            if (r36 == null) goto L64;
            String r37 = (String) ArraysKt.getOrNull(r36, r32);
        L66:
            if ((!Intrinsics.areEqual(r37, r33)) == false) goto L73;
            PdpSKUService r38 = this.a;
            SkuRestoreState r39 = r38.j;
            if (r39 == null) goto L70;
            String[] r40 = r111.getSpecArray();
            Intrinsics.checkNotNull(r40);
            r39.setSelectSkuKeys(r40);
            Unit r41 = Unit.INSTANCE;
            r38.q(r39, !com.bytedance.android.ec.core.abtest.d.D());
        L71:
            this.a.l(SkuProductDetailInfo.copy$default(r111, null, null, null, null, true, null, false, 111, null));
            goto L73
        L70:
            String[] r42 = r111.getSpecArray();
            Intrinsics.checkNotNull(r42);
            SkuRestoreState r43 = new SkuRestoreState(r42.length);
            String[] r44 = r111.getSpecArray();
            Intrinsics.checkNotNull(r44);
            r43.setSelectSkuKeys(r44);
            Unit r45 = Unit.INSTANCE;
            r38.q(r43, !com.bytedance.android.ec.core.abtest.d.D());
        L73:
            r110 = r110 + 1;
            r32 = r34;
            r111 = r111;
        L64:
            r37 = null;
            goto L66
        L88:
            return;
        L86:
            return;
        L49:
            r28 = null;
            goto L51
        L74:
            CommonMeta r46 = this.a.b2();
            if (r46 == null) goto L78;
            r12 = r46.getChoosePanelText();
        L78:
            if (a2.b(r12) == false) goto L87;
            this.a.l(r111);
            return;
        L87:
            return;
        L44:
            r24 = null;
            goto L45
        L39:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L40:
            r22 = null;
            goto L41
        L32:
            r20 = null;
        L24:
            r15 = null;
        L18:
            r10 = "";
            goto L19
        L13:
            r14 = null;
            goto L14
        L9:
            r7 = null;
            goto L10
        L5:
            r5 = null;
            goto L6
        }
    }

    public static final class b implements m {
        public final /* synthetic */ PdpSKUService a;

        public final boolean I() {
            return this.a.q;
        }

        public final SkuRestoreState P() {
            return this.a.j;
        }

        public final boolean X() {
            return this.a.n;
        }

        public final void f0() {
            x r0 = this.a.c2();
            if (r0 == null) goto L5;
            x.a.a(r0, false, "sku_select_finish", null, 28);
        L5:
            this.a.o = null;
        }

        public final boolean h0() {
            PdpSKUService r0 = this.a;
            return Intrinsics.areEqual(r0.o, r0.l);
        }

        public final void v() {
            Iterator r0 = ((ArrayList) this.a.s).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((Function0) r0.next()).invoke();
            goto L4
        }

        public final void z() {
            PdpSKUService r0 = this.a;
            r0.o = r0.l;
        }

        public b(PdpSKUService r1) {
            this.a = r1;
        }

        public final void S(String r19) {
            Intrinsics.checkNotNullParameter(r19, "specId");
            CommonMeta r2 = this.a.b2();
            if (r2 == null) goto L34;
            List r3 = r2.getSkuSpecInfo();
            if (r3 == null) goto L34;
            int r4 = r3.size();
            SkuRestoreState r5 = this.a.j;
            if (r5 == null) goto L21;
            String[] r6 = r5.getSelectSkuKeys();
            if (r6 != null) goto L11;
        L17:
            boolean r7 = true;
        L18:
            if (r7 == true) goto L20;
            r5.getSelectSkuKeys()[0] = r19;
        L20:
            Unit r1 = Unit.INSTANCE;
            q(r5, true);
            goto L34
        L11:
            if (r6.length != 0) goto L13;
            boolean r8 = true;
        L14:
            if (r8 == true) goto L17;
            r7 = false;
            goto L18
        L13:
            r8 = false;
            goto L14
        L21:
            SkuRestoreState r9 = new SkuRestoreState(r4);
            String[] r10 = r9.getSelectSkuKeys();
            if (r10 != null) goto L24;
        L30:
            boolean r11 = true;
        L31:
            if (r11 == true) goto L33;
            r9.getSelectSkuKeys()[0] = r19;
        L33:
            Unit r12 = Unit.INSTANCE;
            q(r9, true);
            goto L34
        L24:
            if (r10.length != 0) goto L26;
            boolean r13 = true;
        L27:
            if (r13 == true) goto L30;
            r11 = false;
            goto L31
        L26:
            r13 = false;
        L34:
            l(new SkuProductDetailInfo(null, new ProductPriceInfo(null, null, new PromotionDiscountPrice(null, null, null, null, 15, null), null, null, 24, null), null, null, true, null, false, 108, null));
        }

        public final void d0(int r2) {
            this.a.r = r2;
        }

        public final void e0(SkuRestoreState r3) {
            Intrinsics.checkNotNullParameter(r3, "state");
            this.a.d2(r3, true);
        }

        public final void l(SkuProductDetailInfo r2) {
            this.a.l(r2);
        }

        public final void n0(boolean r2) {
            this.a.q = false;
        }

        public final void F(String r4, a0 r5) {
            Intrinsics.checkNotNullParameter(r4, "skuSessionId");
            Intrinsics.checkNotNullParameter(r5, "params");
            c r1 = this.a.p;
            if (r1 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("skuSchemaEventCenter");
        L5:
            r1.getClass();
            Intrinsics.checkNotNullParameter(r4, "skuSessionId");
            Intrinsics.checkNotNullParameter(r5, "eventParams");
            if (r4.length() != 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == true) goto L13;
            r1.b("ecom.sku.buynow", (PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2.a) r1.f.getValue());
            r1.b("ecom.sku.show", (PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2.a) r1.c.getValue());
            r1.b("ecom.sku.dismiss", (PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2.a) r1.e.getValue());
            r1.b("ecom.sku.spec.change", (PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2.a) r1.d.getValue());
            r1.b("ecom.sku.add.cart", (PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2.a) r1.g.getValue());
            r1.b.put(r4, r5);
            return;
        L13:
            return;
        L8:
            r0 = false;
            goto L9
        }

        public final void q(SkuRestoreState r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "state");
            this.a.q(r2, r3);
        }
    }

    @Override // vg3.e0
    public final String H1() {
        SkuRestoreState r0 = this.j;
        if (r0 == null) goto L7;
        String[] r1 = r0.getSelectSkuKeys();
        if (r1 == null) goto L7;
        return (String) ArraysKt.firstOrNull(r1);
    L7:
        return null;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(x.class);
    }

    public final x c2() {
        return (x) N1(x.class);
    }

    public PdpSKUService() {
        this.i = LazyKt.lazy(PdpSKUService$skuRefreshAB$2.INSTANCE);
        this.k = new LinkedHashSet();
        this.q = true;
        this.s = new ArrayList();
        this.t = new b(this);
        this.u = new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, e0.class, this, false, 12);
        Z1(x.class, new PdpSKUService$onAttach$1(this, null));
        O1().e().C1(new q(), true, new com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b(this));
        this.p = new c(O1().e(), this.u);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void U1() {
        super.U1();
        c r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("skuSchemaEventCenter");
    L5:
        g.c(r0.h, "ecom.sku.buynow", (PdpSchemaSkuEventCenter$skuBuyNowJsEventSubscriber$2.a) r0.f.getValue());
        g.c(r0.h, "ecom.sku.show", (PdpSchemaSkuEventCenter$skuShowJsEventSubscriber$2.a) r0.c.getValue());
        g.c(r0.h, "ecom.sku.dismiss", (PdpSchemaSkuEventCenter$skuDismissJsEventSubscriber$2.a) r0.e.getValue());
        g.c(r0.h, "ecom.sku.spec.change", (PdpSchemaSkuEventCenter$skuSpecChangeJsEventSubscriber$2.a) r0.d.getValue());
        g.c(r0.h, "ecom.sku.add.cart", (PdpSchemaSkuEventCenter$skuAddCartJsEventSubscriber$2.a) r0.g.getValue());
        Iterator r1 = ((LinkedHashMap) r0.a).entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) r1.next();
        g.c(r0.h, (String) r2.getKey(), (j) r2.getValue());
        goto L7
    L9:
        ((LinkedHashMap) r0.a).clear();
        ((LinkedHashMap) r0.b).clear();
    }

    @Override // vg3.e0
    public final List<SkuSpecInfo> Z0() {
        CommonMeta r0 = b2();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getSkuSpecInfo();
    }

    public final CommonMeta b2() {
        x r0 = c2();
        if (r0 == null) goto L9;
        PdpDataStore r1 = r0.getData();
        if (r1 == null) goto L9;
        e<CommonMeta> r2 = r1.a();
        if (r2 == null) goto L9;
        return r2.a();
    L9:
        return null;
    }

    @Override // vg3.e0
    public final int G0() {
        return this.r;
    }

    @Override // vg3.e0
    public final b b() {
        return this.t;
    }

    @Override // vg3.e0
    public final SkuRestoreState g0() {
        return this.j;
    }

    @Override // vg3.e0
    public final void f1(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "function");
        ((ArrayList) this.s).add(r2);
    }

    public final Object invoke(Object r10) {
        SkuProductDetailInfo r11 = (SkuProductDetailInfo) r10;
        x r0 = c2();
        if (r0 == null) goto L9;
        PdpDataStore r1 = r0.getData();
        if (r1 == null) goto L9;
        e<CommonMeta> r2 = r1.a();
        if (r2 == null) goto L9;
        CommonMeta r3 = r2.a();
    L10:
        String r6 = "";
        if (r11 != null) goto L13;
    L35:
        int r4 = c0.e;
        if (r11 != null) goto L38;
    L43:
        String r12 = null;
    L44:
        if (r12 != null) goto L46;
        r12 = "";
    L46:
        f.a.a(O1().e().r(), c0.a.a("SkuSpecifications", MapsKt.mapOf(TuplesKt.to("selected_specification", r12)), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
    L47:
        SkuRestoreState r13 = this.j;
        if (r13 == null) goto L52;
        String[] r14 = r13.getSelectSkuKeys();
        if (r14 == null) goto L52;
        String r15 = (String) ArraysKt.firstOrNull(r14);
    L53:
        if (r15 == null) goto L56;
        r6 = r15;
    L56:
        int r16 = c0.e;
        SlcCommonAction r5 = c0.a.a("SkuPreview", MapsKt.mapOf(TuplesKt.to("spec_id", r6)), null, 10);
        SlcCommonAction r17 = c0.a.a("head_sku_info", MapsKt.mapOf(TuplesKt.to("spec_id", r6)), null, 10);
        f.a.a(O1().e().r(), r5, new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        f.a.a(O1().e().r(), r17, new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        return Unit.INSTANCE;
    L52:
        r15 = null;
        goto L53
    L38:
        if (com.bytedance.android.ec.model.m.a(r11.getSkuPrice()) == true) goto L41;
        r11 = null;
    L41:
        if (r11 == null) goto L43;
        r12 = r11.getSkuName();
        goto L44
    L13:
        if (r11.isSkuInfo() != true) goto L35;
        if (r3 == null) goto L19;
        List r8 = r3.getSkuSpecInfo();
        if (r8 == null) goto L19;
        if (r8.isEmpty() == true) goto L35;
    L19:
        if (r3 == null) goto L47;
        SkuRestoreState r18 = this.j;
        if (r18 == null) goto L23;
        String[] r19 = r18.getSelectSkuKeys();
    L24:
        String r110 = h73.a.e(r3, r19);
        if (r110 == null) goto L47;
        SkuRestoreState r7 = this.j;
        if (r7 == null) goto L29;
        Boolean r9 = Boolean.valueOf(r7.hasSelectedSku());
    L30:
        int r20 = c0.e;
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == true) goto L34;
        r110 = "";
    L34:
        f.a.a(O1().e().r(), c0.a.a("SkuSpecifications", MapsKt.mapOf(TuplesKt.to("selected_specification", r110)), null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), true, 4);
        goto L47
    L29:
        r9 = null;
        goto L30
    L23:
        r19 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Override // vg3.e0
    public final void l(SkuProductDetailInfo r4) {
        CommonMeta r0 = b2();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.getEnablePDPOptimize());
    L7:
        if (k.i(r1) == false) goto L13;
        Iterator<T> r2 = this.k.iterator();
    L10:
        if (r2.hasNext() == false) goto L44;
        ((Function1) r2.next()).invoke(r4);
        goto L10
    L44:
        return;
    L13:
        if (r4 != null) goto L15;
    L20:
        if (r4 == null) goto L33;
        String r3 = r4.getSkuBigImageUrl();
        if (r3 == null) goto L33;
        if (a2.b(r3) != true) goto L33;
        if (com.bytedance.android.ec.model.m.a(r4.getSkuPrice()) == false) goto L33;
        Iterator<T> r5 = this.k.iterator();
    L29:
        if (r5.hasNext() == false) goto L31;
        ((Function1) r5.next()).invoke(r4);
        goto L29
    L31:
        this.m = true;
        return;
    L33:
        if (this.m == false) goto L43;
        this.m = false;
        Iterator<T> r6 = this.k.iterator();
    L36:
        if (r6.hasNext() == false) goto L46;
        ((Function1) r6.next()).invoke(null);
        goto L36
    L46:
        return;
    L43:
        return;
    L15:
        if (r4.isSkuInfo() != true) goto L20;
        Iterator<T> r7 = this.k.iterator();
    L18:
        if (r7.hasNext() == false) goto L45;
        ((Function1) r7.next()).invoke(r4);
        goto L18
    L45:
        return;
    L5:
        r1 = null;
        goto L7
    }

    @Override // vg3.e0
    public final void u(Function1<? super SkuProductDetailInfo, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.k.add(r2);
    }

    public final void d2(SkuRestoreState r7, boolean r8) {
        CommonMeta r0 = b2();
        boolean r2 = false;
        if (this.j != null) goto L21;
        if (r0 == null) goto L21;
        List r1 = r0.getSkuSpecInfo();
        if (r1 == null) goto L21;
        if (r1.size() != r7.getSelectSkuKeys().length) goto L21;
        List<SkuSpecInfo> r3 = Z0();
        if (r3 == null) goto L21;
        Iterator<T> r4 = r3.iterator();
        int r5 = 0;
    L13:
        if (r4.hasNext() == false) goto L21;
        Object r6 = r4.next();
        int r9 = r5 + 1;
        if (r5 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        SkuSpecInfo r10 = (SkuSpecInfo) r6;
        if (com.bytedance.android.shopping.anchorv3.a.b(r10.getSelectSpecId()) == false) goto L20;
        r7.getSelectSkuKeys()[r5] = r10.getSelectSpecId();
        this.l = r7.joinedKey();
    L20:
        r5 = r9;
    L21:
        this.j = r7;
        CommonMeta r11 = b2();
        String r12 = r7.joinedKey();
        if (Intrinsics.areEqual(this.l, r12) == false) goto L24;
    L27:
        r2 = true;
    L28:
        this.l = r12;
        if (r2 == false) goto L31;
        return;
    L31:
        if (r11 == null) goto L33;
        String r13 = r11.getForbidSkuSwitch();
    L35:
        if (Intrinsics.areEqual(r13, "1") == false) goto L37;
        return;
    L37:
        if (((Boolean) this.i.getValue()).booleanValue() == false) goto L53;
        if (r8 == true) goto L41;
        return;
    L41:
        if (com.bytedance.android.ec.core.abtest.d.D() == false) goto L43;
        String r14 = "sku_select_finish";
    L44:
        x r15 = c2();
        if (r15 == null) goto L54;
        x.a.a(r15, true, r14, null, 28);
        return;
    L54:
        return;
    L43:
        r14 = "sku_select";
        goto L44
    L53:
        return;
    L33:
        r13 = null;
        goto L35
    L24:
        if (this.l != null) goto L28;
        if (Intrinsics.areEqual(r12, "") == false) goto L28;
        goto L27
    }

    @Override // vg3.e0
    public final void q(SkuRestoreState r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "state");
        r2.setSelectedSkuId(null);
        d2(r2, r3);
    }
}
