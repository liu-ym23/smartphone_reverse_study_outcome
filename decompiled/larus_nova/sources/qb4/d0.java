package qb4;

import com.bytedance.bdturing.VerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class d0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyWebView f532336a;

    @Override // java.lang.Runnable
    public final void run() {
        g0 r100 = this.f532336a.f201723a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.c();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public d0(VerifyWebView r100) {
        this.f532336a = r100;
    }
}
