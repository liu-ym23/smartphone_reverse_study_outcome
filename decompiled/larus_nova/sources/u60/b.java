package u60;

import cy0.e;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends j implements a, h<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f548916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f548917f;

    public final String toString() {
        return "com.bytedance.android.live.core.scope.__ScopeImpl_LiveRoomScope";
    }

    @Override // u60.a
    public final com.bytedance.live.kmp.core.a i() {
        Object r100 = this.f548916e;
        if (r100 == null) goto L7;
        return (com.bytedance.live.kmp.core.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.ILiveRoomInstance");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f548917f;
    }

    public b(cy0.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f548917f = r100;
        this.f548916e = k.f470908a;
    }
}
