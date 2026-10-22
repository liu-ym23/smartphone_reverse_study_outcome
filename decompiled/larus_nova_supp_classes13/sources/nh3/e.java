package nh3;

import android.view.View;
import com.bytedance.android.ec.core.sku.CommonMarqueeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements View.OnAttachStateChangeListener {
    public final /* synthetic */ CommonMarqueeView a;

    public e(CommonMarqueeView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        this.a.d();
    }
}
