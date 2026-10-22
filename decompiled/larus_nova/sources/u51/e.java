package u51;

import com.bytedance.android.live.revlink.link.core.service.s;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e extends j implements c, h<o11.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f548776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f548777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final cy0.c f548778g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.a f548779h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.live.revenue.core.b f548780i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f548781j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o11.a f548782k;

    public final String toString() {
        return "com.bytedance.android.live.revlink.link.infra.__ScopeImpl_RevLinkInfraAudienceScope";
    }

    @Override // cy0.g
    public final com.bytedance.android.live.revenue.core.b A() {
        com.bytedance.android.live.revenue.core.b r100 = this.f548780i;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstanceExt");
    }

    @Override // cy0.f
    public final com.bytedance.android.live.revenue.core.a F() {
        com.bytedance.android.live.revenue.core.a r100 = this.f548779h;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.IRevenueInstance");
    }

    @Override // u51.c
    public final s f() {
        Object r100 = this.f548777f;
        if (r100 == null) goto L7;
        return (s) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.link.core.service.RevenueDynamicLayoutClient");
    }

    @Override // u51.c
    public final ld.a getLinkInternalDataSet() {
        Object r100 = this.f548776e;
        if (r100 == null) goto L7;
        return (ld.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.datacenter.ILinkInternalDataSet");
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f548781j;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // o11.a
    public final cy0.c v() {
        cy0.c r100 = this.f548778g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.core.scope.RevenueDataScope");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f548782k;
    }

    public e(o11.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f548782k = r100;
        Object r101 = k.f470908a;
        this.f548776e = r101;
        this.f548777f = r101;
        this.f548778g = r100.v();
        this.f548779h = r100.F();
        this.f548780i = r100.A();
        this.f548781j = r100.i();
    }
}
