package o5a;

import android.view.inputmethod.InputMethodManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes32.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f522130a;

    @Override // java.lang.Runnable
    public final void run() {
        ((InputMethodManager) this.f522130a.f380859e.getSystemService("input_method")).hideSoftInputFromWindow(this.f522130a.f522108h.getWindowToken(), 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r100) {
        this.f522130a = r100;
    }
}
