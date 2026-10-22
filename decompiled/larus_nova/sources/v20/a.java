package v20;

import com.lynx.react.bridge.PiperData;
import d8.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f552661a = null;

    public a() {
    }

    static {
        f552661a = new a();
    }

    @Override // d8.e
    public final Object a(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(new PiperData(r100, false));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        return null;
    L13:
        return r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
