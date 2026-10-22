package com.bytedance.android.shopping.store.home.presenter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.store.common.param.StoreAccountParam;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.ec.store.repository.vo.ECTagListDTO;
import com.bytedance.android.ec.store.view.ECTagListView;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView;
import com.bytedance.android.shopping.store.slicecard.SliceItemType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t2 extends ECShopBasePresenter implements View.OnClickListener {
    public final c A;
    public final int u;
    public ViewGroup v;
    public ViewGroup w;
    public LottieAnimationView x;
    public ViewGroup y;
    public ValueAnimator z;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ t2 a;

        public b(t2 r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r1v8, types: [android.widget.TextView, com.bytedance.android.shopping.store.home.view.ECShopMarqueeTextView] */
        public final void onChanged(Object r21) {
            com.bytedance.android.shopping.store.home.entity.n r1 = (com.bytedance.android.shopping.store.home.entity.n) r21;
            if (r1.d() == false) goto L5;
        L85:
            this.a.y().setVisibility(8);
            return;
        L5:
            if (r1.c() == true) goto L85;
            t2 r2 = this.a;
            View r4 = r2.w().b(2131370882).f();
            r4.setVisibility(0);
            r4.setOnClickListener(r2);
            SimpleDraweeView r5 = r2.w().b(2131370880).f();
            com.bytedance.android.shopping.store.home.entity.e r6 = r1.b;
            String r7 = null;
            if (r6 == null) goto L10;
            ECUrlModel r8 = r6.c;
        L11:
            ECShopBasePresenter.Y(r2, r5, r8);
            r2.T().doEventAction("store_bind_author_show", (Pair[]) Arrays.copyOf(h4.a(r2.T(), "fold"), 8));
            r2.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.f.class), new w2(r2));
            t2 r3 = this.a;
            r3.getClass();
            com.bytedance.android.shopping.store.home.slice.d r9 = r1.o;
            if (r9 == null) goto L27;
            Map<String, ECStoreHeaderInfoSliceConfig> r10 = r9.a;
            if (r10 == null) goto L27;
            ECStoreHeaderInfoSliceConfig r11 = r10.get(SliceItemType.SHOP_PROFILE.getType());
            if (r11 == null) goto L27;
            SimpleDraweeView r12 = com.bytedance.android.ec.store.product.presenter.utils.f.a(r3.w().b(2131370881));
            Map<String, Object> r13 = r11.getSliceItemStates();
            if (r13 == null) goto L20;
            Object r14 = r13.get("shop_is_living");
        L22:
            if (Intrinsics.areEqual(r14, Boolean.TRUE) == false) goto L25;
            if (r12 == null) goto L27;
            ECShopBasePresenter.Y(r3, r12, com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.c.a(38, 38, "https://lf3-static.bytednsdoc.com/obj/eden-cn/wvoz_j_tvjl/ljhwZthlaukjlkulzlp/living/live_breathing_border.webp"));
            goto L27
        L25:
            if (r12 == null) goto L27;
            r12.setVisibility(8);
            goto L27
        L20:
            r14 = null;
        L27:
            t2 r15 = this.a;
            ECStoreViewModel r16 = r15.T();
            BtmSDK r17 = BtmSDK.INSTANCE;
            uj3.j r18 = r15.T().getCurrentTab();
            if (r18 != null) goto L30;
        L32:
            String r19 = "a1.b6269.c5887.d3193";
        L33:
            Map r20 = r17.createReportParams(r19, PageFinder.via(r15.y()));
            ArrayList r22 = new ArrayList(r20.size());
            Iterator r23 = r20.entrySet().iterator();
        L35:
            if (r23.hasNext() == false) goto L37;
            Map.Entry r110 = (Map.Entry) r23.next();
            r22.add(TuplesKt.to(r110.getKey(), String.valueOf(r110.getValue())));
            goto L35
        L37:
            Map<String, String> r24 = MapsKt.toMap(r22);
            SpreadBuilder r25 = new SpreadBuilder(2);
            r25.add(TuplesKt.to("position", "fold"));
            int r111 = com.bytedance.android.shopping.store.home.d0.a;
            r25.addSpread(com.bytedance.android.shopping.store.home.d0.a(r15.T()));
            r16.doEventAction("store_experience_score_show", r24, (Pair[]) r25.toArray(new Pair[r25.size()]));
            this.a.T().getSelectedTabLocation().a(this.a.W(), new z2(this), false);
            this.a.T().getUpglideFactor().a(this.a.W(), new a3(this), false);
            t2 r26 = this.a;
            ECTagListView r27 = com.bytedance.android.ec.store.product.presenter.utils.f.a(r26.w().b(2131371097));
            if (r27 == null) goto L44;
            r27.setVisibility(0);
            com.bytedance.android.shopping.store.home.entity.e r28 = r1.b;
            if (r28 == null) goto L44;
            ECTagListDTO r112 = r28.p;
            if (r112 == null) goto L44;
            ECTagListView.c(r27, r112, Integer.valueOf(r26.u), MapsKt.toMutableMap(com.bytedance.android.ec.store.utils.m.b(r26.T().getBaseParams())), null, null, null, 56);
        L44:
            if (r27 == null) goto L46;
            r27.setOnClickListener(r26);
        L46:
            ECStoreViewModel r29 = r26.T();
            Pair<String, String>[] r30 = new Pair[3];
            r30[0] = TuplesKt.to("subject", "user");
            r30[1] = TuplesKt.to("position", "fold");
            com.bytedance.android.shopping.store.home.entity.e r31 = r1.b;
            if (r31 == null) goto L53;
            AuthorReputationVO r32 = r31.d;
            if (r32 == null) goto L53;
            Double r33 = r32.getScore();
            if (r33 == null) goto L53;
            String r34 = String.valueOf(r33.doubleValue());
        L54:
            r30[2] = TuplesKt.to("score", r34);
            r29.doEventAction("author_sell_score_show", r30);
            t2 r35 = this.a;
            com.bytedance.android.shopping.store.home.entity.e r36 = r1.b;
            if (r36 == null) goto L59;
            com.bytedance.android.shopping.store.home.entity.v r37 = r36.h;
            if (r37 == null) goto L59;
            String r38 = r37.a();
        L60:
            com.bytedance.android.shopping.store.home.entity.e r39 = r1.b;
            if (r39 == null) goto L65;
            com.bytedance.android.shopping.store.home.entity.v r40 = r39.h;
            if (r40 == null) goto L65;
            r7 = r40.b();
        L65:
            ?? r41 = (ECShopMarqueeTextView) com.bytedance.android.ec.store.product.presenter.utils.f.a(r35.w().b(2131371088));
            if (r41 == 0) goto L68;
            r41.post(new x2(r41, r35, r38, r7));
        L68:
            if (r41 == 0) goto L70;
            r41.setOnClickListener(r35);
        L70:
            r35.T().getViewTransitShipment().d(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.store.viewmodel.g.class), new y2(r35, r41));
            t2 r42 = this.a;
            LottieAnimationView r43 = r42.x;
            if (r43 == null) goto L73;
            r43.setAnimation("ec_shop_follow_animation.json");
        L73:
            LottieAnimationView r44 = r42.x;
            if (r44 == null) goto L76;
            r44.addAnimatorListener(new u2(r42));
        L76:
            ValueAnimator r45 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            r42.z = r45;
            if (r45 == null) goto L79;
            r45.setDuration(200);
        L79:
            ValueAnimator r46 = r42.z;
            if (r46 == null) goto L82;
            r46.addUpdateListener(new v2(r42));
        L82:
            ViewGroup r47 = r42.y;
            if (r47 == null) goto L88;
            r47.setOnClickListener(r42);
            return;
        L88:
            return;
        L59:
            r38 = null;
        L53:
            r34 = null;
            goto L54
        L30:
            if (r18.j() != true) goto L32;
            r19 = "a1.b0715.c722556";
            goto L33
        L10:
            r8 = null;
            goto L11
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ t2 a;

        public c(t2 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            com.bytedance.android.shopping.store.home.a0 r7 = (com.bytedance.android.shopping.store.home.a0) r6;
            t2 r0 = this.a;
            boolean r1 = r7.a;
            LottieAnimationView r2 = r0.x;
            if (r2 == null) goto L7;
            if (r1 == true) goto L6;
            r2.setVisibility(8);
            goto L7
        L6:
            r2.setVisibility(0);
        L7:
            ViewGroup r3 = r0.w;
            if (r3 != null) goto L10;
        L12:
            boolean r4 = false;
        L13:
            if (r4 == r1) goto L21;
            ViewGroup r5 = r0.w;
            if (r5 == null) goto L21;
            if (r1 == true) goto L19;
            r5.setVisibility(8);
            goto L21
        L19:
            r5.setVisibility(0);
            r5.setOnClickListener(new b3(r0));
        L21:
            if (r7.b == false) goto L24;
            t2.q0(this.a, r7.e);
            return;
        L24:
            if (r7.c == false) goto L28;
            t2.q0(this.a, r7.e);
            return;
        L28:
            return;
        L10:
            if (r3.getVisibility() != 0) goto L12;
            r4 = true;
            goto L13
        }
    }

    static {
    }

    public t2(Fragment r1) {
        super(r1);
        this.u = com.bytedance.android.shopping.extensions.b.b(80);
        this.A = new c(this);
    }

    public static final void r0(t2 r6) {
        if (r6.T().needShopProfilePin2Top() == true) goto L7;
        ViewGroup r7 = r6.v;
        if (r7 == null) goto L40;
        r7.setVisibility(8);
        return;
    L40:
        return;
    L7:
        Float r0 = (Float) r6.T().getUpglideFactor().getValue();
        if (r0 == null) goto L10;
        float r1 = r0.floatValue();
    L11:
        float r2 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r1, 0.0f), 1.0f);
        if (r2 >= 0.75f) goto L16;
        ViewGroup r8 = r6.v;
        if (r8 == null) goto L42;
        r8.setVisibility(8);
        return;
    L42:
        return;
    L16:
        ViewGroup r3 = r6.v;
        if (r3 == null) goto L19;
        r3.setVisibility(0);
    L19:
        ViewGroup r4 = r6.v;
        if (r4 == null) goto L22;
        r4.setAlpha((r2 - 0.75f) * 4.0f);
    L22:
        ViewGroup r5 = r6.v;
        if (r5 == null) goto L25;
        r5.requestLayout();
    L25:
        ViewGroup r9 = r6.y;
        if (r9 == null) goto L28;
        r9.setAlpha(0.0f);
    L28:
        ValueAnimator r10 = r6.z;
        if (r10 == null) goto L32;
        r10.cancel();
    L32:
        if (r2 != 1.0f) goto L44;
        ViewGroup r11 = r6.v;
        if (r11 == null) goto L36;
        r11.setAlpha(1.0f);
    L36:
        ValueAnimator r12 = r6.z;
        if (r12 == null) goto L45;
        r12.start();
        return;
    L45:
        return;
    L44:
        return;
    L10:
        r1 = 0.0f;
        goto L11
    }

    public final void A(QModel r4) {
        this.v = (ViewGroup) w().b(2131371159).f();
        this.w = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371087));
        this.x = com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371085));
        this.y = (ViewGroup) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(2131371082));
        ViewGroup r5 = this.v;
        if (r5 == null) goto L5;
        r5.setVisibility(4);
    L5:
        T().getHeaderArea().a(W(), new b(this), false);
        T().getFollowConfigLiveData().a(W(), this.A, false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        int r0 = kn.a.a;
        if (kn.a.a(r8.getId()) == false) goto L7;
        return;
    L7:
        if (U() == true) goto L9;
    L11:
        int r9 = r8.getId();
        if (r9 != 2131370882) goto L54;
        int r10 = com.bytedance.android.shopping.store.home.d0.a;
        ECStoreViewModel r11 = T();
        View r1 = y();
        ECStoreViewModel r3 = T();
        Context r4 = u().c();
        Map r2 = MapsKt.mapOf(TuplesKt.to("position", "fold"));
        Intrinsics.checkNotNullParameter(r11, "eventReporter");
        Intrinsics.checkNotNullParameter(r1, "v");
        Intrinsics.checkNotNullParameter(r3, "storeViewModel");
        Intrinsics.checkNotNullParameter(r4, "context");
        jm.a<com.bytedance.android.shopping.store.home.entity.n> r5 = r3.getHeaderArea();
        if (r5 == null) goto L22;
        com.bytedance.android.shopping.store.home.entity.n r6 = (com.bytedance.android.shopping.store.home.entity.n) r5.getValue();
        if (r6 == null) goto L22;
        com.bytedance.android.shopping.store.home.entity.d r7 = r6.c;
        if (r7 == null) goto L22;
        if (r7.d != true) goto L22;
        com.bytedance.android.shopping.store.home.d0.c(r11, r1, r3, r4, r2);
        return;
    L22:
        ECStoreParam r12 = r3.getStoreParam();
        if (r12 == null) goto L27;
        String r13 = r12.getStoreHomePageUrl();
        if (r13 == null) goto L27;
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(r4, r13);
    L27:
        Pair[] r14 = new Pair[6];
        ECStoreParam r15 = r3.getStoreParam();
        Integer r16 = null;
        if (r15 == null) goto L30;
        String r17 = r15.getShopId();
    L31:
        r14[0] = TuplesKt.to("shop_id", r17);
        ECStoreParam r18 = r3.getStoreParam();
        if (r18 == null) goto L36;
        StoreAccountParam r19 = r18.getStoreAccountParam();
        if (r19 == null) goto L36;
        String r20 = r19.getUserId();
    L37:
        r14[1] = TuplesKt.to("author_id", r20);
        ECStoreParam r21 = r3.getStoreParam();
        if (r21 == null) goto L40;
        String r22 = r21.getStoreSourceMethod();
    L41:
        r14[2] = TuplesKt.to("store_source_method", r22);
        ECStoreParam r23 = r3.getStoreParam();
        if (r23 == null) goto L44;
        String r24 = r23.getStoreGroupType();
    L45:
        r14[3] = TuplesKt.to("store_group_type", r24);
        ECStoreParam r25 = r3.getStoreParam();
        if (r25 == null) goto L48;
        String r26 = r25.getStoreSourcePage();
    L49:
        r14[4] = TuplesKt.to("store_source_page", r26);
        ECStoreParam r27 = r3.getStoreParam();
        if (r27 == null) goto L52;
        r16 = r27.getFollowStatus();
    L52:
        r14[5] = TuplesKt.to("follow_status", String.valueOf(r16));
        r11.doAnyEventAction("store_bind_author_click", r2, r14);
        com.bytedance.android.shopping.store.home.d0.d(r11, r3, "103", r2);
        return;
    L48:
        r26 = null;
        goto L49
    L44:
        r24 = null;
        goto L45
    L40:
        r22 = null;
    L36:
        r20 = null;
        goto L37
    L30:
        r17 = null;
        goto L31
    L54:
        if (r9 != 2131371087) goto L61;
        ECStoreViewModel r28 = T();
        if (r28 == null) goto L72;
        com.bytedance.android.shopping.store.home.y r29 = r28.getIShopInfoAreaAbility();
        if (r29 == null) goto L73;
        r29.a();
        return;
    L73:
        return;
    L72:
        return;
    L61:
        if (r9 != 2131371082) goto L67;
        ECStoreViewModel r30 = T();
        if (r30 == null) goto L75;
        com.bytedance.android.shopping.store.home.y r31 = r30.getIShopInfoAreaAbility();
        if (r31 == null) goto L76;
        r31.a();
        return;
    L76:
        return;
    L75:
        return;
    L67:
        int r32 = com.bytedance.android.shopping.store.home.d0.a;
        com.bytedance.android.shopping.store.home.d0.c(T(), y(), T(), u().c(), MapsKt.mapOf(TuplesKt.to("position", "fold")));
        return;
    L9:
        if (y().getAlpha() > 0.2f) goto L11;
    }

    public static final void q0(t2 r0, boolean r1) {
        if (r1 == false) goto L10;
        LottieAnimationView r2 = r0.x;
        if (r2 != null) goto L6;
        return;
    L6:
        if (r2.getVisibility() != 0) goto L15;
        LottieAnimationView r3 = r0.x;
        if (r3 == null) goto L16;
        r3.playAnimation();
        return;
    L16:
        return;
    L15:
        return;
    L10:
        ViewGroup r4 = r0.y;
        if (r4 == null) goto L18;
        r4.setVisibility(0);
        return;
    }
}
