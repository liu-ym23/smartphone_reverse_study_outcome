package i83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ HeadAdapter a;
    public final /* synthetic */ Runnable b;

    public d(HeadAdapter r1, Runnable r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    L13:
        return;
    L3:
        if (this.a.e.isComputingLayout() == true) goto L9;
        this.b.run();     // Catch: Throwable -> L6
        return;
    }
}
