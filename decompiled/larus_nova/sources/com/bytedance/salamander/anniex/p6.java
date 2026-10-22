package com.bytedance.salamander.anniex;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class p6 {
    public p6() {
    }

    public static void a(String r100, String r101, Map r102, Map r103) {
        String r104 = com.bytedance.anniex.bd.foundation.impl.o.b(r102);     // Catch: Throwable -> L8
        String r105 = r101 + "|xContext:" + com.bytedance.anniex.bd.foundation.impl.o.b(r103) + "|xParam:" + r104;     // Catch: Throwable -> L8
        if (Intrinsics.areEqual(RXScreenCaptureService.KEY_INDEX, "e") == false) goto L6;
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.b(r100, r105);     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        com.bytedance.anniex.bd.foundation.impl.a.f190139a.c(r100, r105);     // Catch: Throwable -> L8
    }
}
