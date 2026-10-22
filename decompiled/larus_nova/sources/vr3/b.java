package vr3;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import bs3.l;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.agent.v2.instrumentation.BatteryAgent;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.o;
import com.bytedance.apm.util.t;
import com.bytedance.crash.Npth;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends ss3.a implements ds3.a.InterfaceC5704a {
    public static final Object C = null;
    public final c A;
    public final d B;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, l> f556810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f556811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f556812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f556813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile long f556814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile long f556815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile long f556816m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<String> f556817n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f556818o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public volatile boolean f556819p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f556820q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f556821r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String[] f556822s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final List<String> f556823t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f556824u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap<Integer, t> f556825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap<Integer, t> f556826w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f556827x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final HashMap<String, Integer> f556828y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f556829z;

    /* JADX INFO: loaded from: classes14.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f556830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f556831b;

        public final void a() {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                java.lang.String r0 = "ChargingStatusChange:"
                java.lang.Object r1 = vr3.b.C
                monitor-enter(r1)
                boolean r2 = com.bytedance.apm.d.j()     // Catch: java.lang.Throwable -> L48
                r3 = 0
                if (r2 == 0) goto L22
                r2 = 1
                java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L48
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L48
                r4.<init>(r0)     // Catch: java.lang.Throwable -> L48
                boolean r0 = r5.f556830a     // Catch: java.lang.Throwable -> L48
                r4.append(r0)     // Catch: java.lang.Throwable -> L48
                java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L48
                r2[r3] = r0     // Catch: java.lang.Throwable -> L48
                ps3.b.a(r2)     // Catch: java.lang.Throwable -> L48
            L22:
                vr3.b r0 = r5.f556831b     // Catch: java.lang.Throwable -> L48
                boolean r0 = r0.l(r3)     // Catch: java.lang.Throwable -> L48
                vr3.b r2 = r5.f556831b     // Catch: java.lang.Throwable -> L48
                java.util.Map<java.lang.String, bs3.l> r2 = r2.f556810g     // Catch: java.lang.Throwable -> L48
                java.util.concurrent.ConcurrentHashMap r2 = (java.util.concurrent.ConcurrentHashMap) r2     // Catch: java.lang.Throwable -> L48
                java.util.Collection r2 = r2.values()     // Catch: java.lang.Throwable -> L48
                java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L48
            L36:
                boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L48
                if (r3 == 0) goto L4e
                java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L48
                bs3.l r3 = (bs3.l) r3     // Catch: java.lang.Throwable -> L48
                boolean r4 = r5.f556830a     // Catch: java.lang.Throwable -> L48
                r3.c(r4, r0)     // Catch: java.lang.Throwable -> L48
                goto L36
            L48:
                r0 = move-exception
                java.lang.String r2 = "ChargingStatusChange"
                com.bytedance.services.apm.api.EnsureManager.ensureNotReachHere(r0, r2)     // Catch: java.lang.Throwable -> L56
            L4e:
                vr3.b r0 = r5.f556831b     // Catch: java.lang.Throwable -> L56
                boolean r2 = r5.f556830a     // Catch: java.lang.Throwable -> L56
                r0.f556829z = r2     // Catch: java.lang.Throwable -> L56
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
                return
            L56:
                r0 = move-exception
                monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: vr3.b.a.a():void");
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

        public a(b r100, boolean r101) {
            this.f556831b = r100;
            this.f556830a = r101;
        }
    }

    /* JADX INFO: renamed from: vr3.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class RunnableC8034b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f556832a;

        public final void a() {
            Object r100 = b.C;
            monitor-enter(r100);
            boolean r101 = false;
            if (com.bytedance.apm.d.j() == false) goto L7;
            ps3.b.a(new String[]{"onTimer record, current is background? : " + ActivityLifeObserver.getInstance().isForeground()});     // Catch: Throwable -> L26
        L7:
            boolean r102 = this.f556832a.l(true);     // Catch: Throwable -> L26
            Iterator r103 = ((ConcurrentHashMap) this.f556832a.f556810g).values().iterator();     // Catch: Throwable -> L26
        L9:
            if (r103.hasNext() == false) goto L11;
            ((l) r103.next()).b(r102);     // Catch: Throwable -> L26
            goto L9
        L11:
            long r104 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L26
            if (this.f556832a.f556813j == true) goto L14;
        L28:
            monitor-exit(r100);     // Catch: Throwable -> L30
            return;
        L14:
            if ((r104 - this.f556832a.f556816m) <= (this.f556832a.f556815l * 60000)) goto L17;
            r101 = true;
        L17:
            if (com.bytedance.apm.d.k() == false) goto L28;
            if (r101 == false) goto L28;
            as3.b.a.f16095a.i();     // Catch: Throwable -> L22
        L24:
            this.f556832a.f556816m = r104;     // Catch: Throwable -> L26
        L22:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "handleReportAndHandleCache");     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, WidgetCostModule.TYPE_ON_START);     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            throw th;
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

        public RunnableC8034b(b r100) {
            this.f556832a = r100;
        }
    }

    public class c implements f27.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f556833a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f556833a.e();
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public c(b r100) {
            this.f556833a = r100;
        }
    }

    public class d implements f27.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f556834a;

        @Override // java.lang.Runnable
        public final void run() {
            b.i(this.f556834a);     // Catch: Throwable -> L18
            if (this.f556834a.f556812i == false) goto L9;
            if (this.f556834a.f556828y.containsKey("cpu_monitor_thread_front_capture_period") == false) goto L7;
            int r100 = this.f556834a.f556828y.get("cpu_monitor_thread_front_capture_period").intValue();     // Catch: Throwable -> L18
        L12:
            bt3.b r101 = bt3.b.d.f20539a;     // Catch: Throwable -> L18
            d r102 = this.f556834a.B;     // Catch: Throwable -> L18
            long r103 = r100 * 1000;     // Catch: Throwable -> L18
            f27.d r104 = r101.f20532c;     // Catch: Throwable -> L18
            if (r104 == null) goto L23;
            if (r102 == null) goto L24;
            r104.i(r102, r103);     // Catch: Throwable -> L18
            return;
        L24:
            return;
        L23:
            return;
        L7:
            r100 = 5;
            goto L12
        L9:
            if (this.f556834a.f556828y.containsKey("cpu_monitor_thread_background_capture_period") == false) goto L11;
            r100 = this.f556834a.f556828y.get("cpu_monitor_thread_background_capture_period").intValue();     // Catch: Throwable -> L18
            goto L12
        L11:
            r100 = 20;
        L18:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "mUpdateThreadRecordRunnable");
        }

        @Override // f27.g
        public final AsyncTaskType getTaskType() {
            return AsyncTaskType.LIGHT_WEIGHT;
        }

        public d(b r100) {
            this.f556834a = r100;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f556835a = null;

        static {
            f556835a = new b();
        }
    }

    @Override // ss3.a
    public final boolean c() {
        return false;
    }

    static {
        C = new Object();
    }

    @Override // ss3.a
    public final void e() {
        if (Build.VERSION.SDK_INT <= this.f556820q) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        if (((ConcurrentHashMap) this.f556810g).isEmpty() == true) goto L20;
        long r101 = h();
        if (r101 <= 0) goto L17;
        bt3.b r102 = bt3.b.d.f20539a;
        c r103 = this.A;
        f27.d r104 = r102.f20532c;
        if (r104 == null) goto L17;
        if (r103 == null) goto L17;
        r104.i(r103, r101);
    L17:
        as3.b r105 = as3.b.a.f16095a;
        r105.f16092a = ActivityLifeObserver.getInstance().getTopActivityClassName();
        bt3.b.d.f20539a.b(new RunnableC8034b(this));
        return;
    L20:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public final void m() {
        this.f556825v.clear();
        this.f556826w.clear();
        LinkedList<t> r100 = com.bytedance.apm.util.b.h(Process.myPid(), false, 0);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L13;
        Iterator<t> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L14;
        t r102 = r101.next();
        this.f556825v.put(Integer.valueOf(r102.f190684a), r102);
        goto L9
    L14:
        return;
    }

    public b() {
        this.f556810g = new ConcurrentHashMap();
        this.f556811h = -1;
        this.f556813j = false;
        this.f556815l = 30;
        this.f556816m = -1;
        this.f556820q = 32;
        this.f556822s = new String[2];
        this.f556823t = new ArrayList();
        this.f556825v = new HashMap();
        this.f556826w = new HashMap();
        this.f556828y = new HashMap();
        this.A = new c(this);
        this.B = new d(this);
        this.f543336e = Scraps.BATTERY;
    }

    @Override // ss3.a
    public final void d() {
        if (Build.VERSION.SDK_INT <= this.f556820q) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        com.bytedance.apm.d.c();
        this.f556812i = ActivityLifeObserver.getInstance().isForeground();
        this.f556822s[1] = ActivityLifeObserver.getInstance().getTopActivityClassName();
        this.f556827x = com.bytedance.apm.util.b.f();
        this.f556829z = ds3.a.b(com.bytedance.apm.d.getContext(), this);
        bs3.d r101 = new bs3.d();
        bs3.g r102 = new bs3.g();
        bs3.k r103 = new bs3.k();
        zr3.a r104 = new zr3.a();     // Catch: Throwable -> L11
        ((HashMap) r104.f573408a).put("alarm", r101);     // Catch: Throwable -> L11
        ((HashMap) r104.f573408a).put("location", r102);     // Catch: Throwable -> L11
        ((HashMap) r104.f573408a).put(BatteryTypeInf.BATTERY_POWER_LOCK, r103);     // Catch: Throwable -> L11
        r104.b();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f556810g).put("alarm", r101);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f556810g).put("location", r102);     // Catch: Throwable -> L11
        ((ConcurrentHashMap) this.f556810g).put(BatteryTypeInf.BATTERY_POWER_LOCK, r103);     // Catch: Throwable -> L11
    L13:
        bs3.f r105 = new bs3.f();
        bs3.j r106 = new bs3.j();
        bs3.h r107 = new bs3.h();
        bs3.e r108 = new bs3.e();
        ((ConcurrentHashMap) this.f556810g).put(BatteryTypeInf.BATTERY_CPU_ACTIVE, r105);
        ((ConcurrentHashMap) this.f556810g).put("traffic", r106);
        ((ConcurrentHashMap) this.f556810g).put(BatteryTypeInf.BATTERY_PACKETS, r107);
        ((ConcurrentHashMap) this.f556810g).put(BatteryTypeInf.BATTERY_CONSUME, r108);
        this.f556816m = SystemClock.elapsedRealtime();
        return;
    L11:
        th = move-exception;
        th.getMessage();
        goto L13
    L5:
        r100 = false;
        goto L6
    }

    @Override // ss3.a
    public final long h() {
        return this.f556814k * 60000;
    }

    public final boolean k() {
        if (BatteryAgent.hasHook() == false) goto L5;
        return true;
    L5:
        if (this.f556828y.containsKey("monitor_enable") == true) goto L7;
    L9:
        return false;
    L7:
        if (this.f556828y.get("monitor_enable").intValue() != 1) goto L9;
        return true;
    }

    @Override // ss3.a, com.bytedance.services.slardar.config.IConfigListener
    public final void onReady() {
        super.onReady();
        if (com.bytedance.apm.d.k() == true) goto L5;
        return;
    L5:
        if (this.f556813j == false) goto L9;
        as3.b r100 = as3.b.a.f16095a;
        bt3.b.d.f20539a.e(new as3.a(r100));
        this.f556816m = SystemClock.elapsedRealtime();
        return;
    }

    public static void i(b r110) {
        if (r110.f556825v.isEmpty() == true) goto L32;
        LinkedList<t> r100 = com.bytedance.apm.util.b.h(Process.myPid(), false, 0);
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == true) goto L33;
        Iterator<t> r101 = r100.iterator();
    L12:
        if (r101.hasNext() == false) goto L34;
        t r102 = r101.next();
        if (r110.f556825v.containsKey(Integer.valueOf(r102.f190684a)) == false) goto L16;
        long r103 = r102.f190686c - r110.f556825v.get(Integer.valueOf(r102.f190684a)).f190686c;
    L18:
        if (r103 <= 0) goto L12;
        long r104 = (long) ((r103 / r110.f556827x) * 1000.0d);
        if (r110.f556826w.containsKey(Integer.valueOf(r102.f190684a)) == true) goto L21;
        r110.f556826w.put(Integer.valueOf(r102.f190684a), new t(r102.f190684a, r102.f190685b, r104));
        goto L12
    L21:
        r110.f556826w.get(Integer.valueOf(r102.f190684a)).f190686c = r104;
        goto L12
    L16:
        r103 = r102.f190686c;
        goto L18
    L34:
        return;
    L33:
        return;
    }

    public static void j(b r100) {
        if (((ArrayList) r100.f556823t).isEmpty() == false) goto L5;
        r100.f556824u = null;
        return;
    L5:
        Collections.sort(r100.f556823t, new vr3.a());
        r100.f556824u = com.bytedance.apm.util.k.a(((ArrayList) r100.f556823t).toArray());
    }

    @Override // ss3.a
    public final void a(JSONObject r110) {
        this.f556814k = r110.optLong("battery_record_interval", 10);
        this.f556815l = r110.optLong("battery_report_interval", 30);
        int r100 = r110.optInt("enable_upload", 0);
        boolean r101 = true;
        if (r100 == 1) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f556813j = r102;
        this.f556820q = r110.optInt("support_max_api_level", this.f556820q);
        if (com.bytedance.apm.d.j() == false) goto L12;
        ps3.b.a(new String[]{"mRecordInterval:" + this.f556814k + ",mBatteryCollectEnabled" + r100});
    L12:
        if (this.f556813j == true) goto L30;
        if (this.f556818o == true) goto L30;
        ((ConcurrentHashMap) this.f556810g).clear();
        ActivityLifeObserver.getInstance().unregister(this);
        Context r103 = com.bytedance.apm.d.getContext();
        ArrayList r104 = (ArrayList) ds3.a.f469859a;
        r104.remove(this);
        if (r104.isEmpty() == false) goto L33;
        ds3.a.b r105 = ds3.a.f469862d;     // Catch: Throwable -> L54
        ReceiverRegisterLancet.loge(r105, false);     // Catch: Throwable -> L54
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L55;
        r103.unregisterReceiver(r105);     // Catch: Throwable -> L54
        goto L28
    L55:
    L23:
        e = move-exception;
        if (r105 == null) goto L26;
        Npth.addTag("unregisterReceiver", r105.toString());     // Catch: Throwable -> L54
    L26:
        e.printStackTrace();     // Catch: Throwable -> L54
        goto L28
    L20:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r105, r103) == false) goto L28;
        r103.unregisterReceiver(r105);     // Catch: Exception -> L23 Throwable -> L54
    L28:
        ds3.a.f469860b = false;
    L33:
        if (r110.optInt("trace_enable", 0) == 1) goto L36;
        r101 = false;
    L36:
        this.f556819p = r101;
        if (this.f556819p == false) goto L39;
        wr3.a.f560801a = r110.optLong("max_single_wake_lock_hold_time_second", 120) * 1000;
        wr3.a.f560802b = r110.optInt("max_total_wake_lock_acquire_count", 5);
        wr3.a.f560803c = r110.optLong("max_total_wake_lock_hold_time_second", 240) * 1000;
        wr3.a.f560804d = r110.optInt("max_wake_up_alarm_invoke_count", 5);
        wr3.a.f560805e = r110.optInt("max_normal_alarm_invoke_count", 10);
        wr3.a.f560806f = r110.optLong("max_single_loc_request_time_second", 120) * 1000;
        wr3.a.f560807g = r110.optInt("max_total_loc_request_count", 5);
        wr3.a.f560808h = r110.optLong("max_total_loc_request_time_second", 240) * 1000;
    L39:
        JSONObject r106 = r110.optJSONObject("cpu_monitor_config");
        if (r106 == null) goto L50;
        Iterator<String> r107 = r106.keys();
    L43:
        if (r107.hasNext() == false) goto L50;
        String r108 = r107.next();
        if ("monitor_enable".equals(r108) == true) goto L46;
        int r109 = r106.optInt(r108, 0);
        if (r109 <= 0) goto L43;
        this.f556828y.put(r108, Integer.valueOf(r109));
        goto L43
    L46:
        this.f556828y.put(r108, Integer.valueOf(r106.optInt(r108, 0)));
    L50:
        this.f556817n = o.b(r110, "scene_black_list");
        if (k() == false) goto L66;
        bt3.b.d.f20539a.b(this.B);
        m();
        return;
    L66:
        return;
    L30:
        if (r110.optInt("battery_net_for_all_interface_enable", 0) != 1) goto L33;
        ((ConcurrentHashMap) this.f556810g).put(BatteryTypeInf.BATTERY_NET_ALL_INTERFACE, new bs3.i());
        goto L33
    L5:
        if (this.f556814k <= 0) goto L7;
        r102 = true;
        goto L8
    }

    public final boolean l(boolean r210) throws JSONException {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r100 - this.f556811h;
        if (r101 <= 2000) goto L5;
        boolean r110 = true;
    L7:
        if (this.f556811h == (-1)) goto L15;
        if (r110 == false) goto L15;
        as3.b.a.f16095a.g(new ms3.a(this.f556812i, System.currentTimeMillis(), BatteryTypeInf.BATTERY_GROUND_RECORD, this.f556829z, r101, this.f556824u));
        if (this.f556812i == false) goto L15;
        if (r101 <= 7200000) goto L15;
        HashMap r102 = new HashMap();
        r102.put("duration", String.valueOf(r101));
        EnsureManager.ensureNotReachHere("BatterErrorDuration", r102);
    L15:
        if (this.f556811h == (-1)) goto L81;
        if (r210 == false) goto L81;
        if (k() == false) goto L81;
        if (this.f556812i == true) goto L29;
        if (TextUtils.isEmpty(this.f556824u) == false) goto L29;
        if (this.f556828y.containsKey("cpu_monitor_function_background_threshold") == false) goto L27;
        int r103 = this.f556828y.get("cpu_monitor_function_background_threshold").intValue();
    L32:
        Map<String, BatteryAgent.MethodExecutedValue> r104 = BatteryAgent.filterResultAndClear((((long) r103) * r101) / 100);
        if (this.f556812i == false) goto L42;
        if (this.f556828y.containsKey("cpu_monitor_front_valid_duration") == false) goto L37;
        int r105 = this.f556828y.get("cpu_monitor_front_valid_duration").intValue();
    L39:
        if (r101 > (r105 * 1000)) goto L47;
    L48:
        boolean r106 = false;
    L49:
        if (r106 == false) goto L80;
        JSONObject r107 = new JSONObject();
        if (r104 != null) goto L53;
    L59:
        boolean r108 = false;
    L61:
        if (this.f556826w.isEmpty() == true) goto L73;
        ArrayList r109 = new ArrayList(this.f556826w.values());
        Collections.sort(r109, new g());
        JSONArray r111 = new JSONArray();
        if (this.f556828y.containsKey("cpu_monitor_thread_count") == false) goto L65;
        int r112 = this.f556828y.get("cpu_monitor_thread_count").intValue();
    L66:
        int r113 = 0;
    L68:
        if (r113 >= Math.min(r109.size(), r112)) goto L72;
        t r114 = (t) ListProtector.get(r109, r113);
        if (r114.f190686c <= 0) goto L72;
        JSONObject r115 = new JSONObject();
        r113 = r113 + 1;
        r115.putOpt("rank", Integer.valueOf(r113));
        r115.putOpt("thread_name", r114.f190685b);
        r115.putOpt("cpu_cost", Long.valueOf(r114.f190686c));
        r111.put(r115);
    L72:
        r107.putOpt("threads", r111);
        boolean r116 = true;
    L74:
        if (r116 == false) goto L80;
        if (this.f556812i == false) goto L78;
        String r117 = as3.b.a.f16095a.f16092a;
    L79:
        JSONObject r118 = new JSONObject();
        r118.putOpt("scene", r117);
        JSONObject r119 = new JSONObject();
        r119.putOpt("stay_duration", Long.valueOf(r101));
        r107.toString();
        ApmAgent.monitorEvent("monitor_expend_function", r118, r119, r107);
        goto L80
    L78:
        r117 = "background";
        goto L79
    L65:
        r112 = 100;
        goto L66
    L73:
        r116 = r108;
        goto L74
    L53:
        if (r104.isEmpty() == true) goto L59;
        JSONArray r120 = new JSONArray();
        Iterator<Map.Entry<String, BatteryAgent.MethodExecutedValue>> r121 = r104.entrySet().iterator();
    L56:
        if (r121.hasNext() == false) goto L58;
        Map.Entry<String, BatteryAgent.MethodExecutedValue> r122 = r121.next();
        JSONObject r123 = new JSONObject();
        r123.putOpt(com.alipay.sdk.m.p.e.f25671s, r122.getKey());
        r123.putOpt("exe_count", Integer.valueOf(r122.getValue().getCount()));
        r123.putOpt("cpu_cost", Integer.valueOf(r122.getValue().getCost()));
        r120.put(r123);
        goto L56
    L58:
        r107.putOpt("functions", r120);
        r108 = true;
    L80:
        m();
    L47:
        r106 = true;
        goto L49
    L37:
        r105 = 20;
        goto L39
    L42:
        if (this.f556828y.containsKey("cpu_monitor_background_duration") == false) goto L44;
        int r124 = this.f556828y.get("cpu_monitor_background_duration").intValue();
    L46:
        if (r101 <= (r124 * 1000)) goto L48;
    L44:
        r124 = 60;
        goto L46
    L27:
        r103 = 2;
    L29:
        if (this.f556828y.containsKey("cpu_monitor_function_front_threshold") == false) goto L31;
        r103 = this.f556828y.get("cpu_monitor_function_front_threshold").intValue();
        goto L32
    L31:
        r103 = 5;
    L81:
        this.f556811h = r100;
        return r110;
    L5:
        r110 = false;
        goto L7
    }

    @Override // ss3.a, ff7.c
    public final void onActivityResume(Activity r100) {
        String[] r101 = this.f556822s;
        boolean r102 = true;
        r101[0] = r101[1];
        r101[1] = r100.getClass().getName();
        if (TextUtils.equals(r100.getClass().getName(), this.f556821r) == false) goto L5;
    L13:
        this.f556821r = null;
        return;
    L5:
        if (TextUtils.isEmpty(this.f556822s[0]) == true) goto L13;
        String r103 = this.f556822s[0];
        if (Build.VERSION.SDK_INT > this.f556820q) goto L10;
        r102 = false;
    L10:
        if (r102 == true) goto L13;
        as3.b.a.f16095a.f16092a = r103;
        bt3.b.d.f20539a.b(new vr3.e(this));
        goto L13
    }

    @Override // ss3.a, ff7.c
    public final void onBackground(Activity r100) {
        super.onBackground(r100);
        if (Build.VERSION.SDK_INT <= this.f556820q) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        as3.b r102 = as3.b.a.f16095a;
        r102.f16092a = ActivityLifeObserver.getInstance().getTopActivityClassName();
        bt3.b.d.f20539a.b(new f(this));
        return;
    L10:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // ds3.a.InterfaceC5704a
    public final void onChange(boolean r100) {
        if (((ConcurrentHashMap) this.f556810g).isEmpty() == false) goto L5;
        return;
    L5:
        as3.b r101 = as3.b.a.f16095a;
        r101.f16092a = ActivityLifeObserver.getInstance().getTopActivityClassName();
        bt3.b.d.f20539a.b(new a(this, r100));
    }

    @Override // ss3.a, ff7.c
    public final void onFront(Activity r100) {
        super.onFront(r100);
        this.f556821r = r100.getClass().getName();
        String r101 = ActivityLifeObserver.getInstance().getTopActivityClassName();
        if (Build.VERSION.SDK_INT <= this.f556820q) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        as3.b.a.f16095a.f16092a = r101;
        bt3.b.d.f20539a.b(new vr3.e(this));
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
