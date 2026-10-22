package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.k;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPrice;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroPriceDescription;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.c0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.d0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.m;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.m0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.n0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.o;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.w;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroSkinHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinPriceUIConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import oh2.d;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001#B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardPriceComponent;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "", "", "getComponentContentDescription", "Loh2/e;", "d", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "e", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Lq83/a;", "k", "Lkotlin/Lazy;", "getTickListener", "()Lq83/a;", "tickListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardPriceComponent extends ECLargePriceAutoLocateLayout {
    public e d;
    public oh2.c e;
    public final PriceView f;
    public final TextView g;
    public final PriceView h;
    public final PriceView i;
    public IntroPrice j;
    public final Lazy k;

    public static final class a {
    }

    static {
    }

    public IntroCardPriceComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardPriceComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final q83.a getTickListener() {
        return (q83.a) this.k.getValue();
    }

    public final String getComponentContentDescription() {
        StringBuilder r0 = new StringBuilder();
        if (this.f.getVisibility() != 0) goto L6;
        r0.append(this.f.A());
    L6:
        if (this.h.getVisibility() != 0) goto L9;
        r0.append(2131913940);
        r0.append(this.h.A());
    L9:
        if (this.i.getVisibility() != 0) goto L12;
        r0.append(this.i.A());
    L12:
        return r0.toString();
    }

    public final void c() {
        e r0 = getArgument();
        if (r0 == null) goto L7;
        d r1 = r0.d;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTickListener());
    }

    public e getArgument() {
        return this.d;
    }

    public oh2.c getContainerAbility() {
        return this.e;
    }

    public void setArgument(e r1) {
        this.d = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.e = r1;
    }

    public final void b(IntroPrice r27, Integer r28) {
        Intrinsics.checkNotNullParameter(r27, "priceModel");
        this.j = r27;
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.HIDE_MODE);
        ECLiveABUtils r2 = ECLiveABUtils.INSTANCE;
        th2.b r3 = r2.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(r28);
        if (r3 == null) goto L6;
        ECLiveSkinPriceUIConfig r4 = r3.q();
        if (r4 == null) goto L6;
    L7:
        int r5 = IntroSkinHelper.a;
        IntroSkinHelper.b(this.f, r4);
        th2.b r6 = r2.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(r28);
        if (r6 == null) goto L11;
        ECLiveSkinPriceUIConfig r7 = r6.p();
        if (r7 == null) goto L11;
    L12:
        IntroSkinHelper.b(this.h, r7);
        th2.b r1 = r2.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(r28);
        int r9 = 2;
        if (r1 == null) goto L18;
        ECLiveSkinViewUIConfig r8 = r1.m();
        if (r8 == null) goto L18;
        ECLiveLayoutConfig r10 = r8.getLayout();
        if (r10 == null) goto L18;
    L19:
        Integer r11 = r10.getLeftMargin();
        if (r11 != null) goto L22;
    L30:
        int r12 = 0;
    L31:
        int r13 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r12));
        Integer r14 = r10.getTopMargin();
        if (r14 != null) goto L34;
    L42:
        int r15 = 0;
    L43:
        int r16 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r15));
        Integer r17 = r10.getRightMargin();
        if (r17 != null) goto L46;
    L54:
        int r18 = 0;
    L55:
        int r19 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r18));
        Integer r20 = r10.getBottomMargin();
        if (r20 != null) goto L58;
    L66:
        int r21 = 0;
    L67:
        int r22 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r21));
        Integer r23 = r10.getLeftPadding();
        if (r23 != null) goto L70;
    L78:
        int r24 = 2;
    L79:
        int r25 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r24));
        Integer r26 = r10.getTopPadding();
        if (r26 != null) goto L82;
    L90:
        int r29 = 0;
    L91:
        int r30 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r29));
        Integer r110 = r10.getRightPadding();
        if (r110 != null) goto L94;
    L102:
        int r111 = 0;
    L103:
        int r112 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r111));
        Integer r31 = r10.getBottomPadding();
        if (r31 != null) goto L106;
    L114:
        int r32 = 1;
    L115:
        int r33 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r32));
        d2.d(this.i, r13, r16, r19, r22);
        this.i.setPadding(r25, r30, r112, r33);
        Integer r34 = r27.b();
        if (r34 != null) goto L119;
    L224:
        if (r34 != null) goto L227;
    L231:
        if (r34 != null) goto L234;
        return;
    L234:
        if (r34.intValue() != 3) goto L251;
        n0 r0 = r27.d();
        if (r0 == null) goto L252;
        this.f.C(IntroCardPriceComponent$updateShowText$1.INSTANCE);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        String r35 = r0.a();
        if (r35 == null) goto L253;
        this.f.setText(r35);
        return;
    L253:
        return;
    L252:
        return;
    L251:
        return;
    L227:
        if (r34.intValue() != 2) goto L231;
        m r36 = r27.a();
        if (r36 == null) goto L249;
        this.f.C(IntroCardPriceComponent$updateCountDown$1.INSTANCE);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        d(true, r36);
        return;
    L249:
        return;
    L119:
        if (r34.intValue() != 1) goto L224;
        m0 r37 = r27.c();
        if (r37 == null) goto L246;
        final w r38 = r37.b();
        if (r38 == null) goto L131;
        this.f.getLayoutParams().width = -2;
        ViewGroup.LayoutParams r39 = this.f.getLayoutParams();
        if ((r39 instanceof LinearLayout.LayoutParams) == true) goto L127;
        r39 = null;
    L127:
        LinearLayout.LayoutParams r40 = (LinearLayout.LayoutParams) r39;
        if (r40 == null) goto L130;
        r40.weight = 0.0f;
    L130:
        this.f.C(new IntroCardPriceComponent$updateShowPrice$1$1(r38));
    L131:
        final Ref.BooleanRef r113 = new Ref.BooleanRef();
        r113.element = false;
        Ref.BooleanRef r41 = new Ref.BooleanRef();
        r41.element = false;
        Ref.BooleanRef r42 = new Ref.BooleanRef();
        r42.element = false;
        List<IntroPriceDescription> r43 = r37.a();
        if (r43 == null) goto L212;
        Iterator<T> r114 = r43.iterator();
    L135:
        if (r114.hasNext() == false) goto L212;
        final IntroPriceDescription r44 = (IntroPriceDescription) r114.next();
        Integer r45 = r44.a();
        if (r45 != null) goto L140;
    L166:
        if (r45 != null) goto L169;
    L179:
        final Ref.BooleanRef r210 = r42;
        final Ref.BooleanRef r115 = r41;
        if (r45 != null) goto L183;
    L210:
        final Ref.BooleanRef r46 = r210;
    L211:
        r42 = r46;
    L178:
        r41 = r115;
        r9 = 2;
        goto L135
    L183:
        if (r45.intValue() != 3) goto L210;
        c0 r47 = r44.b();
        if (r47 == null) goto L210;
        r46 = r210;
        r46.element = true;
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.DEFAULT_MODE);
        this.f.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(55.0f)));
        this.f.getLayoutParams().width = 0;
        ViewGroup.LayoutParams r48 = this.f.getLayoutParams();
        if (r48 == null) goto L209;
        ((LinearLayout.LayoutParams) r48).weight = 1.0f;
        String r49 = r47.b();
        if (r49 == null) goto L191;
        this.i.setText(r49);
    L191:
        String r50 = r47.c();
        if (r50 == null) goto L196;
        Integer r51 = s.b(r50);
        if (r51 == null) goto L196;
        this.i.setTextColor(r51.intValue());
    L196:
        String r52 = r47.a();
        if (r52 == null) goto L206;
        Integer r53 = s.b(r52);
        if (r53 == null) goto L204;
        int r54 = r53.intValue();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_FIX() == false) goto L203;
        PriceView r55 = this.i;
        GradientDrawable r56 = new GradientDrawable();
        r56.setColor(r54);
        r56.setCornerRadius(UtilityKotlinExtentionsKt.c(3));
        Unit r57 = Unit.INSTANCE;
        r55.setBackground(r56);
        PriceView r58 = this.i;
        r58.setTranslationY(r58.getPaddingBottom() * (-1));
    L205:
        UtilityKotlinExtentionsKt.h(r53, new IntroCardPriceComponent$updateShowPrice$$inlined$forEach$lambda$2(this, r113, r115, r46));
    L207:
        UtilityKotlinExtentionsKt.h(r52, new IntroCardPriceComponent$updateShowPrice$$inlined$forEach$lambda$3(this, r113, r115, r46));
        goto L211
    L203:
        this.i.setBackgroundColor(r54);
        goto L205
    L204:
        r53 = null;
        goto L205
    L206:
        r52 = null;
        goto L207
    L209:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L169:
        if (r45.intValue() != r9) goto L179;
        o r59 = r44.c();
        if (r59 != null) goto L172;
    L165:
        r115 = r41;
        r42 = r42;
        goto L178
    L172:
        final long r60 = Long.valueOf(r59.a()).longValue();
        r41.element = true;
        r210 = r42;
        final Ref.BooleanRef r61 = r41;
        r115 = r41;
        this.h.C(new IntroCardPriceComponent$updateShowPrice$$inlined$forEach$lambda$1(r60, r44, this, r113, r61, r210));
        this.h.setBackgroundColor(0);
        this.h.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r62 = this.h.getLayoutParams();
        if (r62 == null) goto L176;
        ViewGroup.MarginLayoutParams r63 = (ViewGroup.MarginLayoutParams) r62;
        r63.setMargins(r63.leftMargin, r63.topMargin, r63.rightMargin, 0);
        goto L210
    L176:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L140:
        if (r45.intValue() != 1) goto L166;
        d0 r64 = r44.d();
        if (r64 == null) goto L165;
        String r65 = r64.c();
        if (r65 == null) goto L165;
        if (r65.length() <= 0) goto L148;
        boolean r66 = true;
    L149:
        if (r66 == true) goto L152;
        r65 = null;
    L152:
        if (r65 == null) goto L165;
        r113.element = true;
        this.g.setText(r65);
        String r67 = r44.d().b();
        if (r67 == null) goto L158;
        Integer r68 = s.b(r67);
        if (r68 == null) goto L158;
        this.g.setTextColor(r68.intValue());
    L158:
        Boolean r69 = Boolean.valueOf(r44.d().a());
        if (r69.booleanValue() == true) goto L162;
        r69 = null;
    L162:
        if (r69 == null) goto L164;
        r69.booleanValue();
        this.g.setTypeface(Typeface.DEFAULT_BOLD);
        goto L165
    L164:
        this.g.setTypeface(Typeface.DEFAULT);
        Unit r70 = Unit.INSTANCE;
        goto L165
    L148:
        r66 = false;
    L212:
        Ref.BooleanRef r71 = r42;
        Ref.BooleanRef r116 = r41;
        if (r113.element == false) goto L215;
        this.g.setVisibility(0);
        int r72 = 8;
    L217:
        if (r116.element == false) goto L219;
        this.h.setVisibility(0);
    L221:
        if (r71.element == false) goto L223;
        this.i.setVisibility(0);
        return;
    L223:
        this.i.setVisibility(r72);
        return;
    L219:
        this.h.setVisibility(r72);
        goto L221
    L215:
        r72 = 8;
        this.g.setVisibility(8);
        goto L217
    L246:
        return;
    L106:
        if (r31.intValue() < 0) goto L108;
        boolean r117 = true;
    L109:
        if (r117 == true) goto L112;
        r31 = null;
    L112:
        if (r31 == null) goto L114;
        r32 = r31.intValue();
        goto L115
    L108:
        r117 = false;
        goto L109
    L94:
        if (r110.intValue() < 0) goto L96;
        boolean r118 = true;
    L97:
        if (r118 == true) goto L100;
        r110 = null;
    L100:
        if (r110 == null) goto L102;
        r111 = r110.intValue();
        goto L103
    L96:
        r118 = false;
        goto L97
    L82:
        if (r26.intValue() < 0) goto L84;
        boolean r119 = true;
    L85:
        if (r119 == true) goto L88;
        r26 = null;
    L88:
        if (r26 == null) goto L90;
        r29 = r26.intValue();
        goto L91
    L84:
        r119 = false;
        goto L85
    L70:
        if (r23.intValue() < 0) goto L72;
        boolean r73 = true;
    L73:
        if (r73 == true) goto L76;
        r23 = null;
    L76:
        if (r23 == null) goto L78;
        r24 = r23.intValue();
        goto L79
    L72:
        r73 = false;
        goto L73
    L58:
        if (r20.intValue() < 0) goto L60;
        boolean r74 = true;
    L61:
        if (r74 == true) goto L64;
        r20 = null;
    L64:
        if (r20 == null) goto L66;
        r21 = r20.intValue();
        goto L67
    L60:
        r74 = false;
        goto L61
    L46:
        if (r17.intValue() < 0) goto L48;
        boolean r75 = true;
    L49:
        if (r75 == true) goto L52;
        r17 = null;
    L52:
        if (r17 == null) goto L54;
        r18 = r17.intValue();
        goto L55
    L48:
        r75 = false;
        goto L49
    L34:
        if (r14.intValue() < 0) goto L36;
        boolean r76 = true;
    L37:
        if (r76 == true) goto L40;
        r14 = null;
    L40:
        if (r14 == null) goto L42;
        r15 = r14.intValue();
        goto L43
    L36:
        r76 = false;
        goto L37
    L22:
        if (r11.intValue() < 0) goto L24;
        boolean r77 = true;
    L25:
        if (r77 == true) goto L28;
        r11 = null;
    L28:
        if (r11 == null) goto L30;
        r12 = r11.intValue();
        goto L31
    L24:
        r77 = false;
    L18:
        r10 = new ECLiveLayoutConfig(0, 0, 0, 0, 0, 1, 2, 0, null, null, null, 1792, null);
    L11:
        r7 = new ECLiveSkinPriceUIConfig(10, 10, 10, 10, 10, CollectionsKt.listOf("#FFFFFF"), null, 64, null);
    L6:
        r4 = new ECLiveSkinPriceUIConfig(12, 18, 11, 10, 10, CollectionsKt.listOf("#FFFFFF"), null, 64, null);
        goto L7
    }

    public final void d(boolean r7, m r8) {
        String r0 = null;
        if (r8 == null) goto L5;
        k r9 = r8.a();
    L6:
        if (r9 != null) goto L14;
        e r10 = getArgument();
        if (r10 == null) goto L12;
        d r11 = r10.d;
        if (r11 == null) goto L12;
        r11.a();
    L12:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTickListener());
        return;
    L14:
        oh2.c r1 = getContainerAbility();
        if (r1 == null) goto L19;
        Long r12 = r1.b(r9.c(), r9.a());
        if (r12 == null) goto L19;
        long r2 = r12.longValue();
    L20:
        int r13 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a;
        String r14 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a(r2 - SystemClock.elapsedRealtime());
        if (r14.length() <= 0) goto L23;
        boolean r3 = true;
    L24:
        if (r3 == false) goto L26;
        r0 = r14;
    L26:
        if (r0 == null) goto L36;
        this.f.setText(th.a.h(getContext(), 2131896642, new Object[]{r14}));
        if (r7 == false) goto L43;
        e r15 = getArgument();
        if (r15 == null) goto L34;
        d r16 = r15.d;
        if (r16 == null) goto L34;
        r16.a();
    L34:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(getTickListener());
        return;
    L43:
        return;
    L36:
        e r17 = getArgument();
        if (r17 == null) goto L41;
        d r18 = r17.d;
        if (r18 == null) goto L41;
        r18.a();
    L41:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTickListener());
        return;
    L23:
        r3 = false;
    L19:
        r2 = 0;
        goto L20
    L5:
        r9 = null;
        goto L6
    }

    public IntroCardPriceComponent(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7);
        this.k = LazyKt.lazy(new IntroCardPriceComponent$tickListener$2(this));
        th.a.c(r5, 2131560749, this, true);
        PriceView r8 = findViewById(2131383478);
        this.f = r8;
        TextView r9 = (TextView) findViewById(2131390486);
        this.g = r9;
        PriceView r10 = findViewById(2131383481);
        this.h = r10;
        PriceView r0 = findViewById(2131383476);
        this.i = r0;
        setGravity(80);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_FIX() == false) goto L7;
        r8.setIncludeFontPadding(false);
        r9.setIncludeFontPadding(false);
        r10.setIncludeFontPadding(false);
        r0.setIncludeFontPadding(false);
        if (Build.VERSION.SDK_INT < 28) goto L8;
        r8.setFallbackLineSpacing(false);
        r9.setFallbackLineSpacing(false);
        r10.setFallbackLineSpacing(false);
        r0.setFallbackLineSpacing(false);
    L8:
        PriceView.z(r8, MonitorLevel.FATAL, 4);
        return;
    L7:
        r9.setTranslationY(-2.0f);
        goto L8
    }

    public /* synthetic */ IntroCardPriceComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
