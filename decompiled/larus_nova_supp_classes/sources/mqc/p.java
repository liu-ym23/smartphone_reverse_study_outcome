package mqc;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.volcengine.zeus.Zeus;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class p {
    public static final Queue<Runnable> a = null;
    public static Thread b;
    public static final Handler c = null;

    static {
        a = new ArrayDeque();
        c = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r3) {
        Intrinsics.checkNotNullParameter(r3, "runnable");
        if (Zeus.hasInit() == false) goto L6;
        r3.run();
        return;
    L6:
        Queue<Runnable> r0 = a;
        monitor-enter(r0);
        ((ArrayDeque) r0).add(r3);     // Catch: Throwable -> L14
        if (b != null) goto L11;
        PthreadThreadV2 r4 = new PthreadThreadV2(a.a, "l/ThreadUtils");     // Catch: Throwable -> L14
        b = r4;     // Catch: Throwable -> L14
        ThreadMethodProxy.start(r4);     // Catch: Throwable -> L14
    L11:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static void b(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r2.run();
        return;
    L5:
        c.post(r2);
    }
}
