package ju4;

import android.view.View;
import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFragment;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements View.OnAttachStateChangeListener {
    public final /* synthetic */ BitableApplyProFragment a;
    public final /* synthetic */ BaseTitleBar b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.t;
        if (r3 == null) goto L6;
        r3.a(true);
        return;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        au5.b r3 = this.a.t;
        if (r3 == null) goto L5;
        r3.a(false);
    L5:
        this.b.removeOnAttachStateChangeListener(this);
    }

    public a(BitableApplyProFragment r1, BaseTitleBar r2) {
        this.a = r1;
        this.b = r2;
    }
}
