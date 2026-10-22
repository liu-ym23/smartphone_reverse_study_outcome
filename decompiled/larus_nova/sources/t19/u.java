package t19;

import android.view.View;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: classes27.dex */
public final class u implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f544216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieAdapterView f544217b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f544216a.removeOnAttachStateChangeListener(this);
        this.f544217b.setAnimation("lottie/toast_loading.json");
        this.f544217b.playAnimation();
    }

    public u(View r100, LottieAdapterView r101) {
        this.f544216a = r100;
        this.f544217b = r101;
    }
}
