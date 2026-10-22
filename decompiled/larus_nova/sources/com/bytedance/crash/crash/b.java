package com.bytedance.crash.crash;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f203119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.crash.monitor.a f203120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f203121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f203122d;

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = 0;
    L12:
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    L4:
        if (r100 >= this.f203119a.size()) goto L15;
        c r101 = this.f203122d;     // Catch: Throwable -> L7
        CrashSummary r102 = (CrashSummary) ListProtector.get(this.f203119a, r100);     // Catch: Throwable -> L7
        com.bytedance.crash.monitor.a r103 = this.f203120b;     // Catch: Throwable -> L7
        File r104 = (File) ListProtector.get(this.f203121c, r100);     // Catch: Throwable -> L7
        r101.getClass();     // Catch: Throwable -> L7
        c.b(r102, r103, r104);     // Catch: Throwable -> L7
        r100 = r100 + 1;
        goto L12
    }

    public b(c r100, List r101, com.bytedance.crash.monitor.a r102, List r103) {
        this.f203122d = r100;
        this.f203119a = r101;
        this.f203120b = r102;
        this.f203121c = r103;
    }
}
