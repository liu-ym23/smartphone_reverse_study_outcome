package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorV4FoldableTabIndicator f475828a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public c(AnchorV4FoldableTabIndicator r100) {
        this.f475828a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        AnchorV4FoldableTabIndicator r101 = this.f475828a;
        r101.d(r101.f168744k, r101.f168745l, true);
    }
}
