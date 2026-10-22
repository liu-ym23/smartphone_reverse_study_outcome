package com.ss.android.lark.feed.molten.serializer;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f421123a = 0;

    static {
    }

    public static Object a(Class r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "enumClass");
        Object r102 = r100.getMethod("fromValue", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r101)});
        if (r102 != null) goto L6;
        return null;
    L6:
        return r102;
    }
}
