package qb4;

import com.bytedance.bdturing.VerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class f0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f532345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ VerifyWebView f532346c;

    @Override // java.lang.Runnable
    public final void run() {
        g0 r100 = this.f532346c.f201723a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.b(this.f532344a, this.f532345b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public f0(VerifyWebView r100, int r101, String r102) {
        this.f532346c = r100;
        this.f532344a = r101;
        this.f532345b = r102;
    }
}
