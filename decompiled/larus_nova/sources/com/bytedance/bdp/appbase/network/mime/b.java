package com.bytedance.bdp.appbase.network.mime;

import gb4.e;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f200904a;

    @Override // gb4.e
    public final String a() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // gb4.e
    public final long b() {
        return this.f200904a.size();
    }

    public b() {
        this.f200904a = new ByteArrayOutputStream();
    }

    @Override // gb4.e
    public final void c(OutputStream r100) throws IOException {
        r100.write(this.f200904a.toByteArray());
    }

    public final void d(Map<String, String> r100) {
        Iterator<T> r101 = r100.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Map.Entry r102 = (Map.Entry) r101.next();
        String r103 = (String) r102.getKey();
        String r104 = (String) r102.getValue();
        if (this.f200904a.size() <= 0) goto L15;
        this.f200904a.write(38);
    L15:
        String r105 = URLEncoder.encode(r103, "UTF-8");     // Catch: IOException -> L11
        String r106 = URLEncoder.encode(r104, "UTF-8");     // Catch: IOException -> L11
        this.f200904a.write(r105.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L11
        this.f200904a.write(61);     // Catch: IOException -> L11
        this.f200904a.write(r106.getBytes(Charset.forName("UTF-8")));     // Catch: IOException -> L11
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
