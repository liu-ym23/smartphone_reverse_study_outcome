package tx5;

import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.AsyncLogReporter;
import com.larus.apm.impl.protector.RunnableProtector;
import hx5.b;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements AsyncLogReporter {

    /* JADX INFO: renamed from: tx5.a$a, reason: collision with other inner class name */
    public class C7791a extends hx5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f547824a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f547824a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C7791a(long r100, Runnable r101) {
            this.f547824a = r101;
            super(r100, 0);
        }
    }

    public a() {
    }

    @Override // com.bytedance.retrofit2.AsyncLogReporter
    public final void postDelayed(Runnable r100, long r101) {
        b.a(NetworkAsyncTaskType.NETWORK).b(new C7791a(r101, r100));
    }
}
