package com.bytedance.ee.bear.document.print;

import android.net.Uri;
import io.reactivex.disposables.Disposables;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements rw4.a {
    public final /* synthetic */ PrintExportCoordinator a;
    public final /* synthetic */ long b;
    public final /* synthetic */ oj5.c c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;

    @Override // rw4.a
    public final void onDismiss() {
    }

    @Override // rw4.a
    public final void onExportStart() {
        PrintExportCoordinator.c(this.a, this.b, 0);
    }

    @Override // rw4.a
    public final void onStartDownload() {
        PrintExportCoordinator.c(this.a, this.b, 20);
    }

    @Override // rw4.a
    public final void onStartPolling() {
        PrintExportCoordinator.c(this.a, this.b, 10);
    }

    @Override // rw4.a
    public final void onDownloading(int r6) {
        PrintExportCoordinator.c(this.a, this.b, (int) (20 + (r6 * 0.8f)));
    }

    @Override // rw4.a
    public final void onPolling(int r5) {
        PrintExportCoordinator.c(this.a, this.b, RangesKt.coerceAtMost((r5 * 5) + 10, 20));
    }

    @Override // rw4.a
    public final void onSuccess(Uri r11) {
        Intrinsics.checkNotNullParameter(r11, "uri");
        PrintExportCoordinator r4 = this.a;
        long r5 = this.b;
        oj5.c r7 = this.c;
        String r8 = this.d;
        String r3 = this.e;
        int r0 = PrintExportCoordinator.l;
        r4.getClass();
        h r9 = new h(r11, r3, r4, r5, r7, r8);
    L7:
        e = move-exception;
        tt5.a.e("PrintExportCoordinator", "schedule print artifact preparation failed", e, false);
        r9.run();
        return;
    L4:
        if (fo5.d.b().scheduleDirect(r9) != Disposables.disposed()) goto L12;
        tt5.a.k("PrintExportCoordinator", "schedule print artifact preparation was rejected");     // Catch: RuntimeException -> L7
        r9.run();     // Catch: RuntimeException -> L7
        return;
    }

    @Override // rw4.a
    public final void onFail(int r8, Throwable r9) {
        PrintExportCoordinator.a(this.a, this.b, this.c, this.d, r8, r9);
    }

    public f(PrintExportCoordinator r1, long r2, oj5.c r4, String r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
