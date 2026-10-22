package com.ss.ugc.live.sdk.msg.network;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HttpMethod f458298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f458299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f458300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f458301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f458302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f458303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f458304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f458305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f458306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public n f458307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public h f458308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f458309l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f458310a;

        public final f a() {
            f r100 = this.f458310a;
            if (r100.f458305h != null) goto L6;
            r100.f458305h = Collections.emptyMap();
        L6:
            return this.f458310a;
        }

        public a() {
            this.f458310a = new f();
        }

        public a query(Map<String, String> r100) {
            this.f458310a.f458301d = r100;
            return this;
        }
    }

    public final byte[] a() {
        int r100 = com.ss.ugc.live.sdk.msg.utils.c.f458473a;
        Intrinsics.checkNotNullParameter(this, "httpRequest");
        byte[] r101 = this.f458302e;
        if (r101 != null) goto L50;
        b r102 = this.f458303f;
        if (r102 != null) goto L48;
        Map<String, String> r103 = this.f458305h;
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L38;
        Map<String, String> r105 = this.f458305h;
        if (r105 == null) goto L38;
        if (r105.isEmpty() == true) goto L38;
        ByteArrayOutputStream r106 = new ByteArrayOutputStream();
        Iterator<String> r107 = r105.keySet().iterator();
    L23:
        if (r107.hasNext() == false) goto L49;
        String r108 = r107.next();
        String r109 = r105.get(r108);
        if (r108 == null) goto L23;
        if (r109 == null) goto L23;
        if (r106.size() <= 0) goto L39;
        r106.write(38);
    L39:
        String r110 = URLEncoder.encode(r108, "UTF-8");     // Catch: IOException -> L33
        String r111 = URLEncoder.encode(r109, "UTF-8");     // Catch: IOException -> L33
        r106.write(r110.getBytes("UTF-8"));     // Catch: IOException -> L33
        r106.write(61);     // Catch: IOException -> L33
        r106.write(r111.getBytes("UTF-8"));     // Catch: IOException -> L33
    L33:
        e = move-exception;
        throw new RuntimeException(e);
    L49:
        return r106.toByteArray();
    L38:
        return new byte[0];
    L11:
        if (r103.isEmpty() == true) goto L14;
        r104 = false;
        goto L15
    L48:
        return r102.encode();
    L50:
        return r101;
    }

    public f() {
        this.f458298a = HttpMethod.POST;
        this.f458309l = false;
    }
}
