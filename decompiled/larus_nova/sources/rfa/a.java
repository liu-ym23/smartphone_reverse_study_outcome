package rfa;

import android.content.Intent;
import kotlin.Result;
import kotlin.ResultKt;
import p9a.e;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f537647a = 0;

    static {
    }

    public static String a(Intent r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        String r103 = r100.getDataString();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        String r104 = r103.substring(8);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L15;
        e r107 = p9a.b.f528329a;
        p9a.b.c("AppChangeHandler", "getDataPackageName failed: " + r100.getDataString(), r106);
    L15:
        if (Result.m9455isFailureimpl(r105) == true) goto L19;
        r101 = r105;
    L19:
        return (String) r101;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
