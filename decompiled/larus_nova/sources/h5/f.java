package h5;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f483817a = null;

    static {
        f483817a = new f();
    }

    public f() {
    }

    public static Object a(String r100, Class r101) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L20;
        return null;
    L20:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl(com.bytedance.ai.applet.base.gson.e.a(r100, r101));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        return null;
    L19:
        return r104;
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r102 = false;
        goto L9
    }
}
