package com.bytedance.ies.bullet.prefetchv2;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        if (StringsKt.contains$default(r100, HTTP.URL_DEFAULT, false, 2, null) == true) goto L6;
        return r101;
    L6:
        return b(r100, r101);
    }

    public static final String b(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "suffix");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return r111;
    L8:
        int r101 = StringsKt.lastIndexOf$default(r110, "://", 0, false, 6, null);
        int r102 = StringsKt.lastIndexOf$default(r110, '/', 0, false, 6, null);
        if (r102 < 0) goto L18;
        if ((r101 + 2) != r102) goto L16;
        if (r101 < 0) goto L16;
        return r110 + '/' + r111;
    L16:
        return r110.substring(0, r102) + '/' + r111;
    L18:
        return r110 + '/' + r111;
    L5:
        r100 = false;
        goto L6
    }
}
