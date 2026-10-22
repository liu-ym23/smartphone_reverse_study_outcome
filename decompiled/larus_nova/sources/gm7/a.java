package gm7;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PthreadTimer f481674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f481675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static InterfaceC6036a f481676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Integer> f481677d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f481678e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f481679f = null;

    /* JADX INFO: renamed from: gm7.a$a, reason: collision with other inner class name */
    public interface InterfaceC6036a {
        void a(Set r100);
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final class b extends TimerTask {
        public static void a() {
            InterfaceC6036a r100 = a.f481676c;
            if (r100 == null) goto L5;
            r100.a(a.f481677d.keySet());
        L5:
            Iterator<Map.Entry<String, Integer>> r101 = a.f481677d.entrySet().iterator();
        L7:
            if (r101.hasNext() == false) goto L13;
            Map.Entry<String, Integer> r102 = r101.next();
            String r103 = r102.getKey();
            int r104 = r102.getValue().intValue();
            if (r104 > 1) goto L10;
            if (r104 <= 0) goto L7;
            a.f481677d.remove(r103);
            goto L7
        L10:
            a.f481677d.put(r103, Integer.valueOf(r104 - 1));
            goto L7
        }

        @Override // java.util.TimerTask, java.lang.Runnable
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

        public b() {
        }
    }

    public a() {
    }

    static {
        f481679f = new a();
        f481677d = new ConcurrentHashMap();
    }

    public final synchronized void b(String r100) {
        monitor-enter(this);
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyTaskTimer", "stopTimerWithScene(), sceneId = " + r100);     // Catch: Throwable -> L19
        if (r100 != null) goto L8;
        monitor-exit(this);
        return;
    L8:
        ConcurrentHashMap<String, Integer> r101 = f481677d;     // Catch: Throwable -> L19
        r101.remove(r100);     // Catch: Throwable -> L19
        if (r101.isEmpty() == false) goto L17;
        PthreadTimer r102 = f481674a;     // Catch: Throwable -> L19
        if (r102 == null) goto L13;
        r102.cancel();     // Catch: Throwable -> L19
    L13:
        f481674a = null;     // Catch: Throwable -> L19
        b r103 = f481675b;     // Catch: Throwable -> L19
        if (r103 == null) goto L16;
        r103.cancel();     // Catch: Throwable -> L19
    L16:
        f481675b = null;     // Catch: Throwable -> L19
        f481678e = false;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r100, int r101) {
        monitor-enter(this);
        e.B.getClass();     // Catch: Throwable -> L31
        if (e.f481709m.size() <= 0) goto L7;
    L11:
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyTaskTimer", "startTimerWithScene(), sceneId = " + r100 + ", duration = " + r101);     // Catch: Throwable -> L31
        if (r100 != null) goto L15;
        monitor-exit(this);
        return;
    L15:
        f481677d.put(r100, Integer.valueOf(r101));     // Catch: Throwable -> L31
        if (f481678e == false) goto L20;
        monitor-exit(this);
        return;
    L20:
        if (f481675b != null) goto L23;
        f481675b = new b();     // Catch: Throwable -> L31
    L23:
        if (f481674a != null) goto L25;
        f481674a = new PthreadTimer("LuckyTaskTimer");     // Catch: Throwable -> L31
    L25:
        PthreadTimer r102 = f481674a;     // Catch: Throwable -> L31
        if (r102 != null) goto L28;
        Intrinsics.throwNpe();     // Catch: Throwable -> L31
    L28:
        r102.schedule(f481675b, 1000, 1000);     // Catch: Throwable -> L31
        f481678e = true;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L7:
        if (e.f481706j.get() == true) goto L11;
        com.bytedance.ug.sdk.luckydog.api.log.d.a("LuckyTaskTimer", "startTimerWithScene(), task null");     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L31:
        th = move-exception;
        throw th;
    }
}
