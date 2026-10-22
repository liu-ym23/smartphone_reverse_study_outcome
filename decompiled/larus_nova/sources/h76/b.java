package h76;

import com.bytedance.ies.xelement.banner.Banner;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Banner f483991a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f483991a.h();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(Banner r100) {
        this.f483991a = r100;
    }
}
