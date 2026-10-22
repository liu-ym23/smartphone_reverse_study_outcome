package j83;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f497693a;

    public b(a r100) {
        this.f497693a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f497693a;     // Catch: Throwable -> L19
        boolean r101 = true;
        if (r100.d() == false) goto L5;
        com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.b r102 = r100.f497679g;     // Catch: Throwable -> L19
        if (r102 == null) goto L24;
        r102.k0(true);     // Catch: Throwable -> L19
    L24:
        return;
    L5:
        if (r100.f497688p.getVisibility() != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L24;
        if (r100.f497678f.f46000a != null) goto L13;
        r101 = false;
    L13:
        if (r101 == false) goto L24;
        r100.f497688p.setVisibility(0);     // Catch: Throwable -> L19
        r100.f497678f.c();     // Catch: Throwable -> L19
        goto L24
    L7:
        r103 = false;
    L19:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L27;
        throw th;
    }
}
