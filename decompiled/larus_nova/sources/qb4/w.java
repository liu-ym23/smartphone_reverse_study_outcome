package qb4;

import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringVerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TuringVerifyWebView f532392a;

    @Override // java.lang.Runnable
    public final void run() {
        int r100 = n.f532367a;     // Catch: Throwable -> L6
        TuringVerifyWebView r101 = this.f532392a;     // Catch: Throwable -> L6
        EventReport.J(-10001, "h5 load failed after retry", r101.f201715k, r101.f201716l);     // Catch: Throwable -> L6
        g0 r102 = this.f532392a.f201705a;     // Catch: Throwable -> L6
        if (r102 == null) goto L9;
        r102.b(-10001, "h5 load failed");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public w(TuringVerifyWebView r100) {
        this.f532392a = r100;
    }
}
