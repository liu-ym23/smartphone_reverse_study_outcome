package rx9;

import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements ThreadFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f539875b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539876a;

    public static final class a {
    }

    public static final class b extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ Runnable f539877v;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            Process.setThreadPriority(10);     // Catch: Throwable -> L7
            Runnable r100 = this.f539877v;     // Catch: Throwable -> L7
            if (r100 == null) goto L10;
            r100.run();     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public b(Runnable r100, String r101) {
            this.f539877v = r100;
            super(r101);
        }
    }

    static {
        f539875b = new AtomicInteger(1);
    }

    public r(String r100) {
        Intrinsics.checkNotNullParameter(r100, "prefix");
        this.f539876a = r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        return new b(r100, this.f539876a + '#' + f539875b.getAndIncrement());
    }
}
