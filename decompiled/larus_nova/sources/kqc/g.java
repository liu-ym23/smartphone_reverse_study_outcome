package kqc;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes41.dex */
public final class g extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f505697a;

    public final int getCount() {
        monitor-enter(this);
        long r100 = this.f505697a;     // Catch: Throwable -> L11
        monitor-exit(this);
        if (r100 > SieveCacheKt.NodeLinkMask) goto L10;
        return (int) r100;
    L10:
        throw new ArithmeticException("The byte count " + r100 + " is too large to be converted to an int");
    L11:
        th = move-exception;
        throw th;
    }

    public g(InputStream r100) {
        super(r100);
    }

    @Override // kqc.l, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
        long r101 = super.skip(r100);     // Catch: Throwable -> L6
        this.f505697a += r101;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
