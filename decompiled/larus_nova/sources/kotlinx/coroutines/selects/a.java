package kotlinx.coroutines.selects;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: classes6.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f505107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f505108b;

    public a(l r100, b r101) {
        this.f505107a = r100;
        this.f505108b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f505107a.f(this.f505108b, Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
