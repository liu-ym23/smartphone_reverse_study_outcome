package com.bytedance.ee.bear.bitable.superagent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.byted.cast.common.CastMonitor;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0014J0\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0014J\u000e\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0013J\b\u0010&\u001a\u00020\u0019H\u0014J\b\u0010'\u001a\u00020\u0019H\u0014J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentGlowAnimationView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animationWidthRatio", "", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "animationView$delegate", "Lkotlin/Lazy;", "initialized", "", "playbackId", "wantVisible", "compositionReady", "phase", "init", "", "isNightMode", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", CastMonitor.EVENT_PARAM_BYTECAST_NETWORK_STATE_CHANGED, "left", "top", "right", "bottom", "setVisible", "visible", "onAttachedToWindow", "onDetachedFromWindow", "updatePlayback", "startPlayback", "onIntroFinished", "startedId", "stopPlayback", "Frame", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentGlowAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f215749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f215750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f215751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f215752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f215753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f215754f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f215755g;

    public BitableSuperAgentGlowAnimationView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BitableSuperAgentGlowAnimationView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final LottieAnimationView getAnimationView() {
        return (LottieAnimationView) this.f215750b.getValue();
    }

    public final void b() {
        if (this.f215754f == true) goto L6;
        return;
    L6:
        if (isAttachedToWindow() == true) goto L8;
    L14:
        this.f215752d++;
        this.f215755g = -1;
        if (getAnimationView().isAnimating() == false) goto L20;
        getAnimationView().cancelAnimation();
        return;
    L20:
        return;
    L8:
        if (this.f215753e == false) goto L14;
        if (getVisibility() != 0) goto L14;
        if (getAnimationView().isAnimating() == true) goto L18;
        this.f215752d++;
        this.f215755g = 0;
        getAnimationView().setRepeatCount(0);
        getAnimationView().setMinAndMaxFrame(0, 360);
        getAnimationView().setFrame(0);
        getAnimationView().playAnimation();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f215752d++;
        this.f215755g = -1;
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

    public final void setVisible(boolean r100) {
        if (r100 == false) goto L4;
        int r101 = 0;
    L6:
        if (getVisibility() == r101) goto L8;
        setVisibility(r101);
    L8:
        this.f215753e = r100;
        b();
        return;
    L4:
        r101 = 8;
        goto L6
    }

    public static final void a(BitableSuperAgentGlowAnimationView r100, int r101) {
        if (r101 == r100.f215752d) goto L6;
        return;
    L6:
        if (r100.f215755g == 0) goto L9;
        return;
    L9:
        if (r100.isAttachedToWindow() == true) goto L11;
        return;
    L11:
        if (r100.f215753e == true) goto L13;
        return;
    L13:
        if (r100.getVisibility() != 0) goto L21;
        r100.f215755g = 360;
        r100.getAnimationView().setRepeatCount(-1);
        r100.getAnimationView().setMinAndMaxFrame(360, 960);
        r100.getAnimationView().setFrame(360);
        r100.getAnimationView().playAnimation();
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        if (this.f215751c == true) goto L5;
        return;
    L5:
        getAnimationView().measure(View.MeasureSpec.makeMeasureSpec((int) (getMeasuredWidth() * this.f215749a), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    public BitableSuperAgentGlowAnimationView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f215749a = 1.2f;
        this.f215750b = LazyKt.lazy(new BitableSuperAgentGlowAnimationView$animationView$2(r100, this));
        this.f215753e = true;
        this.f215755g = -1;
        boolean r103 = false;
        setClipChildren(false);
        setClipToPadding(false);
        setClickable(false);
        setFocusable(false);
        if (q.a().b() == false) goto L5;
        setVisibility(8);
        return;
    L5:
        addView(getAnimationView(), new FrameLayout.LayoutParams(-1, -1));
        LottieAnimationView r104 = getAnimationView();
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L10;
        String r105 = "bitable_super_agent_glow/dark";
    L11:
        r104.setImageAssetsFolder(r105);
        getAnimationView().setAnimation(R.raw.bitable_super_agent_landing_glow);
        getAnimationView().addLottieOnCompositionLoadedListener(new c(this));
        getAnimationView().addAnimatorListener(new d(this));
        this.f215751c = true;
        return;
    L10:
        r105 = "bitable_super_agent_glow/light";
        goto L11
    }

    public /* synthetic */ BitableSuperAgentGlowAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (this.f215751c == true) goto L5;
        return;
    L5:
        int r105 = getAnimationView().getMeasuredWidth();
        int r106 = ((r103 - r101) - r105) / 2;
        LottieAnimationView r107 = getAnimationView();
        int r108 = r105 + r106;
        r107.layout(r106, 0, r108, r104 - r102);
    }
}
