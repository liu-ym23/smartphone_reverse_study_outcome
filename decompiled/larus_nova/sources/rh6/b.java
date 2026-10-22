package rh6;

import cy0.e;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends j implements a, h<e> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f537788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f537789f;

    public final String toString() {
        return "com.bytedance.live.core.scope.__ScopeImpl_LivePreviewScope";
    }

    @Override // rh6.a
    public final vh6.b s() {
        Object r100 = this.f537788e;
        if (r100 == null) goto L7;
        return (vh6.b) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.kmp.core.util.IPreviewDependencyResolver");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f537789f;
    }

    public b(cy0.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f537789f = r100;
        this.f537788e = k.f470908a;
    }
}
