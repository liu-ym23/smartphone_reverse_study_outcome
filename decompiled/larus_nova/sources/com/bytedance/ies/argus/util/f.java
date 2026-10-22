package com.bytedance.ies.argus.util;

import android.util.LruCache;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Pattern> f246256a = null;

    static {
        f246256a = new LruCache(100);
    }

    public static boolean a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "reg");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        LruCache<String, Pattern> r103 = f246256a;     // Catch: Throwable -> L8
        Pattern r104 = r103.get(r101);     // Catch: Throwable -> L8
        if (r104 != null) goto L6;
        r104 = PatternProtector.compile(r101);     // Catch: Throwable -> L8
        r103.put(r101, r104);     // Catch: Throwable -> L8
    L6:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r104.matcher(r100).find()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L15;
        r105 = Boolean.FALSE;
    L15:
        return ((Boolean) r105).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
