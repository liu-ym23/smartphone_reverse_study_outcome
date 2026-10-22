package r48;

import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.services.apm.api.EnsureManager;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends t57.c {
    @Override // t57.a
    public final String b() {
        return "UnsupportedOperationExceptionPlugin";
    }

    @Override // t57.c
    public final void f() {
    }

    public d() {
    }

    @Override // p57.g
    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        String r102 = r101.getMessage();     // Catch: Throwable -> L14
        if ((r101 instanceof UnsupportedOperationException) == true) goto L6;
    L13:
        return false;
    L6:
        if (TextUtils.isEmpty(r102) == true) goto L13;
        if (r102.contains("This isn't a hierarchical URI") == true) goto L11;
        return false;
    L11:
        Logger.a("UnsupportedOperationExceptionPlugin", "Hint UnsupportedOperationExceptionPlugin case ,fix it.");     // Catch: Throwable -> L14
        EnsureManager.ensureNotReachHere(r101, "UnsupportedOperationExceptionPlugin");     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        Object[] r103 = {th.getMessage()};
        Logger.Level r104 = Logger.f266614a;
        Logger.c("UnsupportedOperationExceptionPlugin", String.format("UnsupportedOperationExceptionPlugin error", r103), Logger.Level.ERROR);
        return false;
    }
}
