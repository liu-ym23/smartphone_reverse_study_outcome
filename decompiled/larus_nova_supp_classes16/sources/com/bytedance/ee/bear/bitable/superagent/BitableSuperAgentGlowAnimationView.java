package com.bytedance.ee.bear.bitable.superagent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J0\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0013J\b\u0010&\u001a\u00020\u0019H\u0014J\b\u0010'\u001a\u00020\u0019H\u0014J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentGlowAnimationView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationWidthRatio", "", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "animationView$delegate", "Lkotlin/Lazy;", "initialized", "", "playbackId", "wantVisible", "compositionReady", "phase", "init", "", "isNightMode", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", CustomHeaderConfig.TitleConfig.Position.LEFT, "top", "right", "bottom", "setVisible", "visible", "onAttachedToWindow", "onDetachedFromWindow", "updatePlayback", "startPlayback", "onIntroFinished", "startedId", "stopPlayback", "Frame", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentGlowAnimationView extends FrameLayout {
    public final float a;
    public final Lazy b;
    public boolean c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public BitableSuperAgentGlowAnimationView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BitableSuperAgentGlowAnimationView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final LottieAnimationView getAnimationView() {
        return (LottieAnimationView) this.b.getValue();
    }

    public final void b() {
        if (this.f == true) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L14:
        this.d++;
        this.g = -1;
        if (getAnimationView().isAnimating() == false) goto L20;
        getAnimationView().cancelAnimation();
        return;
    L20:
        return;
    L8:
        if (this.e == false) goto L14;
        if (getVisibility() != 0) goto L14;
        if (getAnimationView().isAnimating() == true) goto L18;
        this.d++;
        this.g = 0;
        getAnimationView().setRepeatCount(0);
        getAnimationView().setMinAndMaxFrame(0, 360);
        getAnimationView().setFrame(0);
        getAnimationView().playAnimation();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.d++;
        this.g = -1;
        if (getAnimationView().isAnimating() == false) goto L5;
        getAnimationView().cancelAnimation();
    L5:
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        b();
    }

    public final void setVisible(boolean r3) {
        if (r3 == false) goto L4;
        int r0 = 0;
    L6:
        if (getVisibility() == r0) goto L8;
        setVisibility(r0);
    L8:
        this.e = r3;
        b();
        return;
    L4:
        r0 = 8;
        goto L6
    }

    public static final void a(BitableSuperAgentGlowAnimationView r2, int r3) {
        if (r3 == r2.d) goto L6;
        return;
    L6:
        if (r2.g == 0) goto L9;
        return;
    L9:
        if (r2.isAttachedToWindow() == true) goto L11;
        return;
    L11:
        if (r2.e == true) goto L13;
        return;
    L13:
        if (r2.getVisibility() != 0) goto L21;
        r2.g = 360;
        r2.getAnimationView().setRepeatCount(-1);
        r2.getAnimationView().setMinAndMaxFrame(360, 960);
        r2.getAnimationView().setFrame(360);
        r2.getAnimationView().playAnimation();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        if (this.c == true) goto L5;
        return;
    L5:
        getAnimationView().measure(View.MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() * this.a), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    public BitableSuperAgentGlowAnimationView(final Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = 1.2f;
        this.b = LazyKt.lazy(new BitableSuperAgentGlowAnimationView$animationView$2(r3, this));
        this.e = true;
        this.g = -1;
        boolean r6 = false;
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(false);
        setFocusable(false);
        if (q.a().b() == false) goto L5;
        setVisibility(8);
        return;
    L5:
        addView(getAnimationView(), new FrameLayout.LayoutParams(-1, -1));
        LottieAnimationView r7 = getAnimationView();
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        r6 = true;
    L8:
        if (r6 == false) goto L10;
        String r8 = "bitable_super_agent_glow/dark";
    L11:
        r7.setImageAssetsFolder(r8);
        getAnimationView().setAnimation(2131820553);
        getAnimationView().addLottieOnCompositionLoadedListener(new c(this));
        getAnimationView().addAnimatorListener(new d(this));
        this.c = true;
        return;
    L10:
        r8 = "bitable_super_agent_glow/light";
        goto L11
    }

    public /* synthetic */ BitableSuperAgentGlowAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (this.c == true) goto L5;
        return;
    L5:
        int r6 = getAnimationView().getMeasuredWidth();
        int r7 = ((r4 - r2) - r6) / 2;
        LottieAnimationView r8 = getAnimationView();
        int r9 = r6 + r7;
        r8.layout(r7, 0, r9, r5 - r3);
    }
}
