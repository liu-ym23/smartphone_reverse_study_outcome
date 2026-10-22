package com.larus.bmhome.chat.trace.appreciable;

import com.google.gson.Gson;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f310106a = 0;

    static {
    }

    public static JSONObject a(Object r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        if (r100 != null) goto L7;
        JSONObject r103 = null;
    L10:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r104) == true) goto L19;
        r101 = r104;
    L19:
        return (JSONObject) r101;
    L7:
        if ((r100 instanceof JSONObject) == false) goto L9;
        r103 = (JSONObject) r100;     // Catch: Throwable -> L12
        goto L10
    L9:
        r103 = new JSONObject(new Gson().toJson(r100));     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    public static JSONObject b(Object r100, Object r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        JSONObject r103 = a(r100);     // Catch: Throwable -> L13
        JSONObject r104 = a(r101);     // Catch: Throwable -> L13
        if (r103 != null) goto L5;
        return r104;
    L5:
        if (r104 != null) goto L7;
        return r103;
    L7:
        Iterator<String> r105 = r103.keys();     // Catch: Throwable -> L13
    L9:
        if (r105.hasNext() == false) goto L12;
        String r106 = r105.next();     // Catch: Throwable -> L13
        r104.put(r106, r103.get(r106));     // Catch: Throwable -> L13
        goto L9
    L12:
        return r104;
    L13:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r108) == false) goto L18;
        r108 = null;
    L18:
        return (JSONObject) r108;
    }
}
