package mq9;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class e {
    public static final String a(String r100) {
        if (r100 == null) goto L35;
        String r101 = StringsKt.trim(r100).toString();
        boolean r102 = true;
        if (r101.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return r100;
    L12:
        if (StringsKt.startsWith$default(r101, "larus_", false, 2, null) == true) goto L33;
        r101 = "larus_".concat(r101);
    L33:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L26
        Application r105 = AppHost.f326268a.getApplication();     // Catch: Throwable -> L26
        int r106 = r105.getResources().getIdentifier(r101, "string", r105.getPackageName());     // Catch: Throwable -> L26
        if (r106 == 0) goto L23;
        String r107 = r105.getString(r106);     // Catch: Throwable -> L26
        if (r107.length() == 0) goto L22;
        r102 = false;
    L22:
        if (r102 == true) goto L23;
    L24:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L26
    L28:
        Object r109 = r100;
        if (Result.m9452exceptionOrNullimpl(r108) != null) goto L32;
        r109 = r108;
    L32:
        return (String) r109;
    L23:
        r107 = r100;
    L26:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L28
    L8:
        r103 = false;
        goto L9
    L35:
        return null;
    }
}
