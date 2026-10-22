package ja7;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f497897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f497898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ qa7.b f497899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f497900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f497901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Runnable f497902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ qa7.c f497903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f497904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ i f497905i;

    public final void a() {
        if (this.f497897a == true) goto L5;
        this.f497898b.setVisibility(8);
    L5:
        qa7.b r100 = this.f497899c;
        monitor-enter(r100);
        boolean r101 = r100.f532269a;     // Catch: Throwable -> L17
        monitor-exit(r100);     // Catch: Throwable -> L17
        if (r101 == true) goto L12;
        this.f497905i.b(this.f497900d, this.f497901e, this.f497902f, this.f497903g.c());
        return;
    L12:
        if (this.f497897a == false) goto L14;
        return;
    L14:
        if (this.f497904h == false) goto L24;
        this.f497898b.setVisibility(0);
        return;
    L24:
        return;
    L17:
        th = move-exception;
        throw th;
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

    public e(i r100, boolean r101, View r102, qa7.b r103, a r104, a r105, c r106, qa7.c r107, boolean r108) {
        this.f497905i = r100;
        this.f497897a = r101;
        this.f497898b = r102;
        this.f497899c = r103;
        this.f497900d = r104;
        this.f497901e = r105;
        this.f497902f = r106;
        this.f497903g = r107;
        this.f497904h = r108;
    }
}
