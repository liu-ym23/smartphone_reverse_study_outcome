package nc0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements ey.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.connect.l f518612a;

    public h(com.bytedance.android.live.revenuelink.connect.l r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518612a = r100;
    }

    @Override // ey.i
    public final void a(fy.h r100) {
        Intrinsics.checkNotNullParameter(r100, "leaveParams");
        this.f518612a.a(r100);
    }

    @Override // ey.i
    public final void b(fy.d r100) {
        Intrinsics.checkNotNullParameter(r100, "finishParams");
        this.f518612a.b(r100);
    }

    @Override // ey.i
    public final void c(fy.f r100) {
        Intrinsics.checkNotNullParameter(r100, "joinChannelParams");
        this.f518612a.c(r100);
    }
}
