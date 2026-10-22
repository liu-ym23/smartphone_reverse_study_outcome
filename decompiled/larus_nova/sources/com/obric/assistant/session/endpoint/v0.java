package com.obric.assistant.session.endpoint;

import android.content.ComponentName;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class v0 {
    public static final String a(Bundle r100) {
        Object r101 = "";
        if (r100 != null) goto L29;
        return "";
    L29:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        ArrayList r103 = r100.getParcelableArrayList("android.service.voice.FOREGROUND_ACTIVITIES", ComponentName.class);     // Catch: Throwable -> L15
        if (r103 == null) goto L10;
        ComponentName r104 = (ComponentName) CollectionsKt.firstOrNull(r103);     // Catch: Throwable -> L15
        if (r104 == null) goto L10;
        String r105 = r104.getPackageName();     // Catch: Throwable -> L15
    L11:
        if (r105 != null) goto L13;
        r105 = "";
    L13:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L15
    L17:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L21;
        FLogger.f375446a.e("EndpointUtil", "getForeGroundAppPackageName error: " + r107);
    L21:
        if (Result.m9456isSuccessimpl(r106) == false) goto L24;
        FLogger.f375446a.i("EndpointUtil", "getForeGroundAppPackageName packageName: " + ((String) r106));
    L24:
        if (Result.m9455isFailureimpl(r106) == true) goto L28;
        r101 = r106;
    L28:
        return (String) r101;
    L10:
        r105 = null;
    L15:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
