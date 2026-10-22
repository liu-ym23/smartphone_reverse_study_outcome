package hta;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f487185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f487186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f487187c;

    @Override // java.lang.Runnable
    public final void run() {
        b.a(this.f487187c.f487170k, this.f487185a, this.f487186b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(b r100, View r101, View r102) {
        this.f487187c = r100;
        this.f487185a = r101;
        this.f487186b = r102;
    }
}
