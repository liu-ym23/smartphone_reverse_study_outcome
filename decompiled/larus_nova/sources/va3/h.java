package va3;

import android.content.Context;
import android.widget.ViewAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends ViewAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f553937a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f553938a;

        public a(h r100) {
            this.f553938a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f553938a.showNext();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f553937a = new a(this);
    }
}
