package com.larus.share.impl.util;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f368775a = 0;

    static {
    }

    public static boolean a(String r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L15;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L15;
        return false;
    L11:
        if (StringsKt.startsWith(r100, "https://", true) != true) goto L13;
        r102 = true;
    L15:
        return true;
    L5:
        if (StringsKt.startsWith(r100, "http://", true) != true) goto L7;
        r101 = true;
        goto L8
    }
}
