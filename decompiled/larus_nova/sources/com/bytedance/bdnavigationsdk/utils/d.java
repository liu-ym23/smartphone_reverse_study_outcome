package com.bytedance.bdnavigationsdk.utils;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f200377a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        return r100.toLowerCase(Locale.ROOT);
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        String r101 = StringsKt.trim(r100).toString();
        return new Regex("\\s+").replace(r101, "");
    }
}
