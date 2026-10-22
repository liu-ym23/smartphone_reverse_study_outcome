package vq7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static void a(String r100) throws InvocationTargetException {
        lq7.a r101 = lq7.a.f510306a;
        Intrinsics.checkNotNullParameter(r100, "url");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        monitor-enter(r101);     // Catch: Throwable -> L18
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L6:
        if (lq7.a.f510308c != null) goto L12;
        Class<?> r103 = lq7.a.f510307b;     // Catch: Throwable -> L15
        if (r103 == null) goto L10;
        Method r104 = r103.getMethod("preconnectUrl", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L15
    L11:
        lq7.a.f510308c = r104;     // Catch: Throwable -> L15
        goto L12
    L10:
        r104 = null;
    L12:
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L18
        Method r106 = lq7.a.f510308c;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L18
        Object r107 = Result.m9449constructorimpl(r106.invoke(null, new Object[]{r100, 1}));     // Catch: Throwable -> L18
    L20:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 != null) goto L24;
        return;
    L24:
        throw new InvocationTargetException(r108);
    L18:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }
}
