package com.ss.android.lark.watermark.userscope;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class j {
    public static final void a(Handler r100, Runnable r101) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r101.run();
        return;
    L5:
        r100.post(r101);
    }
}
