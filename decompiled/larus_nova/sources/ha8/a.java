package ha8;

import com.google.gson.Gson;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f484395a = null;

    static {
        f484395a = new Gson();
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        Gson r103 = f484395a;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        Object r105 = Result.m9449constructorimpl(r103.fromJson(r100, r101));     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r105) == false) goto L21;
        return null;
    L21:
        return r105;
    L15:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L10
    }
}
