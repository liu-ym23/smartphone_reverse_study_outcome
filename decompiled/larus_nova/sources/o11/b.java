package o11;

import cy0.c;
import cy0.f;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends j implements a, h<f> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f521691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f521692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f521693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f521694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final f f521695i;

    public final String toString() {
        return "com.bytedance.android.live.revlink.api.scope.__ScopeImpl_LinkScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f521693g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f521692f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f521694h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final c v() {
        Object r100 = this.f521691e;
        if (r100 == null) goto L7;
        return (c) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f521695i;
    }

    public b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f521695i = r100;
        this.f521691e = k.f470908a;
        this.f521692f = r100.F();
        this.f521693g = r100.A();
        this.f521694h = r100.i();
    }
}
