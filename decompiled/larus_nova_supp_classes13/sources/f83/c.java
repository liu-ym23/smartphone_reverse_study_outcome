package f83;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4FoldableTabIndicator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements View.OnAttachStateChangeListener {
    public final /* synthetic */ AnchorV4FoldableTabIndicator a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public c(AnchorV4FoldableTabIndicator r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r4) {
        Intrinsics.checkNotNullParameter(r4, "v");
        AnchorV4FoldableTabIndicator r5 = this.a;
        r5.d(r5.k, r5.l, true);
    }
}
