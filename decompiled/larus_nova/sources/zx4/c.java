package zx4;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements yx4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f573885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BearLottieView f573886b;

    public c() {
    }

    @Override // yx4.d
    public final void hideLoading() {
        BearLottieView r100 = this.f573886b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r100 = null;
    L5:
        r100.cancelAnimation();
    }

    @Override // yx4.d
    public final void showLoading() {
        BearLottieView r100 = this.f573886b;
        BearLottieView r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r100 = null;
    L5:
        r100.setAnimation(R.raw.loading_anim);
        BearLottieView r102 = this.f573886b;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r102 = null;
    L8:
        r102.loop(true);
        BearLottieView r103 = this.f573886b;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
    L12:
        r101.playAnimation();
        return;
    L11:
        r101 = r103;
        goto L12
    }

    @Override // yx4.d
    public final void detachLoadingView() {
        hideLoading();
        FrameLayout r100 = this.f573885a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r100 = null;
    L5:
        r100.removeAllViews();
    }

    @Override // yx4.d
    public final LoadingLayoutScope getScope() {
        return LoadingLayoutScope.CONTENT;
    }

    @Override // yx4.d
    public final void attachLoadingView(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        this.f573885a = r100;
        this.f573886b = (BearLottieView) LayoutInflater.from(r100.getContext()).inflate(R.layout.layout_default_loading, r100, true).findViewById(R.id.iv_loading);
        hideLoading();
    }
}
