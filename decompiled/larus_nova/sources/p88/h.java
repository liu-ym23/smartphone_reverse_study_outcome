package p88;

import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes23.dex */
public final class h {
    public static final String a(int r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(AppHost.f326268a.getApplication().getString(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = null;
    L9:
        String r103 = (String) r102;
        if (r103 != null) goto L15;
        return "";
    L15:
        return r103;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
