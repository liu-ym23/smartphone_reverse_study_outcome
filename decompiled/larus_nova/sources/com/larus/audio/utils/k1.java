package com.larus.audio.utils;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f290062a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "srcUrl");
        Intrinsics.checkNotNullParameter(r101, "newPath");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L25;
        return r100;
    L25:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L14
        if (StringsKt.startsWith$default(r101, HTTP.URL_DEFAULT, false, 2, null) == true) goto L12;
        r101 = HTTP.URL_DEFAULT.concat(r101);     // Catch: Throwable -> L14
    L12:
        Object r104 = Result.m9449constructorimpl(UriProtector.parse(r100).buildUpon().path(r101).build().toString());     // Catch: Throwable -> L14
    L16:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L19;
        FLogger.f375446a.e("AudioUrlUtils", "replacePath failed: " + r105, r105);
    L19:
        Object r106 = r100;
        if (Result.m9455isFailureimpl(r104) == true) goto L24;
        r106 = r104;
    L24:
        return (String) r106;
    L14:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        r102 = false;
        goto L6
    }
}
