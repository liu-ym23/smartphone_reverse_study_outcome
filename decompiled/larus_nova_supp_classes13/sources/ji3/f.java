package ji3;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements View.OnAttachStateChangeListener {
    public final /* synthetic */ e a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public f(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Object r3 = this.a.I3.w.g(AnchorV4VM.class);
        if ((r3 instanceof AnchorV4VM) == true) goto L5;
        r3 = null;
    L5:
        AnchorV4VM r4 = (AnchorV4VM) r3;
        if (r4 == null) goto L9;
        r4.listenActivityTickIfNotContains(this.a);
        return;
    }
}
