package com.bytedance.ies.argus.util;

import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class JSONUtilsKt {
    public static final boolean a(JSONObject r100, final JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = true;
        k36.a.a(r100, new JSONUtilsKt$isEqual$1(r101, r102));
        return r102.element;
    }

    public static JSONObject c(JSONObject r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return b(r100, true, r101, null);
    }

    public static final JSONObject d(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        JSONObject r104 = r100.put(r101, r102);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L11:
        Object r106 = r100;
        if (Result.m9452exceptionOrNullimpl(r105) != null) goto L15;
        r106 = r105;
    L15:
        return (JSONObject) r106;
    L6:
        r104 = r100;
    L9:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static final JSONObject e(JSONObject r100, String r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        r102 = "null";
    L6:
        Object r104 = Result.m9449constructorimpl(r100.put(r101, r102));     // Catch: Throwable -> L8
    L10:
        Object r105 = r100;
        if (Result.m9452exceptionOrNullimpl(r104) != null) goto L14;
        r105 = r104;
    L14:
        return (JSONObject) r105;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final JSONObject b(JSONObject r100, boolean r101, JSONObject r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r102 != null) goto L32;
        return r100;
    L32:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L25
        Iterator<String> r105 = r102.keys();     // Catch: Throwable -> L25
    L7:
        if (r105.hasNext() == false) goto L23;
        String r106 = r105.next();     // Catch: Throwable -> L25
        Object r107 = r102.get(r106);     // Catch: Throwable -> L25
        if (r103 == null) goto L14;
        String r108 = r103 + '_' + r106;     // Catch: Throwable -> L25
        if (r108 == null) goto L14;
        r106 = r108;
    L14:
        if (r101 == false) goto L22;
        if ((r107 instanceof String) == false) goto L18;
        String r109 = (String) r107;     // Catch: Throwable -> L25
    L19:
        if (r109 != null) goto L21;
        r107 = r107.toString();     // Catch: Throwable -> L25
        goto L22
    L21:
        r107 = r109;
        goto L22
    L18:
        r109 = null;
    L22:
        d(r100, r106, r107);     // Catch: Throwable -> L25
        goto L7
    L23:
        Object r110 = Result.m9449constructorimpl(r100);     // Catch: Throwable -> L25
    L27:
        Object r111 = r100;
        if (Result.m9452exceptionOrNullimpl(r110) != null) goto L31;
        r111 = r110;
    L31:
        return (JSONObject) r111;
    L25:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }
}
