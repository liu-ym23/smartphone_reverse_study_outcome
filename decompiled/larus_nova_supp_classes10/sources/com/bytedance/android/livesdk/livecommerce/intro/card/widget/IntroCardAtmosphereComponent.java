package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.widget.ECHotAtmosphereView;
import com.bytedance.android.ec.core.widget.h;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.event.f;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroNumAtmosphere;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroAuctionAtmosphereHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0004B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"R$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardAtmosphereComponent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Loh2/e;", "a", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/b;", "c", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/b;", "getPresenter", "()Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/b;", "setPresenter", "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/b;)V", "presenter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardAtmosphereComponent extends ConstraintLayout {
    public e a;
    public oh2.c b;
    public com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b c;
    public final ECDraweeView d;
    public final ECHotAtmosphereView e;
    public final ViewStub f;
    public IntroAuctionHotAtmosphereView g;
    public IntroAuctionAtmosphereHelper h;
    public boolean i;
    public boolean j;
    public ECUrlModel k;
    public String l;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ IntroCardAtmosphereComponent a;
        public final /* synthetic */ ECHotAtmosphere b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r4) {
            Intrinsics.checkNotNullParameter(r4, "animation");
            IntroAuctionHotAtmosphereView r5 = this.a.g;
            if (r5 != null) goto L5;
            return;
        L5:
            if (ViewCompat.isAttachedToWindow(r5) == true) goto L8;
            r5 = null;
        L8:
            if (r5 == null) goto L17;
            e r0 = this.a.getArgument();
            if (r0 == null) goto L14;
            IntroCardEventCenter r1 = r0.a;
            if (r1 == null) goto L14;
            ECHotAtmosphere r2 = this.b;
            Intrinsics.checkNotNullParameter(r2, "atmosphere");
            IntroCardEventCenter.b(new f(r1, r2));
        L14:
            r5.i = true;
            r5.g(false);
            return;
        }

        public b(IntroCardAtmosphereComponent r1, ECHotAtmosphere r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements h {
        public final /* synthetic */ IntroCardAtmosphereComponent a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e b;
        public final /* synthetic */ ECHotAtmosphere c;
        public final /* synthetic */ int d;

        public final void a(ECHotAtmosphere r1) {
        }

        public final void c(ECHotAtmosphere r1) {
        }

        public final void b() {
            com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b r0 = this.a.getPresenter();
            if (r0 == null) goto L6;
            r0.q(true);
            return;
        }

        public final void onAttachedToWindow() {
            IntroAuctionHotAtmosphereView r0 = this.a.g;
            if (r0 == null) goto L5;
            Object r1 = r0.getTag();
        L6:
            if (r1 != null) goto L9;
            this.a.S5(this.b, this.c, this.d);
            return;
        L9:
            return;
        L5:
            r1 = null;
            goto L6
        }

        public final void onDetachedFromWindow() {
            IntroAuctionHotAtmosphereView r0 = this.a.g;
            if (r0 == null) goto L5;
            r0.setTag(null);
        L5:
            IntroAuctionHotAtmosphereView r1 = this.a.g;
            if (r1 == null) goto L9;
            r1.a();
            return;
        }

        public c(IntroCardAtmosphereComponent r1, com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r2, ECHotAtmosphere r3, int r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public IntroCardAtmosphereComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardAtmosphereComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        ViewStub r0 = this.f;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.inflate();
    L7:
        if ((r2 instanceof IntroAuctionHotAtmosphereView) == false) goto L10;
        r1 = r2;
    L10:
        IntroAuctionHotAtmosphereView r4 = (IntroAuctionHotAtmosphereView) r1;
        if (r4 == null) goto L14;
        this.g = r4;
        this.h = new IntroAuctionAtmosphereHelper(this, r4, this.d, new IntroCardAtmosphereComponent$inflateAuctionAtmosphereView$$inlined$also$lambda$1(this), new IntroCardAtmosphereComponent$inflateAuctionAtmosphereView$$inlined$also$lambda$2(this));
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public e getArgument() {
        return this.a;
    }

    public oh2.c getContainerAbility() {
        return this.b;
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b getPresenter() {
        return this.c;
    }

    public void setArgument(e r1) {
        this.a = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.b = r1;
    }

    public final void setPresenter(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b r1) {
        this.c = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroCardAtmosphereComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = !ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM_OPT().b();
        th.a.c(r2, 2131560747, this, true);
        this.e = findViewById(2131374531);
        this.d = findViewById(2131376035);
        this.f = (ViewStub) findViewById(2131363360);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r13, ECHotAtmosphere r14, int r15) {
        setVisibility(0);
        IntroProduct r1 = r13.e;
        Integer r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.i();
    L6:
        IntroAuctionHotAtmosphereView r4 = this.g;
        if (r4 == null) goto L9;
        Object r5 = r4.getTag();
    L11:
        if ((r5 instanceof com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) == true) goto L13;
        r5 = null;
    L13:
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e r6 = (com.bytedance.android.livesdk.livecommerce.intro.card.presenter.e) r5;
        if (r6 == null) goto L18;
        IntroProduct r7 = r6.e;
        if (r7 == null) goto L18;
        String r8 = r7.i();
    L19:
        boolean r9 = Intrinsics.areEqual(r3, r8);
        boolean r10 = true;
        if ((!r9) == false) goto L24;
        IntroAuctionHotAtmosphereView r11 = this.g;
        if (r11 == null) goto L24;
        r11.h();
    L24:
        int r12 = r14.type;
        if (r12 == 10001) goto L36;
        if (r12 != 10002) goto L44;
        this.d.setVisibility(0);
        th2.b r16 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r16 == null) goto L34;
        ECUrlModel r17 = r16.c();
        if (r17 == null) goto L34;
        String r18 = r17.getFirstUrl();
        if (r18 == null) goto L34;
    L35:
        h0.e(this.d, r18, null, null, null, 120);
    L34:
        r18 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_deal_bg_v2.webp";
    L44:
        IntroAuctionHotAtmosphereView r19 = this.g;
        if (r19 == null) goto L47;
        r19.setVisibility(0);
    L47:
        IntroAuctionHotAtmosphereView r20 = this.g;
        if (r20 == null) goto L50;
        r20.setMaxWidth(UtilityKotlinExtentionsKt.d(Float.valueOf(119.0f)));
    L50:
        int r21 = r14.type;
        if (r21 == 10001) goto L59;
        if (r21 != 10002) goto L64;
        th2.b r22 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r22 == null) goto L64;
        ECUrlModel r23 = r22.c();
        if (r23 == null) goto L64;
        r2 = Integer.valueOf(r23.getHeight());
    L64:
        if (r2 == null) goto L66;
        float r24 = r2.intValue();
    L67:
        IntroAuctionHotAtmosphereView r25 = this.g;
        if (r25 == null) goto L74;
        ViewGroup.LayoutParams r26 = r25.getLayoutParams();
        if (r26 == null) goto L74;
        if (r26.height == UtilityKotlinExtentionsKt.d(Float.valueOf(r24))) goto L74;
        r26.height = UtilityKotlinExtentionsKt.d(Float.valueOf(r24));
    L74:
        IntroAuctionHotAtmosphereView r27 = this.g;
        if (r27 == null) goto L85;
        IntroProduct r28 = r13.e;
        if (r28 == null) goto L79;
        int r29 = r28.e();
    L80:
        th2.b r30 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r30 == null) goto L83;
        int r31 = r30.n();
    L84:
        r27.f(r29, r24, r31);
        goto L85
    L83:
        r31 = 18;
        goto L84
    L79:
        r29 = 2;
    L85:
        IntroAuctionHotAtmosphereView r32 = this.g;
        if (r32 == null) goto L88;
        r32.setTag(r13);
    L88:
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b r33 = this.c;
        if (r33 == null) goto L92;
        r33.q(false);
    L92:
        if (this.j == true) goto L94;
        IntroAuctionHotAtmosphereView r34 = this.g;
        if (r34 == null) goto L100;
        r34.i = true;
    L100:
        if (r34 == null) goto L102;
        r34.setAlpha(1.0f);
    L102:
        r13.a.setHasShown(true);
        int r35 = r14.getNumInt();
        int r36 = r14.type;
        if (r13.a.getLastNum() > 0) goto L105;
    L113:
        r13.a.setLastNum(r35);
        r13.a.setLastType(r36);
        if (r10 == false) goto L116;
        r13.a.setFold(false);
    L116:
        IntroAuctionHotAtmosphereView r0 = this.g;
        if (r0 == null) goto L119;
        r0.i(r14, r10, r13.a.isFold());
    L119:
        IntroAuctionHotAtmosphereView r37 = this.g;
        if (r37 == null) goto L123;
        r37.setCallback(new c(this, r13, r14, r15));
        return;
    L123:
        return;
    L105:
        if (r13.a.getLastType() <= 0) goto L113;
        if (r13.a.getHasShown() == false) goto L113;
        if (r13.a.getLastNum() != r35) goto L113;
        if (r13.a.getLastType() != r36) goto L113;
        r10 = false;
        goto L113
    L94:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM() == false) goto L96;
        setTranslationX(UtilityKotlinExtentionsKt.c(100));
        setAlpha(0.0f);
        animate().translationX(0.0f).alpha(1.0f).setDuration(500).setInterpolator(new DecelerateInterpolator()).setListener(new b(this, r14)).start();
    L96:
        this.j = false;
        goto L102
    L66:
        r24 = 24.0f;
        goto L67
    L59:
        th2.b r38 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r38 == null) goto L64;
        ECUrlModel r39 = r38.a();
        if (r39 == null) goto L64;
        r2 = Integer.valueOf(r39.getHeight());
        goto L64
    L36:
        this.d.setVisibility(0);
        th2.b r40 = ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r40 == null) goto L42;
        ECUrlModel r41 = r40.a();
        if (r41 == null) goto L42;
        String r42 = r41.getFirstUrl();
        if (r42 == null) goto L42;
    L43:
        h0.e(this.d, r42, null, null, null, 120);
    L42:
        r42 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/lcps_tvjl/ljhwZthlaukjlkulzlp/live_intro/auction/auction_price_bg.webp";
    L18:
        r8 = null;
        goto L19
    L9:
        r5 = null;
        goto L11
    L5:
        r3 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T5(final IntroAtmosphere r17, final int r18, final boolean r19) {
        IntroNumAtmosphere r2 = r17.d();
        if (r2 == null) goto L52;
        int r5 = IntroNumAtmosphere.a;
        Intrinsics.checkNotNullParameter(r2, "$this$toECHotAtmosphereCompat");
        ECHotAtmosphere r6 = new ECHotAtmosphere();
        ECUrlModel r7 = r2.b();
        Integer r8 = null;
        if (r7 == null) goto L7;
        String r9 = r7.getFirstUrl();
    L8:
        r6.img = r9;
        r6.type = r2.getType();
        r6.num = r2.c();
        r6.uiType = 5000;
        r6.bgColor = "#00000000";
        r6.borderColor = "#00000000";
        r6.bgColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        r6.borderColors = CollectionsKt.listOf(new String[]{"#00000000", "#00000000", "#00000000"});
        setVisibility(0);
        if (this.j == true) goto L11;
    L14:
        IntroNumAtmosphere r10 = r17.d();
        if (r10 == null) goto L23;
        ECUrlModel r11 = r10.a();
        if (r11 == null) goto L23;
        this.d.setVisibility(0);
        if ((!Intrinsics.areEqual(this.k, r11)) == false) goto L22;
        h0.d(this.d, r11, null, null, null, null, null, 120);
        UtilityKotlinExtentionsKt.f(Integer.valueOf(r11.getWidth()), Integer.valueOf(r11.getHeight()), new IntroCardAtmosphereComponent$showTypeNumIntroAtmosphere$$inlined$also$lambda$1(this, r17, r19, r18));
    L22:
        this.k = r11;
    L24:
        this.e.setVisibility(0);
        ECHotAtmosphereView r3 = this.e;
        ECLiveABUtils r12 = ECLiveABUtils.INSTANCE;
        th2.b r13 = r12.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r18));
        if (r13 == null) goto L27;
        int r14 = r13.n();
    L28:
        boolean r15 = r12.getEC_LIVE_INTRO_CARD_STYLE_FIX();
        r3.a = true;
        r3.A = true;
        r3.C = r14;
        r3.B = r15;
        ECHotAtmosphereView r4 = this.e;
        IntroNumAtmosphere r16 = r17.d();
        if (r16 == null) goto L40;
        ECUrlModel r20 = r16.a();
        if (r20 == null) goto L40;
        Integer r21 = Integer.valueOf(r20.getHeight());
        if (r21.intValue() <= 0) goto L35;
        boolean r22 = true;
    L36:
        if (r22 == false) goto L38;
        r8 = r21;
    L38:
        if (r8 == null) goto L40;
        float r23 = r8.intValue();
    L41:
        ECHotAtmosphereView.g(r4, true, false, new com.bytedance.android.ec.core.widget.b(r23, 12, 20, null, 0.0f, null, false, false), 2);
        this.e.l(false);
        ECHotAtmosphereView.k(this.e, r6, false, 6);
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b r24 = this.c;
        if (r24 == null) goto L45;
        r24.q(false);
    L45:
        if (this.i == true) goto L56;
        e r25 = getArgument();
        if (r25 == null) goto L51;
        IntroCardEventCenter r26 = r25.a;
        if (r26 == null) goto L51;
        Intrinsics.checkNotNullParameter(r17, "atmosphere");
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.e(r26));
    L51:
        this.i = true;
        return;
    L56:
        return;
    L35:
        r22 = false;
    L40:
        r23 = 24.0f;
        goto L41
    L27:
        r14 = 18;
    L23:
        this.d.setVisibility(8);
        Unit r27 = Unit.INSTANCE;
        goto L24
    L11:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_ANIM() == false) goto L13;
        setTranslationX(UtilityKotlinExtentionsKt.c(100));
        setAlpha(0.0f);
        animate().translationX(0.0f).alpha(1.0f).setDuration(500).setInterpolator(new DecelerateInterpolator()).start();
    L13:
        this.j = false;
        goto L14
    L7:
        r9 = null;
        goto L8
    L52:
        setVisibility(8);
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.b r1 = this.c;
        if (r1 == null) goto L58;
        r1.q(true);
        Unit r28 = Unit.INSTANCE;
        return;
    }

    public /* synthetic */ IntroCardAtmosphereComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
