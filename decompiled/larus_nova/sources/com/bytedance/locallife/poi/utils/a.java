package com.bytedance.locallife.poi.utils;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f264218a = null;

    static {
        f264218a = new a();
    }

    public a() {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonStr");
        Intrinsics.checkNotNullParameter("preload_config", "keyToRemove");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        JSONObject r102 = new JSONObject(r100);     // Catch: Throwable -> L5
        r102.remove("preload_config");     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(r102.toString());     // Catch: Throwable -> L5
    L7:
        Object r104 = r100;
        if (Result.m9455isFailureimpl(r103) == true) goto L12;
        r104 = r103;
    L12:
        return (String) r104;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
