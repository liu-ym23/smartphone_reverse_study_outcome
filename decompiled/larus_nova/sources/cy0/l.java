package cy0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends e33.j implements g, e33.h<u60.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f465771e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f465772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u60.a f465773g;

    public final String toString() {
        return "com.bytedance.android.live.revenue.core.scope.__ScopeImpl_RevenueInstanceScopeExt";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        Object r100 = this.f465771e;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.revenue.core.b) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f465772f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f465773g;
    }

    public l(u60.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f465773g = r100;
        this.f465771e = e33.k.f470908a;
        this.f465772f = r100.i();
    }
}
