package com.bytedance.android.livesdk.livecommerce.promotion.card.widget;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.core.widget.ECBenefitLabelView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUILotteryInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.CampaignProgress;
import com.bytedance.android.ec.model.response.CountDown;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends LinearLayout implements ij2.a {
    public StringBuilder a;
    public final LivePromotionCardArgs b;

    public static final class a {
    }

    static {
    }

    @Override // ij2.a
    public String getType() {
        return "coupon_group_widget";
    }

    @Override // ij2.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.a;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    @Override // ij2.a
    public final boolean a() {
        return ij2.a.C0143a.b(this);
    }

    public final void c() {
        List r0 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) r4.next()).c();
        goto L10
    }

    @Override // ij2.a
    public ij2.b getParentContainer() {
        return ij2.a.C0143a.a(this);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        c();
        super.removeAllViews();
    }

    @Override // ij2.a
    public final void release() {
        c();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // ij2.a
    public final void b(com.bytedance.android.ec.common.api.jump.model.e r17) {
        Intrinsics.checkNotNullParameter(r17, "data");
        ECUIPromotion r1 = r17.a;
        this.a = new StringBuilder();
        if (com.bytedance.android.livesdk.livecommerce.promotion.card.utils.a.b() == false) goto L93;
        ECUICampaign r2 = r1.getCampaign();
        if (r2 == null) goto L7;
        CampaignProgress r3 = r2.progress;
    L8:
        if (r3 == null) goto L93;
        ECUICampaign r4 = r1.getCampaign();
        if (r4 != null) goto L12;
    L14:
        boolean r5 = false;
    L15:
        ECUICampaign r12 = r1.getCampaign();
        if (r12 != null) goto L18;
    L20:
        boolean r13 = false;
    L21:
        List r14 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        Object r18 = r16.next();
        if ((r18 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) == false) goto L23;
        r15.add(r18);
        goto L23
    L27:
        com.bytedance.android.livesdk.livecommerce.promotion.card.view.a r6 = (com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) CollectionsKt.firstOrNull(r15);
        if (r5 == true) goto L31;
        if (r13 == true) goto L31;
    L88:
        if (r6 == null) goto L90;
        r6.setVisibility(8);
    L90:
        if (r6 == null) goto L92;
        r6.c();
    L92:
        c();
    L137:
        ECUILotteryInfo r7 = r1.getLotteryInfo();
        if (r7 == null) goto L150;
        PromotionBenefitLabel r8 = r7.getBenefitLabel();
        if (r8 == null) goto L150;
        List r9 = CollectionsKt.mutableListOf(new PromotionBenefitLabel[]{r8});
        List r10 = r1.getBenefitLabels();
        ECUILotteryInfo r11 = r1.getLotteryInfo();
        if (r11 != null) goto L144;
    L149:
        if (r9 == null) goto L150;
    L156:
        if (r9 != null) goto L159;
        r9 = CollectionsKt.emptyList();
    L159:
        if (r9.size() <= 3) goto L161;
        boolean r19 = true;
    L162:
        if (r19 == false) goto L164;
        List r20 = r9;
    L165:
        if (r20 == null) goto L170;
        List r21 = r20.subList(0, 3);
        if (r21 == null) goto L170;
        r9 = r21;
    L170:
        Iterator r22 = com.bytedance.commerce.base.view.b.a(this).iterator();
        int r23 = 0;
    L172:
        if (r22.hasNext() == false) goto L182;
        ECBenefitLabelView r24 = (View) r22.next();
        if ((r24 instanceof ECBenefitLabelView) == false) goto L172;
        if (r23 < r9.size()) goto L177;
        r24.setVisibility(8);
        goto L172
    L177:
        r24.setVisibility(0);
        PromotionBenefitLabel r25 = (PromotionBenefitLabel) ListProtector.get(r9, r23);
        r24.a(r25, this.a);
        RitTagTrack r26 = r25.getTagTrack();
        if (r26 == null) goto L180;
        r26.setVisibile(true);
    L180:
        r23 = r23 + 1;
        goto L172
    L182:
        return;
    L164:
        r20 = null;
        goto L165
    L161:
        r19 = false;
        goto L162
    L144:
        if (r11.isScarceLottery() != true) goto L149;
        if (r10 == null) goto L149;
        List r27 = r10;
        if ((!r27.isEmpty()) != true) goto L149;
        r9.addAll(r27);
    L150:
        r9 = r1.getBenefitLabels();
        if (r9 != null) goto L153;
    L155:
        r9 = null;
        goto L156
    L153:
        if ((!r9.isEmpty()) == false) goto L155;
    L31:
        if (r1.isPriceDeduce() == true) goto L88;
        if (r6 != null) goto L38;
        r6 = new com.bytedance.android.livesdk.livecommerce.promotion.card.view.a(getContext(), this.b);
        addView(r6, 0);
        ViewGroup.LayoutParams r28 = r6.getLayoutParams();
        if (r28 == null) goto L37;
        ((ViewGroup.MarginLayoutParams) r28).rightMargin = UtilityKotlinExtentionsKt.d(4);
        goto L38
    L37:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L38:
        r6.setVisibility(0);
        StringBuilder r29 = this.a;
        Intrinsics.checkNotNullParameter(r1, "promotion");
        if (Intrinsics.areEqual(r6.a, r1) == false) goto L50;
        ECUICampaign r30 = r1.getCampaign();
        ECUICampaign r31 = r1.campaign;
        if (r31 == null) goto L45;
        CampaignProgress r32 = r31.progress;
        if (r32 == null) goto L45;
        CountDown r33 = r32.getCountDown();
    L46:
        if (r33 != null) goto L48;
        long r34 = 0;
    L49:
        r6.e(r30, r34, r29);
        goto L137
    L48:
        r34 = r31.progressEndTime - SystemClock.elapsedRealtime();
    L45:
        r33 = null;
        goto L46
    L50:
        r6.a = r1;
        r6.e = r29;
        ECUICampaign r35 = r1.getCampaign();
        if (r35 != null) goto L53;
    L54:
        if (r35 != null) goto L56;
    L87:
        r6.b();
        r6.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r6.h);
        goto L137
    L56:
        if (r35.isLimitTimeBuy() != true) goto L87;
    L57:
        CampaignProgress r36 = r35.progress;
        if (r36 == null) goto L60;
        CountDown r37 = r36.getCountDown();
    L61:
        if (r37 != null) goto L63;
    L66:
        boolean r38 = true;
    L67:
        if (r38 == true) goto L69;
        r6.b();
        goto L137
    L69:
        r6.setBackgroundDrawable(r6.a());
        r6.d.setTextColor(th.a.a(r6.getContext(), 2131101602));
        r6.c.setVisibility(0);
        r6.b.setVisibility(8);
        if (r35.isLimitQuantityBuy() == false) goto L76;
        CampaignProgress r39 = r35.progress;
        if (r39 == null) goto L75;
        String r40 = r39.getLeftText();
        if (r40 == null) goto L75;
    L83:
        r6.c.setText(r40);
        if (r29 == null) goto L86;
        r29.append(r40);
    L86:
        r6.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r6.h);
    L75:
        r40 = th.a.g(r6.getContext(), 2131896539);
        goto L83
    L76:
        CampaignProgress r41 = r35.progress;
        if (r41 == null) goto L82;
        String r42 = r41.getLeftText();
        if (r42 == null) goto L82;
        r40 = r42;
    L82:
        r40 = th.a.g(r6.getContext(), 2131896538);
        goto L83
    L63:
        if (r37.getServerTime() >= r37.getStartTime()) goto L66;
        r38 = false;
        goto L67
    L60:
        r37 = null;
        goto L61
    L53:
        if (r35.isLimitQuantityBuy() == true) goto L57;
    L18:
        if (r12.isLimitQuantityBuy() != true) goto L20;
        r13 = true;
        goto L21
    L12:
        if (r4.shouldShowLimitBuyV2() != true) goto L14;
        r5 = true;
        goto L15
    L7:
        r3 = null;
    L93:
        ECUICampaign r43 = r1.getCampaign();
        if (r43 != null) goto L96;
    L98:
        boolean r44 = false;
    L99:
        List r45 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r110 = new ArrayList();
        Iterator r46 = r45.iterator();
    L101:
        if (r46.hasNext() == false) goto L105;
        Object r111 = r46.next();
        if ((r111 instanceof com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) == false) goto L101;
        r110.add(r111);
        goto L101
    L105:
        com.bytedance.android.livesdk.livecommerce.promotion.card.view.a r47 = (com.bytedance.android.livesdk.livecommerce.promotion.card.view.a) CollectionsKt.firstOrNull(r110);
        if (r44 == true) goto L108;
    L132:
        if (r47 == null) goto L134;
        r47.setVisibility(8);
    L134:
        if (r47 == null) goto L136;
        r47.c();
    L136:
        c();
        goto L137
    L108:
        if (r1.isPriceDeduce() == true) goto L132;
        if (r47 != null) goto L115;
        r47 = new com.bytedance.android.livesdk.livecommerce.promotion.card.view.a(getContext(), this.b);
        addView(r47, 0);
        ViewGroup.LayoutParams r48 = r47.getLayoutParams();
        if (r48 == null) goto L114;
        ((ViewGroup.MarginLayoutParams) r48).rightMargin = UtilityKotlinExtentionsKt.d(4);
        goto L115
    L114:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L115:
        r47.setVisibility(0);
        StringBuilder r49 = this.a;
        Intrinsics.checkNotNullParameter(r1, "promotion");
        if (Intrinsics.areEqual(r47.a, r1) == false) goto L118;
        r47.d(r1.getCampaign(), SystemClock.elapsedRealtime(), r49);
        goto L137
    L118:
        r47.e = r49;
        r47.a = r1;
        ECUICampaign r50 = r1.getCampaign();
        if (r50 != null) goto L121;
    L131:
        r47.setVisibility(8);
        r47.c.setVisibility(8);
        r47.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(r47.g);
        goto L137
    L121:
        if (r50.isLimitBuy() != true) goto L131;
        r47.setBackgroundDrawable(r47.a());
        r47.d.setTextColor(th.a.a(r47.getContext(), 2131101602));
        r47.c.setVisibility(0);
        r47.b.setVisibility(8);
        ECUICampaign r51 = r1.getCampaign();
        if (r51 == null) goto L126;
        String r52 = r51.label;
        if (r52 == null) goto L126;
    L127:
        r47.c.setText(r52);
        if (r49 == null) goto L130;
        r49.append(r52);
    L130:
        r47.d(r1.getCampaign(), SystemClock.elapsedRealtime(), r49);
        r47.i.b.a();
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(r47.g);
    L126:
        r52 = th.a.g(r47.getContext(), 2131896538);
        goto L127
    L96:
        if (r43.shouldShowLimitBuy() != true) goto L98;
        r44 = true;
        goto L99
    }

    public c(Context r7, LivePromotionCardArgs r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "argument");
        super(r7, null, 0);
        this.b = r8;
        int r9 = 0;
    L4:
        if (r9 >= 3) goto L13;
        ECBenefitLabelView r2 = new ECBenefitLabelView(r7, null, 6, 0);
        LinearLayout.LayoutParams r3 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(16));
        if (r9 != 0) goto L8;
        int r5 = 0;
    L9:
        r3.setMargins(UtilityKotlinExtentionsKt.d(r5), 0, 0, 0);
        r2.setLayoutParams(r3);
        r2.setFocusable(true);
        addView(r2);
        int r4 = com.bytedance.android.ec.core.utils.a.a;
        Intrinsics.checkNotNullParameter(this, "view");
        if (Build.VERSION.SDK_INT < 26) goto L12;
        setImportantForAccessibility(4);
    L12:
        r9 = r9 + 1;
        goto L4
    L8:
        r5 = 4;
        goto L9
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        super.onLayout(r2, r3, r4, r5, r6);
        int r7 = getChildCount() - 1;
    L3:
        if (r7 < 0) goto L13;
        View r8 = getChildAt(r7);
        if (r8 == null) goto L12;
        if (r8.getVisibility() == 8) goto L12;
        if ((r8.getLeft() + r8.getMeasuredWidth()) < getMeasuredWidth()) goto L19;
        r8.layout(r8.getLeft(), r8.getTop(), r8.getLeft(), r8.getBottom());
        goto L12
    L19:
        return;
    L12:
        r7 = r7 - 1;
        goto L3
    }
}
