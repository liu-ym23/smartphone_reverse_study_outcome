package z7c;

import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardFunctionEditText f570773a;

    public j(KeyboardFunctionEditText r100) {
        this.f570773a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        KeyboardFunctionEditText r100 = this.f570773a;     // Catch: Throwable -> L4
        r100.setSelection(r100.length());     // Catch: Throwable -> L4
        this.f570773a.requestFocus();     // Catch: Throwable -> L4
        KeyboardUtils.showKeyboard(this.f570773a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
