package f00;

import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends j implements d, e33.h<a> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f474954e;

    public final String toString() {
        return "com.bytedance.android.live.broadcast.api.scope.__ScopeImpl_BroadcastOnlyGlobalScope";
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f474954e;
    }

    public i(a.C5839a r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f474954e = r100;
        Object r101 = k.f470908a;
    }
}
