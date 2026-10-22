package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.common.api.abilities.IShoppingAbilities;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.sku.CartNumWithBusinessLine;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.store.api.IECStoreService;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.anchorv3.utils.d0;
import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.bottom.AppointmentMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonMeta;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottom.BuyMeta;
import com.bytedance.android.shopping.anchorv4.bottom.DepositPreSaleAppointmentComponent;
import com.bytedance.android.shopping.anchorv4.bottom.EnterCartMeta;
import com.bytedance.android.shopping.anchorv4.bottom.EnterShopMeta;
import com.bytedance.android.shopping.anchorv4.bottom.IMMeta;
import com.bytedance.android.shopping.anchorv4.bottom.SkuComponentComponentV2;
import com.bytedance.android.shopping.anchorv4.bottom.SkuMeta;
import com.bytedance.android.shopping.anchorv4.bottom.j0;
import com.bytedance.android.shopping.anchorv4.bottom.k0;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.BasePdpAddCartAnimation;
import com.bytedance.android.shopping.anchorv4.helper.PdpAddCartAnimationV2;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.business.pdp.view.BottomButtonView;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.verify.AuthUtils;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.internal.LinkedTreeMap;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomButtonComponent implements com.bytedance.android.shopping.anchorv4.voavhs.base.design.a, nl.d, com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.vm.h {
    public BottomButtonVO a;
    public boolean b;
    public com.bytedance.android.shopping.anchorv4.bottom.widget.b c;
    public com.bytedance.android.shopping.anchorv4.bottom.b d;
    public boolean e;
    public final d f;
    public final FragmentManager g;
    public final BottomButtonView h;

    public final int M0() {
        return 0;
    }

    public final void S2(float r1) {
    }

    public final void a2(boolean r1) {
    }

    public final void b2(boolean r1) {
    }

    public final void onVisible() {
    }

    public final View t() {
        return null;
    }

    public final void onScan() {
        BottomButtonView r0 = this.h;
        if (r0 == null) goto L6;
        ExtensionsKt.b(r0, this);
        return;
    }

    public final void a(String r3) {
        if (r3 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L10;
        return;
    L10:
        this.f.R();
        IAction r4 = com.bytedance.android.shopping.anchorv4.helper.z.a(r3);
        BottomButtonView r1 = this.h;
        if (r1 == null) goto L14;
        this.f.m(r4, r1);
        return;
    L14:
        return;
    L4:
        if (r3.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void addShopCartSuccessEvent(hl.b r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.e == false) goto L5;
        return;
    L5:
        if (r9.o == true) goto L80;
        Integer r0 = r9.c;
        if (r0 != null) goto L11;
    L12:
        Integer r1 = r9.c;
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.intValue() == 102) goto L18;
        return;
    L18:
        BottomButtonVO r2 = this.a;
        if (r2 == null) goto L23;
        BottomButtonMeta r3 = r2.getBottomButtonMetaValue();
        if (r3 == null) goto L23;
        AddCartMeta r4 = r3.getAddCartMeta();
    L24:
        String r5 = r9.b;
        if (r5 != null) goto L29;
        if (r4 == null) goto L28;
        r5 = r4.getAddCartCover();
        goto L29
    L28:
        r5 = null;
    L29:
        if (r4 == null) goto L31;
        int r6 = r4.getAddCartAnimationStyle();
    L32:
        int r7 = r9.a;
        List r8 = r9.e;
        if (r8 == null) goto L52;
        Iterator r10 = r8.iterator();
    L36:
        if (r10.hasNext() == false) goto L52;
        CartNumWithBusinessLine r11 = (CartNumWithBusinessLine) r10.next();
        Integer r12 = r11.getCartBusinessLineId();
        if (r12 == null) goto L36;
        int r13 = r12.intValue();
        if (r13 <= 0) goto L36;
        BottomButtonVO r14 = this.a;
        if (r14 == null) goto L36;
        BottomButtonMeta r15 = r14.getBottomButtonMetaValue();
        if (r15 == null) goto L36;
        AddCartMeta r16 = r15.getAddCartMeta();
        if (r16 == null) goto L36;
        if (r13 != r16.getCartBusinessLineId()) goto L36;
        Integer r17 = r11.getNum();
        if (r17 == null) goto L36;
        r7 = r17.intValue();
    L52:
        if (r6 == 0) goto L56;
        if (r5 == null) goto L56;
        c(r5, r7, null);
    L59:
        a(r9.m);
        return;
    L56:
        BottomButtonView r18 = this.h;
        if (r18 == null) goto L59;
        r18.h(r7);
        goto L59
    L31:
        r6 = 0;
    L23:
        r4 = null;
        goto L24
    L11:
        if (r0.intValue() == 101) goto L18;
    }

    public final void f(String r5) {
        CommonMeta r0 = this.f.a();
        String r1 = null;
        if (r0 == null) goto L8;
        ECAdLogExtra r2 = r0.getAdLogExtra();
        if (r2 == null) goto L8;
        String r3 = r2.getCreativeId();
        if (r3 == null) goto L8;
    L16:
        if (r3 != null) goto L18;
        return;
    L18:
        CommonMeta r4 = this.f.a();
        if (r4 == null) goto L21;
        Map r6 = h73.a.a(r4);
    L22:
        CommonMeta r7 = this.f.a();
        if (r7 == null) goto L30;
        String r8 = r7.getEntranceInfo();
        if (r8 == null) goto L30;
        JSONObject r9 = com.bytedance.android.shopping.extensions.k.w(r8);
        if (r9 == null) goto L30;
        r1 = r9.optString("log_extra");
    L30:
        switch(r5.hashCode()) {
            case -818891737: goto L44;
            case -818408451: goto L41;
            case 97926: goto L36;
            case 164161734: goto L33;
            default: goto L54;
        };
    L54:
        return;
    L33:
        if (r5.equals("add_to_cart") == false) goto L47;
        AdLogUtils.b(r3, r6, r1);
        return;
    L47:
        return;
    L36:
        if (r5.equals("buy") == false) goto L49;
        if (r6 == null) goto L39;
        r6.put("position", 0);
    L39:
        AdLogUtils.e(r3, r6, r1);
        return;
    L49:
        return;
    L41:
        if (r5.equals("enter_shop") == false) goto L51;
        AdLogUtils.d(r3, r6, r1);
        return;
    L51:
        return;
    L44:
        if (r5.equals("enter_cart") == false) goto L53;
        AdLogUtils.f(r3, r6, r1);
        return;
    L53:
        return;
    L21:
        r6 = null;
    L8:
        CommonMeta r10 = this.f.a();
        if (r10 == null) goto L15;
        String r11 = r10.getEntranceInfo();
        if (r11 == null) goto L15;
        JSONObject r12 = com.bytedance.android.shopping.extensions.k.w(r11);
        if (r12 == null) goto L15;
        r3 = r12.optString("creative_id");
    L15:
        r3 = null;
        goto L16
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(final Action r6) {
        BottomButtonVO r0 = this.a;
        if (r0 == null) goto L9;
        BottomButtonMeta r1 = r0.getBottomButtonMetaValue();
        if (r1 == null) goto L9;
        BuyMeta r2 = r1.getBuyMeta();
        if (r2 == null) goto L9;
        final BuyMeta r3 = r2.fillCommonMeta(this.f.a());
    L10:
        BottomButtonVO r4 = this.a;
        if (r4 == null) goto L17;
        BottomButtonMeta r5 = r4.getBottomButtonMetaValue();
        if (r5 == null) goto L17;
        SkuMeta r7 = r5.getSkuMeta();
        if (r7 == null) goto L17;
        SkuMeta r8 = r7.fillCommonMeta(this.f.a());
    L18:
        if (r6 == null) goto L20;
        String r9 = r6.getId();
    L22:
        if (Intrinsics.areEqual(r9, "action_buy") == false) goto L26;
        if (r3 == null) goto L26;
        return new BottomButtonComponent$getPreAction$1(this, r3, r6);
    L26:
        if (r6 == null) goto L28;
        String r10 = r6.getId();
    L30:
        if (Intrinsics.areEqual(r10, "action_sku") == false) goto L42;
        if (r8 == null) goto L43;
        String r11 = r6.getMeta();
        if (r11 == null) goto L37;
        JSONObject r12 = com.bytedance.android.shopping.extensions.k.w(r11);
        if (r12 == null) goto L37;
        Boolean r13 = Boolean.valueOf(r12.optBoolean("is_add_to_cart"));
    L39:
        if (com.bytedance.android.shopping.extensions.k.i(r13) == false) goto L41;
        return null;
    L41:
        return new BottomButtonComponent$getPreAction$2(this, r6);
    L37:
        r13 = null;
        goto L39
    L43:
        return null;
    L42:
        return null;
    L28:
        r10 = null;
        goto L30
    L20:
        r9 = null;
    L17:
        r8 = null;
    L9:
        r3 = null;
        goto L10
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void pdpAddShopCartSuccessEvent(hl.l r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.e == false) goto L5;
        return;
    L5:
        String r0 = r6.b;
        List r1 = r6.c;
        if (r1 == null) goto L24;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L18;
        Object r3 = r2.next();
        if (Intrinsics.areEqual(((CartNumWithBusinessLine) r3).getCartBusinessLineId(), r6.g) == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == false) goto L9;
    L19:
        CartNumWithBusinessLine r5 = (CartNumWithBusinessLine) r3;
        if (r5 == null) goto L24;
        Integer r7 = r5.getNum();
        if (r7 == null) goto L24;
        int r8 = r7.intValue();
    L26:
        if (r6.d == false) goto L31;
        if (r0 == null) goto L31;
        c(r0, r8, r6.e);
    L42:
        if (r6.h == true) goto L50;
        a(r6.i);
        return;
    L50:
        return;
    L31:
        if (r6.f == false) goto L35;
        BottomButtonView r9 = this.h;
        if (r9 == null) goto L38;
        r9.e(r8, AnonymousClass1.INSTANCE);
    L38:
        hl.i r10 = r6.e;
        if (r10 == null) goto L42;
        r10.onAnimationEnd();
        goto L42
    L35:
        BottomButtonView r11 = this.h;
        if (r11 == null) goto L38;
        r11.h(r8);
        goto L38
    L13:
        if (r6.g == null) goto L15;
        r4 = true;
        goto L16
    L18:
        r3 = null;
    L24:
        r8 = r6.a;
        goto L26
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void showAddCartEntrance(hl.p r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        int r0 = com.bytedance.android.shopping.utils.c.a;
        BottomButtonView r1 = this.h;
        if (r1 == null) goto L5;
        Context r2 = r1.getContext();
    L6:
        com.bytedance.android.shopping.utils.c.g(r2, new i(this.f), r6.a, r6.b);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void b(final String r10, final Map r11) {
        Intrinsics.checkNotNullParameter(r10, "enterPageType");
        BtmSDK r0 = BtmSDK.INSTANCE;
        BtmItemBuilder r1 = new BtmItemBuilder("a1.b8094.c7963.d2435", Boolean.FALSE);
        BottomButtonView r2 = this.h;
        if (r2 == null) goto L35;
        final String r3 = r0.createBtmId(r1.withView(r2).build());
        this.f.d(new BottomButtonComponent$logWhenClickBuyButton$1(this, r10, r3, r11));
        this.f.u("click_buy_right_now_btn");
        int r12 = com.bytedance.android.shopping.anchorv3.utils.a.a;
        CommonMeta r13 = this.f.a();
        if (r13 != null) goto L7;
    L9:
        boolean r4 = false;
    L10:
        CommonMeta r14 = this.f.a();
        if (r14 == null) goto L13;
        ECAdLogExtra r15 = r14.getAdLogExtra();
    L14:
        long r5 = this.f.getDuration();
        CommonMeta r6 = this.f.a();
        if (r6 == null) goto L17;
        String r7 = r6.getPromotionId();
    L18:
        CommonMeta r8 = this.f.a();
        if (r8 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        CommonMeta r16 = this.f.a();
        if (r16 == null) goto L27;
        Long r17 = Long.valueOf(r16.getPromotionSource());
    L28:
        CommonMeta r18 = this.f.a();
        if (r18 == null) goto L31;
        Long r19 = r18.getProductMinPrice();
    L32:
        com.bytedance.android.shopping.anchorv3.utils.a.a(r4, r15, r5, r7, r9, r17, r19);
        this.f.Q();
        return;
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    L21:
        if (r8.getFromLive() != true) goto L23;
        r9 = true;
        goto L24
    L17:
        r7 = null;
        goto L18
    L13:
        r15 = null;
        goto L14
    L7:
        if (r13.isLuban() != true) goto L9;
        r4 = true;
        goto L10
    L35:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(final Action r4, Object r5) {
        final Boolean r6 = null;
        if (r4 == null) goto L5;
        String r0 = r4.getId();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        switch(r0.hashCode()) {
            case -1644511110: goto L79;
            case -262296112: goto L76;
            case -261812826: goto L69;
            case 13598893: goto L63;
            case 198295501: goto L60;
            case 238756925: goto L57;
            case 1210086935: goto L54;
            case 1586109880: goto L51;
            case 1852186877: goto L30;
            case 1852202900: goto L12;
            default: goto L110;
        };
    L110:
        return;
    L12:
        if (r0.equals("action_sku") == false) goto L84;
        String r1 = r4.getMeta();
        if (r1 == null) goto L16;
        JSONObject r2 = com.bytedance.android.shopping.extensions.k.w(r1);
    L17:
        if (r2 == null) goto L19;
        Boolean r3 = Boolean.valueOf(r2.optBoolean("is_add_to_cart"));
    L20:
        if (r2 == null) goto L22;
        r6 = Boolean.valueOf(r2.optBoolean("is_custombuying"));
    L22:
        Boolean r7 = Boolean.TRUE;
        if (Intrinsics.areEqual(r3, r7) == false) goto L26;
        this.f.d(new BottomButtonComponent$handleShowToHub$2(this, r4));
        return;
    L26:
        if (Intrinsics.areEqual(r6, r7) == false) goto L28;
        this.f.d(BottomButtonComponent$handleShowToHub$3.INSTANCE);
        return;
    L28:
        this.f.d(new BottomButtonComponent$handleShowToHub$4(r4));
        return;
    L19:
        r3 = null;
        goto L20
    L16:
        r2 = null;
        goto L17
    L84:
        return;
    L30:
        if (r0.equals("action_buy") == false) goto L88;
        String r8 = r4.getMeta();
        if (r8 == null) goto L36;
        JSONObject r9 = com.bytedance.android.shopping.extensions.k.w(r8);
        if (r9 == null) goto L36;
        Boolean r10 = Boolean.valueOf(r9.optBoolean("is_custombuying"));
    L38:
        if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L40;
        this.f.d(BottomButtonComponent$handleShowToHub$5.INSTANCE);
    L41:
        BottomButtonVO r11 = this.a;
        if (r11 == null) goto L46;
        BottomButtonMeta r12 = r11.getBottomButtonMetaValue();
        if (r12 == null) goto L46;
        r6 = r12.getBuyMeta();
    L46:
        if (r6 != null) goto L48;
        return;
    L48:
        if (Intrinsics.areEqual(r6.getJoinMemberType(), "follow") == false) goto L90;
        this.f.d(new BottomButtonComponent$handleShowToHub$7$1(r6));
        return;
    L90:
        return;
    L40:
        this.f.d(new BottomButtonComponent$handleShowToHub$6(r4));
    L36:
        r10 = null;
        goto L38
    L88:
        return;
    L51:
        if (r0.equals("action_appoint") == false) goto L92;
        this.f.d(BottomButtonComponent$handleShowToHub$8.INSTANCE);
        return;
    L92:
        return;
    L54:
        if (r0.equals("action_deposit_appoint") == false) goto L94;
        this.f.d(BottomButtonComponent$handleShowToHub$9.INSTANCE);
        return;
    L94:
        return;
    L57:
        if (r0.equals("action_add_to_cart") == false) goto L96;
        this.f.d(new BottomButtonComponent$handleShowToHub$1(this, r4));
        return;
    L96:
        return;
    L60:
        if (r0.equals("action_im") == false) goto L98;
        this.f.d(BottomButtonComponent$handleShowToHub$10.INSTANCE);
        return;
    L98:
        return;
    L63:
        if (r0.equals("action_open_schema") == false) goto L100;
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L66
        this.f.d(new BottomButtonComponent$handleShowToHub$$inlined$runCatching$lambda$1(this, r4));     // Catch: Throwable -> L66
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L66
        return;
    L66:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L100:
        return;
    L69:
        if (r0.equals("action_enter_shop") == false) goto L102;
        final String r15 = new BtmItemBuilder("a1.b8094.c7963.d9242", Boolean.FALSE).withView(this.h).createBtmId();
        this.f.d(new BottomButtonComponent$handleShowToHub$11(this, r15));
        if (this.b == true) goto L103;
        this.b = true;
        int r16 = ECSdk.a;
        IECStoreService r17 = (IECStoreService) ECSdk.a(IECStoreService.class);
        if (r17 == null) goto L104;
        r17.onStoreEntranceShow();
        return;
    L104:
        return;
    L103:
        return;
    L102:
        return;
    L76:
        if (r0.equals("action_enter_cart") == false) goto L106;
        this.f.d(new BottomButtonComponent$handleShowToHub$12(this));
        return;
    L106:
        return;
    L79:
        if (r0.equals("action_find_same_goods") == false) goto L108;
        final String r18 = new BtmItemBuilder("a1.b8094.c7963.d41924", Boolean.FALSE).withView(this.h).createBtmId();
        this.f.d(new BottomButtonComponent$handleShowToHub$13(r18));
        return;
    L108:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public BottomButtonComponent(BottomNavigationComponentV1$componentDepend$1 r2, FragmentManager r3, BottomButtonView r4) {
        Intrinsics.checkNotNullParameter(r2, "anchorV4VM");
        this.f = r2;
        this.g = r3;
        this.h = r4;
        s0.c(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(final View r76, final Action r77, Object r78) {
        Intrinsics.checkNotNullParameter(r76, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r77, "action");
        final CommonMeta r4 = this.f.a();
        LinkedTreeMap<String, Object> r5 = this.f.b();
        if (r5 != null) goto L5;
        return;
    L5:
        boolean r2 = this.f.j();
        String r18 = this.f.f();
        long r16 = this.f.p();
        String r0 = r77.getMeta();
        if (r0 == null) goto L8;
        JSONObject r6 = com.bytedance.android.shopping.extensions.k.w(r0);
    L9:
        String r1 = r77.getId();
        if (r1 != null) goto L13;
        return;
    L13:
        switch(r1.hashCode()) {
            case -1644511110: goto L394;
            case -262296112: goto L369;
            case -261812826: goto L356;
            case 13598893: goto L324;
            case 198295501: goto L301;
            case 238756925: goto L264;
            case 1210086935: goto L261;
            case 1586109880: goto L220;
            case 1851553502: goto L203;
            case 1852186877: goto L124;
            case 1852202900: goto L16;
            default: goto L465;
        };
    L465:
        return;
    L16:
        if (r1.equals("action_sku") == false) goto L428;
        int r3 = ECSdk.a;
        IEShoppingService r7 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r7 == null) goto L20;
        sc3.c r8 = r7.getBuyNowService();
    L21:
        if (r8 == null) goto L23;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r10 = r8.n(new com.bytedance.android.ec.model.d(r76.getContext(), "BottomButtonComponent_sku", System.currentTimeMillis()));
    L24:
        if (r10 == null) goto L27;
        r10.c(ChainPoint.PAGE_INIT, Long.valueOf(System.currentTimeMillis()));
        Unit r9 = Unit.INSTANCE;
    L27:
        if (r6 == null) goto L29;
        Boolean r11 = Boolean.valueOf(r6.optBoolean("is_add_to_cart"));
    L31:
        if (com.bytedance.android.shopping.extensions.k.i(r11) == false) goto L61;
        com.bytedance.android.shopping.anchorv4.bottom.widget.b r12 = this.c;
        if (r12 == null) goto L61;
        if (r12.a != true) goto L61;
        SkuRestoreState r13 = this.f.P();
        if (r13 == null) goto L39;
        String r14 = r13.getSelectedSkuId();
    L41:
        if (a2.b(r14) == false) goto L61;
        BottomButtonVO r15 = this.a;
        if (r15 == null) goto L57;
        BottomButtonMeta r17 = r15.getBottomButtonMetaValue();
        if (r17 == null) goto L57;
        AddCartMeta r37 = r17.getAddCartMeta();
        if (r37 == null) goto L57;
        SkuRestoreState r19 = this.f.P();
        if (r19 == null) goto L51;
        String r67 = r19.getSelectedSkuId();
    L52:
        com.bytedance.android.shopping.anchorv4.bottom.b r20 = this.d;
        if (r20 == null) goto L55;
        Integer r53 = Integer.valueOf(r20.h);
    L56:
        AddCartMeta r21 = AddCartMeta.copy$default(r37, 0, null, null, null, null, null, null, null, null, null, null, null, null, true, r53, null, 0, false, null, false, false, null, null, null, null, null, null, 1, r67, 0, null, null, null, -402677761, 1, null);
    L58:
        d(r76, r4, r21);
        com.bytedance.android.shopping.anchorv4.bottom.widget.b r22 = this.c;
        if (r22 == null) goto L429;
        r22.a = false;
        r22.b();
        return;
    L429:
        return;
    L55:
        r53 = null;
        goto L56
    L51:
        r67 = null;
    L57:
        r21 = null;
        goto L58
    L39:
        r14 = null;
    L61:
        Set r23 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.e r24 = ECProcessMonitor.p();
        JSONObject r110 = new JSONObject();
        if (r4 != null) goto L414;
        String r25 = null;
    L67:
        r110.put(SimilarProductParam.ENTER_FROM, r25);     // Catch: Exception -> L64
        if (r4 == null) goto L76;
        String r26 = r4.getEntranceInfo();     // Catch: Exception -> L64
        if (r26 == null) goto L76;
        JSONObject r27 = com.bytedance.android.shopping.extensions.k.w(r26);     // Catch: Exception -> L64
        if (r27 == null) goto L76;
        r110.put("product_source_page", r27.optString("product_source_page"));     // Catch: Exception -> L64
        r110.put("module_label", r27.optString("module_label"));     // Catch: Exception -> L64
    L64:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L76:
        Unit r28 = Unit.INSTANCE;
        ActionRateListener.c(r24, r110, null, false, 6);
        Set r29 = ECProcessMonitor.a;
        ECProcessMonitor.p().d();
        Activity r30 = d0.a.getActivity(this.h);
        FragmentManager r111 = this.g;
        if (r111 == null) goto L122;
        if (r2 == false) goto L80;
        String r31 = "full_screen";
    L81:
        String r112 = r31;
        V4NativeParams r32 = this.f.c();
        if (r32 == null) goto L84;
        Boolean r33 = Boolean.valueOf(r32.isFromFeedProductGuessULike());
    L85:
        boolean r210 = com.bytedance.android.shopping.extensions.k.i(r33);
        if (r6 == null) goto L88;
        Boolean r34 = Boolean.valueOf(r6.optBoolean("is_add_to_cart"));
    L89:
        boolean r35 = com.bytedance.android.shopping.extensions.k.i(r34);
        if (r6 == null) goto L92;
        Boolean r36 = Boolean.valueOf(r6.optBoolean("is_groupbuying"));
    L93:
        boolean r211 = com.bytedance.android.shopping.extensions.k.i(r36);
        if (r6 == null) goto L96;
        Boolean r38 = Boolean.valueOf(r6.optBoolean("is_custombuying"));
    L97:
        boolean r212 = com.bytedance.android.shopping.extensions.k.i(r38);
        if (r6 == null) goto L100;
        Integer r39 = Integer.valueOf(r6.optInt("ultimate_buy_ab"));
    L101:
        int r310 = com.bytedance.android.shopping.extensions.k.g(r39, 0);
        if (r6 == null) goto L104;
        String r311 = r6.optString("biz_identifier");
    L105:
        if (r6 == null) goto L107;
        Integer r312 = Integer.valueOf(r6.optInt("force_yata_sku", 0));
    L108:
        j0 r40 = new j0(r111, r16, r18, r112, r210, r211, r35, null, null, r212, null, null, null, null, null, r310, r312, r311, null, 294272);
        BottomButtonVO r41 = this.a;
        if (r41 == null) goto L113;
        BottomButtonMeta r42 = r41.getBottomButtonMetaValue();
        if (r42 == null) goto L113;
        SkuMeta r43 = r42.getSkuMeta();
    L114:
        String r44 = r77.getTrackMeta();
        if (r44 == null) goto L119;
        JSONObject r45 = com.bytedance.android.shopping.extensions.k.w(r44);
        if (r45 == null) goto L119;
        Map<String, Object> r313 = com.bytedance.android.shopping.hybrid.a.b(r45);
    L120:
        e(this, r76, r30, r4, r5, r40, r43, true, null, r313, r10, 128);
        return;
    L119:
        r313 = null;
    L113:
        r43 = null;
        goto L114
    L107:
        r312 = null;
        goto L108
    L104:
        r311 = null;
        goto L105
    L100:
        r39 = null;
        goto L101
    L96:
        r38 = null;
        goto L97
    L92:
        r36 = null;
        goto L93
    L88:
        r34 = null;
        goto L89
    L84:
        r33 = null;
        goto L85
    L80:
        r31 = "half_screen";
        goto L81
    L122:
        throw new IllegalStateException("Required value was null.".toString());
    L414:
        r25 = r4.getSourcePage();     // Catch: Exception -> L64
        goto L67
    L29:
        r11 = null;
        goto L31
    L23:
        r10 = null;
        goto L24
    L20:
        r8 = null;
        goto L21
    L428:
        return;
    L124:
        if (r1.equals("action_buy") == false) goto L432;
        int r46 = ECSdk.a;
        IEShoppingService r47 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r47 == null) goto L128;
        sc3.c r48 = r47.getBuyNowService();
    L129:
        if (r48 == null) goto L131;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r49 = r48.n(new com.bytedance.android.ec.model.d(r76.getContext(), "BottomButtonComponent", System.currentTimeMillis()));
    L132:
        if (r49 == null) goto L135;
        r49.c(ChainPoint.PAGE_INIT, Long.valueOf(System.currentTimeMillis()));
        Unit r50 = Unit.INSTANCE;
    L135:
        if (z53.b.a(1001, 800) == false) goto L137;
        return;
    L137:
        Set r51 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.b r52 = ECProcessMonitor.e("ec_product_detail");
        JSONObject r54 = new JSONObject();
        if (r4 != null) goto L418;
        String r55 = null;
    L143:
        r54.put(SimilarProductParam.ENTER_FROM, r55);     // Catch: Exception -> L140
        if (r4 == null) goto L152;
        String r56 = r4.getEntranceInfo();     // Catch: Exception -> L140
        if (r56 == null) goto L152;
        JSONObject r57 = com.bytedance.android.shopping.extensions.k.w(r56);     // Catch: Exception -> L140
        if (r57 == null) goto L152;
        r54.put("product_source_page", r57.optString("product_source_page"));     // Catch: Exception -> L140
        r54.put("module_label", r57.optString("module_label"));     // Catch: Exception -> L140
    L140:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L152:
        Unit r58 = Unit.INSTANCE;
        ActionRateListener.c(r52, r54, null, false, 6);
        Set r59 = ECProcessMonitor.a;
        ECProcessMonitor.e("ec_product_detail").d();
        this.f.T();
        BottomButtonVO r60 = this.a;
        if (r60 == null) goto L157;
        BottomButtonMeta r61 = r60.getBottomButtonMetaValue();
        if (r61 == null) goto L157;
        BuyMeta r62 = r61.getBuyMeta();
    L158:
        d0 r63 = d0.a;
        FragmentActivity r64 = r63.getActivity(r76);
        if (r64 == null) goto L201;
        FragmentActivity r65 = r64;
        FragmentManager r66 = this.g;
        if (r66 == null) goto L199;
        BottomButtonView r68 = this.h;
        V4NativeParams r113 = this.f.c();
        if (r113 == null) goto L165;
        Boolean r114 = Boolean.valueOf(r113.isFromFeedProductGuessULike());
    L166:
        boolean r115 = com.bytedance.android.shopping.extensions.k.i(r114);
        if (r6 == 0) goto L169;
        JSONObject r116 = r6;
        Boolean r69 = Boolean.valueOf(r116.optBoolean("is_groupbuying"));
    L170:
        boolean r213 = com.bytedance.android.shopping.extensions.k.i(r69);
        if (r116 == null) goto L173;
        Boolean r70 = Boolean.valueOf(r116.optBoolean("is_custombuying"));
    L174:
        com.bytedance.android.shopping.anchorv4.bottom.m r71 = new com.bytedance.android.shopping.anchorv4.bottom.m(r65, r66, r68, r18, r115, r213, com.bytedance.android.shopping.extensions.k.i(r70));
        if (r62 == null) goto L193;
        BuyMeta r72 = r62.fillCommonMeta(r4);
        if (r72 == null) goto L193;
        d r73 = this.f;
        BottomButtonVO r74 = this.a;
        if (r74 == null) goto L184;
        BottomButtonMeta r75 = r74.getBottomButtonMetaValue();
        if (r75 == null) goto L184;
        SkuMeta r79 = r75.getSkuMeta();
    L185:
        final BuyComponent r80 = new BuyComponent(r73, r76, r79, r72, r71, new com.bytedance.android.shopping.anchorv4.bottom.o(r5), r49);
        if (r80.d.getUseNativeBuy() == false) goto L188;
        boolean r81 = com.bytedance.android.shopping.utils.i.a;
    L189:
        if (r81 == false) goto L191;
        int r82 = AuthUtils.a;
        AuthUtils.a(r63.getActivity(r80.b), r80.d.getPromotionSource(), null, new BuyComponent$logAndAction$1(r80));
    L192:
        f("buy");
        goto L193
    L191:
        r80.a(r80.d, false);
        goto L192
    L188:
        r81 = com.bytedance.android.shopping.utils.i.a();
    L184:
        r79 = null;
    L193:
        int r84 = ECSdk.a;
        IECUserTrackerService r85 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r85 == null) goto L433;
        of.a r86 = r85.getMarketingService();
        if (r86 == null) goto L434;
        r86.a("product_detail_click_purchase", PostActionType.DO, "product_detail");
        return;
    L434:
        return;
    L433:
        return;
    L173:
        r70 = null;
        goto L174
    L169:
        r116 = r6;
        r69 = null;
        goto L170
    L165:
        r114 = null;
        goto L166
    L199:
        throw new IllegalStateException("Required value was null.".toString());
    L201:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L157:
        r62 = null;
        goto L158
    L418:
        r55 = r4.getSourcePage();     // Catch: Exception -> L140
        goto L143
    L131:
        r49 = null;
        goto L132
    L128:
        r48 = null;
        goto L129
    L432:
        return;
    L203:
        if (r1.equals("action_toast") == false) goto L436;
        Context r87 = r76.getContext();
        BottomButtonVO r88 = this.a;
        if (r88 == null) goto L209;
        BottomButtonMeta r89 = r88.getBottomButtonMetaValue();
        if (r89 == null) goto L209;
        BuyMeta r90 = r89.getBuyMeta();
    L210:
        if (r90 == null) goto L437;
        String r91 = r90.getToast();
        if (r91 != null) goto L214;
        return;
    L214:
        if (com.bytedance.android.shopping.extensions.k.c(r91) == false) goto L216;
        String r92 = r91;
    L217:
        if (r92 == null) goto L439;
        com.bytedance.android.ec.sdk.helper.i.a.e(r87, r92, true, false);
        return;
    L439:
        return;
    L216:
        r92 = null;
        goto L217
    L437:
        return;
    L209:
        r90 = null;
        goto L210
    L436:
        return;
    L220:
        if (r1.equals("action_appoint") == false) goto L441;
        BottomButtonVO r94 = this.a;
        if (r94 == null) goto L259;
        BottomButtonMeta r95 = r94.getBottomButtonMetaValue();
        if (r95 == null) goto L426;
        AppointmentMeta r96 = r95.getAppointMeta();
        if (r96 == null) goto L427;
        final a r97 = new a(r96.fillCommonMeta(r4), this.f, this);
        AnchorV3Api.a r98 = AnchorV3Api.a;
        String r99 = r97.a.getPromotionId();
        if (r99 != null) goto L231;
        String r100 = "";
    L232:
        String r101 = r97.a.getProductId();
        if (r101 != null) goto L235;
        String r102 = "";
    L236:
        String r103 = r97.a.getItemId();
        if (r103 != null) goto L239;
        String r104 = "";
    L240:
        String r105 = r97.a.getAuthorId();
        if (r105 != null) goto L243;
        String r106 = "";
    L244:
        String r107 = r97.a.getSecAuthorId();
        if (r107 != null) goto L247;
        String r108 = "";
    L248:
        String r109 = com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId();
        if (r97.a.isAppointment() == false) goto L251;
        int r117 = 2;
    L252:
        String r118 = r97.a.getMetaParam();
        if (r118 != null) goto L255;
        String r119 = "";
    L256:
        Function2<Boolean, String, Unit> r120 = new AppointmentComponent$appointment$1(r97);
        r98.getClass();
        AnchorV3Api.a.c(r100, r102, r104, r106, r108, r109, r117, r119, r120);
        nl.d r121 = r97.c;
        if (r121 == null) goto L442;
        r121.b("5", null);
        return;
    L442:
        return;
    L255:
        r119 = r118;
        goto L256
    L251:
        r117 = 1;
        goto L252
    L247:
        r108 = r107;
        goto L248
    L243:
        r106 = r105;
        goto L244
    L239:
        r104 = r103;
        goto L240
    L235:
        r102 = r101;
        goto L236
    L231:
        r100 = r99;
        goto L232
    L427:
        return;
    L426:
        return;
    L259:
        return;
    L441:
        return;
    L261:
        if (r1.equals("action_deposit_appoint") == false) goto L444;
        com.bytedance.android.shopping.anchorv4.bottom.y r122 = new com.bytedance.android.shopping.anchorv4.bottom.y(0);
        r122.a(r4);
        new DepositPreSaleAppointmentComponent(r122, this).a(new BottomButtonComponent$handleActionToHub$6(this), new BottomButtonComponent$handleActionToHub$7(this));
        return;
    L444:
        return;
    L264:
        if (r1.equals("action_add_to_cart") == false) goto L446;
        Set r123 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a r124 = ECProcessMonitor.d("ec_product_detail");
        JSONObject r125 = new JSONObject();
        if (r4 != null) goto L416;
        String r126 = null;
    L271:
        r125.put(SimilarProductParam.ENTER_FROM, r126);     // Catch: Exception -> L268
        if (r4 == null) goto L280;
        String r127 = r4.getEntranceInfo();     // Catch: Exception -> L268
        if (r127 == null) goto L280;
        JSONObject r128 = com.bytedance.android.shopping.extensions.k.w(r127);     // Catch: Exception -> L268
        if (r128 == null) goto L280;
        r125.put("product_source_page", r128.optString("product_source_page"));     // Catch: Exception -> L268
        r125.put("module_label", r128.optString("module_label"));     // Catch: Exception -> L268
    L268:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L280:
        Unit r129 = Unit.INSTANCE;
        ActionRateListener.c(r124, r125, null, false, 6);
        Set r130 = ECProcessMonitor.a;
        ECProcessMonitor.d("ec_product_detail").d();
        BottomButtonVO r131 = this.a;
        if (r131 == null) goto L293;
        BottomButtonMeta r132 = r131.getBottomButtonMetaValue();
        if (r132 == null) goto L293;
        AddCartMeta r133 = r132.getAddCartMeta();
        if (r133 == null) goto L293;
        String r134 = r77.getTrackMeta();
        if (r134 == null) goto L291;
        JSONObject r135 = com.bytedance.android.shopping.extensions.k.w(r134);
        if (r135 == null) goto L291;
        Map<String, Object> r136 = com.bytedance.android.shopping.hybrid.a.b(r135);
    L292:
        r133.setTrackServerMeta(r136);
    L291:
        r136 = null;
    L293:
        BottomButtonVO r137 = this.a;
        if (r137 == null) goto L298;
        BottomButtonMeta r138 = r137.getBottomButtonMetaValue();
        if (r138 == null) goto L298;
        AddCartMeta r139 = r138.getAddCartMeta();
    L299:
        d(r76, r4, r139);
        return;
    L298:
        r139 = null;
        goto L299
    L416:
        r126 = r4.getSourcePage();     // Catch: Exception -> L268
        goto L271
    L446:
        return;
    L301:
        if (r1.equals("action_im") == false) goto L448;
        final d r140 = this.f;
        BottomButtonVO r141 = this.a;
        if (r141 == null) goto L307;
        BottomButtonMeta r142 = r141.getBottomButtonMetaValue();
        if (r142 == null) goto L307;
        IMMeta r143 = r142.getImMeta();
    L308:
        if (r143 == null) goto L449;
        IMMeta r144 = r143.fillCommonMeta(r4);
        if (r144 == null) goto L466;
        Set r145 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_product_detail", "enter_im").d();
        if (com.bytedance.android.ec.core.opt.ab.u.c() != 1) goto L322;
        String r146 = r144.getImUrl();
        if (r146 == null) goto L321;
        int r147 = ECSdk.a;
        IShoppingAbilities r148 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r148 == null) goto L319;
        r148.openIM(r76.getContext(), new df.m(r146, r76, "a1.b8094.c7963.d6675"), new df.l(r144.getPromotionSource(), r144.getSourcePage(), r144.getEnterMethod()), new BottomButtonComponent$handleIMWithMeta$$inlined$let$lambda$1(r76, r140));
        Unit r149 = Unit.INSTANCE;
    L320:
        if (r149 == null) goto L321;
        return;
    L319:
        r149 = null;
    L321:
        com.bytedance.android.ec.core.monitor.listener.c.j(ECProcessMonitor.c("ec_product_detail", "enter_im"), -2);
        Unit r150 = Unit.INSTANCE;
        return;
    L322:
        new IMComponent(r140, r76, r144, "a1.b8094.c7963.d6675").b();
        return;
    L466:
        return;
    L449:
        return;
    L307:
        r143 = null;
        goto L308
    L448:
        return;
    L324:
        if (r1.equals("action_open_schema") == false) goto L453;
        final Context r151 = r76.getContext();
        BottomButtonVO r152 = this.a;
        if (r152 == null) goto L330;
        BottomButtonMeta r153 = r152.getBottomButtonMetaValue();
        if (r153 == null) goto L330;
        BuyMeta r154 = r153.getBuyMeta();
    L331:
        if (r154 == null) goto L454;
        String r155 = r154.getCommonSchema();
        if (r155 == null) goto L455;
        String r156 = com.bytedance.android.ec.core.btm.c.c(r155, this.h, "a1.b8094.c7963.d2435", new Pair[0]);
        Result.Companion r157 = Result.Companion;     // Catch: Throwable -> L344
        Uri r158 = UriProtector.parse(r155);     // Catch: Throwable -> L344
        if (r158 == null) goto L338;
        String r159 = UriProtector.getQueryParameter(r158, "client_handle_mega_object");     // Catch: Throwable -> L344
    L339:
        boolean r160 = Intrinsics.areEqual(r159, "1");     // Catch: Throwable -> L344
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L342
    L347:
        if (r160 == false) goto L349;
        ECLiveHybridUtil.k(r151, r156, false, false, false, null, 252);
    L422:
        this.f.d(new BottomButtonComponent$handleOpenSchema$$inlined$let$lambda$1(this, this, r151, r77));     // Catch: Throwable -> L352
        Object r161 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L352
    L354:
        Result.box-impl(r161);
        return;
    L352:
        th = move-exception;
        Result.Companion r162 = Result.Companion;
        r161 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L354
    L349:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r151, r156);
    L342:
        th = th;
    L346:
        Result.Companion r163 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L347
    L338:
        r159 = null;
    L344:
        th = th;
        r160 = false;
        goto L346
    L455:
        return;
    L454:
        return;
    L330:
        r154 = null;
        goto L331
    L453:
        return;
    L356:
        if (r1.equals("action_enter_shop") == false) goto L457;
        BottomButtonVO r164 = this.a;
        if (r164 == null) goto L362;
        BottomButtonMeta r165 = r164.getBottomButtonMetaValue();
        if (r165 == null) goto L362;
        EnterShopMeta r166 = r165.getEnterShopMeta();
    L363:
        if (r166 == null) goto L458;
        EnterShopMeta r167 = r166.fillCommonMeta(r4);
        if (r167 == null) goto L467;
        j.a(new j(r167, this.f), r76, "a1.b8094.c7963.d9242", "product_detail_tab", null, 48);
        f("enter_shop");
        return;
    L467:
        return;
    L458:
        return;
    L362:
        r166 = null;
        goto L363
    L457:
        return;
    L369:
        if (r1.equals("action_enter_cart") == false) goto L460;
        this.f.T();
        BottomButtonVO r168 = this.a;
        if (r168 == null) goto L375;
        BottomButtonMeta r169 = r168.getBottomButtonMetaValue();
        if (r169 == null) goto L375;
        EnterCartMeta r170 = r169.getEnterCartMeta();
    L376:
        if (r170 == null) goto L461;
        EnterCartMeta r171 = r170.fillCommonMeta(r4);
        if (r171 == null) goto L468;
        Set r172 = ECProcessMonitor.a;
        ECProcessMonitor.c("ec_product_detail", "enter_cart").d();
        if (com.bytedance.android.ec.core.opt.ab.u.b() != 1) goto L388;
        int r173 = ECSdk.a;
        IShoppingAbilities r174 = (IShoppingAbilities) ECSdk.a(IShoppingAbilities.class);
        if (r174 == null) goto L392;
        Context r175 = r76.getContext();
        String r176 = r171.getCartUrl();
        if (r176 != null) goto L387;
        r176 = "";
    L387:
        r174.enterCart(r175, new df.j(r176, r76), new df.i(r171.getPromotionSource()), new BottomButtonComponent$handleEnterCartWithMeta$1(this, r76, r171, r170));
    L392:
        f("enter_cart");
        return;
    L388:
        final EnterCartComponent r177 = new EnterCartComponent(r76, this.f, d0.a.getActivity(this.h), r171);
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L391;
        int r178 = AuthUtils.a;
        AuthUtils.a(r177.c, r177.d.getPromotionSource(), null, new EnterCartComponent$doEnterShop$1(r177));
        goto L392
    L391:
        r177.a();
        goto L392
    L468:
        return;
    L461:
        return;
    L375:
        r170 = null;
        goto L376
    L460:
        return;
    L394:
        if (r1.equals("action_find_same_goods") == false) goto L463;
        Context r179 = r76.getContext();
        BottomButtonVO r180 = this.a;
        if (r180 == null) goto L400;
        BottomButtonMeta r181 = r180.getBottomButtonMetaValue();
        if (r181 == null) goto L400;
        BuyMeta r182 = r181.getBuyMeta();
    L401:
        if (r182 == null) goto L403;
        String r183 = r182.getFindSameGoodsUrl();
    L404:
        if (r183 != null) goto L407;
        r183 = "";
    L407:
        if (r183.length() != 0) goto L409;
        boolean r184 = true;
    L410:
        if (r184 == true) goto L469;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r179, com.bytedance.android.ec.core.btm.c.c(r183, this.h, "a1.b8094.c7963.d41924", new Pair[0]));
        final String r185 = new BtmItemBuilder("a1.b8094.c7963.d41924", Boolean.FALSE).withView(this.h).createBtmId();
        this.f.d(new BottomButtonComponent$handleFindSameGoodsSchema$1(r4, r185));
        return;
    L469:
        return;
    L409:
        r184 = false;
        goto L410
    L403:
        r183 = null;
    L400:
        r182 = null;
        goto L401
    L463:
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void c(final String r18, final int r19, final hl.i r20) {
        BottomButtonView r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        final Context r8 = r0.getContext();
        if (r8 != null) goto L8;
        return;
    L8:
        BottomButtonMeta r1 = this.f.D();
        if (r1 == null) goto L21;
        AddCartMeta r2 = r1.getAddCartMeta();
        if (r2 == null) goto L21;
        if (r2.getAddCartAnimationV2() != true) goto L21;
        final View r5 = this.h.getCartIcon();
        if (r5 == null) goto L60;
        Rect r3 = this.f.O();
        if (r3 == null) goto L61;
        final int r4 = (r3.left + r3.right) / 2;
        final int r6 = ((r3.top + r3.bottom) / 2) - this.f.getStatusBarHeight();
        PdpAddCartAnimationV2 r9 = com.bytedance.android.shopping.anchorv4.helper.o.a(r8);
        ((BasePdpAddCartAnimation) r9).c = r18;
        Point r7 = new Point(r4, r6);
        Point r10 = com.bytedance.android.shopping.anchorv4.helper.p.b(r5);
        ((BasePdpAddCartAnimation) r9).a = r7;
        ((BasePdpAddCartAnimation) r9).b = r10;
        r9.c(new BottomButtonComponent$doScaleAnimationV2$$inlined$also$lambda$1(this, r18, r4, r6, r5, r19, r8, r20));
        return;
    L61:
        return;
    L60:
        return;
    L21:
        BottomButtonView r11 = this.h;
        if (r11 == null) goto L62;
        final View r12 = r11.getCartIcon();
        if (r12 == null) goto L59;
        Context r13 = this.h.getContext();
        Object r14 = null;
        if (r13 == null) goto L29;
        Object r15 = r13.getSystemService("window");
    L31:
        if ((r15 instanceof WindowManager) == false) goto L34;
        r14 = r15;
    L34:
        final WindowManager r16 = (WindowManager) r14;
        Rect r17 = this.f.O();
        if (r17 == null) goto L63;
        int[] r21 = new int[2];
        r12.getLocationOnScreen(r21);
        final View r22 = new ECDraweeView(this.h.getContext(), null, 0, 6, null);
        com.bytedance.android.ec.core.utils.y.g(r22, r18, r17.bottom - r17.top, r17.right - r17.left);
        r22.setCornerRadius((r17.right - r17.left) / 2);
        int r23 = r17.right - r17.left;
        int r24 = r17.bottom - r17.top;
        int r25 = this.f.getStatusBarHeight();
        r21[1] = r21[1] - r25;
        r21[0] = r21[0] + (r12.getWidth() / 2);
        r21[1] = r21[1] + (r12.getHeight() / 2);
        WindowManager.LayoutParams r110 = new WindowManager.LayoutParams();
        r110.width = r23;
        r110.height = r23;
        r110.flags = 664;
        r110.format = -3;
        r110.type = 99;
        r110.y = r24 - r25;
        r110.gravity = 8388659;
        if (r16 == null) goto L40;
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r22, r110);
        r16.addView(r22, r110);
    L40:
        Float[] r26 = {Float.valueOf(0.24f), Float.valueOf(0.3f)};
        final ValueAnimator r27 = ValueAnimator.ofObject(new com.bytedance.android.shopping.utils.v(), new Object[]{new PointF(1.0f, 0.0f), new PointF(r26[0].floatValue(), 1.0f), new PointF(r26[1].floatValue(), 1.0f)});
        r27.addUpdateListener(new b(r22));
        List r28 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(r110.x), Integer.valueOf(r110.y)});
        List r29 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(((-r110.width) / 2) + r21[0]), Integer.valueOf(r21[1] - (r110.height / 2))});
        Integer r30 = (Integer) CollectionsKt.getOrNull(r28, 0);
        if (r30 == null) goto L43;
        int r31 = r30.intValue();
    L44:
        Integer r32 = (Integer) CollectionsKt.getOrNull(r28, 1);
        if (r32 == null) goto L47;
        int r33 = r32.intValue();
    L48:
        Integer r111 = (Integer) CollectionsKt.getOrNull(r29, 0);
        if (r111 == null) goto L51;
        int r112 = r111.intValue();
    L52:
        Integer r34 = (Integer) CollectionsKt.getOrNull(r29, 1);
        if (r34 == null) goto L55;
        int r35 = r34.intValue();
    L56:
        final ValueAnimator r36 = ValueAnimator.ofObject(new com.bytedance.android.shopping.utils.d(new Point(r112, (r33 + r35) / 2)), new Object[]{new Point(r31, r33), new Point(r112, r35)});
        r36.addUpdateListener(new c(r36, r16, r22, r110));
        r36.setDuration(400);
        AnimatorSet r113 = new AnimatorSet();
        r113.playSequentially(new Animator[]{r27, r36});
        com.bytedance.android.ec.core.utils.f.a(r113, new BottomButtonComponent$doScaleAnimationV1$$inlined$let$lambda$1(r27, r36, r22, r16, r12, this, r18, r19, r20));
        r113.start();
        return;
    L55:
        r35 = 0;
        goto L56
    L51:
        r112 = 0;
        goto L52
    L47:
        r33 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L63:
        return;
    L29:
        r15 = null;
        goto L31
    L59:
        return;
    }

    public final void d(final View r4, CommonMeta r5, final AddCartMeta r6) {
        if (r6 == null) goto L12;
        final AddCartMeta r7 = r6.fillCommonMeta(r5);
        if (r7 == null) goto L13;
        final AddCartComponent r0 = new AddCartComponent(r4, this.f, r7);
        final Function1<Integer, Unit> r1 = new BottomButtonComponent$handleAddCartWithMeta$1(this, r7, r4, r6);
        Intrinsics.checkNotNullParameter(r1, "addCartCallBack");
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L9;
        int r8 = AuthUtils.a;
        AuthUtils.a(d0.a.getActivity(r0.a), r0.c.getPromotionSource(), null, new AddCartComponent$logAndAction$1(r0, r1));
    L10:
        f("add_to_cart");
        return;
    L9:
        r0.a(r0.c, r0.a.getContext(), r1);
        goto L10
    L13:
        return;
    }

    public static void e(BottomButtonComponent r13, View r14, Activity r15, CommonMeta r16, LinkedTreeMap r17, j0 r18, SkuMeta r19, boolean r20, com.bytedance.android.btm.api.model.d r21, Map r22, sc3.b r23, int r24) {
        LinkedTreeMap r4 = null;
        if ((r24 & 128) == 0) goto L5;
        com.bytedance.android.btm.api.model.d r11 = null;
    L7:
        if ((r24 & 256) == 0) goto L9;
        Map r3 = null;
    L11:
        if ((r24 & 512) == 0) goto L13;
        sc3.b r12 = null;
    L14:
        r13.getClass();
        if (r19 == null) goto L17;
        SkuMeta r9 = r19.fillCommonMeta(r16);
    L18:
        if (r9 != null) goto L20;
        Set r0 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.e r1 = ECProcessMonitor.p();
        int r2 = com.bytedance.android.ec.core.monitor.listener.e.k;
        r1.j(-2, null);
        return;
    L20:
        BottomButtonVO r5 = r13.a;
        if (r5 == null) goto L25;
        BottomButtonMeta r6 = r5.getBottomButtonMetaValue();
        if (r6 == null) goto L25;
        AddCartMeta r7 = r6.getAddCartMeta();
    L26:
        r9.setAddCartMeta(r7);
        LinkedHashMap r8 = new LinkedHashMap();
        r8.putAll(r17);
        LinkedTreeMap r10 = r19.getTrackMeta();
        if (r10 == null) goto L29;
        r8.putAll(r10);
    L29:
        Unit r25 = Unit.INSTANCE;
        AddCartMeta r26 = r9.getAddCartMeta();
        if (r26 == null) goto L36;
        LinkedTreeMap r27 = r26.getTrackMeta();
        if (r27 == null) goto L36;
        if (r3 != null) goto L35;
        r3 = new LinkedHashMap();
    L35:
        r27.putAll(r3);
        r4 = r27;
    L36:
        k0 r28 = new k0(r8, r4);
        d r29 = r13.f;
        new SkuComponentComponentV2(r15, r18, r28, r9, new BottomNavV1SkuDependency(r29, r29.V()), r11, r12).c(r14, r20);
        if (r18.g == false) goto L39;
        String r30 = "add_to_cart";
    L40:
        r13.f(r30);
        return;
    L39:
        r30 = "buy";
    L25:
        r7 = null;
        goto L26
    L17:
        r9 = null;
        goto L18
    L13:
        r12 = r23;
        goto L14
    L9:
        r3 = r22;
        goto L11
    L5:
        r11 = r21;
        goto L7
    }
}
