package com.ss.android.lark.officesdk.minutes.service.recording.common.core.sessionstatehandler;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f434593a = null;

    static {
        f434593a = new e();
    }

    public e() {
    }

    public static Integer a(JSONObject r100) {
        if (r100 != null) goto L5;
    L10:
        return null;
    L5:
        if (r100.has("denyType") == false) goto L8;
        return Integer.valueOf(r100.optInt("denyType"));
    L8:
        if (r100.has("deny_type") == false) goto L10;
        return Integer.valueOf(r100.optInt("deny_type"));
    }

    public static Integer b(ErrorResult r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L17;
        if (r100 != null) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == true) goto L17;
        boolean r104 = false;
    L18:
        Object r105 = null;
        if (r104 == true) goto L21;
        return null;
    L21:
        String r106 = r100.getDebugMsg();
        if (r106 != null) goto L24;
    L27:
        boolean r107 = true;
    L28:
        if (r107 == true) goto L66;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L32
        Object r109 = Result.m9449constructorimpl(new JSONObject(r106));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r109) == false) goto L37;
        r109 = null;
    L37:
        JSONObject r110 = (JSONObject) r109;
        if (r110 == null) goto L67;
        Integer r111 = a(r110.optJSONObject("data"));
        if (r111 != null) goto L65;
        String r112 = r110.optString("message");
        Intrinsics.checkNotNull(r112);
        if (r112.length() <= 0) goto L46;
        r101 = true;
    L46:
        if (r101 == true) goto L49;
        r112 = null;
    L49:
        if (r112 == null) goto L68;
        Object r113 = Result.m9449constructorimpl(new JSONObject(r112));     // Catch: Throwable -> L53
    L56:
        if (Result.m9455isFailureimpl(r113) == true) goto L60;
        r105 = r113;
    L60:
        return a((JSONObject) r105);
    L53:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L56
    L68:
        return null;
    L65:
        return Integer.valueOf(r111.intValue());
    L67:
        return null;
    L32:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L66:
        return null;
    L24:
        if (r106.length() == 0) goto L27;
        r107 = false;
        goto L28
    L11:
        if (r100.getStatus() != 220202) goto L13;
        r103 = true;
    L17:
        r104 = true;
        goto L18
    L5:
        if (r100.getCode() != 220202) goto L7;
        r102 = true;
        goto L8
    }
}
