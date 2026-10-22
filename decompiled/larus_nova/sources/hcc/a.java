package hcc;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.widget.dialog.loadingdialog.view.SpinView;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpinView f484571a;

    @Override // java.lang.Runnable
    public final void run() {
        SpinView r100 = this.f484571a;     // Catch: Throwable -> L10
        float r101 = r100.f445827a + 30.0f;     // Catch: Throwable -> L10
        r100.f445827a = r101;     // Catch: Throwable -> L10
        if (r101 < 360.0f) goto L6;
        r101 = r101 - 360.0f;     // Catch: Throwable -> L10
    L6:
        r100.f445827a = r101;     // Catch: Throwable -> L10
        r100.invalidate();     // Catch: Throwable -> L10
        SpinView r102 = this.f484571a;     // Catch: Throwable -> L10
        if (r102.f445829c == false) goto L13;
        r102.postDelayed(this, r102.f445828b);     // Catch: Throwable -> L10
        return;
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }

    public a(SpinView r100) {
        this.f484571a = r100;
    }
}
