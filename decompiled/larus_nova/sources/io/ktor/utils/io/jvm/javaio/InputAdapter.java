package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import java.io.InputStream;
import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes41.dex */
public final class InputAdapter extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteReadChannel f492115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableJob f492116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InputAdapter$loop$1 f492117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f492118d;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        monitor-enter(this);
        super.close();     // Catch: Throwable -> L9
        ByteReadChannel r100 = this.f492115a;     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r100, "<this>");     // Catch: Throwable -> L9
        r100.cancel(null);     // Catch: Throwable -> L9
        if (this.f492116b.isCompleted() == true) goto L6;
        Job.DefaultImpls.cancel$default(this.f492116b, null, 1, null);     // Catch: Throwable -> L9
    L6:
        this.f492117c.c();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f492115a.w();
    }

    @Override // java.io.InputStream
    public final synchronized int read() {
        monitor-enter(this);
        byte[] r100 = this.f492118d;     // Catch: Throwable -> L19
        if (r100 != null) goto L7;
        r100 = new byte[1];     // Catch: Throwable -> L19
        this.f492118d = r100;     // Catch: Throwable -> L19
    L7:
        int r101 = this.f492117c.e(r100, 0, 1);     // Catch: Throwable -> L19
        if (r101 != (-1)) goto L12;
        monitor-exit(this);
        return -1;
    L12:
        if (r101 != 1) goto L18;
        int r102 = r100[0] & UByte.MAX_VALUE;
        monitor-exit(this);
        return r102;
    L18:
        throw new IllegalStateException(("Expected a single byte or EOF. Got " + r101 + " bytes.").toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public InputAdapter(Job r100, ByteReadChannel r101) {
        Intrinsics.checkNotNullParameter(r101, "channel");
        this.f492115a = r101;
        this.f492116b = JobKt.Job(r100);
        this.f492117c = new InputAdapter$loop$1(r100, this);
    }

    @Override // java.io.InputStream
    public final synchronized int read(byte[] r100, int r101, int r102) {
        monitor-enter(this);
        InputAdapter$loop$1 r103 = this.f492117c;     // Catch: Throwable -> L6
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L6
        int r104 = r103.e(r100, r101, r102);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r104;
    L6:
        th = move-exception;
        throw th;
    }
}
