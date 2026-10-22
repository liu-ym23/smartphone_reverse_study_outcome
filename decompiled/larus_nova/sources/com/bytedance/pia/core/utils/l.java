package com.bytedance.pia.core.utils;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f266402a = 0;

    static {
    }

    @JvmStatic
    public static final int b(WebView r100) {
        Intrinsics.areEqual(((Handler) ThreadUtil.f266382e.getValue()).getLooper(), Looper.myLooper());
        if (r100 == null) goto L7;
        WebSettings r101 = r100.getSettings();
        if (r101 == null) goto L7;
        String r102 = r101.getUserAgentString();
    L9:
        if (r102 != null) goto L20;
        return -1;
    L20:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        Object r104 = Result.m9449constructorimpl(Integer.valueOf(CastIntegerProtector.parseInt(StringsKt.substringBefore$default(StringsKt.substringAfter$default(r102.toLowerCase(Locale.getDefault()), "chrome/", null, 2, null), ".", null, 2, null))));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == false) goto L19;
        r104 = -1;
    L19:
        return ((Number) r104).intValue();
    L13:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = null;
        goto L9
    }

    @JvmStatic
    public static final void a(StringBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        if (r101 != null) goto L5;
        return;
    L5:
        r100.append("(\"");
        int r102 = 0;
    L7:
        if (r102 >= r101.length()) goto L26;
        char r103 = r101.charAt(r102);
        if (r103 != '\r') goto L11;
        r100.append("\\r");
    L25:
        r102 = r102 + 1;
        goto L7
    L11:
        if (r103 != '\"') goto L13;
        r100.append("\\\"");
        goto L25
    L13:
        if (r103 != '\'') goto L15;
        r100.append("\\'");
        goto L25
    L15:
        if (r103 == '\\') goto L21;
        switch(r103) {
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            default: goto L17;
        };
    L17:
        r100.append(r103);
        goto L25
    L18:
        r100.append("\\n");
        goto L25
    L19:
        r100.append("\\t");
        goto L25
    L20:
        r100.append("\\b");
        goto L25
    L21:
        r100.append("\\\\");
        goto L25
    L26:
        r100.append("\")");
    }
}
