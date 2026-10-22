package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.base.api.ai.framework.model.PanelItem;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.ECShopShareHelper;
import com.bytedance.android.shopping.store.home.entity.MoreEntryInfo;
import com.bytedance.android.shopping.store.home.entity.ServiceEntryInfo;
import com.bytedance.android.shopping.store.home.entity.StoreUITheme;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.home.view.ECShopToolDialog;
import com.bytedance.android.shopping.store.live.event.ShopLiveState;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.ECImageHelper;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.store.viewmodel.ShopStatus;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopTopBarBackPresenterV2 extends ECShopBasePresenter implements View.OnClickListener {
    public static final /* synthetic */ int O = 0;
    public ViewGroup A;
    public ViewGroup B;
    public ViewGroup C;
    public View D;
    public View E;
    public SimpleDraweeView F;
    public SimpleDraweeView G;
    public SimpleDraweeView H;
    public final Pair<Integer, Integer> I;
    public com.bytedance.android.shopping.store.home.entity.f J;
    public ECShopToolDialog K;
    public boolean L;
    public final b M;
    public final c N;
    public final s83.e u;
    public com.bytedance.android.shopping.store.home.view.i v;
    public final Lazy w;
    public final Lazy x;
    public ImageView y;
    public SimpleDraweeView z;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public b(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (Intrinsics.areEqual(r2.optString("shop_id"), this.a.T().getStoreParam().getShopId()) == false) goto L6;
            this.a.Q();
            return;
        }
    }

    public static final class c implements ti.j {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public c(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (Intrinsics.areEqual(r2.optString("sec_shop_id"), this.a.T().getStoreParam().getSecShopId()) == true) goto L5;
            return;
        L5:
            if (this.a.t0().e() == false) goto L7;
            this.a.v0();
            return;
        L7:
            SimpleDraweeView r3 = this.a.z;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L11:
            if (r3.getVisibility() != 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L19;
            SimpleDraweeView r5 = this.a.z;
            if (r5 != null) goto L18;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L18:
            r5.performClick();
            return;
        L19:
            SimpleDraweeView r6 = this.a.H;
            if (r6 == null) goto L26;
            r6.performClick();
            return;
        L26:
            return;
        L13:
            r4 = false;
            goto L14
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public d(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r13) {
            com.bytedance.android.shopping.store.home.entity.n r14 = (com.bytedance.android.shopping.store.home.entity.n) r13;
            ECShopTopBarBackPresenterV2 r0 = this.a;
            Activity r1 = r0.X();
            Integer r2 = r0.T().getStoreParam().getStoreUITheme();
            int r3 = StoreUITheme.DefaultDark.ordinal();
            if (r2 != null) goto L6;
        L8:
            boolean r4 = true;
        L10:
            if (Intrinsics.areEqual((Boolean) r0.T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L12;
            r4 = false;
        L12:
            int r5 = com.bytedance.android.ec.core.utils.y1.a;
            com.bytedance.android.ec.core.utils.y1.c(r1, r1.getWindow(), r4);
            int r6 = com.bytedance.android.ec.core.utils.j.a;
            com.bytedance.android.ec.core.utils.j.a.a(r0.w().b(2131371141).f());
            r0.T().getTopBarHeight().c(Integer.valueOf(eh.b.b(r1) + r0.w().b(2131371157).f().getLayoutParams().height));
            if (r14.d() == false) goto L27;
            ImageView r15 = this.a.y;
            if (r15 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
        L17:
            r15.setVisibility(8);
            SimpleDraweeView r16 = this.a.z;
            if (r16 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L20:
            r16.setVisibility(8);
            SimpleDraweeView r17 = this.a.F;
            if (r17 == null) goto L23;
            r17.setVisibility(8);
        L23:
            SimpleDraweeView r18 = this.a.H;
            if (r18 == null) goto L26;
            r18.setVisibility(8);
        L26:
            this.a.w().b(2131371157).f().setVisibility(8);
            this.a.w().b(2131371158).f().setVisibility(0);
            return;
        L27:
            ECShopTopBarBackPresenterV2 r7 = this.a;
            com.bytedance.android.shopping.store.home.entity.g r8 = r14.e;
            SimpleDraweeView r9 = r7.G;
            if (r9 != null) goto L31;
        L40:
            ECShopTopBarBackPresenterV2 r10 = this.a;
            com.bytedance.android.shopping.store.home.entity.j r11 = r14.i;
            if (r10.t0().e() == false) goto L48;
            SimpleDraweeView r12 = r10.z;
            if (r12 != null) goto L45;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L45:
            r12.setVisibility(8);
            SimpleDraweeView r19 = r10.H;
            if (r19 == null) goto L69;
            r19.setVisibility(8);
        L69:
            if (r14.c() == false) goto L78;
            SimpleDraweeView r110 = this.a.F;
            if (r110 == null) goto L73;
            r110.setVisibility(8);
        L73:
            ViewGroup r111 = this.a.A;
            if (r111 == null) goto L79;
            r111.setVisibility(8);
            return;
        L79:
            return;
        L78:
            return;
        L48:
            if (r11 == null) goto L69;
            SimpleDraweeView r20 = r10.z;
            if (r20 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
        L53:
            r20.setVisibility(8);
            SimpleDraweeView r21 = r10.H;
            if (r21 == null) goto L69;
            com.bytedance.android.ec.sdk.helper.q r22 = com.bytedance.android.ec.sdk.helper.q.a;
            long r23 = com.bytedance.android.ec.sdk.helper.q.f("share_btn_animation_count");
            if (r23 >= 3) goto L58;
            Lazy r24 = ECImageHelper.a;
            ECImageHelper.a(r21, r11.a);
            com.bytedance.android.ec.sdk.helper.q.h("share_btn_animation_count", r23 + 1);
        L65:
            r21.setVisibility(0);
            r10.T().doEventAction("show_share_entrance", new Pair[]{TuplesKt.to("click_area", "top_bar")});
            if (r10.U() == true) goto L69;
            r10.x0(r21, r11);
            goto L69
        L58:
            Integer r25 = r11.e;
            if (r25 != null) goto L62;
        L64:
            r21.setActualImageResource(2131234718);
            goto L65
        L62:
            if (r25.intValue() != 1) goto L64;
            r21.setActualImageResource(2131248083);
            goto L65
        L31:
            if (r7.t0().e() == false) goto L33;
            r9.setVisibility(8);
            goto L40
        L33:
            if (r8 == null) goto L40;
            if (r8.h == null) goto L40;
            if (r7.T().needShowServiceEntryInNavigationBar() == false) goto L39;
            r9.setVisibility(0);
            goto L40
        L39:
            r9.setVisibility(8);
            goto L40
        L6:
            if (r2.intValue() != r3) goto L8;
            r4 = false;
            goto L10
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public e(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Float r3 = (Float) r2;
            float r0 = 1.0f - this.a.a0(0.5f);
            ECShopTopBarBackPresenterV2.y0(this.a, r0);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public f(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (((ShopLiveState) r2).a != ShopLiveState.PlayState.ERROR) goto L6;
            ECShopTopBarBackPresenterV2.y0(this.a, 0.0f);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public g(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            if (((Boolean) r5).booleanValue() == false) goto L36;
            ECShopTopBarBackPresenterV2 r6 = this.a;
            if (r6.t0().e() == true) goto L41;
            SimpleDraweeView r0 = r6.F;
            if (r0 == null) goto L42;
            r0.setVisibility(0);
            ViewGroup r1 = r6.A;
            if (r1 == null) goto L13;
            r1.setVisibility(4);
        L13:
            com.bytedance.android.shopping.store.home.entity.n r2 = (com.bytedance.android.shopping.store.home.entity.n) r6.T().getHeaderArea().getValue();
            if (r2 == null) goto L37;
            com.bytedance.android.shopping.store.home.entity.g r3 = r2.e;
            if (r3 == null) goto L38;
            MoreEntryInfo r4 = r3.q;
            if (r4 == null) goto L39;
            ShopStatus r7 = (ShopStatus) r6.T().getShopStatus().getValue();
            if (r7 != null) goto L23;
            r7 = ShopStatus.NORMAL;
        L23:
            if (r7 != ShopStatus.PREVIEW_EXPANDED) goto L28;
            if (r4.getImmerceIcon() == null) goto L28;
            Lazy r8 = ECImageHelper.a;
            SimpleDraweeView r9 = r6.F;
            Intrinsics.checkNotNull(r9);
            ECImageHelper.a(r9, r4.getImmerceIcon());
        L32:
            SimpleDraweeView r10 = r6.F;
            if (r10 == null) goto L40;
            r10.postDelayed(new o2(r6), 2700);
            return;
        L40:
            return;
        L28:
            if (r7.getValue() > ShopStatus.PREVIEW_COLLAPSE.getValue()) goto L32;
            if (r4.getNormalIcon() == null) goto L32;
            Lazy r11 = ECImageHelper.a;
            SimpleDraweeView r12 = r6.F;
            Intrinsics.checkNotNull(r12);
            ECImageHelper.a(r12, r4.getNormalIcon());
            goto L32
        L39:
            return;
        L38:
            return;
        L37:
            return;
        L42:
            return;
        L41:
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

        public h(ECShopTopBarBackPresenterV2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r4v7, types: [android.app.Dialog, com.bytedance.android.shopping.store.home.view.ECShopToolDialog, java.lang.Object] */
        public final void onChanged(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L27;
            BottomSheetDialog r5 = this.a.K;
            if (r5 != null) goto L7;
            return;
        L7:
            if (r5.isShowing() != true) goto L32;
            ?? r6 = this.a.K;
            if (r6 == 0) goto L33;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L13;
        L15:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
        L24:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L20:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
            if (r1 == null) goto L24;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L13:
            if (Looper.myLooper() == r0.getLooper()) goto L15;
            r0.post(DialogLancet.createDismissRunnable(r6));
            return;
        L33:
            return;
        L32:
            return;
        }
    }

    static {
    }

    public final zi3.c t0() {
        return (zi3.c) this.w.getValue();
    }

    public final com.bytedance.android.shopping.store.home.view.l u0() {
        return (com.bytedance.android.shopping.store.home.view.l) this.x.getValue();
    }

    public final void C() {
        View r0 = this.D;
        if (r0 == null) goto L7;
        ViewGroup r1 = this.B;
        if (r1 == null) goto L7;
        r1.removeView(r0);
    L7:
        View r2 = this.E;
        if (r2 == null) goto L12;
        ViewGroup r3 = this.C;
        if (r3 == null) goto L12;
        r3.removeView(r2);
    L12:
        this.D = null;
        this.E = null;
        if (T().getStoreParam().getInterceptBackProcessType() == null) goto L16;
        ECLiveHybridUtil.p("ecom.shop.close_shop", this.M);
        ECLiveHybridUtil.p("ecom.shop.open_toolbar", this.N);
        return;
    }

    public final void v0() {
        if (V() == true) goto L5;
        return;
    L5:
        if (T().getStoreParam().isPreview() == true) goto L125;
        Boolean r2 = null;
        String r3 = null;
        r3 = null;
        if (t0().e() == false) goto L25;
        T().doEventAction("click_menu", new Pair[0]);
        zi3.c r1 = t0();
        Context r4 = X();
        ArrayList r5 = new ArrayList();
        if (u0().e() == false) goto L17;
        String r9 = s0(ToolType.CUSTOM_SERVICE);
        int r10 = r5.size() + 1;
        ECUrlModel r6 = u0().f();
        if (r6 == null) goto L16;
        List r7 = r6.getUrlList();
        if (r7 == null) goto L16;
        r3 = (String) CollectionsKt.firstOrNull(r7);
    L16:
        String r12 = r3;
        Function1<View, Unit> r8 = new ECShopTopBarBackPresenterV2$buildAppletPanelItems$1(this);
        PanelItem r11 = new PanelItem("shop_custom_service", r9, r10, "customer_service", r12, 1);
        r11.setOnClickListener(new n2(r8));
        r5.add(r11);
    L17:
        Lazy r13 = ECAppInfoService.a;
        if (ECAppInfoService.l() == true) goto L21;
        String r14 = s0(ToolType.ORDER);
        int r15 = r5.size() + 1;
        Function1<View, Unit> r16 = new ECShopTopBarBackPresenterV2$buildAppletPanelItems$2(this);
        PanelItem r17 = new PanelItem("order_list", r14, r15, null, null, 1);
        r17.setOnClickListener(new n2(r16));
        r5.add(r17);
    L21:
        if (u0().d() == false) goto L23;
        String r18 = s0(ToolType.CART);
        int r19 = r5.size() + 1;
        Function1<View, Unit> r20 = new ECShopTopBarBackPresenterV2$buildAppletPanelItems$3(this);
        PanelItem r21 = new PanelItem("cart", r18, r19, null, null, 1);
        r21.setOnClickListener(new n2(r20));
        r5.add(r21);
    L23:
        r1.a(r4, r5);
        return;
    L25:
        if (ECShopABSettings.a() > 0) goto L27;
        com.bytedance.android.shopping.store.home.view.i r22 = this.v;
        if (r22 == null) goto L42;
        if (r22.isShowing() != true) goto L42;
        return;
    L42:
        if (this.v != null) goto L80;
        Fragment r23 = this.h;
        if (r23 == null) goto L124;
        View r24 = r23.getView();
        if (r24 == null) goto L128;
        com.bytedance.android.shopping.store.home.view.i r110 = new com.bytedance.android.shopping.store.home.view.i(X(), r24);
        ECStoreViewModel r25 = T();
        Intrinsics.checkNotNullParameter(r25, "viewModel");
        r110.a = r25;
        r110.b = new com.bytedance.android.shopping.store.home.view.l(r110.d, r110.e, r25);
        r110.setOutsideTouchable(true);
        r110.setFocusable(true);
        r110.setBackgroundDrawable(new ColorDrawable());
        Context r26 = th.a.e(r110.d, true);
        r110.c = r26.getResources().getDimensionPixelSize(2131166445);
        int r111 = r26.getResources().getDimensionPixelSize(2131166447);
        r110.setWidth((r110.c * 2) + r111);
        r110.setHeight(-2);
        View r27 = th.a.d(r26, 2131560951, null, 4);
        LinearLayout r112 = (LinearLayout) r27.findViewById(2131371112);
        r112.setShowDividers(2);
        r112.setDividerDrawable(new com.bytedance.android.shopping.store.home.view.j(r111));
        SimpleDraweeView r113 = r27.findViewById(2131371115);
        com.bytedance.android.shopping.store.home.view.l r114 = r110.b;
        if (r114 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L51:
        ECUrlModel r115 = r114.f();
        if (r115 == null) goto L54;
        com.bytedance.android.ec.core.imagex.h0.d(r113, r115, null, null, null, null, null, 120);
    L55:
        View r116 = r27.findViewById(2131371114);
        com.bytedance.android.shopping.store.home.view.l r117 = r110.b;
        if (r117 != null) goto L59;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L59:
        if (r117.e() == false) goto L61;
        r116.setVisibility(0);
        r116.setOnClickListener(r110);
    L62:
        View r118 = r27.findViewById(2131371117);
        Lazy r119 = ECAppInfoService.a;
        if (ECAppInfoService.l() == false) goto L65;
        r118.setVisibility(8);
    L66:
        r27.findViewById(2131371116).setVisibility(8);
        View r120 = r27.findViewById(2131371113);
        com.bytedance.android.shopping.store.home.view.l r121 = r110.b;
        if (r121 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("actionHelper");
    L70:
        if (r121.d() == false) goto L72;
        r120.setVisibility(0);
        r120.setOnClickListener(r110);
    L73:
        View r122 = r27.findViewById(2131371119);
        r122.setVisibility(0);
        r122.setOnClickListener(r110);
        boolean r123 = ECServiceManager.a;
        s83.e r124 = ((s83.g) ECServiceManager.c(s83.g.class)).W();
        if (r124 == null) goto L77;
        r2 = Boolean.valueOf(r124.e());
    L77:
        if (com.bytedance.android.shopping.extensions.k.i(r2) == true) goto L79;
        r27.findViewById(2131371119).setVisibility(8);
    L79:
        Unit r28 = Unit.INSTANCE;
        r110.setContentView(r27);
        this.v = r110;
        goto L80
    L72:
        r120.setVisibility(8);
        goto L73
    L65:
        r118.setVisibility(0);
        r118.setOnClickListener(r110);
        goto L66
    L61:
        r116.setVisibility(8);
        goto L62
    L54:
        r113.setBackgroundResource(2131234689);
        goto L55
    L128:
        return;
    L124:
        return;
    L80:
        com.bytedance.android.shopping.store.home.view.i r29 = this.v;
        if (r29 == null) goto L116;
        View r30 = w().b(2131371161).f();
        Intrinsics.checkNotNullParameter(r30, "anchor");
        int r125 = r29.c;
        OverlaySource r126 = PopupWindowLancet.resolveSource(r30);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(r29, r30, r126) == true) goto L86;
        r29.showAsDropDown(r30, r125, 0, 8388613);
        PopupWindowLancet.trackAfterShow(r29, r126, r30);
    L86:
        View r31 = r29.getContentView();
        View r127 = r31.findViewById(2131371114);
        if (r127 != null) goto L89;
    L94:
        View r32 = r31.findViewById(2131371117);
        if (r32 != null) goto L97;
    L102:
        View r33 = r31.findViewById(2131371113);
        if (r33 == null) goto L111;
        if (r33.getVisibility() != 0) goto L111;
        ECStoreViewModel r34 = r29.a;
        if (r34 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L109:
        r34.doEventAction("show_cart_entrance", new Pair[]{TuplesKt.to("click_area", "menu")});
    L111:
        if (r31.findViewById(2131371119).getVisibility() != 0) goto L116;
        ECStoreViewModel r35 = r29.a;
        if (r35 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L115:
        r35.doEventAction("show_share_entrance", new Pair[]{TuplesKt.to("click_area", "menu")});
        goto L116
    L97:
        if (r32.getVisibility() != 0) goto L102;
        ECStoreViewModel r36 = r29.a;
        if (r36 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L101:
        r36.doEventAction("show_order_entrance", new Pair[]{TuplesKt.to("click_area", "menu")});
        goto L102
    L89:
        if (r127.getVisibility() != 0) goto L94;
        ECStoreViewModel r128 = r29.a;
        if (r128 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L93:
        r128.doEventAction("show_consultation", new Pair[]{TuplesKt.to("click_area", "menu")});
    L116:
        T().doEventAction("click_menu", new Pair[0]);
        return;
    L27:
        if (this.L == true) goto L126;
        T().doEventAction("click_menu", new Pair[0]);
        this.L = true;
        int r37 = com.bytedance.android.shopping.store.utils.i.a;
        Observable r38 = com.bytedance.android.shopping.store.utils.i.a(T().getStoreParam().getSecShopId(), (String) T().getStoreParam().getPassThroughParam("pass_through_api"));
        if (r38 == null) goto L120;
        Observable r39 = bg4.b.b(r38);
        if (r39 == null) goto L121;
        Disposable r40 = r39.subscribe(new l2(this));
        if (r40 == null) goto L122;
        com.bytedance.android.ec.core.async.a.a(r40, T());
        return;
    L122:
        return;
    L121:
        return;
    L120:
        return;
    L126:
        return;
    }

    public final void w0() {
        if (T().getStoreParam().isSplitMode() == false) goto L6;
        Lazy r0 = ECStoreFoldPhoneHelper.a;
        ECStoreFoldPhoneHelper.a(this.h);
        return;
    L6:
        if (T().interceptBackPressed(u().c(), true) == true) goto L10;
        Q();
        return;
    }

    public ECShopTopBarBackPresenterV2(Fragment r3) {
        super(r3);
        boolean r4 = ECServiceManager.a;
        s83.g r5 = (s83.g) ECServiceManager.c(s83.g.class);
        if (r5 == null) goto L5;
        s83.e r6 = r5.W();
    L6:
        this.u = r6;
        LazyThreadSafetyMode r7 = LazyThreadSafetyMode.NONE;
        this.w = LazyKt.lazy(r7, ECShopTopBarBackPresenterV2$buttonProvider$2.INSTANCE);
        this.x = LazyKt.lazy(r7, new ECShopTopBarBackPresenterV2$popupMenuActionHelper$2(this));
        this.I = new Pair(-15329245, -1);
        this.M = new b(this);
        this.N = new c(this);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public static final void q0(ECShopTopBarBackPresenterV2 r11) {
        View r0 = r11.y().findViewById(2131371063);
        LinearLayout r1 = (LinearLayout) r11.y().findViewById(2131371125);
        com.bytedance.android.ec.core.utils.d2.d(r1, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        uj3.j r4 = r11.T().getCurrentHomeTab();
        if (r4 != null) goto L5;
    L20:
        Float r5 = (Float) r11.T().getUpglideFactor().getValue();
        if (r5 == null) goto L23;
        float r6 = r5.floatValue();
    L24:
        float r8 = 1;
        float r10 = RangesKt.coerceAtLeast(r8 - (3 * r6), 0.0f);
        float r2 = RangesKt.coerceAtLeast(r8 - (r6 * 8), 0.0f);
        ViewGroup r7 = r11.A;
        if (r7 == null) goto L27;
        r7.setAlpha(r2);
    L27:
        ViewGroup r3 = r11.A;
        if (r3 == null) goto L30;
        wg.a.i(r3, (int) (com.bytedance.android.shopping.extensions.b.b(24) * r10));
    L30:
        if (r0 == null) goto L32;
        com.bytedance.android.ec.core.utils.d2.d(r0, (int) (com.bytedance.android.shopping.extensions.b.b(8) * r10), 0, 0, 0);
    L32:
        ViewGroup r12 = r11.A;
        if (r12 == null) goto L35;
        com.bytedance.android.ec.core.utils.d2.d(r12, 0, 0, 0, 0);
    L35:
        com.bytedance.android.ec.core.utils.d2.d(r1, com.bytedance.android.shopping.extensions.b.b(8), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
        return;
    L23:
        r6 = 0.0f;
        goto L24
    L5:
        if (r4.f() != true) goto L20;
        if (r11.T().isMiddleTabFramework() == true) goto L20;
        ViewGroup r9 = r11.A;
        if (r9 == null) goto L11;
        com.bytedance.android.ec.core.utils.d2.d(r9, com.bytedance.android.shopping.extensions.b.b(8), 0, 0, 0);
    L11:
        ViewGroup r13 = r11.A;
        if (r13 == null) goto L14;
        r13.setAlpha(1.0f);
    L14:
        ViewGroup r14 = r11.A;
        if (r14 == null) goto L17;
        wg.a.i(r14, com.bytedance.android.shopping.extensions.b.b(24));
    L17:
        if (r0 == null) goto L19;
        com.bytedance.android.ec.core.utils.d2.d(r0, com.bytedance.android.shopping.extensions.b.b(8), 0, 0, 0);
    L19:
        com.bytedance.android.ec.core.utils.d2.d(r1, com.bytedance.android.shopping.extensions.b.b(12), 0, com.bytedance.android.shopping.extensions.b.b(12), 0);
    }

    public final void A(QModel r13) {
        boolean r14 = U();
        View r0 = y();
        if (r14 == false) goto L5;
        float r1 = 0.0f;
    L6:
        r0.setAlpha(r1);
        View r2 = y();
        if (r14 == false) goto L9;
        int r3 = 4;
    L10:
        r2.setVisibility(r3);
        ImageView r4 = (ImageView) w().b(2131371155).f();
        if (r14 == false) goto L13;
        int r15 = 2131248082;
    L14:
        r4.setImageResource(r15);
        Unit r16 = Unit.INSTANCE;
        this.y = r4;
        this.A = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371179));
        this.B = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371036));
        this.C = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371037));
        this.G = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371168));
        this.H = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371169));
        this.z = w().b(2131371161).f();
        this.F = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371170));
        ImageView r17 = this.y;
        if (r17 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L17:
        r17.setOnClickListener(this);
        SimpleDraweeView r18 = this.z;
        if (r18 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L20:
        r18.setOnClickListener(this);
        SimpleDraweeView r19 = this.F;
        if (r19 == null) goto L23;
        r19.setOnClickListener(this);
    L23:
        SimpleDraweeView r110 = this.H;
        if (r110 == null) goto L26;
        r110.setOnClickListener(this);
    L26:
        SimpleDraweeView r111 = this.G;
        if (r111 == null) goto L29;
        r111.setOnClickListener(this);
    L29:
        Lazy r112 = ECAppInfoService.a;
        if (we.a.a == false) goto L38;
        ImageView r113 = this.y;
        if (r113 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L34:
        r113.setImageResource(2131248536);
        SimpleDraweeView r114 = this.z;
        if (r114 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L37:
        r114.setActualImageResource(2131248537);
    L43:
        if (T().getStoreParam().isSplitMode() == true) goto L45;
        com.bytedance.android.shopping.extensions.f.d((LinearLayout) y().findViewById(2131371125), com.bytedance.android.shopping.extensions.b.b(8), 2);
    L56:
        if (t0().e() == false) goto L110;
        boolean r115 = t0().c();
        if (r115 == true) goto L66;
        ImageView r5 = this.y;
        if (r5 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L63:
        r5.setVisibility(8);
        ViewGroup r6 = this.B;
        if (r6 == null) goto L74;
        r6.setVisibility(8);
    L74:
        View r7 = t0().b(X(), new ECShopTopBarBackPresenterV2$setupTopBarControls$3(this), ECShopTopBarBackPresenterV2$setupTopBarControls$4.INSTANCE);
        this.E = r7;
        if (r7 == null) goto L110;
        SimpleDraweeView r8 = this.z;
        if (r8 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L79:
        r8.setVisibility(8);
        SimpleDraweeView r9 = this.H;
        if (r9 == null) goto L82;
        r9.setVisibility(8);
    L82:
        SimpleDraweeView r10 = this.G;
        if (r10 == null) goto L85;
        r10.setVisibility(8);
    L85:
        SimpleDraweeView r11 = this.F;
        if (r11 == null) goto L88;
        r11.setVisibility(8);
    L88:
        ViewGroup r12 = this.A;
        if (r12 == null) goto L91;
        r12.setVisibility(8);
    L91:
        View r20 = y().findViewById(2131371125);
        if (r20 == null) goto L101;
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        if ((r21 instanceof RelativeLayout.LayoutParams) == true) goto L96;
        r21 = null;
    L96:
        RelativeLayout.LayoutParams r22 = (RelativeLayout.LayoutParams) r21;
        if (r22 == null) goto L100;
        r22.rightMargin = 0;
        r22.setMarginEnd(0);
        r22.removeRule(21);
        r22.removeRule(0);
        r22.removeRule(1);
        r22.removeRule(16);
        r22.removeRule(17);
        r22.addRule(16, 2131371037);
        r20.setLayoutParams(r22);
    L100:
        r20.setVisibility(0);
    L101:
        ViewGroup r23 = this.C;
        if (r23 == null) goto L104;
        r23.addView(r7);
        r23.setVisibility(0);
    L104:
        View r24 = y().findViewById(2131371165);
        r24.post(new p2(r24, this));
        View r25 = y().findViewById(2131371148);
        if (r25 == null) goto L107;
        r25.post(new q2(r25, this, r115));
    L107:
        View r26 = y().findViewById(2131371160);
        if (r26 == null) goto L110;
        r26.post(new r2(r26, this, r115));
        goto L110
    L66:
        View r27 = t0().d(X(), new ECShopTopBarBackPresenterV2$setupTopBarControls$1(this));
        this.D = r27;
        if (r27 == null) goto L74;
        ImageView r28 = this.y;
        if (r28 != null) goto L71;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L71:
        r28.setVisibility(4);
        ViewGroup r29 = this.B;
        if (r29 == null) goto L74;
        r29.addView(r27);
        r29.setVisibility(0);
    L110:
        T().getHeaderArea().a(W(), new d(this), false);
        T().getCollapseFactor().a(W(), new e(this), false);
        if (T().getStoreParam().getInterceptBackProcessType() == null) goto L113;
        ECLiveHybridUtil.m("ecom.shop.close_shop", this.M);
        ECLiveHybridUtil.m("ecom.shop.open_toolbar", this.N);
    L113:
        T().getLiveState().a(W(), new f(this), false);
        T().getShowCouponAnimEvent().a(W(), new g(this), false);
        T().getHideToolDialogEvent().a(W(), new h(this), false);
        Lazy r116 = ECTaskManager.b;
        ECTaskManager.a.a().a(T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopTopBarBackPresenterV2$onBind$8(this));
        return;
    L45:
        if (T().getStoreParam().isTopSplit() == false) goto L50;
        ImageView r117 = this.y;
        if (r117 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L49:
        r117.setVisibility(4);
    L50:
        View r118 = y().findViewById(2131371158);
        ViewGroup.LayoutParams r30 = r118.getLayoutParams();
        r30.height = com.bytedance.android.shopping.extensions.b.b(52);
        r118.requestLayout();
        View r119 = y().findViewById(2131371157);
        ViewGroup.LayoutParams r31 = r119.getLayoutParams();
        r31.height = com.bytedance.android.shopping.extensions.b.b(52);
        r119.requestLayout();
        com.bytedance.android.ec.core.utils.d2.d(y().findViewById(2131371155), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(2), com.bytedance.android.shopping.extensions.b.b(8));
        ViewGroup r120 = this.A;
        if (r120 == null) goto L53;
        com.bytedance.android.ec.core.utils.d2.d(r120, 0, 0, 0, 0);
    L53:
        com.bytedance.android.shopping.extensions.f.d((LinearLayout) y().findViewById(2131371125), com.bytedance.android.shopping.extensions.b.b(0), 2);
        T().getUpglideFactor().a(W(), new j2(this), false);
        T().getCurrentTabLiveData().a(W(), new k2(this), false);
        goto L56
    L38:
        SimpleDraweeView r121 = this.z;
        if (r121 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L41:
        r121.setActualImageResource(2131248083);
        goto L43
    L13:
        r15 = 2131248081;
        goto L14
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = 1.0f;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r0 = kn.a.a;
        if (kn.a.a(r3.getId()) == false) goto L5;
        return;
    L5:
        if (V() == true) goto L8;
        return;
    L8:
        if (r3.getId() != 2131371155) goto L11;
        w0();
    L11:
        if (T().getStoreParam().isPreview() == false) goto L13;
        return;
    L13:
        int r4 = r3.getId();
        if (r4 != 2131371161) goto L16;
        v0();
        return;
    L16:
        String r1 = null;
        if (r4 != 2131371168) goto L27;
        com.bytedance.android.shopping.store.home.entity.n r5 = (com.bytedance.android.shopping.store.home.entity.n) T().getHeaderArea().getValue();
        if (r5 == null) goto L25;
        com.bytedance.android.shopping.store.home.entity.g r6 = r5.e;
        if (r6 == null) goto L25;
        ServiceEntryInfo r7 = r6.h;
        if (r7 == null) goto L25;
        r1 = r7.getSchema();
    L25:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(X(), r1);
        return;
    L27:
        if (r4 != 2131371169) goto L35;
        ECShopShareHelper r8 = T().getShareHelper();
        if (r8 == null) goto L36;
        int r2 = com.bytedance.android.shopping.store.home.d.f;
        r8.f(null);
        return;
    L36:
        return;
    }

    public final void r0(ToolType r5) {
        if (ECShopABSettings.a() != 0) goto L5;
        return;
    L5:
        T().doEventAction("shop_tools_panel_entrance_click", "a1.b6269.c25145.d289907", PageFinder.via(y()), new Pair[]{TuplesKt.to("entry_name", com.bytedance.android.shopping.store.home.view.f.a(r5))});
    }

    public final String s0(ToolType r3) {
        int r4 = i2.a[r3.ordinal()];
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L23;
        if (r4 == 3) goto L22;
        if (r4 == 4) goto L21;
        if (r4 == 5) goto L20;
        return "";
    L20:
        return th.a.e(u().c(), true).getString(2131896741);
    L21:
        return th.a.e(u().c(), true).getString(2131895892);
    L22:
        return th.a.e(u().c(), true).getString(2131896848);
    L23:
        return th.a.e(u().c(), true).getString(2131896842);
    L18:
        return th.a.e(u().c(), true).getString(2131896863);
    }

    public static void y0(ECShopTopBarBackPresenterV2 r4, float r5) {
        r4.getClass();
        float r1 = 1.0f - r5;
        int r2 = com.bytedance.android.ec.core.utils.s.a;
        com.bytedance.android.shopping.store.home.entity.n r3 = (com.bytedance.android.shopping.store.home.entity.n) r4.T().getHeaderArea().getValue();
        if (r3 == null) goto L7;
        com.bytedance.android.shopping.store.home.entity.p r6 = r3.h;
        if (r6 == null) goto L7;
        String r7 = r6.g();
    L8:
        Integer r8 = com.bytedance.android.ec.core.utils.s.b(r7);
        if (r8 != null) goto L11;
    L13:
        int r9 = ((Number) r4.I.getFirst()).intValue();
    L14:
        int r10 = ColorUtils.blendARGB(r9, ((Number) r4.I.getSecond()).intValue(), r5);
        if (r4.t0().e() == true) goto L26;
        ImageView r11 = r4.y;
        if (r11 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L19:
        r11.setColorFilter(r10);
        SimpleDraweeView r12 = r4.z;
        if (r12 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("moreBtn");
    L22:
        r12.setColorFilter(r10);
        SimpleDraweeView r13 = r4.H;
        if (r13 == null) goto L26;
        r13.setColorFilter(r10);
    L26:
        if (r4.U() == true) goto L28;
        r4.w().b(2131371157).f().setAlpha(1.0f);
        return;
    L28:
        r4.y().setVisibility(0);
        r4.y().setAlpha(r1);
        if (r1 <= 0.5f) goto L43;
        SimpleDraweeView r14 = r4.H;
        if (r14 != null) goto L33;
        return;
    L33:
        if (r14.getVisibility() != 0) goto L45;
        com.bytedance.android.shopping.store.home.entity.n r15 = (com.bytedance.android.shopping.store.home.entity.n) r4.T().getHeaderArea().getValue();
        if (r15 == null) goto L46;
        com.bytedance.android.shopping.store.home.entity.j r16 = r15.i;
        if (r16 == null) goto L47;
        SimpleDraweeView r0 = r4.H;
        if (r0 == null) goto L48;
        r4.x0(r0, r16);
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L43:
        return;
    L11:
        if (r4.K() == false) goto L13;
        r9 = r8.intValue();
    L7:
        r7 = null;
        goto L8
    }

    public final void x0(final View r6, final com.bytedance.android.shopping.store.home.entity.j r7) {
        Lazy r0 = ECTaskManager.b;
        ECTaskManager.a.a().a(T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopTopBarBackPresenterV2$tryShowShareGuideBubble$1(this, r6, r7));
    }
}
