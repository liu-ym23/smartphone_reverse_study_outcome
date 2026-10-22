package iz4;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes16.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f496695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f496696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f496697c;

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f496697c;     // Catch: Throwable -> L7
        WebView r101 = r100.f496632c;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.scrollTo(0, this.f496695a * r100.f496638i);     // Catch: Throwable -> L7
    L5:
        this.f496696b.countDown();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public x(w r100, int r101, CountDownLatch r102) {
        this.f496697c = r100;
        this.f496695a = r101;
        this.f496696b = r102;
    }
}
