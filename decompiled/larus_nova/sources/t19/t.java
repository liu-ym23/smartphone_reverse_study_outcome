package t19;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class t implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f544214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAdapterView f544215b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f544214a.removeOnAttachStateChangeListener(this);
        this.f544215b.setAnimation("lottie/toast_loading.json");
        this.f544215b.playAnimation();
    }

    public t(View r100, LottieAdapterView r101) {
        this.f544214a = r100;
        this.f544215b = r101;
    }
}
