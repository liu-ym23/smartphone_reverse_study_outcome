package com.bytedance.rts.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r {
    public static final String a(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return String.valueOf(r1.charAt(r2));
    }

    public static boolean b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "searchString");
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "searchString");
        int r0 = r10.length();
        if (r0 >= r11.length()) goto L6;
        return false;
    L6:
        return StringsKt.regionMatches$default(r10, r0 - r11.length(), r11, 0, r11.length(), false, 16, null);
    }

    public static boolean c(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "str");
        return d(r1, r2, 0);
    }

    public static boolean g(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "searchString");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "searchString");
        return StringsKt.startsWith(r2, r3, 0, false);
    }

    public static final boolean d(String r8, String r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "str");
        if (r10 < r8.length()) goto L5;
        return false;
    L5:
        if (r10 >= 0) goto L9;
        return d(r8, r9, 0);
    L9:
        if (StringsKt.indexOf$default(r8, r9, r10, false, 4, null) == (-1)) goto L12;
        return true;
    L12:
        return false;
    }

    public static final String e(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 >= r2.length()) goto L18;
        if (r3 >= 0) goto L7;
        r3 = r3 + r2.length();
    L7:
        if (r3 >= 0) goto L9;
        r3 = 0;
    L9:
        if (r4 >= 0) goto L12;
        r4 = r4 + r2.length();
    L12:
        if (r4 <= r2.length()) goto L14;
        r4 = r2.length();
    L14:
        if (r3 < r4) goto L17;
        return "";
    L17:
        return StringsKt.slice(r2, RangesKt.until(r3, r4));
    L18:
        return "";
    }

    public static final ArrayList<String> f(String r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiters");
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "delimiters");
        if (r9 == 0) goto L13;
        List r10 = StringsKt.split$default(r7, new String[]{r8}, false, 0, 4, null);
        if (r9 <= 0) goto L9;
        r10 = CollectionsKt.take(r10, r9);
    L9:
        if (r10.size() <= 1) goto L14;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<kotlin.String> }");
        return (ArrayList) r10;
    L14:
        return new ArrayList(r10);
    L13:
        return new ArrayList();
    }
}
