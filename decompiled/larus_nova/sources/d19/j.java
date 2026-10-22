package d19;

import android.animation.Animator;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Animator, Unit> f466463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animator f466464b;

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super Animator, Unit> r100, Animator r101) {
        this.f466463a = r100;
        this.f466464b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function1<Animator, Unit> r100 = this.f466463a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.invoke(this.f466464b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
