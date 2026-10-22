package com.bytedance.apm.block;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import bt3.f;
import com.bytedance.apm.PerfConfig;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.d;
import com.bytedance.common.util.JellyBeanV16Compat;
import com.bytedance.common.utility.Logger;
import com.bytedance.sliver.Sliver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.LinkedList;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import ss3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public static volatile k t;
    public f a;
    public volatile boolean b;
    public volatile boolean c;
    public long d;
    public long e;
    public boolean f;
    public final String g;
    public final StringBuilder h;
    public final StringBuilder i;
    public final StringBuilder j;
    public c k;
    public c l;
    public volatile boolean m;
    public boolean n;
    public boolean o;
    public final LinkedList<js3.c> p;
    public boolean q;
    public final a r;
    public final b s;

    public class a implements Runnable {
        public final /* synthetic */ k a;

        public final void a() {
            c r0 = this.a.k;
            if (r0 != null) goto L44;
            return;
        L44:
            r0.a();     // Catch: Throwable -> L24
            int r3 = 0;
            if (this.a.q == false) goto L31;
            String r1 = Sliver.getStackTrace(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));     // Catch: Throwable -> L24
            if (r1.contains(this.a.g) == false) goto L11;
            return;
        L11:
            String[] r2 = r1.split("\\)\\n");     // Catch: Throwable -> L24
            this.a.h.setLength(0);     // Catch: Throwable -> L24
            int r4 = r2.length;     // Catch: Throwable -> L24
        L12:
            if (r3 >= r4) goto L27;
            String r5 = r2[r3];     // Catch: Throwable -> L24
            String r6 = "";
            char[] r7 = r5.toCharArray();     // Catch: Throwable -> L24
            if (r7 == null) goto L26;
            if (r7.length == 0) goto L26;
            if (r7[r7.length - 1] != '(') goto L23;
            String[] r8 = r5.split("\\.");     // Catch: Throwable -> L24
            int r9 = r8.length;     // Catch: Throwable -> L24
            if (r9 <= 2) goto L23;
            r6 = r8[r9 - 2];     // Catch: Throwable -> L24
        L23:
            StringBuilder r10 = this.a.h;     // Catch: Throwable -> L24
            r10.append("\tat " + r5);     // Catch: Throwable -> L24
            r10.append(r6);     // Catch: Throwable -> L24
            r10.append(".java:1");     // Catch: Throwable -> L24
            r10.append(")\n");     // Catch: Throwable -> L24
        L26:
            r3 = r3 + 1;     // Catch: Throwable -> L24
            goto L12
        L27:
            k r11 = this.a;     // Catch: Throwable -> L24
            r11.k.q = r11.h.toString();     // Catch: Throwable -> L24
            if (d.j() == false) goto L50;
            Logger.e("StackThread", "block detected: " + this.a.h.toString());     // Catch: Throwable -> L24
            return;
        L50:
            return;
        L31:
            StackTraceElement[] r12 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L24
            if (r12[0].getClassName().startsWith(this.a.g) == false) goto L34;
            return;
        L34:
            this.a.k.m = System.currentTimeMillis();     // Catch: Throwable -> L24
            this.a.k.o = r12;     // Catch: Throwable -> L24
            if (d.j() == false) goto L37;
            b(r12);     // Catch: Throwable -> L24
        L37:
            this.a.h.setLength(0);     // Catch: Throwable -> L24
            int r13 = r12.length;     // Catch: Throwable -> L24
        L38:
            if (r3 >= r13) goto L40;
            StackTraceElement r14 = r12[r3];     // Catch: Throwable -> L24
            StringBuilder r15 = this.a.h;     // Catch: Throwable -> L24
            r15.append("\tat " + r14.getClassName());     // Catch: Throwable -> L24
            r15.append(".");     // Catch: Throwable -> L24
            r15.append(r14.getMethodName());     // Catch: Throwable -> L24
            r15.append("(");     // Catch: Throwable -> L24
            r15.append(r14.getFileName());     // Catch: Throwable -> L24
            r15.append(":");     // Catch: Throwable -> L24
            r15.append(r14.getLineNumber());     // Catch: Throwable -> L24
            r15.append(")\n");     // Catch: Throwable -> L24
            r3 = r3 + 1;     // Catch: Throwable -> L24
            goto L38
        L40:
            k r16 = this.a;     // Catch: Throwable -> L24
            r16.k.q = r16.h.toString();     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            com.bytedance.apm.k.b.a.c(th, "block_deal_exception");
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

        public a(k r1) {
            this.a = r1;
        }

        public final void b(StackTraceElement[] r5) {
            TimeoutException r0 = new TimeoutException("main thread task execute more than " + this.a.d + "ms");
            r0.setStackTrace(r5);
            Logger.e("StackThread", "block detected", r0);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ k a;

        public final void a() {
            k r0 = this.a;     // Catch: Throwable -> L26
            if (r0.k != null) goto L5;
            return;
        L5:
            int r2 = 0;
            if (r0.q == false) goto L28;
            String r1 = Sliver.getStackTrace(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()));     // Catch: Throwable -> L26
            if (r1.contains(this.a.g) == false) goto L10;
            return;
        L10:
            String[] r3 = r1.split("\\)\\n");     // Catch: Throwable -> L26
            this.a.i.setLength(0);     // Catch: Throwable -> L26
            int r4 = r3.length;     // Catch: Throwable -> L26
        L11:
            if (r2 >= r4) goto L24;
            String r5 = r3[r2];     // Catch: Throwable -> L26
            String r6 = "";
            char[] r7 = r5.toCharArray();     // Catch: Throwable -> L26
            if (r7 == null) goto L23;
            if (r7.length == 0) goto L23;
            if (r7[r7.length - 1] != '(') goto L22;
            String[] r8 = r5.split("\\.");     // Catch: Throwable -> L26
            int r9 = r8.length;     // Catch: Throwable -> L26
            if (r9 <= 2) goto L22;
            r6 = r8[r9 - 2];     // Catch: Throwable -> L26
        L22:
            StringBuilder r10 = this.a.i;     // Catch: Throwable -> L26
            r10.append("\tat " + r5);     // Catch: Throwable -> L26
            r10.append(r6);     // Catch: Throwable -> L26
            r10.append(".java:1");     // Catch: Throwable -> L26
            r10.append(")\n");     // Catch: Throwable -> L26
        L23:
            r2 = r2 + 1;     // Catch: Throwable -> L26
            goto L11
        L24:
            k r11 = this.a;     // Catch: Throwable -> L26
            r11.k.q = r11.i.toString();     // Catch: Throwable -> L26
            this.a.k.n = System.currentTimeMillis();     // Catch: Throwable -> L26
            c r12 = this.a.k;     // Catch: Throwable -> L26
            e.b().getClass();     // Catch: Throwable -> L26
            r12.u = e.a();     // Catch: Throwable -> L26
            k r13 = this.a;     // Catch: Throwable -> L26
            r13.k.v = k.d(r13);     // Catch: Throwable -> L26
            this.a.k.j = true;     // Catch: Throwable -> L26
            return;
        L28:
            StackTraceElement[] r14 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L26
            if (r14[0].getClassName().startsWith(this.a.g) == false) goto L31;
            return;
        L31:
            this.a.k.n = System.currentTimeMillis();     // Catch: Throwable -> L26
            c r15 = this.a.k;     // Catch: Throwable -> L26
            r15.p = r14;     // Catch: Throwable -> L26
            e.b().getClass();     // Catch: Throwable -> L26
            r15.u = e.a();     // Catch: Throwable -> L26
            k r16 = this.a;     // Catch: Throwable -> L26
            r16.k.v = k.d(r16);     // Catch: Throwable -> L26
            this.a.k.j = true;     // Catch: Throwable -> L26
            return;
        L26:
            th = move-exception;
            com.bytedance.apm.k.b.a.c(th, "serious_block_deal_exception");
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

        public b(k r1) {
            this.a = r1;
        }
    }

    public k() {
        this.b = false;
        this.c = false;
        this.d = 2500;
        this.e = 5000;
        this.f = true;
        this.h = new StringBuilder(1200);
        this.i = new StringBuilder(1200);
        this.j = new StringBuilder(1200);
        this.l = null;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = new LinkedList();
        this.q = false;
        this.r = new a(this);
        this.s = new b(this);
        this.g = k.class.getName();
    }

    public static JSONObject d(k r4) {
        r4.getClass();
        JSONObject r5 = new JSONObject();     // Catch: Exception -> L8
        Context r0 = d.getContext();     // Catch: Exception -> L8
        if (r0 == null) goto L6;
        ActivityManager r1 = (ActivityManager) r0.getSystemService("activity");     // Catch: Exception -> L8
        ActivityManager.MemoryInfo r2 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L8
        r1.getMemoryInfo(r2);     // Catch: Exception -> L8
        r5.put("availMem", r2.availMem);     // Catch: Exception -> L8
        r5.put("lowMemory", r2.lowMemory);     // Catch: Exception -> L8
        r5.put("threshold", r2.threshold);     // Catch: Exception -> L8
        r5.put("totalMem", JellyBeanV16Compat.getTotalMem(r2));     // Catch: Exception -> L8
    L6:
        Runtime r3 = Runtime.getRuntime();     // Catch: Exception -> L8
        r5.put("max_memory", r3.maxMemory());     // Catch: Exception -> L8
        r5.put("free_memory", r3.freeMemory());     // Catch: Exception -> L8
        r5.put("total_memory", r3.totalMemory());     // Catch: Exception -> L8
        return r5;
    L8:
        return null;
    }

    public static JSONObject g(c r6) {
        long r0 = r6.h - r6.g;
        JSONObject r2 = new JSONObject();
        r2.put("timestamp", r6.i);     // Catch: JSONException -> L5
        r2.put("crash_time", r6.i);     // Catch: JSONException -> L5
        r2.put("is_main_process", d.k());     // Catch: JSONException -> L5
        r2.put("process_name", d.c());     // Catch: JSONException -> L5
        r2.put("block_duration", r0);     // Catch: JSONException -> L5
        r2.put("last_scene", r6.s);     // Catch: JSONException -> L5
    L7:
        return r2;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public final void e(js3.c r6) {
    L3:
        if (this.p.size() == 0) goto L13;
        if ((r6.d - this.p.getFirst().d) < 0) goto L12;
        if ((r6.d - this.p.getFirst().d) > 60000) goto L12;
        if (this.p.size() <= 60) goto L13;
        this.p.removeFirst();
    L12:
        this.p.removeFirst();
    L13:
        this.p.addLast(r6);
    }

    public final void h(boolean r12) {
        if (this.a.d == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L74;
        c r1 = this.l;     // Catch: Exception -> L71
        if (r1 == null) goto L12;
        if (r12 == false) goto L11;
        r1.f = true;     // Catch: Exception -> L71
    L11:
        bt3.b.d.a.e(new l(this, r1));     // Catch: Exception -> L71
        this.l = null;     // Catch: Exception -> L71
    L12:
        c r2 = this.k;     // Catch: Exception -> L71
        if (r2 != null) goto L15;
        return;
    L15:
        if (r2.g >= 0) goto L17;
        return;
    L17:
        if (r2.h != (-1)) goto L77;
        r2.h = b27.a.b;     // Catch: Exception -> L71
        if (this.f == false) goto L22;
        this.a.a(this.r);     // Catch: Exception -> L71
        this.a.a(this.s);     // Catch: Exception -> L71
    L22:
        c r3 = this.k;     // Catch: Exception -> L71
        if ((r3.h - r3.g) <= this.d) goto L78;
        String r4 = g.a();     // Catch: Exception -> L71
        if (TextUtils.isEmpty(r4) == false) goto L27;
        r3.s = ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: Exception -> L71
    L28:
        this.k.i = System.currentTimeMillis();     // Catch: Exception -> L71
        if (this.f == true) goto L31;
        this.k.l = true;     // Catch: Exception -> L71
    L31:
        c r5 = this.k;     // Catch: Exception -> L71
        r5.d = r12;     // Catch: Exception -> L71
        r5.c = false;     // Catch: Exception -> L71
        c r6 = new c(r5.g, r5.b);     // Catch: Exception -> L71
        r6.h = r5.h;     // Catch: Exception -> L71
        boolean r7 = r5.a;     // Catch: Exception -> L71
        r6.a = r7;     // Catch: Exception -> L71
        r6.c = false;     // Catch: Exception -> L71
        r6.d = r12;     // Catch: Exception -> L71
        r6.e = r5.e;     // Catch: Exception -> L71
        r6.f = r5.f;     // Catch: Exception -> L71
        r6.i = r5.i;     // Catch: Exception -> L71
        r6.j = r5.j;     // Catch: Exception -> L71
        r6.k = r5.k;     // Catch: Exception -> L71
        r6.m = r5.m;     // Catch: Exception -> L71
        r6.n = r5.n;     // Catch: Exception -> L71
        r6.o = r5.o;     // Catch: Exception -> L71
        r6.p = r5.p;     // Catch: Exception -> L71
        r6.q = r5.q;     // Catch: Exception -> L71
        r6.r = r5.r;     // Catch: Exception -> L71
        r6.s = r5.s;     // Catch: Exception -> L71
        r6.t = r5.t;     // Catch: Exception -> L71
        r6.u = r5.u;     // Catch: Exception -> L71
        r6.v = r5.v;     // Catch: Exception -> L71
        r6.w = r5.w;     // Catch: Exception -> L71
        r6.l = r5.l;     // Catch: Exception -> L71
        if (r7 == true) goto L35;
        r6.a();     // Catch: Exception -> L71
    L35:
        if ((r6.h - r6.g) < this.e) goto L37;
        boolean r8 = true;
    L38:
        r6.j = r8;     // Catch: Exception -> L71
        com.bytedance.monitor.collector.b.e r9 = com.bytedance.monitor.collector.c.e().f();     // Catch: Exception -> L71
        if (r9 == null) goto L61;
        StackTraceElement[] r10 = r6.o;     // Catch: Exception -> L71
        if (r10 != null) goto L45;
        r10 = new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};     // Catch: Exception -> L71
    L45:
        if (r6.j == false) goto L50;
        StackTraceElement[] r11 = r6.p;     // Catch: Exception -> L71
        if (r11 != null) goto L52;
        r11 = new StackTraceElement[]{new StackTraceElement("Invalid Stack\n", "a", "a.java", 1)};     // Catch: Exception -> L71
    L52:
        if (TextUtils.isEmpty("uuid") == true) goto L54;
        r9.m = "uuid";     // Catch: Exception -> L71
    L54:
        r9.j = r10;     // Catch: Exception -> L71
        if (r11 == null) goto L58;
        r9.k = r11;     // Catch: Exception -> L71
    L58:
        if (TextUtils.isEmpty(null) == true) goto L61;
        r9.l = null;     // Catch: Exception -> L71
        goto L61
    L50:
        r11 = null;
    L61:
        if (r6.k == false) goto L63;
        bt3.b.d.a.e(new l(this, r6));     // Catch: Exception -> L71
    L64:
        c r13 = this.k;     // Catch: Exception -> L71
        if ((r13.h - r13.g) <= this.e) goto L79;
        if (r12 == true) goto L68;
        return;
    L68:
        if (this.m == false) goto L81;
        h.b();     // Catch: Exception -> L71
        return;
    L81:
        return;
    L79:
        return;
    L63:
        this.l = r6;     // Catch: Exception -> L71
        goto L64
    L37:
        r8 = false;
        goto L38
    L27:
        r3.s = r4 + "," + ActivityLifeObserver.getInstance().getTopActivityClassName();     // Catch: Exception -> L71
        goto L28
    L78:
        return;
    L77:
        return;
    L74:
        return;
    L5:
        r0 = false;
    }

    public static void c(k r4, c r5, String r6) throws JSONException {
        if (PerfConfig.a == false) goto L5;
        r4.getClass();
        JSONObject r7 = g(r5);
        JSONObject r0 = ou3.a.a().c(true);
        r0.put("crash_section", d.i(r5.i));
        r0.put("belong_frame", String.valueOf(r5.d));
        r0.put("belong_dump", String.valueOf(r5.c));
        r0.put("block_stack_type", "messageKey");
        r7.put("filters", r0);
        r7.put("event_type", "lag");
        r7.put("stack", "at " + r6 + ".*(a.java:-1)");
        js3.c r8 = new js3.c("block_monitor", r7);
        r8.c = true;
        is3.a.h().b(r8);
        return;
    L5:
        r4.getClass();
    }

    public static JSONObject f(boolean r3, c r4, String r5) throws JSONException {
        JSONObject r0 = ou3.a.a().c(true);
        r0.put("crash_section", d.i(r4.i));
        r0.put("belong_frame", String.valueOf(r3));
        r0.put("belong_dump", String.valueOf(r4.c));
        r0.put("block_input", String.valueOf(r4.e));
        r0.put("block_frame", String.valueOf(r4.f));
        r0.put("block_message", r5);
        r0.put("block_stack_type", "stack");
        r0.put("buuid", r4.r);
        r0.put("belong_poll_once", String.valueOf(r4.k));
        return r0;
    }

    public static void a(k r3, boolean r4, c r5, String r6) throws JSONException {
        if (r3.n == false) goto L7;
        JSONObject r0 = g(r5);
        r0.put("stack", r5.q);
        r0.put("message", r6);
        r0.put("ignore_stack", r3.k.l);
        r0.put("event_type", "lag");
        r0.put("filters", f(r4, r5, r6));
        r0.put("custom", new JSONObject());
        js3.c r7 = new js3.c("block_monitor", r0, r5.g);
        r3.e(r7);
        is3.a.h().b(r7);
        return;
    }

    public static void b(k r17, c r18, String r19, boolean r20) throws JSONException {
        if (r17.o == false) goto L79;
        Logger.e("StackThread", "reportSeriousBlock :" + r18.q);
        JSONObject r3 = f(r18.d, r18, r19);
        r3.put("sbuuid", "empty");
        JSONObject r4 = g(r18);
        r4.put("message", r19);
        StackTraceElement[] r2 = r18.o;
        if (r2 == null) goto L70;
        StackTraceElement[] r7 = r18.p;
        if (r7 == null) goto L70;
        int r5 = r2.length;
        int r8 = r7.length;
        int r9 = 0;
        int r10 = 0;
    L11:
        if (r9 >= Math.min(r5, r8)) goto L46;
        boolean r13 = true;
        int r12 = (r5 - r9) - 1;
        int r15 = (r8 - r9) - 1;
        if (r18.o[r12].equals(r18.p[r15]) == false) goto L14;
        r10 = r10 + 1;
        r9 = r9 + 1;
        goto L11
    L14:
        StackTraceElement r11 = r18.o[r12];
        StackTraceElement r14 = r18.p[r15];
        if (r11 == r14) goto L42;
        if (r11 == null) goto L41;
        if (r14 == null) goto L41;
        if (r11.getClassName().equals(r14.getClassName()) == false) goto L41;
        String r16 = r11.getMethodName();
        String r110 = r14.getMethodName();
        if (r16 == r110) goto L29;
        if (r16 != null) goto L26;
    L28:
        boolean r111 = false;
    L30:
        if (r111 == false) goto L41;
        String r21 = r11.getFileName();
        String r112 = r14.getFileName();
        if (r21 == r112) goto L38;
        if (r21 != null) goto L35;
    L37:
        boolean r22 = false;
    L39:
        if (r22 == false) goto L41;
    L35:
        if (r21.equals(r112) == false) goto L37;
    L38:
        r22 = true;
        goto L39
    L26:
        if (r16.equals(r110) == false) goto L28;
    L29:
        r111 = true;
    L41:
        r13 = false;
    L42:
        if (r13 == false) goto L46;
        r10 = r10 + 1;
    L46:
        if (r10 != 0) goto L48;
        r3.put("serious_stack_coincide", "none");
    L51:
        JSONObject r113 = r3;
    L61:
        r17.j.setLength(0);
    L62:
        if (r10 <= 0) goto L65;
        StringBuilder r6 = r17.j;
        r6.append("\tat ");
        int r23 = r5 - r10;
        r6.append(r18.o[r23].getClassName());
        r6.append(".");
        r6.append(r18.o[r23].getMethodName());
        r6.append("(");
        r6.append(r18.o[r23].getFileName());
        r6.append(":");
        r6.append(r18.o[r23].getLineNumber());
        r6.append(")\n");
        r10 = r10 - 1;
        goto L62
    L65:
        if (r17.j.length() != 0) goto L67;
        String r24 = r18.q;
    L68:
        r4.put("stack", r24);
        r3 = r113;
        r3.put("sbuuid", r18.r);
        goto L70
    L67:
        r24 = r17.j.toString();
        goto L68
    L48:
        if (r10 != r5) goto L52;
        if (r10 != r8) goto L52;
        r3.put("serious_stack_coincide", "full");
    L52:
        r3.put("serious_stack_coincide", "part");
        r17.j.setLength(0);
        int r25 = 0;
    L54:
        if (r25 > (r5 - r10)) goto L56;
        StringBuilder r114 = r17.j;
        r114.append("\tat ");
        r114.append(r18.o[r25].getClassName());
        r114.append(".");
        r114.append(r18.o[r25].getMethodName());
        r114.append("(");
        r114.append(r18.o[r25].getFileName());
        r114.append(":");
        r114.append(r18.o[r25].getLineNumber());
        r114.append(")\n");
        r25 = r25 + 1;
        r3 = r3;
        goto L54
    L56:
        r113 = r3;
        r4.put("stack1", r17.j.toString());
        r17.j.setLength(0);
        int r115 = 0;
    L58:
        if (r115 > (r8 - r10)) goto L60;
        StringBuilder r26 = r17.j;
        r26.append("\tat ");
        r26.append(r18.p[r115].getClassName());
        r26.append(".");
        r26.append(r18.p[r115].getMethodName());
        r26.append("(");
        r26.append(r18.p[r115].getFileName());
        r26.append(":");
        r26.append(r18.p[r115].getLineNumber());
        r26.append(")\n");
        r115 = r115 + 1;
        goto L58
    L60:
        r4.put("stack2", r17.j.toString());
    L70:
        if (r17.q == false) goto L72;
        r4.put("stack", r18.q);
        r3.put("sbuuid", r18.r);
    L72:
        r4.put("stack_cost", r18.n - r18.m);
        r4.put("filters", r3);
        r4.put("event_type", "serious_lag");
        r4.put("block_looper_info", r18.t);
        r4.put("block_cpu_info", r18.u);
        r4.put("block_memory_info", r18.v);
        r4.put("custom", r18.w);
        r4.put("block_error_info", r20);
        js3.c r27 = new js3.c(UploadTypeInf.SERIOUS_BLOCK_MONITOR, r4, r18.g);
        r17.e(r27);
        is3.a.h().b(r27);
        return;
    }
}
