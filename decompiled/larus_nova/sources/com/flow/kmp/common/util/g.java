package com.flow.kmp.common.util;

import kotlin.Deprecated;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static final byte[] a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.encodeToByteArray(r100);
    }

    @Deprecated(message = "temp")
    public static final JSONObject b(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return new JSONObject();
    L12:
        if (StringsKt.startsWith$default(r100, "{", false, 2, null) == false) goto L25;
        if (StringsKt.endsWith$default(r100, com.alipay.sdk.m.u.i.f25855d, false, 2, null) == false) goto L25;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L18
        Object r103 = Result.m9449constructorimpl(new JSONObject(r100));     // Catch: Throwable -> L18
    L20:
        JSONObject r104 = new JSONObject();
        if (Result.m9455isFailureimpl(r103) == false) goto L29;
        r103 = r104;
    L29:
        return (JSONObject) r103;
    L18:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L25:
        return new JSONObject();
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
