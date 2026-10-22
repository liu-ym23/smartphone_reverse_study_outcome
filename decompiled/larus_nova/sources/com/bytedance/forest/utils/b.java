package com.bytedance.forest.utils;

import android.webkit.WebResourceResponse;
import com.bytedance.lynx.webview.TTWebSdk;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f244510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f244511b;

    public static final boolean b() {
        if (f244510a == false) goto L15;
        return true;
    L15:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        if (TTWebSdk.isFeatureSupport("offline_native_interceptor", 2) == false) goto L9;
        f244510a = true;     // Catch: Throwable -> L11
        return true;
    L9:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return false;
    L11:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public static final Map<String, String> a(WebResourceResponse r100) {
        if (r100.getResponseHeaders() != null) goto L6;
        r100.setResponseHeaders(new LinkedHashMap());
    L6:
        return r100.getResponseHeaders();
    }
}
