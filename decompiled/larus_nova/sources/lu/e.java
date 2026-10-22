package lu;

import android.app.Activity;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f510777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f510778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f510779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ju.b f510780d;

    public e(Activity r100, int r101) {
        this.f510777a = r100;
        this.f510778b = r101;
        this.f510779c = "live_detail";
        this.f510780d = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler r100 = g.f510784a;     // Catch: Throwable -> L4
        g.a(this.f510777a, 2, this.f510778b, this.f510779c, this.f510780d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
