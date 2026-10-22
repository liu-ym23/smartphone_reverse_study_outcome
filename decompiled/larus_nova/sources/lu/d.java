package lu;

import android.app.Activity;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f510773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f510774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f510775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ju.b f510776d;

    public d(Activity r100, int r101) {
        this.f510773a = r100;
        this.f510774b = r101;
        this.f510775c = "live_detail";
        this.f510776d = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler r100 = g.f510784a;     // Catch: Throwable -> L4
        g.a(this.f510773a, 3, this.f510774b, this.f510775c, this.f510776d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
