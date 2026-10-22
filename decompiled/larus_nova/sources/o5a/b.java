package o5a;

import android.view.inputmethod.InputMethodManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f522129a;

    @Override // java.lang.Runnable
    public final void run() {
        ((InputMethodManager) this.f522129a.f380859e.getSystemService("input_method")).showSoftInput(this.f522129a.f522108h, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100) {
        this.f522129a = r100;
    }
}
