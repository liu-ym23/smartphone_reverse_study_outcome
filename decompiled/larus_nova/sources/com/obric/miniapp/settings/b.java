package com.obric.miniapp.settings;

import com.bytedance.ai.utils.g;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f398403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f398404b;

    static {
        f398403a = new b();
    }

    public b() {
    }

    public static g37.a a() {
        return g37.a.c("obric-mini-app");
    }

    public static IMiniAppSettings b() {
        g.f37637a.d("MiniAppSettingsManager", "obtainSettings");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl((IMiniAppSettings) a().b(IMiniAppSettings.class));     // Catch: Throwable -> L5
    L7:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 != null) goto L10;
    L13:
        DefaultValueMiniAppSettings r103 = DefaultValueMiniAppSettings.INSTANCE;
        if (Result.m9455isFailureimpl(r101) == false) goto L17;
        r101 = r103;
    L17:
        return (IMiniAppSettings) r101;
    L10:
        if (f398404b == true) goto L12;
        g.f37637a.w("MiniAppSettingsManager", "obtain settings failed", r102);
        goto L13
    L12:
        throw r102;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
