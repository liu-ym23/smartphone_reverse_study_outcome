package va3;

import android.content.Context;
import android.widget.ViewAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends ViewAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f553931a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f553932a;

        public a(c r100) {
            this.f553932a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f553932a.showNext();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f553931a = new a(this);
    }
}
