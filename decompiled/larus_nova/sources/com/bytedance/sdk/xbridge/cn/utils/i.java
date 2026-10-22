package com.bytedance.sdk.xbridge.cn.utils;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class i {
    static {
    }

    @JvmStatic
    public static final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter("BridgeProcessing", "bridgeStatus");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L5
        String r104 = c(r100, r101, "BridgeProcessing", r102);     // Catch: Throwable -> L5
        h.f270261a.d(r104);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static final void b(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "bridgeStatus");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        String r105 = c(r100, r101, r102, r103);     // Catch: Throwable -> L5
        h.f270261a.i(r105);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static String c(String r100, String r101, String r102, String r103) {
        StringBuilder r104 = new StringBuilder();
        boolean r105 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == false) goto L12;
        r104.append("[bulletSession-unknown]");
    L13:
        r104.append("[bullet-bridge][" + r100 + ']');
        if (r102 != null) goto L16;
    L19:
        if (r105 == true) goto L21;
        r104.append("[" + r102 + ']');
    L21:
        r104.append(r101);
        return r104.toString();
    L16:
        if (r102.length() == 0) goto L19;
        r105 = false;
        goto L19
    L12:
        r104.append("[bulletSession-" + r103 + ']');
        goto L13
    L5:
        if (r103.length() == 0) goto L8;
        r106 = false;
        goto L10
    }
}
