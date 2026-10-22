package wta;

import android.app.Activity;
import android.view.Window;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f561269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f561270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.dypay.webview.d f561271c;

    public e(boolean r100, Activity r101, com.ss.android.dypay.webview.a.C4736a r102) {
        this.f561269a = r100;
        this.f561270b = r101;
        this.f561271c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L16;
        return;
    L16:
        throw th;
    L3:
        if (this.f561269a == false) goto L7;
        Window r100 = this.f561270b.getWindow();     // Catch: Throwable -> L12
        if (r100 == null) goto L10;
        r100.clearFlags(8192);     // Catch: Throwable -> L12
    L10:
        qta.a.g(this.f561271c, null, 0, null, 7);     // Catch: Throwable -> L12
        return;
    L7:
        Window r101 = this.f561270b.getWindow();     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        r101.addFlags(8192);     // Catch: Throwable -> L12
        goto L10
    }
}
