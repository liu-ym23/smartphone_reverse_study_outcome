package srb;

import com.facebook.soloader.SoLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f543273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f543274b;

    static {
        new ReentrantLock();
    }

    public static void a() {
        if (f543274b == true) goto L10;
        Log.i("CardPreload", "current thread name" + ThreadMethodProxy.currentThread().getName());     // Catch: IllegalStateException -> L6
        SoLoader.init(com.ss.android.lark.message.card.b.a().getContext(), false);     // Catch: IllegalStateException -> L6
    L8:
        f543274b = true;
    L6:
        e = move-exception;
        Log.i("CardPreload", e.getMessage());
    L10:
        if (f543273a == false) goto L12;
        return;
    L12:
        f543273a = true;
    }
}
