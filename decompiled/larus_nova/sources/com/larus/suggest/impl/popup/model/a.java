package com.larus.suggest.impl.popup.model;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a {
    public static final String a(JsonElement r100) {
        Object r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isJsonPrimitive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L25;
        JsonPrimitive r102 = r100.getAsJsonPrimitive();
        if (r102 == null) goto L26;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        Object r104 = Result.m9449constructorimpl(r102.getAsString());     // Catch: Throwable -> L14
    L17:
        if (Result.m9455isFailureimpl(r104) == true) goto L21;
        r101 = r104;
    L21:
        return (String) r101;
    L14:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L26:
        return null;
    L25:
        return null;
    }
}
