package lp0;

import android.content.Context;
import e33.h;
import e33.j;
import e33.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends j implements a, h<com.bytedance.android.scope.j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f510199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Object f510200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Object f510201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f510202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.scope.j f510203i;

    public final String toString() {
        return "com.bytedance.android.live.openplatform.impl.miniappanchor.choose.scope.__ScopeImpl_MiniAppChooseScope";
    }

    @Override // lp0.a
    public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b getContainer() {
        Object r100 = this.f510202h;
        if (r100 == null) goto L7;
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.IMiniAppChooseContainer");
    }

    @Override // lp0.a
    public Context getContext() {
        Object r100 = this.f510200f;
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.content.Context");
    }

    @Override // lp0.a
    public final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a getRoot() {
        return (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a) this.f510201g;
    }

    @Override // lp0.a
    public final so0.a w() {
        Object r100 = this.f510199e;
        if (r100 == null) goto L7;
        return (so0.a) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.openplatform.impl.base.miniappanchor.IMiniAppAnchorService");
    }

    @Override // e33.h
    public final com.bytedance.android.scope.j r() {
        return this.f510203i;
    }

    public c(com.bytedance.android.scope.j r100) {
        Intrinsics.checkNotNullParameter(r100, "__parentScope");
        this.f510203i = r100;
        Object r101 = k.f470908a;
        this.f510199e = r101;
        this.f510200f = r101;
        this.f510201g = r101;
        this.f510202h = r101;
    }
}
