package uyb;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f552158a = null;

    /* JADX INFO: renamed from: uyb.a$a, reason: collision with other inner class name */
    public static final class RunnableC7946a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f552159a;

        public RunnableC7946a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f552159a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f552159a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f552158a = new Handler(Looper.getMainLooper());
    }
}
