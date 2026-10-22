package kotlinx.coroutines;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<q0> f505154a = null;

    static {
        f505154a = new ThreadLocal();
    }

    public static q0 a() {
        ThreadLocal<q0> r100 = f505154a;
        q0 r101 = r100.get();
        if (r101 != null) goto L6;
        e r102 = new e(ThreadMethodProxy.currentThread());
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }
}
