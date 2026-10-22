package ji3;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnAttachStateChangeListener {
    public final /* synthetic */ g a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public h(g r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        Object r3 = this.a.I3.w.g(vg3.h.class);
        if ((r3 instanceof vg3.h) == true) goto L5;
        r3 = null;
    L5:
        vg3.h r4 = (vg3.h) r3;
        if (r4 == null) goto L9;
        r4.k0(this.a);
        return;
    }
}
