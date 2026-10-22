package rfc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.graffiti.GraffitiView;

/* JADX INFO: loaded from: classes38.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f537661a;

    public final void a() {
        GraffitiView r100 = this.f537661a;
        com.ss.android.photoeditor.graffiti.b r101 = r100.f449209j;
        int r102 = r101.f449232o;
        int r103 = r101.f449231n;
        r100.n();
        this.f537661a.j();
        GraffitiView r104 = this.f537661a;
        r104.f449209j.e(r104.f449204e);
        this.f537661a.setPaintSize(r103);
        this.f537661a.setPaintColor(r102);
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

    public g(GraffitiView r100) {
        this.f537661a = r100;
    }
}
