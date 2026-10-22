package j83;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    public b(a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r0 = this.a;     // Catch: Throwable -> L19
        boolean r2 = true;
        if (r0.d() == false) goto L5;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r1 = r0.g;     // Catch: Throwable -> L19
        if (r1 == null) goto L24;
        r1.k0(true);     // Catch: Throwable -> L19
    L24:
        return;
    L5:
        if (r0.p.getVisibility() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L24;
        if (r0.f.a != null) goto L13;
        r2 = false;
    L13:
        if (r2 == false) goto L24;
        r0.p.setVisibility(0);     // Catch: Throwable -> L19
        r0.f.c();     // Catch: Throwable -> L19
        goto L24
    L7:
        r3 = false;
    L19:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    }
}
