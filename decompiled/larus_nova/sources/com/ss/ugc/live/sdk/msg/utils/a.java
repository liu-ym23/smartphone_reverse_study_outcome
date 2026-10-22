package com.ss.ugc.live.sdk.msg.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {
    public static final boolean b(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isWRDS");
        if ((r100 instanceof xlc.b) == true) goto L5;
    L7:
        return false;
    L5:
        if (((xlc.b) r100).isWRDSMessage() == false) goto L7;
        return true;
    }

    public static final void a(vlc.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$debug");
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100.a() == false) goto L6;
        r100.log("MessageManagerV2", r101);
        return;
    }

    public static final void c(vlc.c r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$trace");
        Intrinsics.checkNotNullParameter(r101, "msg");
        r100.log("MessageManagerV2", r101);
    }
}
