package ia4;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f488904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f488905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ a f488906c;

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f488906c.f488878e, this.f488904a, this.f488905b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r100, View r101, View r102) {
        this.f488906c = r100;
        this.f488904a = r101;
        this.f488905b = r102;
    }
}
