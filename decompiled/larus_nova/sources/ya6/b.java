package ya6;

import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;
import xa6.c;
import xa6.d;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends j implements a, h<xa6.a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f567026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.live.kmp.core.a f567027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final xa6.a f567028g;

    public final String toString() {
        return "com.bytedance.kmp.gamecp.live.api.instantplay.__ScopeImpl_TeamPlayScope";
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        com.bytedance.live.kmp.core.a r100 = this.f567027f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // xa6.b
    public final d j() {
        d r100 = this.f567026e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.gamecp.live.api.IGameCpInstanceExt");
    }

    @Override // xa6.a
    public final c o() {
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.kmp.gamecp.live.api.IGameCpInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f567028g;
    }

    public b(xa6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f567028g = r100;
        Object r101 = k.f470908a;
        r100.o();
        this.f567026e = r100.j();
        this.f567027f = r100.i();
    }
}
