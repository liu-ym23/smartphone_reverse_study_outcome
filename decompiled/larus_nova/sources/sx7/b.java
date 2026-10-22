package sx7;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes23.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f543833a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f543834b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f543835a;

        public final void a() {
            Runnable r100 = this.f543835a;
            if (r100 != null) goto L13;
            return;
        L13:
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
            r100.run();     // Catch: Throwable -> L7
            Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
        L9:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L15;
            Map<Class<?>, ox7.a> r104 = ox7.b.f527091a;
            ox7.b.b("SafeWrapper", "fail to execute runnable = " + this.f543835a + " error = " + Log.getStackTraceString(r103), null);
            return;
        L15:
            return;
        L7:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L9
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

        public a(Runnable r100) {
            this.f543835a = r100;
        }
    }

    static {
        f543833a = new Handler(Looper.getMainLooper());
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("background_thread_utils");
        ThreadMethodProxy.start(r100);
        f543834b = new Handler(r100.getLooper());
    }
}
