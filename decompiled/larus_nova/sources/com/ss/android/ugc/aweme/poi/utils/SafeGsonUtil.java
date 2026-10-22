package com.ss.android.ugc.aweme.poi.utils;

import com.bytedance.locallife.common.utils.d;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/utils/SafeGsonUtil;", "", "<init>", "()V", "locallife-saas-common_release"}, k = 1, mv = {1, 4, 3})
public final class SafeGsonUtil {
    static {
        new SafeGsonUtil();
    }

    private SafeGsonUtil() {
    }

    @JvmStatic
    public static final String c(Object r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(d.c(r100));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        return (String) r102;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @JvmStatic
    public static final <T> T a(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        Object r103 = d.a(r100, r101);     // Catch: Throwable -> L9
    L7:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r104) == false) goto L15;
        return null;
    L15:
        return (T) r104;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @JvmStatic
    public static final <T> List<T> b(String r100, Class<T[]> r101) {
        Intrinsics.checkNotNullParameter(r101, "arrayClass");
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L9
        if (r100 == null) goto L6;
        List r104 = d.d(r100, r101);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        r102 = r105;
    L16:
        return (List) r102;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }
}
