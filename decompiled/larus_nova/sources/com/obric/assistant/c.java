package com.obric.assistant;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f386004a = 0;

    static {
    }

    public static String a(String r100) {
        if (Intrinsics.areEqual(r100, "1") == false) goto L5;
        return r100;
    L5:
        if (Intrinsics.areEqual(r100, "2") == true) goto L10;
        return "0";
    L10:
        return r100;
    }
}
