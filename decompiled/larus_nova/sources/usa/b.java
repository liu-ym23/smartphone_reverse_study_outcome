package usa;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.view.CountDownButton;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownButton f551560a;

    @Override // java.lang.Runnable
    public final void run() {
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L6
        CountDownButton r101 = this.f551560a;     // Catch: Throwable -> L6
        long r102 = r100 - r101.f407759r;     // Catch: Throwable -> L6
        r101.f407759r = r100;     // Catch: Throwable -> L6
        r101.f407758q -= r102 / 1000.0f;     // Catch: Throwable -> L6
        this.f551560a.postInvalidate();     // Catch: Throwable -> L6
        if (this.f551560a.f407758q <= 0.0f) goto L9;
        this.f551560a.f407755n.postDelayed(this, 10);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public b(CountDownButton r100) {
        this.f551560a = r100;
    }
}
