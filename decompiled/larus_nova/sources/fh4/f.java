package fh4;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i0;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.m0;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.m;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.p;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f477011e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f477012f = 30;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f477013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f477014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CopyOnWriteArrayList<f> f477015i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashSet<String> f477016j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f477017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<g> f477018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue<g> f477019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.crash.monitor.f f477020d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f477021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f477022b;

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f477022b.c(this.f477021a) == false) goto L5;
            this.f477022b.f477019c.add(this.f477021a);     // Catch: Throwable -> L9
        L5:
            f r100 = this.f477022b;     // Catch: Throwable -> L9
            r100.a();     // Catch: Throwable -> L9
            if (r100.f477019c.size() < f.f477012f) goto L12;
            r100.h();     // Catch: Throwable -> L9
            return;
        }

        public a(f r100, g r101) {
            this.f477022b = r100;
            this.f477021a = r101;
        }
    }

    static {
        f477015i = new CopyOnWriteArrayList();
        f477016j = new HashSet();
    }

    public final void a() {
    L3:
        if (this.f477018b.isEmpty() == true) goto L7;
        g r100 = this.f477018b.poll();
        if (c(r100) == false) goto L3;
        this.f477019c.add(r100);
        goto L3
    }

    public final void b() {
        StringBuilder r100 = new StringBuilder("run:");
        com.bytedance.crash.i.getContext();
        r100.append(com.bytedance.crash.util.b.a());
        r100.append(" ");
        r100.append(this.f477020d.a());
        p.b(r100.toString());
        a();
        h();
        wh4.b.postDelayed(this, 30000);
    }

    public final void h() {
        if (this.f477019c.isEmpty() == false) goto L28;
        return;
    L28:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L27
        JSONArray r101 = new JSONArray();     // Catch: Exception -> L27
        int r102 = 0;
        if (m0.f203237s == true) goto L16;
        m0 r103 = this.f477020d.f203291c;     // Catch: Exception -> L27
        r103.getClass();     // Catch: Exception -> L27
        Map<String, String> r104 = i0.f203227a;     // Catch: Exception -> L27
        if (NativeBridge.H() == true) goto L10;
    L12:
        Map<String, String> r105 = r103.f203238a;     // Catch: Exception -> L27
    L13:
        Map<String, String> r106 = i0.f203227a;     // Catch: Exception -> L27
        if (r106 == null) goto L18;
        HashMap r107 = new HashMap();     // Catch: Exception -> L27
        r107.putAll(r105);     // Catch: Exception -> L27
        r107.putAll(r106);     // Catch: Exception -> L27
        r105 = r107;
    L18:
        if (this.f477019c.isEmpty() == true) goto L22;
        if (r102 > f477012f) goto L22;
        g r108 = this.f477019c.poll();     // Catch: Exception -> L27
        p.e("upload:message:" + r108.f477026c + " log_type:" + r108.f477029f);     // Catch: Exception -> L27
        r101.put(r108.f(this.f477020d, r105));     // Catch: Exception -> L27
        r102 = r102 + 1;     // Catch: Exception -> L27
    L22:
        r100.put("data", r101);     // Catch: Exception -> L27
        int r109 = Process.myPid();     // Catch: Exception -> L27
        JSONObject r110 = Header.b(this.f477020d, System.currentTimeMillis(), CrashType.ENSURE, r109).f203195a;     // Catch: Exception -> L27
        r100.put("header", r110);     // Catch: Exception -> L27
        if (f477014h == false) goto L25;
        return;
    L25:
        String r111 = n.d(zg4.g.f572072l.f572076d, r110);     // Catch: Exception -> L27
        p.e("isSuccess:" + CrashUploader.h(r111, r100) + "  upload:" + r111);     // Catch: Exception -> L27
        m.b().d();     // Catch: Exception -> L27
        return;
    L10:
        if (r103.f203254q == false) goto L12;
        r105 = NativeBridge.z();     // Catch: Exception -> L27
        goto L13
    L16:
        r105 = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public f(com.bytedance.crash.monitor.f r100) {
        this.f477019c = new ConcurrentLinkedQueue();
        this.f477018b = new ConcurrentLinkedQueue();
        this.f477020d = r100;
        f477015i.add(this);
    }

    public final boolean c(g r110) {
        if (this.f477017a != null) goto L6;
        p.e("isCanReport:config = null and event type" + r110.f477029f);
        return false;
    L6:
        String r100 = r110.f477029f;
        boolean r101 = true;
        if (f477013g == false) goto L9;
        boolean r102 = !f477016j.contains(r100);
    L11:
        if (r102 == false) goto L15;
        p.e("the log_type = " + r110.f477029f + " and message = " + r110.f477026c + "is discard because the stop upload");
        return false;
    L15:
        if (this.f477017a.b(r110.f477029f, r110.f477026c) == true) goto L28;
        StringBuilder r103 = new StringBuilder("the log_type = ");
        r103.append(r110.f477029f);
        r103.append(" and message = ");
        r103.append(r110.f477026c);
        r103.append("is discard because the config");
        r103.append(this.f477017a.a(r110.f477029f));
        r103.append(" ");
        d r104 = this.f477017a;
        String r111 = r110.f477026c;
        if (r104.f477009d == true) goto L25;
        JSONObject r105 = r104.f477008c;
        if (r105 == null) goto L25;
        if (Math.random() <= r105.optDouble(r111, 1.0d)) goto L25;
        r101 = false;
    L25:
        r103.append(r101);
        p.e(r103.toString());
        return false;
    L28:
        if (TextUtils.isEmpty(r110.f477026c) == false) goto L30;
        String r106 = null;
    L31:
        String r107 = r110.d();
        m r108 = m.b();
        boolean r109 = r108.a(r107, m.f203395f);
        if (r106 == null) goto L34;
        boolean r112 = r108.a(r106, m.f203396g);
    L35:
        boolean r113 = r108.a("ensure_all", m.f203394e);
        p.e("checkEnsureLimit:" + r107 + " " + m.f203395f + ContainerUtils.KEY_VALUE_DELIMITER + r109 + " " + r106 + " " + m.f203396g + ContainerUtils.KEY_VALUE_DELIMITER + r112 + " totalExceed=" + r113);
        if (r109 == true) goto L41;
        if (r112 == true) goto L41;
        if (r113 == true) goto L41;
        boolean r114 = false;
    L42:
        if (r114 == true) goto L44;
    L46:
        p.e("the message " + r110.f477026c + "  is exceed limit:" + r114);
        if (r114 == true) goto L55;
        m r115 = m.b();
        if (r107 == null) goto L51;
        r115.c(r107);
    L51:
        if (r106 == null) goto L53;
        r115.c(r106);
    L53:
        r115.c("ensure_all");
        return true;
    L55:
        return false;
    L44:
        if (m.f203393d == true) goto L46;
        m.f203393d = true;
    L41:
        r114 = true;
        goto L42
    L34:
        r112 = false;
        goto L35
    L30:
        r106 = com.bytedance.crash.util.d.a(r110.f477026c);
        goto L31
    L9:
        r102 = false;
        goto L11
    }

    public final void f(g r100) {
        if (this.f477017a == null) goto L5;
        wh4.b.post(new a(this, r100));
        return;
    L5:
        if (this.f477018b.size() < f477011e) goto L7;
        return;
    L7:
        p.c("cache:" + r100);
        this.f477018b.add(r100);
    }

    public final boolean d(String r100, String r110) {
        if (f477013g == false) goto L5;
        boolean r101 = !f477016j.contains(r100);
    L6:
        if (r101 == false) goto L10;
        p.e("isStopUpload：the logType = " + r100 + " message:" + r110);
        return true;
    L10:
        if (this.f477017a != null) goto L16;
        if (this.f477018b.size() < f477011e) goto L16;
        p.e("the logType = " + r100 + "is discarded the cache exceed 100");
        return true;
    L16:
        if (f477012f > 0) goto L19;
        return true;
    L19:
        if (m.f203398i == false) goto L25;
        if (m.b().a("ensure_all", m.f203394e) == false) goto L25;
        p.e("the logType = " + r100 + "is discarded beacuse the report is exceed 100");
        return true;
    L25:
        if (this.f477017a != null) goto L31;
        if (this.f477018b.size() < f477011e) goto L31;
        p.e("the logType = " + r100 + "is discarded the cache exceed 100");
        return true;
    L31:
        if (this.f477017a != null) goto L33;
        return false;
    L33:
        p.e("the logType = " + r100 + "message = " + r110 + " isSample = " + this.f477017a.b(r100, r110));
        return !this.f477017a.b(r100, r110);
    L5:
        r101 = false;
        goto L6
    }

    public final void e(String r110, int r111) {
        if (d("core_exception_monitor", r110) == false) goto L6;
        p.e("reportMessage：isDrop:" + r110);
        return;
    L6:
        Thread r100 = ThreadMethodProxy.currentThread();
        f(new g(null, r100.getStackTrace(), r111, r110, null, r100.getName(), "core_exception_monitor"));
    }

    public final void g(String r100, Map<String, String> r110, Throwable r111, String r112) {
        String r101 = ThreadMethodProxy.currentThread().getName();
        if (TextUtils.isEmpty(r112) == false) goto L5;
        r112 = "core_exception_monitor";
    L5:
        String r102 = r112;
        p.b("reportJavaEnsure:message:" + r100 + " " + com.bytedance.crash.util.b.c());
        if (d(r102, r100) == false) goto L8;
        p.e("reportJavaEnsure：isDrop:" + r102 + " " + r100);
        return;
    L8:
        f(new g(r111, null, 0, r100, r110, r101, r102));
    }
}
