package com.xiaomi.channel.commonutils.logger;

import android.content.Context;
import android.os.Process;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.xiaomi.push.j;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f463010a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Context f122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static LoggerInterface f123a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Integer f124a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f125a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final HashMap<Integer, Long> f126a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static AtomicInteger f127a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, String> f463011b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private static boolean f129b;

    public static class a implements LoggerInterface {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f463012a;

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String r100) {
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void log(String r100, Throwable r101) {
        }

        public a() {
            this.f463012a = b.m8716a();
        }

        @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
        public void setTag(String r100) {
            this.f463012a = r100;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m8721a() {
        return false;
    }

    static {
        f125a = "XMPush-" + Process.myPid();
        f123a = new a();
        f126a = new HashMap();
        f463011b = new HashMap();
        f124a = -1;
        f127a = new AtomicInteger(1);
    }

    private static String b() {
        return "[Tid:" + ThreadMethodProxy.currentThread().getId() + "] ";
    }

    public static int a() {
        return f463010a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static /* synthetic */ String m8716a() {
        return f125a;
    }

    public static void a(Integer r100) {
        if (f463010a > 1) goto L9;
        HashMap<Integer, Long> r101 = f126a;
        if (r101.containsKey(r100) == true) goto L7;
        return;
    L7:
        long r102 = r101.remove(r100).longValue();
        String r103 = f463011b.remove(r100);
        long r104 = System.currentTimeMillis() - r102;
        f123a.log(r103 + " ends in " + r104 + " ms");
        return;
    }

    public static void b(String r100) {
        if (m8722a(0) == false) goto L6;
        a(0, m8717a(r100));
        return;
    }

    public static void c(String r100) {
        if (m8722a(0) == false) goto L6;
        a(1, m8717a(r100));
        return;
    }

    public static void d(String r100) {
        if (m8722a(4) == false) goto L6;
        a(4, m8717a(r100));
        return;
    }

    public static void e(String r100) {
        if (f128a == false) goto L5;
        m8718a(r100);
        return;
    L5:
        m8717a(r100);
        if (f129b == true) goto L10;
        m8718a(r100);
        return;
    }

    public static Integer a(String r100) {
        if (f463010a > 1) goto L7;
        Integer r101 = Integer.valueOf(f127a.incrementAndGet());
        f126a.put(r101, Long.valueOf(System.currentTimeMillis()));
        f463011b.put(r101, r100);
        f123a.log(r100 + " starts");
        return r101;
    L7:
        return f124a;
    }

    public static void a(int r100) {
        if (r100 >= 0) goto L4;
    L5:
        a(2, "set log level as " + r100);
    L6:
        f463010a = r100;
        return;
    L4:
        if (r100 <= 5) goto L6;
        goto L5
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static String m8717a(String r100) {
        return b() + r100;
    }

    public static void a(Context r100) {
        f122a = r100;
        if (j.m9295a(r100) == false) goto L6;
        f128a = true;
    L6:
        if (j.m9294a() == false) goto L9;
        f129b = true;
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8718a(String r100) {
        if (m8722a(2) == false) goto L6;
        a(2, m8717a(r100));
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m8722a(int r100) {
        if (r100 < f463010a) goto L5;
    L8:
        return true;
    L5:
        if (m8721a() == true) goto L8;
        return false;
    }

    public static void a(Throwable r100) {
        if (m8722a(4) == false) goto L6;
        a(4, r100);
        return;
    }

    public static void a(LoggerInterface r100) {
        f123a = r100;
    }

    private static String a(String r100, Object... r101) {
        StringBuilder r102 = new StringBuilder("[Tid:");
        r102.append(ThreadMethodProxy.currentThread().getId());
        r102.append("] [");
        r102.append(r100);
        r102.append("] ");
        if (r101 == null) goto L10;
        if (r101.length <= 0) goto L10;
        int r103 = r101.length;
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        r102.append(r101[r104]);
        r104 = r104 + 1;
    L10:
        return r102.toString();
    }

    private static String b(String r100, String r101) {
        return b() + a(r100, r101);
    }

    public static void c(String r100, String r101) {
        if (m8722a(4) == false) goto L6;
        a(4, b(r100, r101));
        return;
    }

    public static void d(String r100, String r101) {
        if (f128a == false) goto L5;
        m8719a(r100, r101);
        return;
    L5:
        b(r100, r101);
        if (f129b == true) goto L10;
        m8719a(r100, r101);
        return;
    }

    public static String a(String r100, String r101) {
        return "[" + r100 + "] " + r101;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m8723b(String r100, String r101) {
        if (m8722a(1) == false) goto L6;
        a(1, b(r100, r101));
        return;
    }

    public static void a(int r100, Throwable r101) {
        if (r100 < f463010a) goto L6;
        f123a.log("", r101);
        return;
    L6:
        if (m8721a() == true) goto L8;
        return;
    }

    public static void b(String r100, Object... r101) {
        if (m8722a(1) == false) goto L6;
        a(1, a(r100, r101));
        return;
    }

    public static void a(int r100, String r101) {
        if (r100 < f463010a) goto L6;
        f123a.log(r101);
        return;
    L6:
        if (m8721a() == true) goto L8;
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8719a(String r100, String r101) {
        if (m8722a(2) == false) goto L6;
        a(2, b(r100, r101));
        return;
    }

    public static void a(String r100, Throwable r101) {
        if (m8722a(4) == false) goto L6;
        a(4, m8717a(r100), r101);
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8720a(String r100, Object... r101) {
        if (m8722a(2) == false) goto L6;
        a(2, a(r100, r101));
        return;
    }

    public static void a(int r100, String r101, Throwable r102) {
        if (r100 < f463010a) goto L6;
        f123a.log(r101, r102);
        return;
    L6:
        if (m8721a() == true) goto L8;
        return;
    }
}
