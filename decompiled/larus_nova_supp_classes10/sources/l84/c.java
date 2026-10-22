package l84;

import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements Runnable {
    public final /* synthetic */ BDLocationCallback a;
    public final /* synthetic */ BDLocationException b;

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onError(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(l0 r1, BDLocationException r2) {
        this.a = r1;
        this.b = r2;
    }
}
