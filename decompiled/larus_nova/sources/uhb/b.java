package uhb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeEditText f550116a;

    @Override // java.lang.Runnable
    public final void run() {
        VerifyCodeEditText r100 = this.f550116a;     // Catch: Throwable -> L8
        CodeView[] r101 = r100.f423916d;     // Catch: Throwable -> L8
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length <= 0) goto L15;
        r100.f423913a.setPadding(r101[0].getWidth() / 2, 0, 0, 0);     // Catch: Throwable -> L8
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(VerifyCodeEditText r100) {
        this.f550116a = r100;
    }
}
