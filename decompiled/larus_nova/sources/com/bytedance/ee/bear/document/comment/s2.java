package com.bytedance.ee.bear.document.comment;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f219360a = 0;

    static {
    }

    @JvmStatic
    public static final void a(com.bytedance.ee.bear.middleground.comment.export.i r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "from");
        af5.b r102 = r100.a();
        if (r102 == null) goto L8;
        com.bytedance.ee.bear.middleground.comment.performance.b r103 = r102.c();
        if (r103 == null) goto L9;
        r103.d(System.currentTimeMillis(), r101);
        return;
    L9:
        return;
    }
}
