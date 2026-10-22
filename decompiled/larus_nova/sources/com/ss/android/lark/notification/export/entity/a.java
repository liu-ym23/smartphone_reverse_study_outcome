package com.ss.android.lark.notification.export.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final boolean a(Notice r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.extra.f433060d != Notice.Extra.ChatMode.THREAD_V2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L14;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.extra.f433067k >= 0) goto L14;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.extra.f433074r, Boolean.TRUE) == true) goto L14;
        if (r100.extra.f433068l < 0) goto L14;
        return true;
    L14:
        return false;
    L5:
        r101 = false;
        goto L6
    }
}
