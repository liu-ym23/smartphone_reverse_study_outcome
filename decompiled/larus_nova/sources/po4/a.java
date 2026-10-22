package po4;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f530045a;

    public a(View r100) {
        this.f530045a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f530045a.setPivotX(0.0f);     // Catch: Throwable -> L4
        View r100 = this.f530045a;     // Catch: Throwable -> L4
        r100.setPivotY(r100.getHeight() / 2.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
