package wt7;

import com.flow.kmp.common.platform.PlatformLoggerLevel;
import java.util.Locale;
import juc.d;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.a0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public c() {
    }

    public static Object a(String r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, "serializer");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        c r103 = a.f561230a;
        if (a.f561231b == true) goto L15;
        a0.INSTANCE.getClass();
        String r104 = a0.f526802a;
        Locale r105 = Locale.ROOT;
        if (Intrinsics.areEqual(r104.toLowerCase(r105), r100.toLowerCase(r105)) == false) goto L34;
        return null;
    L34:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L24
        Object r107 = Result.m9449constructorimpl(xt7.d.f565073b.c(r101, r100));     // Catch: Throwable -> L24
    L26:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L30;
        c r109 = a.f561230a;
        PlatformLoggerLevel r110 = PlatformLoggerLevel.ERROR;
        b.a(r110, "PlatformSerializer", "fromJson error: " + r100);
        Intrinsics.checkNotNullParameter(r108, "<this>");
        b.a(r110, "PlatformSerializer", ExceptionsKt.stackTraceToString(r108));
    L30:
        if (Result.m9455isFailureimpl(r107) == false) goto L33;
        return null;
    L33:
        return r107;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L15:
        if (r100.length() != 4) goto L34;
        a0.INSTANCE.getClass();
        if (StringsKt.equals(r100, a0.f526802a, true) == false) goto L34;
        return null;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public static String b(Object r100, d r101) {
        Intrinsics.checkNotNullParameter(r101, "serializer");
        Object r102 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L8;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(xt7.d.f565073b.a(r101, r100));     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        c r106 = a.f561230a;
        PlatformLoggerLevel r107 = PlatformLoggerLevel.ERROR;
        b.a(r107, "PlatformSerializer", "toJson error: " + r100);
        Intrinsics.checkNotNullParameter(r105, "<this>");
        b.a(r107, "PlatformSerializer", ExceptionsKt.stackTraceToString(r105));
    L17:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r102 = r104;
    L21:
        return (String) r102;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L8:
        return (String) r100;
    }
}
