package com.bytedance.ee.bear.lynx.impl.xelement;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tt5.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0012J\u0017\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J(\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u001cH\u0014J\b\u0010\"\u001a\u00020\fH\u0014J\b\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020\fH\u0014J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xelement/CCMLynxLottieView;", "Lcom/bytedance/ee/bear/facade/common/widget/BearLottieView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "TAG", "", "needPlay", "", "mHasInit", "playAnimation", "", "setAutoplay", "autoplay", "setAutoplay$features_lynx_impl_productionChinaRelease", "setLoop", "loop", "setLoop$features_lynx_impl_productionChinaRelease", "setAnimationAsset", "assetName", "setAnimationAsset$features_lynx_impl_productionChinaRelease", "cancelAnimation", "init", "onVisibilityChanged", "changedView", "Landroid/view/View;", RemoteMessageConst.Notification.VISIBILITY, "", "onSizeChanged", "w", "h", "oldw", "oldh", "onAttachedToWindow", "isVisible", "checkAnimation", "onDetachedFromWindow", "invalidateDrawable", "dr", "Landroid/graphics/drawable/Drawable;", "isLoadingDrawableRunning", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxLottieView extends BearLottieView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f229974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f229975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f229976k;

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView
    public final void playAnimation() {
        a.h(this.f229974i, "xxx:playAnimation: ");
        if (isVisible() == false) goto L5;
        super.playAnimation();
        return;
    L5:
        this.f229975j = true;
    }

    private final boolean isVisible() {
        if (getVisibility() == 0) goto L5;
    L9:
        return false;
    L5:
        if (getHeight() <= 0) goto L9;
        if (getWidth() <= 0) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView
    public final void cancelAnimation() {
        super.cancelAnimation();
        this.f229975j = false;
    }

    public final boolean m() {
        Object r100 = getDrawable();
        if (isAnimating() == false) goto L5;
    L10:
        return true;
    L5:
        if ((r100 instanceof Animatable) == true) goto L7;
    L9:
        return false;
    L7:
        if (((Animatable) r100).isRunning() == false) goto L9;
        goto L9
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m() == false) goto L6;
        a.h(this.f229974i, "xxx: onAttachedToWindow: cancel animator");
        super.cancelAnimation();
        this.f229975j = true;
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a.h(this.f229974i, "xxx: onDetachedFromWindow");
    }

    public CCMLynxLottieView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        if (m() == false) goto L5;
        a.h(this.f229974i, "xxx:init: cancel animator");
        super.cancelAnimation();
        this.f229975j = true;
    L5:
        setAnimation(R.raw.loading_anim);
        this.f229976k = true;
        this.f229974i = "CCMLynxLottieView";
    }

    private final void checkAnimation(int r100) {
        if (this.f229976k == true) goto L5;
        return;
    L5:
        if (r100 != 0) goto L12;
        if (isVisible() == false) goto L12;
        if (this.f229975j == false) goto L12;
        a.h(this.f229974i, "xxx: checkAnimation: play " + hashCode());
        super.playAnimation();
        return;
    L12:
        if (m() == false) goto L14;
        this.f229975j = true;
    L14:
        a.b(this.f229974i, "xxx: checkAnimation: cancel " + hashCode());
        super.cancelAnimation();
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView, android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "dr");
        if (this.f229976k == true) goto L7;
        super.invalidateDrawable(r100);
        return;
    L7:
        if (isVisible() == true) goto L13;
        a.h(this.f229974i, "invalidateDrawable not visible, return");
        if (m() == false) goto L11;
        this.f229975j = true;
    L11:
        super.cancelAnimation();
        return;
    L13:
        super.invalidateDrawable(r100);
    }

    public final void setAnimationAsset$features_lynx_impl_productionChinaRelease(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        setAnimation(r100);
        return;
    L5:
        a.k(this.f229974i, "asset name is empty");
    }

    public final void setAutoplay$features_lynx_impl_productionChinaRelease(boolean r100) {
        this.f229975j = r100;
    }

    public final void setLoop$features_lynx_impl_productionChinaRelease(boolean r100) {
        if (r100 == false) goto L5;
        setRepeatCount(-1);
        return;
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "changedView");
        a.h(this.f229974i, "xxx: onVisibilityChanged: " + r101);
        checkAnimation(r101);
    }

    @Override // com.bytedance.ee.bear.facade.common.widget.BearLottieView, com.airbnb.lottie.LottieAnimationView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        a.h(this.f229974i, "xxx: onSizeChanged: ");
        checkAnimation(getVisibility());
    }
}
