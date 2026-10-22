package com.bytedance.caijing.sdk.infra.base.api.lottie;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001(B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010%\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010 \u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/lottie/LottieAnimationViewStub;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/ILottieAnimationView;", "Landroid/widget/ImageView;", "getLottieAnimationView", "", "mode", "", "setRepeatMode", "count", "setRepeatCount", "", "imageAssetsFolder", "setImageAssetsFolder", "", "scale", "setScale", "progress", "setProgress", "assetName", "setAnimation", "Lorg/json/JSONObject;", "json", "url", "setAnimationFromUrl", "", "getDuration", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/LottieAnimationViewStub$a;", "listener", "setOnAnimationListener", "", "composition", "setComposition", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public final class LottieAnimationViewStub extends FrameLayout implements ILottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILottieAnimationView f202230a;

    public interface a {
        void onCompositionLoaded();

        void onFailure();
    }

    public LottieAnimationViewStub(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LottieAnimationViewStub(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void cancelAnimation() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 == null) goto L6;
        r100.cancelAnimation();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public long getDuration() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getDuration();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public ImageView getLottieAnimationView() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getLottieAnimationView();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final boolean isAnimating() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isAnimating();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void pauseAnimation() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 == null) goto L6;
        r100.pauseAnimation();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void playAnimation() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 == null) goto L6;
        r100.playAnimation();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void resumeAnimation() {
        ILottieAnimationView r100 = this.f202230a;
        if (r100 == null) goto L6;
        r100.resumeAnimation();
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void addAnimatorListener(Animator.AnimatorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.addAnimatorListener(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void loop(boolean r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.loop(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void removeAnimatorListener(Animator.AnimatorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.removeAnimatorListener(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "assetName");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setAnimation(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setAnimationFromUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setAnimationFromUrl(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setComposition(Object r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setComposition(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setImageAssetsFolder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageAssetsFolder");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setImageAssetsFolder(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setOnAnimationListener(a r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setOnAnimationListener(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setProgress(float r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setProgress(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setRepeatCount(int r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setRepeatCount(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setRepeatMode(int r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setRepeatMode(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setScale(float r100) {
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setScale(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public void setAnimation(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        ILottieAnimationView r101 = this.f202230a;
        if (r101 == null) goto L6;
        r101.setAnimation(r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setAnimationFromJson(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        Intrinsics.checkNotNullParameter(r101, "cacheKey");
        ILottieAnimationView r102 = this.f202230a;
        if (r102 == null) goto L6;
        r102.setAnimationFromJson(r100, r101);
        return;
    }

    public LottieAnimationViewStub(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ LottieAnimationViewStub(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
