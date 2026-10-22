package wg4;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.l;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import zg4.g;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f559547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, C8108a> f559548b = null;

    /* JADX INFO: renamed from: wg4.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static class C8108a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f559549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Long> f559550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f559551c;

        public C8108a(String r100, long r101, CrashType r102) {
            ArrayList r103 = new ArrayList();
            this.f559550b = r103;
            this.f559549a = r100;
            r103.add(Long.valueOf(r101));
            if (r102 != CrashType.LAUNCH) goto L6;
            this.f559551c = true;
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PolarisFileWrapper f559552a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final wg4.c f559553b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d f559554c;

        public b(String r100, wg4.c r101, d r102) {
            this.f559552a = new PolarisFileWrapper(r100);
            this.f559553b = r101;
            this.f559554c = r102;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f559555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.bytedance.crash.monitor.a f559556b;

        public final void a() {
            if (a.a() == true) goto L5;
        L64:
            int r100 = this.f559555a;
            this.f559555a = r100 + 1;
            if (r100 >= 60) goto L91;
            wh4.b.postDelayed(this, 2000);
            return;
        L91:
            return;
        L5:
            if (l.a() == false) goto L64;
            com.bytedance.crash.monitor.a r101 = this.f559556b;
            HashMap<String, C8108a> r102 = a.f559548b;
            monitor-enter(r102);
            HashMap r103 = new HashMap(r102);     // Catch: Throwable -> L61
            r102.clear();     // Catch: Throwable -> L61
            monitor-exit(r102);     // Catch: Throwable -> L61
            Iterator r104 = r103.keySet().iterator();
        L13:
            if (r104.hasNext() == false) goto L92;
            C8108a r105 = (C8108a) r103.get((String) r104.next());
            if (r105 == null) goto L13;
            if (((ArrayList) r105.f559550b).isEmpty() == true) goto L13;
            HashSet r106 = new HashSet();
            Iterator r107 = ((ArrayList) r105.f559550b).iterator();
        L20:
            if (r107.hasNext() == false) goto L34;
            long r108 = ((Long) r107.next()).longValue();
            String r109 = r105.f559549a;
            if (a.a() == false) goto L30;
            b r110 = a.f559547a;
            if (r110.f559552a.exists() == false) goto L30;
            d r111 = r110.f559554c;
            if ((r111 instanceof wg4.b) == false) goto L73;
            r111 = new wg4.b(r109);
        L73:
            List<String> r112 = r111.a(r110.f559552a.getAbsolutePath(), r108);     // Catch: Throwable -> L68
        L31:
            if (r112 == null) goto L20;
            r106.addAll(r112);
        L30:
            r112 = null;
            goto L31
        L34:
            if (r106.isEmpty() == true) goto L13;
            ArrayList r113 = new ArrayList(r106);
            String r114 = r105.f559549a;
            int r115 = CastIntegerProtector.parseInt(r101.a());     // Catch: Throwable -> L39
        L40:
            if (r115 > 0) goto L75;
            String r116 = "no_aid";
        L52:
            ch4.c.b r117 = new ch4.c.b("alog_check");
            Object[] r118 = new Object[6];
            r118[0] = LocationMonitorConst.CHECK_RESULT;
            r118[1] = r116;
            r118[2] = "crash_type";
            if (r105.f559551c == false) goto L55;
            String r119 = "lunch";
        L56:
            r118[3] = r119;
            r118[4] = "alog_inited";
            if (a.a() == false) goto L59;
            String r120 = "true";
        L60:
            r118[5] = r120;
            j.a(r117.f23770a, r118);
            r117.a();
            goto L13
        L59:
            r120 = "uncertain";
            goto L60
        L55:
            r119 = "normal";
            goto L56
        L75:
            String r121 = r101.d("0");     // Catch: Throwable -> L49
            if (TextUtils.isEmpty(r121) == false) goto L45;
            r116 = "no_did";
            goto L52
        L45:
            int r122 = r115;
            if (CrashUploader.e(n.a(g.f572072l.f572081i, r122, r121, r101.j(), r101.f()), r115, r121, r114, r113) == false) goto L51;
            r116 = "success";
        L51:
            r116 = "unknown";
        L49:
            th = move-exception;
            ch4.c.c(th);
        L39:
            r115 = 0;
            goto L40
        L92:
            return;
        L61:
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

        public c(com.bytedance.crash.monitor.a r100) {
            this.f559555a = 0;
            this.f559556b = r100;
        }
    }

    static {
        f559548b = new HashMap();
    }

    public static boolean a() {
        if (f559547a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(String r100, long r101, long r102, CrashType r103) {
        HashMap<String, C8108a> r104 = f559548b;
        monitor-enter(r104);
        C8108a r105 = r104.get(r100 + r101);     // Catch: Throwable -> L12
        if (r105 != null) goto L7;
        r104.put(r100 + r101, new C8108a(r100, r102, r103));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r104);     // Catch: Throwable -> L12
        return;
    L7:
        ((ArrayList) r105.f559550b).add(Long.valueOf(r102));     // Catch: Throwable -> L12
        if (r103 != CrashType.LAUNCH) goto L10;
        r105.f559551c = true;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
