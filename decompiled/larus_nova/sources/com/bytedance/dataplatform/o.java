package com.bytedance.dataplatform;

import android.app.Application;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static v f204342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile i f204343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Object> f204344c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Future f204345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f204346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f204347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f204348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f204349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Object f204350i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static r f204351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, String> f204352k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set<String> f204353l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static boolean f204354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f204355n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map<String, String> f204356o = null;

    /* JADX INFO: loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.b();     // Catch: Throwable -> L4
            o.f204343b.c(o.f204352k);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f204344c = new ConcurrentHashMap();
        f204346e = false;
        f204347f = false;
        f204348g = false;
        f204350i = new Object();
        f204352k = new ConcurrentHashMap();
        f204353l = new ConcurrentSkipListSet();
        f204354m = false;
        f204355n = false;
        f204356o = new ConcurrentHashMap();
    }

    public static void b() {
        if ((f204346e | f204347f) == true) goto L19;
        if (f204354m == false) goto L19;
        Object r100 = f204350i;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L10:
        if ((f204346e | f204347f) == false) goto L30;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        goto L19
    L30:
        r100.wait(10000);     // Catch: InterruptedException -> L27 Throwable -> L15
    L19:
        if (f204345d == null) goto L26;
        f204345d.get();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    L26:
        throw new RuntimeException("ExperimentManager has not been init");
    }

    public static void a(Map<String, String> r100) {
        Iterator<Map.Entry<String, String>> r101 = r100.entrySet().iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<String, String> r103 = r101.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        Map<String, String> r106 = f204352k;
        if (TextUtils.equals((CharSequence) ((ConcurrentHashMap) r106).get(r104), r105) == true) goto L4;
        ((ConcurrentHashMap) r106).put(r104, r105);
        r102 = true;
        goto L4
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        if (f204346e == false) goto L19;
        w.a(new a());
        return;
    }

    public static void g(String r100) {
        if (f204348g == false) goto L5;
        f204343b.e(r100);
        return;
    L5:
        f204349h = r100;
    }

    public static void f(String r100, Object r101, boolean r102, String r103) {
        if (r102 == false) goto L5;
        if (r101 == null) goto L5;
        ((ConcurrentHashMap) f204344c).put(r100, r101);
    L5:
        ((ConcurrentHashMap) f204356o).put(r100, r103);
    }

    public static <T> T c(String r100, Type r101, T r102, boolean r103, boolean r110) {
        return (T) d(r100, r101, r102, r103, r110, null);
    }

    public static Object d(String r110, Type r111, Object r112, boolean r210, boolean r211, ij4.a r212) {
        b();
        if (r210 == false) goto L14;
        Map<String, Object> r100 = f204344c;
        ConcurrentHashMap r101 = (ConcurrentHashMap) r100;
        if (r101.containsKey(r110) == false) goto L14;
        if (r101.get(r110).getClass() != r111) goto L14;
        if (r211 == true) goto L85;
    L12:
        Object r102 = ((ConcurrentHashMap) r100).get(r110);     // Catch: Exception -> L84
        f(r110, r102, r210, "sticky");     // Catch: Exception -> L84
        return r102;
    L85:
        i r103 = f204343b;     // Catch: Exception -> L84
        Runnable r104 = (Runnable) ((ConcurrentHashMap) r103.f204314j).get(r110);     // Catch: Exception -> L84
        if (r104 == null) goto L12;
        ((ConcurrentHashMap) r103.f204314j).remove(r110);     // Catch: Exception -> L84
        r104.run();     // Catch: Exception -> L84
    L14:
        p.a r105 = p.f204357a;
        Object r106 = null;
        if (r105 != null) goto L17;
        Object r107 = null;
    L18:
        if (r107 == null) goto L22;
        f(r110, r107, r210, "panel");
        return r107;
    L22:
        if (f204355n == false) goto L27;
        Object r108 = f204343b.b(r110, r111, r211);
        if (r108 == null) goto L27;
        f(r110, r108, r210, "libra");
        return r108;
    L27:
        v r109 = f204342a;
        if (r109 == null) goto L34;
        Object r113 = r109.G0(r110, r111);
        if (r113 == null) goto L34;
        f(r110, r113, r210, "setting");
        return r113;
    L34:
        if (f204355n == true) goto L39;
        Object r114 = f204343b.b(r110, r111, r211);
        if (r114 == null) goto L39;
        f(r110, r114, r210, "libra");
        return r114;
    L39:
        i r115 = f204343b;
        r115.getClass();
        if (r212 != null) goto L42;
    L79:
        if (r106 == null) goto L82;
        f(r110, r106, r210, "client");
        return r106;
    L82:
        f(r110, r112, r210, "default");
        return r112;
    L42:
        if (TextUtils.isEmpty(r212.f490061a) == true) goto L79;
        ij4.b<T>[] r116 = r212.f490063c;
        if (r116 == 0) goto L79;
        if (r116.length == 0) goto L79;
        String r117 = r212.f490061a;
        monitor-enter(r115);
    L76:
        th = move-exception;
        throw th;
    L51:
        if (((ConcurrentHashMap) r115.f204308d).containsKey(r117) == false) goto L53;
        int r118 = ((Integer) ((ConcurrentHashMap) r115.f204308d).get(r117)).intValue();     // Catch: Throwable -> L76
    L58:
        monitor-exit(r115);     // Catch: Throwable -> L76
        int r119 = (int) (r212.f490062b * 1000.0d);
        if (r118 < r119) goto L79;
        ij4.b[] r120 = r212.f490063c;
        int r121 = r120.length;
        int r122 = 0;
    L63:
        if (r122 >= r121) goto L75;
        ij4.b r123 = r120[r122];
        if (r123 == null) goto L74;
        r119 = (int) (((double) r119) + 500.0d);
        if (r118 >= r119) goto L74;
        k r124 = new k(r115, r110, r212, r123);
        if (r211 == false) goto L72;
        r124.run();
    L73:
        r106 = r123.f490068b;
        goto L79
    L72:
        ((ConcurrentHashMap) r115.f204314j).put(r110, r124);
    L74:
        r122 = r122 + 1;
        goto L63
    L75:
        w.a(new l(r115, r110, r212));
        goto L79
    L53:
        int r125 = new Random().nextInt(1000);     // Catch: Throwable -> L76
        ((ConcurrentHashMap) r115.f204308d).put(r117, Integer.valueOf(r125));     // Catch: Throwable -> L76
        w.a(new b(r115.f204306b, r117, r125));     // Catch: Throwable -> L76
        Integer r126 = Integer.valueOf(r125);     // Catch: Throwable -> L76
        if (hj4.d.f485430d == false) goto L57;
        w.a(new hj4.c(r117, r126));     // Catch: Throwable -> L76
    L57:
        r118 = r125;
        goto L58
    L17:
        r107 = r105.b();
        goto L18
    }

    public static void e(Application r100, String r110, v r111, u r112, s r113, t r114) {
        ClientExperimentManager.f204280f.getClass();
        ClientExperimentManager.f204276b = r100;
        if (f204346e == true) goto L15;
        Object r101 = f204350i;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f204346e == true) goto L9;
        f204345d = w.a(new n(r100, r110, r112, r113, r114, r111));     // Catch: Throwable -> L12
        f204346e = true;     // Catch: Throwable -> L12
        f204347f = true;     // Catch: Throwable -> L12
    L9:
        r101.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return;
    L15:
        if (r111 == null) goto L24;
        f204342a = r111;
        p.a r102 = p.f204357a;
        if (r102 == null) goto L25;
        r102.init();
        return;
    L25:
        return;
    }
}
