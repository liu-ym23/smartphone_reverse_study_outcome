package x35;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;

    public g(h r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(eu5.b.a, "render_cache, from = " + this.a.a.e("render_cache", "render_cache_from"));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
