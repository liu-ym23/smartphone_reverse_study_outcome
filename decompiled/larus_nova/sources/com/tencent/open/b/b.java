package com.tencent.open.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes31.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f461707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f461708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f461709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f461710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f461711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f461712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f461713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f461714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<Serializable> f461715i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<Serializable> f461716j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Executor f461717k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f461718l;

    public static synchronized b a() {
        monitor-enter(b.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f461707a != null) goto L7;
        f461707a = new b();     // Catch: Throwable -> L10
    L7:
        b r100 = f461707a;     // Catch: Throwable -> L10
        monitor-exit(b.class);
        return r100;
    }

    private void c() {
    L3:
        if (this.f461716j.isEmpty() == true) goto L5;
        c r100 = (c) ListProtector.remove(this.f461716j, 0);
        r100.f461721a.put("appid", this.f461708b);
        r100.f461721a.put("app_name", this.f461709c);
        r100.f461721a.put(Constants.PARAM_APP_VER, this.f461711e);
        r100.f461721a.put("pkg_name", this.f461712f);
        r100.f461721a.put("qq_install", this.f461713g);
        r100.f461721a.put(Constants.PARAM_QQ_VER, this.f461714h);
        r100.f461721a.put("openid", this.f461710d);
        r100.f461721a.put("time_appid_openid", r100.f461721a.get("time") + "_" + this.f461708b + "_" + this.f461710d);
        StringBuilder r101 = new StringBuilder("fixDirtyData--------------------------");
        r101.append(r100);
        SLog.i("AttaReporter", r101.toString());
        this.f461715i.add(r100);
        goto L3
    }

    private void d() {
        SLog.i("AttaReporter", "attaReportAtSubThread");
        if (this.f461718l == true) goto L8;
        List<Serializable> r100 = g.b("report_atta");
        this.f461718l = r100.isEmpty();
        this.f461715i.addAll(r100);
        Iterator<Serializable> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        SLog.i("AttaReporter", "attaReportAtSubThread from db = " + r101.next());
    L8:
        ArrayList r102 = new ArrayList();
    L10:
        if (this.f461715i.isEmpty() == true) goto L15;
        c r103 = (c) ListProtector.remove(this.f461715i, 0);
        if (b(r103) == true) goto L10;
        r102.add(r103);
        goto L10
    L15:
        if (r102.isEmpty() == true) goto L22;
        SLog.i("AttaReporter", "attaReportAtSubThread fail size=" + r102.size());
        Iterator r104 = r102.iterator();
    L18:
        if (r104.hasNext() == false) goto L20;
        SLog.i("AttaReporter", "attaReportAtSubThread fail cache to db, " + ((c) ((Serializable) r104.next())));
        goto L18
    L20:
        g.a("report_atta", r102);
        this.f461718l = false;
        return;
    L22:
        if (this.f461718l == true) goto L33;
        SLog.i("AttaReporter", "attaReportAtSubThread clear db");
        g.a("report_atta");
        this.f461718l = true;
        return;
    }

    private b() {
        this.f461708b = "";
        this.f461709c = "";
        this.f461710d = "";
        this.f461711e = "";
        this.f461712f = "";
        this.f461713g = "";
        this.f461714h = "";
        this.f461715i = Collections.synchronizedList(new ArrayList());
        this.f461716j = Collections.synchronizedList(new ArrayList());
        this.f461717k = l.b();
    }

    public static String b() {
        return a().f461708b;
    }

    private boolean b(c r100) {
        int r101 = 0;
    L3:
        r101 = r101 + 1;
        SLog.i("AttaReporter", "doAttaReportItem post " + r100);     // Catch: Exception -> L9
        if (com.tencent.open.a.f.a().b("https://h.trace.qq.com/kv", r100.f461721a).d() != 200) goto L18;
        return true;
    L18:
        return false;
    L9:
        e = move-exception;
        SLog.i("AttaReporter", "Exception", e);
        if (r101 < 2) goto L3;
        return false;
    }

    public void a(String r100) {
        SLog.i("AttaReporter", "updateOpenId");
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this.f461710d = r100;
    }

    private void a(final c r100) {
        this.f461717k.execute(new AnonymousClass1(this, r100));
    }

    public static /* synthetic */ void b(b r100) {
        r100.d();
    }

    public static /* synthetic */ List a(b r100) {
        return r100.f461715i;
    }

    public void a(String r100, Context r101) {
        SLog.i("AttaReporter", "init");
        this.f461708b = r100;
        this.f461709c = k.a(r101);
        this.f461711e = m.d(r101, com.tencent.open.utils.g.b());
        this.f461712f = com.tencent.open.utils.g.b();
        if (k.b(r101) == false) goto L5;
        String r102 = "1";
    L6:
        this.f461713g = r102;
        this.f461714h = m.c(r101, "com.tencent.mobileqq");
        c();
        g.a();
        return;
    L5:
        r102 = "0";
        goto L6
    }

    public void a(String r100, Object r101) {
        a(r100, "", r101, null);
    }

    public void a(String r100, String r101) {
        a(r100, r101, null);
    }

    public void a(String r100, String r101, Map<String, Object> r102) {
        a(r100, r101, "", r102);
    }

    private c b(String r100, String r101, Object r102, Map<String, Object> r110) {
        long r103 = System.currentTimeMillis();
        HashMap r104 = new HashMap();
        r104.put("attaid", "09400051119");
        r104.put("token", "9389887874");
        r104.put("time_appid_openid", r103 + "_" + this.f461708b + "_" + this.f461710d);
        r104.put("time", String.valueOf(r103));
        r104.put("openid", this.f461710d);
        r104.put("appid", this.f461708b);
        r104.put("app_name", this.f461709c);
        r104.put(Constants.PARAM_APP_VER, this.f461711e);
        r104.put("pkg_name", this.f461712f);
        r104.put("os", "AND");
        r104.put("os_ver", Build.VERSION.RELEASE);
        r104.put("sdk_ver", Constants.SDK_VERSION);
        r104.put("model_name", com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
        r104.put("interface_name", r100);
        r104.put("interface_data", r101);
        String r105 = "";
        if (r102 != null) goto L5;
        String r106 = "";
    L6:
        r104.put("interface_result", r106);
        r104.put("qq_install", this.f461713g);
        r104.put(Constants.PARAM_QQ_VER, this.f461714h);
        if (r110 == null) goto L28;
        if (r110.isEmpty() == true) goto L28;
        Object r107 = r110.get("reserve1");
        if (r107 != null) goto L13;
        String r108 = "";
    L14:
        r104.put("reserve1", r108);
        Object r109 = r110.get("reserve2");
        if (r109 != null) goto L17;
        String r111 = "";
    L18:
        r104.put("reserve2", r111);
        Object r112 = r110.get("reserve3");
        if (r112 != null) goto L21;
        String r113 = "";
    L22:
        r104.put("reserve3", r113);
        Object r114 = r110.get("reserve4");
        if (r114 == null) goto L26;
        r105 = r114.toString();
    L26:
        r104.put("reserve4", r105);
        goto L28
    L21:
        r113 = r112.toString();
        goto L22
    L17:
        r111 = r109.toString();
        goto L18
    L13:
        r108 = r107.toString();
    L28:
        return new c(r104);
    L5:
        r106 = r102.toString();
        goto L6
    }

    public void a(String r100, String r101, Object r102, Map<String, Object> r103) {
        c r104 = b(r100, r101, r102, r103);
        if (TextUtils.isEmpty(this.f461708b) == false) goto L5;
    L11:
        SLog.i("AttaReporter", "attaReport cancel appid=" + this.f461708b + ", mAppName=" + this.f461709c + ", context=" + com.tencent.open.utils.g.a() + ", " + r104);
        this.f461716j.add(r104);
        return;
    L5:
        if (TextUtils.isEmpty(this.f461709c) == true) goto L11;
        if (com.tencent.open.utils.g.a() == null) goto L11;
        a(r104);
    }
}
