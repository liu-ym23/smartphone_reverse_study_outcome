package com.ss.android.ainote;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes34.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f406759a = null;

    static {
        f406759a = new h0();
    }

    public h0() {
    }

    public static boolean b(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(FeatureGatingModule.getFeatureGatingService().isEnable(r100)));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L9;
        int r104 = t.f407207a;
        t.c("AINoteRuntimeConfigLoader", "loadFeatureGating failed, key=".concat(r100), r103);
    L9:
        Boolean r105 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r102) == false) goto L13;
        r102 = r105;
    L13:
        return ((Boolean) r102).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static final Long a(JSONObject r100, String r101) {
        if (r100.containsKey(r101) == true) goto L7;
        return null;
    L7:
        return Long.valueOf(r100.getLongValue(r101));
    }
}
