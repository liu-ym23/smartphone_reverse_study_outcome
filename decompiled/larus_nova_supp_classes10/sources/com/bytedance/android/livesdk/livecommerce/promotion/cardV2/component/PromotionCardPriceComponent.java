package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import android.content.Context;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.android.ec.core.utils.s;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.response.PriceDescriptionType;
import com.bytedance.android.ec.model.response.PromotionPriceType;
import com.bytedance.android.ec.model.response.c1;
import com.bytedance.android.ec.model.response.d1;
import com.bytedance.android.ec.model.response.e1;
import com.bytedance.android.ec.model.response.h1;
import com.bytedance.android.ec.model.response.i1;
import com.bytedance.android.ec.model.response.m;
import com.bytedance.android.ec.model.response.m0;
import com.bytedance.android.ec.model.response.n0;
import com.bytedance.android.ec.model.response.u0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.Decision;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\u001b\u0010\u0010\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/component/PromotionCardPriceComponent;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/card/widget/ECLargePriceAutoLocateLayout;", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/LivePromotionCardArgsV2;", "argument", "", "setArgument", "Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/a;", "ability", "setAbility", "", "getReadableText", "Lq83/a;", "l", "Lkotlin/Lazy;", "getTICK_LISTENER", "()Lq83/a;", "TICK_LISTENER", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardPriceComponent extends ECLargePriceAutoLocateLayout {
    public static final /* synthetic */ int m = 0;
    public LivePromotionCardArgsV2 d;
    public jj2.e e;
    public com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f;
    public final PriceView g;
    public final TextView h;
    public final PriceView i;
    public final PriceView j;
    public int k;
    public final Lazy l;

    public static final class a {
    }

    static {
    }

    public PromotionCardPriceComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PromotionCardPriceComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final q83.a getTICK_LISTENER() {
        return (q83.a) this.l.getValue();
    }

    public final void c() {
        LivePromotionCardArgsV2 r0 = this.d;
        if (r0 == null) goto L7;
        ILivePromotionCardContainerHandler r1 = r0.b;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTICK_LISTENER());
    }

    public final String getReadableText() {
        boolean r1 = true;
        if (this.g.getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        String r3 = "";
        if (r0 == false) goto L10;
        r3 = "" + this.g.A();
    L10:
        if (this.i.getVisibility() != 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        r3 = (r3 + th.a.g(getContext(), 2131913940)) + this.i.A();
    L16:
        if (this.j.getVisibility() == 0) goto L19;
        r1 = false;
    L19:
        if (r1 == true) goto L21;
        return r3;
    L21:
        return r3 + this.j.A();
    L12:
        r2 = false;
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public final void b(final jj2.e r19) {
        Intrinsics.checkNotNullParameter(r19, "model");
        jj2.e r1 = this.e;
        if (r1 == null) goto L5;
        d1 r2 = r1.a;
    L7:
        if ((!Intrinsics.areEqual(r2, r19.a)) == false) goto L9;
        c();
        this.e = r19;
    L9:
        LivePromotionCardArgsV2 r3 = this.d;
        int r11 = 2;
        int r12 = 3;
        if (r3 == null) goto L16;
        ILivePromotionCardContainerHandler r4 = r3.b;
        if (r4 == null) goto L16;
        if (r4.h(Decision.ADJUST_INSTANT_FUSION) != true) goto L16;
        PriceView r5 = this.i;
        Boolean r6 = Boolean.TRUE;
        setCustomHideSequence(CollectionsKt.listOf(new Pair[]{new Pair(this.g, Boolean.FALSE), new Pair(r5, r6), new Pair(this.j, r6), new Pair(this.h, r6)}));
    L17:
        this.g.C(new PromotionCardPriceComponent$initSkinStyle$1(r19));
        this.i.C(new PromotionCardPriceComponent$initSkinStyle$2(r19));
        IPromotionUIConfig.d r7 = r19.c.a(PromotionCardModuleName.DescPriceAreaModule);
        if (r7 == null) goto L20;
        int r8 = UIConfigHelper.a;
        UIConfigHelper.d(this.h, r7);
    L20:
        PromotionPriceType r9 = r19.a.b();
        if (r9 == null) goto L131;
        int r10 = l.b[r9.ordinal()];
        if (r10 == 1) goto L34;
        if (r10 == 2) goto L33;
        if (r10 != 3) goto L132;
        this.g.C(new PromotionCardPriceComponent$bindData$3(r19));
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        i1 r0 = r19.a.d();
        if (r0 == null) goto L125;
        String r13 = r0.a();
        if (r13 == null) goto L126;
        this.g.setText(r13);
        return;
    L126:
        return;
    L125:
        return;
    L132:
        return;
    L33:
        this.g.C(new PromotionCardPriceComponent$bindData$2(r19));
        this.h.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        d(true);
        return;
    L34:
        h1 r14 = r19.a.c();
        if (r14 == null) goto L129;
        final c1 r15 = r14.b();
        if (r15 == null) goto L43;
        this.g.getLayoutParams().width = -2;
        ViewGroup.LayoutParams r16 = this.g.getLayoutParams();
        if (r16 == null) goto L42;
        ((LinearLayout.LayoutParams) r16).weight = 0.0f;
        this.g.C(new PromotionCardPriceComponent$bindData$1$1$1(r15));
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L43:
        Ref.BooleanRef r17 = new Ref.BooleanRef();
        r17.element = false;
        Ref.BooleanRef r18 = new Ref.BooleanRef();
        r18.element = false;
        Ref.BooleanRef r20 = new Ref.BooleanRef();
        r20.element = false;
        List r21 = r14.a();
        if (r21 == null) goto L103;
        Iterator r110 = r21.iterator();
    L47:
        if (r110.hasNext() == false) goto L103;
        final e1 r22 = (e1) r110.next();
        PriceDescriptionType r23 = r22.a();
        if (r23 != null) goto L51;
    L50:
        final Ref.BooleanRef r111 = r20;
        Ref.BooleanRef r112 = r18;
        Ref.BooleanRef r113 = r17;
    L102:
        r18 = r112;
        r17 = r113;
        r20 = r111;
        r11 = 2;
        r12 = 3;
        goto L47
    L51:
        int r24 = l.a[r23.ordinal()];
        if (r24 == 1) goto L82;
        if (r24 == r11) goto L75;
        if (r24 != r12) goto L50;
        this.k = 1;
        m0 r25 = r22.b();
        if (r25 == null) goto L50;
        r20.element = true;
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.DEFAULT_MODE);
        this.g.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(55.0f)));
        this.g.getLayoutParams().width = 0;
        ViewGroup.LayoutParams r26 = this.g.getLayoutParams();
        if (r26 == null) goto L74;
        ((LinearLayout.LayoutParams) r26).weight = 1.0f;
        String r27 = r25.b();
        if (r27 == null) goto L63;
        this.j.setText(r27);
    L63:
        String r28 = r25.c();
        if (r28 == null) goto L68;
        Integer r29 = s.b(r28);
        if (r29 == null) goto L68;
        this.j.setTextColor(r29.intValue());
    L68:
        String r30 = r25.a();
        if (r30 == null) goto L50;
        Integer r31 = s.b(r30);
        if (r31 == null) goto L50;
        this.j.setBackgroundColor(r31.intValue());
        goto L50
    L74:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L75:
        m r32 = r22.c();
        if (r32 == null) goto L50;
        final long r33 = Long.valueOf(r32.a()).longValue();
        r18.element = true;
        final Ref.BooleanRef r34 = r17;
        r111 = r20;
        final Ref.BooleanRef r35 = r18;
        r112 = r18;
        r113 = r17;
        this.i.C(new PromotionCardPriceComponent$bindData$$inlined$also$lambda$1(r33, r22, r34, r35, r111, this));
        this.i.setBackgroundColor(0);
        this.i.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams r36 = this.i.getLayoutParams();
        if (r36 == null) goto L81;
        ViewGroup.MarginLayoutParams r37 = (ViewGroup.MarginLayoutParams) r36;
        r37.setMargins(r37.leftMargin, r37.topMargin, r37.rightMargin, 0);
        goto L102
    L81:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L82:
        r111 = r20;
        r112 = r18;
        r113 = r17;
        n0 r38 = r22.d();
        if (r38 == null) goto L102;
        String r39 = r38.c();
        if (r39 == null) goto L102;
        r113.element = true;
        this.h.setText(r39);
        n0 r40 = r22.d();
        if (r40 == null) goto L93;
        String r41 = r40.b();
        if (r41 == null) goto L93;
        Integer r42 = s.b(r41);
        if (r42 == null) goto L93;
        this.h.setTextColor(r42.intValue());
    L93:
        n0 r43 = r22.d();
        if (r43 == null) goto L101;
        Boolean r44 = Boolean.valueOf(r43.a());
        if (r44.booleanValue() == true) goto L99;
        r44 = null;
    L99:
        if (r44 == null) goto L101;
        r44.booleanValue();
        this.h.setTypeface(Typeface.DEFAULT_BOLD);
    L101:
        this.h.setTypeface(Typeface.DEFAULT);
        Unit r45 = Unit.INSTANCE;
    L103:
        Ref.BooleanRef r114 = r20;
        Ref.BooleanRef r115 = r18;
        if (r17.element == false) goto L106;
        this.h.setVisibility(0);
    L108:
        if (r115.element == false) goto L110;
        this.i.setVisibility(0);
    L112:
        if (r114.element == false) goto L114;
        this.j.setVisibility(0);
        return;
    L114:
        this.j.setVisibility(8);
        return;
    L110:
        this.i.setVisibility(8);
        goto L112
    L106:
        this.h.setVisibility(8);
        goto L108
    L129:
        return;
    L131:
        return;
    L16:
        setMode(ECLargePriceAutoLocateLayout.AutoLocateMode.HIDE_MODE);
        goto L17
    L5:
        r2 = null;
        goto L7
    }

    public final void d(boolean r8) {
        jj2.e r0 = this.e;
        String r1 = null;
        if (r0 == null) goto L9;
        d1 r2 = r0.a;
        if (r2 == null) goto L9;
        u0 r3 = r2.a();
        if (r3 == null) goto L9;
        com.bytedance.android.ec.model.response.k r4 = r3.a();
    L10:
        if (r4 != null) goto L18;
        LivePromotionCardArgsV2 r9 = this.d;
        if (r9 == null) goto L16;
        ILivePromotionCardContainerHandler r10 = r9.b;
        if (r10 == null) goto L16;
        r10.a();
    L16:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTICK_LISTENER());
        return;
    L18:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r5 = this.f;
        if (r5 == null) goto L23;
        Long r6 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.a(r5, r4.c(), r4.a());
        if (r6 == null) goto L23;
        long r7 = r6.longValue();
    L24:
        int r11 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a;
        String r12 = com.bytedance.android.livesdk.livecommerce.promotion.card.utils.c.a(r7 - SystemClock.elapsedRealtime());
        jj2.e r13 = this.e;
        if (r13 == null) goto L32;
        d1 r14 = r13.a;
        if (r14 == null) goto L32;
        u0 r15 = r14.a();
        if (r15 == null) goto L32;
        r1 = r15.b();
    L32:
        if (r12.length() <= 0) goto L34;
        boolean r16 = true;
    L35:
        if (r16 == false) goto L37;
        r1 = th.a.h(getContext(), 2131896642, new Object[]{r12});
    L43:
        this.g.setText(r1);
        if (r8 == false) goto L52;
        LivePromotionCardArgsV2 r17 = this.d;
        if (r17 == null) goto L50;
        ILivePromotionCardContainerHandler r18 = r17.b;
        if (r18 == null) goto L50;
        r18.a();
    L50:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.a(getTICK_LISTENER());
        return;
    L52:
        return;
    L37:
        LivePromotionCardArgsV2 r19 = this.d;
        if (r19 == null) goto L42;
        ILivePromotionCardContainerHandler r20 = r19.b;
        if (r20 == null) goto L42;
        r20.a();
    L42:
        com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d.a.b(getTICK_LISTENER());
        goto L43
    L34:
        r16 = false;
    L23:
        r7 = 0;
    L9:
        r4 = null;
        goto L10
    }

    public final void setAbility(com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "ability");
        this.f = r2;
    }

    public final void setArgument(LivePromotionCardArgsV2 r2) {
        Intrinsics.checkNotNullParameter(r2, "argument");
        this.d = r2;
        this.g.C(PromotionCardPriceComponent$initOptStyle$1.INSTANCE);     // Catch: Exception -> L5
        this.j.C(PromotionCardPriceComponent$initOptStyle$2.INSTANCE);     // Catch: Exception -> L5
    L8:
        if (isBaselineAligned() == false) goto L13;
        setBaselineAligned(false);
        return;
    L13:
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECLargePriceAutoLocateLayout, android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r4, int r5) {
        super.onMeasure(r4, r5);
        if (this.k != 1) goto L15;
        float r6 = this.g.getTextSize();
        if (r6 < q.b(Float.valueOf(12.0f))) goto L7;
        int r7 = (int) ((r6 - q.b(Float.valueOf(12.0f))) * 0.6f);
    L8:
        ViewGroup.LayoutParams r8 = this.j.getLayoutParams();
        if (r8 == null) goto L14;
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r8;
        if (r9.bottomMargin == r7) goto L16;
        r9.setMargins(r9.leftMargin, r9.topMargin, r9.rightMargin, r7);
        return;
    L16:
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L7:
        r7 = 0;
        goto L8
    }

    public PromotionCardPriceComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.l = LazyKt.lazy(new PromotionCardPriceComponent$TICK_LISTENER$2(this));
        th.a.c(r2, 2131564755, this, true);
        this.g = findViewById(2131383478);
        this.h = (TextView) findViewById(2131390486);
        this.i = findViewById(2131383481);
        PriceView r5 = findViewById(2131383476);
        this.j = r5;
        r5.setMaxWidth(UtilityKotlinExtentionsKt.c(Float.valueOf(46.0f)));
    }

    public /* synthetic */ PromotionCardPriceComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
