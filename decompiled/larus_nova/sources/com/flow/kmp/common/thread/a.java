package com.flow.kmp.common.thread;

import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    static {
    }

    public static boolean a() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }
}
