package ru0;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends j implements a, h<a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f539239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f539240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f539241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f539242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f539243i;

    public final String toString() {
        return "com.bytedance.android.live.profit.livepet.scopes.__ScopeImpl_LivePetInstanceScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f539241g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f539240f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f539242h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f539243i;
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f539243i = r100;
        this.f539239e = k.f470908a;
        this.f539240f = r100.F();
        this.f539241g = r100.A();
        this.f539242h = r100.i();
    }
}
