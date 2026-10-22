package com.bytedance.forest.utils.io;

import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes19.dex */
public class b extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f244562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f244563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f244564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicInteger f244565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l f244566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Response f244567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f244568g;

    @Override // java.io.InputStream
    public final int read() {
        return read(new byte[1], 0, 1);
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.f244563b.get() == true) goto L13;
    L9:
        th = move-exception;
        a(th, "available");
        throw th;
    L5:
        if (this.f244566e.isCacheProvided$forest_release() == false) goto L8;
        return this.f244566e.size() - this.f244564c;
    L8:
        return this.f244566e.size();
    L13:
        throw new IOException("InputStream has been closed!");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f244563b.set(true);
        this.f244566e.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(th, "close");
        throw th;
    }

    @Override // java.io.InputStream
    public final long skip(long r100) {
        return super.skip(r100);
    }

    public b(l r100, Response r101) {
        this.f244566e = r100;
        this.f244567f = r101;
        this.f244568g = 1024;
        this.f244562a = new AtomicBoolean(false);
        this.f244563b = new AtomicBoolean(false);
        this.f244565d = new AtomicInteger(-1);
    }

    public final void a(Throwable r110, String r111) {
        com.bytedance.forest.utils.c.a(this.f244566e.getContext$forest_release().f244543g, 6, "Streaming", "error happens when executing ".concat(r111), true, r110, null, 32);
        if (this.f244566e.isCacheClear$forest_release() == false) goto L6;
        this.f244567f.f244315q.getForest().getMemoryManager$forest_release().d(this.f244567f.f244315q.getCacheKey$forest_release());
        return;
    }

    @Override // java.io.InputStream
    public final int read(byte[] r210, int r211, int r212) {
        if (this.f244563b.get() == true) goto L30;
        if (this.f244562a.get() == false) goto L7;
        return -1;
    L7:
        int r100 = this.f244565d.incrementAndGet();
        if (r210 == null) goto L28;
        int r101 = hashCode();
        int r102 = Math.min(r210.length - r211, r212);
        if (r102 != 0) goto L12;
        return 0;
    L12:
        int r103 = this.f244566e.size();
        int r110 = this.f244564c;
        if (r102 > (r103 - r110)) goto L15;
        int r104 = this.f244566e.getBytesAtRange$forest_release(r110, r210, r211, r102, this.f244567f);
    L23:
        if (r104 != (-1)) goto L25;
        com.bytedance.forest.utils.c.a(this.f244566e.getContext$forest_release().f244543g, 4, "Streaming", "[" + r100 + '-' + r101 + "] read finished， cursor:" + this.f244564c, false, null, null, 56);
        this.f244562a.set(true);
        this.f244564c = this.f244566e.size();
    L26:
        return r104;
    L25:
        this.f244564c += r104;
        goto L26
    L15:
        int r105 = this.f244568g;
        int r106 = r102 / r105;
        if ((r102 % r105) == 0) goto L18;
        int r111 = 1;
    L19:
        int r112 = (r106 + r111) * r105;
        byte[] r107 = new byte[r112];
        int r108 = this.f244566e.getBytesAtRange$forest_release(r110, r107, 0, r112, this.f244567f);
        if (r108 <= 0) goto L22;
        int r109 = Math.min(r108, r102);
        System.arraycopy(r107, 0, r210, r211, r109);
        r104 = r109;
        goto L23
    L22:
        r104 = r108;
        goto L23
    L18:
        r111 = 0;
        goto L19
    L28:
        throw new NullPointerException("Input ByteArray is NULL!");
    L30:
        throw new IOException("InputStream has been closed!");
    }
}
