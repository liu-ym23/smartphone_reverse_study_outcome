package iaa;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.platform.depend.ILogDepend;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f488968a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<HandlerThread> f488969b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f488970c = null;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f488971a;

        public final void a() {
            Runnable r100 = this.f488971a;
            if (r100 != null) goto L12;
            return;
        L12:
            r100.run();     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            if ((th instanceof Error) == true) goto L10;
            ILogDepend.f384986a.e("SafeWrapper", "fail to execute runnable = " + this.f488971a + " error = " + Log.getStackTraceString(th));
            return;
        L10:
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

        public a(Runnable r100) {
            this.f488971a = r100;
        }
    }

    static {
        f488968a = new Handler(Looper.getMainLooper());
        f488969b = LazyKt.lazy(new f());
        f488970c = LazyKt.lazy(new g());
    }
}
