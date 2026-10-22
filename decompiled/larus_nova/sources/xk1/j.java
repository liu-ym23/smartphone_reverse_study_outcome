package xk1;

import android.app.Activity;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tp1.a[] f564160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f564161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sp1.a f564162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f564163d;

    public final void a() {
        if (this.f564163d.f564149e != null) goto L6;
        return;
    L6:
        if (NetworkUtils.g(jc1.a.b()) == false) goto L9;
        this.f564163d.c(this.f564160a, this.f564161b, this.f564162c);
        return;
    L9:
        final i r100 = this.f564163d;
        if (r100.f564152h == false) goto L13;
        r100.c(this.f564160a, this.f564161b, this.f564162c);
        return;
    L13:
        final tp1.a[] r101 = this.f564160a;
        final boolean r102 = this.f564161b;
        final sp1.a r103 = this.f564162c;
        WeakReference<Activity> r104 = com.bytedance.android.live.core.utils.a.f66107a;
        if (r104 == null) goto L24;
        Activity r105 = r104.get();
        if (r105 != null) goto L19;
        return;
    L19:
        if (r105.isFinishing() == true) goto L25;
        r100.f564153i = d.a(r105, new e(r100), new f(r100, r101, r102, r103));
        return;
    L25:
        return;
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

    public j(i r100, tp1.a[] r101) {
        this.f564163d = r100;
        this.f564160a = r101;
        this.f564161b = true;
        this.f564162c = null;
    }
}
