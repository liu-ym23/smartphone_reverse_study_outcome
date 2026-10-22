package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b extends kx5.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static kx5.c f244655f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRequest.Priority f244656e;

    public final void c() {
        if (this.f506555a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        if (f244655f != null) goto L7;
        f244655f = kx5.c.b();
    L7:
        kx5.c r100 = f244655f;
        monitor-enter(r100);
        c.f244658g.a(this);     // Catch: Throwable -> L12
        monitor-exit(r100);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public final int a() {
        return this.f506558d;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public final IRequest.Priority getPriority() {
        return this.f244656e;
    }

    public b(IRequest.Priority r100) {
        this.f244656e = r100;
        StringUtils.isEmpty("UpdateHelper-Thread");
    }

    @Override // java.lang.Comparable
    public final int compareTo(IRequest r100) {
        IRequest r101 = r100;
        IRequest.Priority r102 = this.f244656e;
        IRequest.Priority r103 = r101.getPriority();
        if (r102 != null) goto L5;
        r102 = IRequest.Priority.NORMAL;
    L5:
        if (r103 != null) goto L7;
        r103 = IRequest.Priority.NORMAL;
    L7:
        if (r102 != r103) goto L10;
        return this.f506558d - r101.a();
    L10:
        return r103.ordinal() - r102.ordinal();
    }
}
