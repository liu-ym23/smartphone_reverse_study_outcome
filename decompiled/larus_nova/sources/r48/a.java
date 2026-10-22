package r48;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends t57.c {
    @Override // t57.a
    public final String b() {
        return "BadParcelableExceptionPlugin";
    }

    @Override // t57.c
    public final void f() {
    }

    public a() {
    }

    @Override // p57.g
    public final boolean a(Thread r100, Throwable r101) throws Throwable {
        String r102 = r101.getMessage();     // Catch: Throwable -> L15
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r103 == 29) goto L8;
        if (r103 == 28) goto L8;
    L9:
        return false;
    L8:
        if (TextUtils.isEmpty(r102) == true) goto L9;
        if (r102.contains("ClassNotFoundException when unmarshalling: androidx.fragment.app.FragmentManagerState") == true) goto L13;
        return false;
    L13:
        Object[] r104 = {r101.getMessage()};     // Catch: Throwable -> L15
        Logger.Level r105 = Logger.f266614a;     // Catch: Throwable -> L15
        Logger.c("BadParcelableExceptionPlugin", String.format("BadParcelableExceptionPlugin success", r104), Logger.Level.ERROR);     // Catch: Throwable -> L15
        return true;
    L15:
        th = move-exception;
        Object[] r106 = {th.getMessage()};
        Logger.Level r107 = Logger.f266614a;
        Logger.c("BadParcelableExceptionPlugin", String.format("BadParcelableExceptionPlugin error", r106), Logger.Level.ERROR);
        return false;
    }
}
