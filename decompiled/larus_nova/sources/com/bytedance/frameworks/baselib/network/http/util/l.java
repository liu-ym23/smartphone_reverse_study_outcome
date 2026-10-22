package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.common.utility.StringUtils;
import java.net.URI;

/* JADX INFO: loaded from: classes3.dex */
public final class l {
    public static URI a(String r100) throws RuntimeException {
        if (StringUtils.isEmpty(r100) == false) goto L14;
        return null;
    L14:
        int r101 = r100.indexOf("?");     // Catch: Exception -> L11
        if (r101 <= 0) goto L9;
        r100 = r100.substring(0, r101);     // Catch: Exception -> L11
    L9:
        return URI.create(r100);
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static URI b(String r100) throws RuntimeException {
        if (StringUtils.isEmpty(r100) == false) goto L12;
        return null;
    L12:
        return new URI(r100);
    L8:
        return URI.create(r100.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        return a(r100);
    }
}
