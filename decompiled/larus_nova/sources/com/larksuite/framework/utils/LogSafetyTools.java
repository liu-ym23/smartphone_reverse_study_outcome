package com.larksuite.framework.utils;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
public final class LogSafetyTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f285909a = null;

    static {
        f285909a = LazyKt.lazy(LogSafetyTools$REGEX_DOC_TOKEN$2.INSTANCE);
    }

    @JvmStatic
    public static final String a(String r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == true) goto L9;
        return r100;
    L9:
        return ((Regex) f285909a.getValue()).replace(r100, "DOC_URL_TOKEN");
    L5:
        if (StringsKt.contains$default(r100, "http", false, 2, null) != true) goto L7;
        r101 = true;
        goto L7
    }
}
