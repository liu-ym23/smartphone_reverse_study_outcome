package e08;

import android.view.View;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUISearchView f470653a;

    @Override // java.lang.Runnable
    public final void run() {
        LKUISearchView r100 = this.f470653a;     // Catch: Throwable -> L7
        View.OnFocusChangeListener r101 = r100.D;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.onFocusChange(r100.f284302w, false);     // Catch: Throwable -> L7
    L5:
        LKUISearchView.b(this.f470653a.f284302w);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c(LKUISearchView r100) {
        this.f470653a = r100;
    }
}
