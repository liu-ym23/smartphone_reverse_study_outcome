package com.bytedance.caijing.sdk.infra.base.api.lottie;

import android.animation.Animator;
import android.widget.ImageView;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\tH&J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH&J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0011H&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\u0006H&J\b\u0010$\u001a\u00020\u0006H&J\b\u0010%\u001a\u00020\u0006H&J\b\u0010'\u001a\u00020&H&J\u0012\u0010)\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010(H&J\u0012\u0010+\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001H&¨\u0006,"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/lottie/ILottieAnimationView;", "", "Landroid/widget/ImageView;", "getLottieAnimationView", "Landroid/animation/Animator$AnimatorListener;", "listener", "", "addAnimatorListener", "removeAnimatorListener", "", "loop", "", "mode", "setRepeatMode", "count", "setRepeatCount", "isAnimating", "", "imageAssetsFolder", "setImageAssetsFolder", "", "scale", "setScale", "progress", "setProgress", "assetName", "setAnimation", "Lorg/json/JSONObject;", "json", "jsonString", "cacheKey", "setAnimationFromJson", "url", "setAnimationFromUrl", "playAnimation", "pauseAnimation", "resumeAnimation", "cancelAnimation", "", "getDuration", "Lcom/bytedance/caijing/sdk/infra/base/api/lottie/LottieAnimationViewStub$a;", "setOnAnimationListener", "composition", "setComposition", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface ILottieAnimationView {
    void addAnimatorListener(Animator.AnimatorListener r100);

    void cancelAnimation();

    long getDuration();

    ImageView getLottieAnimationView();

    boolean isAnimating();

    void loop(boolean r100);

    void pauseAnimation();

    void playAnimation();

    void removeAnimatorListener(Animator.AnimatorListener r100);

    void resumeAnimation();

    void setAnimation(String r100);

    void setAnimation(JSONObject r100);

    void setAnimationFromJson(String r100, String r101);

    void setAnimationFromUrl(String r100);

    void setComposition(Object r100);

    void setImageAssetsFolder(String r100);

    void setOnAnimationListener(LottieAnimationViewStub.a r100);

    void setProgress(float r100);

    void setRepeatCount(int r100);

    void setRepeatMode(int r100);

    void setScale(float r100);
}
