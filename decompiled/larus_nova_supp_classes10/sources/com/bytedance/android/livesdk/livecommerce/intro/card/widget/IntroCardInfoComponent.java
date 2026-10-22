package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoBenefitLabelWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoCustomTagWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoElasticTitleWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoProgressBarWidget;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.IntroInfoTagWidget;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroBenefit;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.i0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.p0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\b\b\u0002\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001d\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardInfoComponent;", "Landroid/widget/LinearLayout;", "", "", "getComponentContentDescription", "Loh2/e;", "a", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Landroid/widget/FrameLayout;", "d", "Lkotlin/Lazy;", "getShowViewGroup1", "()Landroid/widget/FrameLayout;", "showViewGroup1", "e", "getShowViewGroup2", "showViewGroup2", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardInfoComponent extends LinearLayout {
    public static final /* synthetic */ int g = 0;
    public e a;
    public oh2.c b;
    public final List<com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a> c;
    public final Lazy d;
    public final Lazy e;
    public c f;

    public static final class a {
    }

    static {
    }

    public IntroCardInfoComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardInfoComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final FrameLayout getShowViewGroup1() {
        return (FrameLayout) this.d.getValue();
    }

    private final FrameLayout getShowViewGroup2() {
        return (FrameLayout) this.e.getValue();
    }

    public final void c() {
        c r0 = this.f;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.f = null;
        getShowViewGroup1().removeAllViews();
        getShowViewGroup2().removeAllViews();
    }

    public final void f() {
        Iterator<T> r0 = this.c.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r0.next()).release();
        goto L4
    L6:
        ((ArrayList) this.c).clear();
        c();
    }

    public final String getComponentContentDescription() {
        StringBuilder r0 = new StringBuilder();
        Iterator<T> r1 = this.c.iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        r0.append(((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r1.next()).getCurrentContentDescription());
        goto L4
    L7:
        return r0.toString();
    }

    public e getArgument() {
        return this.a;
    }

    public oh2.c getContainerAbility() {
        return this.b;
    }

    public final void e(com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a r2) {
        r2.setArgument(getArgument());
        r2.setContainerAbility(getContainerAbility());
    }

    public void setArgument(e r1) {
        this.a = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.b = r1;
    }

    public final void a(g r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "benefitsModel");
        removeAllViews();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_RELEASE_FIX() == false) goto L8;
        Iterator<T> r0 = this.c.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r0.next()).release();
    L8:
        ((ArrayList) this.c).clear();
        c();
        List<p0> r10 = r8.a();
        if (r10 == null) goto L20;
        Iterator<T> r11 = r10.iterator();
        int r1 = 0;
    L12:
        if (r11.hasNext() == false) goto L25;
        Object r2 = r11.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        Pair<LinearLayout, Integer> r4 = d((p0) r2, r9);
        View r5 = (LinearLayout) r4.component1();
        int r6 = ((Number) r4.component2()).intValue();
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        if (r1 <= 0) goto L19;
        r7.topMargin = r6;
    L19:
        Unit r12 = Unit.INSTANCE;
        addView(r5, r7);
        r1 = r3;
        goto L12
    L25:
        return;
    }

    public final void b(l r15, int r16) {
        Intrinsics.checkNotNullParameter(r15, "benefitsModel");
        List<p0> r0 = r15.b();
        if (r0 != null) goto L5;
    L8:
        removeAllViews();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_INFO_RELEASE_FIX() == false) goto L14;
        Iterator r1 = ((ArrayList) this.c).iterator();
    L12:
        if (r1.hasNext() == false) goto L14;
        ((com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) r1.next()).release();
    L14:
        ((ArrayList) this.c).clear();
        c();
        addView(getShowViewGroup1(), new LinearLayout.LayoutParams(-1, -2));
        addView(getShowViewGroup2(), new LinearLayout.LayoutParams(-1, -2));
        List<p0> r6 = r15.b();
        if (r6 == null) goto L21;
        long r9 = r15.a() * ((long) 1000);
        FrameLayout r12 = getShowViewGroup1();
        FrameLayout r3 = getShowViewGroup2();
        c();
        this.f = new c(this, r12, r3, r16, r6, r6, r9, r9);
        r12.setVisibility(0);
        c r2 = this.f;
        if (r2 == null) goto L22;
        r2.j();
        return;
    L22:
        return;
    L21:
        return;
    L5:
        if (r0.size() != 1) goto L8;
        a(new g(r15.b()), r16);
    }

    public final Pair<LinearLayout, Integer> d(p0 r24, int r25) {
        th2.b r1 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r25));
        int r3 = 1;
        int r4 = 0;
        ql.a r5 = null;
        if (r1 == null) goto L13;
        Integer r2 = Integer.valueOf(r1.f());
        if (r2.intValue() < 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L11;
        r2 = null;
    L11:
        if (r2 == null) goto L13;
        int r7 = r2.intValue();
    L14:
        int r8 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r7));
        LinearLayout r9 = new LinearLayout(getContext());
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r9.setOrientation(0);
        List<IntroBenefit> r10 = r24.a();
        if (r10 == null) goto L234;
        Iterator r11 = r10.iterator();
        int r12 = 0;
    L18:
        if (r11.hasNext() == false) goto L234;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 >= 0) goto L22;
        CollectionsKt.throwIndexOverflow();
    L22:
        IntroBenefit r15 = (IntroBenefit) r13;
        Integer r16 = r15.b();
        int r17 = 2;
        int r18 = 6;
        if (r16 != null) goto L26;
    L70:
        if (r16 != null) goto L73;
    L185:
        Iterator r22 = r11;
        if (r16 != null) goto L189;
    L194:
        if (r16 != null) goto L197;
    L203:
        if (r16 != null) goto L206;
    L208:
        if (r16 != null) goto L211;
    L207:
        ql.a r19 = null;
        ql.a r110 = null;
    L219:
        int r111 = -2;
    L217:
        int r112 = -2;
    L221:
        if ((r110 instanceof com.bytedance.android.livesdk.livecommerce.intro.card.widget.info.a) == true) goto L223;
        ql.a r20 = r19;
    L224:
        if (r20 == null) goto L226;
        ((ArrayList) this.c).add(r20);
    L226:
        if (r110 == null) goto L232;
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(r112, r111);
        if (r12 <= 0) goto L230;
        r21.setMarginStart(UtilityKotlinExtentionsKt.d(4));
    L230:
        Unit r23 = Unit.INSTANCE;
        r9.addView(r110, r21);
    L232:
        r5 = r19;
        r12 = r14;
        r11 = r22;
        r3 = 1;
        r4 = 0;
        goto L18
    L223:
        r20 = r110;
        goto L224
    L211:
        if (r16.intValue() != 6) goto L207;
        List<ECRitTag> r26 = r15.c();
        if (r26 != null) goto L214;
    L193:
        r19 = null;
    L216:
        r110 = r19;
        goto L219
    L214:
        r19 = null;
        ql.a r27 = new IntroInfoCustomTagWidget(getContext(), null, 6, 0);
        e(r27);
        r27.a(r26);
    L215:
        r110 = r27;
        goto L219
    L206:
        if (r16.intValue() != 5) goto L208;
    L197:
        if (r16.intValue() != 4) goto L203;
        i0 r28 = r15.e();
        if (r28 == null) goto L201;
        ql.a r29 = new IntroInfoProgressBarWidget(getContext(), null, r18, 0);
        e(r29);
        r29.a(r28);
        r112 = -1;
    L202:
        r110 = r29;
        r19 = null;
        r111 = -2;
        goto L221
    L201:
        r29 = null;
        r112 = -2;
        goto L202
    L189:
        if (r16.intValue() != 3) goto L194;
        List<PromotionBenefitLabel> r30 = r15.a();
        if (r30 == null) goto L193;
        r27 = new IntroInfoBenefitLabelWidget(getContext(), null, 6, 0);
        e(r27);
        r27.a(r30);
        r19 = null;
        goto L215
    L73:
        if (r16.intValue() != 2) goto L185;
        List<ECRitTag> r31 = r15.f();
        if (r31 == null) goto L184;
        ql.a r113 = new IntroInfoTagWidget(getContext(), r5, 6, r4);
        e(r113);
        Intrinsics.checkNotNullParameter(r31, "tags");
        r113.d = new StringBuilder();
        r113.e = r31;
        List<ECRitTag> r32 = r31;
        Iterator<T> r114 = r32.iterator();
        int r115 = 0;
    L78:
        if (r114.hasNext() == false) goto L174;
        Object r116 = r114.next();
        int r117 = r115 + 1;
        if (r115 >= 0) goto L82;
        CollectionsKt.throwIndexOverflow();
    L82:
        ECRitTag r118 = (ECRitTag) r116;
        ECUIConfig r33 = r118.getUiConfig();
        List r119 = r118.getText();
        if (r119 == null) goto L85;
        ql.a r120 = (String) CollectionsKt.firstOrNull(r119);
    L86:
        if (r120 == null) goto L88;
        boolean r34 = true;
    L89:
        if (r33 == null) goto L91;
        Integer r121 = Integer.valueOf(r33.getTextSplitorStyle());
    L92:
        if (r121 == null) goto L109;
        if (r121.intValue() != 0) goto L109;
        ECUrlModel r35 = r118.getTextIcon();
        if (r35 == null) goto L102;
        if (r115 == 0) goto L100;
        boolean r36 = true;
    L101:
        r113.addView(r113.a(r35, r36, r34));
        goto L102
    L100:
        r36 = false;
    L102:
        List r37 = r118.getText();
        if (r37 == null) goto L107;
        String r38 = (String) CollectionsKt.firstOrNull(r37);
        if (r38 == null) goto L107;
        r113.addView(r113.b(r115, r38, r33));
    L107:
        r11 = r11;
    L173:
        r115 = r117;
        r11 = r11;
        r3 = 1;
        r5 = null;
        r17 = 2;
    L109:
        if (r121 == null) goto L128;
        if (r121.intValue() != r17) goto L128;
        if (r115 <= 0) goto L119;
        TextView r39 = new TextView(r113.getContext());
        r39.setTag("text");
        r39.setText(" · ");
        r39.setMaxLines(r3);
        r39.setTextSize(r3, 12.0f);
        r39.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int r40 = s.a;
        if (r33 == null) goto L117;
        String r41 = r33.getTextColor();
    L118:
        r39.setTextColor(s.a(r41, th.a.a(r39.getContext(), 2131106238)));
        r113.addView(r39);
        goto L119
    L117:
        r41 = null;
    L119:
        ECUrlModel r42 = r118.getTextIcon();
        if (r42 == null) goto L122;
        r113.addView(r113.a(r42, false, r34));
    L122:
        List r43 = r118.getText();
        if (r43 == null) goto L107;
        String r44 = (String) CollectionsKt.firstOrNull(r43);
        if (r44 == null) goto L107;
        r113.addView(r113.b(r115, r44, r33));
    L128:
        if (r115 <= 0) goto L131;
        View r122 = new View(r113.getContext());
        r122.setTag("divider");
        r122.setBackgroundColor(th.a.a(r122.getContext(), 2131106184));
        LinearLayout.LayoutParams r45 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(10.0f)));
        r45.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r45.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        r45.gravity = 17;
        Unit r46 = Unit.INSTANCE;
        r122.setLayoutParams(r45);
        r113.addView(r122);
    L131:
        ECUrlModel r47 = r118.getTextIcon();
        if (r47 == null) goto L134;
        r113.addView(r113.a(r47, false, r34));
    L134:
        List r48 = r118.getText();
        if (r48 == null) goto L173;
        String r49 = (String) CollectionsKt.firstOrNull(r48);
        if (r49 == null) goto L173;
        ECUrlModel r50 = r118.getTextIcon();
        if (r50 == null) goto L143;
        List r51 = r50.getUrlList();
        if (r51 == null) goto L143;
        String r52 = (String) CollectionsKt.firstOrNull(r51);
    L144:
        if (r52 == null) goto L146;
        boolean r53 = true;
    L147:
        TextView r54 = new TextView(r113.getContext());
        r54.setTag("text");
        r54.setMaxLines(1);
        if (r33 == null) goto L158;
        Integer r55 = Integer.valueOf(r33.getTextSize());
        if (r55.intValue() <= 0) goto L152;
        boolean r123 = true;
    L153:
        if (r123 == true) goto L156;
        r55 = null;
    L156:
        if (r55 == null) goto L158;
        float r56 = r55.intValue();
    L159:
        r54.setTextSize(r56);
        int r57 = s.a;
        if (r33 == null) goto L162;
        String r58 = r33.getTextColor();
    L163:
        r54.setTextColor(s.a(r58, th.a.a(r54.getContext(), 2131106238)));
        r54.setText(r49);
        ViewGroup.LayoutParams r59 = r54.getLayoutParams();
        if ((r59 instanceof LinearLayout.LayoutParams) == true) goto L166;
        r59 = null;
    L166:
        LinearLayout.LayoutParams r60 = (LinearLayout.LayoutParams) r59;
        if (r60 == null) goto L172;
        if (r53 == false) goto L170;
        int r61 = 0;
    L171:
        r60.leftMargin = r61;
        goto L172
    L170:
        r61 = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
    L172:
        r113.addView(r54);
        goto L173
    L162:
        r58 = null;
        goto L163
    L152:
        r123 = false;
    L158:
        r56 = 12.0f;
        goto L159
    L146:
        r53 = false;
    L143:
        r52 = null;
        goto L144
    L91:
        r121 = null;
        goto L92
    L88:
        r34 = false;
        goto L89
    L85:
        r120 = r5;
        goto L86
    L174:
        r22 = r11;
        if (r113.getChildCount() <= 0) goto L177;
        r113.addView(new Space(r113.getContext()), new LinearLayout.LayoutParams(1, 0));
    L177:
        Iterator<T> r62 = r32.iterator();
    L179:
        if (r62.hasNext() == false) goto L183;
        RitTagTrack r63 = ((ECRitTag) r62.next()).getTagTrack();
        if (r63 == null) goto L179;
        r63.setVisibile(true);
        goto L179
    L183:
        r110 = r113;
        r19 = null;
        goto L219
    L184:
        r22 = r11;
        r19 = r5;
        goto L216
    L26:
        if (r16.intValue() != r3) goto L70;
        com.bytedance.android.livesdk.livecommerce.intro.model.resp.s r64 = r15.d();
        if (r64 == null) goto L68;
        e r124 = getArgument();
        if (r124 == null) goto L47;
        com.bytedance.android.ec.common.api.jump.model.g r125 = (com.bytedance.android.ec.common.api.jump.model.g) r124.e.invoke(r5);
        if (r125 == null) goto L34;
        ql.a r126 = r125.a;
    L36:
        if ((r126 instanceof IntroPromotionVO) == true) goto L38;
        r126 = r5;
    L38:
        IntroPromotionVO r127 = (IntroPromotionVO) r126;
        if (r127 == null) goto L45;
        IntroProduct r128 = r127.getProduct();
        if (r128 == null) goto L45;
        if (r128.e() != r3) goto L45;
        int r129 = 1;
    L46:
        if (r129 != r3) goto L47;
    L65:
        r111 = UtilityKotlinExtentionsKt.d(16);
    L67:
        r110 = new IntroInfoElasticTitleWidget(getContext(), r5, r18, r4);
        r110.setArgument(getArgument());
        r110.setContainerAbility(getContainerAbility());
        r110.b(r64);
    L69:
        r19 = r5;
        r22 = r11;
    L45:
        r129 = 0;
        goto L46
    L34:
        r126 = r5;
    L47:
        e r130 = getArgument();
        if (r130 == null) goto L66;
        com.bytedance.android.ec.common.api.jump.model.g r131 = (com.bytedance.android.ec.common.api.jump.model.g) r130.e.invoke(r5);
        if (r131 == null) goto L52;
        ql.a r132 = r131.a;
    L54:
        if ((r132 instanceof IntroPromotionVO) == true) goto L56;
        r132 = r5;
    L56:
        IntroPromotionVO r133 = (IntroPromotionVO) r132;
        if (r133 == null) goto L63;
        IntroProduct r134 = r133.getProduct();
        if (r134 == null) goto L63;
        if (r134.e() != 2) goto L63;
        int r135 = 1;
    L64:
        if (r135 != r3) goto L66;
    L63:
        r135 = 0;
        goto L64
    L52:
        r132 = r5;
    L66:
        r111 = -2;
        goto L67
    L68:
        r110 = r5;
        r111 = -2;
    L234:
        return new Pair(r9, Integer.valueOf(r8));
    L7:
        r6 = false;
    L13:
        r7 = 4;
        goto L14
    }

    public IntroCardInfoComponent(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new ArrayList();
        this.d = LazyKt.lazy(new IntroCardInfoComponent$showViewGroup1$2(r2));
        this.e = LazyKt.lazy(new IntroCardInfoComponent$showViewGroup2$2(r2));
        setOrientation(1);
    }

    public /* synthetic */ IntroCardInfoComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
