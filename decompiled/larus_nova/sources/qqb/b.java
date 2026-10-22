package qqb;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f534508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f534509b;

    public b(String r100, Runnable r101) {
        this.f534508a = r100;
        this.f534509b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r100 = this.f534508a;     // Catch: Throwable -> L12
        Runnable r101 = this.f534509b;     // Catch: Throwable -> L12
        String r102 = a.d();     // Catch: Throwable -> L8
        a.f(r100);     // Catch: Throwable -> L6
        r101.run();     // Catch: Throwable -> L6
        a.a();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r102, "traceId");     // Catch: Throwable -> L12
        a.g(r102);     // Catch: Throwable -> L12
        return;
    L6:
        th = th;
    L10:
        a.a();     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r102, "traceId");     // Catch: Throwable -> L12
        a.g(r102);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L8:
        th = th;
        r102 = "";
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L22;
        throw th;
    }
}
