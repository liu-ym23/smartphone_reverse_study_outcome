package com.ss.android.socialbase.downloader.network.throttle;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes38.dex */
public class ThrottleInputStream extends InputStream {
    public static final int DEFAULT_THROTTLE_SMOOTHNESS = 40;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    private final InputStream f449586in;
    private long overReadAndSleepTime;
    protected long periodStartTime;
    private long readBytesInPeriod;
    protected long throttleNetSpeed;
    protected volatile long throttlePeriod;
    private volatile long throttlePeriodBytes;
    protected int throttleSmoothness;

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        monitor-enter(this);
        this.f449586in.reset();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f449586in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f449586in.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f449586in.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.f449586in.read();
    }

    public ThrottleInputStream(InputStream r100) {
        this.throttleSmoothness = 40;
        this.f449586in = r100;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int r100) {
        monitor-enter(this);
        this.f449586in.mark(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setThrottleNetSpeed(long r100) {
        setThrottleNetSpeed(r100, 0);
    }

    @Override // java.io.InputStream
    public long skip(long r100) throws IOException {
        return this.f449586in.skip(r100);
    }

    public void setThrottleNetSpeed(long r100, int r101) {
        this.throttleNetSpeed = r100;
        if (r101 >= 1) goto L5;
    L7:
        this.throttlePeriod = 1000 / this.throttleSmoothness;
        this.throttlePeriodBytes = r100 / ((long) this.throttleSmoothness);
        return;
    L5:
        if (r101 > 100) goto L7;
        this.throttleSmoothness = r101;
        goto L7
    }

    @Override // java.io.InputStream
    public int read(byte[] r100, int r101, int r110) throws IOException {
        if (this.throttlePeriodBytes <= 0) goto L37;
        if (this.periodStartTime != 0) goto L7;
        this.periodStartTime = System.currentTimeMillis();
    L7:
        long r102 = this.throttlePeriodBytes - this.readBytesInPeriod;
        if (r102 > 0) goto L10;
    L12:
        int r103 = this.f449586in.read(r100, r101, r110);
        if (r103 == (-1)) goto L16;
        this.readBytesInPeriod += (long) r103;
    L16:
        if (this.readBytesInPeriod < this.throttlePeriodBytes) goto L35;
        long r104 = System.currentTimeMillis();
        long r105 = r104 - this.periodStartTime;
        this.periodStartTime = r104;
        long r106 = this.throttlePeriod - r105;
        if (r106 <= 0) goto L30;
        long r107 = this.overReadAndSleepTime;
        if (r106 <= r107) goto L29;
        long r108 = r106 - r107;
        this.overReadAndSleepTime = 0;
        if (r108 <= 0) goto L34;
        this.periodStartTime += r108;
        Thread.sleep(r108);     // Catch: InterruptedException -> L26
    L26:
        e = move-exception;
        throw new IOException(e);
    L34:
        this.readBytesInPeriod = 0;
        goto L35
    L29:
        this.overReadAndSleepTime = r107 - r106;
        goto L34
    L30:
        if (r106 >= 0) goto L34;
        long r109 = this.overReadAndSleepTime + (-r106);
        this.overReadAndSleepTime = r109;
        if (r109 <= 100) goto L34;
        this.overReadAndSleepTime = 100;
    L35:
        return r103;
    L10:
        if (r110 <= r102) goto L12;
        r110 = (int) r102;
        goto L12
    L37:
        return this.f449586in.read(r100, r101, r110);
    }

    public int superRead(byte[] r100, int r101, int r102) throws IOException {
        return super.read(r100, r101, r102);
    }
}
