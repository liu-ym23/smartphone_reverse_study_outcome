package em7;

import com.bytedance.ug.sdk.luckydog.api.log.d;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import il7.m;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import zm7.l;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CopyOnWriteArraySet<l> f473094a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f473095b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PthreadTimer f473096c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C5791a f473097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f473098e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f473099f = null;

    /* JADX INFO: renamed from: em7.a$a, reason: collision with other inner class name */
    public static final class C5791a extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            Iterator<l> r100 = a.f473094a.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            r100.next().d(a.f473098e);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public C5791a() {
        }
    }

    public a() {
    }

    static {
        f473099f = new a();
        f473094a = new CopyOnWriteArraySet();
        f473095b = new AtomicBoolean(false);
        float r100 = 1.0f;
        f473098e = 1.0f;
        m r101 = m.a();
        if (r101.f490336a == null) goto L5;
        r101.g("timer_interval_ts");
        r100 = r101.f490336a.getFloat("timer_interval_ts", 1.0f);
    L5:
        f473098e = r100;
    }

    public static void b() {
    L18:
        th = move-exception;
        d.b("LuckyCountDownTimer", th.getMessage());
        return;
    L4:
        if (f473094a.isEmpty() == false) goto L8;
        d.d("LuckyCountDownTimer", "timerTriggers is null");     // Catch: Throwable -> L18
        return;
    L8:
        if (f473097d != null) goto L11;
        d.d("LuckyCountDownTimer", "timerTask is null");     // Catch: Throwable -> L18
        f473097d = new C5791a();     // Catch: Throwable -> L18
    L11:
        if (f473096c != null) goto L13;
        d.d("LuckyCountDownTimer", "timer is null");     // Catch: Throwable -> L18
        f473096c = new PthreadTimer("luckydog_new_timer");     // Catch: Throwable -> L18
    L13:
        PthreadTimer r100 = f473096c;     // Catch: Throwable -> L18
        if (r100 != null) goto L16;
        Intrinsics.throwNpe();     // Catch: Throwable -> L18
    L16:
        C5791a r101 = f473097d;     // Catch: Throwable -> L18
        long r102 = (long) (f473098e * 1000);     // Catch: Throwable -> L18
        r100.schedule(r101, r102, r102);     // Catch: Throwable -> L18
        f473095b.set(true);     // Catch: Throwable -> L18
    }

    public final synchronized void a(l r100) {
        monitor-enter(this);
        d.d("LuckyCountDownTimer", "registerTask() task = ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L12
        CopyOnWriteArraySet<l> r101 = f473094a;     // Catch: Throwable -> L12
        if (r101.contains(r100) == true) goto L8;
        r101.add(r100);     // Catch: Throwable -> L12
        d.d("LuckyCountDownTimer", "registerTask add success");     // Catch: Throwable -> L12
    L8:
        if (f473095b.get() == true) goto L10;
        d.d("LuckyCountDownTimer", "registerTask() start timer");     // Catch: Throwable -> L12
        b();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(l r100) {
        monitor-enter(this);
        d.d("LuckyCountDownTimer", "unregisterTask() task = ".concat(r100.getClass().getSimpleName()));     // Catch: Throwable -> L15
        CopyOnWriteArraySet<l> r101 = f473094a;     // Catch: Throwable -> L15
        r101.remove(r100);     // Catch: Throwable -> L15
        if (r101.isEmpty() == false) goto L13;
        d.d("LuckyCountDownTimer", "unregisterTask() timerTriggers is empty");     // Catch: Throwable -> L15
        f473095b.set(false);     // Catch: Throwable -> L15
        PthreadTimer r102 = f473096c;     // Catch: Throwable -> L15
        if (r102 == null) goto L9;
        r102.cancel();     // Catch: Throwable -> L15
    L9:
        f473096c = null;     // Catch: Throwable -> L15
        C5791a r103 = f473097d;     // Catch: Throwable -> L15
        if (r103 == null) goto L12;
        r103.cancel();     // Catch: Throwable -> L15
    L12:
        f473097d = null;     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
