package x64;

import android.os.SystemClock;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.o0;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.badger.utils.n;
import com.bytedance.badger.v.w;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.UInt;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile com.bytedance.badger.C.b f562608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f562609b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f562610c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f562611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AtomicReference f562612e = null;

    static {
        f562608a = com.bytedance.badger.C.b.f199023a;
        f562609b = new ConcurrentHashMap();
        f562610c = new ConcurrentHashMap();
        f562612e = new AtomicReference(null);
    }

    public static void c() {
        BadgerCore.Companion.getClass();
        String r100 = com.bytedance.badger.j.a().getDeviceId();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, new C10462c("update# deviceId is blank", SpeechEngineDefines.ERR_AUTHENTICATION_FAILED, null, null, 12), 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.c.f570473a, 4092);
        return;
    L9:
        int r102 = n.f199273a;
        z64.f r110 = new z64.f(UInt.m9590toStringimpl(UInt.m9544constructorimpl(n.a(r100.getBytes(Charsets.UTF_8)))), r100, System.currentTimeMillis(), null, 48);
        TriggerStage r103 = TriggerStage.login;
        l r111 = new l(r103, r110.f570466b, false, null, null, null, 60);
        int r104 = r103.ordinal();
        if (r104 == 0) goto L14;
        if (r104 == 1) goto L13;
        String r105 = "init_timestamp";
    L15:
        ConcurrentHashMap r106 = f562610c;
        Object r107 = r106.get(r105);
        if (r107 != null) goto L21;
        r107 = new Object();
        Object r108 = r106.putIfAbsent(r105, r107);
        if (r108 == null) goto L21;
        r107 = r108;
    L21:
        monitor-enter(r107);
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L33
        com.bytedance.badger.v.k r109 = com.bytedance.badger.v.d.T;     // Catch: Throwable -> L33
        KProperty r112 = com.bytedance.badger.v.d.f199311a[46];     // Catch: Throwable -> L33
        if (b(r105, ((Number) r109.a()).longValue(), r111, r110, 0, "login") == true) goto L29;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r103, new C10462c("update freq", -1105, null, null, 12), 0, null, 0, 0, 0, r110, null, false, 0, null, z64.h.c.f570473a, 3964);     // Catch: Throwable -> L33
        com.bytedance.badger.e.g("ReportManager", "freq, stage=" + r103);     // Catch: Throwable -> L33
        monitor-exit(r107);
        return;
    L29:
        f562609b.put(r105, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L33
        monitor-exit(r107);
        long r113 = System.currentTimeMillis();
        z0 r114 = d0.f199093a;
        d0.b(17, z64.h.c.f570473a, new a(r110, r113), true);
        return;
    L33:
        th = move-exception;
        throw th;
    L13:
        r105 = "login_timestamp";
        goto L15
    L14:
        r105 = "login_finished_timestamp";
        goto L15
    L5:
        r101 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21, types: [z64.c] */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r2v18, types: [b74.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void a(l r210, b74.b r211) {
        BadgerCore.Companion.getClass();
        if (com.bytedance.badger.j.a().isInitialized() == true) goto L6;
        com.bytedance.badger.e.g("ReportManager", "reportUnified# - not initialized");
        return;
    L6:
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == false) goto L123;
        com.bytedance.badger.v.f r100 = com.bytedance.badger.v.d.f199328l;
        KProperty r101 = com.bytedance.badger.v.d.f199311a[11];
        if (((Boolean) r100.a()).booleanValue() == false) goto L123;
        if (r210.f562628a == TriggerStage.periodic) goto L14;
    L17:
        int r102 = r210.f562628a.ordinal();
        if (r102 == 0) goto L22;
        if (r102 == 1) goto L21;
        String r103 = "init_timestamp";
    L23:
        Map r104 = i.f562627a;
        j r105 = (j) i.f562627a.get(r210.f562628a);
        if (r105 != null) goto L27;
        r105 = c.f562613a;
    L27:
        h r106 = r105.b();
        if (r106.f562619a <= 0) goto L130;
        com.bytedance.badger.e.f("ReportManager", "first report# triggerStage=" + r210.f562628a + ",sleep time=" + r106.f562619a + "ms");
        Thread.sleep(r106.f562619a);     // Catch: InterruptedException -> L125
    L130:
        z64.c r107 = r105.a(r210);     // Catch: Exception -> L120
        com.bytedance.badger.e.f("ReportManager", "start report#, triggerStage=" + r210.f562628a + " request=" + r107 + ", key=" + r103 + " triggerPath=" + r210.f562632e);
        C10462c r110 = null;
        if (r210.f562630c == false) goto L59;
        com.bytedance.badger.e.f("ReportManager", "first report# triggerStage=" + r210.f562628a + ",check timeout threshold~~~");
        BadgerCore.Companion.getClass();
        z64.a r108 = com.bytedance.badger.j.a().getBadgerExtraParams();
        if (r108 == null) goto L37;
        Long r109 = Long.valueOf(r108.f570453b);
    L38:
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.g r111 = com.bytedance.badger.v.d.B;
        KProperty r112 = com.bytedance.badger.v.d.f199311a[28];
        long r113 = ((w) r111.a()).a();
        long r114 = System.currentTimeMillis();
        if (r109 == null) goto L52;
        boolean r115 = false;
        if (r109.longValue() <= 0) goto L43;
        boolean r116 = true;
    L44:
        if (r116 == true) goto L47;
        r109 = null;
    L47:
        if (r109 == null) goto L52;
        long r117 = r114 - r109.longValue();
        if (r117 >= r113) goto L54;
        if (r117 >= 0) goto L52;
    L54:
        if (r113 <= 0) goto L58;
        if (r115 == true) goto L58;
        f562611d = true;
        com.bytedance.badger.e.g("ReportManager", "first report# boot threshold exceeded, skip first report");
        C10462c r118 = new C10462c("sdkStartTime not within threshold", SpeechEngineDefines.ERR_LICENSE_SUBFUNC_MISSING, null, null, 12);
        int r119 = (int) r106.f562621c;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r210.f562628a, r118, 0, null, r119, SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime(), SystemClock.uptimeMillis() - SystemClock.uptimeMillis(), r107, null, false, new AtomicLong(0).get(), r210.f562631d, null, 4364);
        b74.e.f17952f.b(r210.f562628a, r107, r118);
        return;
    L58:
        f562611d = true;
        com.bytedance.badger.e.g("ReportManager", "first report# allow report");
        goto L59
    L43:
        r116 = false;
    L52:
        r115 = true;
        goto L54
    L37:
        r109 = null;
    L59:
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r120 = com.bytedance.badger.v.d.f199335s;
        Object[] r121 = com.bytedance.badger.v.d.f199311a;
        Object r122 = r121[19];
        if (((Boolean) r120.a()).booleanValue() == true) goto L66;
        BadgerCore.Companion.getClass();
        if (com.bytedance.badger.j.a().isAppInForeground() == true) goto L66;
        com.bytedance.badger.e.g("ReportManager", "not in foreground, ctx " + r210);
        C10462c r123 = new C10462c("Badger not in foreground", SpeechEngineDefines.ERR_UNSUPPORT_AUTHENTICATE_TYPE, null, null, 12);
        int r124 = (int) r106.f562621c;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r210.f562628a, r123, 0, null, r124, SystemClock.elapsedRealtime() - SystemClock.elapsedRealtime(), SystemClock.uptimeMillis() - SystemClock.uptimeMillis(), r107, null, false, new AtomicLong(0).get(), r210.f562631d, null, 4364);
        b74.e.f17952f.b(r210.f562628a, r107, r123);
        return;
    L66:
        if (StringsKt.isBlank(r107.getDeviceId()) == false) goto L70;
        int r125 = (int) r106.f562621c;
        TriggerStage r126 = r210.f562628a;
        com.bytedance.badger.C.a r127 = r210.f562631d;
        long r128 = SystemClock.elapsedRealtime();
        long r129 = SystemClock.uptimeMillis();
        AtomicLong r130 = new AtomicLong(0);
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r126, new C10462c("deviceId is blank", SpeechEngineDefines.ERR_AUTHENTICATION_FAILED, null, null, 12), 0, null, r125, SystemClock.elapsedRealtime() - r128, SystemClock.uptimeMillis() - r129, r107, null, false, r130.get(), r127, null, 4364);
        return;
    L70:
        if (r106.f562622d == false) goto L94;
        z64.c r131 = r107;
        if (b(r103, r106.f562620b, r210, r107, (int) r106.f562621c, "pre-lock") == true) goto L75;
        return;
    L75:
        if (r210.f562628a != TriggerStage.periodic) goto L95;
        ConcurrentHashMap r132 = f562610c;
        Object r133 = r132.get(r103);
        if (r133 != null) goto L82;
        r133 = new Object();
        Object r134 = r132.putIfAbsent(r103, r133);
        if (r134 == null) goto L82;
        Object r135 = r134;
    L83:
        monitor-enter(r135);
    L91:
        th = move-exception;
        throw th;
    L85:
        if (b(r103, r106.f562620b, r210, r131, (int) r106.f562621c, "in-lock") == true) goto L88;
        monitor-exit(r135);
        return;
    L88:
        f562609b.put(r103, Long.valueOf(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L91
        monitor-exit(r135);
    L96:
        com.bytedance.badger.e.f("ReportManager", "check finish, start report: triggerStage=" + r210.f562628a + ",update timestamp map=" + f562609b);
        int r136 = (int) r106.f562621c;
        com.bytedance.badger.v.f r137 = com.bytedance.badger.v.d.f199334r;     // Catch: Throwable -> L106
        Object r138 = r121[18];     // Catch: Throwable -> L106
        if (((Boolean) r137.a()).booleanValue() == false) goto L104;
        com.bytedance.badger.e.f("ReportManager", "enable pre login report...");     // Catch: Throwable -> L106
        r138 = r131;
        o0.f199132a.i(r131, r136, r210.f562628a, true, r210.f562631d, r211);     // Catch: Throwable -> L102
    L132:
        return;
    L104:
        z64.c r139 = r131;
        com.bytedance.badger.e.f("ReportManager", "enable collect full report...");     // Catch: Throwable -> L102
        o0.f199132a.h(r139, r136, r210.f562628a, r106.f562623e, r210.f562631d, r211);     // Catch: Throwable -> L102
        r138 = r139;
    L102:
        th = th;
        ?? r140 = r138;
    L109:
        if ((th instanceof C10462c) == false) goto L112;
        r110 = th;
    L112:
        C10462c r141 = r110;
        if (r141 != null) goto L115;
        return;
    L115:
        if (r141.c() != (-1104)) goto L117;
    L118:
        b74.e.f17952f.b(r210.f562628a, r140, r141);
        return;
    L117:
        if (r141.c() == (-1103)) goto L118;
        return;
    L106:
        th = th;
        r140 = r131;
    L82:
        r135 = r133;
    L95:
        f562609b.put(r103, Long.valueOf(SystemClock.elapsedRealtime()));
        goto L96
    L94:
        r131 = r107;
    L120:
        e = move-exception;
        com.bytedance.badger.e.c("ReportManager", "build request#, triggerStage=" + r210.f562628a, e);
        return;
    L21:
        r103 = "login_timestamp";
        goto L23
    L22:
        r103 = "login_finished_timestamp";
        goto L23
    L14:
        if (f562611d == true) goto L17;
        com.bytedance.badger.e.g("ReportManager", "reportUnified# - first report not ready. stage=" + r210.f562628a);
        return;
    L123:
        com.bytedance.badger.e.b("ReportManager", "reportUnified# - not enabled");
    }

    public static boolean b(String r210, long r211, l r310, z64.c r311, int r312, String r313) {
        long r100 = SystemClock.elapsedRealtime();
        Long r101 = (Long) f562609b.get(r210);
        if (r101 != null) goto L6;
        r101 = 0L;
    L6:
        long r102 = r101.longValue();
        long r103 = r100 - r102;
        if (r102 != 0) goto L9;
        return true;
    L9:
        if (r103 >= r211) goto L14;
        com.bytedance.badger.e.g("ReportManager", "freq check# hit freq control." + r313 + " paht=" + r310.f562632e + ", key=" + r210 + ", since=" + r103 + "ms, interval=" + r211 + "ms");
        TriggerStage r110 = r310.f562628a;
        com.bytedance.badger.C.a r104 = r310.f562631d;
        long r105 = SystemClock.elapsedRealtime();
        long r106 = SystemClock.uptimeMillis();
        AtomicLong r107 = new AtomicLong(0);
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, r110, new C10462c("report interval not satisfied, return", -1105, null, null, 12), 0, null, r312, SystemClock.elapsedRealtime() - r105, SystemClock.uptimeMillis() - r106, r311, null, false, r107.get(), r104, null, 4364);
        return false;
    L14:
        return true;
    }
}
