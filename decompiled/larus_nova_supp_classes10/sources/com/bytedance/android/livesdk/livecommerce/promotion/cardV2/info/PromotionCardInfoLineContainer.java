package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.PromotionBenefitType;
import com.bytedance.android.ec.model.response.b0;
import com.bytedance.android.ec.model.response.i0;
import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.ec.model.response.p0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECBenefitLabelView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECBenefitLabelViewV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECFlashMaterialWidget;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECStockProgressLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECUserRightsTagWidget;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.g;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.h;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.m;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/PromotionCardInfoLineContainer;", "Landroid/widget/LinearLayout;", "", "", "getLineContentDescription", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardInfoLineContainer extends LinearLayout {
    public final Map<String, a> a;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a b;
    public final LivePromotionCardArgsV2 c;

    public PromotionCardInfoLineContainer(Context r7) {
        this(r7, null, null, null, 30);
    }

    public PromotionCardInfoLineContainer(Context r7, AttributeSet r8) {
        this(r7, r8, null, null, 28);
    }

    public final String getLineContentDescription() {
        StringBuilder r0 = new StringBuilder();
        List r1 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Object r4 = r3.next();
        if ((r4 instanceof a) == false) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Iterator r5 = r2.iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        r0.append(((a) r5.next()).getCurrentContentDescription());
        goto L10
    L13:
        return r0.toString();
    }

    public final void d() {
        List r0 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof a) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((a) r4.next()).release();
        goto L10
    }

    public final <T extends a> T c(String r4, Function0<? extends T> r5) {
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L19;
        T r0 = (T) ((LinkedHashMap) this.a).get(r4);
        if (r0 == null) goto L17;
        ViewParent r2 = null;
        if ((r0 instanceof View) == true) goto L9;
        Object r1 = null;
    L10:
        View r3 = (View) r1;
        if (r3 == null) goto L13;
        r2 = r3.getParent();
    L13:
        if (r2 == null) goto L16;
        r0 = (T) r5.invoke();
        this.a.put(r4, r0);
    L16:
        if (r0 == null) goto L17;
        return r0;
    L9:
        r1 = r0;
    L17:
        T r6 = (T) r5.invoke();
        this.a.put(r4, r6);
        return r6;
    L19:
        return (T) r5.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(a r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "widget");
        if ((r3 instanceof View) == false) goto L11;
        View r6 = (View) r3;
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(r4, -2);
        if (r5 == false) goto L7;
    L9:
        Unit r7 = Unit.INSTANCE;
        addView(r6, r0);
        return;
    L7:
        if (r4 == (-1)) goto L9;
        r0.setMarginStart(UtilityKotlinExtentionsKt.d(4));
        goto L9
    }

    public final void b(i0 r29, final boolean r30, final long r31, final k r33) {
        Intrinsics.checkNotNullParameter(r29, "linePromotionBenefit");
        Intrinsics.checkNotNullParameter(r33, "uiConfig");
        List r12 = null;
        if (Intrinsics.areEqual(null, r29) == false) goto L5;
        return;
    L5:
        d();
        removeAllViews();
        List r0 = r29.a();
        if (r0 == null) goto L231;
        Iterator r13 = r0.iterator();
        int r14 = 0;
        int r15 = 0;
    L9:
        if (r13.hasNext() == false) goto L251;
        Object r1 = r13.next();
        int r16 = r15 + 1;
        if (r15 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        final p0 r17 = (p0) r1;
        PromotionBenefitType r2 = r17.b();
        if (r2 == null) goto L215;
        int r3 = b.a[r2.ordinal()];
        boolean r6 = true;
        if (r3 != 1) goto L19;
        List r7 = r12;
        m r4 = (m) c("tag_and_sales_point", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$1(this, r30, r31, r33));
        if (r15 == 0) goto L227;
        r6 = false;
    L227:
        a(r4, -2, r6);
        b0 r5 = r17.d();
        if (r5 == null) goto L230;
        r4.a(r5, r30, r31, r33);
    L230:
        r12 = r7;
        r15 = r16;
        r14 = 0;
        goto L9
    L19:
        if (r3 != 2) goto L21;
        r7 = r12;
        ECUserRightsTagWidget r8 = (ECUserRightsTagWidget) c("user_right_tag_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$2(this, r30, r31, r33));
        if (r15 == 0) goto L220;
        r6 = false;
    L220:
        a(r8, -2, r6);
        List<ECRitTag> r9 = r17.f();
        if (r9 == null) goto L230;
        r8.a(r9, r33);
        goto L230
    L21:
        if (r3 == 3) goto L129;
        if (r3 != 4) goto L24;
        final LivePromotionCardArgsV2 r10 = this.c;
        if (r10 == null) goto L215;
        final int r11 = r15;
        h r18 = (h) c("seckill_bar_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$4(r10, r11, r17, this, r30, r31, r33));
        if (r15 != 0) goto L74;
        boolean r19 = true;
    L75:
        a(r18, -1, r19);
        o0 r20 = r17.e();
        if (r20 == null) goto L215;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r20, "progressBar");
        Intrinsics.checkNotNullParameter(r33, "uiConfig");
        if (Intrinsics.areEqual(r18.a, r20) == true) goto L215;
        r18.a = r20;
        IPromotionUIConfig.d r21 = r33.a(PromotionCardModuleName.InfoAreaSecKillTextModule);
        if (r21 == null) goto L104;
        IPromotionUIConfig.b r22 = r21.a();
        if (r22 == null) goto L104;
        CountDownView r23 = (CountDownView) r18.findViewById(2131368046);
        if (r23 == null) goto L87;
        r23.c(r22);
    L87:
        ECStockProgressLayout r24 = (ECStockProgressLayout) r18.findViewById(2131365111);
        if (r24 == null) goto L104;
        TextView r25 = r24.b;
        if (r25 == null) goto L92;
        UIConfigHelper.c(r25, r22);
    L92:
        TextView r26 = r24.d;
        if (r26 == null) goto L95;
        UIConfigHelper.c(r26, r22);
    L95:
        Float r27 = Float.valueOf(r22.e());
        if (r27.floatValue() <= r14) goto L98;
        boolean r28 = true;
    L99:
        if (r28 == true) goto L102;
        r27 = null;
    L102:
        if (r27 == null) goto L104;
        r24.h = r27.floatValue();
        goto L104
    L98:
        r28 = false;
    L104:
        IPromotionUIConfig.d r32 = r33.a(PromotionCardModuleName.InfoAreaSecKillModule);
        if (r32 == null) goto L121;
        IPromotionUIConfig.c r34 = r32.b();
        if (r34 == null) goto L121;
        Integer r35 = Integer.valueOf(r34.c());
        if (r35.intValue() <= 0) goto L111;
        boolean r36 = true;
    L112:
        if (r36 == true) goto L115;
        r35 = null;
    L115:
        if (r35 == null) goto L121;
        int r37 = r35.intValue();
        ECStockProgressLayout r38 = (ECStockProgressLayout) r18.findViewById(2131365111);
        if (r38 == null) goto L121;
        ViewGroup.LayoutParams r39 = r38.getLayoutParams();
        if (r39 == null) goto L121;
        r39.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r37));
        r38.setLayoutParams(r39);
        goto L121
    L111:
        r36 = false;
    L121:
        ECStockProgressLayout r40 = (ECStockProgressLayout) r18.findViewById(2131365111);
        String r41 = r20.b();
        Long r42 = r20.c();
        if (r42 == null) goto L124;
        Float r43 = Float.valueOf(r42.longValue());
    L125:
        r40.c(r41, r43, r20.d());
        if (r20.a() == null) goto L128;
        r18.d.b.a();
        d.a.a(r18.b);
        goto L215
    L128:
        r18.findViewById(2131368046).setVisibility(4);
        r18.d.b.a();
        d.a.b(r18.b);
        Unit r44 = Unit.INSTANCE;
        goto L215
    L124:
        r43 = null;
        goto L125
    L74:
        r19 = false;
        goto L75
    L24:
        if (r3 != 5) goto L215;
        ECFlashMaterialWidget r45 = (ECFlashMaterialWidget) c("flash_material_info", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$5(this, r30, r31, r33));
        if (r15 != 0) goto L29;
        boolean r46 = true;
    L30:
        a(r45, -2, r46);
        List r47 = r17.c();
        if (r47 == null) goto L215;
        r45.getClass();
        Intrinsics.checkNotNullParameter(r47, "tagList");
        Intrinsics.checkNotNullParameter(r33, "uiConfig");
        if ((!r47.isEmpty()) == true) goto L36;
        r47 = r12;
    L36:
        if (r47 == null) goto L215;
        ArrayList r48 = new ArrayList();
        Iterator r49 = r47.iterator();
    L39:
        if (r49.hasNext() == false) goto L44;
        String r50 = ((ECRitTag) r49.next()).getFirstText();
        if (r50 == null) goto L39;
        r48.add(r50);
        goto L39
    L44:
        if ((!Intrinsics.areEqual(r45.a, r48)) == false) goto L215;
        r45.a = r48;
        r45.removeAllViews();
        r45.b = new StringBuilder();
        Iterator r51 = r48.iterator();
        int r52 = 0;
    L47:
        if (r51.hasNext() == false) goto L67;
        Object r53 = r51.next();
        int r54 = r52 + 1;
        if (r52 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        String r55 = (String) r53;
        if (r52 != 0) goto L59;
        TextView r56 = r45.a(r55, r14);
        IPromotionUIConfig.d r57 = r33.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r57 == null) goto L58;
        IPromotionUIConfig.b r58 = r57.a();
        if (r58 == null) goto L58;
        UIConfigHelper.c(r56, r58);
    L58:
        Unit r59 = Unit.INSTANCE;
        r45.addView(r56);
    L65:
        r52 = r54;
        goto L47
    L59:
        View r60 = new View(r45.getContext());
        r60.setTag("divider");
        r60.setBackgroundColor(th.a.a(r60.getContext(), 2131106189));
        r45.setGravity(16);
        LinearLayout.LayoutParams r61 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f)));
        r61.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r61.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        Unit r62 = Unit.INSTANCE;
        r60.setLayoutParams(r61);
        r45.addView(r60);
        TextView r63 = r45.a(r55, r52);
        IPromotionUIConfig.d r64 = r33.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r64 == null) goto L64;
        IPromotionUIConfig.b r65 = r64.a();
        if (r65 == null) goto L64;
        UIConfigHelper.c(r63, r65);
    L64:
        r45.addView(r63);
        goto L65
    L67:
        if (r45.getChildCount() <= 0) goto L215;
        r45.addView(new Space(r45.getContext()), new LinearLayout.LayoutParams(1, r14));
        goto L215
    L29:
        r46 = false;
        goto L30
    L129:
        final LivePromotionCardArgsV2 r66 = this.c;
        if (r66 == null) goto L215;
        final int r67 = r15;
        g r68 = (g) c("coupon_group_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$3(r66, r67, r17, this, r30, r31, r33));
        if (r15 != 0) goto L134;
        boolean r69 = true;
    L135:
        a(r68, -2, r69);
        List r110 = r17.a();
        if (r110 == null) goto L215;
        r68.getClass();
        Intrinsics.checkNotNullParameter(r110, "benefitList");
        Intrinsics.checkNotNullParameter(r33, "uiConfig");
        Iterator r111 = r110.iterator();
        int r70 = 0;
    L139:
        if (r111.hasNext() == false) goto L199;
        Object r71 = r111.next();
        int r112 = r70 + 1;
        if (r70 >= 0) goto L143;
        CollectionsKt.throwIndexOverflow();
    L143:
        PromotionBenefitLabel r72 = (PromotionBenefitLabel) r71;
        if (((Boolean) r68.a.getValue()).booleanValue() == false) goto L171;
        View r73 = r68.getChildAt(r70);
        if ((r73 instanceof ECBenefitLabelViewV2) == true) goto L148;
        r73 = null;
    L148:
        ECBenefitLabelViewV2 r74 = (ECBenefitLabelViewV2) r73;
        if (r74 == null) goto L151;
        r74.setVisibility(0);
        int r75 = ECBenefitLabelViewV2.m;
        r74.a(r72, null);
    L198:
        r70 = r112;
        goto L139
    L151:
        int r210 = r70;
        ECBenefitLabelViewV2 r76 = new ECBenefitLabelViewV2(r68.getContext(), null, 0, r68.b, r68.c, r33, 6);
        LinearLayout.LayoutParams r77 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r210 != 0) goto L154;
        int r78 = 0;
    L155:
        r77.setMargins(UtilityKotlinExtentionsKt.d(r78), 0, 0, 0);
        r76.setLayoutParams(r77);
        r76.setFocusable(true);
        IPromotionUIConfig.d r79 = r33.a(PromotionCardModuleName.InfoAreaBenefitLabelModule);
        if (r79 == null) goto L170;
        IPromotionUIConfig.c r80 = r79.b();
        if (r80 == null) goto L170;
        Integer r81 = Integer.valueOf(r80.c());
        if (r81.intValue() <= 0) goto L162;
        boolean r82 = true;
    L163:
        if (r82 == true) goto L166;
        r81 = null;
    L166:
        if (r81 == null) goto L170;
        int r83 = r81.intValue();
        ViewGroup.LayoutParams r85 = r76.getLayoutParams();
        if (r85 == null) goto L170;
        r85.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r83));
        r76.setLayoutParams(r85);
        goto L170
    L162:
        r82 = false;
    L170:
        r68.addView(r76, r210);
        r76.a(r72, null);
        Unit r86 = Unit.INSTANCE;
        goto L198
    L154:
        r78 = 4;
        goto L155
    L171:
        View r87 = r68.getChildAt(r70);
        if ((r87 instanceof ECBenefitLabelView) == true) goto L174;
        r87 = null;
    L174:
        ECBenefitLabelView r88 = (ECBenefitLabelView) r87;
        if (r88 == null) goto L178;
        r88.setVisibility(0);
        int r89 = ECBenefitLabelView.k;
        r88.a(r72, null);
        goto L198
    L178:
        int r211 = r70;
        ECBenefitLabelView r90 = new ECBenefitLabelView(r68.getContext(), null, 0, r68.b, r68.c, r33, 6);
        LinearLayout.LayoutParams r91 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r211 != 0) goto L181;
        int r92 = 0;
    L182:
        r91.setMargins(UtilityKotlinExtentionsKt.d(r92), 0, 0, 0);
        r90.setLayoutParams(r91);
        r90.setFocusable(true);
        IPromotionUIConfig.d r93 = r33.a(PromotionCardModuleName.InfoAreaBenefitLabelModule);
        if (r93 == null) goto L197;
        IPromotionUIConfig.c r94 = r93.b();
        if (r94 == null) goto L197;
        Integer r95 = Integer.valueOf(r94.c());
        if (r95.intValue() <= 0) goto L189;
        boolean r96 = true;
    L190:
        if (r96 == true) goto L193;
        r95 = null;
    L193:
        if (r95 == null) goto L197;
        int r97 = r95.intValue();
        ViewGroup.LayoutParams r98 = r90.getLayoutParams();
        if (r98 == null) goto L197;
        r98.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r97));
        r90.setLayoutParams(r98);
        goto L197
    L189:
        r96 = false;
    L197:
        r68.addView(r90, r211);
        r90.a(r72, null);
        Unit r99 = Unit.INSTANCE;
        goto L198
    L181:
        r92 = 4;
        goto L182
    L199:
        r7 = null;
        Iterator r100 = com.bytedance.commerce.base.view.b.a(r68).subList(r110.size(), com.bytedance.commerce.base.view.b.a(r68).size()).iterator();
    L201:
        if (r100.hasNext() == false) goto L204;
        ((View) r100.next()).setVisibility(8);
        goto L201
    L204:
        if ((r68.getChildAt(r68.getChildCount() - 1) instanceof ECBenefitLabelView) == false) goto L208;
        r68.addView(new Space(r68.getContext()), new LinearLayout.LayoutParams(1, 0));
        goto L230
    L208:
        if ((r68.getChildAt(r68.getChildCount() - 1) instanceof ECBenefitLabelViewV2) == false) goto L211;
        r68.addView(new Space(r68.getContext()), new LinearLayout.LayoutParams(1, 0));
        goto L230
    L211:
        if ((r68.getChildAt(r68.getChildCount() - 1) instanceof Space) == false) goto L230;
        View r101 = r68.getChildAt(r68.getChildCount() - 1);
        if (r101 == null) goto L230;
        r101.setVisibility(0);
        goto L230
    L134:
        r69 = false;
    L215:
        r7 = null;
        goto L230
    L251:
        return;
    }

    public PromotionCardInfoLineContainer(Context r3, AttributeSet r4, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r5, LivePromotionCardArgsV2 r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 16) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, 0);
        this.b = r5;
        this.c = r6;
        this.a = new LinkedHashMap();
        setGravity(16);
        setOrientation(0);
        setImportantForAccessibility(4);
    }
}
