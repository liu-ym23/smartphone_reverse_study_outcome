package com.larus.office.base.utils;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361173a = 0;

    static {
    }

    public f() {
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "null";
    L11:
        String r102 = StringsKt.trim(r100).toString();
        if (r102.length() > 6) goto L16;
        return "***";
    L16:
        return StringsKt.take(r102, 3) + "..." + StringsKt.takeLast(r102, 3);
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static String b(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "null";
    L11:
        String r102 = StringsKt.trim(r100).toString();
        if (r102.length() > 8) goto L16;
        return "***";
    L16:
        return StringsKt.take(r102, 6) + "..." + StringsKt.takeLast(r102, 4);
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }

    public static String c(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L10;
        return "null";
    L10:
        String r102 = StringsKt.trim(r100).toString();
        if (r102.length() > 140) goto L14;
        return r102;
    L14:
        return StringsKt.take(r102, 140) + "...";
    L4:
        if (StringsKt.isBlank(r100) == true) goto L7;
        r101 = false;
        goto L8
    }
}
