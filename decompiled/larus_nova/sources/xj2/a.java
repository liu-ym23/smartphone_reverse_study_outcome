package xj2;

import com.larus.apm.impl.protector.RunnableProtector;
import sg2.v;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gi2.a f564089a;

    public a(gi2.a r100) {
        this.f564089a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v r100 = new v("livesdk_list_switch_show", this.f564089a);     // Catch: Throwable -> L4
        r100.c("area_type", "list_head");     // Catch: Throwable -> L4
        r100.i(null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
