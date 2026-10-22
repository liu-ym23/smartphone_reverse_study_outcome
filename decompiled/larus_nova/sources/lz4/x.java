package lz4;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes16.dex */
public final class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f511432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f511433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f511434c;

    @Override // java.lang.Runnable
    public final void run() {
        w r100 = this.f511434c;     // Catch: Throwable -> L7
        WebView r101 = r100.f511367c;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.scrollTo(0, this.f511432a * r100.f511373i);     // Catch: Throwable -> L7
    L5:
        this.f511433b.countDown();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public x(w r100, int r101, CountDownLatch r102) {
        this.f511434c = r100;
        this.f511432a = r101;
        this.f511433b = r102;
    }
}
