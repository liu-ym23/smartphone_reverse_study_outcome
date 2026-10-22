package com.larus.canvas.feature.component.logic.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class a {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "localResPath");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(UriProtector.parse(r100));     // Catch: Throwable -> L5
    L7:
        String r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Uri r104 = (Uri) r102;
        if (r104 == null) goto L13;
        r103 = r104.getScheme();
    L13:
        if (r103 != null) goto L15;
    L18:
        boolean r105 = true;
    L19:
        if (r105 == false) goto L24;
        String r106 = Uri.fromFile(new PolarisFileWrapper(r100)).toString();
        Intrinsics.checkNotNull(r106);
        return r106;
    L24:
        return r100;
    L15:
        if (StringsKt.isBlank(r103) == true) goto L18;
        r105 = false;
    L5:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
