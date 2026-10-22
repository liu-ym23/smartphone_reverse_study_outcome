package com.ss.android.lark.monitor;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;

/* JADX INFO: loaded from: classes36.dex */
public final class x extends ForwardingSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OkHttpMonitorInterceptor.c f432537a;

    @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        super.close();
        OkHttpMonitorInterceptor.c r100 = this.f432537a;
        OkHttpMonitorInterceptor.b r101 = r100.f432335d;
        if (r101 == null) goto L8;
        long r102 = r100.f432334c;
        OkHttpMonitorInterceptor.a r103 = (OkHttpMonitorInterceptor.a) r101;
        LarkMetrics r104 = LarkMetrics.a.f432318a;
        String r105 = r103.f432330a;
        long r106 = r103.f432331b;
        com.ss.android.lark.monitor.traffic.j r107 = r104.f432312f;
        if (r107 == null) goto L9;
        r107.b(r105, r102, r106);
        return;
    L9:
        return;
    }

    public x(OkHttpMonitorInterceptor.c r100, BufferedSource r101) {
        this.f432537a = r100;
        super(r101);
    }

    @Override // okio.ForwardingSource, okio.Source
    public final long read(Buffer r100, long r101) throws IOException {
        long r102 = super.read(r100, r101);
        if (r102 <= 0) goto L5;
        this.f432537a.f432334c += r102;
    L5:
        return r102;
    }
}
