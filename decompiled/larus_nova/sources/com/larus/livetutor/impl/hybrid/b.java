package com.larus.livetutor.impl.hybrid;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final void b(LiveTutorHybridContainer r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "action");
        ((Handler) r100.f356152b.getValue()).removeCallbacks(r101);
    }

    public static final void a(LiveTutorHybridContainer r100, long r101, Runnable r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "action");
        ((Handler) r100.f356152b.getValue()).postDelayed(r102, r101);
    }
}
