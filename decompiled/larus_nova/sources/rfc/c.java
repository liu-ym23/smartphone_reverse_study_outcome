package rfc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.graffiti.GraffitiView;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f537654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f537655b;

    public final void a() {
        GraffitiView r100 = this.f537655b;
        int r101 = GraffitiView.f449199n;
        r100.n();
        this.f537655b.j();
        GraffitiView r102 = this.f537655b;
        r102.f449209j.e(r102.f449204e);
        this.f537655b.f449210k = true;
        Runnable r103 = this.f537654a;
        if (r103 == null) goto L5;
        r103.run();
    L5:
        this.f537655b.m();
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

    public c(GraffitiView r100, Runnable r101) {
        this.f537655b = r100;
        this.f537654a = r101;
    }
}
