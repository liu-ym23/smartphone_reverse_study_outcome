package f00;

import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h extends j implements b, e33.h<c> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f474951e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i00.c f474952f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f474953g;

    public final String toString() {
        return "com.bytedance.android.live.broadcast.api.scope.__ScopeImpl_BroadcastInLiveInstanceScope";
    }

    @Override // f00.c
    public final i00.c d() {
        i00.c r100 = this.f474952f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.scope.instance.ILiveBroadcastInstance");
    }

    @Override // f00.b
    public final i00.a e() {
        Object r100 = this.f474951e;
        if (r100 == null) goto L7;
        return (i00.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcast.api.scope.instance.IBroadcastInLiveInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f474953g;
    }

    public h(c r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f474953g = r100;
        this.f474951e = k.f470908a;
        this.f474952f = r100.d();
    }
}
