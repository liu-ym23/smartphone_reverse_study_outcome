package zx4;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import yx4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements e {
    public FrameLayout a;

    public d() {
    }

    @Override // yx4.e
    public final void c() {
    }

    @Override // yx4.e
    public final void a() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r0 = null;
    L5:
        r0.setVisibility(0);
    }

    @Override // yx4.e
    public final void x() {
        FrameLayout r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r0 = null;
    L5:
        r0.setVisibility(8);
    }

    @Override // yx4.e
    public final void b(FrameLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "frameLayout");
        this.a = r2;
    }
}
