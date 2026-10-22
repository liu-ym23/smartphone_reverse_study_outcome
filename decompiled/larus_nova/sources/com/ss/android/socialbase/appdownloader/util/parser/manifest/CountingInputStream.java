package com.ss.android.socialbase.appdownloader.util.parser.manifest;

import androidx.collection.SieveCacheKt;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class CountingInputStream extends ProxyInputStream {
    private long count;

    public synchronized long getByteCount() {
        monitor-enter(this);
        long r100 = this.count;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized long resetByteCount() {
        monitor-enter(this);
        long r100 = this.count;     // Catch: Throwable -> L6
        this.count = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public int getCount() {
        long r100 = getByteCount();
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        return (int) r100;
    L7:
        throw new ArithmeticException("The byte count " + r100 + " is too large to be converted to an int");
    }

    public int resetCount() {
        long r100 = resetByteCount();
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        return (int) r100;
    L7:
        throw new ArithmeticException("The byte count " + r100 + " is too large to be converted to an int");
    }

    public CountingInputStream(InputStream r100) {
        super(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.ProxyInputStream
    public synchronized void afterRead(int r100) {
        monitor-enter(this);
        if (r100 != (-1)) goto L12;
    L10:
        monitor-exit(this);
        return;
    L12:
        this.count += (long) r100;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.manifest.ProxyInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long r100) throws IOException {
        monitor-enter(this);
        long r101 = super.skip(r100);     // Catch: Throwable -> L6
        this.count += r101;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }
}
