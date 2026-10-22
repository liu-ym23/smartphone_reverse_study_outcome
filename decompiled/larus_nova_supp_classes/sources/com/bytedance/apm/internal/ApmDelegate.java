package com.bytedance.apm.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.EventsUtils;
import bt3.f;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.agent.tracing.AutoLaunchTraceHelper;
import com.bytedance.apm.agent.tracing.AutoPageTraceHelper;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.config.SlardarConfigManagerImpl;
import com.bytedance.apm.config.b;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.doctor.DoctorManager;
import com.bytedance.apm.util.a;
import com.bytedance.apm.util.m;
import com.bytedance.crash.z;
import com.bytedance.monitor.collector.c;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import ff7.d;
import ff7.i;
import ff7.l;
import iu3.e;
import java.lang.ref.ReferenceQueue;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import ss3.g;
import ss3.j;
import vr3.h;
import ws3.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ApmDelegate implements IConfigListener {
    public static long p;
    public static boolean q;
    public b a;
    public ApmStartConfig b;
    public os3.b c;
    public d d;
    public SlardarConfigManagerImpl e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public boolean i;
    public Set<i> j;
    public boolean k;
    public boolean l;
    public List<String> m;
    public List<String> n;
    public List<String> o;

    private void initEvilMethodTraceInject() {
    }

    public final void onReady() {
        boolean r0 = true;
        this.f = true;
        os3.b r1 = this.c;
        if (r1 == null) goto L5;
        r1.onReady();
    L5:
        JSONObject r2 = this.e.getConfig();
        boolean r3 = false;
        if (this.i == false) goto L14;
        new j().b();
        if (com.bytedance.apm.util.j.d(r2, "traffic", "enable_collect") != 1) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        String r5 = k.x;
        k.a.a.b();
        goto L14
    L10:
        r4 = false;
    L14:
        if (this.b.n == false) goto L47;
        if (com.bytedance.apm.util.j.d(r2, "battery", "enable_upload") != 1) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L21;
    L24:
        if (r6 == false) goto L26;
    L27:
        boolean r7 = this.b.o;
        Object r8 = vr3.b.C;
        vr3.b r9 = vr3.b.e.a;
        r9.o = r7;
        r9.b();
    L29:
        if (com.bytedance.apm.util.j.d(r2, "battery", "power_monitor_enable") != 1) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == false) goto L37;
        if (a.b(com.bytedance.apm.d.getContext()) == false) goto L37;
        vr3.k.a.a.b();
    L37:
        if (com.bytedance.apm.util.j.d(r2, "battery", "temperature_enable_upload") == 1) goto L40;
        r0 = false;
    L40:
        if (r0 == false) goto L42;
    L43:
        boolean r11 = this.b.p;
        if (a.b(com.bytedance.apm.d.getContext()) == false) goto L47;
        vr3.j r12 = vr3.j.b.a;
        r12.k = r11;
        r12.b();
        goto L47
    L42:
        if (this.b.p == false) goto L47;
    L31:
        r10 = false;
        goto L32
    L26:
        if (this.b.o == false) goto L29;
    L21:
        if (a.b(com.bytedance.apm.d.getContext()) == false) goto L23;
        h.c.a.b();
    L23:
        new vr3.i().b();
        goto L24
    L18:
        r6 = false;
    L47:
        if (this.b.i == false) goto L54;
        Boolean r13 = (Boolean) ((ConcurrentHashMap) ss3.d.a.a.b).get("block_monitor");
        if (r13 == null) goto L51;
        r3 = r13.booleanValue();
    L51:
        if (r3 == false) goto L55;
        d();
        return;
    L55:
        return;
    }

    private static void initTraceEvilMethod() {
        long r0 = p;
        if (r0 >= 70) goto L5;
        r0 = 1000;
    L5:
        a47.a.j = r0;
        a47.a.l = q;
        a47.a.k = true;
        es3.h.z.g();
        MethodCollector.getInstance().onStart();
        new a47.a(false).j();
        c.e().getClass();
    }

    public final b a() {
        b r0 = this.a;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new b(new b.a());
    }

    public final void d() {
        if (this.k == false) goto L5;
        return;
    L5:
        this.k = true;
        bt3.a.a.post(new a());
        ff7.c r1 = new com.bytedance.apm.block.b();
        long r2 = this.b.l;
        com.bytedance.apm.block.k r4 = ((com.bytedance.apm.block.b) r1).d;
        r4.getClass();
        if (r2 >= 70) goto L8;
        r2 = 2500;
    L8:
        r4.d = r2;
        if (r4.e >= r2) goto L11;
        r4.e = r2 + 50;
    L11:
        ((com.bytedance.apm.block.b) r1).d.b = this.b.j;
        ((com.bytedance.apm.block.b) r1).d.c = this.b.k;
        this.b.getClass();
        ((com.bytedance.apm.block.b) r1).d.getClass();
        ActivityLifeObserver.getInstance().register(r1);
        List r3 = com.bytedance.apm.i.a;
        monitor-enter(com.bytedance.apm.i.class);
        ((ArrayList) com.bytedance.apm.i.a).add(r1);     // Catch: Throwable -> L30
        monitor-exit(com.bytedance.apm.i.class);
        com.bytedance.apm.block.k r5 = ((com.bytedance.apm.block.b) r1).d;
        r5.getClass();
        f r6 = new f("StackThread");
        r5.a = r6;
        ThreadMethodProxy.start(r6.a);
        es3.h.z.d(r1);
        es3.h.A = true;
        ((com.bytedance.apm.block.b) r1).b = true;
        if (com.bytedance.apm.d.j() == false) goto L19;
        ps3.b.a(new String[]{"BlockDetector init: "});
    L19:
        if (ActivityLifeObserver.getInstance().isForeground() == true) goto L21;
    L28:
        this.a.getClass();
        ((com.bytedance.apm.block.b) r1).d.q = false;
        return;
    L21:
        if (((com.bytedance.apm.block.b) r1).b == false) goto L28;
        if (((com.bytedance.apm.block.b) r1).c == true) goto L28;
        ((com.bytedance.apm.block.b) r1).c = true;
        if (com.bytedance.apm.d.j() == false) goto L28;
        ps3.b.a(new String[]{"BlockDetector start: "});
    L30:
        th = move-exception;
        throw th;
    }

    public final void e() {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        r0.put("init", com.bytedance.apm.d.d);     // Catch: JSONException -> L4
        r0.put("init_finish", com.bytedance.apm.d.e);     // Catch: JSONException -> L4
        r0.put("init_step2", com.bytedance.apm.d.z);     // Catch: JSONException -> L4
        r0.put("init_step3", com.bytedance.apm.d.A);     // Catch: JSONException -> L4
        r0.put("init_step4", com.bytedance.apm.d.B);     // Catch: JSONException -> L4
        r0.put("init_step5", com.bytedance.apm.d.C);     // Catch: JSONException -> L4
        r0.put("start", com.bytedance.apm.d.f);     // Catch: JSONException -> L4
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L4
        r1.put("is_main_process", this.i);     // Catch: JSONException -> L4
        ApmAgent.monitorEvent("apm_cost", r1, r0, null);     // Catch: JSONException -> L4
        return;
    }

    public final void g() {
        h r0 = h.a.a;
        System.currentTimeMillis();
        Context r1 = com.bytedance.apm.d.a;
        gs3.d r2 = this.b.v;
        monitor-enter(com.bytedance.apm.d.class);
        com.bytedance.apm.d.y = r2;     // Catch: Throwable -> L138
        monitor-exit(com.bytedance.apm.d.class);
        this.b.getClass();
        List r3 = nu3.b.a;
        if (com.bytedance.apm.util.k.b(this.b.a) == false) goto L12;
        if (com.bytedance.apm.util.k.b(this.m) == true) goto L12;
        this.b.a = this.m;
    L12:
        if (com.bytedance.apm.util.k.b(this.b.b) == false) goto L17;
        if (com.bytedance.apm.util.k.b(this.n) == true) goto L17;
        this.b.b = this.n;
    L17:
        if (com.bytedance.apm.util.k.b(this.b.c) == true) goto L19;
    L21:
        zs3.c.a = new ys3.a();
        com.bytedance.apm.k r4 = com.bytedance.apm.k.b.a;
        r4.a = new e();
        Object r5 = f27.d.f;
        f27.d.a.a.e = new com.bytedance.apm.j(r4);
        com.bytedance.apm.d.n(this.b.t);
        com.bytedance.apm.d.m(this.b.u);
        ApmStartConfig r6 = this.b;
        IHttpService r7 = r6.w;
        if (r7 == null) goto L24;
        com.bytedance.apm.d.j = r7;
    L24:
        com.bytedance.apm.d.k = r6.F;
        com.bytedance.apm.d.v = r6.a;
        com.bytedance.apm.d.w = r6.D;
        this.d = r6.C;
        this.j = r6.x;
        int r8 = iu3.d.h;
        iu3.d.a.a.getClass();
        e r9 = e.a.a;
        r9.c();
        r9.d();
        r9.a();
        r9.b();
        if (this.i == false) goto L27;
        g r10 = new g();
        this.b.getClass();
        r10.b();
    L27:
        ApmStartConfig r11 = this.b;
        k.y = r11.E;
        yt3.a r12 = yt3.a.e;
        yt3.c r13 = yt3.c.o;
        if (r11.h == true) goto L30;
    L32:
        rs3.b r14 = rs3.b.a();
        os3.a r15 = this.b.A;
        r14.getClass();
        if (r15 != null) goto L145;
    L37:
        is3.a.h().f();
        is3.d r16 = is3.d.a.a;
        r16.f();
        r16.t = this.b.s;
        com.bytedance.apm.d.getContext();
        tr3.e r17 = this.a.q;
        if (tr3.b.a != null) goto L157;
        tr3.b.a = r17;
    L157:
    L48:
        th = move-exception;
        th.printStackTrace();
    L50:
        long r18 = this.b.y;
        f r19 = new f(this);
        if (r18 > 0) goto L53;
        bt3.b.d.a.e(r19);
    L55:
        if (com.bytedance.apm.d.j() == true) goto L58;
    L58:
        if (this.i == false) goto L63;
        h r20 = h.a.a;
        String r21 = r20.a.getString("update_version_code", null);
        String r22 = com.bytedance.apm.d.g.optString("update_version_code");
        if (TextUtils.equals(r21, r22) == true) goto L62;
        com.bytedance.apm.d.m = 1;
        r20.a.edit().putString("update_version_code", r22).apply();
        goto L63
    L62:
        com.bytedance.apm.d.m = 2;
    L63:
        Context r23 = com.bytedance.apm.d.getContext();
        Set<i> r24 = this.j;
        if (r24 == null) goto L73;
        Iterator<i> r25 = r24.iterator();
    L68:
        if (r25.hasNext() == false) goto L73;
        r25.next().init(r23);     // Catch: Throwable -> L72
    L73:
        l r26 = new l();
        r26.a = this.b.b;
        Set<i> r28 = this.j;
        if (r28 == null) goto L83;
        Iterator<i> r29 = r28.iterator();
    L78:
        if (r29.hasNext() == false) goto L83;
        r29.next().notifyParams(r26);     // Catch: Throwable -> L82
    L83:
        Set<i> r30 = this.j;
        if (r30 == null) goto L93;
        Iterator<i> r31 = r30.iterator();
    L88:
        if (r31.hasNext() == false) goto L93;
        r31.next().start();     // Catch: Throwable -> L92
    L93:
        bt3.b.d.a.d(this.b.B);
        ApmStartConfig r32 = this.b;
        List r33 = r32.b;
        if (com.bytedance.apm.util.k.b(r33) == true) goto L109;
        int r34 = 0;
        String r35 = new URL((String) ListProtector.get(r33, 0)).getHost();     // Catch: MalformedURLException -> L141
        xs3.a.a = "https://" + r35 + "/monitor/collect/c/logcollect";     // Catch: MalformedURLException -> L141
        xs3.a.c = r35;     // Catch: MalformedURLException -> L141
        xs3.a.b(r35);     // Catch: MalformedURLException -> L141
        ur3.a.a = "https://" + r35 + "/monitor/collect/c/logcollect";     // Catch: MalformedURLException -> L141
    L97:
        ArrayList r36 = new ArrayList(2);
        int r37 = r33.size();
    L98:
        if (r34 >= r37) goto L105;
        String r38 = new URL((String) ListProtector.get(r33, r34)).getHost();     // Catch: Exception -> L142
        if (TextUtils.isEmpty(r38) == true) goto L104;
        if (r38.indexOf(46) <= 0) goto L104;
        r36.add("https://" + r38 + "/monitor/collect/batch/");     // Catch: Exception -> L142
    L104:
        r34 = r34 + 1;
        goto L98
    L105:
        com.bytedance.apm6.consumer.slardar.send.d r39 = com.bytedance.apm6.consumer.slardar.send.d.a.a;
        r39.getClass();
        if (xu3.e.b(r36) == true) goto L109;
        ((ArrayList) r39.f).clear();
        ((ArrayList) r39.f).addAll(r36);
    L109:
        com.bytedance.apm6.consumer.slardar.send.d r40 = com.bytedance.apm6.consumer.slardar.send.d.a.a;
        List r41 = fs3.a.c;
        r40.getClass();
        if (xu3.e.b(r41) == true) goto L113;
        ((ArrayList) r40.g).clear();
        ((ArrayList) r40.g).addAll(r41);
    L113:
        List r42 = fs3.a.d;
        if (xu3.e.b(r42) == true) goto L117;
        ((ArrayList) r40.h).clear();
        ((ArrayList) r40.h).addAll(r42);
    L117:
        List r43 = r32.c;
        if (xu3.e.b(r43) == true) goto L121;
        ((ArrayList) r40.h).clear();
        ((ArrayList) r40.h).addAll(r43);
    L121:
        List r44 = r32.d;
        if (com.bytedance.apm.util.k.b(r44) == false) goto L124;
    L127:
        os3.b r45 = this.b.z;
        this.c = r45;
        if (r45 == null) goto L130;
        r45.onStartComplete();
    L130:
        AutoLaunchTraceHelper.reportStats();
        ServiceManager.registerService(IHttpService.class, new 7(this));
        if (com.bytedance.apm.d.j() == false) goto L175;
        DoctorManager r46 = DoctorManager.getInstance();
        if (this.i == false) goto L135;
        String r47 = "APM_START";
    L136:
        r46.b(r47, this.b.toString());
        return;
    L135:
        r47 = "APM_START_OTHER_PROCESS";
        goto L136
    L175:
        return;
    L124:
        if (xu3.e.b(r44) == true) goto L127;
        ((ArrayList) r40.g).clear();
        ((ArrayList) r40.g).addAll(r44);
        goto L127
    L53:
        bt3.b.d.a.g(r19, r18 * 1000);
        goto L55
    L41:
        if (z.a != null) goto L43;
        String r48 = XmlPullParser.NO_NAMESPACE;
    L45:
        if (TextUtils.isEmpty(r48) == true) goto L50;
        com.bytedance.apm.d.g.put("bytrace_id", r48);     // Catch: Throwable -> L48
        com.bytedance.apm.d.g.put("pid", String.valueOf(Process.myPid()));     // Catch: Throwable -> L48
        goto L50
    L43:
        r48 = com.bytedance.crash.dumper.c.b().d;     // Catch: Throwable -> L48
        goto L45
    L145:
        r14.a.add(r15);     // Catch: Throwable -> L36
        goto L37
    L30:
        if (r11.i == true) goto L32;
        d();
        goto L32
    L19:
        if (com.bytedance.apm.util.k.b(this.o) == true) goto L21;
        this.b.c = this.o;
    L138:
        th = move-exception;
        throw th;
    }

    public ApmDelegate() {
        this.k = false;
        this.l = true;
    }

    public final boolean b(String r2) {
        if (this.f == false) goto L9;
        SlardarConfigManagerImpl r0 = this.e;
        if (r0 != null) goto L8;
        return false;
    L8:
        return r0.getLogTypeSwitch(r2);
    L9:
        return false;
    }

    public final void f(ApmStartConfig r4) {
        if (this.g == false) goto L19;
        if (r4 == null) goto L17;
        if (this.h == false) goto L8;
        return;
    L8:
        bt3.b r0 = bt3.b.d.a;
        r0.b = true;
        if (r0.f.isEmpty() == true) goto L12;
        r0.h(r0.d);
        r0.f(r0.d);
    L12:
        if (r0.g.isEmpty() == true) goto L14;
        r0.h(r0.e);
        r0.f(r0.e);
    L14:
        this.h = true;
        this.b = r4;
        r0.e(new d(this));
        return;
    L17:
        throw new IllegalArgumentException("startConfig must not be allowed");
    L19:
        throw new IllegalArgumentException("You must call Apm.getInstance().init() on Application.onCreate from version 5.x.x, pls call init() before start().");
    }

    public final void c(Context r11, b r12) {
        if (this.g == true) goto L59;
        long r0 = System.nanoTime();
        this.g = true;
        com.bytedance.apm.d.h();
        com.bytedance.apm.d.p = System.currentTimeMillis();
        System.currentTimeMillis();
        SystemClock.uptimeMillis();
        this.a = r12;
        int r3 = m.a;
        hs3.a.e = EventsUtils.FEAT_TYPE_SHUT_DOWN;
        hs3.a.f = false;
        boolean r4 = jt3.a.a;
        monitor-enter(jt3.a.class);
        jt3.a.e = false;     // Catch: Throwable -> L56
        monitor-exit(jt3.a.class);
        if (r11 != null) goto L11;
        Application r5 = null;
    L15:
        if (r5 == null) goto L18;
        com.bytedance.apm.d.a = r5;
    L18:
        ActivityLifeObserver.init(r5);
        com.bytedance.apm.d.z = System.nanoTime() - r0;
        SlardarConfigManagerImpl r6 = new SlardarConfigManagerImpl();
        this.e = r6;
        r6.registerConfigListener(this);
        ServiceManager.registerService(IConfigManager.class, this.e);
        ServiceManager.registerService(IApmAgent.class, new a());
        ServiceManager.registerService(ILaunchTrace.class, new b());
        ServiceManager.registerService(ff7.j.class, new c());
        ServiceManager.registerService(ff7.k.class, new d());
        if (com.bytedance.apm.d.j() == false) goto L22;
        DoctorManager.getInstance().registerApmListener(new f());
    L22:
        com.bytedance.apm.d.A = System.nanoTime() - r0;
        com.bytedance.apm.d.q = r12.j;
        this.i = com.bytedance.apm.d.k();
        com.bytedance.apm6.hub.k r7 = it3.c.a(r11);
        com.bytedance.apm.d.B = System.nanoTime() - r0;
        bt3.b.d.a.e(new b(this, r12, r11, r7));
        com.bytedance.apm.d.C = System.nanoTime() - r0;
        if (this.i == false) goto L49;
        com.bytedance.apm.config.a r13 = this.a.i;
        us3.e r8 = us3.e.g;
        if (r5 == null) goto L34;
        if (r13 == null) goto L34;
        if (us3.e.h == true) goto L34;
        us3.e.h = true;
        us3.e r9 = us3.e.g;
        r9.d = r13;
        r9.e = r13.b;
        long r10 = System.currentTimeMillis();
        r9.a = new Handler(Looper.getMainLooper());
        r9.b = new ReferenceQueue();
        r9.c = new CopyOnWriteArraySet();
        r5.registerActivityLifecycleCallbacks(new us3.a());
        if (com.bytedance.apm.d.j() == false) goto L34;
        ps3.b.a(new String[]{"initActivityLeakCheck done, cost: " + (System.currentTimeMillis() - r10) + " ms."});
    L34:
        if (r12.a == false) goto L36;
        ff7.c r14 = new ct3.c();
        ((ct3.c) r14).f = r12.b;
        ((ct3.c) r14).g = true;
        ActivityLifeObserver.getInstance().register(r14);
    L36:
        AutoPageTraceHelper.setMaxValidTimeMs(r12.b);
        AutoLaunchTraceHelper.setMaxValidTimeMs(15000);
        p = r12.d;
        q = r12.c;
        es3.e.e = r12.g;
        boolean r15 = r12.f;
        es3.h r2 = es3.h.z;
        r2.g();
        r2.e = false;
        r2.u = r12.n;
        r2.v = false;
        r2.w = r12.o;
        r2.x = 0;
        b27.j.b = this.a.p;
        if (r15 == false) goto L44;
        es3.e r16 = new es3.e();
        et3.h.k = r16;
        a47.a.i = new c(r16);
        if (Build.VERSION.SDK_INT >= 24) goto L41;
    L42:
        r2.d(r16);
    L43:
        es3.h.B = r16;
        goto L44
    L41:
        if (this.a.o == true) goto L43;
    L44:
        initEvilMethodTraceInject();
        com.bytedance.apm.launch.evil.b.a();
        ns3.a r17 = ns3.a.a.a;
        if (r12.l != null) goto L47;
        r12.l = new ns3.c(false, false, false);
    L47:
        r17.b(r12.l);
        com.bytedance.apm.d.d = System.nanoTime() - r0;
        com.bytedance.apm.d.s = r12.k;
        com.bytedance.apm.d.t = r12.m;
    L49:
        if (com.bytedance.apm.d.j() == false) goto L55;
        DoctorManager r18 = DoctorManager.getInstance();
        if (this.i == false) goto L53;
        String r19 = "APM_INIT";
    L54:
        r18.b(r19, r12.toString());
        goto L55
    L53:
        r19 = "APM_INIT_OTHER_PROCESS";
    L55:
        com.bytedance.apm.d.e = System.nanoTime() - r0;
        return;
    L11:
        if ((r11 instanceof Application) == false) goto L13;
        Context r20 = r11;
    L14:
        r5 = (Application) r20;
        goto L15
    L13:
        r20 = r11.getApplicationContext();
    L56:
        th = move-exception;
        throw th;
    }

    public final void onRefresh(JSONObject r2, boolean r3) {
        JSONObject r4 = r2.optJSONObject("general");
        if (r4 == null) goto L5;
        this.l = r4.optBoolean("enable_active_upload_alog", true);
        return;
    L5:
        this.l = true;
    }
}
