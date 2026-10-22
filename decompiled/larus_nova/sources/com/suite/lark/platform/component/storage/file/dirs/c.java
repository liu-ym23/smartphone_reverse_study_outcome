package com.suite.lark.platform.component.storage.file.dirs;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        return r100;
    L12:
        if (r100.length() == 0) goto L15;
        r102 = false;
    L15:
        if (r102 == true) goto L22;
        StringBuilder r104 = new StringBuilder();
        r104.append(r100);
        String r105 = HTTP.URL_DEFAULT;
        if (StringsKt.endsWith$default(r100, HTTP.URL_DEFAULT, false, 2, null) == false) goto L20;
        r105 = "";
    L20:
        r104.append(r105);
        r104.append(r101);
        return r104.toString();
    L22:
        return r101;
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
