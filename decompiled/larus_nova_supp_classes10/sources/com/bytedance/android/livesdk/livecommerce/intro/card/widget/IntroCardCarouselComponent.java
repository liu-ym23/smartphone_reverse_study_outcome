package com.bytedance.android.livesdk.livecommerce.intro.card.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.IntroCardSecondFrameComponent;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.g0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.l;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.setting.ECLiveSkinViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oh2.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0006B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/IntroCardCarouselComponent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "", "getComponentContentDescription", "Loh2/e;", "a", "Loh2/e;", "getArgument", "()Loh2/e;", "setArgument", "(Loh2/e;)V", "argument", "Loh2/c;", "b", "Loh2/c;", "getContainerAbility", "()Loh2/c;", "setContainerAbility", "(Loh2/c;)V", "containerAbility", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/c;", "e", "Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/c;", "getPresenter", "()Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/c;", "setPresenter", "(Lcom/bytedance/android/livesdk/livecommerce/intro/card/presenter/c;)V", "presenter", "Ljava/lang/Runnable;", "value", "f", "Ljava/lang/Runnable;", "setSecondFrameRunnable", "(Ljava/lang/Runnable;)V", "secondFrameRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCardCarouselComponent extends ConstraintLayout {
    public static final /* synthetic */ int i = 0;
    public e a;
    public oh2.c b;
    public final IntroCardInfoComponent c;
    public IntroCardSecondFrameComponent d;
    public com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c e;
    public Runnable f;
    public boolean g;
    public String h;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ g0 a;
        public final /* synthetic */ IntroCardCarouselComponent b;
        public final /* synthetic */ IntroPromotionVO c;

        public b(g0 r1, IntroCardCarouselComponent r2, IntroPromotionVO r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.IntroCardCarouselComponent, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r4v4, types: [android.view.ViewGroup, com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe.IntroCardSecondFrameComponent] */
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
        public final void a() {
            final ?? r0 = this.b;
            final g0 r1 = this.a;
            s0 r2 = this.c.getControl();
            if (r2 == null) goto L5;
            int r3 = r2.d();
        L6:
            int r4 = IntroCardCarouselComponent.i;
            r0.getClass();
            if (r1.c() == 2) goto L11;
            com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c r5 = r0.e;
            if (r5 == null) goto L15;
            r5.t(false);
        L15:
            if (r0.d != null) goto L30;
            ViewStub r6 = (ViewStub) r0.findViewById(2131387493);
            if (r6 == null) goto L30;
            Object r7 = r6.inflate();
            if (r7 == null) goto L30;
            if ((r7 instanceof IntroCardSecondFrameComponent) == true) goto L24;
            r7 = null;
        L24:
            IntroCardSecondFrameComponent r8 = (IntroCardSecondFrameComponent) r7;
            r0.d = r8;
            if (r8 == null) goto L27;
            r8.setArgument(r0.getArgument());
        L27:
            IntroCardSecondFrameComponent r9 = r0.d;
            if (r9 == null) goto L30;
            r9.setContainerAbility(r0.getContainerAbility());
        L30:
            ?? r10 = r0.d;
            if (r10 == 0) goto L34;
            r0.g = true;
            r10.setVisibility(0);
            r10.setAlpha(0.0f);
            r10.R5(r1, r3);
            r10.post(new IntroCardCarouselComponent$hideInfoComponent$$inlined$also$lambda$1(r0, r1));
            return;
        L34:
            return;
        L11:
            com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c r11 = r0.e;
            if (r11 == null) goto L15;
            r11.t(true);
            goto L15
        L5:
            r3 = 0;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
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

    public IntroCardCarouselComponent(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public IntroCardCarouselComponent(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final String getComponentContentDescription() {
        return this.c.getComponentContentDescription();
    }

    public final void release() {
        Runnable r0 = this.f;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
    L5:
        setSecondFrameRunnable(null);
        this.c.f();
        this.g = false;
        IntroCardSecondFrameComponent r2 = this.d;
        if (r2 == null) goto L8;
        r2.e = false;
        r2.f = false;
    L8:
        this.h = null;
    }

    public e getArgument() {
        return this.a;
    }

    public oh2.c getContainerAbility() {
        return this.b;
    }

    public final com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c getPresenter() {
        return this.e;
    }

    private final void setSecondFrameRunnable(Runnable r3) {
        Runnable r0 = this.f;
        if (r0 == null) goto L5;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r0);
    L5:
        this.f = r3;
    }

    public final void R5(IntroPromotionVO r13) {
        Intrinsics.checkNotNullParameter(r13, "introPromotionVO");
        ECLiveABUtils r0 = ECLiveABUtils.INSTANCE;
        boolean r2 = true;
        if (r0.getEC_LIVE_INTRO_CARD_CHANGE_CARD_FIX() == true) goto L5;
    L7:
        ECLiveLayoutConfig r4 = null;
        Integer r5 = null;
        r4 = null;
        r4 = null;
        int r6 = 8;
        if (this.g == false) goto L18;
        g0 r1 = r13.getSecondFrame();
        if (r1 == null) goto L72;
        IntroCardSecondFrameComponent r7 = this.d;
        if (r7 == null) goto L72;
        s0 r8 = r13.getControl();
        if (r8 == null) goto L16;
        int r9 = r8.d();
    L17:
        r7.R5(r1, r9);
        goto L72
    L16:
        r9 = 0;
    L72:
        s0 r14 = r13.getControl();
        if (r14 == null) goto L75;
        int r15 = r14.d();
    L76:
        th2.b r16 = r0.getEC_LIVE_INTRO_CARD_STYLE_CONFIG().get(Integer.valueOf(r15));
        if (r16 == null) goto L129;
        ECLiveSkinViewUIConfig r17 = r16.e();
        if (r17 == null) goto L129;
        ECLiveLayoutConfig r18 = r17.getLayout();
        if (r18 == null) goto L129;
        Integer r3 = r18.getLeftMargin();
        if (r3 != null) goto L85;
    L93:
        int r10 = 0;
    L94:
        d2.c(this.c, UtilityKotlinExtentionsKt.d(Integer.valueOf(r10)));
        Integer r11 = r18.getTopMargin();
        if (r11 != null) goto L97;
    L105:
        int r12 = 2;
    L106:
        d2.f(this.c, UtilityKotlinExtentionsKt.d(Integer.valueOf(r12)));
        Integer r19 = r18.getBottomMargin();
        if (r19 != null) goto L109;
    L117:
        int r20 = 0;
    L118:
        d2.a(this.c, UtilityKotlinExtentionsKt.d(Integer.valueOf(r20)));
        Integer r21 = r18.getRightMargin();
        if (r21 != null) goto L121;
    L128:
        d2.e(this.c, UtilityKotlinExtentionsKt.d(Integer.valueOf(r6)));
        r4 = r18;
        goto L129
    L121:
        if (r21.intValue() >= 0) goto L124;
        r2 = false;
    L124:
        if (r2 == false) goto L126;
        r5 = r21;
    L126:
        if (r5 == null) goto L128;
        r6 = r5.intValue();
        goto L128
    L109:
        if (r19.intValue() < 0) goto L111;
        boolean r22 = true;
    L112:
        if (r22 == true) goto L115;
        r19 = null;
    L115:
        if (r19 == null) goto L117;
        r20 = r19.intValue();
        goto L118
    L111:
        r22 = false;
        goto L112
    L97:
        if (r11.intValue() < 0) goto L99;
        boolean r23 = true;
    L100:
        if (r23 == true) goto L103;
        r11 = null;
    L103:
        if (r11 == null) goto L105;
        r12 = r11.intValue();
        goto L106
    L99:
        r23 = false;
        goto L100
    L85:
        if (r3.intValue() < 0) goto L87;
        boolean r24 = true;
    L88:
        if (r24 == true) goto L91;
        r3 = null;
    L91:
        if (r3 == null) goto L93;
        r10 = r3.intValue();
        goto L94
    L87:
        r24 = false;
    L129:
        UtilityKotlinExtentionsKt.h(r4, new IntroCardCarouselComponent$updateShowStyle$2(this));
        return;
    L75:
        r15 = 0;
        goto L76
    L18:
        ConstraintLayout r25 = this.d;
        if (r25 == null) goto L21;
        r25.setVisibility(8);
    L21:
        Runnable r26 = this.f;
        if (r26 == null) goto L24;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r26);
    L24:
        g0 r27 = r13.getSecondFrame();
        if (r27 == null) goto L56;
        List<Long> r28 = r13.getDurations();
        if (r28 == null) goto L40;
        Long r29 = (Long) CollectionsKt.firstOrNull(r28);
        if (r29 == null) goto L40;
        if (r29.longValue() <= 0) goto L33;
        boolean r30 = true;
    L34:
        if (r30 == true) goto L37;
        r29 = null;
    L37:
        if (r29 == null) goto L40;
        long r31 = r29.longValue();
        b r32 = new b(r27, this, r13);
        UtilityKotlinExtentionsKt.b.postDelayed(r32, r31);
        Unit r33 = Unit.INSTANCE;
        setSecondFrameRunnable(r32);
        goto L40
    L33:
        r30 = false;
    L40:
        if (r0.getEC_LIVE_INTRO_CARD_CHANGE_CARD_FIX() == false) goto L47;
        g r34 = r13.getBenefits();
        l r35 = r13.getCarouselBenefits();
        s0 r36 = r13.getControl();
        if (r36 == null) goto L44;
        int r37 = r36.d();
    L45:
        S5(r34, r35, r37);
        goto L72
    L44:
        r37 = 0;
        goto L45
    L47:
        if (r13.getBenefits() == null) goto L49;
    L50:
        g r38 = r13.getBenefits();
        l r39 = r13.getCarouselBenefits();
        s0 r40 = r13.getControl();
        if (r40 == null) goto L53;
        int r41 = r40.d();
    L54:
        S5(r38, r39, r41);
        goto L72
    L53:
        r41 = 0;
        goto L54
    L49:
        if (r13.getCarouselBenefits() == null) goto L72;
    L56:
        if (r0.getEC_LIVE_INTRO_CARD_CHANGE_CARD_FIX() == false) goto L63;
        g r42 = r13.getBenefits();
        l r43 = r13.getCarouselBenefits();
        s0 r44 = r13.getControl();
        if (r44 == null) goto L60;
        int r45 = r44.d();
    L61:
        S5(r42, r43, r45);
    L71:
        Unit r46 = Unit.INSTANCE;
        goto L72
    L60:
        r45 = 0;
        goto L61
    L63:
        if (r13.getBenefits() == null) goto L65;
    L66:
        g r47 = r13.getBenefits();
        l r48 = r13.getCarouselBenefits();
        s0 r49 = r13.getControl();
        if (r49 == null) goto L69;
        int r50 = r49.d();
    L70:
        S5(r47, r48, r50);
        goto L71
    L69:
        r50 = 0;
        goto L70
    L65:
        if (r13.getCarouselBenefits() == null) goto L71;
    L5:
        if ((!Intrinsics.areEqual(r13.getPromotionId(), this.h)) == false) goto L7;
        release();
        this.h = r13.getPromotionId();
        goto L7
    }

    public void setArgument(e r1) {
        this.a = r1;
    }

    public void setContainerAbility(oh2.c r1) {
        this.b = r1;
    }

    public final void setPresenter(com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c r1) {
        this.e = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IntroCardCarouselComponent(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        th.a.c(r2, 2131560752, this, true);
        this.c = (IntroCardInfoComponent) findViewById(2131393195);
    }

    public final void S5(g r6, l r7, int r8) {
        this.c.setVisibility(0);
        this.c.setTranslationY(0.0f);
        this.c.setAlpha(1.0f);
        if (r7 != null) goto L5;
    L7:
        if (r6 == null) goto L9;
        this.c.a(r6, r8);
    L12:
        com.bytedance.android.livesdk.livecommerce.intro.card.presenter.c r9 = this.e;
        if (r9 == null) goto L16;
        r9.i();
        return;
    L16:
        return;
    L9:
        IntroCardInfoComponent r10 = this.c;
        r10.getClass();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_CHANGE_CARD_FIX() == false) goto L12;
        r10.removeAllViews();
        r10.f();
        goto L12
    L5:
        if (r7.a() <= 0) goto L7;
        this.c.b(r7, r8);
        goto L12
    }

    public /* synthetic */ IntroCardCarouselComponent(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
