package ic3;

import com.bytedance.android.bst.api.f;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ com.bytedance.android.bst.api.d a;

    public c(com.bytedance.android.bst.api.d r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r0 = f.b;     // Catch: Throwable -> L4
        com.bytedance.android.bst.api.d r1 = this.a;     // Catch: Throwable -> L4
        r0.getClass();     // Catch: Throwable -> L4
        f.a(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
