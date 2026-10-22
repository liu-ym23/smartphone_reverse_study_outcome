package zj6;

import android.graphics.Rect;
import com.bytedance.live.photoviewer.transition.TransitionLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransitionLayout f572491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f572492b;

    public b(TransitionLayout r100, Rect r101) {
        this.f572491a = r100;
        this.f572492b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TransitionLayout r100 = this.f572491a;     // Catch: Throwable -> L4
        r100.f255705k = 0;     // Catch: Throwable -> L4
        r100.f255695a = this.f572492b;     // Catch: Throwable -> L4
        r100.f255703i.start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
