package kv0;

import cy0.f;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends j implements a, h<f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f506228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f506229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f506230g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f506231h;

    public final String toString() {
        return "com.bytedance.android.live.profit.vip.scope.__ScopeImpl_VipScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f506229f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f506228e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f506230g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f506231h;
    }

    public b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f506231h = r100;
        Object r101 = k.f470908a;
        this.f506228e = r100.F();
        this.f506229f = r100.A();
        this.f506230g = r100.i();
    }
}
