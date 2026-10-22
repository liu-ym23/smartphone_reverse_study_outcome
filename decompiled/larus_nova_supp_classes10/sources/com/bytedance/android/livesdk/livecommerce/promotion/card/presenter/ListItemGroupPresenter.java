package com.bytedance.android.livesdk.livecommerce.promotion.card.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.widget.ECConstrainLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.sdk.helper.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.UpdateType;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemBottomModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemButtonModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemImageAreaModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemInfoWidgetContainer;
import com.bytedance.android.livesdk.livecommerce.promotion.card.module.ListItemPriceAreaModule;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECSalePointView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECTagAndSalePointWidget;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mh2.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ListItemGroupPresenter extends QPresenter {
    public hj2.h e;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.i f;
    public Disposable g;
    public boolean h;
    public boolean i;
    public final LivePromotionCardArgs j;
    public final Map<PromotionCardModuleName, Integer> k;

    public final void E() {
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        ECUIPromotion r2 = r1.a.a;
        int r3 = r2.getIronIndex();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r4 = this.j.a;
        if (r4 == null) goto L8;
        String r5 = r4.a(ListItemGroupPresenter$onClick$btm$1.INSTANCE, r3);
    L9:
        String r7 = r5;
        if (r7 != null) goto L12;
        String r6 = "";
    L13:
        BtmItemBuilder r8 = new BtmItemBuilder(r6, Boolean.TRUE).withView(y());
        com.bytedance.android.btm.api.model.d r13 = BtmUtilsKt.e(r7, PageFinder.via(y()));
        LivePromotionCardArgs r9 = this.j;
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r10 = this.f;
        if (r10 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L16:
        LivePromotionCardArgs.b(r9, r10.a, "blank", r7, r8, y(), 4);
        jf.d r11 = this.j.g;
        Context r12 = u().c();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r14 = this.f;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L19:
        jf.d.b.a(r11, r12, "blank", r14.a.b, r13, null, y(), null, 192);
        xh.c.a("Live").d("good_list", "cell_blank", MapsKt.mapOf(new Pair[]{TuplesKt.to("promotion_id", r2.getPromotionId()), TuplesKt.to("product_id", r2.getProductId())}));
        return;
    L12:
        r6 = r7;
        goto L13
    L8:
        r5 = null;
        goto L9
    }

    public final void F() {
        if (this.h == false) goto L5;
        this.i = true;
    L5:
        D(false);
        Disposable r0 = this.g;
        if (r0 == null) goto L8;
        r0.dispose();
    L8:
        ((ListItemPriceAreaModule) w().b(2131367779).f()).c();
        ((ListItemInfoWidgetContainer) w().b(2131378693).f()).d();
        ((ListItemInfoWidgetContainer) w().b(2131378850).f()).d();
        ListItemImageAreaModule r1 = (ListItemImageAreaModule) w().b(2131377867).f();
    }

    public final void K() {
        boolean r3 = true;
        if (this.e != null) goto L5;
        hj2.h r1 = new hj2.h(u().c(), this.j);
        this.e = r1;
        List<? extends ij2.b> r5 = CollectionsKt.listOf(new ListItemInfoWidgetContainer[]{(ListItemInfoWidgetContainer) w().b(2131378693).f(), (ListItemInfoWidgetContainer) w().b(2131378850).f()});
        Intrinsics.checkNotNullParameter(r5, "list");
        r1.a = r5;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r2 = this.f;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L8:
        IPromotionUIConfig.d r4 = r2.c.a(PromotionCardModuleName.InfoAreaModule);
        Object r6 = null;
        if (r4 == null) goto L11;
        Boolean r7 = r4.d();
    L13:
        if (Intrinsics.areEqual(r7, Boolean.FALSE) == false) goto L22;
        hj2.h r8 = this.e;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L17:
        Iterator<T> r9 = r8.a.iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        ((ij2.b) r9.next()).hide();
        goto L19
    L21:
        return;
    L22:
        hj2.h r10 = this.e;
        if (r10 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("widgetManager");
    L25:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r11 = this.f;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L28:
        com.bytedance.android.ec.common.api.jump.model.e r12 = r11.a;
        Function2<Integer, Boolean, Unit> r13 = new ListItemGroupPresenter$updateInfoArea$2(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r13, "callback");
        boolean r14 = r10.f.b(r12);
        boolean r15 = r10.g.b(r12);
        boolean r16 = r10.h.b(r12);
        boolean r17 = r10.i.b(r12);
        boolean r18 = r10.j.b(r12);
        ij2.c r19 = r10.d;
        if (r19.b(r12) == true) goto L32;
        r19 = null;
    L32:
        if (r19 != null) goto L38;
        r19 = r10.e;
        if (r19.b(r12) == true) goto L38;
        r19 = null;
    L38:
        if (r19 == null) goto L42;
        ij2.c r20 = hj2.h.a(r12, CollectionsKt.listOf(new ij2.c[]{r10.h, r10.i, r10.g, r10.f}));
        if (Intrinsics.areEqual(r20, r10.h) == false) goto L50;
        ij2.c r110 = r19;
        r19 = r10.h;
        r20 = r110;
    L50:
        if (r18 == false) goto L55;
        if (r19 != null) goto L53;
        r19 = r10.j;
        goto L55
    L53:
        if (r20 != null) goto L55;
        r20 = r10.j;
    L55:
        List r21 = CollectionsKt.listOfNotNull(new ij2.c[]{r19, r20});
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r21, "factoryList");
        if (r10.a.isEmpty() == true) goto L83;
        Iterator r22 = r21.iterator();
        int r23 = 0;
    L60:
        if (r22.hasNext() == false) goto L79;
        ij2.c r111 = (ij2.c) r22.next();
        if (r23 >= r10.a.size()) goto L79;
        if (r111.b(r12) == false) goto L60;
        ij2.a r112 = ((ij2.b) ListProtector.get(r10.a, r23)).getCurrentWidget();
        if (r112 != null) goto L68;
    L72:
        ((ij2.b) ListProtector.get(r10.a, r23)).b();
        r112 = r111.a(r10.c, r10.b);
        if (r112.a() == false) goto L77;
        ij2.b r113 = r112.getParentContainer();
        if (r113 == null) goto L77;
        r113.b();
    L77:
        ((ij2.b) ListProtector.get(r10.a, r23)).a(r112);
    L78:
        ((ij2.b) ListProtector.get(r10.a, r23)).show();
        r112.b(r12);
        r23 = r23 + 1;
        goto L60
    L68:
        if (Intrinsics.areEqual(r112.getType(), r111.getType()) == true) goto L71;
        r112 = null;
    L71:
        if (r112 != null) goto L78;
    L79:
        List<? extends ij2.b> r24 = r10.a;
        Iterator<T> r25 = r24.subList(r23, r24.size()).iterator();
    L81:
        if (r25.hasNext() == false) goto L83;
        ((ij2.b) r25.next()).hide();
    L83:
        ECUIPromotion r26 = r12.a;
        Iterator r27 = r21.iterator();
    L85:
        if (r27.hasNext() == false) goto L89;
        Object r28 = r27.next();
        if ((((ij2.c) r28) instanceof hj2.g) == false) goto L85;
        r6 = r28;
    L89:
        if (r6 == null) goto L91;
        boolean r29 = true;
    L92:
        r26.isShowUserRightsTag = r29;
        List<? extends ij2.b> r30 = r10.a;
        ArrayList r31 = new ArrayList();
        Iterator<T> r32 = r30.iterator();
    L94:
        if (r32.hasNext() == false) goto L98;
        Object r33 = r32.next();
        if (((ij2.b) r33).c() == false) goto L94;
        r31.add(r33);
        goto L94
    L98:
        Integer r34 = Integer.valueOf(r31.size());
        ArrayList r35 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r31, 10));
        Iterator r36 = r31.iterator();
    L100:
        if (r36.hasNext() == false) goto L103;
        r35.add(((ij2.b) r36.next()).getCurrentWidget());
        goto L100
    L103:
        if (r35.isEmpty() == true) goto L134;
        Iterator r37 = r35.iterator();
    L107:
        if (r37.hasNext() == false) goto L134;
        ij2.a r38 = (ij2.a) r37.next();
        if ((r38 instanceof ECTagAndSalePointWidget) == false) goto L131;
        ECTagAndSalePointWidget r39 = (ECTagAndSalePointWidget) r38;
        ECSalePointView r40 = r39.h;
        if (r40 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L114:
        if (r40.getVisibility() != 0) goto L116;
        boolean r41 = true;
    L117:
        if (r41 == true) goto L128;
        ECSalePointView r42 = r39.i;
        if (r42 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L122:
        if (r42.getVisibility() != 0) goto L124;
        boolean r43 = true;
    L125:
        if (r43 == true) goto L128;
        boolean r44 = false;
    L129:
        if (r44 == false) goto L131;
        boolean r45 = true;
    L132:
        if (r45 == false) goto L107;
    L135:
        r13.invoke(r34, Boolean.valueOf(r3));
        return;
    L124:
        r43 = false;
    L128:
        r44 = true;
        goto L129
    L116:
        r41 = false;
    L131:
        r45 = false;
    L134:
        r3 = false;
        goto L135
    L91:
        r29 = false;
        goto L92
    L42:
        if (r17 == false) goto L44;
        r19 = r10.i;
        r20 = hj2.h.a(r12, CollectionsKt.listOf(new ij2.c[]{r10.h, r10.f, r10.g}));
        goto L50
    L44:
        if (r16 == false) goto L46;
        r19 = r10.h;
        r20 = hj2.h.a(r12, CollectionsKt.listOf(new ij2.c[]{r10.f, r10.g}));
        goto L50
    L46:
        if (r14 == false) goto L49;
        if (r15 == false) goto L49;
        r19 = r10.f;
        r20 = r10.g;
    L49:
        r19 = hj2.h.a(r12, CollectionsKt.listOf(new ij2.c[]{r10.f, r10.g}));
        r20 = null;
        goto L50
    L11:
        r7 = null;
        goto L13
    }

    public final void G() {
        ListItemButtonModule r0 = (ListItemButtonModule) w().b(2131377852).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        r0.b(r1);
    }

    public final void C() {
        F();
    }

    public final void A(QModel r15) {
        Boolean r1 = null;
        if ((r15 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.i) == true) goto L5;
        r15 = null;
    L5:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r16 = (com.bytedance.android.livesdk.livecommerce.promotion.card.i) r15;
        if (r16 == null) goto L183;
        cl.d r0 = k.a();
        if (r0 == null) goto L11;
        r0.c(w().f());
    L11:
        if (this.h == true) goto L14;
        this.h = true;
        ((ListItemButtonModule) w().b(2131377852).f()).setArgument(this.j);
        ((ListItemImageAreaModule) w().b(2131377867).f()).setArgument(this.j);
        ((ListItemPriceAreaModule) w().b(2131367779).f()).setArgument(this.j);
        ((ListItemBottomModule) w().b(2131377851).f()).setArgument(this.j);
        D(true);
    L14:
        this.f = r16;
        ECUIPromotion r2 = r16.a.a;
        View r6 = y();
        Context r8 = u().c();     // Catch: Exception -> L28
        StringBuilder r9 = new StringBuilder();     // Catch: Exception -> L28
        if (r2.getIronIndex() <= 0) goto L18;
        r9.append(r2.getIronIndex() + "号商品");     // Catch: Exception -> L28
    L18:
        r9.append(r2.title);     // Catch: Exception -> L28
        ListItemPriceAreaModule r10 = (ListItemPriceAreaModule) w().b(2131367779).f();     // Catch: Exception -> L28
        ListItemInfoWidgetContainer r11 = (ListItemInfoWidgetContainer) w().b(2131378693).f();     // Catch: Exception -> L28
        ListItemInfoWidgetContainer r12 = (ListItemInfoWidgetContainer) w().b(2131378850).f();     // Catch: Exception -> L28
        ij2.a r13 = r11.getCurrentWidget();     // Catch: Exception -> L28
        if (r13 == null) goto L21;
        String r14 = r13.getCurrentContentDescription();     // Catch: Exception -> L28
    L22:
        r9.append(r14);     // Catch: Exception -> L28
        ij2.a r17 = r12.getCurrentWidget();     // Catch: Exception -> L28
        if (r17 == null) goto L25;
        String r18 = r17.getCurrentContentDescription();     // Catch: Exception -> L28
    L26:
        r9.append(r18);     // Catch: Exception -> L28
        r9.append(com.bytedance.android.livesdk.livecommerce.utils.a.c(r2, r8, false));     // Catch: Exception -> L28
        r9.append(r10.getReadableText());     // Catch: Exception -> L28
        String r3 = r9.toString();     // Catch: Exception -> L28
    L30:
        r6.setContentDescription(r3);
        int r4 = d.a[r16.b.ordinal()];
        if (r4 != 1) goto L33;
        int r19 = UIConfigHelper.a;
        ConstraintLayout r110 = w().f();
        Map<PromotionCardModuleName, Integer> r5 = this.k;
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r7 = this.f;
        if (r7 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L50:
        UIConfigHelper.e(r110, r5, r7.c);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r111 = this.f;
        if (r111 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L53:
        final ECUIPromotion r112 = r111.a.a;
        ViewExtensionsKt.g(w().f(), 12.0f, 12.0f, 12.0f, 12.0f);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r20 = this.f;
        if (r20 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L56:
        IPromotionUIConfig.d r21 = r20.c.a(PromotionCardModuleName.Parent);
        if (r21 == null) goto L59;
        UIConfigHelper.d(w().f(), r21);
    L59:
        View r22 = w().f();
        if (r112.isOnTopExplain() == false) goto L65;
        Drawable r23 = (Drawable) this.j.b.n(ILivePromotionCardContainerHandler.Scene.ExplainPromotionBackground, Reflection.getOrCreateKotlinClass(Drawable.class), null);
        if (r23 == null) goto L64;
        r22.setBackground(r23);
    L67:
        if (r112.isLottery() == false) goto L79;
        ECUILotteryInfo r24 = r112.getLotteryInfo();
        if (r24 != null) goto L71;
    L73:
        ECUILotteryInfo r25 = r112.getLotteryInfo();
        if (r25 != null) goto L76;
    L78:
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$4(this), 1);
    L80:
        y().setOnLongClickListener(new f(this));
        if ((y() instanceof ECConstrainLayout) == false) goto L87;
        ECConstrainLayout r26 = y();
        if (r26 == null) goto L86;
        r26.setViewOnClickListener(new ListItemGroupPresenter$updateItemView$7(this, r112));
    L88:
        ImageView r113 = (ImageView) w().b(2131376518).f();
        if (this.j.b.h(Decision.PROMOTION_CARD_CLOSE_STYLE) == false) goto L91;
        int r27 = 2131234439;
    L92:
        r113.setImageResource(r27);
        r113.setOnClickListener(new e(this));
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r114 = this.f;
        if (r114 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L95:
        ECUIPromotion r115 = r114.a.a;
        if (r115 == null) goto L109;
        Map r28 = r115.getRitTag();
        if (r28 == null) goto L109;
        List r29 = (List) r28.get("live_room_product_title_before");
        if (r29 == null) goto L109;
        Iterator r30 = r29.iterator();
    L103:
        if (r30.hasNext() == false) goto L109;
        ECRitTag r31 = (ECRitTag) r30.next();
        if (r31 == null) goto L103;
        RitTagTrack r32 = r31.getTagTrack();
        if (r32 == null) goto L103;
        r32.setVisibile(true);
    L109:
        AppCompatTextView r33 = w().b(2131391606).f();
        Map r34 = r115.getRitTag();
        if (r34 == null) goto L125;
        List r35 = (List) r34.get("live_room_product_title_before");
        if (r35 == null) goto L125;
        ArrayList r36 = new ArrayList();
        Iterator r37 = r35.iterator();
    L115:
        if (r37.hasNext() == false) goto L120;
        ECUrlModel r38 = ((ECRitTag) r37.next()).getTextIcon();
        if (r38 == null) goto L115;
        r36.add(r38);
        goto L115
    L120:
        if ((!r36.isEmpty()) == true) goto L123;
        r36 = null;
    L123:
        if (r36 == null) goto L125;
        this.g = q.b(r36, r115.title, ((ECUrlModel) ListProtector.get(r36, 0)).getHeight(), r33, false, 96);
    L126:
        r33.setFocusable(true);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r116 = this.f;
        if (r116 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L129:
        IPromotionUIConfig.d r117 = r116.c.a(PromotionCardModuleName.Title);
        if (r117 == null) goto L135;
        IPromotionUIConfig.b r118 = r117.a();
        if (r118 == null) goto L135;
        UIConfigHelper.c(r33, r118);
    L135:
        if (this.i == true) goto L137;
    L139:
        I(null);
        K();
    L140:
        G();
        ListItemPriceAreaModule r119 = (ListItemPriceAreaModule) w().b(2131367779).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r39 = this.f;
        if (r39 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L143:
        r119.b(r39);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r120 = this.f;
        if (r120 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L146:
        IPromotionUIConfig.d r121 = r120.c.a(PromotionCardModuleName.BottomModule);
        if (r121 == null) goto L150;
        r1 = r121.d();
    L150:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L152;
        w().b(2131377851).f().setVisibility(8);
    L156:
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r122 = this.f;
        if (r122 != null) goto L159;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L159:
        ECUIPromotion r123 = r122.a.a;
        View r40 = w().f();
        if (r123.shouldShowFindSimilarWithOtherStore() == false) goto L162;
        r40.setAlpha(1.0f);
        return;
    L162:
        int r124 = r123.overlayType;
        if (r124 == 0) goto L167;
        if (r124 != 1) goto L192;
        r40.setAlpha(0.5f);
        return;
    L192:
        return;
    L167:
        r40.setAlpha(1.0f);
        return;
    L152:
        ListItemBottomModule r125 = (ListItemBottomModule) w().b(2131377851).f();
        r125.setVisibility(0);
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r41 = this.f;
        if (r41 != null) goto L155;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L155:
        r125.a(r41);
        goto L156
    L137:
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableIdleLoadCard() == false) goto L139;
        Looper.myQueue().addIdleHandler(new g(this));
    L125:
        r33.setText(r115.title);
        goto L126
    L91:
        r27 = 2131234474;
        goto L92
    L86:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.core.widget.ECConstrainLayout");
    L87:
        ECExceptionMonitor.e(new RuntimeException("商品卡点击监听器注册失败，可能影响购物列表进商城推荐"));
        goto L88
    L76:
        if (r25.isButtonGray() != true) goto L78;
        y().setOnClickListener(null);
        goto L80
    L71:
        if (r24.isScarceLottery() != true) goto L73;
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$3(this), 1);
        goto L80
    L79:
        com.bytedance.android.ec.core.widget.f.c(y(), null, "bind_key_live_promotion_list", new ListItemGroupPresenter$updateItemView$5(this), 1);
        goto L80
    L64:
        r22.setBackgroundResource(2131234286);
        Unit r42 = Unit.INSTANCE;
        goto L67
    L65:
        r22.setBackgroundColor(th.a.a(u().c(), 2131106174));
        goto L67
    L33:
        if (r4 != 2) goto L35;
        ListItemImageAreaModule r126 = (ListItemImageAreaModule) w().b(2131377867).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r43 = r126.c;
        if (r43 == null) goto L187;
        r126.e(r43, true);
        return;
    L187:
        return;
    L35:
        if (r4 != 3) goto L37;
        I(r16.b);
        return;
    L37:
        if (r4 != 4) goto L39;
        F();
        return;
    L39:
        if (r4 != 5) goto L191;
        G();
        return;
    L191:
        return;
    L25:
        r18 = null;
        goto L26
    L21:
        r14 = null;
    L28:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r3 = null;
        goto L30
    }

    public final void D(boolean r3) {
        int r0 = ph.b.a;
        ph.b.c(w().b(2131391606).f(), r3);
        ph.b.c(w().b(2131378693).f(), r3);
        ph.b.c(w().b(2131378850).f(), r3);
        ph.b.c(w().b(2131367779).f(), r3);
        ph.b.c(w().b(2131377852).f(), r3);
        ph.b.c(w().b(2131377851).f(), r3);
    }

    public final void I(UpdateType r4) {
        ListItemImageAreaModule r0 = (ListItemImageAreaModule) w().b(2131377867).f();
        com.bytedance.android.livesdk.livecommerce.promotion.card.i r1 = this.f;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L5:
        r0.b(r1, r4);
    }

    public ListItemGroupPresenter(LivePromotionCardArgs r2, Map<PromotionCardModuleName, Integer> r3) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        Intrinsics.checkNotNullParameter(r3, "moduleIdMap");
        this.j = r2;
        this.k = r3;
    }
}
