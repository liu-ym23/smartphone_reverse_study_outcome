package xkc;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes40.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f564418a;

    public static void a() {
        if (f564418a == true) goto L5;
        return;
    L5:
        ThreadMethodProxy.currentThread().getName();
    }
}
