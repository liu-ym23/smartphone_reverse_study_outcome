package com.ss.android.lark.chat.utils;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416667a = 0;

    static {
    }

    public static /* synthetic */ float[] b(v5b.c r100) {
        return a(r100, 10.0f, 2.0f);
    }

    @JvmStatic
    public static final boolean c(v5b.c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof y6b.c) == true) goto L5;
    L7:
        return false;
    L5:
        if (((y6b.c) r100).f566496k1 == false) goto L7;
        return true;
    }

    @JvmStatic
    public static final float[] a(v5b.c<?> r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "messageVO");
        int r103 = r100.getGroupType();
        if (r103 == 1) goto L6;
        if (r103 == 2) goto L6;
        float r104 = r101;
    L7:
        if (r103 == 0) goto L10;
        if (r103 == 1) goto L10;
    L11:
        float[] r105 = new float[4];
        int r106 = 0;
    L12:
        if (r106 >= 4) goto L15;
        r105[r106] = r101;
        r106 = r106 + 1;
        goto L12
    L15:
        if (c(r100) == false) goto L17;
        r105[2] = r102;
        r105[3] = r104;
    L18:
        return r105;
    L17:
        r105[0] = r102;
        r105[1] = r104;
    L10:
        r102 = r101;
    L6:
        r104 = r102;
        goto L7
    }
}
