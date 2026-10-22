package zd9;

import com.google.gson.Gson;
import com.larus.im.internal.delegate.c0;
import java.lang.reflect.Type;
import kotlin.ExceptionsKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f571481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f571482b = null;

    public h() {
    }

    static {
        f571481a = new h();
        f571482b = new Gson();
    }

    public static String c(Object r100) {
        Object r101 = null;
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof String) == true) goto L8;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        Object r103 = Result.m9449constructorimpl(f571482b.toJson(r100));     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        c0 r105 = c0.f348199b;
        StringBuilder r106 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r104, "<this>");
        r106.append(ExceptionsKt.stackTraceToString(r104));
        r105.e("GsonHolder", r106.toString());
    L17:
        if (Result.m9455isFailureimpl(r103) == true) goto L21;
        r101 = r103;
    L21:
        return (String) r101;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L8:
        return (String) r100;
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L24;
        return null;
    L24:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(f571482b.fromJson(r100, r101));     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L20;
        c0 r106 = c0.f348199b;
        StringBuilder r107 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r107.append(ExceptionsKt.stackTraceToString(r105));
        r106.e("GsonHolder", r107.toString());
    L20:
        if (Result.m9455isFailureimpl(r104) == false) goto L23;
        return null;
    L23:
        return r104;
    L14:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L10
    }

    public static Object b(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (StringsKt.isBlank(r100) == false) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L21;
        return null;
    L21:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(f571482b.fromJson(r100, r101));     // Catch: Throwable -> L11
    L13:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L17;
        c0 r106 = c0.f348199b;
        StringBuilder r107 = new StringBuilder("fromJson failed, stack: ");
        Intrinsics.checkNotNullParameter(r105, "<this>");
        r107.append(ExceptionsKt.stackTraceToString(r105));
        r106.e("GsonHolder", r107.toString());
    L17:
        if (Result.m9455isFailureimpl(r104) == false) goto L20;
        return null;
    L20:
        return r104;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L5:
        r102 = false;
        goto L7
    }
}
