package com.bytedance.frameworks.baselib.netx.chunk;

import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f244816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f244817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TypedInput f244818c;

    public d(TypedInput r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f244818c = r100;
        this.f244816a = true;
        this.f244817b = new LinkedHashMap();
    }

    public final void a(zn0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        if (this.f244816a == true) goto L35;
        a r101 = new a(this.f244818c.in());
        this.f244818c.mimeType();
        r101.a();     // Catch: IOException -> L7
    L10:
        if (r101.f244815l == 0) goto L12;
        r100.c(new IllegalStateException("ChunkedInputStream already been observed!"));
        return;
    L12:
        r101.f244815l = 1;
        System.currentTimeMillis();
        int r102 = r101.e();     // Catch: Throwable -> L23
        if (r102 >= 0) goto L21;
        r100.a();     // Catch: Throwable -> L23
        InputStream r103 = r101.f244804a;     // Catch: Throwable -> L19
    L17:
        StreamParser.safeClose(r103);     // Catch: Throwable -> L19
        return;
    L21:
        byte[] r104 = new byte[r102];     // Catch: Throwable -> L23
        System.arraycopy(r101.f244807d, r101.f244808e, r104, 0, r102);     // Catch: Throwable -> L23
        System.currentTimeMillis();     // Catch: Throwable -> L23
        NetXChunkInject.f244801a.getClass();     // Catch: Throwable -> L23
        NetXChunkInject r105 = (NetXChunkInject) NetXChunkInject.Companion.f244802a.getValue();     // Catch: Throwable -> L23
        new ByteArrayInputStream(r104);     // Catch: Throwable -> L23
        r100.d(r105.a());     // Catch: Throwable -> L23
        throw null;     // Catch: Throwable -> L23
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L23:
        th = move-exception;
        r100.c(th);     // Catch: Throwable -> L29
        r103 = r101.f244804a;     // Catch: Throwable -> L19
    L29:
        th = move-exception;
        StreamParser.safeClose(r101.f244804a);     // Catch: Throwable -> L32
    L34:
        throw th;
    L32:
        th = move-exception;
        th.printStackTrace();
    L7:
        e = move-exception;
        r100.c(e);
        goto L10
    L35:
        NetXChunkInject.f244801a.getClass();
        NetXChunkInject r106 = (NetXChunkInject) NetXChunkInject.Companion.f244802a.getValue();
        this.f244818c.in();
        this.f244818c.mimeType();
        r100.b(r106.a());
        throw null;
    }
}
