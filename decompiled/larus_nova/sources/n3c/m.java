package n3c;

import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m implements ne6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f517030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExecutorService f517031b = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f517032a;

        public a(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f517032a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f517032a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public m() {
    }

    static {
        f517030a = new m();
        f517031b = CoreThreadPool.getDefault().newSerialIODensityThreadPool("PolicyEngine");
    }

    @Override // ne6.e
    public final void a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r100));
    }

    @Override // ne6.e
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new a(r100));
    }

    @Override // ne6.e
    public final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f517031b.execute(new a(r100));
    }
}
