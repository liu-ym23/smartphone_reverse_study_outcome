package com.bytedance.android.shopping.store.tabkit.drainageprefetch;

import android.net.Uri;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.shopping.store.utils.n;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(int r2) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        boolean r3 = true;
        if ((r2 & 1) > 0) goto L7;
        r3 = false;
    L7:
        Object r4 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == false) goto L14;
        r4 = null;
    L14:
        Boolean r5 = (Boolean) r4;
        if (r5 != null) goto L17;
        return false;
    L17:
        return r5.booleanValue();
    L9:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public static int b(String r2) {
        if (StringsKt.isBlank(r2) == false) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return 0;
    L8:
        Uri r3 = n.c(r2);
        if (r3 == null) goto L16;
        String r4 = j1.c(r3, "na_prefetch_strategy");
        if (r4 == null) goto L17;
        Integer r5 = StringsKt.toIntOrNull(r4);
        if (r5 != null) goto L15;
        return 0;
    L15:
        return r5.intValue();
    L17:
        return 0;
    L16:
        return 0;
    L5:
        r0 = false;
        goto L6
    }

    public static boolean c(String r1) {
        Intrinsics.checkNotNullParameter(r1, "url");
        String r2 = UriProtector.getQueryParameter(UriProtector.parse(r1), "na_prefetch_strategy");
        if (r2 == null) goto L7;
        Integer r3 = StringsKt.toIntOrNull(r2);
        if (r3 == null) goto L7;
        int r4 = r3.intValue();
    L9:
        return a(r4);
    L7:
        r4 = 0;
        goto L9
    }
}
