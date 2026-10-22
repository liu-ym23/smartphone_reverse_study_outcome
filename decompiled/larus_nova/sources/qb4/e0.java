package qb4;

import com.bytedance.bdturing.VerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class e0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f532341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f532342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VerifyWebView f532343d;

    @Override // java.lang.Runnable
    public final void run() {
        g0 r100 = this.f532343d.f201723a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f532340a, this.f532341b, this.f532342c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public e0(VerifyWebView r100, int r101, String r102, String r103) {
        this.f532343d = r100;
        this.f532340a = r101;
        this.f532341b = r102;
        this.f532342c = r103;
    }
}
