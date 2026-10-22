package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.ee.bear.sheet.exportimage.imagedataprocessor.ShareImageDataPlugin;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes23.dex */
public class c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f277206l = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GrsBaseInfo f277207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f277208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.e.a f277209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f277210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, Future<d>> f277211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<d> f277212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JSONArray f277213g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<String> f277214h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.huawei.hms.framework.network.grs.g.j.c f277215i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f277216j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f277217k;

    public c(com.huawei.hms.framework.network.grs.g.j.c r100, com.huawei.hms.framework.network.grs.e.a r101) {
        this.f277211e = new ConcurrentHashMap(16);
        this.f277212f = new CopyOnWriteArrayList();
        this.f277213g = new JSONArray();
        this.f277214h = new CopyOnWriteArrayList();
        this.f277216j = "";
        this.f277217k = 1;
        this.f277215i = r100;
        this.f277207a = r100.b();
        this.f277208b = r100.a();
        this.f277209c = r101;
        b();
        c();
    }

    private d a(ExecutorService r110, List<String> r111, String r112, com.huawei.hms.framework.network.grs.e.c r113) {
        d r114 = null;
        int r115 = 0;
    L4:
        if (r115 >= r111.size()) goto L35;
        String r100 = (String) ListProtector.get(r111, r115);
        if (TextUtils.isEmpty(r100) == true) goto L30;
        Future<d> r101 = r110.submit(new a(r100, r115, this, this.f277208b, r112, this.f277207a, r113).g());
        this.f277211e.put(r100, r101);
        boolean r102 = true;
        d r103 = r101.get(this.f277217k, TimeUnit.SECONDS);     // Catch: TimeoutException -> L36 InterruptedException -> L24 ExecutionException -> L26 CancellationException -> L37
        if (r103 != null) goto L40;
    L22:
        r114 = r103;
        goto L30
    L40:
        if (r103.o() == false) goto L13;
    L14:
        Logger.i(f277206l, "grs request return body is not null and is OK.");     // Catch: TimeoutException -> L16 InterruptedException -> L17 ExecutionException -> L19 CancellationException -> L21
        r114 = r103;
    L31:
        if (r102 == true) goto L32;
        r115 = r115 + 1;
        goto L4
    L32:
        Logger.v(f277206l, "needBreak is true so need break current circulation");
        goto L35
    L13:
        if (r103.m() == false) goto L22;
    L17:
        e = e;
        r114 = r103;
    L25:
        Logger.w(f277206l, "the current thread was interrupted while waiting", e);
    L21:
        r114 = r103;
    L19:
        e = e;
        r114 = r103;
    L27:
        Logger.w(f277206l, "the computation threw an ExecutionException", e);
    L16:
        r114 = r103;
        goto L23
    L24:
        e = e;
    L26:
        e = e;
    L28:
        Logger.i(f277206l, "{requestServer} the computation was cancelled");
    L23:
        Logger.w(f277206l, "the wait timed out");
    L30:
        r102 = false;
    L35:
        return b(r114);
    }

    private void a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append(r101);
        r102.append(r100);
        String r103 = this.f277207a.getGrsReqParamJoint(false, false, d(), this.f277208b);
        if (TextUtils.isEmpty(r103) == true) goto L5;
        r102.append("?");
        r102.append(r103);
    L5:
        this.f277214h.add(r102.toString());
    }

    private d b(d r100) {
        Iterator<Map.Entry<String, Future<d>>> r101 = this.f277211e.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L22;
        Map.Entry<String, Future<d>> r102 = r101.next();
        if (r100 != null) goto L8;
    L23:
    L12:
        r100 = r102.getValue().get(ShareImageDataPlugin.TRANSFER_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L13 InterruptedException -> L16 ExecutionException -> L18 CancellationException -> L21
    L16:
        e = e;
        String r103 = f277206l;
        String r104 = "{checkResponse} when check result, find InterruptedException, check others";
    L20:
        Logger.w(r103, r104, e);
    L21:
        Logger.i(f277206l, "{checkResponse} when check result, find CancellationException, check others");
    L18:
        e = e;
        r103 = f277206l;
        r104 = "{checkResponse} when check result, find ExecutionException, check others";
    L13:
        Logger.w(f277206l, "{checkResponse} when check result, find TimeoutException, cancel current request task");
        if (r102.getValue().isCancelled() == true) goto L4;
        r102.getValue().cancel(true);
        goto L4
    L8:
        if (r100.o() == true) goto L22;
        if (r100.m() == false) goto L23;
    L22:
        return r100;
    }

    private void b() {
        com.huawei.hms.framework.network.grs.g.j.d r100 = com.huawei.hms.framework.network.grs.g.i.a.a(this.f277208b);
        if (r100 != null) goto L6;
        Logger.w(f277206l, "g*s***_se****er_conf*** maybe has a big error");
        return;
    L6:
        a(r100);
        List<String> r101 = r100.a();
        if (r101 != null) goto L9;
    L26:
        Logger.v(f277206l, "maybe grs_base_url config with [],please check.");
        return;
    L9:
        if (r101.size() <= 0) goto L26;
        if (r101.size() > 10) goto L25;
        String r102 = r100.b();
        if (r101.size() <= 0) goto L22;
        Iterator<String> r103 = r101.iterator();
    L17:
        if (r103.hasNext() == false) goto L22;
        String r104 = r103.next();
        if (r104.startsWith("https://") == false) goto L20;
        a(r102, r104);
        goto L17
    L20:
        Logger.w(f277206l, "grs server just support https scheme url,please check.");
    L22:
        Logger.v(f277206l, "request to GRS server url is {%s}", new Object[]{this.f277214h});
        return;
    L25:
        throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
    }

    private void c() {
        String r100 = this.f277207a.getGrsParasKey(true, true, this.f277208b);
        this.f277216j = this.f277209c.a().a(r100 + "ETag", "");
    }

    private String d() {
        com.huawei.hms.framework.network.grs.f.b r100 = com.huawei.hms.framework.network.grs.f.b.a(this.f277208b.getPackageName());
        if (r100 == null) goto L5;
        com.huawei.hms.framework.network.grs.local.model.a r101 = r100.a();
    L6:
        if (r101 == null) goto L8;
        String r102 = r101.a();
        Logger.v(f277206l, "get appName from local assets is{%s}", new Object[]{r102});
        return r102;
    L8:
        return "";
    L5:
        r101 = null;
        goto L6
    }

    public d a(ExecutorService r100, String r101, com.huawei.hms.framework.network.grs.e.c r102) {
        if (this.f277214h.isEmpty() == false) goto L6;
        return null;
    L6:
        long r103 = SystemClock.elapsedRealtime();
        d r104 = a(r100, this.f277214h, r101, r102);
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        Logger.i(f277206l, "use 2.0 interface return http's code is：{%d}", new Object[]{Integer.valueOf(r105)});
        e.a(new ArrayList(this.f277212f), SystemClock.elapsedRealtime() - r103, this.f277213g, this.f277208b);
        this.f277212f.clear();
        return r104;
    L9:
        r105 = r104.b();
        goto L10
    }

    public String a() {
        return this.f277216j;
    }

    public synchronized void a(d r100) {
        monitor-enter(this);
        this.f277212f.add(r100);     // Catch: Throwable -> L38
        d r101 = this.f277210d;     // Catch: Throwable -> L38
        if (r101 == null) goto L13;
        if (r101.o() == false) goto L8;
    L9:
        Logger.v(f277206l, "grsResponseResult is ok");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L8:
        if (this.f277210d.m() == true) goto L9;
    L13:
        if (r100.n() == false) goto L18;
        Logger.i(f277206l, "GRS server open 503 limiting strategy.");     // Catch: Throwable -> L38
        com.huawei.hms.framework.network.grs.h.d.a(this.f277207a.getGrsParasKey(true, true, this.f277208b), new com.huawei.hms.framework.network.grs.h.d.a(r100.k(), SystemClock.elapsedRealtime()));     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L18:
        if (r100.m() == false) goto L21;
        Logger.i(f277206l, "GRS server open 304 Not Modified.");     // Catch: Throwable -> L38
    L21:
        if (r100.o() == false) goto L23;
    L27:
        this.f277210d = r100;     // Catch: Throwable -> L38
        this.f277209c.a(this.f277207a, r100, this.f277208b, this.f277215i);     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, Future<d>>> r102 = this.f277211e.entrySet().iterator();     // Catch: Throwable -> L38
    L29:
        if (r102.hasNext() == false) goto L36;
        Map.Entry<String, Future<d>> r103 = r102.next();     // Catch: Throwable -> L38
        if (r103.getKey().equals(r100.l()) == true) goto L29;
        if (r103.getValue().isCancelled() == true) goto L29;
        Logger.i(f277206l, "future cancel");     // Catch: Throwable -> L38
        r103.getValue().cancel(true);     // Catch: Throwable -> L38
        goto L29
    L36:
        monitor-exit(this);
        return;
    L23:
        if (r100.m() == true) goto L27;
        Logger.v(f277206l, "grsResponseResult has exception so need return");     // Catch: Throwable -> L38
        monitor-exit(this);
        return;
    L38:
        th = move-exception;
        throw th;
    }

    public void a(com.huawei.hms.framework.network.grs.g.j.d r100) {
    }
}
