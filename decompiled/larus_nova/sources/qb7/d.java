package qb7;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends b<Unit> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Handler f532412e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f532413f = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f532414a = null;

        static {
            f532414a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d r100 = d.f532413f;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            r100.c(b.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // qb7.b
    public final String b() {
        return "TokenBeatWaitTimeoutTask";
    }

    static {
        f532413f = new d();
        f532412e = new Handler(Looper.getMainLooper());
    }

    @Override // qb7.b
    public final void d() {
        com.bytedance.sdk.account.settings.common.a.a();
        int r100 = com.bytedance.sdk.account.settings.common.a.L;
        if (r100 <= 0) goto L5;
        f532412e.postDelayed(a.f532414a, r100);
        return;
    L5:
        c(b.a());
    }

    public d() {
    }
}
