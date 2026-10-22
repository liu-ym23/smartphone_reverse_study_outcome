package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class v1 {
    public static final ThreadLocal<q0> a = null;

    static {
        a = new ThreadLocal();
    }

    public static q0 a() {
        ThreadLocal<q0> r0 = a;
        q0 r1 = r0.get();
        if (r1 != null) goto L6;
        e r2 = new e(ThreadMethodProxy.currentThread());
        r0.set(r2);
        return r2;
    L6:
        return r1;
    }
}
