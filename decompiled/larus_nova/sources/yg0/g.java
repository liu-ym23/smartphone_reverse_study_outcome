package yg0;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f567471a = null;

    static {
        f567471a = new g();
    }

    public g() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        ln0.a r100 = h.f567472a;     // Catch: Throwable -> L7
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("newLayoutConfigManager");     // Catch: Throwable -> L7
    L5:
        r100.b();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
