package z7c;

import android.widget.EditText;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f570743a;

    public b(EditText r100) {
        this.f570743a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EditText r100 = this.f570743a;     // Catch: Throwable -> L4
        r100.setSelection(r100.length());     // Catch: Throwable -> L4
        this.f570743a.requestFocus();     // Catch: Throwable -> L4
        KeyboardUtils.showKeyboard(this.f570743a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
