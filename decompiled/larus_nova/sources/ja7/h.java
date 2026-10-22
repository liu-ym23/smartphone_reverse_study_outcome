package ja7;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f497910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f497911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qa7.b f497912c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f497913d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f497914e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f497915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ qa7.c f497916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f497917h;

    @Override // java.lang.Runnable
    public final void run() {
    L18:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L26;
        throw th;
    L26:
        return;
    L3:
        if (this.f497910a == true) goto L8;
        View r100 = this.f497911b;     // Catch: Throwable -> L18
        ViewParent r101 = r100.getParent();     // Catch: Throwable -> L18
        if ((r101 instanceof ViewGroup) == false) goto L7;
        ((ViewGroup) r101).removeView(r100);     // Catch: Throwable -> L18
    L7:
        this.f497911b.setVisibility(8);     // Catch: Throwable -> L18
    L8:
        qa7.b r102 = this.f497912c;     // Catch: Throwable -> L18
        monitor-enter(r102);     // Catch: Throwable -> L18
        boolean r103 = r102.f532269a;     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        if (r103 == true) goto L21;
        this.f497917h.a(this.f497913d, this.f497914e, this.f497915f, this.f497916g.c());     // Catch: Throwable -> L18
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    }

    public h(i r100, boolean r101, View r102, qa7.b r103, a r104, a r105, f r106, qa7.c r107) {
        this.f497917h = r100;
        this.f497910a = r101;
        this.f497911b = r102;
        this.f497912c = r103;
        this.f497913d = r104;
        this.f497914e = r105;
        this.f497915f = r106;
        this.f497916g = r107;
    }
}
