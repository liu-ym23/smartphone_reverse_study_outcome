package rp6;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.SoftReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoftReference<Handler> f538851a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f538852a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f538852a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f538852a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final Handler a() {
        SoftReference<Handler> r100 = f538851a;
        if (r100 == null) goto L5;
        Handler r101 = r100.get();
    L6:
        if (r101 == null) goto L8;
        return r101;
    L8:
        Handler r102 = new Handler(Looper.getMainLooper());
        f538851a = new SoftReference(r102);
        return r102;
    L5:
        r101 = null;
        goto L6
    }

    public static final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L5;
        a().post(r100);
        return;
    L5:
        r100.run();
    }

    public static final void b(long r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        if (r100 > 0) goto L5;
        a().post(new a(r101));
        return;
    L5:
        a().postDelayed(new a(r101), r100);
    }
}
