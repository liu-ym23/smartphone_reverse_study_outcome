package vs4;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f557047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f557048b;

    public u(t r100, String r101) {
        this.f557047a = r100;
        this.f557048b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t.a(this.f557047a, CollectionsKt.listOf(this.f557048b), 2);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
