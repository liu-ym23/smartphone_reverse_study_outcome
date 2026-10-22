package com.ss.ugc.effectplatform.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f458047a = 0;

    static {
    }

    public static boolean b(String r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.length() != 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L13;
        return false;
    L13:
        return true;
    L7:
        r101 = false;
        goto L8
    }

    public static boolean a(String r100, String r101) {
        if (b(r100) == false) goto L9;
        if (b(r101) == false) goto L9;
        return true;
    L9:
        return Intrinsics.areEqual(r100, r101);
    }
}
