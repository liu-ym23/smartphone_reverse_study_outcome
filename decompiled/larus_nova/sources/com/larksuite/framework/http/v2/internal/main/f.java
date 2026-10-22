package com.larksuite.framework.http.v2.internal.main;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements Interceptor {
    public f() {
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain r100) {
        Intrinsics.checkNotNullParameter(r100, "chian");
        Response r101 = r100.proceed(r100.request());
        if (r101.isSuccessful() == true) goto L34;
        String r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L11
        ResponseBody r104 = r101.body();     // Catch: Throwable -> L11
        if (r104 == null) goto L8;
        String r105 = r104.string();     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L14:
        if (Result.m9455isFailureimpl(r106) == false) goto L16;
        r106 = null;
    L16:
        String r107 = (String) r106;
        String r108 = r101.message();
        boolean r109 = true;
        if (r107 != null) goto L19;
    L24:
        StringBuilder r110 = new StringBuilder("Response is not successful, status code: ");
        r110.append(r101.code());
        r110.append(", error message: ");
        if (r108 != null) goto L27;
    L30:
        if (r109 == false) goto L32;
        r108 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L32:
        r110.append(r108);
        r110.append('.');
        throw new IOException(r110.toString());
    L27:
        if (StringsKt.isBlank(r108) == true) goto L30;
        r109 = false;
        goto L30
    L19:
        if ((!StringsKt.isBlank(r107)) == false) goto L21;
        r102 = r107;
    L21:
        if (r102 == null) goto L24;
        r108 = r102;
        goto L24
    L8:
        r105 = null;
    L11:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    L34:
        Intrinsics.checkNotNull(r101);
        return r101;
    }
}
