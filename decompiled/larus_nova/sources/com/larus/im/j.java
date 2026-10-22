package com.larus.im;

import com.larus.im.internal.database.delegate.MessageDaoSource;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f350569a = null;

    static {
        f350569a = LazyKt.lazy(new i());
    }

    public static boolean e() {
        return ((Boolean) f350569a.getValue()).booleanValue();
    }

    public static String b(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f(r100) == true) goto L8;
        return null;
    L8:
        String r101 = StringsKt.substringBefore$default(r100, "-local", null, 2, null);
        boolean r102 = false;
        if (g(r100) == false) goto L16;
        String r103 = StringsKt.substringAfterLast$default(r101, "_", null, 2, null);
        if (r103.length() <= 0) goto L13;
        r102 = true;
    L13:
        if (r102 == true) goto L22;
        return null;
    L22:
        return r103;
    L16:
        if (r101.length() <= 0) goto L18;
        r102 = true;
    L18:
        if (r102 == true) goto L20;
        return null;
    L20:
        return r101;
    }

    public static boolean f(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        return StringsKt.contains$default(r100, "-local", false, 2, null);
    }

    public static boolean g(String r100) {
        if (f(r100) == false) goto L10;
        if (r100 == null) goto L6;
        boolean r101 = StringsKt.contains$default(r100, "main_", false, 2, null);
    L7:
        if (r101 == false) goto L11;
        return true;
    L11:
        return false;
    L6:
        r101 = false;
        goto L7
    L10:
        return false;
    }

    public static String a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        return r100 + '-' + r101 + "-onboarding";
    }

    public static String c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L10:
        if (r102 == false) goto L13;
        return r100 + "-local";
    L13:
        return r100 + "-local" + r101;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L10
    }

    public static Object d(String r100, Continuation r101) {
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return CollectionsKt.emptyList();
    L10:
        return ((MessageDaoSource) ae9.e.a()).y(r100, r101);
    L5:
        r102 = false;
        goto L6
    }
}
