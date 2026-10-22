package com.larus.search.impl.global.view.aggregate.kmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class h {
    public static final boolean a(String r100) {
        if (StringsKt.contains$default(r100, "豆包号", false, 2, null) == false) goto L5;
    L8:
        return true;
    L5:
        if (StringsKt.contains$default(r100, "豆包帳號", false, 2, null) == true) goto L8;
        if (StringsKt.contains$default(r100, "User ID", false, 2, null) == true) goto L8;
        return false;
    }

    public static final String b(String r110) {
        String r100 = StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(r110, "<h>", "", false, 4, null), "</h>", "", false, 4, null)).toString();
        boolean r101 = false;
        if (a(r110) == false) goto L18;
        List r111 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(StringsKt.indexOf$default(r100, ':', 0, false, 6, null)), Integer.valueOf(StringsKt.indexOf$default(r100, 65306, 0, false, 6, null))});
        ArrayList r102 = new ArrayList();
        Iterator r112 = r111.iterator();
    L6:
        if (r112.hasNext() == false) goto L13;
        Object r103 = r112.next();
        if (((Number) r103).intValue() < 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
        r102.add(r103);
        goto L6
    L10:
        r104 = false;
        goto L11
    L13:
        Integer r113 = (Integer) CollectionsKt.minOrNull(r102);
        if (r113 == null) goto L16;
        r100 = r100.substring(r113.intValue() + 1);
    L16:
        r100 = StringsKt.trim(r100).toString();
    L18:
        if (StringsKt.isBlank(r100) == false) goto L20;
    L25:
        if (r101 == false) goto L28;
        return r100;
    L28:
        return null;
    L20:
        if (StringsKt.contains$default(r100, '@', false, 2, null) == true) goto L25;
        if (StringsKt.contains$default(r100, ' ', false, 2, null) == true) goto L25;
        r101 = new Regex("^[A-Za-z0-9][A-Za-z0-9_.-]{0,63}$").matches(r100);
        goto L25
    }
}
