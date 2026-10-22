package bh2;

import com.bytedance.android.livesdk.livecommerce.dialog.ECBottomDialog;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class n implements Runnable {
    public final /* synthetic */ Runnable a;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public n(ECBottomDialog.a r1) {
        this.a = r1;
    }
}
