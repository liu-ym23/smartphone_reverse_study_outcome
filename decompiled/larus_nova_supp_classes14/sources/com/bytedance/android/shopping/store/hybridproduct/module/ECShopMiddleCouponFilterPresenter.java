package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.view.ECShopCountdownTimerView;
import com.bytedance.android.ec.store.view.ECShopCouponStateButton;
import com.bytedance.android.ec.store.view.ECShopMiddleCouponFilterView;
import com.bytedance.android.shopping.store.arch.ECStoreFoldPhoneHelper;
import com.bytedance.android.shopping.store.home.ECShopGroupAnimation;
import com.bytedance.android.shopping.store.home.api.ECStoreApi;
import com.bytedance.android.shopping.store.home.e0;
import com.bytedance.android.shopping.store.home.presenter.ECShopBasePresenter;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.dto.ShopCouponResponseDTO;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.ListMapNumberHandlerGsonHolder;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.shopping.utils.l0;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ECShopMiddleCouponFilterPresenter extends ECShopBasePresenter {
    public static final /* synthetic */ int y = 0;
    public final ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1 u;
    public final b v;
    public final ECShopHybridProductViewModel w;
    public final ECStoreViewModel x;

    public static final class a {
    }

    public static final class b implements ti.j {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;

        public b(ECShopMiddleCouponFilterPresenter r1) {
            this.a = r1;
        }

        public final void a(JSONObject r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            if (Intrinsics.areEqual(r2.optString("coupon_dialog_type"), "3") == false) goto L6;
            ECShopMiddleCouponFilterPresenter r3 = this.a;
            r3.u0(r3.w.getMiddleCouponFilterVO());
            return;
        }
    }

    public static final class c implements ECShopGroupAnimation.a {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;

        @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
        public final int b() {
            return ExtensionsKt.a(0);
        }

        @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
        public final int a() {
            return ExtensionsKt.a(45);
        }

        public c(ECShopMiddleCouponFilterPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
        public final void c(ECShopGroupAnimation.Direction r2) {
            Intrinsics.checkNotNullParameter(r2, "direction");
            if (r2 != ECShopGroupAnimation.Direction.REVERSE) goto L6;
            this.a.y().setVisibility(8);
            return;
        }

        @Override // com.bytedance.android.shopping.store.home.ECShopGroupAnimation.a
        public final void onChange(int r1, float r2) {
            p.a(this.a.y(), r1);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;
        public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.h b;

        public d(ECShopMiddleCouponFilterPresenter r1, com.bytedance.android.ec.store.repository.vo.h r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ECShopMiddleCouponFilterPresenter r11 = this.a;
            com.bytedance.android.ec.store.repository.vo.h r0 = this.b;
            View r1 = r11.y();
            Observable<ShopCouponResponseDTO> r3 = null;
            if ((r1 instanceof ECShopMiddleCouponFilterView) == true) goto L5;
            r1 = null;
        L5:
            ECShopMiddleCouponFilterView r2 = (ECShopMiddleCouponFilterView) r1;
            if (r2 == null) goto L105;
            String r4 = r2.getEcShopCouponStateButton().getStateCode();
            boolean r7 = false;
            r11.v0(r2, "click_ecom_component", MapsKt.mapOf(new Pair[]{TuplesKt.to("coupon_status", String.valueOf(r4)), TuplesKt.to("click_button_type", "filter_products_button")}));
            r11.w0(r2, "marketing_click", r0, MapsKt.mapOf(TuplesKt.to("click_attitude", "positive")));
            if (r4 != null) goto L12;
            return;
        L12:
            switch(r4.hashCode()) {
                case 49: goto L35;
                case 50: goto L18;
                case 51: goto L15;
                default: goto L107;
            };
        L107:
            return;
        L15:
            if (r4.equals("3") == false) goto L92;
            r11.z0();
            r0.c();
            r0.p(Boolean.FALSE);
            ECShopHybridProductViewModel.refreshByDiscountSelect$default(r11.w, null, null, 3, null);
            return;
        L92:
            return;
        L18:
            if (r4.equals("2") == false) goto L94;
            r11.z0();
            r0.d();
            r0.p(Boolean.FALSE);
            ECShopHybridProductViewModel r12 = r11.w;
            String r5 = r0.j();
            if (r5 != null) goto L22;
        L23:
            r7 = true;
        L25:
            if ((true ^ r7) == true) goto L28;
            r5 = null;
        L28:
            if (r5 != null) goto L33;
            com.bytedance.android.ec.store.repository.vo.e r6 = r0.e();
            if (r6 == null) goto L32;
            r5 = r6.d();
            goto L33
        L32:
            r5 = null;
        L33:
            ECShopHybridProductViewModel.refreshByDiscountSelect$default(r12, r5, null, 2, null);
            return;
        L22:
            if (r5.length() != 0) goto L25;
        L94:
            return;
        L35:
            if (r4.equals(CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L96;
            com.bytedance.android.ec.store.repository.vo.h r8 = r11.w.getMiddleCouponFilterVO();
            if (r8 != null) goto L39;
            dm.a.a("ECShopMiddleCouponFilter").w("applyCouponFromMiddleCouponAndRerender() called with: middleCouponFilterVO = null", null);
            return;
        L39:
            ECShopMiddleCouponFilterPresenter$applyCouponFromMiddleCouponAndRerender$1 r9 = new ECShopMiddleCouponFilterPresenter$applyCouponFromMiddleCouponAndRerender$1(r11);
            ECShopMiddleCouponFilterPresenter$applyCouponFromMiddleCouponAndRerender$2 r13 = ECShopMiddleCouponFilterPresenter$applyCouponFromMiddleCouponAndRerender$2.INSTANCE;
            com.bytedance.android.ec.store.repository.vo.e r14 = r8.e();
            if (r14 == null) goto L42;
            List r15 = r14.c();
        L43:
            List r16 = r15;
            if (r16 != null) goto L46;
        L47:
            r7 = true;
        L48:
            if (r7 == true) goto L57;
            HashMap r17 = new HashMap();
            r17.put("apply_resource_param_list", r15);     // Catch: Throwable -> L52
        L54:
            ECStoreApi.a.getClass();
            ECStoreApi r18 = ECStoreApi.a.a;
            if (r18 == null) goto L75;
            r3 = r18.applyCouponForMiddleFloatFromMarket(RequestBody.create(MediaType.parse("application/json"), GsonProtectorUtils.toJson((Gson) ListMapNumberHandlerGsonHolder.b.getValue(), r17)));
        L75:
            if (r3 == null) goto L98;
            Observable r19 = bg4.b.b(r3);
            if (r19 == null) goto L99;
            Disposable r20 = r19.subscribe(new j(r11, r13, r9), new k(r13));
            if (r20 == null) goto L100;
            com.bytedance.android.ec.core.async.a.a(r20, r11.T());
            return;
        L100:
            return;
        L99:
            return;
        L98:
            return;
        L52:
            th = move-exception;
            dm.a.a("ECShopMiddleCouponFilter").w("applyCouponFromMiddleCoupon() called with: applyResourceParamsList = " + r15 + ", t = " + th, null);
            goto L54
        L57:
            com.bytedance.android.ec.store.repository.vo.e r21 = r8.e();
            if (r21 == null) goto L85;
            String r22 = r21.a();
            if (r22 == null) goto L85;
            com.bytedance.android.ec.store.repository.vo.e r23 = r8.e();
            if (r23 == null) goto L81;
            String r24 = r23.b();
            if (r24 == null) goto L81;
            ECStoreApi.a.getClass();
            ECStoreApi r25 = ECStoreApi.a.a;
            if (r25 == null) goto L75;
            com.bytedance.android.ec.store.repository.vo.e r26 = r8.e();
            if (r26 == null) goto L73;
            String r27 = r26.e();
            if (r27 == null) goto L73;
        L74:
            r3 = r25.applyCouponForMiddleFloat(r22, "", r27, r24);
        L73:
            r27 = (String) r11.x.getStoreParam().getPassThroughParam("pass_through_api");
        L81:
            if (r13 != null) goto L83;
        L84:
            Unit r110 = Unit.INSTANCE;
            return;
        L83:
            if (((Unit) r13.invoke(new IllegalArgumentException("空数据 applyCouponSource"))) == null) goto L84;
            return;
        L85:
            if (r13 != null) goto L87;
        L88:
            Unit r111 = Unit.INSTANCE;
            return;
        L87:
            if (((Unit) r13.invoke(new IllegalArgumentException("空数据 applyCouponInfo"))) == null) goto L88;
            return;
        L46:
            if (r16.isEmpty() == false) goto L48;
        L42:
            r15 = null;
            goto L43
        L96:
            return;
        }
    }

    public static final class e implements ECShopCountdownTimerView.a {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;
        public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.h b;

        public final void a() {
        }

        public final void b() {
            ECShopMiddleCouponFilterPresenter r0 = this.a;
            com.bytedance.android.ec.store.repository.vo.h r1 = this.b;
            r0.getClass();
            if (r1 == null) goto L16;
            r1.b();
            r1.p(Boolean.FALSE);
            if (r1.i() != null) goto L8;
            r1.q(r0.t0(r1));
        L8:
            View r2 = r0.y();
            if ((r2 instanceof ECShopMiddleCouponFilterView) == true) goto L11;
            r2 = null;
        L11:
            ECShopMiddleCouponFilterView r3 = (ECShopMiddleCouponFilterView) r2;
            if (r3 == null) goto L17;
            r3.a(r1);
            return;
        L17:
            return;
        }

        public e(ECShopMiddleCouponFilterPresenter r1, com.bytedance.android.ec.store.repository.vo.h r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;
        public final /* synthetic */ ECShopMiddleCouponFilterView b;
        public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.h c;

        public f(ECShopMiddleCouponFilterPresenter r1, ECShopMiddleCouponFilterView r2, com.bytedance.android.ec.store.repository.vo.h r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r8) {
            ECShopMiddleCouponFilterPresenter r9 = this.a;
            ECShopMiddleCouponFilterView r0 = this.b;
            com.bytedance.android.ec.store.repository.vo.h r1 = this.c;
            r9.getClass();
            if (r0.f.getVisibility() != 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L16;
            com.bytedance.android.ec.store.repository.vo.g r3 = r9.t0(r1);
            if (r3 == null) goto L14;
            String r4 = r3.d();
            if (r4 == null) goto L15;
            com.bytedance.android.ec.sdk.helper.p r5 = com.bytedance.android.ec.sdk.helper.p.a;
            Context r6 = r9.y().getContext();
            ECStoreFoldPhoneHelper.b(r4);
            r5.openSchema(r6, r4);
            r9.v0(r0, "click_ecom_component", MapsKt.mapOf(new Pair[]{TuplesKt.to("coupon_status", String.valueOf(r1.k())), TuplesKt.to("click_button_type", "select_coupon_button")}));
            r9.w0(r0, "marketing_click", r1, MapsKt.mapOf(TuplesKt.to("click_attitude", "positive")));
            return;
        L15:
            return;
        L14:
            return;
        L16:
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ ECShopMiddleCouponFilterPresenter a;
        public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.h b;

        public g(ECShopMiddleCouponFilterPresenter r1, com.bytedance.android.ec.store.repository.vo.h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            com.bytedance.android.shopping.store.home.entity.n r7 = (com.bytedance.android.shopping.store.home.entity.n) r6;
            ECShopMiddleCouponFilterPresenter r0 = this.a;
            com.bytedance.android.ec.store.repository.vo.h r1 = this.b;
            String r2 = r0.x.getStoreParam().getShopId();
            if (r2 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            boolean r3 = true ^ r4;
            String r5 = null;
            if (r3 == true) goto L13;
            r2 = null;
        L13:
            if (r2 != null) goto L20;
            com.bytedance.android.shopping.store.home.entity.e r8 = r7.b;
            if (r8 == null) goto L17;
            r5 = r8.a;
        L17:
            if (r5 != null) goto L19;
            r2 = "";
            goto L20
        L19:
            r2 = r5;
        L20:
            r0.s0(r1, r2);
            return;
        L5:
            if (r2.length() == 0) goto L8;
            r4 = false;
            goto L9
        }
    }

    static {
    }

    public final void z0() {
        Iterator<com.bytedance.android.ec.store.repository.dto.c> r0 = this.w.getFilterSelectButtons().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().f(Boolean.FALSE);
        goto L4
    }

    public final void C() {
        s0.e(this);
        ECLiveHybridUtil.p("ecom.shop.dynamic_popup.remote_coupon_update", this.u);
        ECLiveHybridUtil.p("ecom.shop.dynamic_popup.close_dialog", this.v);
        View r0 = y();
        if ((r0 instanceof ECShopMiddleCouponFilterView) == true) goto L5;
        r0 = null;
    L5:
        ECShopMiddleCouponFilterView r1 = (ECShopMiddleCouponFilterView) r0;
        if (r1 == null) goto L9;
        ECShopCountdownTimerView r2 = r1.c;
        r2.c = false;
        r2.a.removeCallbacks(r2.k);
        r2.setVisibility(8);
        return;
    }

    public final void A(QModel r17) {
        s0.e(this);
        ECLiveHybridUtil.p("ecom.shop.dynamic_popup.remote_coupon_update", this.u);
        ECLiveHybridUtil.p("ecom.shop.dynamic_popup.close_dialog", this.v);
        s0.c(this);
        ECLiveHybridUtil.m("ecom.shop.dynamic_popup.remote_coupon_update", this.u);
        ECLiveHybridUtil.m("ecom.shop.dynamic_popup.close_dialog", this.v);
        View r1 = y();
        if ((r1 instanceof ECShopMiddleCouponFilterView) == true) goto L5;
        r1 = null;
    L5:
        ECShopMiddleCouponFilterView r2 = (ECShopMiddleCouponFilterView) r1;
        boolean r3 = false;
        if (r2 != null) goto L8;
    L7:
        QModel r4 = r17;
        if ((r4 instanceof com.bytedance.android.ec.store.repository.vo.h) == true) goto L16;
        r4 = null;
    L16:
        com.bytedance.android.ec.store.repository.vo.h r5 = (com.bytedance.android.ec.store.repository.vo.h) r4;
        if (r5 != null) goto L19;
        return;
    L19:
        int r6 = e0.a;
        if (ECShopABSettings.getEC_SHOP_TAB_INTERACTION_OPT() != 3) goto L22;
        r3 = true;
    L22:
        if (r3 == false) goto L24;
        this.x.getAnimator().a(3, new c(this));
    L24:
        this.w.setMiddleCouponFilterVO(r5);
        if (r5.i() == null) goto L27;
        this.w.setCachedCouponPanelInfo(r5.i());
    L29:
        if (r5.g() == null) goto L31;
        this.w.setCachedCouponMapData(r5.g());
    L33:
        if (r5.s() == false) goto L35;
        this.w.upDateSelectParams(r5.j());
    L35:
        View r7 = y();
        if ((r7 instanceof ECShopMiddleCouponFilterView) == true) goto L38;
        r7 = null;
    L38:
        ECShopMiddleCouponFilterView r8 = (ECShopMiddleCouponFilterView) r7;
        if (r8 != null) goto L41;
        return;
    L41:
        r8.a(r5);
        r8.getEcShopCouponStateButton().setOnClickListener(new d(this, r5));
        f r9 = new f(this, r8, r5);
        r8.getEcShopCouponSelectButton().setOnClickListener(r9);
        r8.setOnClickListener(r9);
        r8.getEcShopCouponTimerView().setCountdownListener(new e(this, r5));
        y0(r5);
        v0(r8, "show_ecom_component", MapsKt.mapOf(TuplesKt.to("coupon_status", String.valueOf(r5.k()))));
        w0(r8, "marketing_show", r5, null);
        return;
    L31:
        r5.o(this.w.getCachedCouponMapData());
        goto L33
    L27:
        r5.q(this.w.getCachedCouponPanelInfo());
        goto L29
    L8:
        ECShopCouponStateButton r10 = r2.getEcShopCouponStateButton();
        Pair[] r11 = new Pair[4];
        GradientDrawable[] r12 = new GradientDrawable[2];
        GradientDrawable r13 = new GradientDrawable();
        r13.setShape(0);
        r13.setCornerRadius(ExtensionsKt.a(24));
        r13.setColor((int) 4294901852L);
        Unit r14 = Unit.INSTANCE;
        r12[0] = r13;
        GradientDrawable r15 = new GradientDrawable();
        if (Build.VERSION.SDK_INT < 29) goto L11;
        r15.setColors(new int[]{(int) 4294940196L, 16736804}, new float[]{0.0f, 0.33f});
    L12:
        r15.setGradientType(0);
        r15.setOrientation(GradientDrawable.Orientation.TL_BR);
        r15.setCornerRadius(ExtensionsKt.a(24));
        r12[1] = r15;
        r11[0] = TuplesKt.to(CommentScene.COMMENTSCENE_NO_AWEME, new ECShopCouponStateButton.a("立即领", -1, new LayerDrawable(r12)));
        int r16 = (int) 4294901820L;
        GradientDrawable r18 = new GradientDrawable();
        r18.setShape(0);
        r18.setColor(-1);
        r18.setCornerRadius(ExtensionsKt.a(24));
        int r19 = (int) 4294928002L;
        r18.setStroke(ExtensionsKt.a(Double.valueOf(0.5d)), r19);
        r11[1] = TuplesKt.to("2", new ECShopCouponStateButton.a("筛选商品", r16, r18));
        GradientDrawable r20 = new GradientDrawable();
        r20.setShape(0);
        r20.setColor(0);
        r20.setCornerRadius(ExtensionsKt.a(24));
        r20.setStroke(ExtensionsKt.a(Double.valueOf(0.5d)), r19);
        r11[2] = TuplesKt.to("3", new ECShopCouponStateButton.a("取消筛选", r16, r20));
        r11[3] = TuplesKt.to("4", new ECShopCouponStateButton.a("券已失效", (int) 4287269777L, null));
        Map r21 = MapsKt.mapOf(r11);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r21, "configs");
        ((LinkedHashMap) r10.b).clear();
        r10.b.putAll(r21);
        goto L7
    L11:
        r15.setColors(new int[]{(int) 4294940196L, 16736804});
        r15.setGradientRadius(ExtensionsKt.a(17));
        goto L12
    }

    @Subscribe
    public final void handleUseCouponEvent(ui3.d r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        com.bytedance.android.ec.store.repository.vo.h r0 = this.w.getMiddleCouponFilterVO();
        if (r0 != null) goto L5;
        return;
    L5:
        String r6 = r5.a;
        Map<String, com.bytedance.android.ec.store.repository.vo.h> r1 = r0.g();
        if (r1 != null) goto L9;
        r1 = this.w.getCachedCouponMapData();
    L9:
        if (r1 == null) goto L11;
        com.bytedance.android.ec.store.repository.vo.h r2 = r1.get(r6);
    L12:
        if (r2 == null) goto L14;
        r2.d();
        r2.p(Boolean.FALSE);
        x0(r2);
        u0(r2);
        return;
    L14:
        dm.a.a("ECShopMiddleCouponFilter").w("handleUseCouponEvent() called with: couponId = " + r6 + ", not found coupon data", null);
        return;
    L11:
        r2 = null;
        goto L12
    }

    public final com.bytedance.android.ec.store.repository.vo.g t0(com.bytedance.android.ec.store.repository.vo.h r1) {
        if (r1 == null) goto L6;
        com.bytedance.android.ec.store.repository.vo.g r2 = r1.i();
        if (r2 == null) goto L6;
        return r2;
    L6:
        return this.w.getCachedCouponPanelInfo();
    }

    public final void u0(com.bytedance.android.ec.store.repository.vo.h r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        View r0 = y();
        if ((r0 instanceof ECShopMiddleCouponFilterView) == true) goto L7;
        r0 = null;
    L7:
        ECShopMiddleCouponFilterView r1 = (ECShopMiddleCouponFilterView) r0;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.a(r3);
    }

    public final void x0(com.bytedance.android.ec.store.repository.vo.h r2) {
        if (r2.i() != null) goto L5;
        r2.q(t0(r2));
    L5:
        com.bytedance.android.ec.store.repository.vo.h r0 = this.w.getMiddleCouponFilterVO();
        if (r0 == null) goto L9;
        r0.t(r2);
        return;
    }

    public final void y0(com.bytedance.android.ec.store.repository.vo.h r5) {
        String r0 = this.x.getStoreParam().getShopId();
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        this.x.getHeaderArea().a(W(), new g(this, r5), false);
        return;
    L11:
        s0(r5, r0);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    public static final void q0(ECShopMiddleCouponFilterPresenter r2, com.bytedance.android.ec.store.repository.dto.d r3) {
        r2.getClass();
        String r4 = r3.c();
        if (r4 == null) goto L8;
        Type r0 = new i().getType();
        int r1 = t0.a;     // Catch: JSONException -> L16
        Map<String, com.bytedance.android.ec.store.repository.vo.h> r5 = (Map) GsonProtectorUtils.fromJson(t0.a.a, r4, r0);     // Catch: JSONException -> L16
    L9:
        if (r5 == null) goto L19;
        com.bytedance.android.ec.store.repository.vo.h r6 = r2.w.getMiddleCouponFilterVO();
        if (r6 == null) goto L14;
        r6.o(r5);
    L14:
        r2.w.setCachedCouponMapData(r5);
        return;
    L19:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public static final void r0(ECShopMiddleCouponFilterPresenter r4, com.bytedance.android.ec.store.repository.dto.d r5) {
        r4.getClass();
        String r6 = r5.c();
        if (r6 != null) goto L53;
    L9:
        com.bytedance.android.ec.store.repository.vo.g r7 = null;
    L10:
        if (r7 == null) goto L57;
        com.bytedance.android.ec.store.repository.vo.h r0 = r4.w.getMiddleCouponFilterVO();
        if (r0 == null) goto L23;
        com.bytedance.android.ec.store.repository.vo.g r1 = r0.i();
        if (r1 == null) goto L17;
        r1.g(r7.b());
    L17:
        com.bytedance.android.ec.store.repository.vo.g r2 = r0.i();
        if (r2 == null) goto L20;
        r2.h(r7.c());
    L20:
        com.bytedance.android.ec.store.repository.vo.g r3 = r0.i();
        if (r3 == null) goto L23;
        r3.f(r7.a());
    L23:
        com.bytedance.android.ec.store.repository.vo.g r8 = r4.w.getCachedCouponPanelInfo();
        if (r8 == null) goto L26;
        r8.g(r7.b());
    L26:
        com.bytedance.android.ec.store.repository.vo.g r9 = r4.w.getCachedCouponPanelInfo();
        if (r9 == null) goto L29;
        r9.h(r7.c());
    L29:
        com.bytedance.android.ec.store.repository.vo.g r10 = r4.w.getCachedCouponPanelInfo();
        if (r10 == null) goto L32;
        r10.f(r7.a());
    L32:
        String r11 = r7.d();
        if (r11 != null) goto L35;
    L38:
        boolean r12 = true;
    L39:
        if (r12 == true) goto L51;
        String r13 = String.valueOf(r7.c());
        r11 = l0.c(UriProtector.parse(r11), "mega_object_id", r13).toString();     // Catch: Throwable -> L43
    L44:
        if (r0 == null) goto L48;
        com.bytedance.android.ec.store.repository.vo.g r14 = r0.i();
        if (r14 == null) goto L48;
        r14.i(r11);
    L48:
        com.bytedance.android.ec.store.repository.vo.g r15 = r4.w.getCachedCouponPanelInfo();
        if (r15 == null) goto L51;
        r15.i(r11);
    L51:
        r4.y0(r0);
        return;
    L35:
        if (r11.length() == 0) goto L38;
        r12 = false;
        goto L39
    L57:
        return;
    L53:
        int r16 = t0.a;     // Catch: Throwable -> L7
        r7 = (com.bytedance.android.ec.store.repository.vo.g) t0.a.a.fromJson(r6, com.bytedance.android.ec.store.repository.vo.g.class);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        dm.a.a("ECShopMiddleCouponFilter").w("parseShopCouponPanelData() called", th);
        goto L9
    }

    public final void s0(com.bytedance.android.ec.store.repository.vo.h r9, String r10) {
        com.bytedance.android.ec.store.repository.vo.g r0 = t0(r9);
        if (r0 == null) goto L19;
        Long r1 = r0.c();
        if (r1 == null) goto L20;
        long r2 = r1.longValue();
        com.bytedance.android.ec.store.repository.vo.g r11 = t0(r9);
        if (r11 == null) goto L21;
        Map r12 = r11.b();
        if (r12 == null) goto L22;
        HashMap r3 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        String r4 = String.valueOf(r2);
        JSONObject r6 = new JSONObject();     // Catch: Throwable -> L14
        r6.put("bottom_button", r12.get("bottom_button"));     // Catch: Throwable -> L14
        r6.put("count_down", r12.get("count_down"));     // Catch: Throwable -> L14
        r6.put("first_page_count", r12.get("first_page_count"));     // Catch: Throwable -> L14
        r6.put("total_count", r12.get("total_count"));     // Catch: Throwable -> L14
        r6.put("max_count", r12.get("max_count"));     // Catch: Throwable -> L14
        r6.put("activity_coupon_list", r12.get("module_list"));     // Catch: Throwable -> L14
        r6.put("shop_id", r10);     // Catch: Throwable -> L14
    L15:
        com.bytedance.android.ec.core.hybrid.utils.j.h(r4, r6);
        return;
    L14:
        r6 = new JSONObject();
        goto L15
    L22:
        return;
    L21:
        return;
    L20:
        return;
    }

    public ECShopMiddleCouponFilterPresenter(Fragment r2, ECShopHybridProductViewModel r3, ECStoreViewModel r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "hybridProductViewModel");
        Intrinsics.checkNotNullParameter(r4, "storeViewModel");
        super(r2);
        this.w = r3;
        this.x = r4;
        this.u = new ECShopMiddleCouponFilterPresenter$couponUpdateEventSubscriber$1(this);
        this.v = new b(this);
    }

    public final void v0(ECShopMiddleCouponFilterView r11, String r12, Map r13) {
        Map<String, ? extends Object> r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("store_type", "shop"), TuplesKt.to("author_id", T().getStoreParam().getStoreAccountParam().getUserId()), TuplesKt.to("shop_id", T().getStoreParam().getShopId()), TuplesKt.to("follow_status", String.valueOf(T().getStoreParam().getFollowStatus())), TuplesKt.to("entrance_location", T().getStoreParam().getEntranceLocation()), TuplesKt.to("store_source_page", T().getStoreParam().getStoreSourcePage()), TuplesKt.to("module_name", "middle_coupon"), TuplesKt.to("store_source_method", T().getStoreParam().getStoreSourceMethod()), TuplesKt.to("store_group_type", T().getStoreParam().getStoreGroupType()), TuplesKt.to("tab_name", "products")});
        if (r13 == null) goto L5;
        r8.putAll(r13);
    L5:
        T().doAnyEventActionWithBtm("a1.b6269.c70930", PageFinder.via(r11), r12, r8, new Pair[0]);
    }

    public final void w0(ECShopMiddleCouponFilterView r9, String r10, com.bytedance.android.ec.store.repository.vo.h r11, Map r12) {
        PageFinder r13 = PageFinder.via(r9);
        Pair[] r6 = new Pair[2];
        com.bytedance.android.ec.store.repository.vo.e r14 = r11.e();
        if (r14 == null) goto L11;
        List r15 = r14.c();
        if (r15 == null) goto L11;
        Map r16 = (Map) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L11;
        Object r17 = r16.get("bcm_em_id");
        if (r17 == null) goto L11;
        String r18 = r17.toString();
    L12:
        r6[0] = TuplesKt.to("bcm_em_id", r18);
        r6[1] = TuplesKt.to("bcm_chain", BtmSDK.getBcmChainByFinder$default(BtmSDK.INSTANCE, r13, 0, false, 6, null));
        Map<String, ? extends Object> r4 = MapsKt.mutableMapOf(r6);
        if (r12 == null) goto L15;
        r4.putAll(r12);
    L15:
        T().doAnyEventActionWithBtm("a1.b6269.c70930", r13, r10, r4, new Pair[0]);
        return;
    L11:
        r18 = null;
        goto L12
    }
}
