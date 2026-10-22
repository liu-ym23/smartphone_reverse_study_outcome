package lt7;

import android.view.View;
import io.supercharge.shimmerlayout.ShimmerLayout;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShimmerLayout f510698a;

    public c(ShimmerLayout r100) {
        this.f510698a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f510698a.c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        this.f510698a.d();
    }
}
