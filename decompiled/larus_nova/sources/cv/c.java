package cv;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f465475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f465476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f465477c;

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f465477c.f465463o, this.f465475a, this.f465476b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r100, View r101, View r102) {
        this.f465477c = r100;
        this.f465475a = r101;
        this.f465476b = r102;
    }
}
