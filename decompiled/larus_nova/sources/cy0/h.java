package cy0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h extends e33.j implements a, e33.h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f465762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.scope.j f465763f;

    public final String toString() {
        return "com.bytedance.android.live.revenue.core.scope.__ScopeImpl_LivePlayScope";
    }

    @Override // cy0.a
    public final b y() {
        Object r100 = this.f465762e;
        if (r100 == null) goto L7;
        return (b) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.LivePlayScopeInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f465763f;
    }

    public h(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f465763f = r100;
        this.f465762e = e33.k.f470908a;
    }
}
