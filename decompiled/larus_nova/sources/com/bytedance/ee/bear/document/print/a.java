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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends PrintDocumentAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f221144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f221145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f221146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f221147d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.print.a$a, reason: collision with other inner class name */
    public static final class C3151a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f221148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptor f221149b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f221150c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f221151d;

        public b(a r100, ParcelFileDescriptor r101, CancellationSignal r102, PrintDocumentAdapter.WriteResultCallback r103) {
            this.f221148a = r100;
            this.f221149b = r101;
            this.f221150c = r102;
            this.f221151d = r103;
        }

        public final void a() {
            a r100 = this.f221148a;
            ParcelFileDescriptor r101 = this.f221149b;
            CancellationSignal r102 = this.f221150c;
            PrintDocumentAdapter.WriteResultCallback r103 = this.f221151d;
            r100.getClass();
            PolarisFileInputStreamWrapper r104 = r100.f221144a.b();     // Catch: Throwable -> L33
            PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r101.getFileDescriptor());     // Catch: Throwable -> L28
            byte[] r106 = new byte[8192];     // Catch: Throwable -> L23
        L8:
            if (r100.f221147d.get() == true) goto L19;
            if (r102.isCanceled() == true) goto L19;
            int r107 = r104.read(r106);     // Catch: Throwable -> L23
            if (r107 < 0) goto L14;
            r105.write(r106, 0, r107);     // Catch: Throwable -> L23
            goto L8
        L14:
            r105.flush();     // Catch: Throwable -> L23
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L23
            CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L33
            r103.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});     // Catch: Throwable -> L33
            return;
        L19:
            r103.onWriteCancelled();     // Catch: Throwable -> L23
            CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L28
            CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L33
            return;
        L23:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            tt5.a.d("PdfPrintAdapter", "write print artifact failed: ".concat(th.getClass().getSimpleName()));
            if (r100.f221147d.get() == false) goto L37;
        L40:
            r103.onWriteCancelled();
            return;
        L37:
            if (r102.isCanceled() == true) goto L40;
            r103.onWriteFailed(null);
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
        if (this.f221147d.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f221146c.shutdownNow();
        this.f221144a.a();
        this.f221145b.invoke();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.d("PdfPrintAdapter", "notify print adapter finished failed: ".concat(th.getClass().getSimpleName()));
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onFinish() {
        a();
    }

    public a(c r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "artifact");
        Intrinsics.checkNotNullParameter(r101, "onFinished");
        this.f221144a = r100;
        this.f221145b = r101;
        this.f221146c = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("PdfPrintDocumentAdapter"));
        this.f221147d = new AtomicBoolean(false);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onWrite(PageRange[] r100, ParcelFileDescriptor r101, CancellationSignal r102, PrintDocumentAdapter.WriteResultCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "pages");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r102, "cancellationSignal");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (this.f221147d.get() == false) goto L10;
        r103.onWriteFailed(null);
        return;
    L10:
        this.f221146c.execute(new b(this, r101, r102, r103));     // Catch: RejectedExecutionException -> L8
        return;
    L8:
        tt5.a.k("PdfPrintAdapter", "write rejected after print adapter finished");
        r103.onWriteFailed(null);
    }

    @Override // android.print.PrintDocumentAdapter
    public final void onLayout(PrintAttributes r100, PrintAttributes r101, CancellationSignal r102, PrintDocumentAdapter.LayoutResultCallback r103, Bundle r104) {
        Intrinsics.checkNotNullParameter(r102, "cancellationSignal");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (this.f221147d.get() == false) goto L5;
    L9:
        r103.onLayoutCancelled();
        return;
    L5:
        if (r102.isCanceled() == true) goto L9;
        r103.onLayoutFinished(new PrintDocumentInfo.Builder(this.f221144a.f221155b).setContentType(0).setPageCount(-1).build(), !Intrinsics.areEqual(r100, r101));
    }
}
