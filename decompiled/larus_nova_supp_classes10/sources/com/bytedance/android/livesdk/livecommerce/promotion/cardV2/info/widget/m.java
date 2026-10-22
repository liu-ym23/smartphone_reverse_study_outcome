package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.response.ECCarouselData;
import com.bytedance.android.ec.model.response.ECSalePointCarouselData;
import com.bytedance.android.ec.model.response.ECSalePointDataV2;
import com.bytedance.android.ec.model.response.a0;
import com.bytedance.android.ec.model.response.b0;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.ec.model.response.x;
import com.bytedance.android.ec.model.response.y;
import com.bytedance.android.ec.model.response.z;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.model.LivePromotionCardArgs;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m extends LinearLayout implements com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a {
    public LivePromotionCardArgs a;
    public b0 b;
    public boolean c;
    public long d;
    public com.bytedance.android.livesdk.livecommerce.promotion.card.k e;
    public u f;
    public ECSalePointView g;
    public ECSalePointView h;
    public ECSalePointViewV2 i;
    public ECSalePointViewV2 j;
    public com.bytedance.android.ec.core.utils.rotation.a k;
    public StringBuilder l;
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a m;

    public static final class a {
    }

    static {
    }

    public m(Context r3) {
        this(r3, null, 14);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getType() {
        return "tag_and_sales_point";
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    private final ECSalePointViewV2 getSalePointView() {
        ?? r0 = new ECSalePointViewV2(getContext());
        r0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        return r0;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public String getCurrentContentDescription() {
        StringBuilder r0 = this.l;
        if (r0 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.a
    public final void release() {
        LivePromotionCardArgs r0 = this.a;
        if (r0 == null) goto L7;
        ILivePromotionCardContainerHandler r1 = r0.b;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r2 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        u r3 = this.f;
        if (r3 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L10:
        r2.b(r3);
        com.bytedance.android.ec.core.utils.rotation.a r4 = this.k;
        if (r4 == null) goto L13;
        r4.a();
    L13:
        this.k = null;
        ?? r5 = this.i;
        if (r5 == 0) goto L16;
        r5.f = null;
        r5.g = null;
        r5.h = false;
        r5.removeAllViews();
        ((LinkedHashMap) r5.e).clear();
    L16:
        ?? r6 = this.j;
        if (r6 == 0) goto L20;
        r6.f = null;
        r6.g = null;
        r6.h = false;
        r6.removeAllViews();
        ((LinkedHashMap) r6.e).clear();
        return;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a getAbility() {
        return this.m;
    }

    public final void c(ECCarouselData r3) {
        if (r3.getType() != 3) goto L9;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r0 = this.m;
        if (r0 == null) goto L15;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r1 = r0.b();
        if (r1 == null) goto L16;
        r1.r(r3.getEventParam(), ECTagAndSalePointWidget$reportEvent$1.INSTANCE);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2 = this.m;
        if (r2 == null) goto L18;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r4 = r2.b();
        if (r4 == null) goto L19;
        r4.p(r3.getEventParam(), ECTagAndSalePointWidget$reportEvent$2.INSTANCE);
        return;
    L19:
        return;
    }

    public final void setArgument(LivePromotionCardArgs r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(ECSalePointViewV2 r19, ECSalePointDataV2 r20) {
        com.bytedance.android.livesdk.livecommerce.promotion.card.k r3 = this.e;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4 = this.m;
        if (r4 == null) goto L5;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r5 = r4.b();
    L6:
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "data");
        r19.removeAllViews();
        ((LinkedHashMap) r19.e).clear();
        r19.h = false;
        r19.f = r20;
        r19.g = r5;
        List r6 = r20.b();
        if (r6 == null) goto L64;
        Iterator r7 = r6.iterator();
        int r8 = 0;
    L10:
        if (r7.hasNext() == false) goto L64;
        Object r9 = r7.next();
        int r10 = r8 + 1;
        if (r8 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        x r11 = (x) r9;
        String r12 = a2.d(r11.b());
        if (r12 == null) goto L24;
        Context r13 = r19.getContext();
        TextView r14 = (TextView) r19.f(r19.b);
        if (r14 != null) goto L19;
        r14 = new TextView(r13);
        r14.setTextSize(1, 12.0f);
        r14.setTextColor(th.a.a(r13, 2131106066));
        r14.setEllipsize(TextUtils.TruncateAt.END);
        r14.setMaxLines(1);
        r14.setIncludeFontPadding(false);
    L19:
        r14.setText(r12);
        int r15 = com.bytedance.android.ec.core.utils.s.a;
        Integer r16 = com.bytedance.android.ec.core.utils.s.b(r11.a());
        if (r16 == null) goto L22;
        int r17 = r16.intValue();
    L23:
        r14.setTextColor(r17);
        r14.setEllipsize(TextUtils.TruncateAt.END);
    L25:
        if (r14 == null) goto L63;
        r19.e.put(r14, r11);
        if (r8 <= 0) goto L53;
        Context r18 = r19.getContext();
        y r21 = r20.d();
        if (r21 == null) goto L32;
        Long r22 = r21.b();
    L33:
        if (r22 != null) goto L36;
    L49:
        Space r23 = (Space) r19.f(r19.c);
        View r24 = r23;
        if (r23 != null) goto L52;
        Space r25 = new Space(r18);
        r25.setLayoutParams(new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(6), -1));
        r24 = r25;
    L52:
        r19.addView(r24);
        View r26 = r24;
    L54:
        r19.addView(r14);
        if (r26 == null) goto L57;
        r19.setHideGroup(new View[]{r26, r14});
    L57:
        if (r3 == null) goto L63;
        IPromotionUIConfig.d r27 = r3.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r27 == null) goto L63;
        IPromotionUIConfig.b r28 = r27.a();
        if (r28 == null) goto L63;
        UIConfigHelper.c(r14, r28);
        goto L63
    L36:
        if (r22.longValue() != 1) goto L49;
        View r29 = r19.f(r19.d);
        View r30 = r29;
        if (r29 != null) goto L40;
        r30 = new View(r18);
    L40:
        LinearLayoutCompat.LayoutParams r110 = new LinearLayoutCompat.LayoutParams(UtilityKotlinExtentionsKt.d(Double.valueOf(0.5d)), UtilityKotlinExtentionsKt.d(10));
        r110.setMargins(UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4), UtilityKotlinExtentionsKt.d(Double.valueOf(0.3d)));
        Unit r111 = Unit.INSTANCE;
        r30.setLayoutParams(r110);
        r30.setTag(2131370825, "divider_line");
        int r112 = com.bytedance.android.ec.core.utils.s.a;
        y r113 = r20.d();
        if (r113 == null) goto L43;
        String r114 = r113.a();
    L44:
        Integer r115 = com.bytedance.android.ec.core.utils.s.b(r114);
        if (r115 == null) goto L47;
        int r31 = r115.intValue();
    L48:
        r30.setBackgroundColor(r31);
        r24 = r30;
        goto L52
    L47:
        r31 = th.a.a(r18, 2131105956);
        goto L48
    L43:
        r114 = null;
        goto L44
    L32:
        r22 = null;
        goto L33
    L53:
        r26 = null;
    L63:
        r8 = r10;
        goto L10
    L22:
        r17 = th.a.a(r19.getContext(), 2131106066);
        goto L23
    L24:
        r14 = null;
    L64:
        StringBuilder r1 = this.l;
        if (r1 == null) goto L74;
        r1.append(r20.a());
        return;
    L74:
        return;
    L5:
        r5 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    /* JADX WARN: Type inference failed for: r4v14, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    public m(Context r3, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4, int r5) {
        if ((r5 & 2) == 0) goto L5;
        r4 = null;
    L5:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.m = r4;
        u r6 = new u(getContext(), r4);
        r6.setLayoutParams(new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(Float.valueOf(16.0f))));
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if (r7 == null) goto L16;
        ((LinearLayout.LayoutParams) r7).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(6.0f)), 0);
        r6.setVisibility(8);
        Unit r8 = Unit.INSTANCE;
        this.f = r6;
        addView(r6);
        this.g = new ECSalePointView(getContext());
        this.h = new ECSalePointView(getContext());
        FrameLayout r9 = new FrameLayout(getContext());
        ECSalePointView r10 = this.g;
        if (r10 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L10:
        r9.addView(r10);
        ECSalePointView r11 = this.h;
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L13:
        r9.addView(r11);
        ?? r12 = getSalePointView();
        this.i = r12;
        r9.addView(r12);
        ?? r13 = getSalePointView();
        this.j = r13;
        r9.addView(r13);
        addView(r9);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    /* JADX WARN: Type inference failed for: r13v1, types: [android.view.View, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECSalePointViewV2] */
    public final void a(b0 r21, boolean r22, long r23, com.bytedance.android.livesdk.livecommerce.promotion.card.k r25) {
        Intrinsics.checkNotNullParameter(r21, "model");
        Intrinsics.checkNotNullParameter(r25, "style");
        this.b = r21;
        this.c = r22;
        this.d = r23;
        this.e = r25;
        this.l = new StringBuilder();
        b0 r0 = this.b;
        if (r0 != null) goto L5;
    L63:
        b0 r1 = this.b;
        if (r1 == null) goto L68;
        z r2 = r1.a();
        if (r2 == null) goto L68;
        List r3 = r2.c();
    L70:
        if (r3 == null) goto L72;
        boolean r4 = true;
    L74:
        if (r4 == false) goto L136;
        ECSalePointView r5 = this.g;
        if (r5 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L78:
        r5.setVisibility(8);
        ECSalePointView r6 = this.h;
        if (r6 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L81:
        r6.setVisibility(8);
        LinearLayoutCompat r7 = this.i;
        if (r7 == null) goto L84;
        r7.setVisibility(8);
    L84:
        LinearLayoutCompat r8 = this.j;
        if (r8 == null) goto L87;
        r8.setVisibility(8);
    L87:
        b0 r9 = this.b;
        if (r9 == null) goto L90;
        z r10 = r9.a();
    L91:
        b0 r11 = this.b;
        if (r11 == null) goto L100;
        z r12 = r11.a();
        if (r12 == null) goto L100;
        List r13 = r12.c();
        if (r13 == null) goto L100;
        if ((!r13.isEmpty()) == false) goto L100;
        List r14 = r13;
    L101:
        if (r9 == null) goto L198;
        if (r10 == null) goto L199;
        if (r14 == null) goto L200;
        long r15 = r10.a();
        if (r15 > 0) goto L107;
    L129:
        ?? r16 = this.i;
        Object r17 = CollectionsKt.firstOrNull(r14);
        if (r16 == 0) goto L204;
        if (r17 == null) goto L205;
        ECSalePointDataV2 r18 = (ECSalePointDataV2) r17;
        StringBuilder r19 = this.l;
        if (r19 == null) goto L135;
        StringsKt.clear(r19);
    L135:
        r16.setVisibility(0);
        b(r16, r18);
        return;
    L205:
        return;
    L204:
        return;
    L107:
        if (r14.size() == 1) goto L129;
        if (r14.size() <= 1) goto L201;
        ?? r110 = this.i;
        if (r110 == 0) goto L213;
        ECSalePointViewV2 r20 = this.j;
        if (r20 == null) goto L214;
        com.bytedance.android.ec.core.utils.rotation.a r24 = this.k;
        if (r24 == null) goto L120;
        r24.a();
    L120:
        this.k = null;
        LivePromotionCardArgs r26 = this.a;
        if (r26 == null) goto L125;
        ILivePromotionCardContainerHandler r27 = r26.b;
        if (r27 == null) goto L125;
        boolean r111 = r27.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L126:
        this.k = new o(this, r110, r20, r14, r14, r15, r15, r111);
        r110.setVisibility(0);
        com.bytedance.android.ec.core.utils.rotation.a r28 = this.k;
        if (r28 == null) goto L202;
        r28.j();
        return;
    L202:
        return;
    L125:
        r111 = false;
        goto L126
    L214:
        return;
    L213:
        return;
    L201:
        return;
    L200:
        return;
    L199:
        return;
    L198:
        return;
    L100:
        r14 = null;
        goto L101
    L90:
        r10 = null;
        goto L91
    L136:
        LinearLayoutCompat r29 = this.i;
        if (r29 == null) goto L139;
        r29.setVisibility(8);
    L139:
        LinearLayoutCompat r30 = this.j;
        if (r30 == null) goto L142;
        r30.setVisibility(8);
    L142:
        ECSalePointView r31 = this.g;
        if (r31 != null) goto L145;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L145:
        r31.setVisibility(8);
        ECSalePointView r32 = this.h;
        if (r32 != null) goto L148;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout2");
    L148:
        r32.setVisibility(8);
        b0 r33 = this.b;
        if (r33 == null) goto L151;
        z r34 = r33.a();
    L152:
        b0 r35 = this.b;
        if (r35 == null) goto L161;
        z r36 = r35.a();
        if (r36 == null) goto L161;
        List r37 = r36.b();
        if (r37 == null) goto L161;
        if ((!r37.isEmpty()) == false) goto L161;
    L162:
        if (r33 == null) goto L207;
        if (r34 == null) goto L208;
        if (r37 == null) goto L209;
        ECSalePointCarouselData r38 = new ECSalePointCarouselData(r34.a(), r37, null, 4, null);
        if (r38.getCarouselTime() > 0) goto L168;
    L187:
        ECCarouselData r39 = (ECCarouselData) CollectionsKt.first(r37);
        ECSalePointView r40 = this.g;
        if (r40 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L190:
        r40.setVisibility(0);
        ECSalePointView r41 = this.g;
        if (r41 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L193:
        r41.a(r39, this.e);
        StringBuilder r42 = this.l;
        if (r42 == null) goto L196;
        StringsKt.append(r42, new String[]{r39.getBefore(), r39.getContent()});
    L196:
        c((ECCarouselData) CollectionsKt.first(r37));
        return;
    L168:
        if (r37.size() == 1) goto L187;
        if (r37.size() <= 1) goto L210;
        long r43 = r38.getCarouselTime();
        com.bytedance.android.ec.core.utils.rotation.a r44 = this.k;
        if (r44 == null) goto L175;
        r44.a();
    L175:
        this.k = null;
        LivePromotionCardArgs r45 = this.a;
        if (r45 == null) goto L180;
        ILivePromotionCardContainerHandler r46 = r45.b;
        if (r46 == null) goto L180;
        boolean r47 = r46.h(Decision.DEGRADE_SALE_POINT_LOOP);
    L181:
        this.k = new n(this, r37, r37, r43, r43, r47);
        ECSalePointView r48 = this.g;
        if (r48 != null) goto L184;
        Intrinsics.throwUninitializedPropertyAccessException("salePointLayout1");
    L184:
        r48.setVisibility(0);
        com.bytedance.android.ec.core.utils.rotation.a r49 = this.k;
        if (r49 == null) goto L211;
        r49.j();
        return;
    L211:
        return;
    L180:
        r47 = false;
        goto L181
    L210:
        return;
    L209:
        return;
    L208:
        return;
    L207:
        return;
    L161:
        r37 = null;
        goto L162
    L151:
        r34 = null;
        goto L152
    L72:
        r4 = false;
    L68:
        r3 = null;
        goto L70
    L5:
        if (r0.c() == null) goto L7;
    L13:
        u r50 = this.f;
        if (r50 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L16:
        r50.setVisibility(0);
        final u r51 = this.f;
        if (r51 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L19:
        boolean r52 = this.c;
        long r53 = this.d;
        int r54 = u.k;
        r51.getClass();
        Intrinsics.checkNotNullParameter(r0, "model");
        r51.e = r52;
        r51.f = r53;
        r51.d = false;
        t1 r55 = r0.c();
        if (r55 == null) goto L27;
        UtilityKotlinExtentionsKt.f(r55.c(), r55.a(), new TagIVAndCountdownLayout$bind$$inlined$let$lambda$1(r51));
        List r56 = r55.b();
        if (r56 == null) goto L26;
        String r112 = (String) CollectionsKt.firstOrNull(r56);
        if (r112 == null) goto L26;
        h0.e(r51.a, r112, null, null, null, 120);
    L26:
        ExtensionsKt.visible(r51.a);
    L28:
        r51.i = null;
        a0 r57 = r0.b();
        r51.c = r57;
        if (r57 == null) goto L35;
        r51.a(r57);
        ViewGroup.LayoutParams r58 = r51.a.getLayoutParams();
        if (r58 == null) goto L34;
        ((LinearLayout.LayoutParams) r58).setMargins(0, 0, UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f)), 0);
    L38:
        u r59 = this.f;
        if (r59 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L41:
        int r60 = u.k;
        if (r59.c(null) == false) goto L52;
        LivePromotionCardArgs r61 = this.a;
        if (r61 == null) goto L48;
        ILivePromotionCardContainerHandler r62 = r61.b;
        if (r62 == null) goto L48;
        r62.a();
    L48:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r63 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        u r64 = this.f;
        if (r64 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L51:
        r63.a(r64);
        goto L63
    L52:
        LivePromotionCardArgs r65 = this.a;
        if (r65 == null) goto L57;
        ILivePromotionCardContainerHandler r66 = r65.b;
        if (r66 == null) goto L57;
        r66.a();
    L57:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d r67 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a;
        u r68 = this.f;
        if (r68 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L60:
        r67.b(r68);
        goto L63
    L34:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L35:
        r51.b.setVisibility(8);
        ViewGroup.LayoutParams r69 = r51.a.getLayoutParams();
        if (r69 == null) goto L62;
        ((LinearLayout.LayoutParams) r69).setMargins(0, 0, 0, 0);
        goto L38
    L62:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        r51.a.setVisibility(8);
        goto L28
    L7:
        if (r0.b() != null) goto L13;
        u r70 = this.f;
        if (r70 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("tagIVAndCountdownLayout");
    L12:
        r70.setVisibility(8);
        goto L38
    }
}
