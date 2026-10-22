package com.bytedance.caijing.sdk.infra.utils;

import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;

/* JADX INFO: loaded from: classes15.dex */
public final class g {
    public static String a(Object r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.toString();
    }

    public static String b(String r100, Object... r101) {
        return String.format(r100, r101);
    L4:
        e = move-exception;
        CJLogger.c("StringUtils", "format error", e);
        return "";
    }
}
