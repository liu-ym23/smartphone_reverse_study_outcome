package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Calendar;
import kk.d;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "Landroid/widget/RelativeLayout;", "", "getClickStorageKey", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BigCardTitleView extends RelativeLayout {
    public static final /* synthetic */ int k = 0;
    public final SimpleDraweeView a;
    public boolean b;
    public final AppCompatTextView c;
    public final SimpleDraweeView d;
    public final LottieAnimationView e;
    public ChannelVO.a f;
    public ChannelVO g;
    public com.bytedance.android.shopping.mall.homepage.card.headercard.a h;
    public com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a i;
    public e j;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ BigCardTitleView a;

        public a(BigCardTitleView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BigCardTitleView r4 = this.a;
            int r0 = BigCardTitleView.k;
            r4.b(false);
            com.bytedance.android.shopping.mall.homepage.card.headercard.a r5 = this.a.h;
            if (r5 == null) goto L9;
            ECMallFeed r6 = r5.h;
            if (r6 == null) goto L9;
            ECMallFeed.f r7 = r6.A1;
            if (r7 == null) goto L9;
            r7.Q30("channelTitleLottieHidden", null);
        L9:
            Lazy r8 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "BigCardTitleView onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            BigCardTitleView r4 = this.a;
            int r0 = BigCardTitleView.k;
            r4.b(false);
            com.bytedance.android.shopping.mall.homepage.card.headercard.a r5 = this.a.h;
            if (r5 == null) goto L9;
            ECMallFeed r6 = r5.h;
            if (r6 == null) goto L9;
            ECMallFeed.f r7 = r6.A1;
            if (r7 == null) goto L9;
            r7.Q30("channelTitleLottieHidden", null);
        L9:
            Lazy r8 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "BigCardTitleView onAnimationEnd");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Lazy r3 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "BigCardTitleView onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            Lazy r3 = ECMallLogUtil.a;
            ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.f.b, "BigCardTitleView onAnimationStart");
            BigCardTitleView r4 = this.a;
            int r0 = BigCardTitleView.k;
            r4.b(true);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ LottieAnimationView a;
        public final /* synthetic */ BigCardTitleView b;

        public b(LottieAnimationView r1, BigCardTitleView r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            Integer r0 = null;
            if (r5 != null) goto L40;
            Object r6 = null;
        L8:
            LottieComposition r1 = this.a.getComposition();     // Catch: Exception -> L5
            ChannelVO.a r2 = this.b.f;     // Catch: Exception -> L5
            if (r2 == null) goto L13;
            ChannelVO.a.C0021a r3 = r2.f;     // Catch: Exception -> L5
            if (r3 == null) goto L13;
            Integer r4 = Integer.valueOf(r3.b);     // Catch: Exception -> L5
        L14:
            ChannelVO.a r7 = this.b.f;     // Catch: Exception -> L5
            if (r7 == null) goto L19;
            ChannelVO.a.C0021a r8 = r7.f;     // Catch: Exception -> L5
            if (r8 == null) goto L19;
            r0 = Integer.valueOf(r8.c);     // Catch: Exception -> L5
        L19:
            if (r1 != null) goto L21;
            return;
        L21:
            if ((r6 instanceof Float) == false) goto L42;
            if (r4 != null) goto L24;
            return;
        L24:
            if (r4.intValue() < 0) goto L44;
            if (r0 != null) goto L27;
            return;
        L27:
            if (r0.intValue() <= 0) goto L46;
            int r9 = (int) (((Number) r6).floatValue() * r1.getDurationFrames());     // Catch: Exception -> L5
            if (r9 != 1) goto L31;
        L36:
            this.b.c.setVisibility(8);     // Catch: Exception -> L5
            return;
        L31:
            if (r9 == r0.intValue()) goto L36;
            if (r9 != r4.intValue()) goto L47;
            this.b.c.setVisibility(0);     // Catch: Exception -> L5
            return;
        L47:
            return;
        L46:
            return;
        L44:
            return;
        L42:
            return;
        L13:
            r4 = null;
            goto L14
        L40:
            r6 = r5.getAnimatedValue();     // Catch: Exception -> L5
        L5:
            e = move-exception;
            EnsureManager.ensureNotReachHere(e);
        }
    }

    public BigCardTitleView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BigCardTitleView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final String getClickStorageKey() {
        StringBuilder r0 = new StringBuilder("channel_activity_animation_");
        ChannelVO r1 = this.g;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getComponentId();
    L6:
        r0.append(r3);
        r0.append('_');
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r4 = this.h;
        if (r4 == null) goto L9;
        r2 = r4.a;
    L9:
        r0.append(r2);
        return r0.toString();
    L5:
        r3 = null;
        goto L6
    }

    public final void b(final boolean r2) {
        ECHybridExtensionsKt.f(new BigCardTitleView$changeLottieViewVisibility$1(this, r2));
    }

    public final void c(int r2) {
        if (this.f == null) goto L9;
        if (r2 < 0) goto L6;
        final String r3 = "product";
    L7:
        d.c(new BigCardTitleView$stopLottie$1(this, r3));
        return;
    L6:
        r3 = "icon";
        goto L7
    }

    public BigCardTitleView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        View r13 = new SimpleDraweeView(r10);
        this.a = r13;
        AppCompatTextView r14 = new AppCompatTextView(r10);
        r14.setVisibility(8);
        r14.setTextAlignment(4);
        r14.setGravity(17);
        Unit r1 = Unit.INSTANCE;
        this.c = r14;
        SimpleDraweeView r2 = new SimpleDraweeView(r10);
        r2.setVisibility(8);
        this.d = r2;
        LottieAnimationView r3 = new LottieAnimationView(r10);
        r3.setId(ViewCompat.generateViewId());
        r3.addAnimatorListener(new a(this));
        r3.addAnimatorUpdateListener(new b(r3, this));
        this.e = r3;
        int r4 = c.a;
        RelativeLayout.LayoutParams r15 = new RelativeLayout.LayoutParams(c.c(36, getContext(), true), c.c(36, getContext(), true));
        r15.addRule(10);
        r15.topMargin = c.c(9, getContext(), true);
        r15.addRule(14);
        addView(r3, r15);
        RelativeLayout.LayoutParams r16 = new RelativeLayout.LayoutParams(c.c(64, getContext(), true), c.c(40, getContext(), true));
        r16.addRule(3, r3.getId());
        r16.addRule(14);
        addView(r2, r16);
        RelativeLayout.LayoutParams r17 = new RelativeLayout.LayoutParams(-2, -2);
        r17.addRule(8, r3.getId());
        r17.addRule(6, r3.getId());
        r17.addRule(5, r3.getId());
        r17.addRule(7, r3.getId());
        addView(r14, r17);
        RelativeLayout.LayoutParams r18 = new RelativeLayout.LayoutParams(c.c(64, getContext(), true), c.c(80, getContext(), true));
        r18.addRule(13);
        addView(r13, r18);
    }

    public final void a(ChannelVO r6, com.bytedance.android.shopping.mall.homepage.card.headercard.a r7, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r8) {
        Intrinsics.checkNotNullParameter(r7, "cardContext");
        Intrinsics.checkNotNullParameter(r8, "action");
        this.g = r6;
        this.h = r7;
        this.i = r8;
        ChannelVO.a r9 = null;
        this.f = null;
        if (r6 == null) goto L5;
        String r0 = r6.getTitleImgUrl();
    L6:
        b(false);
        if (r0 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L15;
        d0.c(this.a, r0, r7.k);
    L15:
        if (r6 == null) goto L18;
        r9 = r6.getCouponAnimation();
    L18:
        if (r7.e == true) goto L54;
        if (r9 == null) goto L59;
        String r10 = r9.d;
        if (r10.length() <= 0) goto L23;
        boolean r11 = true;
    L24:
        if (r11 == false) goto L60;
        long r4 = System.currentTimeMillis();     // Catch: Exception -> L48
        com.bytedance.android.ec.hybrid.a.e();     // Catch: Exception -> L48
        Calendar r12 = Calendar.getInstance();     // Catch: Exception -> L31
        r12.setTimeInMillis(r4);     // Catch: Exception -> L31
        Calendar r1 = Calendar.getInstance();     // Catch: Exception -> L31
        r1.setTimeInMillis(0);     // Catch: Exception -> L31
        if (r12.get(1) != r1.get(1)) goto L33;
        if (r12.get(6) != r1.get(6)) goto L33;
        boolean r13 = true;
    L35:
        if ((!r13) == false) goto L61;
        this.e.setVisibility(0);     // Catch: Exception -> L48
        this.d.setVisibility(0);     // Catch: Exception -> L48
        this.c.setVisibility(4);     // Catch: Exception -> L48
        this.f = r9;     // Catch: Exception -> L48
        String r14 = r9.e;     // Catch: Exception -> L48
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r2 = this.h;     // Catch: Exception -> L48
        if (r14.length() <= 0) goto L40;
        boolean r5 = true;
    L41:
        if (r5 == false) goto L44;
        if (r2 == null) goto L44;
        d0.c(this.d, r14, r2.k);     // Catch: Exception -> L48
    L44:
        e(String.valueOf(r9.a), this.c, r9.b);     // Catch: Exception -> L48
        LottieAnimationView r15 = this.e;     // Catch: Exception -> L48
        r15.setVisibility(0);     // Catch: Exception -> L48
        r15.setImageAssetsFolder("mall/animation/channel");     // Catch: Exception -> L48
        r15.setAnimationFromUrl(r10);     // Catch: Exception -> L48
        int r16 = (int) r9.f.a;     // Catch: Exception -> L48
        if (r16 <= 1) goto L62;
        r15.setRepeatCount(r16 - 1);     // Catch: Exception -> L48
        return;
    L62:
        return;
    L40:
        r5 = false;
        goto L41
    L61:
        return;
    L33:
        r13 = false;
    L31:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);     // Catch: Exception -> L48
    L48:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
        if (HybridAppInfoService.p.isLocalTest() == true) goto L53;
        b(false);
        return;
    L53:
        throw new RuntimeException("BigCardTitleView#bindCouponAnimation", e);
    L60:
        return;
    L23:
        r11 = false;
        goto L24
    L59:
        return;
    L54:
        return;
    L9:
        if (r0.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void d(boolean r1, Boolean r2, boolean r3) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L11;
        if (r3 == true) goto L7;
        return;
    L7:
        if (this.f == null) goto L13;
        d.c(new BigCardTitleView$playLottie$1(this));
        return;
    L13:
        return;
    }

    public final void e(String r8, AppCompatTextView r9, int r10) {
        if (r8.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        SpannableStringBuilder r1 = new SpannableStringBuilder();
        r1.append(r8);
        Resources r5 = Resources.getSystem();
        r1.setSpan(new AbsoluteSizeSpan(MathKt.roundToInt(TypedValue.applyDimension(1, 14, WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics())))), 0, r1.length(), 17);
        if (r8.length() < 3) goto L11;
        r1.append("\n");
    L11:
        r1.append("元");
        Resources r4 = Resources.getSystem();
        r1.setSpan(new AbsoluteSizeSpan(MathKt.roundToInt(TypedValue.applyDimension(1, 7, WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics())))), r1.length() - 1, r1.length(), 17);
        r1.setSpan(new ForegroundColorSpan(-1), 0, r1.length(), 17);
        ViewGroup.LayoutParams r11 = null;
        if (r10 <= 1) goto L20;
        ViewGroup.LayoutParams r12 = r9.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        r11 = r12;
    L17:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r11;
        if (r13 == null) goto L27;
        int r2 = c.a;
        r13.leftMargin = c.c(2, getContext(), true);
    L27:
        r9.setText(r1);
        com.bytedance.android.ec.hybrid.a.c();
        return;
    L20:
        ViewGroup.LayoutParams r14 = r9.getLayoutParams();
        if ((r14 instanceof ViewGroup.MarginLayoutParams) == false) goto L24;
        r11 = r14;
    L24:
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r11;
        if (r15 == null) goto L27;
        r15.leftMargin = 0;
        goto L27
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ BigCardTitleView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
