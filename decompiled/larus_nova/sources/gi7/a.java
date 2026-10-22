package gi7;

import android.app.Activity;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f481455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c.a f481456b;

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f481456b.f481464b, this.f481455a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(c.a r100, Activity r101) {
        this.f481456b = r100;
        this.f481455a = r101;
    }
}
