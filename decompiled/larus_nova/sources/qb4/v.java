package qb4;

import com.bytedance.bdturing.TuringVerifyWebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes12.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f532389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f532390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TuringVerifyWebView f532391d;

    @Override // java.lang.Runnable
    public final void run() {
        g0 r100 = this.f532391d.f201705a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.a(this.f532388a, this.f532389b, this.f532390c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public v(TuringVerifyWebView r100, int r101, String r102, String r103) {
        this.f532391d = r100;
        this.f532388a = r101;
        this.f532389b = r102;
        this.f532390c = r103;
    }
}
