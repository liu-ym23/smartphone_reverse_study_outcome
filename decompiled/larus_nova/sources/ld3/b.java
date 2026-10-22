package ld3;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.opt.ab.p;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f508686a = 0;

    static {
        Lazy r100 = ECSettingKeys.f43616a;
        int r101 = p.f45243a;
        Object r102 = 0;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r104 = jj4.b.f499326b;     // Catch: Throwable -> L7
        Object r105 = jj4.a.a("ec_inner_flow_fps_opt", Integer.class, r102, false);     // Catch: Throwable -> L7
        if (r105 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        f508686a = ((Number) r105).intValue();
        return;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Object r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r107) == true) goto L12;
        r102 = r107;
    L12:
        r105 = r102;
        goto L13
    }

    public static boolean a() {
        int r100 = f508686a;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean b() {
        int r100 = f508686a;
        if (r100 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 3) goto L8;
        return false;
    }
}
