package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f434039a = null;

    static {
        f434039a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        f434039a.post(r100);
    }
}
