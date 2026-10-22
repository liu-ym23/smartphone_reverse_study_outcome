package ic3;

import com.bytedance.android.bst.api.f;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.bst.api.d f489159a;

    public c(com.bytedance.android.bst.api.d r100) {
        this.f489159a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = f.f41925b;     // Catch: Throwable -> L4
        com.bytedance.android.bst.api.d r101 = this.f489159a;     // Catch: Throwable -> L4
        r100.getClass();     // Catch: Throwable -> L4
        f.a(r101);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
