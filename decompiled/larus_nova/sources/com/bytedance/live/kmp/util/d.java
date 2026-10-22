package com.bytedance.live.kmp.util;

import android.os.Handler;
import android.os.Looper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {
    public static /* synthetic */ void b(long r100, boolean r101, Function0 r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r101 = false;
    L8:
        a(r100, false, r101, r102);
    }

    public static final void a(long r100, boolean r101, boolean r102, final Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r103, "action");
        Handler r104 = new Handler(Looper.getMainLooper());
        if (r100 <= 0) goto L5;
        r104.postDelayed(new a(r103), r100);
        return;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        if (r102 == true) goto L8;
        r103.invoke();
        return;
    L8:
        if (r101 == false) goto L10;
        r104.postAtTime(new a(r103), 2);
        return;
    L10:
        r104.post(new a(r103));
    }
}
