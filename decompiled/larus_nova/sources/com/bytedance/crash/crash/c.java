package com.bytedance.crash.crash;

import android.content.Context;
import android.os.Process;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.entity.Header;
import com.bytedance.crash.i;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.h;
import com.bytedance.crash.util.k;
import com.bytedance.crash.util.p;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static c f203123d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PolarisFileWrapper f203124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f203125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f203126c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.crash.monitor.a f203127a;

        public final void a() {
            com.bytedance.crash.monitor.a r100 = this.f203127a;
            new qh4.a.C7329a(r100, uh4.b.f550093h.f550094a).k();     // Catch: Throwable -> L5
        L62:
            new rh4.a.b(r100, uh4.b.f550093h.f550095b).k();     // Catch: Throwable -> L9
        L72:
            new vh4.c.b(r100, uh4.b.f550093h.f550096c).k();     // Catch: Throwable -> L13
        L68:
            new ph4.a.b(r100, uh4.b.f550093h.f550097d).k();     // Catch: Throwable -> L17
        L66:
            new sh4.a.C7610a(r100, uh4.b.f550093h.f550098e).k();     // Catch: Throwable -> L21
        L23:
            PolarisFileWrapper r101 = new PolarisFileWrapper(i.d(), "protector");
            if (r101.exists() == false) goto L84;
            File[] r102 = r101.listFiles();
            if (r102 == null) goto L60;
            int r103 = r102.length;
            int r104 = 0;
        L29:
            if (r104 >= r103) goto L85;
            File r105 = r102[r104];
            long r110 = System.currentTimeMillis();
            p.e("upload " + r105.getAbsolutePath());     // Catch: Exception -> L61
            com.bytedance.crash.monitor.a r106 = j.f203315a;     // Catch: Exception -> L61
            if (r106 == null) goto L59;
            JSONObject r111 = Header.b(r106, r110, CrashType.NATIVE_CUSTOMIZE, Process.myPid()).f203195a;     // Catch: Exception -> L61
            CrashSummary r112 = CrashSummary.loadFromDirectory(r105);     // Catch: Exception -> L61
            if (r112 != null) goto L37;
            r105.getAbsolutePath();     // Catch: Exception -> L61
            boolean r107 = zg4.i.f572087c;     // Catch: Exception -> L61
            com.bytedance.crash.util.g.e(r105);     // Catch: Exception -> L61
            goto L59
        L37:
            JSONObject r113 = r112.assemblyCrashBody(r106).f472653a;     // Catch: Exception -> L61
            r113.put("event_type", "native_exception");     // Catch: Exception -> L61
            r113.put("message", "protector");     // Catch: Exception -> L61
            r113.put(FrescoMonitorConst.LOG_TYPE, "1");     // Catch: Exception -> L61
            r113.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L61
            r113.put("exception_type", 1);     // Catch: Exception -> L61
            String r114 = r112.getStackTrace();     // Catch: Exception -> L61
            if (r114 == null) goto L40;
            r113.put("class_ref", "Native");     // Catch: Exception -> L61
            r113.put(com.alipay.sdk.m.p.e.f25671s, "Native");     // Catch: Exception -> L61
            r113.put("is_core", 1);     // Catch: Exception -> L61
            r113.put("line_num", -1);     // Catch: Exception -> L61
            r113.put("ensure_type", "EnsureNotReachHere");     // Catch: Exception -> L61
            k.a().getClass();     // Catch: Exception -> L61
            r113.put("crash_lib_uuid", k.b(r114));     // Catch: Exception -> L61
            r113.put("stack", r114);     // Catch: Exception -> L61
            r113.put("has_dump", "true");     // Catch: Exception -> L61
        L40:
            JSONObject r108 = r113.optJSONObject("filters");     // Catch: Exception -> L61
            if (r108 != null) goto L43;
            r108 = new JSONObject();     // Catch: Exception -> L61
            r113.put("filters", r108);     // Catch: Exception -> L61
        L43:
            ah4.b.e(r106, r112, r105, r108);     // Catch: Exception -> L61
            JSONArray r109 = new JSONArray();     // Catch: Exception -> L61
            r109.put(r113);     // Catch: Exception -> L61
            JSONObject r115 = new JSONObject();     // Catch: Exception -> L61
            r115.put("data", r109);     // Catch: Exception -> L61
            r115.put("header", r111);     // Catch: Exception -> L61
            String r116 = n.d(zg4.g.f572072l.f572078f, r111);     // Catch: Exception -> L61
            String r117 = r115.toString();     // Catch: Exception -> L61
            ArrayList r118 = new ArrayList();     // Catch: Exception -> L61
            File[] r119 = r105.listFiles();     // Catch: Exception -> L61
            if (r119 == null) goto L57;
            int r120 = r119.length;     // Catch: Exception -> L61
            int r121 = 0;
        L46:
            if (r121 >= r120) goto L57;
            File r122 = r119[r121];     // Catch: Exception -> L61
            String r123 = r122.getName();     // Catch: Exception -> L61
            if (r123.endsWith(".summary") == true) goto L55;
            if (r123.endsWith(InvRouter.FLOW_SUFFIX) == true) goto L55;
            if (r123.endsWith(".inf") == true) goto L55;
            r118.add(r122);     // Catch: Exception -> L61
        L55:
            r121 = r121 + 1;     // Catch: Exception -> L61
        L57:
            if (CrashUploader.g("ensure_zip", r116, r117, r118).a() == false) goto L59;
            p.b("upload success");     // Catch: Exception -> L61
            h.b(r105);     // Catch: Exception -> L61
        L59:
            r104 = r104 + 1;
            goto L29
        L85:
            return;
        L60:
            return;
        L84:
            return;
        L21:
            th = move-exception;
            p.c("upload exception:" + th);
        L17:
            th = move-exception;
            p.c("upload exception:" + th);
        L13:
            th = move-exception;
            p.c("upload exception:" + th);
        L9:
            th = move-exception;
            p.c("upload exception:" + th);
        L5:
            th = move-exception;
            p.c("upload exception:" + th);
            goto L62
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(com.bytedance.crash.monitor.a r100) {
            this.f203127a = r100;
        }
    }

    public static String a() {
        return i.b() + "-" + Process.myPid();
    }

    public c(Context r100, PolarisFileWrapper r101) {
        PolarisFileWrapper r102 = com.bytedance.crash.util.g.b(r101, "crash");
        this.f203124a = r102;
        com.bytedance.crash.util.g.b(r101, "protector");
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, a());
        this.f203126c = r103;
        com.bytedance.crash.crash.a r104 = new com.bytedance.crash.crash.a(r103);
        new d(r104);
        ch4.b.a("JavaCrash_Init");
        this.f203125b = new f(r100, r104);
        ch4.b.a("NativeCrash_Init");
    }

    public final void c(com.bytedance.crash.monitor.a r210, long r211) {
        File[] r100 = this.f203124a.listFiles();
        if (r100 == null) goto L33;
        p.d("uploadAll:crashDumpDir:" + this.f203126c.getName());
        String r110 = "uploadAll ";
        int r111 = 0;
        if (r211 <= 0) goto L23;
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        int r112 = r100.length;
    L7:
        if (r111 >= r112) goto L20;
        File r113 = r100[r111];
        if (r113.getName().equals(this.f203126c.getName()) == false) goto L11;
        String r114 = r110;
        int r115 = r112;
    L18:
        r111 = r111 + 1;
        r112 = r115;
        r110 = r114;
        goto L7
    L11:
        p.d(r110 + r113.getAbsolutePath());
        CrashSummary r116 = CrashSummary.loadFromDirectory(r113);
        if (r116 == null) goto L17;
        r115 = r112;
        r114 = r110;
        ai4.e.d(r116.mCrashType, r116.getProcessName(), r116.getPid(), r116.getCrashTime());
        if ((r116.getCrashTime() - r116.getStartTime()) <= zg4.i.f572085a) goto L16;
        r101.add(r116);
        r102.add(r113);
        goto L18
    L16:
        b(r116, r210, r113);
        goto L18
    L17:
        r114 = r110;
        r115 = r112;
        p.d("uploadAll delete dir" + r113.getAbsolutePath());
        com.bytedance.crash.util.g.e(r113);
        ch4.c.d("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r113.getAbsolutePath()));
        goto L18
    L20:
        if (r101.isEmpty() == true) goto L33;
        wh4.b.postDelayed(new b(this, r101, r210, r102), r211);
        goto L33
    L23:
        String r117 = "uploadAll ";
        int r103 = r100.length;
    L24:
        if (r111 >= r103) goto L33;
        File r104 = r100[r111];
        if (r104.getName().equals(this.f203126c.getName()) == false) goto L28;
        String r118 = r117;
    L32:
        r111 = r111 + 1;
        r100 = r100;
        r117 = r118;
        goto L24
    L28:
        r118 = r117;
        p.d(r118 + r104.getAbsolutePath());
        CrashSummary r119 = CrashSummary.loadFromDirectory(r104);
        if (r119 == null) goto L31;
        ai4.e.d(r119.mCrashType, r119.getProcessName(), r119.getPid(), r119.getCrashTime());
        p.d("uploadAll create summary");
        JSONObject r105 = new JSONObject();
        ah4.b.e(r210, r119, r104, r105);
        r119.upload(r210, r105);
        goto L32
    L31:
        p.d("uploadAll delete dir" + r104.getAbsolutePath());
        com.bytedance.crash.util.g.e(r104);
        ch4.c.d("NPTH_CRASH_ERROR", new Exception("uploadCrash() summary is null:" + r104.getAbsolutePath()));
    L33:
        wh4.b.postDelayed(new a(r210), r211);
    }

    public static void b(CrashSummary r100, com.bytedance.crash.monitor.a r101, File r102) {
        p.d("uploadAll create summary");
        JSONObject r103 = new JSONObject();
        ah4.b.e(r101, r100, r102, r103);
        CrashType r104 = r100.mCrashType;
        if (r104 != CrashType.JAVA) goto L5;
    L6:
        com.bytedance.crash.util.j.h(r103, "from_custom", Boolean.FALSE);
    L7:
        r100.upload(r101, r103);
        return;
    L5:
        if (r104 != CrashType.LAUNCH) goto L7;
        goto L6
    }
}
