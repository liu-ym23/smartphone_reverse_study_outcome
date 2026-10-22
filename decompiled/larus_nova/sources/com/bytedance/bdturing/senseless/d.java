package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.text.TextUtils;
import cc4.g;
import cc4.h;
import cc4.j;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.ee.space.sync.PushAction$ESubType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile d f202036g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.bdturing.senseless.a f202037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f202038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f202039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f202040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f202041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f202042f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f202043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f202044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2913d f202045c;

        @Override // java.lang.Runnable
        public final void run() {
            rb4.d.b().a(new c(this.f202043a, System.currentTimeMillis(), "pre_collect", this.f202044b, this.f202045c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, String r101, InterfaceC2913d r102) {
            this.f202043a = r100;
            this.f202044b = r101;
            this.f202045c = r102;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f202046a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f202047b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2913d f202048c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f202049d;

        @Override // java.lang.Runnable
        public final void run() {
            rb4.d.b().a(new c(this.f202046a, this.f202049d.f202040d, "async_collect", this.f202047b, this.f202048c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r100, String r101, String r102, InterfaceC2913d r103) {
            this.f202049d = r100;
            this.f202046a = r101;
            this.f202047b = r102;
            this.f202048c = r103;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f202050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f202051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f202052c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final InterfaceC2913d f202053d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f202054e;

        public class a implements ec4.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f202055a;

            public a(c r100) {
                this.f202055a = r100;
            }

            @Override // ec4.c
            public final void a(xb4.a r100) {
                if (r100.f563110a != 200) goto L8;
                InterfaceC2913d r101 = this.f202055a.f202053d;
                if (r101 == null) goto L22;
                r101.onSuccess();
                return;
            L22:
                return;
            L8:
                if (this.f202055a.f202053d == null) goto L24;
                JSONObject r102 = new JSONObject();
                hc4.d.b(r102, "message", r100.f563112c);
                hc4.d.b(r102, "sec_message", r100.f563113d);
                JSONObject r103 = new JSONObject();
                if (r100.f563110a != 201) goto L17;
                String r104 = r100.f563111b.optString("decision");
                r103.put("detail", new JSONObject(r104).optString("detail"));     // Catch: Exception -> L14
            L16:
                hc4.d.b(r102, "decision", r104);
                hc4.d.b(r102, "query", r103);
                int r105 = 10;
            L18:
                this.f202055a.f202053d.onFail(r105, r102);
                return;
            L14:
                e = move-exception;
                e.printStackTrace();
                goto L16
            L17:
                r105 = 1;
                goto L18
            }

            @Override // ec4.c
            public final void onError(Throwable r100) {
                if (this.f202055a.f202053d == null) goto L6;
                JSONObject r101 = new JSONObject();
                hc4.d.b(r101, "errorMsg", "net work error:" + r100);
                this.f202055a.f202053d.a(1, r101);
                return;
            }
        }

        public final void a() {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L28
            r100.put("data_type", this.f202051b);     // Catch: Exception -> L28
            JSONObject r101 = new JSONObject();     // Catch: Exception -> L28
            r101.put("launch_time", EventReport.f201689b);     // Catch: Exception -> L28
            r101.put("is_back_ground", g.d().f23279b);     // Catch: Exception -> L28
            long r102 = System.currentTimeMillis() - EventReport.f201689b;     // Catch: Exception -> L28
            r101.put("runtime", r102);     // Catch: Exception -> L28
            BdTuringConfig r103 = qb4.b.c.f532315a.f532302a;     // Catch: Exception -> L28
            if (r103 == null) goto L6;
            Activity r104 = r103.getTopActivity();     // Catch: Exception -> L28
        L7:
            if (r104 == null) goto L9;
            r101.put(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, r104.getClass().getName());     // Catch: Exception -> L28
        L9:
            g.d().getClass();     // Catch: Exception -> L28
            JSONArray r105 = g.e();     // Catch: Exception -> L28
            r101.put("page_history", r105);     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r101.put("page_profile", g.f());     // Catch: Exception -> L28
            g r106 = g.d();     // Catch: Exception -> L28
            List<h> r107 = g.f23270j;     // Catch: Exception -> L28
            r106.getClass();     // Catch: Exception -> L28
            r101.put("first_touch_event", g.m(r107));     // Catch: Exception -> L28
            g r108 = g.d();     // Catch: Exception -> L28
            List<h> r109 = g.f23269i;     // Catch: Exception -> L28
            r108.getClass();     // Catch: Exception -> L28
            JSONArray r110 = g.m(r109);     // Catch: Exception -> L28
            r101.put("touch_event", r110);     // Catch: Exception -> L28
            if ("async_collect".equals(this.f202051b) == false) goto L12;
            r105 = r110;
        L12:
            HashMap r111 = (HashMap) j.a(r102, r105, this.f202050a, this.f202051b);     // Catch: Exception -> L28
            Iterator r112 = r111.keySet().iterator();     // Catch: Exception -> L28
        L14:
            if (r112.hasNext() == false) goto L16;
            String r113 = (String) r112.next();     // Catch: Exception -> L28
            r101.put(r113, (Long) r111.get(r113));     // Catch: Exception -> L28
            goto L14
        L16:
            r100.put("common", r101);     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r100.put("data_profile", g.c());     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r100.put("sdk_runtime_info", g.g());     // Catch: Exception -> L28
            r100.put("nocaptcha", cc4.b.a());     // Catch: Exception -> L28
            if ("async_collect".equals(this.f202051b) == false) goto L19;
            JSONObject r114 = new JSONObject();     // Catch: Exception -> L28
            r114.put("async_touch_event_start_time", this.f202054e);     // Catch: Exception -> L28
            r100.put("async_collect_data", r114);     // Catch: Exception -> L28
        L19:
            String r115 = hc4.b.c(this.f202052c);     // Catch: Exception -> L28
            String r116 = hc4.b.a(r100.toString(), r115);     // Catch: Exception -> L28
            if (TextUtils.isEmpty(r115) == true) goto L25;
            if (TextUtils.isEmpty(r116) == true) goto L25;
            String r117 = d.a(d.b());     // Catch: Exception -> L28
            HashMap r118 = new HashMap();     // Catch: Exception -> L28
            r118.put("detail", this.f202052c);     // Catch: Exception -> L28
            r118.put(PushAction$ESubType.KEY_NAME, this.f202050a);     // Catch: Exception -> L28
            HashMap r119 = new HashMap();     // Catch: Exception -> L28
            r119.put("data", r116);     // Catch: Exception -> L28
            HashMap r120 = new HashMap();     // Catch: Exception -> L28
            r120.put("Content-Type", "application/json; charset=utf-8");     // Catch: Exception -> L28
            ec4.j r121 = new ec4.j(r117, r118, r119, r120);     // Catch: Exception -> L28
            EventReport.z(SenselessVerifyService.getInstance().getRiskRequest());     // Catch: Exception -> L28
            r121.c(new a(this));     // Catch: Exception -> L28
            return;
        L25:
            if (this.f202053d == null) goto L41;
            JSONObject r122 = new JSONObject();     // Catch: Exception -> L28
            r122.put("errorMsg", "params error");     // Catch: Exception -> L28
            this.f202053d.a(-1, r122);     // Catch: Exception -> L28
            return;
        L41:
            return;
        L6:
            r104 = null;
        L28:
            e = move-exception;
            e.printStackTrace();
            if (this.f202053d == null) goto L42;
            JSONObject r123 = new JSONObject();     // Catch: Exception -> L33
            r123.put("error", e.getMessage());     // Catch: Exception -> L33
            this.f202053d.a(1, r123);     // Catch: Exception -> L33
            return;
        L33:
            e = move-exception;
            e.printStackTrace();
            return;
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

        public c(String r100, long r101, String r102, String r103, InterfaceC2913d r104) {
            this.f202050a = r100;
            this.f202054e = r101;
            this.f202051b = r102;
            this.f202052c = r103;
            this.f202053d = r104;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.senseless.d$d, reason: collision with other inner class name */
    public interface InterfaceC2913d {
        void a(int r100, JSONObject r101);

        void onFail(int r100, JSONObject r101);

        void onSuccess();
    }

    public interface e {
        void onFail(int r100, JSONObject r101);

        void onSuccess();
    }

    public static d b() {
        if (f202036g != null) goto L13;
        monitor-enter(d.class);
        f202036g = new d();     // Catch: Throwable -> L9
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return f202036g;
    }

    public d() {
    }

    public static String a(d r100) {
        if (TextUtils.isEmpty(r100.f202039c) == false) goto L14;
        com.bytedance.bdturing.setting.e r101 = com.bytedance.bdturing.setting.e.f202077a;
        String r102 = com.bytedance.bdturing.setting.e.d("verify");
        StringBuilder r103 = new StringBuilder();
        if (TextUtils.isEmpty(r102) == false) goto L7;
    L12:
        r103.append("nocaptcha/report");
        r100.f202039c = r103.toString();
        goto L14
    L7:
        if (r102.startsWith("https://") == true) goto L9;
        r103.append("https://");
    L9:
        r103.append(r102);
        if (r102.endsWith(HTTP.URL_DEFAULT) == true) goto L12;
        r103.append(HTTP.URL_DEFAULT);
    L14:
        return r100.f202039c;
    }

    public static void d(String r100, String r101, InterfaceC2913d r102, long r110) {
        if (r110 > 0) goto L5;
        rb4.d.b().a(new c(r100, System.currentTimeMillis(), "pre_collect", r101, r102));
        return;
    L5:
        if (c0.a.f532328a.b(new a(r100, r101, r102), r110) == true) goto L10;
        if (r102 == null) goto L11;
        JSONObject r103 = new JSONObject();
        hc4.d.b(r103, "errorMsg", "taskEnqueue fail");
        r102.onFail(1, r103);
        return;
    L11:
        return;
    }

    public final void c(String r100, String r101, InterfaceC2913d r110, long r111) {
        if (r111 > 0) goto L5;
        rb4.d.b().a(new c(r100, this.f202040d, "async_collect", r101, r110));
        return;
    L5:
        if (c0.a.f532328a.b(new b(this, r100, r101, r110), r111) == true) goto L10;
        if (r110 == null) goto L11;
        JSONObject r102 = new JSONObject();
        hc4.d.b(r102, "errorMsg", "taskEnqueue fail");
        r110.onFail(1, r102);
        return;
    L11:
        return;
    }
}
