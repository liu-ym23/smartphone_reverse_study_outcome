package rfc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.photoeditor.graffiti.GraffitiView;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f537656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f537657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ GraffitiView f537658c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f537658c.setPaintColor(this.f537656a);     // Catch: Throwable -> L4
        this.f537658c.setPaintSize(this.f537657b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(GraffitiView r100, int r101, int r102) {
        this.f537658c = r100;
        this.f537656a = r101;
        this.f537657b = r102;
    }
}
