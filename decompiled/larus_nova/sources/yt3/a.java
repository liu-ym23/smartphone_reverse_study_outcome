package yt3;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Pair;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xu3.e;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f569045e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zt3.a f569046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f569047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f569048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C8380a f569049d;

    /* JADX INFO: renamed from: yt3.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class C8380a extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f569050d;

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
        public final void a() {
            long r100 = System.currentTimeMillis();
            if (xu3.a.a() == false) goto L5;
            av3.b.a("APM-Disk", "startCollect:");
        L5:
            SharedPreferences r101 = xu3.a.getContext().getSharedPreferences("monitor_config", 0);
            if (r101 == null) goto L8;
            long r102 = r101.getLong("check_disk_last_time", 0);
        L9:
            long r110 = System.currentTimeMillis() - r102;
            if (xu3.a.a() == false) goto L13;
            av3.b.a("APM-Disk", "durationMs:" + r110);
        L13:
            if (r110 < 86400000) goto L131;
            c r103 = c.f569064o;
            zt3.a r111 = this.f569050d.f569046a;
            b r112 = null;
            if (r111 != null) goto L18;
        L19:
            long r210 = r100;
            SharedPreferences r113 = r101;
            String r211 = "APM-Disk";
            String r114 = "check_disk_last_time";
        L127:
            if (xu3.a.a() == false) goto L129;
            String r104 = r211;
            av3.b.a(r104, "durationMs:" + r112.a());
        L130:
            nu3.b.a(r112);
            r113.edit().putLong(r114, System.currentTimeMillis()).commit();
        L132:
            cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f569050d.f569049d);
            if (xu3.a.a() == false) goto L170;
            av3.b.a(r104, "collect end and cost time:" + (System.currentTimeMillis() - r210));
            return;
        L170:
            return;
        L129:
            r104 = r211;
            goto L130
        L18:
            if (r103.f569069e == true) goto L19;
            r103.f569074j = r111;
            if (r103.f569073i == true) goto L33;
            r103.f569073i = true;
            Application r115 = xu3.a.getContext();
            r115.getPackageName();     // Catch: Exception -> L32
            r103.f569065a = r115.getFilesDir().getParent();     // Catch: Exception -> L32
            r103.f569066b = r115.getCacheDir().getAbsolutePath();     // Catch: Exception -> L32
            String r116 = r115.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L27
        L28:
            r103.f569067c = r116;     // Catch: Exception -> L32
            File r117 = r115.getExternalCacheDir();     // Catch: Exception -> L32
            if (r117 == null) goto L33;
            r103.f569068d = r117.getAbsolutePath();     // Catch: Exception -> L32
        L27:
            r116 = null;
        L32:
            r103.f569069e = true;
        L33:
            r103.f569070f = r103.n(r111.f573578j);
            r103.f569071g = r103.n(r111.f573577i);
            r103.f569072h = r103.n(r111.f573579k);
            ArrayList r118 = new ArrayList();
            File[] r119 = new PolarisFileWrapper(r103.f569065a).listFiles();
            if (r119 != null) goto L36;
        L41:
            File[] r120 = new PolarisFileWrapper(r103.f569067c).listFiles();
            if (r120 != null) goto L44;
        L49:
            ArrayList r121 = new ArrayList();
            Iterator r122 = r118.iterator();
        L51:
            if (r122.hasNext() == false) goto L63;
            c.a r123 = (c.a) r122.next();
            Iterator r124 = ((ArrayList) r123.f569084f).iterator();
        L54:
            if (r124.hasNext() == false) goto L59;
            if (((c.a) r124.next()).f569082d == false) goto L54;
            boolean r105 = false;
        L60:
            if (r105 == false) goto L51;
            r121.remove(r123);
            goto L51
        L59:
            r105 = true;
            goto L60
        L63:
            r118.removeAll(r121);
            if (xu3.a.a() == false) goto L69;
            Iterator r106 = r118.iterator();
        L67:
            if (r106.hasNext() == false) goto L69;
            av3.b.a("APM-Disk", "diskInfoNodes:" + ((c.a) r106.next()).b());
        L69:
            v<c.b> r107 = new v(r103.f569074j.f573574f);
            v<c.b> r108 = new v(r103.f569074j.f573575g);
            v<c.b> r125 = new v(r103.f569074j.f573573e);
            ArrayList r126 = new ArrayList();
            r126.add(r103.f569065a);
            r126.add(r103.f569066b);
            ArrayList r212 = r118;
            r103.d(r103.c(r103.f569065a, r107, r108, r125, r126));
            r126.clear();
            r126.add(r103.f569068d);
            r126.add(r103.f569067c);
            r103.d(r103.c(r103.f569067c, r107, r108, r125, r126));
            if (xu3.a.a() == false) goto L85;
            Iterator r127 = ((ArrayList) r107.b()).iterator();
        L73:
            if (r127.hasNext() == false) goto L75;
            av3.b.a("APM-Disk", "fileListTopK:" + ((c.b) r127.next()).b());
            goto L73
        L75:
            Iterator r128 = ((ArrayList) r108.b()).iterator();
        L77:
            if (r128.hasNext() == false) goto L79;
            av3.b.a("APM-Disk", "dirListTopK:" + ((c.b) r128.next()).b());
            goto L77
        L79:
            Iterator r129 = ((ArrayList) r125.b()).iterator();
        L81:
            if (r129.hasNext() == false) goto L83;
            av3.b.a("APM-Disk", "outdatedListTopK:" + ((c.b) r129.next()).b());
            goto L81
        L83:
            av3.b.a("APM-Disk", "insideDataSize:" + r103.f569075k + " outsideDataSize:" + r103.f569076l + " insideCacheSize:" + r103.f569077m + " outsideCacheSize:" + r103.f569078n);
        L85:
            if (e.b(r103.f569071g) == false) goto L87;
        L86:
            v<c.b> r130 = r107;
            List<c.a> r109 = r212;
            long r131 = r103.f569075k + r103.f569076l;     // Catch: Throwable -> L123
            r210 = r100;
            long r132 = r103.f569077m + r103.f569078n;     // Catch: Throwable -> L138
            long r133 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L138
            long r310 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L138
            r114 = "check_disk_last_time";
            long r134 = Math.min(r131, 17179869184L);     // Catch: Throwable -> L120
            long r213 = Math.min(r132, 17179869184L);     // Catch: Throwable -> L120
            if (r134 >= 0) goto L109;
        L108:
            r113 = r101;
            r211 = "APM-Disk";
        L125:
            r112 = null;
            goto L127
        L109:
            Pair r135 = c.j();     // Catch: Throwable -> L120
            long r136 = r103.g();     // Catch: Throwable -> L120
            if (xu3.a.a() == true) goto L139;
        L114:
            r113 = r101;
            r211 = "APM-Disk";
            r112 = new b(r131, r213, r133, r310, r136, ((Long) r135.first).longValue(), ((Long) r135.second).longValue(), (float) new BigDecimal(r136).divide(new BigDecimal(r133), 4, 4).doubleValue(), c.f(r130), c.f(r108), c.f(r125), r103.e(r109, r134));     // Catch: Throwable -> L136
        L121:
            r211 = "APM-Disk";
            goto L125
        L139:
            av3.b.a("APM-Disk", "appUsage:" + r136);     // Catch: Throwable -> L113
        L120:
            r113 = r101;
        L124:
            r113 = r101;
            r211 = "APM-Disk";
            r114 = "check_disk_last_time";
        L123:
            r210 = r100;
            goto L124
        L87:
            Iterator r137 = ((ArrayList) r103.f569071g).iterator();
        L89:
            if (r137.hasNext() == false) goto L86;
            File r138 = new PolarisFileWrapper((String) r137.next());
            if (r138.exists() == true) goto L93;
        L99:
            r212 = r212;
        L100:
            r107 = r107;
            r137 = r137;
            goto L89
        L93:
            if (r103.k(r138) == true) goto L99;
            if (r138.isFile() == false) goto L98;
            long r139 = r138.length();
            c.a r140 = new c.a(r103);
            r140.f569082d = false;
            r140.f569079a = r138.getAbsolutePath();
            r140.f569080b = r139;
            r140.f569083e = "custom";
            r212.add(r140);
            goto L100
        L98:
            c.a r141 = new c.a(r103);
            r141.f569082d = true;
            r141.f569083e = "custom";
            r141.f569079a = r138.getAbsolutePath();
            r141.f569080b = c.h(r138);
            r212.add(r141);
            goto L100
        L44:
            if (r120.length == 0) goto L49;
            int r142 = r120.length;
            int r143 = 0;
        L47:
            if (r143 >= r142) goto L49;
            r103.b(r120[r143], r118);
            r143 = r143 + 1;
            goto L47
        L36:
            if (r119.length == 0) goto L41;
            int r144 = r119.length;
            int r145 = 0;
        L39:
            if (r145 >= r144) goto L41;
            r103.b(r119[r145], r118);
            r145 = r145 + 1;
            goto L39
        L131:
            r210 = r100;
            r104 = "APM-Disk";
            goto L132
        L8:
            r102 = 0;
            goto L9
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

        public C8380a(a r100) {
            this.f569050d = r100;
        }
    }

    public a() {
    }

    public final synchronized void a() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.f569048c == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        zt3.a r100 = this.f569046a;     // Catch: Throwable -> L22
        if (r100 != null) goto L10;
    L20:
        monitor-exit(this);
        return;
    L10:
        if (r100.f573580l == false) goto L20;
        if (du3.a.o() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f569048c = true;     // Catch: Throwable -> L22
        this.f569049d = new C8380a(this);     // Catch: Throwable -> L22
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f569049d);     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    static {
        f569045e = new a();
    }

    public final synchronized void b(zt3.a r100) {
        monitor-enter(this);
        if (r100 != null) goto L27;
        monitor-exit(this);
        return;
    L27:
        this.f569046a = r100;     // Catch: Throwable -> L24
        if (xu3.a.a() == false) goto L11;
        av3.b.a("APM-Disk", "updateConfig:" + r100);     // Catch: Throwable -> L24
    L11:
        if (this.f569047b == true) goto L14;
        monitor-exit(this);
        return;
    L14:
        uu3.a r101 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L24
        if (r101 != null) goto L17;
    L22:
        monitor-exit(this);
        return;
    L17:
        if (r101.isForeground() == true) goto L22;
        a();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L24:
        th = move-exception;
        throw th;
    }
}
