package ioc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.suite.lark.platform.component.cta.newstyle.adapter.VersionInfoAdapter;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f495245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VersionInfoAdapter f495246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f495247c;

    public b(int r100, VersionInfoAdapter r101, int r102) {
        this.f495245a = r100;
        this.f495246b = r101;
        this.f495247c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = this.f495245a;     // Catch: Throwable -> L7
        if (r100 == (-1)) goto L5;
        this.f495246b.notifyItemChanged(r100);     // Catch: Throwable -> L7
    L5:
        this.f495246b.notifyItemChanged(this.f495247c);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
