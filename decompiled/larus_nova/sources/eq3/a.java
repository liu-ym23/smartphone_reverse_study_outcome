package eq3;

import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowInnerFlowAdapter f473481a;

    public a(ECWindowInnerFlowAdapter r100) {
        this.f473481a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f473481a.f189223g.invoke();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
