package com.larus.xbridge.custom;

import android.util.Base64;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class g2 implements te7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestMethod f379758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.network.a.b f379759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IBDXBridgeContext f379760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> f379761d;

    @Override // te7.b
    public final void a(te7.i r110) {
        final String r100 = r110.c();
        boolean r101 = true;
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        BufferedInputStream r103 = null;
        ByteArrayOutputStream r104 = null;
        r104 = null;
        r104 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L22;
        Throwable r105 = r110.d();
        if (r105 == null) goto L21;
        r100 = r105.getMessage();
        if (r100 == null) goto L21;
        if (r100.length() > 0) goto L19;
        r101 = false;
    L19:
        if (r101 == true) goto L22;
    L21:
        r100 = null;
    L22:
        InputStream r106 = r110.e();
        final int r107 = r110.f545613b.element;
        final Integer r111 = r110.b();
        if (r106 != null) goto L26;
        int r112 = RequestMethod.f379681e;
        RequestMethod r113 = this.f379758a;
        this.f379759b.getUrl();
        RequestMethod.a(r113);
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r114 = this.f379761d;
        com.larus.utils.t0.c(new d2(r114, r100, r107, r111));
        return;
    L26:
        final LinkedHashMap<String, String> r108 = r110.f545612a;
        BufferedInputStream r109 = new BufferedInputStream(r106);     // Catch: Throwable -> L43 Exception -> L45
        ByteArrayOutputStream r115 = new ByteArrayOutputStream();     // Catch: Exception -> L41 Throwable -> L57
        byte[] r116 = new byte[4096];     // Catch: Throwable -> L37 Exception -> L39
    L31:
        int r117 = r109.read(r116);     // Catch: Throwable -> L37 Exception -> L39
        if (r117 == (-1)) goto L34;
        r115.write(r116, 0, r117);     // Catch: Throwable -> L37 Exception -> L39
        goto L31
    L34:
        final String r118 = Base64.encodeToString(r115.toByteArray(), 2);     // Catch: Throwable -> L37 Exception -> L39
        RequestMethod r119 = this.f379758a;     // Catch: Throwable -> L37 Exception -> L39
        this.f379759b.getUrl();     // Catch: Throwable -> L37 Exception -> L39
        RequestMethod.a(r119);     // Catch: Throwable -> L37 Exception -> L39
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r120 = this.f379761d;     // Catch: Throwable -> L37 Exception -> L39
        com.larus.utils.t0.c(new e2(r120, r108, r118, r107, r111));     // Catch: Throwable -> L37 Exception -> L39
        r110.a();     // Catch: IOException -> L54
        r109.close();     // Catch: IOException -> L54
        r115.close();     // Catch: IOException -> L54
        return;
    L39:
        final Exception e100 = e;
        r104 = r115;
    L47:
        RequestMethod r121 = this.f379758a;     // Catch: Throwable -> L57
        this.f379759b.getUrl();     // Catch: Throwable -> L57
        RequestMethod.a(r121);     // Catch: Throwable -> L57
        final CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r122 = this.f379761d;     // Catch: Throwable -> L57
        com.larus.utils.t0.c(new f2(r122, e100, r107, r111));     // Catch: Throwable -> L57
        r110.a();     // Catch: IOException -> L54
        if (r109 == null) goto L51;
        r109.close();     // Catch: IOException -> L54
    L51:
        if (r104 == null) goto L79;
        r104.close();     // Catch: IOException -> L54
        return;
    L79:
        return;
    L37:
        Throwable th10 = th;
        r104 = r115;
    L59:
        ByteArrayOutputStream r123 = r104;
        r103 = r109;
        ByteArrayOutputStream r124 = r123;
    L72:
        r110.a();     // Catch: IOException -> L66
        if (r103 == null) goto L63;
        r103.close();     // Catch: IOException -> L66
    L63:
        if (r124 == null) goto L82;
        r124.close();     // Catch: IOException -> L66
        throw th10;
    L82:
        throw th10;
    L66:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L41:
        e = move-exception;
        e100 = e;
    L57:
        th = move-exception;
        th10 = th;
        goto L59
    L54:
        e = move-exception;
        e.printStackTrace();
        return;
    L45:
        e = move-exception;
        e100 = e;
        r109 = null;
    L43:
        th = move-exception;
        th10 = th;
        r124 = null;
        goto L72
    L5:
        r102 = false;
        goto L6
    }

    public g2(RequestMethod r100, com.bytedance.sdk.xbridge.cn.network.a.b r101, IBDXBridgeContext r102, long r103, CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> r104) {
        this.f379758a = r100;
        this.f379759b = r101;
        this.f379760c = r102;
        this.f379761d = r104;
    }
}
