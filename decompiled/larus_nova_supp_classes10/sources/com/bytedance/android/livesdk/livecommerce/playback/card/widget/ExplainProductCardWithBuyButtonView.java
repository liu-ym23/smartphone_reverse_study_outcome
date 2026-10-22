package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cf.h;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.widget.price.PriceView;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.ui.base.widget.round.BackgroundDrawable;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fB'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/playback/card/widget/ExplainProductCardWithBuyButtonView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/android/livesdk/livecommerce/playback/card/widget/f;", "Lcf/h;", "listener", "", "setFinishPlaybackPageListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainProductCardWithBuyButtonView extends RelativeLayout implements com.bytedance.android.livesdk.livecommerce.playback.card.widget.f {
    public final SimpleDraweeView a;
    public final PriceView b;
    public final ImageView c;
    public final TextView d;
    public final ImageView e;
    public final View f;
    public final View g;
    public final View h;
    public final TextView i;
    public final com.bytedance.android.livesdk.livecommerce.playback.card.widget.e j;
    public ObjectAnimator k;
    public ObjectAnimator l;
    public ObjectAnimator m;
    public ObjectAnimator n;
    public ObjectAnimator o;
    public ObjectAnimator p;
    public int q;
    public int r;

    public static final class a extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ ExplainProductCardWithBuyButtonView g;

        public a(ExplainProductCardWithBuyButtonView r2) {
            this.g = r2;
            super(null, null, 3);
        }

        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            this.g.g.setVisibility(8);
            cj2.c r4 = cj2.a.a;
            HashMap r5 = new HashMap();
            r5.put("ecom_entrance_form", "replay_popup_card");
            r5.put("card_status", PromotionCategory.CATEGORY_TYPE_SECOND);
            cj2.a.a("livesdk_replay_popup_card_close", r5, null, null);
        }
    }

    public static final class b {
    }

    public static final class c extends com.bytedance.android.ec.core.widget.d {
        public final /* synthetic */ boolean g;
        public final /* synthetic */ jf.d h;
        public final /* synthetic */ g i;
        public final /* synthetic */ Context j;

        public final void a(View r12) {
            Intrinsics.checkNotNullParameter(r12, "v");
            if (this.g == true) goto L9;
            jf.d r1 = this.h;
            if (r1 == null) goto L9;
            g r3 = this.i;
            if (r3 == null) goto L9;
            jf.d.b.c(r1, this.j, r3, "card", false, BtmUtilsKt.e("a1.b3390.c11834.d45925", PageFinder.via(r12)), null);
        L9:
            cj2.a.c("click_blank", PromotionCategory.CATEGORY_TYPE_SECOND);
            jf.d r2 = this.h;
            if (r2 == null) goto L15;
            g r4 = this.i;
            if (r4 == null) goto L16;
            jf.d.b.f(r2, r4, "card", false, "a1.b3390.c11834.d45925", null, r12, false, 84);
            return;
        L16:
            return;
        }

        public c(boolean r1, jf.d r2, g r3, Context r4) {
            this.g = r1;
            this.h = r2;
            this.i = r3;
            this.j = r4;
            super(null, null, 3);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ ExplainProductCardWithBuyButtonView a;
        public final /* synthetic */ jf.d b;

        public d(ExplainProductCardWithBuyButtonView r1, jf.d r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ExplainProductCardWithBuyButtonView r0 = this.a;     // Catch: Throwable -> L4
            r0.r = r0.g.getWidth();     // Catch: Throwable -> L4
            ExplainProductCardWithBuyButtonView r1 = this.a;     // Catch: Throwable -> L4
            r1.q = r1.g.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ dj2.d a;
        public final /* synthetic */ ExplainProductCardWithBuyButtonView b;
        public final /* synthetic */ Function0 c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r11) {
            Intrinsics.checkNotNullParameter(r11, "animation");
            ExplainProductCardWithBuyButtonView r12 = this.b;
            dj2.d r0 = this.a;
            int r1 = r0.a;
            int r2 = r0.b;
            int r3 = r0.c;
            Function0 r4 = this.c;
            r12.getClass();
            AnimatorSet r5 = new AnimatorSet();
            ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r12.getContext().getResources().getDimensionPixelOffset(2131166400), r3});
            r6.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.a(r12));
            r6.setTarget(r12.a);
            ValueAnimator r7 = ValueAnimator.ofInt(new int[]{r12.r, r1});
            r7.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.b(r12));
            r7.setTarget(r12.g);
            ValueAnimator r8 = ValueAnimator.ofInt(new int[]{r12.q, r2});
            r8.addUpdateListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.c(r12));
            r8.setTarget(r12.g);
            r5.playTogether(new Animator[]{r6, r7, r8});
            r5.setDuration(300);
            r5.start();
            r5.addListener(new com.bytedance.android.livesdk.livecommerce.playback.card.widget.d(r12, r4));
        }

        public e(dj2.d r1, ExplainProductCardWithBuyButtonView r2, Function0 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public f() {
        }
    }

    static {
    }

    public ExplainProductCardWithBuyButtonView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ExplainProductCardWithBuyButtonView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.card.widget.f
    public void setFinishPlaybackPageListener(h r1) {
    }

    public final void c() {
        this.d.setTextColor(th.a.a(getContext(), 2131101544));
        this.e.setImageResource(2131234513);
    }

    public ExplainProductCardWithBuyButtonView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = new com.bytedance.android.livesdk.livecommerce.playback.card.widget.e();
        LayoutInflater.from(r2).inflate(2131560697, this);
        this.a = findViewById(2131370689);
        this.b = findViewById(2131370678);
        ImageView r5 = (ImageView) findViewById(2131370656);
        this.c = r5;
        this.d = (TextView) findViewById(2131370693);
        this.e = (ImageView) findViewById(2131370657);
        this.f = findViewById(2131370677);
        View r6 = findViewById(2131367497);
        this.g = r6;
        this.h = findViewById(2131370694);
        this.i = (TextView) findViewById(2131370695);
        r5.setOnClickListener(new a(this));
        Drawable r7 = r6.getBackground();
        if ((r7 instanceof BackgroundDrawable) == true) goto L5;
        r7 = null;
    L5:
        BackgroundDrawable r8 = (BackgroundDrawable) r7;
        if (r8 == null) goto L9;
        r8.setBgColor(-1);
        r8.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(6));
        r8.invalidate();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.playback.card.widget.f
    public final void a(boolean r11, dj2.d r12, Function0<Unit> r13) {
        Intrinsics.checkNotNullParameter(r12, "cardViewState");
        AnimatorSet r0 = new AnimatorSet();
        if (r11 == false) goto L32;
        ViewGroup.LayoutParams r14 = this.g.getLayoutParams();
        boolean r15 = r14 instanceof RelativeLayout.LayoutParams;
        ViewGroup.LayoutParams r16 = null;
        if (r15 == true) goto L7;
        ViewGroup.LayoutParams r7 = null;
    L8:
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) r7;
        if (r8 == null) goto L11;
        r8.width = this.r;
    L11:
        if (r15 == true) goto L13;
        ViewGroup.LayoutParams r17 = null;
    L14:
        RelativeLayout.LayoutParams r18 = (RelativeLayout.LayoutParams) r17;
        if (r18 == null) goto L17;
        r18.height = this.q;
    L17:
        this.g.setLayoutParams(r14);
        ViewGroup.LayoutParams r19 = this.a.getLayoutParams();
        boolean r110 = r19 instanceof RelativeLayout.LayoutParams;
        if (r110 == true) goto L20;
        ViewGroup.LayoutParams r9 = null;
    L21:
        RelativeLayout.LayoutParams r10 = (RelativeLayout.LayoutParams) r9;
        if (r10 == null) goto L24;
        r10.width = getContext().getResources().getDimensionPixelSize(2131166400);
    L24:
        if (r110 == false) goto L27;
        r16 = r19;
    L27:
        RelativeLayout.LayoutParams r111 = (RelativeLayout.LayoutParams) r16;
        if (r111 == null) goto L30;
        r111.height = getContext().getResources().getDimensionPixelSize(2131166400);
    L30:
        this.a.setLayoutParams(r19);
        r0.playTogether(new Animator[]{this.n, this.o, this.p});
        r0.addListener(new f());
        r0.setDuration(200);
        r0.start();
        this.g.setVisibility(0);
        return;
    L20:
        r9 = r19;
        goto L21
    L13:
        r17 = r14;
        goto L14
    L7:
        r7 = r14;
        goto L8
    L32:
        if (r12.a > 0) goto L34;
    L38:
        r0.start();
        return;
    L34:
        if (r12.b <= 0) goto L38;
        if (r12.c <= 0) goto L38;
        r0.playTogether(new Animator[]{this.k, this.l, this.m});
        r0.addListener(new e(r12, this, r13));
        r0.setDuration(200);
        goto L38
    }

    public /* synthetic */ ExplainProductCardWithBuyButtonView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void b(final ECUIPromotion r11, boolean r12, Context r13, jf.d r14, g r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        SimpleDraweeView r1 = this.a;
        String r2 = r11.imageUrl;
        int r0 = r.h;
        h0.e(r1, r2, r.a.b("explain_playback"), null, null, 120);
        com.bytedance.android.livesdk.livecommerce.playback.card.widget.e r3 = this.j;
        final PriceView r4 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r11, "promotion");
        Intrinsics.checkNotNullParameter(r4, "productPriceView");
        long r5 = SystemClock.elapsedRealtime();
        if (TextUtils.isEmpty(r11.priceHeader) == true) goto L19;
        ECUICampaign r6 = r11.campaign;
        if (r6 != null) goto L7;
    L9:
        String r7 = r11.price;
    L10:
        if (r6 != null) goto L12;
    L14:
        String r8 = r11.maxPrice;
    L15:
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = null;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r7, r8) == false) goto L18;
        r9.element = r4.getContext().getResources().getString(2131896475);
    L18:
        r4.C(new ExplainProductSmallCardController$setPriceInfo$1(r9, r11));
    L63:
        int r16 = r11.getStatus();
        if (r16 != 4) goto L66;
    L73:
        c();
        this.d.setText(2131896453);
        this.h.setVisibility(0);
        this.i.setText(2131896469);
    L74:
        setOnClickListener(new c(r12, r14, r15, r13));
        this.k = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f, 0.0f});
        this.l = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f});
        this.m = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{1.0f, 0.0f});
        this.n = ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.0f, 1.0f});
        this.o = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f});
        this.p = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f});
        this.g.post(new d(this, r14));
        return;
    L66:
        if (r16 == 3) goto L73;
        if (r16 != 5) goto L71;
        c();
        this.d.setText(2131896478);
        this.h.setVisibility(0);
        this.i.setText(2131896474);
        goto L74
    L71:
        if (r16 != 2) goto L74;
        c();
        this.d.setText(2131896459);
        this.h.setVisibility(0);
        this.i.setText(2131896472);
        goto L74
    L12:
        if (r5 >= r6.endTime) goto L14;
        r8 = r6.maxPrice;
        goto L15
    L7:
        if (r5 >= r6.endTime) goto L9;
        r7 = r6.price;
        goto L10
    L19:
        ECUICampaign r10 = r11.campaign;
        if (r10 != null) goto L22;
    L29:
        ECUICampaign r17 = r11.campaign;
        if (r17 != null) goto L32;
    L36:
        ECUICampaign r18 = r11.campaign;
        if (r18 != null) goto L39;
    L46:
        r4.C(new ExplainProductSmallCardController$setPriceInfo$6(r11));
    L47:
        ECUICampaign r19 = r11.campaign;
        if (r19 == null) goto L58;
        if (r19.startTime > r5) goto L58;
        if (r5 > r19.endTime) goto L58;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r19.price, r19.maxPrice) == false) goto L56;
        r4.C(new ExplainProductSmallCardController$setPriceInfo$7(r4));
        goto L63
    L56:
        r4.C(ExplainProductSmallCardController$setPriceInfo$8.INSTANCE);
    L58:
        if (r11.isInsuranceProduct() == true) goto L60;
        r4.C(ExplainProductSmallCardController$setPriceInfo$10.INSTANCE);
        goto L63
    L60:
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r11.price, r11.maxPrice) == false) goto L63;
        r4.C(new ExplainProductSmallCardController$setPriceInfo$9(r4));
        goto L63
    L39:
        if (r18.startTime > r5) goto L46;
        if (r5 > r18.endTime) goto L46;
        if (r11.isSecKill().booleanValue() == false) goto L45;
        r4.C(new ExplainProductSmallCardController$setPriceInfo$4(r4));
    L45:
        r4.C(new ExplainProductSmallCardController$setPriceInfo$5(r11));
        goto L47
    L32:
        if (r17.isPreSale().booleanValue() == false) goto L36;
        if (r11.campaign.inCampaignTime() == false) goto L36;
        r4.C(new ExplainProductSmallCardController$setPriceInfo$3(r11, r4));
        goto L63
    L22:
        if (r5 > r10.endTime) goto L29;
        if (r10.isGroup().booleanValue() == false) goto L29;
        final Ref.ObjectRef r20 = new Ref.ObjectRef();
        r20.element = null;
        ECUICampaign r21 = r11.campaign;
        if (com.bytedance.android.livesdk.livecommerce.playback.card.widget.e.a(r21.price, r21.maxPrice) == false) goto L28;
        r20.element = r4.getContext().getResources().getString(2131896475);
    L28:
        r4.C(new ExplainProductSmallCardController$setPriceInfo$2(r11, r20, r4));
        goto L63
    }
}
