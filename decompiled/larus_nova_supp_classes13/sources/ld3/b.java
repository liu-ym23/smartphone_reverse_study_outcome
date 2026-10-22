package ld3;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final int a = 0;

    static {
        Lazy r0 = ECSettingKeys.a;
        int r1 = p.a;
        Object r2 = 0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a("ec_inner_flow_fps_opt", Integer.class, r2, false);     // Catch: Throwable -> L7
        if (r5 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        a = ((Number) r5).intValue();
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Object r7 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r7) == true) goto L12;
        r2 = r7;
    L12:
        r5 = r2;
        goto L13
    }

    public static boolean a() {
        int r0 = a;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean b() {
        int r0 = a;
        if (r0 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r0 == 3) goto L8;
        return false;
    }
}
