package mk6;

import ak6.g;
import android.os.Handler;
import com.bytedance.live.richcontent.utils.MainThreadUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements Runnable, ak6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f514319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ak6.e f514320b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f514321a;

        public a(f r100) {
            this.f514321a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f r100 = this.f514321a;     // Catch: Throwable -> L4
            r100.f514320b.b(r100.f514319a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // ak6.a
    public final void dispose() {
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    L14:
        return;
    L3:
        if (this.f514320b == null) goto L10;
        a r100 = new a(this);     // Catch: Throwable -> L7
        ((Handler) MainThreadUtils.f255802a.getValue()).post(r100);     // Catch: Throwable -> L7
        return;
    }

    public f(g r100, ak6.e r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f514319a = r100;
        this.f514320b = r101;
    }
}
