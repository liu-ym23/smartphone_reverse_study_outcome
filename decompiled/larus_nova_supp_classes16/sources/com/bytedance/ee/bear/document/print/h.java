package com.bytedance.ee.bear.document.print;

import android.net.Uri;
import android.os.Handler;
import com.bytedance.ee.bear.widgets.OpenLoadingView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.pb.security_event.ContainerType;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements Runnable {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PrintExportCoordinator c;
    public final /* synthetic */ long d;
    public final /* synthetic */ oj5.c e;
    public final /* synthetic */ String f;

    public static final class a implements Runnable {
        public final /* synthetic */ PrintExportCoordinator a;
        public final /* synthetic */ long b;
        public final /* synthetic */ oj5.c c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c e;

        public a(PrintExportCoordinator r1, long r2, oj5.c r4, String r5, c r6) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
        }

        public final void a() {
            final PrintExportCoordinator r0 = this.a;
            long r1 = this.b;
            final oj5.f r3 = this.c;
            final String r4 = this.d;
            c r5 = this.e;
            int r6 = PrintExportCoordinator.l;
            if (r0.k(r1) == true) goto L5;
        L29:
            r5.a();
            r0.f(r1, false);
            return;
        L5:
            if (r0.j() == false) goto L29;
            PrintExportLoadingDialogFragment r7 = r0.g;
            if (r7 == null) goto L31;
            int r8 = RangesKt.coerceIn(100, 0, 100);
            r7.j = r8;
            OpenLoadingView r9 = r7.h;
            if (r9 == null) goto L31;
            r9.setProgress(r8);
        L31:
            String r10 = null;
            if ((r3 instanceof oj5.f) == false) goto L15;
            oj5.f r11 = r3;     // Catch: Throwable -> L26
        L16:
            com.bytedance.ee.bear.middleground_permission_export.model.c r12 = (com.bytedance.ee.bear.middleground_permission_export.model.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.c.class, null, null, 6);     // Catch: Throwable -> L26
            sbb.e r13 = sbb.e.d(r3.i());     // Catch: Throwable -> L26
            if (r11 == null) goto L19;
            ContainerType r14 = ContainerType.Wiki;     // Catch: Throwable -> L26
        L20:
            if (r11 == null) goto L22;
            r10 = r11.O;     // Catch: Throwable -> L26
        L22:
            if (r10 != null) goto L24;
            r10 = "";
        L24:
            r12.d(r13, r4, r14, r10);     // Catch: Throwable -> L26
        L28:
            r0.f(r1, false);
            Handler r2 = r.a;
            r.a(r0.a, r5, new PrintExportCoordinator$deliverPrintArtifact$1(r3, r4, r0));
            return;
        L19:
            r14 = ContainerType.ContainerTypeUnknown;     // Catch: Throwable -> L26
            goto L20
        L15:
            r11 = null;
        L26:
            th = move-exception;
            tt5.a.d("PrintExportCoordinator", "report print audit failed: ".concat(th.getClass().getSimpleName()));
            goto L28
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(Uri r1, String r2, PrintExportCoordinator r3, long r4, oj5.c r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r6;
        this.f = r7;
    }

    public final void a() {
        byte[] r0 = c.d;     // Catch: Throwable -> L5
        c r8 = c.a.a(this.a, this.b);     // Catch: Throwable -> L5
        PrintExportCoordinator r3 = this.c;
        r3.a.runOnUiThread(new a(r3, this.d, this.e, this.f, r8));
        return;
    L5:
        th = move-exception;
        PrintExportCoordinator.a(this.c, this.d, this.e, this.f, -1, th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
