package z2;

import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes43.dex */
public final class o {
    public static final String a(String r100) {
        if (r100 != null) goto L15;
    L13:
        return "null";
    L15:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100).buildUpon().clearQuery().toString());     // Catch: Throwable -> L5
    L7:
        Object r103 = r100;
        if (Result.m9455isFailureimpl(r102) == true) goto L11;
        r103 = r102;
    L11:
        String r104 = (String) r103;
        if (r104 == null) goto L13;
        return r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
