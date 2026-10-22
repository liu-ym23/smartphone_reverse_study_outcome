package ex0;

import com.bytedance.android.live.recharge.core.g;
import com.bytedance.android.live.recharge.panel.context.c;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends j implements a, h<com.bytedance.android.live.recharge.core.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f474621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.core.b f474622f;

    public final String toString() {
        return "com.bytedance.android.live.recharge.platform.core.scope.__ScopeImpl_RechargePanelScope";
    }

    @Override // ex0.a
    public final c c() {
        Object r100 = this.f474621e;
        if (r100 == null) goto L7;
        return (c) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.context.ICommonPanelContext");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f474622f;
    }

    public b(g r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f474622f = r100;
        this.f474621e = k.f470908a;
    }
}
