package com.bytedance.bdturing.senseless;

import android.app.Activity;
import android.text.TextUtils;
import cc4.g;
import cc4.j;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import qb4.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static volatile d g;
    public com.bytedance.bdturing.senseless.a a;
    public long b;
    public String c;
    public long d;
    public int e;
    public int f;

    public class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ InterfaceC0115d c;

        @Override // java.lang.Runnable
        public final void run() {
            rb4.d.b().a(new c(this.a, System.currentTimeMillis(), "pre_collect", this.b, this.c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r1, String r2, InterfaceC0115d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ InterfaceC0115d c;
        public final /* synthetic */ d d;

        @Override // java.lang.Runnable
        public final void run() {
            rb4.d.b().a(new c(this.a, this.d.d, "async_collect", this.b, this.c));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(d r1, String r2, String r3, InterfaceC0115d r4) {
            this.d = r1;
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static class c implements Runnable {
        public final String a;
        public final String b;
        public final String c;
        public final InterfaceC0115d d;
        public final long e;

        public class a implements ec4.c {
            public final /* synthetic */ c a;

            public a(c r1) {
                this.a = r1;
            }

            @Override // ec4.c
            public final void a(xb4.a r6) {
                if (r6.a != 200) goto L8;
                InterfaceC0115d r7 = this.a.d;
                if (r7 == null) goto L22;
                r7.onSuccess();
                return;
            L22:
                return;
            L8:
                if (this.a.d == null) goto L24;
                JSONObject r1 = new JSONObject();
                hc4.d.b(r1, "message", r6.c);
                hc4.d.b(r1, "sec_message", r6.d);
                JSONObject r2 = new JSONObject();
                if (r6.a != 201) goto L17;
                String r8 = r6.b.optString("decision");
                r2.put("detail", new JSONObject(r8).optString("detail"));     // Catch: Exception -> L14
            L16:
                hc4.d.b(r1, "decision", r8);
                hc4.d.b(r1, "query", r2);
                int r9 = 10;
            L18:
                this.a.d.onFail(r9, r1);
                return;
            L14:
                e = move-exception;
                e.printStackTrace();
                goto L16
            L17:
                r9 = 1;
                goto L18
            }

            @Override // ec4.c
            public final void onError(Throwable r4) {
                if (this.a.d == null) goto L6;
                JSONObject r0 = new JSONObject();
                hc4.d.b(r0, "errorMsg", "net work error:" + r4);
                this.a.d.a(1, r0);
                return;
            }
        }

        public final void a() {
            JSONObject r1 = new JSONObject();     // Catch: Exception -> L28
            r1.put("data_type", this.b);     // Catch: Exception -> L28
            JSONObject r2 = new JSONObject();     // Catch: Exception -> L28
            r2.put("launch_time", EventReport.b);     // Catch: Exception -> L28
            r2.put("is_back_ground", g.d().b);     // Catch: Exception -> L28
            long r3 = System.currentTimeMillis() - EventReport.b;     // Catch: Exception -> L28
            r2.put("runtime", r3);     // Catch: Exception -> L28
            BdTuringConfig r5 = qb4.b.c.a.a;     // Catch: Exception -> L28
            if (r5 == null) goto L6;
            Activity r6 = r5.getTopActivity();     // Catch: Exception -> L28
        L7:
            if (r6 == null) goto L9;
            r2.put("page_id", r6.getClass().getName());     // Catch: Exception -> L28
        L9:
            g.d().getClass();     // Catch: Exception -> L28
            JSONArray r7 = g.e();     // Catch: Exception -> L28
            r2.put("page_history", r7);     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r2.put("page_profile", g.f());     // Catch: Exception -> L28
            g r8 = g.d();     // Catch: Exception -> L28
            List r9 = g.j;     // Catch: Exception -> L28
            r8.getClass();     // Catch: Exception -> L28
            r2.put("first_touch_event", g.m(r9));     // Catch: Exception -> L28
            g r10 = g.d();     // Catch: Exception -> L28
            List r11 = g.i;     // Catch: Exception -> L28
            r10.getClass();     // Catch: Exception -> L28
            JSONArray r12 = g.m(r11);     // Catch: Exception -> L28
            r2.put("touch_event", r12);     // Catch: Exception -> L28
            if ("async_collect".equals(this.b) == false) goto L12;
            r7 = r12;
        L12:
            HashMap r4 = (HashMap) j.a(r3, r7, this.a, this.b);     // Catch: Exception -> L28
            Iterator r13 = r4.keySet().iterator();     // Catch: Exception -> L28
        L14:
            if (r13.hasNext() == false) goto L16;
            String r14 = (String) r13.next();     // Catch: Exception -> L28
            r2.put(r14, (Long) r4.get(r14));     // Catch: Exception -> L28
            goto L14
        L16:
            r1.put("common", r2);     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r1.put("data_profile", g.c());     // Catch: Exception -> L28
            g.d().getClass();     // Catch: Exception -> L28
            r1.put("sdk_runtime_info", g.g());     // Catch: Exception -> L28
            r1.put("nocaptcha", cc4.b.a());     // Catch: Exception -> L28
            if ("async_collect".equals(this.b) == false) goto L19;
            JSONObject r0 = new JSONObject();     // Catch: Exception -> L28
            r0.put("async_touch_event_start_time", this.e);     // Catch: Exception -> L28
            r1.put("async_collect_data", r0);     // Catch: Exception -> L28
        L19:
            String r15 = hc4.b.c(this.c);     // Catch: Exception -> L28
            String r16 = hc4.b.a(r1.toString(), r15);     // Catch: Exception -> L28
            if (TextUtils.isEmpty(r15) == true) goto L25;
            if (TextUtils.isEmpty(r16) == true) goto L25;
            String r17 = d.a(d.b());     // Catch: Exception -> L28
            HashMap r18 = new HashMap();     // Catch: Exception -> L28
            r18.put("detail", this.c);     // Catch: Exception -> L28
            r18.put("subtype", this.a);     // Catch: Exception -> L28
            HashMap r19 = new HashMap();     // Catch: Exception -> L28
            r19.put("data", r16);     // Catch: Exception -> L28
            HashMap r20 = new HashMap();     // Catch: Exception -> L28
            r20.put("Content-Type", "application/json; charset=utf-8");     // Catch: Exception -> L28
            ec4.j r21 = new ec4.j(r17, r18, r19, r20);     // Catch: Exception -> L28
            EventReport.z(SenselessVerifyService.getInstance().getRiskRequest());     // Catch: Exception -> L28
            r21.c(new a(this));     // Catch: Exception -> L28
            return;
        L25:
            if (this.d == null) goto L41;
            JSONObject r22 = new JSONObject();     // Catch: Exception -> L28
            r22.put("errorMsg", "params error");     // Catch: Exception -> L28
            this.d.a(-1, r22);     // Catch: Exception -> L28
            return;
        L41:
            return;
        L6:
            r6 = null;
        L28:
            e = move-exception;
            e.printStackTrace();
            if (this.d == null) goto L42;
            JSONObject r23 = new JSONObject();     // Catch: Exception -> L33
            r23.put("error", e.getMessage());     // Catch: Exception -> L33
            this.d.a(1, r23);     // Catch: Exception -> L33
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

        public c(String r1, long r2, String r4, String r5, InterfaceC0115d r6) {
            this.a = r1;
            this.e = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.senseless.d$d, reason: collision with other inner class name */
    public interface InterfaceC0115d {
        void a(int r1, JSONObject r2);

        void onFail(int r1, JSONObject r2);

        void onSuccess();
    }

    public interface e {
        void onFail(int r1, JSONObject r2);

        void onSuccess();
    }

    public static d b() {
        if (g != null) goto L13;
        monitor-enter(d.class);
        g = new d();     // Catch: Throwable -> L9
        monitor-exit(d.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return g;
    }

    public d() {
    }

    public static String a(d r4) {
        if (TextUtils.isEmpty(r4.c) == false) goto L14;
        com.bytedance.bdturing.setting.e r0 = com.bytedance.bdturing.setting.e.a;
        String r1 = com.bytedance.bdturing.setting.e.d("verify");
        StringBuilder r2 = new StringBuilder();
        if (TextUtils.isEmpty(r1) == false) goto L7;
    L12:
        r2.append("nocaptcha/report");
        r4.c = r2.toString();
        goto L14
    L7:
        if (r1.startsWith("https://") == true) goto L9;
        r2.append("https://");
    L9:
        r2.append(r1);
        if (r1.endsWith("/") == true) goto L12;
        r2.append("/");
    L14:
        return r4.c;
    }

    public static void d(String r7, String r8, InterfaceC0115d r9, long r10) {
        if (r10 > 0) goto L5;
        rb4.d.b().a(new c(r7, System.currentTimeMillis(), "pre_collect", r8, r9));
        return;
    L5:
        if (c0.a.a.b(new a(r7, r8, r9), r10) == true) goto L10;
        if (r9 == null) goto L11;
        JSONObject r11 = new JSONObject();
        hc4.d.b(r11, "errorMsg", "taskEnqueue fail");
        r9.onFail(1, r11);
        return;
    L11:
        return;
    }

    public final void c(String r8, String r9, InterfaceC0115d r10, long r11) {
        if (r11 > 0) goto L5;
        rb4.d.b().a(new c(r8, this.d, "async_collect", r9, r10));
        return;
    L5:
        if (c0.a.a.b(new b(this, r8, r9, r10), r11) == true) goto L10;
        if (r10 == null) goto L11;
        JSONObject r12 = new JSONObject();
        hc4.d.b(r12, "errorMsg", "taskEnqueue fail");
        r10.onFail(1, r12);
        return;
    L11:
        return;
    }
}
