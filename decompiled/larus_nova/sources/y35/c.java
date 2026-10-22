package y35;

import com.bytedance.ee.bear.domain.BearUrl;
import com.larus.apm.impl.protector.RunnableProtector;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BearUrl f565856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f565857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f565858c;

    public c(BearUrl r100, String r101, String r102) {
        this.f565856a = r100;
        this.f565857b = r101;
        this.f565858c = r102;
    }

    public final void a() {
        tt5.a.h("SyncBlockResolver", "insert...");
        m0 r100 = new m0();
        r100.f501550k = this.f565856a.f222561b;
        r100.f501541b = this.f565857b;
        r100.f501542c = this.f565858c;
        e0.m().w(r100);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
