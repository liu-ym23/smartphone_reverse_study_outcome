package zx4;

import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.dependency.LoadingLayoutScope;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements yx4.d {
    public FrameLayout a;
    public BearLottieView b;

    public c() {
    }

    @Override // yx4.d
    public final void hideLoading() {
        BearLottieView r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r0 = null;
    L5:
        r0.cancelAnimation();
    }

    @Override // yx4.d
    public final void showLoading() {
        BearLottieView r0 = this.b;
        BearLottieView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r0 = null;
    L5:
        r0.setAnimation(2131820626);
        BearLottieView r2 = this.b;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
        r2 = null;
    L8:
        r2.loop(true);
        BearLottieView r3 = this.b;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivLoading");
    L12:
        r1.playAnimation();
        return;
    L11:
        r1 = r3;
        goto L12
    }

    @Override // yx4.d
    public final void detachLoadingView() {
        hideLoading();
        FrameLayout r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r0 = null;
    L5:
        r0.removeAllViews();
    }

    @Override // yx4.d
    public final LoadingLayoutScope getScope() {
        return LoadingLayoutScope.CONTENT;
    }

    @Override // yx4.d
    public final void attachLoadingView(FrameLayout r4) {
        Intrinsics.checkNotNullParameter(r4, "frameLayout");
        this.a = r4;
        this.b = (BearLottieView) LayoutInflater.from(r4.getContext()).inflate(2131563304, r4, true).findViewById(2131376377);
        hideLoading();
    }
}
