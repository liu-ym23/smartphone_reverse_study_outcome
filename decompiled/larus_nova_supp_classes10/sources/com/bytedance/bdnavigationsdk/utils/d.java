package com.bytedance.bdnavigationsdk.utils;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "text");
        return r1.toLowerCase(Locale.ROOT);
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        String r3 = StringsKt.trim(r2).toString();
        return new Regex("\\s+").replace(r3, "");
    }
}
