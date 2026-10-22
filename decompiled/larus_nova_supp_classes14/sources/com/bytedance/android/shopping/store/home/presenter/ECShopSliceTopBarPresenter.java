package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.home.view.ECStoreCollapsibleTextView;
import com.bytedance.android.shopping.store.slicecard.ShopSlcCardFactory;
import com.bytedance.android.shopping.store.slicecard.ShopSliceUniqueId;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopSliceTopBarPresenter extends ECShopBasePresenter {
    public static final /* synthetic */ int G = 0;
    public Map<String, Object> A;
    public final Map<String, Object> B;
    public Map<String, Object> C;
    public com.bytedance.android.ecom.arch.slice.render.context.a D;
    public final Lazy E;
    public boolean F;
    public ViewGroup u;
    public View v;
    public View w;
    public ECStoreCollapsibleTextView x;
    public com.bytedance.android.ecom.arch.slice.render.r y;
    public Map<String, ? extends Object> z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopSliceTopBarPresenter a;

        public b(ECShopSliceTopBarPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            com.bytedance.android.shopping.store.home.entity.n r8 = (com.bytedance.android.shopping.store.home.entity.n) r7;
            Intrinsics.checkNotNullParameter(r8, "headerArea");
            if (r8.d() == true) goto L5;
        L44:
            ViewGroup r9 = this.a.u;
            if (r9 == null) goto L49;
            ExtensionsKt.gone(r9);
            return;
        L49:
            return;
        L5:
            if (r8.c() == true) goto L44;
            ViewGroup r0 = this.a.u;
            if (r0 == null) goto L10;
            ExtensionsKt.visible(r0);
        L10:
            com.bytedance.android.shopping.store.home.slice.d r1 = r8.o;
            if (r1 == null) goto L43;
            ECShopSliceTopBarPresenter r2 = this.a;
            r2.T().getSliceService().d(com.bytedance.android.shopping.store.home.slice.f.a(r1));
            ShopSlcCardFactory r3 = r2.T().getSliceCardFactory();
            Map<String, ECStoreHeaderInfoSliceConfig> r4 = r1.a;
            Map<String, Object> r5 = null;
            if (r4 == null) goto L23;
            ECStoreHeaderInfoSliceConfig r6 = r4.get(SliceItemType.SHOP_TOP_BAR.getType());
            if (r6 == null) goto L23;
            ShopSliceItemConfig r10 = r6.getSliceItemConfig();
            if (r10 == null) goto L23;
            List<SliceTemplate> r11 = r10.getTemplates();
            if (r11 == null) goto L23;
            SliceTemplate r12 = (SliceTemplate) CollectionsKt.firstOrNull(r11);
            if (r12 == null) goto L23;
            String r13 = r12.getName();
        L24:
            com.bytedance.android.ecom.arch.slice.render.r r14 = r3.g(r13);
            r2.y = r14;
            if (r14 == null) goto L27;
            r14.b((com.bytedance.android.shopping.store.slicecard.e) r2.E.getValue());
        L27:
            ECShopSliceTopBarPresenter r15 = this.a;
            com.bytedance.android.shopping.store.home.entity.d r16 = r8.c;
            r15.getClass();
            r15.z = r1.b;
            Map<String, ECStoreHeaderInfoSliceConfig> r17 = r1.a;
            if (r17 == null) goto L39;
            ECStoreHeaderInfoSliceConfig r18 = r17.get(SliceItemType.SHOP_TOP_BAR.getType());
            if (r18 == null) goto L39;
            Map<String, Object> r19 = r18.getSliceItemActions();
            if (r19 == null) goto L34;
            Map<String, Object> r20 = MapsKt.toMutableMap(r19);
        L35:
            r15.A = r20;
            Map<String, Object> r21 = r18.getSliceItemExtra();
            if (r21 == null) goto L38;
            r5 = MapsKt.toMutableMap(r21);
        L38:
            r15.C = r5;
            goto L39
        L34:
            r20 = null;
        L39:
            int r22 = com.bytedance.android.shopping.store.home.b0.a;
            com.bytedance.android.shopping.store.home.b0.a(r15.B, com.bytedance.android.shopping.store.home.b0.b(r16));
            dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("updateFollowStateFromAccountInfo, sliceItemStates: " + r15.B);
            ECShopSliceTopBarPresenter r23 = this.a;
            if (r23.D != null) goto L42;
            c2 r24 = new c2(this);
            r23.T().getSliceService().f(r24);
            Unit r25 = Unit.INSTANCE;
            r23.D = r24;
        L42:
            ECShopSliceTopBarPresenter.q0(this.a);
        L23:
            r13 = null;
        L43:
            this.a.T().getFollowConfigLiveData().a(this.a.W(), new d2(this), false);
            this.a.T().getUpglideFactor().a(ECQuickUtilKt.a(this.a.u()), new e2(this), false);
            this.a.T().isProductListAllShowCrossShop().a(this.a.W(), new f2(this), false);
            this.a.T().getSelectedTabLocation().a(this.a.W(), new g2(this), false);
            this.a.T().getTopSearchInfo().a(this.a.W(), new h2(this), false);
        }
    }

    static {
    }

    public final void C() {
        com.bytedance.android.ecom.arch.slice.render.context.a r0 = this.D;
        if (r0 == null) goto L5;
        T().getSliceService().h(r0);
    L5:
        this.D = null;
    }

    public ECShopSliceTopBarPresenter(final Fragment r2) {
        super(r2);
        this.B = new LinkedHashMap();
        this.E = LazyKt.lazy(new ECShopSliceTopBarPresenter$slcActionHandler$2(this, r2));
    }

    public static final void q0(ECShopSliceTopBarPresenter r7) {
        if (r7.z == null) goto L23;
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(r7.B);
        r0.putAll(r7.T().getSliceService().a());
        r0.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        if (r7.T().isCroppedStyle() == false) goto L8;
        String r1 = "seven_split";
    L9:
        r0.put("modal", r1);
        r0.put("is_split_mode", Boolean.valueOf(r7.T().getStoreParam().isSplitMode()));
        r0.put("is_split_top", Boolean.valueOf(r7.T().getStoreParam().isTopSplit()));
        LinkedHashMap r2 = new LinkedHashMap();
        Map<String, ? extends Object> r3 = r7.z;
        if (r3 != null) goto L12;
        r3 = MapsKt.emptyMap();
    L12:
        r2.putAll(r3);
        r2.put("slice_item_actions", r7.A);
        r2.put("slice_item_states", r0);
        r2.put("slice_item_extra", r7.C);
        Unit r4 = Unit.INSTANCE;
        Map r5 = MapsKt.mapOf(TuplesKt.to("data", r2));
        dm.a.a("ECShopInfoTotalAreaSlicePresenter").a("bindData, sliceItemStates: " + r7.B);
        dm.a.b r6 = dm.a.a("ECShopInfoTotalAreaSlicePresenter");
        StringBuilder r8 = new StringBuilder("bindData, dataCtx sliceItemStates: ");
        Object r9 = r5.get("data");
        if (r9 == null) goto L17;
        Map r10 = com.bytedance.android.ecom.arch.slice.render.util.b.o(r9);
        if (r10 == null) goto L17;
        Object r11 = r10.get("slice_item_states");
    L18:
        r8.append(r11);
        r6.a(r8.toString());
        com.bytedance.android.ecom.arch.slice.render.r r12 = r7.y;
        if (r12 == null) goto L22;
        r12.a(r5, ShopSliceUniqueId.SHOP_TOP_BAR.getId());
        return;
    L22:
        return;
    L17:
        r11 = null;
        goto L18
    L8:
        r1 = "";
        goto L9
    }

    public static final void r0(ECShopSliceTopBarPresenter r2) {
        if (Intrinsics.areEqual((Boolean) r2.T().isProductListAllShowCrossShop().getValue(), Boolean.TRUE) == false) goto L10;
        ECStoreCollapsibleTextView r0 = r2.x;
        if (r0 == null) goto L7;
        ExtensionsKt.gone(r0);
    L7:
        View r3 = r2.w;
        if (r3 == null) goto L17;
        ExtensionsKt.gone(r3);
        return;
    L17:
        return;
    L10:
        View r1 = r2.w;
        if (r1 == null) goto L13;
        ExtensionsKt.visible(r1);
    L13:
        ECStoreCollapsibleTextView r4 = r2.x;
        if (r4 == null) goto L19;
        ExtensionsKt.visible(r4);
        return;
    }

    public final void A(QModel r4) {
        View r5 = y();
        if ((r5 instanceof ViewGroup) == true) goto L5;
        r5 = null;
    L5:
        this.u = (ViewGroup) r5;
        T().getHeaderArea().a(W(), new b(this), false);
    }
}
