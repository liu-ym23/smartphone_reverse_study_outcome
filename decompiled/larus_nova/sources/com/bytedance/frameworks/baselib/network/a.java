package com.bytedance.frameworks.baselib.network;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.SsCall;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends lx5.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseHttpRequestInfo f244634c;

    @Override // lx5.c, java.io.InputStream
    public final int read() throws IOException {
        RetrofitMetrics r100 = this.f244634c.metrics;
        if (r100 == null) goto L15;
        r100.readResponseBodyStart();
    L15:
        int r101 = super.read();     // Catch: Throwable -> L10
        RetrofitMetrics r102 = this.f244634c.metrics;
        if (r102 == null) goto L9;
        r102.readResponseBodyEnd();
    L9:
        return r101;
    L10:
        th = move-exception;
        if (this.f244634c.metrics == null) goto L14;
        this.f244634c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }

    @Override // lx5.c, java.io.InputStream
    public final int read(byte[] r100) throws IOException {
        RetrofitMetrics r101 = this.f244634c.metrics;
        if (r101 == null) goto L15;
        r101.readResponseBodyStart();
    L15:
        int r102 = super.read(r100);     // Catch: Throwable -> L10
        RetrofitMetrics r103 = this.f244634c.metrics;
        if (r103 == null) goto L9;
        r103.readResponseBodyEnd();
    L9:
        return r102;
    L10:
        th = move-exception;
        if (this.f244634c.metrics == null) goto L14;
        this.f244634c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }

    public a(InputStream r100, SsCall r101, BaseHttpRequestInfo r102) {
        super(r100, r101);
        this.f244634c = r102;
    }

    @Override // lx5.c, java.io.InputStream
    public final int read(byte[] r100, int r101, int r102) throws IOException {
        RetrofitMetrics r103 = this.f244634c.metrics;
        if (r103 == null) goto L15;
        r103.readResponseBodyStart();
    L15:
        int r104 = super.read(r100, r101, r102);     // Catch: Throwable -> L10
        RetrofitMetrics r105 = this.f244634c.metrics;
        if (r105 == null) goto L9;
        r105.readResponseBodyEnd();
    L9:
        return r104;
    L10:
        th = move-exception;
        if (this.f244634c.metrics == null) goto L14;
        this.f244634c.metrics.readResponseBodyEnd();
    L14:
        throw th;
    }
}
