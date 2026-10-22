package ir2;

import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f495441a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // ir2.a
    public final cy0.a Ak() {
        return (cy0.a) this.f495441a.a().b(vp2.a.f556613f);
    }

    public b(com.bytedance.android.live.revenue.core.b r100) {
        Intrinsics.checkNotNullParameter(r100, "inst");
        this.f495441a = r100;
    }
}
