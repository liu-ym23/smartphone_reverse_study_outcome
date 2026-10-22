package com.larus.business.markdown.impl.common.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lw8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static n f320551a;

    static {
        f320551a = new n(false);
    }

    public static String a(String r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "content");
        if (r111 == true) goto L6;
        return r110;
    L6:
        if (f320551a.f511091a == false) goto L101;
        List r112 = CollectionsKt.toMutableList(StringsKt.split$default(r110, new String[]{"\n"}, false, 0, 6, null));
        int r100 = 0;
    L9:
        if (r100 >= (r112.size() - 3)) goto L79;
        String r101 = (String) ListProtector.get(r112, r100);
        int r102 = r101.length();
        int r103 = 0;
        int r104 = 0;
    L12:
        if (r103 >= r102) goto L16;
        if (r101.charAt(r103) != ' ') goto L16;
        r104 = r104 + 1;
        r103 = r103 + 1;
    L16:
        String r105 = StringsKt.trimStart(r101).toString();
        boolean r106 = true;
        if (StringsKt.startsWith$default(r105, "- ", false, 2, null) == false) goto L19;
    L24:
        boolean r107 = true;
    L26:
        if (r105.length() != 0) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L49;
        int r109 = 0;
    L33:
        if (r109 >= r105.length()) goto L37;
        if (Character.isDigit(r105.charAt(r109)) == false) goto L37;
        r109 = r109 + 1;
    L37:
        if (r109 == 0) goto L49;
        if (r109 >= r105.length()) goto L49;
        if (r105.charAt(r109) != '.') goto L49;
        int r113 = r109 + 1;
        if (r113 >= r105.length()) goto L49;
        if (r105.charAt(r113) != ' ') goto L49;
    L50:
        if (r107 == true) goto L54;
        if (r106 == true) goto L54;
        r100 = r100 + 1;
    L54:
        int r114 = r100 + 1;
        String r115 = (String) ListProtector.get(r112, r114);
        int r116 = r115.length();
        int r117 = 0;
        int r118 = 0;
    L55:
        if (r117 >= r116) goto L59;
        if (r115.charAt(r117) != ' ') goto L59;
        r118 = r118 + 1;
        r117 = r117 + 1;
    L59:
        if (r118 > r104) goto L77;
        if (StringsKt.startsWith$default(StringsKt.trimStart(r115).toString(), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, false, 2, null) == false) goto L77;
        String r119 = (String) ListProtector.get(r112, r100 + 2);
        if (r119 == null) goto L76;
        String r120 = StringsKt.trimStart(r119).toString();
        if (StringsKt.startsWith$default(r120, "|--", false, 2, null) == true) goto L71;
        if (StringsKt.startsWith$default(r120, "|:-", false, 2, null) == true) goto L71;
        if (StringsKt.startsWith$default(r120, "| --", false, 2, null) == false) goto L77;
    L71:
        ListProtector.add(r112, r114, "\n");
        gw8.c.f483071a.getClass();
        com.larus.business.markdown.api.depend.d r121 = gw8.c.a.f483075d;
        if (r121 == null) goto L74;
        r121.i("MarkdownContentPredealHelper", "refineTableInList adding triggered, tableStartIndex[" + r114 + ']');
    L74:
        r100 = r100 + 4;
        goto L9
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L77:
        r100 = r114;
    L49:
        r106 = false;
        goto L50
    L28:
        r108 = false;
        goto L29
    L19:
        if (StringsKt.startsWith$default(r105, tb2.c.IMAGE_DEFAULT_TEXT, false, 2, null) == true) goto L24;
        if (StringsKt.startsWith$default(r105, "+ ", false, 2, null) == true) goto L24;
        r107 = false;
        goto L26
    L79:
        return CollectionsKt.joinToString$default(r112, "\n", null, null, 0, null, null, 62, null);
    L101:
        return r110;
    }
}
