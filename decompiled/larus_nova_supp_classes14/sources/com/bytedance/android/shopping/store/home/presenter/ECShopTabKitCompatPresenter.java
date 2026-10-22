package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductListResponseVO;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.shopping.store.home.entity.ECStoreDynamicTabData;
import com.bytedance.android.shopping.store.home.view.ShopBottomTabItemView;
import com.bytedance.android.shopping.store.hybrid.ECStoreHybridTabFragment;
import com.bytedance.android.shopping.store.hybrid.StoreTabConfig;
import com.bytedance.android.shopping.store.moments.ECStoreMixFragment;
import com.bytedance.android.shopping.store.moments.dto.ECStoreMomentResponse;
import com.bytedance.android.shopping.store.moments.dto.HybridListDTO;
import com.bytedance.android.shopping.store.moments.dto.SectionDTO;
import com.bytedance.android.shopping.store.product.ECShopHybridTabFragment;
import com.bytedance.android.shopping.store.product.ECStoreProductTabFragment;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory;
import com.bytedance.android.shopping.store.tabkit.TabKitAbilityConfig;
import com.bytedance.android.shopping.store.tabkit.TabKitTabFragment;
import com.bytedance.android.shopping.store.tabkit.TabKitViewModel;
import com.bytedance.android.shopping.store.tabkit.view.BottomTabItemView;
import com.bytedance.android.shopping.store.tabkit.view.TopTabItemView;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.base.widget.tablayout.ECTabLayout;
import com.bytedance.android.ui.ec.widget.toast.ECToast;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentConstants$CmtLongPanelStrategy;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopTabKitCompatPresenter extends ECShopBasePresenter implements ITabKitComponentFactory, com.bytedance.android.shopping.store.tabkit.g {
    public static final /* synthetic */ int z = 0;
    public final Map<String, String> u;
    public final TabKitViewModel v;
    public final c w;
    public final HashSet<Integer> x;
    public final com.bytedance.android.shopping.store.tabkit.f y;

    public static final class a {
    }

    public static final class b extends TopTabItemView {
        @Override // com.bytedance.android.shopping.store.tabkit.view.TopTabItemView, com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView, com.bytedance.android.shopping.store.tabkit.view.BaseTabItemView
        public final void a(boolean r1, boolean r2) {
        }

        @Override // com.bytedance.android.shopping.store.tabkit.view.TopTabItemView, com.bytedance.android.shopping.store.tabkit.view.ABSTabItemView
        public int getResourceId() {
            return super.getResourceId();
        }

        public b(Context r5) {
            super(r5, null, 6, 0);
            ViewGroup.LayoutParams r6 = getTitleTV().getLayoutParams();
            if (r6 == null) goto L11;
            ((ViewGroup.MarginLayoutParams) r6).setMargins(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(5));
            ViewGroup.LayoutParams r7 = getIconView().getLayoutParams();
            if (r7 == null) goto L9;
            ((ViewGroup.MarginLayoutParams) r7).setMargins(0, 0, 0, com.bytedance.android.shopping.extensions.b.b(5));
            getTitleTV().setTextSize(17.0f);
            super.setPadding(com.bytedance.android.shopping.extensions.b.b(10), 0, com.bytedance.android.shopping.extensions.b.b(10), 0);
            getIconView().setAdjustMode(33);
            ViewGroup.LayoutParams r8 = getIconView().getLayoutParams();
            r8.width = -2;
            r8.height = -2;
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }

        @Override // android.view.View
        public final void setPadding(int r1, int r2, int r3, int r4) {
            super.setPadding(r1, r2, r3, r4);
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ ECShopTabKitCompatPresenter a;

        public c(ECShopTabKitCompatPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r11) {
            Intrinsics.checkNotNullParameter(r11, "params");
            String r0 = r11.optString("shopId");
            int r3 = r11.optInt("tabId");
            String r1 = r11.optString("coupon_id");
            String r5 = r11.optString("product_tab_pass_through_api");
            String r2 = r11.optString("product_tab_params");
            if (cg4.a.a(r2) == true) goto L6;
            r2 = null;
        L6:
            String r4 = r2;
            String r7 = r11.optString("toast_msg");
            String r9 = r11.optString("extra_data");
            String r12 = r11.optString("scene");
            if ((!Intrinsics.areEqual(r0, this.a.T().getStoreParam().getShopId())) == false) goto L9;
            return;
        L9:
            com.bytedance.android.ec.core.utils.s0.a(new ui3.d(r1));
            this.a.handleOpenShopEvent(new ah.d(r3, r4, r5, true, r7, r12));
            if (Intrinsics.areEqual(r12, "tool_dialog") == false) goto L13;
            this.a.T().getHideToolDialogEvent().c(Boolean.TRUE);
            this.a.T().getCacheCouponData().setValue(r9);
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
    public final boolean getDisableBottomBar() {
        return false;
    }

    public final void C() {
        com.bytedance.android.ec.core.utils.s0.e(this);
        ECLiveHybridUtil.p("ecom.shop.float_layer_js_event", this.w);
    }

    public ECShopTabKitCompatPresenter(com.bytedance.android.shopping.store.tabkit.f r5) {
        TabKitViewModel r1 = null;
        if ((r5 instanceof Fragment) == true) goto L5;
        com.bytedance.android.shopping.store.tabkit.f r0 = null;
    L6:
        super((Fragment) r0);
        this.y = r5;
        this.u = MapsKt.mapOf(new Pair[]{TuplesKt.to("0", "old_manual"), TuplesKt.to(CommentScene.COMMENTSCENE_NO_AWEME, "auto"), TuplesKt.to("2", "new_manual")});
        if (r5 == null) goto L9;
        r1 = r5.getTabKitViewModel();
    L9:
        this.v = r1;
        this.w = new c(this);
        this.x = new HashSet();
        return;
    L5:
        r0 = r5;
        goto L6
    }

    public final void A(QModel r4) {
        T().getTopSearchInfo().a(W(), new ECShopTabKitCompatPresenter$onBind$1(this), false);
        TabKitViewModel r5 = this.v;
        if (r5 == null) goto L7;
        MutableLiveData<com.bytedance.android.shopping.store.tabkit.model.y> r6 = r5.getCurrentTabAfter();
        if (r6 == null) goto L7;
        r6.observe(W(), new ECShopTabKitCompatPresenter$onBind$2(this));
    L7:
        T().getTabArea().a(W(), new ECShopTabKitCompatPresenter$onBind$3(this), false);
        if (T().isCroppedStyle() == false) goto L10;
        T().getCroppedState().a(W(), new ECShopTabKitCompatPresenter$onBind$4(this), false);
    L10:
        TabKitViewModel r7 = this.v;
        if (r7 == null) goto L13;
        r7.setTabKitComponentFactory(this);
    L13:
        TabKitViewModel r8 = this.v;
        if (r8 == null) goto L16;
        r8.addTabKitLifeListener(this);
    L16:
        com.bytedance.android.ec.core.utils.s0.c(this);
        ECLiveHybridUtil.m("ecom.shop.float_layer_js_event", this.w);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
    public final BottomTabItemView createBottomTabItemView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        return new ShopBottomTabItemView(r8, T().getStoreParam().getLifecycleMonitorId(), new AnonymousClass1(this), new AnonymousClass2(this));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
    public final TopTabItemView createTopTabItemView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new b(r2);
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void f(ECTabLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
        Intrinsics.checkNotNullParameter(r2, "tabLayout");
    }

    @Subscribe
    public final void handleOpenShopEvent(ah.d r11) {
        Intrinsics.checkNotNullParameter(r11, "event");
        com.bytedance.android.shopping.store.tabkit.f r0 = this.y;
        if (r0 == null) goto L36;
        TabKitViewModel r1 = r0.getTabKitViewModel();
        if (r1 == null) goto L37;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = r1.getTabById(Integer.valueOf(r11.a));
        if (r2 == null) goto L40;
        ECStoreViewModel r3 = T();
        if (r2.g() == false) goto L15;
        r2 = r2.d();
        if (r2 != null) goto L15;
        Integer r4 = null;
    L16:
        uj3.j r5 = r3.getTab(r4);
        if (r5 != null) goto L20;
        return;
    L20:
        if (T().getStoreParam().isPreview() == true) goto L22;
    L24:
        T().setProductTabParams(r11.b);
        T().getStoreParam().setProductTabPassThroughApi(r11.c);
        T().setScene(r11.f);
        uj3.j r6 = T().getCurrentTab();
        if (r6 == null) goto L29;
        int r7 = r6.d;
        int r8 = r5.d;
        if (r7 != r8) goto L29;
        com.bytedance.android.ec.core.utils.s0.a(new ah.h(Integer.valueOf(r8), r11.b, r11.c));
    L29:
        this.y.Mc().f0(r5.d);
        String r12 = r11.e;
        if (cg4.a.a(r12) == false) goto L32;
        String r9 = r12;
    L33:
        if (r9 == null) goto L39;
        ECToast.showToast$default(ECToast.INSTANCE, u().c(), r9, null, 4, null);
        return;
    L39:
        return;
    L32:
        r9 = null;
        goto L33
    L22:
        if (r5.f == true) goto L24;
        ECToast.showToast$default(ECToast.INSTANCE, u().c(), ag4.a.a(2131914044, CollectionsKt.listOf(r5.e)), null, 4, null);
        return;
    L15:
        r4 = r2.n();
        goto L16
    L40:
        return;
    L37:
        return;
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void k(com.bytedance.android.shopping.store.tabkit.model.k r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        y().post(new ECShopTabKitCompatPresenter$reportTabShowEvent$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void l(com.bytedance.android.shopping.store.tabkit.model.k r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        y().post(new ECShopTabKitCompatPresenter$reportTabShowEvent$1(this, r3));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.g
    public final void o(com.bytedance.android.shopping.store.tabkit.model.k r3) {
        Intrinsics.checkNotNullParameter(r3, "tab");
        T().setEnterOtherPageCollaspeHeader(true);
        q0(new com.bytedance.android.shopping.store.tabkit.model.y(r3, PinchEnterMethod.CLICK));
    }

    public final void q0(com.bytedance.android.shopping.store.tabkit.model.y r10) {
        com.bytedance.android.shopping.store.tabkit.model.k r0 = r10.a;
        TabKitViewModel r1 = this.v;
        if (r1 == null) goto L5;
        com.bytedance.android.shopping.store.tabkit.model.k r2 = r1.getLastTab();
    L6:
        if (r2 == null) goto L9;
        com.bytedance.android.shopping.store.tabkit.model.k r3 = r2.a;
        if (r3 == null) goto L9;
    L10:
        com.bytedance.android.shopping.store.tabkit.model.k r4 = r0.a;
        if (r4 != null) goto L13;
        com.bytedance.android.shopping.store.tabkit.model.k r5 = r0;
    L15:
        if (r2 != null) goto L20;
        if (r4 == null) goto L18;
        T().isWhiteBrand();
        com.bytedance.android.shopping.store.tabkit.model.k r11 = r0.a;
        Intrinsics.checkNotNull(r11);
        r0(r11, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", CommentConstants$CmtLongPanelStrategy.DEFAULT)}));
    L18:
        r0(r0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", CommentConstants$CmtLongPanelStrategy.DEFAULT)}));
        return;
    L20:
        if (Intrinsics.areEqual(r10.b, CommentConstants$CmtLongPanelStrategy.DEFAULT) == false) goto L22;
        String r12 = CommentConstants$CmtLongPanelStrategy.DEFAULT;
    L24:
        if (Intrinsics.areEqual(r3, r5) == false) goto L29;
        if ((!Intrinsics.areEqual(r2, r0)) == false) goto L29;
        r0(r0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", r12)}));
        return;
    L29:
        if ((!Intrinsics.areEqual(r3, r5)) == true) goto L31;
        return;
    L31:
        if (Intrinsics.areEqual(r5, r0) == false) goto L33;
        r0(r0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", r12)}));
        return;
    L33:
        r0(r0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", CommentConstants$CmtLongPanelStrategy.DEFAULT)}));
        r0(r5, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("click_type", r12)}));
        return;
    L22:
        r12 = PinchEnterMethod.CLICK;
        goto L24
    L13:
        r5 = r4;
    L9:
        r3 = r2;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void r0(com.bytedance.android.shopping.store.tabkit.model.k r4, Map r5) {
        uj3.j r6 = T().getTab(r4.n());
        if (r6 != null) goto L5;
        return;
    L5:
        Lazy r0 = ECTaskManager.b;
        ECTaskManager r1 = ECTaskManager.a.a();
        ECShopTabKitCompatPresenter$reportTabEvent$1 r2 = new ECShopTabKitCompatPresenter$reportTabEvent$1(this, "commodity_source_tab_click", r6, r5);
        r1.getClass();
        ECTaskManager.b(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r5v14, types: [android.os.Bundle] */
    @Override // com.bytedance.android.shopping.store.tabkit.ITabKitComponentFactory
    public final TabKitTabFragment createTab(com.bytedance.android.shopping.store.tabkit.model.k r37, boolean r38, TabKitAbilityConfig r39) {
        Intrinsics.checkNotNullParameter(r37, "tab");
        Intrinsics.checkNotNullParameter(r39, "config");
        ECStoreViewModel r1 = T();
        Integer r2 = r37.n();
        if (r2 == null) goto L5;
        int r3 = r2.intValue();
    L6:
        uj3.j r4 = r1.getTab(Integer.valueOf(r3));
        Intrinsics.checkNotNull(r4);
        int r5 = com.bytedance.android.shopping.store.hybrid.l.a;
        int r6 = r4.d;
        com.bytedance.android.shopping.store.tabkit.f r7 = this.y;
        if (r7 == null) goto L11;
        TabKitViewModel r8 = r7.getTabKitViewModel();
        if (r8 == null) goto L11;
        Integer r9 = r8.getAnchorTabId();
    L12:
        if (r9 != null) goto L15;
    L17:
        boolean r10 = false;
    L18:
        StoreTabConfig r11 = com.bytedance.android.shopping.store.hybrid.l.a(r4, r10);
        Map<Long, com.bytedance.android.shopping.store.lifecycle.m> r12 = com.bytedance.android.shopping.store.lifecycle.a.a;
        com.bytedance.android.shopping.store.lifecycle.m r13 = com.bytedance.android.shopping.store.lifecycle.a.a(Long.valueOf(T().getStoreParam().getLifecycleMonitorId()));
        if (r13 == null) goto L21;
        r13.c(r11);
    L21:
        T().updateTabConfig(r11);
        if (r4.i() == false) goto L66;
        int r0 = ECStoreProductTabFragment.r;
        Intrinsics.checkNotNullParameter(r11, "tabConfig");
        ECStoreProductTabFragment r14 = new ECStoreProductTabFragment();
        String r15 = com.bytedance.android.shopping.store.utils.m.b(r11);
        Bundle r16 = new Bundle();
        r16.putString("store_tab_config_key", r15);
        Unit r17 = Unit.INSTANCE;
        r14.setArguments(r16);
        String r18 = r4.l;
        if (r18 == null) goto L31;
        T().getStoreParam().getProductBasicRequestParam().setCustomIds(null);
        if (r18.length() <= 0) goto L28;
        boolean r19 = true;
    L29:
        if (r19 == false) goto L31;
        ECToast.showToast$default(ECToast.INSTANCE, u().c(), r18, null, 4, null);
        goto L31
    L28:
        r19 = false;
    L31:
        List<com.bytedance.android.ec.store.repository.vo.q> r20 = r4.h;
        List<com.bytedance.android.ec.store.repository.vo.r> r21 = r4.i;
        List<? extends StoreV2ProductItemVO> r110 = r4.j;
        boolean r111 = r4.k;
        Integer r112 = r4.s;
        if (r4.l != null) goto L34;
        String r113 = T().getStoreParam().getProductBasicRequestParam().getCustomIds();
    L35:
        Long r22 = Long.valueOf(r4.r);
        Integer r23 = r4.o;
        String r24 = r4.p;
        Integer r114 = r4.g;
        com.bytedance.android.ec.store.repository.vo.n r25 = r4.B;
        Integer r26 = r4.C;
        List<com.bytedance.android.ec.store.repository.dto.g> r27 = r4.F;
        Map<String, String> r28 = r4.G;
        ECHybridListDTO r29 = r4.H;
        com.bytedance.android.ec.hybrid.list.entity.k r30 = r4.I;
        String r31 = r4.J;
        if (r113 == null) goto L38;
        r14.l.getClass();
        r14.l.getClass();
    L38:
        if (r29 == null) goto L48;
        Map r115 = r29.getExtra();
        if (r115 == null) goto L48;
        String r32 = (String) r115.get("reserved_sections");
        if (r32 == null) goto L48;
        List r33 = StringsKt.split$default(r32, new String[]{","}, false, 0, 6, null);
        if (r33 == null) goto L48;
        List r34 = CollectionsKt.toList(r33);
        if (r34 == null) goto L48;
        List<String> r116 = com.bytedance.android.shopping.store.hybridproduct.k0.a;
        Intrinsics.checkNotNullParameter(r34, "preservedSections");
        ((ArrayList) com.bytedance.android.shopping.store.hybridproduct.k0.a).addAll(r34);
    L48:
        if (r29 == null) goto L53;
        List r35 = r29.getSections();
        if (r35 == null) goto L53;
        if ((!r35.isEmpty()) != true) goto L53;
    L54:
        r14.k = com.bytedance.android.shopping.store.product.f.a(r20, r21, r110, r111, r112, r22, r23, r24, r114, r25, r26, r27, r28, r29, r30, r31, null, 65536);
    L64:
        com.bytedance.android.ec.core.utils.s0.c(r14);
        TabKitTabFragment r36 = r14;
    L181:
        if ((r36 instanceof TabKitTabFragment) == true) goto L184;
        return null;
    L184:
        return r36;
    L53:
        if (r31 != null) goto L54;
        List<com.bytedance.android.ec.store.repository.vo.r> r40 = r21;
        if (r40 != null) goto L58;
    L61:
        boolean r117 = true;
    L62:
        if (r117 == true) goto L64;
        r14.k = com.bytedance.android.shopping.store.product.f.a(r20, r21, r110, r111, r112, r22, r23, r24, r114, r25, r26, r27, r28, null, null, null, null, 122880);
        goto L64
    L58:
        if (r40.isEmpty() == true) goto L61;
        r117 = false;
        goto L62
    L34:
        r113 = null;
        goto L35
    L66:
        if (r4.g() == false) goto L136;
        dm.a.a("混排tab").a("tabVO_id:" + r4.t);
        int r41 = ECShopHybridTabFragment.n;
        String r42 = "products_" + r4.d;
        Intrinsics.checkNotNullParameter(r11, "tabConfig");
        Intrinsics.checkNotNullParameter(r42, "entranceFrom");
        ECShopHybridTabFragment r43 = new ECShopHybridTabFragment();
        String r44 = com.bytedance.android.shopping.store.utils.m.b(r11);
        Bundle r45 = new Bundle();
        r45.putString("store_tab_config_key", r44);
        r45.putString("ecom_entrance_form", r42);
        r45.putBoolean("auto_bind_module", false);
        r45.putBoolean("show_sort_bar", true);
        Unit r46 = Unit.INSTANCE;
        r43.setArguments(r45);
        List<com.bytedance.android.ec.store.repository.vo.q> r47 = r4.h;
        List<com.bytedance.android.ec.store.repository.vo.r> r48 = r4.i;
        List<? extends StoreV2ProductItemVO> r49 = r4.j;
        boolean r50 = r4.k;
        Integer r51 = r4.s;
        String r52 = T().getStoreParam().getProductBasicRequestParam().getCustomIds();
        Long r210 = Long.valueOf(r4.r);
        Integer r118 = r4.o;
        String r119 = r4.p;
        Integer r120 = r4.g;
        com.bytedance.android.ec.store.repository.vo.n r121 = r4.B;
        Integer r122 = r4.C;
        List<com.bytedance.android.ec.store.repository.dto.g> r123 = r4.F;
        Map<String, String> r124 = r4.G;
        ECHybridListDTO r125 = r4.H;
        String r126 = r4.J;
        String r53 = r4.K;
        if (r52 == null) goto L70;
        r43.l.getClass();
        r43.l.getClass();
    L70:
        if (r125 == null) goto L80;
        Map r54 = r125.getExtra();
        if (r54 == null) goto L80;
        String r310 = (String) r54.get("reserved_sections");
        if (r310 == null) goto L80;
        List r55 = StringsKt.split$default(r310, new String[]{","}, false, 0, 6, null);
        if (r55 == null) goto L80;
        List r56 = CollectionsKt.toList(r55);
        if (r56 == null) goto L80;
        List<String> r57 = com.bytedance.android.shopping.store.hybridproduct.k0.a;
        Intrinsics.checkNotNullParameter(r56, "preservedSections");
        ((ArrayList) com.bytedance.android.shopping.store.hybridproduct.k0.a).addAll(r56);
    L80:
        if (r125 == null) goto L86;
        List r58 = r125.getSections();
        if (r58 == null) goto L86;
        boolean r59 = true;
        if ((!r58.isEmpty()) != true) goto L87;
    L98:
        r43.k = com.bytedance.android.shopping.store.product.f.a(r47, r48, r49, r50, r51, r210, r118, r119, r120, r121, r122, r123, r124, r125, null, r126, r53, 16384);
        if (r125 == null) goto L134;
        List r60 = r125.getSections();
        if (r60 == null) goto L134;
        Iterator r61 = r60.iterator();
    L104:
        if (r61.hasNext() == false) goto L134;
        ECHybridListSectionDTO r62 = (ECHybridListSectionDTO) r61.next();
        if (Intrinsics.areEqual(r62.getSectionId(), "__FILTER_SECTION__") == false) goto L104;
        ArrayList r63 = r62.getItems();
        if (r63 == null) goto L110;
        ECHybridListItemDTO r64 = (ECHybridListItemDTO) CollectionsKt.firstOrNull(r63);
    L111:
        if (r64 == null) goto L113;
        Object r65 = r64.getItemData();
    L115:
        if ((r65 instanceof dj3.g) == true) goto L117;
        r65 = null;
    L117:
        dj3.g r66 = (dj3.g) r65;
        if (r66 == null) goto L124;
        List<com.bytedance.android.ec.store.repository.dto.c> r67 = r66.c();
        if (r67 == null) goto L124;
        StoreV2ProductListResponseVO r68 = r43.k;
        if (r68 == null) goto L124;
        com.bytedance.android.ec.store.repository.vo.n r69 = new com.bytedance.android.ec.store.repository.vo.n();
        r69.a = r67;
        Unit r70 = Unit.INSTANCE;
        r68.setDiscountFilterButtons(r69);
    L124:
        if (r66 == null) goto L104;
        List<com.bytedance.android.ec.store.repository.dto.m> r71 = r66.f();
        if (r71 == null) goto L104;
        StoreV2ProductListResponseVO r72 = r43.k;
        if (r72 == null) goto L104;
        List<com.bytedance.android.ec.store.repository.dto.m> r73 = r71;
        ArrayList r74 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r73, 10));
        Iterator r75 = r73.iterator();
    L131:
        if (r75.hasNext() == false) goto L133;
        com.bytedance.android.ec.store.repository.dto.m r76 = (com.bytedance.android.ec.store.repository.dto.m) r75.next();
        int r77 = com.bytedance.android.ec.store.repository.vo.r.t;
        r74.add(com.bytedance.android.ec.store.repository.vo.r.a.a(r76));
        goto L131
    L133:
        r72.setSortTypes(r74);
        goto L104
    L113:
        r65 = null;
        goto L115
    L110:
        r64 = null;
    L134:
        r36 = r43;
    L87:
        if (r126 != null) goto L98;
        if (r53 != null) goto L98;
        List<com.bytedance.android.ec.store.repository.vo.r> r78 = r48;
        if (r78 != null) goto L93;
    L96:
        if (r59 == true) goto L134;
        r43.k = com.bytedance.android.shopping.store.product.f.a(r47, r48, r49, r50, r51, r210, r118, r119, r120, r121, r122, r123, r124, null, null, null, null, 122880);
        goto L134
    L93:
        if (r78.isEmpty() == true) goto L96;
        r59 = false;
    L86:
        r59 = true;
        goto L87
    L136:
        if (r4.d != TabEnum.MOMENTS_TAB.getType()) goto L177;
        ECShopABSettings.k.getClass();
        if (ECShopABSettings.f() == false) goto L144;
        com.bytedance.android.shopping.store.home.entity.b r79 = ((com.bytedance.android.shopping.store.home.entity.a0) r37).y();
        if (r79 == null) goto L154;
        com.bytedance.android.shopping.store.home.entity.t r80 = r79.d();
        if (r80 == null) goto L154;
        ECStoreDynamicTabData r81 = r80.b();
    L155:
        if (r81 == null) goto L157;
        HybridListDTO r82 = r81.getHybridList();
    L158:
        if (r82 == null) goto L174;
        HybridListDTO r83 = r81.getHybridList();
        if (r83 == null) goto L162;
        List<SectionDTO> r84 = r83.getSections();
    L163:
        List<SectionDTO> r85 = r84;
        if (r85 != null) goto L166;
    L169:
        boolean r86 = true;
    L170:
        if (r86 == true) goto L174;
        if (r81.getCursor() <= 0) goto L174;
        ECStoreMomentResponse r87 = new ECStoreMomentResponse();
        r87.setHybridList(r81.getHybridList());
        r87.setCursor(r81.getCursor());
        r87.setHasMore(r81.getHasMore());
        r87.setLogExtra(r4.n);
        ?? r88 = r87;
    L175:
        int r89 = ECStoreMixFragment.o;
        Intrinsics.checkNotNullParameter(r11, "tabConfig");
        String r90 = com.bytedance.android.shopping.store.utils.m.b(r11);
        ECStoreMixFragment r91 = new ECStoreMixFragment();
        ?? r92 = new Bundle();
        r92.putString("store_tab_config_key", r90);
        r92.putSerializable("prefetch_data", r88);
        r92.putBoolean("auto_bind_module", false);
        r92.putInt("tab_id", r11.getTabType());
        Unit r93 = Unit.INSTANCE;
        r91.setArguments(r92);
        r36 = r91;
        goto L181
    L166:
        if (r85.isEmpty() == true) goto L169;
        r86 = false;
        goto L170
    L162:
        r84 = null;
    L174:
        r88 = 0;
        goto L175
    L157:
        r82 = null;
    L154:
        r81 = null;
        goto L155
    L144:
        String r94 = r37.b();
        if (r94 == null) goto L154;
        Object r95 = new Gson().fromJson(r94, com.bytedance.android.shopping.store.home.entity.b.class);     // Catch: Exception -> L148
    L149:
        com.bytedance.android.shopping.store.home.entity.b r96 = (com.bytedance.android.shopping.store.home.entity.b) r95;
        if (r96 == null) goto L154;
        com.bytedance.android.shopping.store.home.entity.t r97 = r96.d();
        if (r97 == null) goto L154;
        r81 = r97.b();
    L148:
        r95 = null;
        goto L149
    L177:
        if (r4.e() == false) goto L179;
        LinkedHashMap r98 = new LinkedHashMap();
        r98.put("pass_through_fe", r4.q);
        r98.put("top_search_info", GsonProtectorUtils.toJson(new Gson(), T().getTopSearchInfo().getValue()));
        r11.setExternalMetaInfo(r98);
        int r99 = ECStoreHybridTabFragment.n;
        Intrinsics.checkNotNullParameter(r11, "tabConfig");
        ECStoreHybridTabFragment r100 = new ECStoreHybridTabFragment();
        String r101 = com.bytedance.android.shopping.store.utils.m.b(r11);
        Bundle r102 = new Bundle();
        r102.putBoolean("auto_bind_module", false);
        r102.putString("store_tab_config_key", r101);
        r102.putInt("tab_id", r11.getTabType());
        Unit r103 = Unit.INSTANCE;
        r100.setArguments(r102);
        r36 = r100;
        goto L181
    L179:
        r36 = null;
        goto L181
    L15:
        if (r6 != r9.intValue()) goto L17;
        r10 = true;
    L11:
        r9 = null;
        goto L12
    L5:
        r3 = 0;
        goto L6
    }
}
