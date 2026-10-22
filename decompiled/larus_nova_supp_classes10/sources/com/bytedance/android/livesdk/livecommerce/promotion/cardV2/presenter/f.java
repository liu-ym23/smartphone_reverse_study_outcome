package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.widget.ECConstrainLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.Product;
import com.bytedance.android.ec.model.response.PromotionExtendType;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.i0;
import com.bytedance.android.ec.model.response.j1;
import com.bytedance.android.ec.model.response.q0;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardBottomComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardButtonComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardImageComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardInfoComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardPriceComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardTitleComponent;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.PromotionCardInfoLineContainer;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.utils.HotAtmosphereHelperV2;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import mh2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends QPresenter {
    public com.bytedance.android.livesdk.livecommerce.promotion.card.h e;
    public boolean f;
    public boolean g;
    public final LivePromotionCardArgsV2 h;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a i;
    public final Map<PromotionCardModuleName, Integer> j;

    public final void E() {
        if (this.f == false) goto L5;
        this.g = true;
    L5:
        D(false);
        ((PromotionCardPriceComponent) w().b(2131367779).f()).c();
        PromotionCardInfoComponent r0 = (PromotionCardInfoComponent) w().b(2131378719).f();
        Iterator r1 = ((ArrayList) r0.a).iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        PromotionCardInfoLineContainer r2 = (PromotionCardInfoLineContainer) r1.next();
        if (r2.getVisibility() == 8) goto L7;
        r2.setVisibility(8);
        goto L7
    L11:
        Iterator r3 = ((ArrayList) r0.a).iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        ((PromotionCardInfoLineContainer) r3.next()).d();
        goto L13
    L15:
        PromotionCardImageComponent r4 = (PromotionCardImageComponent) w().b(2131377867).f();
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCardNoImage() == false) goto L18;
        r4.d.setImageBitmap(null);
        r4.d.a();
    L18:
        HotAtmosphereHelperV2 r5 = r4.p;
        if (r5 == null) goto L33;
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.c(r5);
        Runnable r6 = r5.h;
        if (r6 == null) goto L23;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r6);
    L23:
        Runnable r7 = r5.h;
        if (r7 == null) goto L26;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r7);
    L26:
        r5.h = null;
        Runnable r8 = r5.i;
        if (r8 == null) goto L29;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r8);
    L29:
        Runnable r9 = r5.i;
        if (r9 == null) goto L32;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r9);
    L32:
        r5.i = null;
    L33:
        Disposable r10 = ((PromotionCardTitleComponent) w().b(2131391606).f()).a;
        if (r10 == null) goto L43;
        r10.dispose();
        return;
    }

    public final void F() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ql.a r1 = r0.a.a;
        jj2.a r3 = null;
        if ((r1 instanceof ECUIPromotionV2) == true) goto L8;
        r1 = null;
    L8:
        ECUIPromotionV2 r2 = (ECUIPromotionV2) r1;
        if (r2 == null) goto L13;
        g1 r5 = r2.getPurchase();
        if (r5 == null) goto L13;
        r3 = new jj2.a(r5, r0.b, r0.c, r2.getPromotionId(), r2.getProductId(), r2.getIronIndex());
    L13:
        if (r3 == null) goto L16;
        ((PromotionCardButtonComponent) w().b(2131377852).f()).b(r3);
        return;
    }

    public final void G() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ql.a r2 = r1.a.a;
        jj2.c r4 = null;
        if ((r2 instanceof ECUIPromotionV2) == true) goto L8;
        r2 = null;
    L8:
        ECUIPromotionV2 r3 = (ECUIPromotionV2) r2;
        if (r3 == null) goto L27;
        z0 r6 = r3.getImage();
        if (r6 == null) goto L27;
        UpdateType r7 = r1.b;
        k r8 = r1.c;
        String r9 = r1.a.a.getPromotionId();
        String r10 = r1.a.a.getProductId();
        boolean r11 = r1.a.a.isOnExplaining();
        int r12 = r1.a.a.getIronIndex();
        boolean r13 = r1.a.a.isAuction();
        ECPromotionAuctionInfo r14 = r1.a.a.getAuctionInfo();
        LiveRoomParams r5 = r1.a.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r5 == null) goto L18;
        String r15 = r5.getRoomId();
        if (r15 == null) goto L18;
        String r16 = r15;
    L19:
        LiveRoomParams r17 = r1.a.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r17 == null) goto L25;
        String r18 = r17.getRoomUniqueKey();
        if (r18 == null) goto L25;
        String r19 = r18;
    L26:
        r4 = new jj2.c(r6, r7, r8, r9, r10, r11, r12, r13, r14, r16, r19, !r1.a.a.getClientData().b, r1.a.a.getHasPreferredCouponEffect());
    L25:
        r19 = "";
    L18:
        r16 = "";
    L27:
        if (r4 == null) goto L30;
        ((PromotionCardImageComponent) w().b(2131377867).f()).b(r4);
        return;
    }

    public final void I() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        IPromotionUIConfig.d r2 = r1.c.a(PromotionCardModuleName.InfoAreaModule);
        if (r2 == null) goto L8;
        Boolean r3 = r2.d();
    L10:
        if (Intrinsics.areEqual(r3, Boolean.FALSE) == false) goto L18;
        Iterator r4 = ((ArrayList) ((PromotionCardInfoComponent) w().b(2131378719).f()).a).iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        PromotionCardInfoLineContainer r5 = (PromotionCardInfoLineContainer) r4.next();
        if (r5.getVisibility() == 8) goto L13;
        r5.setVisibility(8);
        goto L13
    L17:
        return;
    L18:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r6 = this.e;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L21:
        ql.a r7 = r6.a.a;
        if ((r7 instanceof ECUIPromotionV2) == true) goto L24;
        r7 = null;
    L24:
        ECUIPromotionV2 r8 = (ECUIPromotionV2) r7;
        int r9 = 0;
        if (r8 == null) goto L37;
        q0 r10 = r8.getBenefits();
        if (r10 == null) goto L37;
        UpdateType r11 = r6.b;
        k r12 = r6.c;
        Product r13 = r8.getProduct();
        if (r13 == null) goto L31;
        boolean r14 = r13.isAuction();
    L32:
        Product r15 = r8.getProduct();
        if (r15 == null) goto L35;
        long r16 = r15.getAuctionType();
    L36:
        jj2.d r17 = new jj2.d(r10, r11, r12, r14, r16);
    L38:
        if (r17 == null) goto L137;
        PromotionCardInfoComponent r18 = (PromotionCardInfoComponent) w().b(2131378719).f();
        Intrinsics.checkNotNullParameter(r17, "model");
        List r19 = r17.a.a();
        if (r19 == null) goto L110;
        Iterator r20 = r19.iterator();
        int r21 = 0;
    L43:
        if (r20.hasNext() == false) goto L110;
        Object r22 = r20.next();
        int r23 = r21 + 1;
        if (r21 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();
    L47:
        i0 r110 = (i0) r22;
        Integer r24 = Integer.valueOf(((ArrayList) r18.a).size());
        if (r24.intValue() > r21) goto L50;
        boolean r25 = true;
    L51:
        if (r25 == true) goto L54;
        r24 = null;
    L54:
        if (r24 == null) goto L101;
        r24.intValue();
        PromotionCardInfoLineContainer r26 = new PromotionCardInfoLineContainer(r18.getContext(), null, r18.c, r18.b, 10);
        ((ArrayList) r18.a).add(r26);
        r26.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (r21 == 0) goto L100;
        ViewGroup.LayoutParams r27 = r26.getLayoutParams();
        if ((r27 instanceof ViewGroup.MarginLayoutParams) == true) goto L60;
        r27 = null;
    L60:
        ViewGroup.MarginLayoutParams r28 = (ViewGroup.MarginLayoutParams) r27;
        if (r28 == null) goto L63;
        r28.topMargin = UtilityKotlinExtentionsKt.d(4);
        r26.setLayoutParams(r28);
    L63:
        IPromotionUIConfig.d r29 = r17.c.a(PromotionCardModuleName.InfoAreaInnerModule);
        if (r29 == null) goto L100;
        IPromotionUIConfig.c r30 = r29.b();
        if (r30 == null) goto L100;
        int r111 = UIConfigHelper.a;
        Intrinsics.checkNotNullParameter(r26, "view");
        Intrinsics.checkNotNullParameter(r30, "layout");
        Integer r112 = r30.k();
        if (r112 == null) goto L70;
        int r113 = UtilityKotlinExtentionsKt.d(r112);
    L71:
        Integer r114 = r30.m();
        if (r114 == null) goto L74;
        int r115 = UtilityKotlinExtentionsKt.d(r114);
    L75:
        Integer r116 = r30.l();
        if (r116 == null) goto L78;
        int r117 = UtilityKotlinExtentionsKt.d(r116);
    L79:
        Integer r118 = r30.j();
        if (r118 == null) goto L82;
        int r119 = UtilityKotlinExtentionsKt.d(r118);
    L83:
        r26.setPadding(r113, r115, r117, r119);
        Integer r120 = r30.g();
        if (r120 == null) goto L86;
        int r121 = UtilityKotlinExtentionsKt.d(r120);
    L87:
        Integer r122 = r30.i();
        if (r122 == null) goto L90;
        int r123 = UtilityKotlinExtentionsKt.d(r122);
    L91:
        Integer r124 = r30.h();
        if (r124 == null) goto L94;
        int r125 = UtilityKotlinExtentionsKt.d(r124);
    L95:
        Integer r31 = r30.f();
        if (r31 == null) goto L98;
        int r32 = UtilityKotlinExtentionsKt.d(r31);
    L99:
        wg.a.f(r26, r121, r123, r125, r32);
        goto L100
    L98:
        r32 = 0;
        goto L99
    L94:
        r125 = 0;
        goto L95
    L90:
        r123 = 0;
        goto L91
    L86:
        r121 = 0;
        goto L87
    L82:
        r119 = 0;
        goto L83
    L78:
        r117 = 0;
        goto L79
    L74:
        r115 = 0;
        goto L75
    L70:
        r113 = 0;
    L100:
        r18.addView(r26);
    L101:
        PromotionCardInfoLineContainer r126 = (PromotionCardInfoLineContainer) CollectionsKt.getOrNull(r18.a, r21);
        if (r126 == null) goto L104;
        r126.b(r110, r17.d, r17.e, r17.c);
    L104:
        PromotionCardInfoLineContainer r33 = (PromotionCardInfoLineContainer) CollectionsKt.getOrNull(r18.a, r21);
        if (r33 == null) goto L109;
        if (r33.getVisibility() == 0) goto L109;
        r33.setVisibility(0);
    L109:
        r21 = r23;
        goto L43
    L50:
        r25 = false;
    L110:
        List r34 = r17.a.a();
        if (r34 == null) goto L113;
        r9 = r34.size();
    L113:
        ArrayList r35 = (ArrayList) r18.a;
        Iterator r36 = r35.subList(r9, r35.size()).iterator();
    L115:
        if (r36.hasNext() == false) goto L119;
        PromotionCardInfoLineContainer r37 = (PromotionCardInfoLineContainer) r36.next();
        if (r37.getVisibility() == 8) goto L115;
        r37.setVisibility(8);
        goto L115
    L119:
        IPromotionUIConfig.d r38 = r17.c.a(PromotionCardModuleName.InfoAreaModule);
        if (r38 == null) goto L138;
        UIConfigHelper.d(r18, r38);
        return;
    L138:
        return;
    L137:
        return;
    L35:
        r16 = 0;
        goto L36
    L31:
        r14 = false;
    L37:
        r17 = null;
        goto L38
    L8:
        r3 = null;
        goto L10
    }

    public final void C() {
        E();
    }

    /* JADX WARN: Type inference failed for: r0v62, types: [android.view.View, android.widget.TextView, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component.PromotionCardTitleComponent] */
    public final void A(QModel r25) {
        QModel r0 = r25;
        if ((r0 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.h) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r1 = (com.bytedance.android.livesdk.livecommerce.promotion.card.h) r0;
        if (r1 == null) goto L230;
        cl.d r2 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r2 == null) goto L11;
        r2.c(w().f());
    L11:
        if (this.f == true) goto L14;
        this.f = true;
        ((PromotionCardButtonComponent) w().b(2131377852).f()).setArgument(this.h);
        ((PromotionCardButtonComponent) w().b(2131377852).f()).setAbility(this.i);
        ((PromotionCardImageComponent) w().b(2131377867).f()).setArgument(this.h);
        ((PromotionCardImageComponent) w().b(2131377867).f()).setAbility(this.i);
        ((PromotionCardPriceComponent) w().b(2131367779).f()).setArgument(this.h);
        ((PromotionCardPriceComponent) w().b(2131367779).f()).setAbility(this.i);
        ((PromotionCardBottomComponent) w().b(2131377851).f()).setArgument(this.h);
        ((PromotionCardBottomComponent) w().b(2131377851).f()).setAbility(this.i);
        ((PromotionCardInfoComponent) w().b(2131378719).f()).setArgument(this.h);
        ((PromotionCardInfoComponent) w().b(2131378719).f()).setContainerAbility(this.i);
        D(true);
    L14:
        this.e = r1;
        int r3 = c.a[r1.b.ordinal()];
        if (r3 == 1) goto L28;
        if (r3 == 2) goto L24;
        if (r3 == 3) goto L23;
        if (r3 == 4) goto L22;
        if (r3 != 5) goto L27;
        F();
    L27:
        ql.a r6 = null;
    L205:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r4 = this.e;
        if (r4 != null) goto L208;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L208:
        ql.a r5 = r4.a.a;
        View r7 = y();
        StringBuilder r8 = new StringBuilder();     // Catch: Exception -> L214
        if (r5.getIronIndex() <= 0) goto L212;
        r8.append(r5.getIronIndex() + "号商品");     // Catch: Exception -> L214
    L212:
        r8.append(r5.getTitle());     // Catch: Exception -> L214
        PromotionCardPriceComponent r9 = (PromotionCardPriceComponent) w().b(2131367779).f();     // Catch: Exception -> L214
        r8.append(((PromotionCardInfoComponent) w().b(2131378719).f()).getInfoAreaContentDescription());     // Catch: Exception -> L214
        r8.append(r9.getReadableText());     // Catch: Exception -> L214
        ql.a r10 = r8.toString();     // Catch: Exception -> L214
    L216:
        r7.setContentDescription(r10);
        return;
    L214:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r10 = r6;
        goto L216
    L22:
        E();
        goto L27
    L23:
        G();
        goto L27
    L24:
        PromotionCardImageComponent r11 = (PromotionCardImageComponent) w().b(2131377867).f();
        jj2.c r12 = r11.c;
        if (r12 == null) goto L27;
        r11.f(r12, true);
        goto L27
    L28:
        int r13 = UIConfigHelper.a;
        ConstraintLayout r14 = w().f();
        Map<PromotionCardModuleName, Integer> r15 = this.j;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r16 = this.e;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L31:
        UIConfigHelper.e(r14, r15, r16.c);
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r17 = this.e;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L34:
        ql.a r18 = r17.a.a;
        if ((r18 instanceof ECUIPromotionV2) == true) goto L37;
        r18 = null;
    L37:
        final ECUIPromotionV2 r19 = (ECUIPromotionV2) r18;
        boolean r110 = false;
        if (r19 != null) goto L40;
        r6 = null;
    L92:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r20 = this.e;
        if (r20 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L95:
        ql.a r21 = r20.a.a;
        if ((r21 instanceof ECUIPromotionV2) == true) goto L98;
        r21 = r6;
    L98:
        ECUIPromotionV2 r22 = (ECUIPromotionV2) r21;
        if (r22 == null) goto L103;
        j1 r23 = r22.getTitle();
        if (r23 == null) goto L103;
        ql.a r24 = new jj2.f(r23, r20.b, r20.c);
    L104:
        if (r24 == null) goto L150;
        List r26 = r24.a.c();
        if (r26 == null) goto L113;
        Iterator r27 = r26.iterator();
    L109:
        if (r27.hasNext() == false) goto L113;
        RitTagTrack r28 = ((ECRitTag) r27.next()).getTagTrack();
        if (r28 == null) goto L109;
        r28.setVisibile(true);
    L113:
        ?? r29 = (PromotionCardTitleComponent) w().b(2131391606).f();
        Intrinsics.checkNotNullParameter(r24, "model");
        String r30 = r24.a.b();
        List r31 = r24.a.c();
        int r32 = (int) r24.a.a();
        if (r31 == null) goto L143;
        ql.a r33 = new ArrayList();
        Iterator r34 = r31.iterator();
    L117:
        if (r34.hasNext() == false) goto L122;
        ECUrlModel r111 = ((ECRitTag) r34.next()).getTextIcon();
        if (r111 == null) goto L117;
        r33.add(r111);
        goto L117
    L122:
        if ((!r33.isEmpty()) == true) goto L125;
        r33 = r6;
    L125:
        if (r33 == null) goto L143;
        ECUrlModel r35 = (ECUrlModel) CollectionsKt.getOrNull(r33, 0);
        if (r35 == null) goto L129;
        float r36 = r35.getHeight();
    L130:
        IPromotionUIConfig.d r112 = r24.c.a(PromotionCardModuleName.TitleTag);
        if (r112 == null) goto L142;
        IPromotionUIConfig.b r113 = r112.a();
        if (r113 == null) goto L142;
        ql.a r114 = Float.valueOf(r113.c());
        if (r114.floatValue() <= 0) goto L137;
        r110 = true;
    L137:
        if (r110 == true) goto L140;
        r114 = r6;
    L140:
        if (r114 == null) goto L142;
        r36 = r36 * r114.floatValue();
    L142:
        r29.a = q.b(r33, r30, r36, r29, true, 64);
    L144:
        r29.setMaxLines(r32);
        r29.setFocusable(true);
        IPromotionUIConfig.d r37 = r24.c.a(PromotionCardModuleName.Title);
        if (r37 == null) goto L150;
        IPromotionUIConfig.b r38 = r37.a();
        if (r38 == null) goto L150;
        UIConfigHelper.c(r29, r38);
        goto L150
    L129:
        r36 = 0.0f;
    L143:
        r29.setText(r30);
        Unit r39 = Unit.INSTANCE;
    L150:
        if (this.g == true) goto L152;
    L165:
        G();
        I();
    L166:
        F();
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r40 = this.e;
        if (r40 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L169:
        ql.a r41 = r40.a.a;
        if ((r41 instanceof ECUIPromotionV2) == true) goto L172;
        r41 = r6;
    L172:
        ECUIPromotionV2 r42 = (ECUIPromotionV2) r41;
        if (r42 == null) goto L177;
        d1 r43 = r42.getPrice();
        if (r43 == null) goto L177;
        ql.a r44 = new jj2.e(r43, r40.b, r40.c);
    L178:
        if (r44 == null) goto L180;
        ((PromotionCardPriceComponent) w().b(2131367779).f()).b(r44);
    L180:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r45 = this.e;
        if (r45 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L183:
        IPromotionUIConfig.d r46 = r45.c.a(PromotionCardModuleName.BottomModule);
        if (r46 == null) goto L186;
        ql.a r47 = r46.d();
    L188:
        if (Intrinsics.areEqual(r47, Boolean.FALSE) == false) goto L190;
        w().b(2131377851).f().setVisibility(8);
        goto L205
    L190:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r48 = this.e;
        if (r48 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L193:
        ql.a r49 = r48.a.a;
        if ((r49 instanceof ECUIPromotionV2) == true) goto L196;
        r49 = r6;
    L196:
        ECUIPromotionV2 r50 = (ECUIPromotionV2) r49;
        if (r50 == null) goto L201;
        v0 r51 = r50.getExtend();
        if (r51 == null) goto L201;
        ql.a r52 = new jj2.b(r51, r48.b, r48.c, r50.getIronIndex());
    L202:
        if (r52 == null) goto L204;
        ((PromotionCardBottomComponent) w().b(2131377851).f()).a(r52);
        goto L205
    L204:
        w().b(2131377851).f().setVisibility(8);
        Unit r53 = Unit.INSTANCE;
    L201:
        r52 = r6;
        goto L202
    L186:
        r47 = r6;
    L177:
        r44 = r6;
        goto L178
    L152:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCard() == false) goto L165;
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r54 = this.e;
        if (r54 != null) goto L156;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L156:
        ql.a r55 = r54.a.a;
        if ((r55 instanceof ECUIPromotionV2) == true) goto L159;
        r55 = r6;
    L159:
        ECUIPromotionV2 r56 = (ECUIPromotionV2) r55;
        if (r56 == null) goto L164;
        z0 r57 = r56.getImage();
        if (r57 == null) goto L164;
        ((PromotionCardImageComponent) w().b(2131377867).f()).d(r57);
    L164:
        Looper.myQueue().addIdleHandler(new e(this));
    L103:
        r24 = r6;
        goto L104
    L40:
        v0 r115 = r19.getExtend();
        if (r115 == null) goto L43;
        PromotionExtendType r116 = r115.e();
    L45:
        if (r116 == PromotionExtendType.GENERAL_BANNER) goto L60;
        v0 r117 = r19.getExtend();
        if (r117 == null) goto L49;
        PromotionExtendType r118 = r117.e();
    L51:
        if (r118 == PromotionExtendType.COMBINATION) goto L60;
        v0 r119 = r19.getExtend();
        if (r119 == null) goto L55;
        PromotionExtendType r120 = r119.e();
    L57:
        if (r120 == PromotionExtendType.GIVEN) goto L60;
        boolean r121 = false;
    L61:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r122 = this.e;
        if (r122 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L64:
        IPromotionUIConfig.d r58 = r122.c.a(PromotionCardModuleName.Parent);
        if (r58 == null) goto L67;
        UIConfigHelper.d(w().f(), r58);
    L67:
        List r59 = (List) this.h.b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackgroundRadius, Reflection.getOrCreateKotlinClass(List.class), null);
        if (r59 == null) goto L70;
        Object r60 = CollectionsKt.firstOrNull(r59);
    L72:
        if ((r60 instanceof Integer) == true) goto L74;
        r60 = null;
    L74:
        Integer r61 = (Integer) r60;
        if (r61 == null) goto L77;
        int r62 = r61.intValue();
    L78:
        float r63 = r62;
        ViewExtensionsKt.g(w().f(), r63, r63, r63, r63);
        View r64 = w().f();
        if (r19.isOnTopExplaining() != true) goto L81;
        GradientDrawable r123 = new GradientDrawable();
        r123.setShape(0);
        r123.setOrientation(GradientDrawable.Orientation.TL_BR);
        r123.setGradientType(0);
        r123.setColors(new int[]{th.a.a(u().c(), 2131106064), th.a.a(u().c(), 2131106064), th.a.a(u().c(), 2131106064), th.a.a(u().c(), 2131106075), th.a.a(u().c(), 2131106063), th.a.a(u().c(), 2131106063)});
        r123.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r62)));
        GradientDrawable r65 = new GradientDrawable();
        r65.setShape(0);
        r65.setColor(th.a.a(u().c(), 2131106065));
        r65.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(Integer.valueOf(r62 - 1)));
        LayerDrawable r66 = new LayerDrawable(new Drawable[]{r123, r65});
        Resources r67 = Resources.getSystem();
        int r210 = MathKt.roundToInt(TypedValue.applyDimension(1, 1, WindowDisplayMetricsOverride.apply(r67, r67.getDisplayMetrics())));
        r66.setLayerInset(1, r210, r210, r210, r210);
        Intrinsics.checkNotNullParameter(r64, "$this$setBackgroundCompat");
        r64.setBackground(r66);
    L82:
        r6 = null;
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new PromotionCardGroupPresenter$updateItemView$3(this), 1);
        y().setOnLongClickListener(new d(this));
        if ((y() instanceof ECConstrainLayout) == false) goto L89;
        ECConstrainLayout r68 = y();
        if (r68 == null) goto L88;
        r68.setViewOnClickListener(new PromotionCardGroupPresenter$updateItemView$5(this, r19));
    L90:
        if (r121 == false) goto L92;
        y().setPadding(y().getPaddingLeft(), y().getPaddingTop(), y().getPaddingRight(), 0);
        goto L92
    L88:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.ECConstrainLayout");
    L89:
        ECExceptionMonitor.e(new RuntimeException("商品卡点击监听器注册失败，可能影响购物列表进商城推荐"));
        goto L90
    L81:
        r64.setBackgroundColor(th.a.a(u().c(), 2131106174));
        goto L82
    L77:
        r62 = 16;
        goto L78
    L70:
        r60 = null;
        goto L72
    L55:
        r120 = null;
        goto L57
    L49:
        r118 = null;
    L60:
        r121 = true;
        goto L61
    L43:
        r116 = null;
        goto L45
    }

    public final void D(boolean r3) {
        int r0 = ph.b.a;
        ph.b.c(w().b(2131391606).f(), r3);
        ph.b.c(w().b(2131378719).f(), r3);
        ph.b.c(w().b(2131367779).f(), r3);
        ph.b.c(w().b(2131377852).f(), r3);
        ph.b.c(w().b(2131377851).f(), r3);
    }

    public f(LivePromotionCardArgsV2 r2, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r3, Map<PromotionCardModuleName, Integer> r4) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        Intrinsics.checkNotNullParameter(r3, "containerAbility");
        Intrinsics.checkNotNullParameter(r4, "moduleIdMap");
        this.h = r2;
        this.i = r3;
        this.j = r4;
    }
}
