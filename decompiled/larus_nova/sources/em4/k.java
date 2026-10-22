package em4;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class k {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f473068a;

        public a(Function0<Unit> r100) {
            this.f473068a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f473068a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final void a(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = d.f473061a;
        Intrinsics.checkNotNullParameter("DuxLogger", "tag");
        Intrinsics.checkNotNullParameter(r100, "msg");
    }

    public static final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(new a(r100));
    }
}
