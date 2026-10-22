package mqc;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.volcengine.zeus.Zeus;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Queue<Runnable> f514963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Thread f514964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Handler f514965c = null;

    /* JADX INFO: loaded from: classes41.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f514966a = null;

        static {
            f514966a = new a();
        }

        public a() {
        }

        public static void a() {
            Zeus.waitInit(-1);
            Queue<Runnable> r100 = p.f514963a;
            monitor-enter(r100);
        L15:
            ArrayDeque r101 = (ArrayDeque) p.f514963a;     // Catch: Throwable -> L12
            if ((!r101.isEmpty()) == false) goto L9;
            Runnable r102 = (Runnable) r101.poll();     // Catch: Throwable -> L12
            if (r102 == null) goto L15;
            r102.run();     // Catch: Throwable -> L12
            goto L15
        L9:
            p.f514964b = null;     // Catch: Throwable -> L12
            Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(r100);
            return;
        L12:
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
    }

    static {
        f514963a = new ArrayDeque();
        f514965c = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Zeus.hasInit() == false) goto L6;
        r100.run();
        return;
    L6:
        Queue<Runnable> r101 = f514963a;
        monitor-enter(r101);
        ((ArrayDeque) r101).add(r100);     // Catch: Throwable -> L14
        if (f514964b != null) goto L11;
        PthreadThreadV2 r102 = new PthreadThreadV2(a.f514966a, "l/ThreadUtils");     // Catch: Throwable -> L14
        f514964b = r102;     // Catch: Throwable -> L14
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L14
    L11:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void b(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        f514965c.post(r100);
    }
}
