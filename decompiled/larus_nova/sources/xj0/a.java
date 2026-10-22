package xj0;

import com.bytedance.android.live.liveinteract.linkpanel.list.BaseRefreshLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseRefreshLayout f564032a;

    public a(BaseRefreshLayout r100) {
        this.f564032a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f564032a.A.run();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
