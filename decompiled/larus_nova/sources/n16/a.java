package n16;

import com.bytedance.ies.bullet.core.k;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<k> f516670a;

    public a(Ref.ObjectRef<k> r100) {
        this.f516670a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f516670a.element;     // Catch: Throwable -> L6
        if (r100.f246516b != null) goto L9;
        b.f516671a.remove(r100.f246515a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
