package qf4;

import android.animation.Animator;
import android.content.Context;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.j;
import com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView;
import com.bytedance.caijing.sdk.infra.base.api.lottie.LottieAnimationViewStub;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ILottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LottieAnimationView f532730a;

    /* JADX INFO: renamed from: qf4.a$a, reason: collision with other inner class name */
    public static final class C7321a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationViewStub.a f532731a;

        public C7321a(LottieAnimationViewStub.a r100) {
            this.f532731a = r100;
        }

        @Override // com.airbnb.lottie.j
        public final void a(LottieComposition r100) {
            LottieAnimationViewStub.a r101 = this.f532731a;
            if (r101 == null) goto L6;
            r101.onCompositionLoaded();
            return;
        }
    }

    public static final class b<T> implements LottieListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LottieAnimationViewStub.a f532732a;

        public b(LottieAnimationViewStub.a r100) {
            this.f532732a = r100;
        }

        @Override // com.airbnb.lottie.LottieListener
        public final void onResult(Object r100) {
            Throwable r101 = (Throwable) r100;
            LottieAnimationViewStub.a r102 = this.f532732a;
            if (r102 == null) goto L6;
            r102.onFailure();
            return;
        }
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void cancelAnimation() {
        this.f532730a.cancelAnimation();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final long getDuration() {
        return this.f532730a.getDuration();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final boolean isAnimating() {
        return this.f532730a.isAnimating();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void pauseAnimation() {
        this.f532730a.pauseAnimation();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void playAnimation() {
        this.f532730a.playAnimation();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void resumeAnimation() {
        this.f532730a.resumeAnimation();
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final ImageView getLottieAnimationView() {
        return this.f532730a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f532730a = new LottieAnimationView(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void addAnimatorListener(Animator.AnimatorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f532730a.addAnimatorListener(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void loop(boolean r100) {
        this.f532730a.loop(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void removeAnimatorListener(Animator.AnimatorListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f532730a.removeAnimatorListener(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setAnimation(String r100) {
        Intrinsics.checkNotNullParameter(r100, "assetName");
        this.f532730a.setAnimation(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setAnimationFromUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f532730a.setAnimationFromUrl(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setComposition(Object r100) {
        if ((r100 instanceof LottieComposition) == false) goto L6;
        this.f532730a.setComposition((LottieComposition) r100);
        return;
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setImageAssetsFolder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "imageAssetsFolder");
        this.f532730a.setImageAssetsFolder(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setOnAnimationListener(LottieAnimationViewStub.a r100) {
        this.f532730a.addLottieOnCompositionLoadedListener(new C7321a(r100));
        this.f532730a.setFailureListener(new b(r100));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setProgress(float r100) {
        this.f532730a.setProgress(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setRepeatCount(int r100) {
        this.f532730a.setRepeatCount(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setRepeatMode(int r100) {
        this.f532730a.setRepeatMode(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setScale(float r100) {
        this.f532730a.setScale(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setAnimation(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        this.f532730a.setAnimation(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.lottie.ILottieAnimationView
    public final void setAnimationFromJson(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonString");
        Intrinsics.checkNotNullParameter(r101, "cacheKey");
        this.f532730a.setAnimationFromJson(r100, r101);
    }
}
