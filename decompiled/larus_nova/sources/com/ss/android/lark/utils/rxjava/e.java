package com.ss.android.lark.utils.rxjava;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class e {
    public static void a(Throwable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((r100 instanceof RuntimeException) == false) goto L8;
        Throwable r101 = new Throwable(String.format("Handle in %1$s >> %2$s: %3$s", new Object[]{"RxJava", r100.getClass().getName(), r100.getMessage()}), r100);
        r101.printStackTrace();
        Log.e("RxJava", r101.getMessage(), r101, true);
        return;
    }
}
