package ms.bd.c;

import android.content.Context;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f515241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile long f515242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile long f515243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f515244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f515245e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j2 f515246f = null;

    static {
        f515245e = new ConcurrentHashMap();
        f515246f = new j2();
    }

    public static synchronized k2 a(String r100) {
        monitor-enter(n2.class);
        if (r100 == null) goto L23;
        if (f515244d == true) goto L11;
        monitor-exit(n2.class);
        return null;
    L11:
        Object r101 = p2.a(67108866, 0, 0, null, null);     // Catch: Throwable -> L24
        if (r101 != null) goto L15;
        monitor-exit(n2.class);
        return null;
    L15:
        c2 r102 = (c2) f515245e.get(r100);     // Catch: Throwable -> L24
        if (r102 != null) goto L19;
        monitor-exit(n2.class);
        return null;
    L19:
        k2 r103 = new k2(r102, d2.f515131b.f515132a, ((Long) r101).longValue());     // Catch: Throwable -> L24
        monitor-exit(n2.class);
        return r103;
    L23:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(Context r110, String r111) {
        monitor-enter(n2.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f515244d == true) goto L11;
        long r100 = System.nanoTime() / 1000;     // Catch: Throwable -> L13
        Context r112 = r110.getApplicationContext();     // Catch: Throwable -> L13
        d2 r113 = d2.f515131b;     // Catch: Throwable -> L13
        if (r112 == null) goto L9;
        Context r101 = r112.getApplicationContext();     // Catch: Throwable -> L13
    L10:
        r113.f515132a = r101;     // Catch: Throwable -> L13
        f515246f.f515172a.set(1);     // Catch: Throwable -> L13
        g3.a(r112, r111);     // Catch: Throwable -> L13
        f515243c = System.currentTimeMillis() - r100;     // Catch: Throwable -> L13
        p2.a(16777219, 0, 0, null, r112);     // Catch: Throwable -> L13
        f515241a = (System.nanoTime() / 1000) - r100;     // Catch: Throwable -> L13
        f515244d = true;     // Catch: Throwable -> L13
        goto L11
    L9:
        r101 = null;
    L11:
        monitor-exit(n2.class);
    }

    public static synchronized boolean c(final Context r110, final c2 r210) {
        monitor-enter(n2.class);
        if (r110 == null) goto L40;
        if (r210 == null) goto L38;
        String r100 = r210.mAppID;     // Catch: Throwable -> L41
        if (r100 != null) goto L10;
    L12:
        final String r101 = r210.mSDKID;     // Catch: Throwable -> L41
    L13:
        if (r101 == null) goto L36;
        if (r101.length() <= 0) goto L36;
        String r102 = r210.mAdvanceInfo.get("kSt");     // Catch: Throwable -> L41
        if (r102 == null) goto L19;
        r102.equals("1");     // Catch: Throwable -> L41
    L19:
        b(r110, "metasec_ml");     // Catch: Throwable -> L41
        ConcurrentHashMap r103 = f515245e;     // Catch: Throwable -> L41
        if (r103.containsKey(r101) == false) goto L25;
        monitor-exit(n2.class);
        return false;
    L25:
        if (r210.mDefaultReportHost.isEmpty() == true) goto L27;
        p2.a(33554449, 0, 0, r210.mDefaultReportHost, null);     // Catch: Throwable -> L41
    L27:
        String r111 = r210.toNativeValue();     // Catch: Throwable -> L41
        long r104 = System.nanoTime() / 1000;     // Catch: Throwable -> L41
        boolean r105 = ((Boolean) p2.a(67108865, 0, 0, r111, null)).booleanValue();     // Catch: Throwable -> L41
        f515242b = (System.nanoTime() / 1000) - r104;     // Catch: Throwable -> L41
        if (r105 == true) goto L31;
        monitor-exit(n2.class);
        return false;
    L31:
        r103.put(r101, r210);     // Catch: Throwable -> L41
        ThreadMethodProxy.start(new PthreadThreadV2(new m4(r110, r210, r101), "ms/bd/c/n2"));     // Catch: Throwable -> L41
        monitor-exit(n2.class);
        return true;
    L36:
        throw new NullPointerException("appID must be set");     // Catch: Throwable -> L41
    L10:
        if (r100.length() <= 0) goto L12;
        r101 = r210.mAppID;     // Catch: Throwable -> L41
        goto L13
    L38:
        throw new NullPointerException("config could not be null");     // Catch: Throwable -> L41
    L40:
        throw new NullPointerException("context could not be null");     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }
}
