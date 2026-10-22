package yt3;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Pair;
import com.bytedance.apm.util.v;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import cv3.a;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import nu3.c;
import xu3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$a extends a {
    public final /* synthetic */ a d;

    public final void a() {
        long r1 = System.currentTimeMillis();
        if (xu3.a.a() == false) goto L5;
        av3.b.a("APM-Disk", "startCollect:");
    L5:
        SharedPreferences r3 = xu3.a.getContext().getSharedPreferences("monitor_config", 0);
        if (r3 == null) goto L8;
        long r9 = r3.getLong("check_disk_last_time", 0);
    L9:
        long r11 = System.currentTimeMillis() - r9;
        if (xu3.a.a() == false) goto L13;
        av3.b.a("APM-Disk", "durationMs:" + r11);
    L13:
        if (r11 < 86400000) goto L131;
        c r10 = c.o;
        zt3.a r12 = this.d.a;
        c r15 = null;
        if (r12 != null) goto L18;
    L19:
        long r21 = r1;
        SharedPreferences r19 = r3;
        String r20 = "APM-Disk";
        String r16 = "check_disk_last_time";
    L127:
        if (xu3.a.a() == false) goto L129;
        String r2 = r20;
        av3.b.a(r2, "durationMs:" + r15.a());
    L130:
        nu3.b.a(r15);
        r19.edit().putLong(r16, System.currentTimeMillis()).commit();
    L132:
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.d.d);
        if (xu3.a.a() == false) goto L170;
        av3.b.a(r2, "collect end and cost time:" + (System.currentTimeMillis() - r21));
        return;
    L170:
        return;
    L129:
        r2 = r20;
        goto L130
    L18:
        if (r10.e == true) goto L19;
        r10.j = r12;
        if (r10.i == true) goto L33;
        r10.i = true;
        Application r13 = xu3.a.getContext();
        r13.getPackageName();     // Catch: Exception -> L32
        r10.a = r13.getFilesDir().getParent();     // Catch: Exception -> L32
        r10.b = r13.getCacheDir().getAbsolutePath();     // Catch: Exception -> L32
        String r14 = r13.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L27
    L28:
        r10.c = r14;     // Catch: Exception -> L32
        File r17 = r13.getExternalCacheDir();     // Catch: Exception -> L32
        if (r17 == null) goto L33;
        r10.d = r17.getAbsolutePath();     // Catch: Exception -> L32
    L27:
        r14 = null;
    L32:
        r10.e = true;
    L33:
        r10.f = r10.n(r12.j);
        r10.g = r10.n(r12.i);
        r10.h = r10.n(r12.k);
        ArrayList r18 = new ArrayList();
        File[] r110 = new PolarisFileWrapper(r10.a).listFiles();
        if (r110 != null) goto L36;
    L41:
        File[] r111 = new PolarisFileWrapper(r10.c).listFiles();
        if (r111 != null) goto L44;
    L49:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r18.iterator();
    L51:
        if (r113.hasNext() == false) goto L63;
        c$a r114 = (c$a) r113.next();
        Iterator r115 = ((ArrayList) r114.f).iterator();
    L54:
        if (r115.hasNext() == false) goto L59;
        if (((c$a) r115.next()).d == false) goto L54;
        boolean r7 = false;
    L60:
        if (r7 == false) goto L51;
        r112.remove(r114);
        goto L51
    L59:
        r7 = true;
        goto L60
    L63:
        r18.removeAll(r112);
        if (xu3.a.a() == false) goto L69;
        Iterator r8 = r18.iterator();
    L67:
        if (r8.hasNext() == false) goto L69;
        av3.b.a("APM-Disk", "diskInfoNodes:" + ((c$a) r8.next()).b());
    L69:
        v r22 = new v(r10.j.f);
        v r23 = new v(r10.j.g);
        v r116 = new v(r10.j.e);
        ArrayList r117 = new ArrayList();
        r117.add(r10.a);
        r117.add(r10.b);
        ArrayList r24 = r18;
        r10.d(r10.c(r10.a, r22, r23, r116, r117));
        r117.clear();
        r117.add(r10.d);
        r117.add(r10.c);
        r10.d(r10.c(r10.c, r22, r23, r116, r117));
        if (xu3.a.a() == false) goto L85;
        Iterator r118 = ((ArrayList) r22.b()).iterator();
    L73:
        if (r118.hasNext() == false) goto L75;
        av3.b.a("APM-Disk", "fileListTopK:" + ((c$b) r118.next()).b());
        goto L73
    L75:
        Iterator r119 = ((ArrayList) r23.b()).iterator();
    L77:
        if (r119.hasNext() == false) goto L79;
        av3.b.a("APM-Disk", "dirListTopK:" + ((c$b) r119.next()).b());
        goto L77
    L79:
        Iterator r120 = ((ArrayList) r116.b()).iterator();
    L81:
        if (r120.hasNext() == false) goto L83;
        av3.b.a("APM-Disk", "outdatedListTopK:" + ((c$b) r120.next()).b());
        goto L81
    L83:
        av3.b.a("APM-Disk", "insideDataSize:" + r10.k + " outsideDataSize:" + r10.l + " insideCacheSize:" + r10.m + " outsideCacheSize:" + r10.n);
    L85:
        if (e.b(r10.g) == false) goto L87;
    L86:
        v r121 = r22;
        ArrayList r6 = r24;
        long r122 = r10.k + r10.l;     // Catch: Throwable -> L123
        r21 = r1;
        long r123 = r10.m + r10.n;     // Catch: Throwable -> L138
        long r4 = Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace();     // Catch: Throwable -> L138
        long r31 = Environment.getDataDirectory().getFreeSpace();     // Catch: Throwable -> L138
        r16 = "check_disk_last_time";
        long r0 = Math.min(r122, 17179869184L);     // Catch: Throwable -> L120
        long r27 = Math.min(r123, 17179869184L);     // Catch: Throwable -> L120
        if (r0 >= 0) goto L109;
    L108:
        r19 = r3;
        r20 = "APM-Disk";
    L125:
        r15 = null;
        goto L127
    L109:
        Pair r5 = c.j();     // Catch: Throwable -> L120
        long r25 = r10.g();     // Catch: Throwable -> L120
        if (xu3.a.a() == true) goto L139;
    L114:
        r19 = r3;
        r20 = "APM-Disk";
        r15 = new b(r122, r27, r4, r31, r25, ((Long) r5.first).longValue(), ((Long) r5.second).longValue(), (float) new BigDecimal(r25).divide(new BigDecimal(r4), 4, 4).doubleValue(), c.f(r121), c.f(r23), c.f(r116), r10.e(r6, r0));     // Catch: Throwable -> L136
    L121:
        r20 = "APM-Disk";
        goto L125
    L139:
        av3.b.a("APM-Disk", "appUsage:" + r25);     // Catch: Throwable -> L113
    L120:
        r19 = r3;
    L124:
        r19 = r3;
        r20 = "APM-Disk";
        r16 = "check_disk_last_time";
    L123:
        r21 = r1;
        goto L124
    L87:
        Iterator r124 = ((ArrayList) r10.g).iterator();
    L89:
        if (r124.hasNext() == false) goto L86;
        PolarisFileWrapper r125 = new PolarisFileWrapper((String) r124.next());
        if (r125.exists() == true) goto L93;
    L99:
        r24 = r24;
    L100:
        r22 = r22;
        r124 = r124;
        goto L89
    L93:
        if (r10.k(r125) == true) goto L99;
        if (r125.isFile() == false) goto L98;
        long r26 = r125.length();
        c$a r126 = new c$a(r10);
        r126.d = false;
        r126.a = r125.getAbsolutePath();
        r126.b = r26;
        r126.e = "custom";
        r24.add(r126);
        goto L100
    L98:
        c$a r28 = new c$a(r10);
        r28.d = true;
        r28.e = "custom";
        r28.a = r125.getAbsolutePath();
        r28.b = c.h(r125);
        r24.add(r28);
        goto L100
    L44:
        if (r111.length == 0) goto L49;
        int r127 = r111.length;
        int r128 = 0;
    L47:
        if (r128 >= r127) goto L49;
        r10.b(r111[r128], r18);
        r128 = r128 + 1;
        goto L47
    L36:
        if (r110.length == 0) goto L41;
        int r129 = r110.length;
        int r130 = 0;
    L39:
        if (r130 >= r129) goto L41;
        r10.b(r110[r130], r18);
        r130 = r130 + 1;
        goto L39
    L131:
        r21 = r1;
        r2 = "APM-Disk";
        goto L132
    L8:
        r9 = 0;
        goto L9
    }

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

    public a$a(a r1) {
        this.d = r1;
    }
}
