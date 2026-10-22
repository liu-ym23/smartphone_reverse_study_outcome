package com.larus.account.saas.runtime.internal.util;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class GsonHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f286473a = null;

    public GsonHolder() {
    }

    static {
        f286473a = LazyKt.lazy(GsonHolder$gson$2.INSTANCE);
    }

    public static String c(Object r100) {
        if ((r100 instanceof String) == true) goto L21;
        Object r101 = null;
        if (r100 == null) goto L22;
        Gson r102 = (Gson) f286473a.getValue();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        Object r104 = Result.m9449constructorimpl(r102.toJson(r100));     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r104) == true) goto L18;
        r101 = r104;
    L18:
        return (String) r101;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    L21:
        return (String) r100;
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
        Gson r103 = (Gson) f286473a.getValue();
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

    public static Object b(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        return null;
    L12:
        Gson r103 = (Gson) f286473a.getValue();
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
