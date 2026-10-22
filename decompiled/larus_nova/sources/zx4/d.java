package zx4;

import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;
import yx4.e;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f573887a;

    public d() {
    }

    @Override // yx4.e
    public final void c() {
    }

    @Override // yx4.e
    public final void a() {
        FrameLayout r100 = this.f573887a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r100 = null;
    L5:
        r100.setVisibility(0);
    }

    @Override // yx4.e
    public final void x() {
        FrameLayout r100 = this.f573887a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("frameLayout");
        r100 = null;
    L5:
        r100.setVisibility(8);
    }

    @Override // yx4.e
    public final void b(FrameLayout r100) {
        Intrinsics.checkNotNullParameter(r100, "frameLayout");
        this.f573887a = r100;
    }
}
