package xz5;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.larus.apm.impl.protector.RunnableProtector;
import hz5.g;
import hz5.l;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrivacyEvent f565520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f565521b;

    public a(PrivacyEvent r100, Throwable r101) {
        this.f565520a = r100;
        this.f565521b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f565520a.b(this.f565521b);     // Catch: Throwable -> L4
        g.f487690b.a(1, this.f565520a);     // Catch: Throwable -> L4
        l.b(this.f565520a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
