package com.bytedance.dataplatform;

import android.app.Application;
import android.text.TextUtils;
import android.util.EventsUtils;
import hj4.c;
import hj4.d;
import ij4.a;
import ij4.b;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class o {
    public static v a;
    public static volatile i b;
    public static final Map<String, Object> c = null;
    public static volatile Future d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static String h;
    public static final Object i = null;
    public static r j;
    public static final Map<String, String> k = null;
    public static final Set<String> l = null;
    public static boolean m;
    public static boolean n;
    public static final Map<String, String> o = null;

    static {
        c = new ConcurrentHashMap();
        e = false;
        f = false;
        g = false;
        i = new Object();
        k = new ConcurrentHashMap();
        l = new ConcurrentSkipListSet();
        m = false;
        n = false;
        o = new ConcurrentHashMap();
    }

    public static void b() {
        if ((e | f) == true) goto L19;
        if (m == false) goto L19;
        Object r0 = i;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L10:
        if ((e | f) == false) goto L30;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        goto L19
    L30:
        r0.wait(10000);     // Catch: InterruptedException -> L27 Throwable -> L15
    L19:
        if (d == null) goto L26;
        d.get();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        throw new RuntimeException(e);
    L26:
        throw new RuntimeException("ExperimentManager has not been init");
    }

    public static void a(Map<String, String> r5) {
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
        boolean r0 = false;
    L4:
        if (r6.hasNext() == false) goto L8;
        Map.Entry<String, String> r1 = r6.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        Map<String, String> r4 = k;
        if (TextUtils.equals((CharSequence) ((ConcurrentHashMap) r4).get(r2), r3) == true) goto L4;
        ((ConcurrentHashMap) r4).put(r2, r3);
        r0 = true;
        goto L4
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        if (e == false) goto L19;
        w.a(new a());
        return;
    }

    public static void g(String r1) {
        if (g == false) goto L5;
        b.e(r1);
        return;
    L5:
        h = r1;
    }

    public static void f(String r0, Object r1, boolean r2, String r3) {
        if (r2 == false) goto L5;
        if (r1 == null) goto L5;
        ((ConcurrentHashMap) c).put(r0, r1);
    L5:
        ((ConcurrentHashMap) o).put(r0, r3);
    }

    public static <T> T c(String r6, Type r7, T r8, boolean r9, boolean r10) {
        return (T) d(r6, r7, r8, r9, r10, null);
    }

    public static Object d(String r17, Type r18, Object r19, boolean r20, boolean r21, a r22) {
        b();
        if (r20 == false) goto L14;
        Map<String, Object> r6 = c;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        if (r7.containsKey(r17) == false) goto L14;
        if (r7.get(r17).getClass() != r18) goto L14;
        if (r21 == true) goto L85;
    L12:
        Object r8 = ((ConcurrentHashMap) r6).get(r17);     // Catch: Exception -> L84
        f(r17, r8, r20, "sticky");     // Catch: Exception -> L84
        return r8;
    L85:
        i r9 = b;     // Catch: Exception -> L84
        Runnable r10 = (Runnable) ((ConcurrentHashMap) r9.j).get(r17);     // Catch: Exception -> L84
        if (r10 == null) goto L12;
        ((ConcurrentHashMap) r9.j).remove(r17);     // Catch: Exception -> L84
        r10.run();     // Catch: Exception -> L84
    L14:
        p.a r11 = p.a;
        Object r12 = null;
        if (r11 != null) goto L17;
        Object r13 = null;
    L18:
        if (r13 == null) goto L22;
        f(r17, r13, r20, "panel");
        return r13;
    L22:
        if (n == false) goto L27;
        Object r14 = b.b(r17, r18, r21);
        if (r14 == null) goto L27;
        f(r17, r14, r20, "libra");
        return r14;
    L27:
        v r15 = a;
        if (r15 == null) goto L34;
        Object r16 = r15.G0(r17, r18);
        if (r16 == null) goto L34;
        f(r17, r16, r20, "setting");
        return r16;
    L34:
        if (n == true) goto L39;
        Object r1 = b.b(r17, r18, r21);
        if (r1 == null) goto L39;
        f(r17, r1, r20, "libra");
        return r1;
    L39:
        i r2 = b;
        r2.getClass();
        if (r22 != null) goto L42;
    L79:
        if (r12 == null) goto L82;
        f(r17, r12, r20, "client");
        return r12;
    L82:
        f(r17, r19, r20, "default");
        return r19;
    L42:
        if (TextUtils.isEmpty(r22.a) == true) goto L79;
        b[] r23 = r22.c;
        if (r23 == null) goto L79;
        if (r23.length == 0) goto L79;
        String r24 = r22.a;
        monitor-enter(r2);
    L76:
        th = move-exception;
        throw th;
    L51:
        if (((ConcurrentHashMap) r2.d).containsKey(r24) == false) goto L53;
        int r25 = ((Integer) ((ConcurrentHashMap) r2.d).get(r24)).intValue();     // Catch: Throwable -> L76
    L58:
        monitor-exit(r2);     // Catch: Throwable -> L76
        int r26 = (int) (r22.b * 1000.0d);
        if (r25 < r26) goto L79;
        b[] r28 = r22.c;
        int r110 = r28.length;
        int r111 = 0;
    L63:
        if (r111 >= r110) goto L75;
        b r112 = r28[r111];
        if (r112 == null) goto L74;
        r26 = (int) (((double) r26) + 500.0d);
        if (r25 >= r26) goto L74;
        k r29 = new k(r2, r17, r22, r112);
        if (r21 == false) goto L72;
        r29.run();
    L73:
        r12 = r112.b;
        goto L79
    L72:
        ((ConcurrentHashMap) r2.j).put(r17, r29);
    L74:
        r111 = r111 + 1;
        goto L63
    L75:
        w.a(new l(r2, r17, r22));
        goto L79
    L53:
        int r30 = new Random().nextInt(EventsUtils.FEAT_TYPE_SHUT_DOWN);     // Catch: Throwable -> L76
        ((ConcurrentHashMap) r2.d).put(r24, Integer.valueOf(r30));     // Catch: Throwable -> L76
        w.a(new b(r2.b, r24, r30));     // Catch: Throwable -> L76
        Integer r31 = Integer.valueOf(r30);     // Catch: Throwable -> L76
        if (d.d == false) goto L57;
        w.a(new c(r24, r31));     // Catch: Throwable -> L76
    L57:
        r25 = r30;
        goto L58
    L17:
        r13 = r11.b();
        goto L18
    }

    public static void e(Application r9, String r10, v r11, u r12, s r13, t r14) {
        ClientExperimentManager.f.getClass();
        ClientExperimentManager.b = r9;
        if (e == true) goto L15;
        Object r0 = i;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (e == true) goto L9;
        d = w.a(new n(r9, r10, r12, r13, r14, r11));     // Catch: Throwable -> L12
        e = true;     // Catch: Throwable -> L12
        f = true;     // Catch: Throwable -> L12
    L9:
        r0.notifyAll();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L15:
        if (r11 == null) goto L24;
        a = r11;
        p.a r15 = p.a;
        if (r15 == null) goto L25;
        r15.init();
        return;
    L25:
        return;
    }
}
