package com.larus.dora.impl.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f338138a = 0;

    static {
    }

    public static int a(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "version1");
        Intrinsics.checkNotNullParameter(r111, "version2");
        List r112 = StringsKt.split$default(r110, new String[]{"."}, false, 0, 6, null);
        List r113 = StringsKt.split$default(r111, new String[]{"."}, false, 0, 6, null);
        int r100 = Math.max(r112.size(), r113.size());
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L33;
        if (r101 < r112.size()) goto L36;
        int r102 = 0;
    L16:
        if (r101 < r113.size()) goto L34;
        int r103 = 0;
    L26:
        if (r102 > r103) goto L27;
        if (r102 < r103) goto L30;
        r101 = r101 + 1;
        goto L3
    L30:
        return -1;
    L27:
        return 1;
    L34:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L19
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r113, r101))));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r105) == false) goto L24;
        r105 = 0;
    L24:
        r103 = ((Number) r105).intValue();
    L19:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L36:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L8
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r112, r101))));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r108) == false) goto L13;
        r108 = 0;
    L13:
        r102 = ((Number) r108).intValue();
    L8:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L33:
        return 0;
    }
}
