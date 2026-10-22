package com.obric.assistant.spi.keyguard;

import android.os.Handler;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import oga.e;
import oga.f;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static void b(boolean r100, Function0 r101, int r110) {
        if ((r110 & 1) == 0) goto L5;
        boolean r102 = false;
    L6:
        Intrinsics.checkNotNullParameter(r101, "onSucceeded");
        IKeyguardService.a.a(KeyguardService.f392886a, new f(r101), false, false, false, r102, null, 14);
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public static void a(Function0 r100, Function0 r101, Handler r110, boolean r111, int r112) {
        if ((r112 & 4) == 0) goto L6;
        r110 = null;
    L6:
        if ((r112 & 8) == 0) goto L8;
        boolean r102 = false;
    L9:
        Intrinsics.checkNotNullParameter(r100, "onSucceeded");
        Intrinsics.checkNotNullParameter(r101, "onFailed");
        IKeyguardService.a.a(KeyguardService.f392886a, new e(r110, r100, r101), false, false, false, r102, null, 14);
        return;
    L8:
        r102 = r111;
        goto L9
    }
}
