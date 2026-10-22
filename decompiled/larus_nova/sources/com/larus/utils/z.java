package com.larus.utils;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f375499a = null;

    static {
        f375499a = new Gson();
    }

    public static JSONObject b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        return null;
    L21:
        return new JSONObject(r100);
    L13:
        th = move-exception;
        AppHost.Companion r102 = AppHost.f326268a;
        if (r102.isDebug() == false) goto L17;
    L18:
        th.printStackTrace();
    L19:
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th);
        return null;
    L17:
        if (r102.isTestChannel() == false) goto L19;
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L9
    }

    public static String c(Object r100) {
        Gson r101 = f375499a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r101.toJson(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L11;
        r103 = null;
    L11:
        return (String) r103;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static Object a(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "cls");
        Gson r102 = f375499a;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        Object r104 = Result.m9449constructorimpl(r102.fromJson(r100, r101));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        return null;
    L13:
        return r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
