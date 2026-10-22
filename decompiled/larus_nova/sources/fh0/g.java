package fh0;

import com.larus.apm.impl.protector.RunnableProtector;
import tf0.p;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f476953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f476954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f476955c;

    public g(f r100) {
        this.f476953a = r100;
        this.f476954b = null;
        this.f476955c = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gh0.a.b("UniversalPlayModeExtHandler", "updateLinkUserMergeDataAndNotify", 4);     // Catch: Throwable -> L4
        f r100 = this.f476953a;     // Catch: Throwable -> L4
        r100.f476947d = this.f476954b;     // Catch: Throwable -> L4
        r100.f476948e = this.f476955c;     // Catch: Throwable -> L4
        r100.c();     // Catch: Throwable -> L4
        f r101 = this.f476953a;     // Catch: Throwable -> L4
        r101.f476946c = System.currentTimeMillis();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
