package e08;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.larksuite.component.ui.navigation.LKUIClearEditText;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LKUISearchView f470652a;

    @Override // java.lang.Runnable
    public final void run() {
        LKUISearchView r100 = this.f470652a;     // Catch: Throwable -> L9
        View.OnFocusChangeListener r101 = r100.D;     // Catch: Throwable -> L9
        if (r101 == null) goto L5;
        r101.onFocusChange(r100.f284302w, true);     // Catch: Throwable -> L9
    L5:
        LKUIClearEditText r102 = this.f470652a.f284302w;     // Catch: Throwable -> L9
        InputMethodManager r103 = (InputMethodManager) r102.getContext().getSystemService("input_method");     // Catch: Throwable -> L9
        if (r103 == null) goto L12;
        r103.showSoftInput(r102, 0);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(LKUISearchView r100) {
        this.f470652a = r100;
    }
}
