package com.larus.home.impl.main.tab.config;

import android.content.Context;
import android.content.res.Resources;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b {
    public static final String a(BottomTabConfig r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r102 = "";
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L30
        String r104 = r100.getStarlingKey();     // Catch: Throwable -> L30
        boolean r105 = true;
        if (r104 != null) goto L6;
    L9:
        boolean r106 = true;
    L10:
        if (r106 == true) goto L15;
        Resources r107 = r101.getResources();     // Catch: Throwable -> L30
        if (r107 == null) goto L15;
        String r108 = r107.getString(r107.getIdentifier(r100.getStarlingKey(), "string", r101.getPackageName()));     // Catch: Throwable -> L30
    L37:
    L28:
        th = th;
    L32:
        Result.Companion r109 = Result.Companion;
        Object r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r102 = r108;
    L34:
        if (Result.m9452exceptionOrNullimpl(r110) == null) goto L36;
        FLogger.f375446a.i("BottomTabConfigManager", "getBottomText fail");
    L36:
        return r102;
    L17:
        if (r108.length() == 0) goto L20;
        r105 = false;
    L20:
        if (r105 == false) goto L25;
        String r111 = r100.getText();     // Catch: Throwable -> L28
        if (r111 == null) goto L26;
        r102 = r111;
    L26:
        r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
        goto L34
    L25:
        r102 = r108;
    L15:
        r108 = "";
        goto L37
    L6:
        if (r104.length() == 0) goto L9;
        r106 = false;
    L30:
        th = th;
        r108 = r102;
        goto L32
    }
}
