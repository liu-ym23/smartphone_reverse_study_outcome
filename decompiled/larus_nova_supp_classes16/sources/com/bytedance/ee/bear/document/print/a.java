package com.bytedance.ee.bear.document.print;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends PrintDocumentAdapter {
    public final c a;
    public final Function0<Unit> b;
    public final ExecutorService c;
    public final AtomicBoolean d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.print.a$a, reason: collision with other inner class name */
    public static final class C0095a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ ParcelFileDescriptor b;
        public final /* synthetic */ CancellationSignal c;
        public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback d;

        public b(a r1, ParcelFileDescriptor r2, CancellationSignal r3, PrintDocumentAdapter.WriteResultCallback r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            a r0 = this.a;
            ParcelFileDescriptor r1 = this.b;
            CancellationSignal r2 = this.c;
            PrintDocumentAdapter.WriteResultCallback r3 = this.d;
            r0.getClass();
            PolarisFileInputStreamWrapper r5 = r0.a.b();     // Catch: Throwable -> L33
            PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r1.getFileDescriptor());     // Catch: Throwable -> L28
            byte[] r4 = new byte[8192];     // Catch: Throwable -> L23
        L8:
            if (r0.d.get() == true) goto L19;
            if (r2.isCanceled() == true) goto L19;
            int r7 = r5.read(r4);     // Catch: Throwable -> L23
            if (r7 < 0) goto L14;
            r6.write(r4, 0, r7);     // Catch: Throwable -> L23
            goto L8
        L14:
            r6.flush();     // Catch: Throwable -> L23
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L23
            CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L33
            r3.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});     // Catch: Throwable -> L33
            return;
        L19:
            r3.onWriteCancelled();     // Catch: Throwable -> L23
            CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r5, null);     // Catch: Throwable -> L33
            return;
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            CloseableKt.closeFinally(r5, th);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            tt5.a.d("PdfPrintAdapter", "write print artifact failed: ".concat(th.getClass().getSimpleName()));
            if (r0.d.get() == false) goto L37;
        L40:
            r3.onWriteCancelled();
            return;
        L37:
            if (r2.isCanceled() == true) goto L40;
            r3.onWriteFailed(null);
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

    static {
    }

    public final void a() {
        if (this.d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.c.shutdownNow();
        this.a.a();
        this.b.invoke();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.d("PdfPrintAdapter", "notify print adapter finished failed: ".concat(th.getClass().getSimpleName()));
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onFinish() {
        a();
    }

    public a(c r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "artifact");
        Intrinsics.checkNotNullParameter(r3, "onFinished");
        this.a = r2;
        this.b = r3;
        this.c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("PdfPrintDocumentAdapter"));
        this.d = new AtomicBoolean(false);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onWrite(PageRange[] r3, ParcelFileDescriptor r4, CancellationSignal r5, PrintDocumentAdapter.WriteResultCallback r6) {
        Intrinsics.checkNotNullParameter(r3, "pages");
        Intrinsics.checkNotNullParameter(r4, "destination");
        Intrinsics.checkNotNullParameter(r5, "cancellationSignal");
        Intrinsics.checkNotNullParameter(r6, "callback");
        if (this.d.get() == false) goto L10;
        r6.onWriteFailed(null);
        return;
    L10:
        this.c.execute(new b(this, r4, r5, r6));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        tt5.a.k("PdfPrintAdapter", "write rejected after print adapter finished");
        r6.onWriteFailed(null);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes r1, PrintAttributes r2, CancellationSignal r3, PrintDocumentAdapter.LayoutResultCallback r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "cancellationSignal");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (this.d.get() == false) goto L5;
    L9:
        r4.onLayoutCancelled();
        return;
    L5:
        if (r3.isCanceled() == true) goto L9;
        r4.onLayoutFinished(new PrintDocumentInfo.Builder(this.a.b).setContentType(0).setPageCount(-1).build(), !Intrinsics.areEqual(r1, r2));
    }
}
