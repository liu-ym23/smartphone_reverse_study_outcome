package cd3;

import com.bytedance.android.shopping.deepfeed.slice.view.scrolling.SlcScrollingView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ SlcScrollingView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public e(SlcScrollingView r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SlcScrollingView r0 = this.a;     // Catch: Throwable -> L4
        int r1 = this.b;     // Catch: Throwable -> L4
        int r2 = this.c;     // Catch: Throwable -> L4
        int r3 = SlcScrollingView.g;     // Catch: Throwable -> L4
        r0.a(r1, r2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
