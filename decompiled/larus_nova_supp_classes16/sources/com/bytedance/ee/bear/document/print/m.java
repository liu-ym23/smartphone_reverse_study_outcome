package com.bytedance.ee.bear.document.print;

import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m implements Runnable {
    public final /* synthetic */ PrintExportCoordinator a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public m(PrintExportCoordinator r1, long r2, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PrintExportCoordinator r0 = this.a;     // Catch: Throwable -> L10
        long r1 = this.b;     // Catch: Throwable -> L10
        int r3 = PrintExportCoordinator.l;     // Catch: Throwable -> L10
        if (r0.k(r1) == false) goto L13;
        PrintExportLoadingDialogFragment r2 = this.a.g;     // Catch: Throwable -> L10
        if (r2 == null) goto L17;
        int r4 = RangesKt.coerceIn(this.c, 0, 100);     // Catch: Throwable -> L10
        r2.j = r4;     // Catch: Throwable -> L10
        OpenLoadingView r5 = r2.h;     // Catch: Throwable -> L10
        if (r5 == null) goto L18;
        r5.setProgress(r4);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
