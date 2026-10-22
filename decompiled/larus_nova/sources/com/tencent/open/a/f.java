package com.tencent.open.a;

import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes29.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f461695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private i f461696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f461697c;

    public static f a() {
        if (f461695a == null) goto L5;
    L14:
        f461695a.c();
        return f461695a;
    L5:
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f461695a != null) goto L9;
        f461695a = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void b() {
        String r100 = "AndroidSDK_" + Build.VERSION.SDK + "_" + com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()) + "_" + Build.VERSION.RELEASE;
        this.f461697c = new e(r100);     // Catch: Throwable -> L5 NoClassDefFoundError -> L7
    L10:
        if (this.f461697c != null) goto L15;
        this.f461697c = new b(r100);
        return;
    L15:
        return;
    L7:
        e = move-exception;
        SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch error", e);
    L5:
        th = move-exception;
        SLog.e("openSDK_LOG.OpenHttpService", "initClient okHttp catch throwable", th);
        goto L10
    }

    private void c() {
        i r100 = this.f461696b;
        if (r100 != null) goto L5;
        return;
    L5:
        int r101 = r100.a("Common_HttpConnectionTimeout");
        if (r101 != 0) goto L8;
        r101 = 15000;
    L8:
        int r102 = this.f461696b.a("Common_SocketConnectionTimeout");
        if (r102 != 0) goto L11;
        r102 = 30000;
    L11:
        a(r101, r102);
    }

    public f() {
        b();
    }

    public void a(i r100) {
        this.f461696b = r100;
        c();
    }

    public g a(String r100, Map<String, String> r101) throws IOException {
        if (r101 == null) goto L19;
        if (r101.isEmpty() == true) goto L19;
        StringBuilder r102 = new StringBuilder("");
        Iterator<String> r103 = r101.keySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        String r105 = r101.get(r104);
        if (r105 == null) goto L9;
        r102.append(URLEncoder.encode(r104, "UTF-8"));
        r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r102.append(URLEncoder.encode(r105, "UTF-8"));
        r102.append("&");
        goto L9
    L14:
        if (r102.length() <= 0) goto L17;
        r102.deleteCharAt(r102.length() - 1);
    L17:
        return a(r100, r102.toString());
    L19:
        return a(r100, "");
    }

    public g b(String r100, Map<String, String> r101) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "post data");
        return this.f461697c.a(r100, r101);
    }

    public g a(String r100, String r101) throws IOException {
        SLog.i("openSDK_LOG.OpenHttpService", "get.");
        return this.f461697c.a(r100, r101);
    }

    public void a(long r100, long r101) {
        a r102 = this.f461697c;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }

    public g a(String r100, Map<String, String> r101, Map<String, byte[]> r102) throws IOException {
        if (r102 == null) goto L9;
        if (r102.size() == 0) goto L9;
        return this.f461697c.a(r100, r101, r102);
    L9:
        return b(r100, r101);
    }
}
