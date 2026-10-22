package com.bytedance.helios.sdk.engine;

import com.larus.apm.impl.protector.RunnableProtector;
import hz5.k;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f245567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f245568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ruler.base.models.f f245569c;

    public b(List r100, Map r101, com.bytedance.ruler.base.models.f r102) {
        this.f245567a = r100;
        this.f245568b = r101;
        this.f245569c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable r100 = this.f245569c.f267673h;     // Catch: Throwable -> L9
        if (5 < k.f487697b) goto L7;
        hz5.h r101 = k.f487696a;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.e(r100);     // Catch: Throwable -> L9
    L7:
        fz5.b.c().f();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L13;
        return;
    L13:
        throw th;
    }
}
