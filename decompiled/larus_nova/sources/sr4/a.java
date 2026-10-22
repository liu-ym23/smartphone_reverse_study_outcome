package sr4;

import com.bytedance.ee.bear.bitable.common.widgets.rating.BTRatingBar;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BTRatingBar f543207a;

    public a(BTRatingBar r100) {
        this.f543207a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f543207a.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
