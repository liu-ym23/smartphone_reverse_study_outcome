package com.bytedance.rts.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class r {
    public static final String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return String.valueOf(r100.charAt(r101));
    }

    public static boolean b(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "searchString");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "searchString");
        int r100 = r110.length();
        if (r100 >= r111.length()) goto L6;
        return false;
    L6:
        return StringsKt.regionMatches$default(r110, r100 - r111.length(), r111, 0, r111.length(), false, 16, null);
    }

    public static boolean c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        return d(r100, r101, 0);
    }

    public static boolean g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "searchString");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "searchString");
        return StringsKt.startsWith(r100, r101, 0, false);
    }

    public static final boolean d(String r100, String r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        if (r110 < r100.length()) goto L5;
        return false;
    L5:
        if (r110 >= 0) goto L9;
        return d(r100, r101, 0);
    L9:
        if (StringsKt.indexOf$default(r100, r101, r110, false, 4, null) == (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    public static final String e(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 >= r100.length()) goto L18;
        if (r101 >= 0) goto L7;
        r101 = r101 + r100.length();
    L7:
        if (r101 >= 0) goto L9;
        r101 = 0;
    L9:
        if (r102 >= 0) goto L12;
        r102 = r102 + r100.length();
    L12:
        if (r102 <= r100.length()) goto L14;
        r102 = r100.length();
    L14:
        if (r101 < r102) goto L17;
        return "";
    L17:
        return StringsKt.slice(r100, RangesKt.until(r101, r102));
    L18:
        return "";
    }

    public static final ArrayList<String> f(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "delimiters");
        if (r102 == 0) goto L13;
        List r103 = StringsKt.split$default(r100, new String[]{r101}, false, 0, 4, null);
        if (r102 <= 0) goto L9;
        r103 = CollectionsKt.take(r103, r102);
    L9:
        if (r103.size() <= 1) goto L14;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.String> }");
        return (ArrayList) r103;
    L14:
        return new ArrayList(r103);
    L13:
        return new ArrayList();
    }
}
