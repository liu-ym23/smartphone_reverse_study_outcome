package zq3;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t1 implements View.OnAttachStateChangeListener {
    public final /* synthetic */ s1 a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
    }

    public t1(s1 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.a();
    }
}
