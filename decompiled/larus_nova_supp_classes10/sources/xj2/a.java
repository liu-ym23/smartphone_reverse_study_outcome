package xj2;

import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements Runnable {
    public final /* synthetic */ gi2.a a;

    public a(gi2.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r0 = new v("livesdk_list_switch_show", this.a);     // Catch: Throwable -> L4
        r0.c("area_type", "list_head");     // Catch: Throwable -> L4
        r0.i(null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
