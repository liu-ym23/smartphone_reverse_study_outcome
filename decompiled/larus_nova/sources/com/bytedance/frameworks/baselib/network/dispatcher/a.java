package com.bytedance.frameworks.baselib.network.dispatcher;

import com.bytedance.common.utility.StringUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends kx5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f244653e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IRequest.Priority f244654f;

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.f244653e != null) goto L5;
        return;
    L5:
        if (this.f506556b.get() == true) goto L15;
        this.f244653e.run();     // Catch: Throwable -> L8
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public final int a() {
        return this.f506558d;
    }

    @Override // com.bytedance.frameworks.baselib.network.dispatcher.IRequest
    public final IRequest.Priority getPriority() {
        return this.f244654f;
    }

    @Override // kx5.a
    public final void b(int r100) {
        this.f506558d = r100;
    }

    @Override // java.lang.Comparable
    public final int compareTo(IRequest r100) {
        IRequest r101 = r100;
        IRequest.Priority r102 = this.f244654f;
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

    public a(String r100, IRequest.Priority r101, int r102, Runnable r103) {
        this.f244654f = r101;
        if (StringUtils.isEmpty(r100) == true) goto L5;
    L5:
        this.f506557c = r102;
        this.f244653e = r103;
    }
}
