package com.bytedance.ug.sdk.luckycat.impl.manager;

import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ug.sdk.luckycat.impl.utils.u f271317a;

    public static final class a {
    }

    static {
    }

    public final JSONObject a() {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L28
        com.bytedance.ug.sdk.luckycat.impl.utils.u r102 = this.f271317a;     // Catch: Throwable -> L28
        if (r102 != null) goto L7;
        r102 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();     // Catch: Throwable -> L28
    L7:
        String r103 = r102.c("cat_settings", "");     // Catch: Throwable -> L28
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L42;
        JSONObject r105 = new JSONObject(r103);     // Catch: Throwable -> L17
    L24:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L28
    L30:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L34;
        r107.printStackTrace();
    L34:
        if (Result.m9455isFailureimpl(r106) == true) goto L38;
        r100 = r106;
    L38:
        return (JSONObject) r100;
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
    L42:
        com.bytedance.ug.sdk.luckycat.impl.utils.u r108 = this.f271317a;     // Catch: Throwable -> L25
        if (r108 != null) goto L23;
        r108 = com.bytedance.ug.sdk.luckycat.impl.utils.u.a();     // Catch: Throwable -> L25
    L23:
        r105 = new JSONObject(r108.c("app_settings", "")).optJSONObject("sdk_key_LuckyCat");     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L28
        return null;
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L28:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public e0() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(com.bytedance.ug.sdk.luckycat.impl.utils.u.a());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        this.f271317a = (com.bytedance.ug.sdk.luckycat.impl.utils.u) r101;
        return;
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
