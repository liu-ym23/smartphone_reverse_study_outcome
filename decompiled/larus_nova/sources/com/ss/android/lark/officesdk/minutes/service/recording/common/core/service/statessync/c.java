package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.google.gson.Gson;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f434459a = null;

    static {
        f434459a = new c();
    }

    public c() {
    }

    public static String a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Object r102 = null;
        if (r101 == false) goto L26;
        return null;
    L26:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L18
        String r104 = new JSONObject(r100).optString("message");     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L18
        if ((true ^ StringsKt.isBlank(r104)) == true) goto L16;
        r104 = null;
    L16:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r105) == true) goto L25;
        r102 = r105;
    L25:
        return (String) r102;
    L18:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static boolean b(ErrorResult r100) {
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Gson r103 = e0.f444707a;     // Catch: Throwable -> L13
        if (r100 == null) goto L6;
        String r104 = r100.getDebugMsg();     // Catch: Throwable -> L13
    L7:
        gvb.b r105 = (gvb.b) e0.a(r104, gvb.b.class);     // Catch: Throwable -> L13
        if (r105 == null) goto L10;
        MmHttpErrorMsg r106 = r105.b();     // Catch: Throwable -> L13
    L11:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r107) == true) goto L19;
        r101 = r107;
    L19:
        MmHttpErrorMsg r108 = (MmHttpErrorMsg) r101;
        if (r108 != null) goto L23;
        return false;
    L23:
        if (r108.isShow() == false) goto L25;
    L26:
        return true;
    L25:
        if (r108.isOverride() == true) goto L26;
        return false;
    L10:
        r106 = null;
        goto L11
    L6:
        r104 = null;
    L13:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    }
}
