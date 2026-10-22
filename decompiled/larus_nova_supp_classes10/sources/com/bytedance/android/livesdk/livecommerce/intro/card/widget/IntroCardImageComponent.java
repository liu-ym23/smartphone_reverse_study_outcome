package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.graphics.Outline;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.c0;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.t1;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.presenter.d;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroImageBottom;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.t;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.v;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroSkinHelper;
import com.bytedance.android.livesdk.livecommerce.intro.utils.k;
import com.bytedance.android.livesdk.livecommerce.iron.ui.ECCustomizedElementView;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinTextElement;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardImageComponent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "visible", "", "setImageTagVisibility", "Loh2/e;", "a", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/d;", "c", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/d;", "getPresenter", "()Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/d;", "setPresenter", "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/d;)V", "presenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardImageComponent extends ConstraintLayout {
    public static final /* synthetic */ int t = 0;
    public e a;
    public oh2.c b;
    public d c;
    public u d;
    public final TextView e;
    public final ECDraweeView f;
    public final LinearLayout g;
    public final ECCustomizedElementView h;
    public final ECDraweeView i;
    public final ECDraweeView j;
    public final TextView k;
    public final ECDraweeView l;
    public final ECDraweeView m;
    public final ECDraweeView n;
    public final TextView o;
    public final r p;
    public c q;
    public String r;
    public Uri s;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r8, Outline r9) {
            Intrinsics.checkNotNullParameter(r8, "view");
            Intrinsics.checkNotNullParameter(r9, "outline");
            r9.setRoundRect(0, 0, r8.getWidth(), r8.getHeight(), UtilityKotlinExtentionsKt.c(8));
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LinearLayout a;
        public final /* synthetic */ IntroCardImageComponent b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;

        public static final class a implements Runnable {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a.setVisibility(8);     // Catch: Throwable -> L4
                c r0 = this.a;     // Catch: Throwable -> L4
                IntroCardImageComponent r1 = r0.b;     // Catch: Throwable -> L4
                List<t> r2 = r0.c;     // Catch: Throwable -> L4
                int r3 = r0.d + 1;     // Catch: Throwable -> L4
                int r4 = IntroCardImageComponent.t;     // Catch: Throwable -> L4
                r1.T5(r2, r3);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public c(LinearLayout r1, IntroCardImageComponent r2, List r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LinearLayout r0 = this.a;     // Catch: Throwable -> L4
            UIConfigHelper.a(r0, r0, new a(this));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public IntroCardImageComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardImageComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void S5() {
        c r0 = this.q;
        if (r0 == null) goto L5;
        Lazy r1 = UIUtils.a;
        UIUtils.c().removeCallbacks(r0);
    L5:
        this.q = null;
    }

    public e getArgument() {
        return this.a;
    }

    public oh2.c getContainerAbility() {
        return this.b;
    }

    public final d getPresenter() {
        return this.c;
    }

    public void setArgument(e r1) {
        this.a = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.b = r1;
    }

    public final void setImageTagVisibility(boolean r5) {
        LinearLayout r0 = this.g;
        float r1 = 1.0f;
        if (r5 == false) goto L5;
        float r3 = 1.0f;
    L6:
        r0.setAlpha(r3);
        ECCustomizedElementView r2 = this.h;
        if (r5 == true) goto L10;
        r1 = 0.0f;
    L10:
        r2.setAlpha(r1);
        return;
    L5:
        r3 = 0.0f;
        goto L6
    }

    public final void setPresenter(d r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardImageComponent$updateExplainBar$1] */
    public final void R5(u r24, int r25) {
        Intrinsics.checkNotNullParameter(r24, "image");
        if ((!Intrinsics.areEqual(this.d, r24)) == false) goto L5;
        S5();
    L5:
        this.d = r24;
        ECLiveABUtils r2 = ECLiveABUtils.INSTANCE;
        th2.b r4 = r2.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r25));
        boolean r6 = false;
        if (r4 == null) goto L89;
        ECLiveSkinViewUIConfig r5 = r4.o();
        if (r5 == null) goto L89;
        ECLiveLayoutConfig r7 = r5.getLayout();
        if (r7 == null) goto L89;
        Integer r8 = r7.getWidth();
        int r9 = 100;
        if (r8 != null) goto L14;
    L22:
        int r10 = 100;
    L23:
        ViewGroup.LayoutParams r11 = getLayoutParams();
        if (r11 == null) goto L26;
        r11.width = UtilityKotlinExtentionsKt.d(Integer.valueOf(r10));
    L26:
        Integer r12 = r7.getHeight();
        if (r12 != null) goto L29;
    L37:
        ViewGroup.LayoutParams r13 = getLayoutParams();
        if (r13 == null) goto L40;
        r13.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r9));
    L40:
        Integer r14 = r7.getLeftMargin();
        if (r14 != null) goto L43;
    L51:
        int r15 = 8;
    L52:
        d2.c(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r15)));
        Integer r16 = r7.getTopMargin();
        if (r16 != null) goto L55;
    L63:
        int r17 = 8;
    L64:
        d2.f(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r17)));
        Integer r18 = r7.getRightMargin();
        if (r18 != null) goto L67;
    L75:
        int r19 = 8;
    L76:
        d2.e(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r19)));
        Integer r20 = r7.getBottomMargin();
        if (r20 != null) goto L79;
    L87:
        int r21 = 8;
    L88:
        d2.a(this, UtilityKotlinExtentionsKt.d(Integer.valueOf(r21)));
    L90:
        UtilityKotlinExtentionsKt.h(r7, new IntroCardImageComponent$updateShowStyle$2(this));
        th2.b r22 = r2.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r25));
        int r23 = 12;
        if (r22 == null) goto L96;
        ECLiveSkinViewUIConfig r26 = r22.v();
        if (r26 == null) goto L96;
        ECLiveSkinTextElement r27 = r26.getText();
        if (r27 == null) goto L96;
    L97:
        int r28 = IntroSkinHelper.a;
        IntroSkinHelper.a(this.k, r27);
        List<t> r29 = r24.d();
        List<t> r30 = r29;
        if (r30 != null) goto L100;
    L103:
        boolean r31 = true;
    L104:
        if (r31 == false) goto L106;
        this.g.setVisibility(8);
        this.h.setVisibility(8);
    L107:
        String r110 = r24.a();
        if (r110 == null) goto L110;
        this.j.setVisibility(0);
        h0.e(this.j, r110, this.p, null, null, 120);
    L111:
        String r32 = r24.c();
        if (r32 == null) goto L123;
        this.i.setVisibility(0);
        if ((!Intrinsics.areEqual(r32, this.r)) == false) goto L124;
        com.bytedance.android.livesdk.livecommerce.intro.card.widget.b r111 = new com.bytedance.android.livesdk.livecommerce.intro.card.widget.b(this);
        IntroCardImageComponent$updateMainImage$1$bindConfig$2 r210 = IntroCardImageComponent$updateMainImage$1$bindConfig$2.INSTANCE;
        ECDraweeView r33 = this.i;
        r r112 = this.p;
        h0 r113 = h0.a;
        Intrinsics.checkNotNullParameter(r33, "draweeView");
        if (r32.length() != 0) goto L118;
        boolean r114 = true;
    L119:
        if (r114 == true) goto L122;
        ImageExtensionsKt.w(r33, r32, null, r112, null, null, null, null, r111, false, null, r210, 2816);
    L122:
        this.r = r32;
        goto L124
    L118:
        r114 = false;
    L124:
        String r34 = r24.e();
        if (r34 == null) goto L127;
        this.k.setVisibility(0);
        this.k.setText(r34);
    L128:
        IntroImageBottom r1 = r24.b();
        ?? r35 = new IntroCardImageComponent$updateExplainBar$1(this);
        if (r1 == null) goto L131;
        Integer r36 = r1.b();
    L132:
        if (r36 != null) goto L135;
    L246:
        r35.m695invoke();
        return;
    L135:
        if (r36.intValue() != 1) goto L246;
        final v r3 = r1.a();
        if (r3 == null) goto L245;
        t1 r37 = r3.a();
        if (r37 == null) goto L159;
        List r38 = r37.b();
        if (r38 == null) goto L159;
        String r115 = (String) CollectionsKt.firstOrNull(r38);
        if (r115 == null) goto L159;
        this.l.setVisibility(0);
        h0.e(this.l, r115, this.p, null, null, 120);
        t1 r39 = r3.a();
        if (r39 == null) goto L157;
        Long r40 = r39.a();
        if (r40 == null) goto L157;
        if (r40.longValue() <= 0) goto L151;
        boolean r41 = true;
    L152:
        if (r41 == true) goto L155;
        r40 = null;
    L155:
        if (r40 == null) goto L157;
        o0.d(this.l, UtilityKotlinExtentionsKt.d(Long.valueOf(r40.longValue())));
        this.l.setAdjustMode(0);
    L158:
        UtilityKotlinExtentionsKt.h(r40, new IntroCardImageComponent$updateExplainBar$$inlined$also$lambda$1(r3, this));
    L160:
        t1 r42 = r3.c();
        if (r42 == null) goto L167;
        List r43 = r42.b();
        if (r43 == null) goto L167;
        String r44 = (String) CollectionsKt.firstOrNull(r43);
        if (r44 == null) goto L167;
        Uri r45 = UriProtector.parse(r44);
    L168:
        t1 r46 = r3.c();
        if (r46 == null) goto L187;
        List r47 = r46.b();
        if (r47 == null) goto L187;
        String r116 = (String) CollectionsKt.firstOrNull(r47);
        if (r116 == null) goto L187;
        this.m.setVisibility(0);
        this.m.setAutoPlayAnimation(true);
        if (r2.getEC_LIVE_INTRO_CARD_FIX_IMAGE() == false) goto L186;
        if (r45 == null) goto L178;
        String r48 = r45.getPath();
    L179:
        Uri r117 = this.s;
        if (r117 == null) goto L182;
        String r118 = r117.getPath();
    L184:
        if ((!Intrinsics.areEqual(r48, r118)) == false) goto L188;
        h0.e(this.m, r116, this.p, null, null, 120);
    L188:
        t1 r49 = r3.d();
        if (r49 == null) goto L195;
        List r50 = r49.b();
        if (r50 == null) goto L195;
        String r51 = (String) CollectionsKt.firstOrNull(r50);
        if (r51 == null) goto L195;
        Uri r52 = UriProtector.parse(r51);
    L196:
        t1 r119 = r3.d();
        if (r119 == null) goto L215;
        List r120 = r119.b();
        if (r120 == null) goto L215;
        String r121 = (String) CollectionsKt.firstOrNull(r120);
        if (r121 == null) goto L215;
        this.n.setVisibility(0);
        this.n.setAutoPlayAnimation(true);
        if (r2.getEC_LIVE_INTRO_CARD_FIX_IMAGE() == false) goto L214;
        if (r52 == null) goto L206;
        String r53 = r52.getPath();
    L207:
        Uri r54 = this.s;
        if (r54 == null) goto L210;
        String r55 = r54.getPath();
    L212:
        if ((!Intrinsics.areEqual(r53, r55)) == false) goto L216;
        h0.e(this.n, r121, this.p, null, null, 120);
    L216:
        this.s = r45;
        String r56 = r3.e();
        if (r56 == null) goto L219;
        this.o.setVisibility(0);
        this.o.setText(r56);
    L220:
        Integer r57 = Integer.valueOf(r3.f());
        if (r57.intValue() <= 0) goto L223;
        r6 = true;
    L223:
        if (r6 == true) goto L226;
        r57 = null;
    L226:
        if (r57 == null) goto L228;
        r23 = r57.intValue();
    L228:
        this.o.setTextSize(1, r23);
        s1 r58 = r3.g();
        if (r58 == null) goto L241;
        String r59 = r58.c();
        if (r59 == null) goto L241;
        e r60 = getArgument();
        if (r60 == null) goto L241;
        IntroCardEventCenter r61 = r60.a;
        if (r61 == null) goto L241;
        String r62 = "livesdk_" + r59 + "_show";
        s1 r63 = r3.g();
        if (r63 == null) goto L239;
        Map<String, String> r64 = r63.d();
    L240:
        r61.a(r62, r64, null);
        goto L241
    L239:
        r64 = null;
    L241:
        String r65 = r3.b();
        if (r65 == null) goto L244;
        this.l.setOnClickListener(new com.bytedance.android.livesdk.livecommerce.intro.card.widget.a(r65, r3, this));
        return;
    L244:
        this.l.setOnClickListener(null);
        Unit r66 = Unit.INSTANCE;
        return;
    L219:
        this.o.setVisibility(8);
        Unit r67 = Unit.INSTANCE;
        goto L220
    L210:
        r55 = null;
        goto L212
    L206:
        r53 = null;
        goto L207
    L214:
        h0.e(this.n, r121, this.p, null, null, 120);
    L215:
        this.n.setVisibility(8);
        Unit r68 = Unit.INSTANCE;
    L195:
        r52 = null;
        goto L196
    L182:
        r118 = null;
        goto L184
    L178:
        r48 = null;
        goto L179
    L186:
        h0.e(this.m, r116, this.p, null, null, 120);
    L187:
        this.m.setVisibility(8);
        Unit r69 = Unit.INSTANCE;
    L167:
        r45 = null;
        goto L168
    L151:
        r41 = false;
    L157:
        r40 = null;
    L159:
        this.l.setVisibility(8);
        Unit r70 = Unit.INSTANCE;
        goto L160
    L245:
        r35.m695invoke();
        Unit r71 = Unit.INSTANCE;
        return;
    L131:
        r36 = null;
        goto L132
    L127:
        this.k.setVisibility(8);
        Unit r72 = Unit.INSTANCE;
        goto L128
    L123:
        this.i.setVisibility(8);
        Unit r73 = Unit.INSTANCE;
        goto L124
    L110:
        this.j.setVisibility(8);
        Unit r74 = Unit.INSTANCE;
        goto L111
    L106:
        T5(r29, 0);
        goto L107
    L100:
        if (r30.isEmpty() == true) goto L103;
        r31 = false;
    L96:
        r27 = new ECLiveSkinTextElement(12, CollectionsKt.listOf("#FFFFFF"), MonitorLevel.FATAL);
        goto L97
    L79:
        if (r20.intValue() < 0) goto L81;
        boolean r75 = true;
    L82:
        if (r75 == true) goto L85;
        r20 = null;
    L85:
        if (r20 == null) goto L87;
        r21 = r20.intValue();
        goto L88
    L81:
        r75 = false;
        goto L82
    L67:
        if (r18.intValue() < 0) goto L69;
        boolean r76 = true;
    L70:
        if (r76 == true) goto L73;
        r18 = null;
    L73:
        if (r18 == null) goto L75;
        r19 = r18.intValue();
        goto L76
    L69:
        r76 = false;
        goto L70
    L55:
        if (r16.intValue() < 0) goto L57;
        boolean r77 = true;
    L58:
        if (r77 == true) goto L61;
        r16 = null;
    L61:
        if (r16 == null) goto L63;
        r17 = r16.intValue();
        goto L64
    L57:
        r77 = false;
        goto L58
    L43:
        if (r14.intValue() < 0) goto L45;
        boolean r78 = true;
    L46:
        if (r78 == true) goto L49;
        r14 = null;
    L49:
        if (r14 == null) goto L51;
        r15 = r14.intValue();
        goto L52
    L45:
        r78 = false;
        goto L46
    L29:
        if (r12.intValue() <= 0) goto L31;
        boolean r122 = true;
    L32:
        if (r122 == true) goto L35;
        r12 = null;
    L35:
        if (r12 == null) goto L37;
        r9 = r12.intValue();
        goto L37
    L31:
        r122 = false;
        goto L32
    L14:
        if (r8.intValue() <= 0) goto L16;
        boolean r123 = true;
    L17:
        if (r123 == true) goto L20;
        r8 = null;
    L20:
        if (r8 == null) goto L22;
        r10 = r8.intValue();
        goto L23
    L16:
        r123 = false;
    L89:
        r7 = null;
        goto L90
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardImageComponent$showIcon$1] */
    public final void T5(List<t> r8, int r9) {
        int r0 = k.a;
        StringBuilder r1 = new StringBuilder("showIcon index = ");
        r1.append(r9);
        r1.append(", duration = ");
        t r2 = (t) CollectionsKt.getOrNull(r8, r9);
        if (r2 == null) goto L5;
        Long r3 = r2.a();
    L6:
        r1.append(r3);
        k.a(r1.toString());
        ?? r4 = new IntroCardImageComponent$showIcon$1(this);
        t r5 = (t) CollectionsKt.getOrNull(r8, r9);
        if (r5 == null) goto L34;
        Long r6 = r5.a();
        if (r6 == null) goto L11;
        long r7 = r6.longValue();
    L13:
        if (r7 <= 0) goto L26;
        r4.invoke(r5);
        S5();
        Integer r10 = r5.d();
        if (r10 != null) goto L18;
    L20:
        LinearLayout r11 = this.g;
    L21:
        c r12 = new c(r11, this, r8, r9);
        this.q = r12;
        Lazy r13 = UIUtils.a;
        UIUtils.c().postDelayed(r12, r7);
        e r14 = getArgument();
        if (r14 == null) goto L35;
        IntroCardEventCenter r15 = r14.a;
        if (r15 == null) goto L36;
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.c(r15));
        return;
    L36:
        return;
    L35:
        return;
    L18:
        if (r10.intValue() != 2) goto L20;
        r11 = this.h;
        goto L21
    L26:
        r4.invoke(r5);
        if (r5.e() == null) goto L38;
        e r16 = getArgument();
        if (r16 == null) goto L39;
        IntroCardEventCenter r17 = r16.a;
        if (r17 == null) goto L40;
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.c(r17));
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L11:
        r7 = 0;
        goto L13
    L34:
        return;
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroCardImageComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.p = new r("ec_live", "ec_live_intro_card_image");
        th.a.c(r2, 2131560753, this, true);
        setLayoutParams(new ViewGroup.LayoutParams(UtilityKotlinExtentionsKt.d(100), UtilityKotlinExtentionsKt.d(100)));
        setOutlineProvider(new a());
        setClipToOutline(true);
        this.e = (TextView) findViewById(2131390775);
        this.f = findViewById(2131376655);
        this.g = (LinearLayout) findViewById(2131378919);
        this.h = (ECCustomizedElementView) findViewById(2131371512);
        this.i = findViewById(2131376390);
        this.j = findViewById(2131376049);
        TextView r5 = (TextView) findViewById(2131391507);
        c0.b(r5, MonitorLevel.FATAL);
        Unit r6 = Unit.INSTANCE;
        this.k = r5;
        this.l = findViewById(2131376223);
        this.m = findViewById(2131376224);
        this.n = findViewById(2131376225);
        this.o = (TextView) findViewById(2131390591);
    }

    public /* synthetic */ IntroCardImageComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
