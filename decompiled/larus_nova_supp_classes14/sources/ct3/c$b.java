package ct3;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class c$b implements Runnable {
    public final /* synthetic */ WeakReference a;
    public final /* synthetic */ c b;

    @Override // java.lang.Runnable
    public final void run() {
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    L16:
        return;
    L3:
        if (this.b.c != null) goto L5;
        return;
    L5:
        if (this.a.get() == null) goto L15;
        ((View) this.a.get()).getViewTreeObserver().removeOnGlobalLayoutListener(this.b.c);     // Catch: Throwable -> L8
        return;
    }

    public c$b(c r1, WeakReference r2) {
        this.b = r1;
        this.a = r2;
    }
}
