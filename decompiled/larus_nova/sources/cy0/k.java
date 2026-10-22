package cy0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k extends e33.j implements f, e33.h<g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f465767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f465768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f465769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f465770h;

    public final String toString() {
        return "com.bytedance.android.live.revenue.core.scope.__ScopeImpl_RevenueInstanceScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f465768f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        Object r100 = this.f465767e;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.revenue.core.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f465769g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f465770h;
    }

    public k(l r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f465770h = r100;
        this.f465767e = e33.k.f470908a;
        this.f465768f = r100.A();
        this.f465769g = r100.i();
    }
}
