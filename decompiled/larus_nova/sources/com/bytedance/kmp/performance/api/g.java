package com.bytedance.kmp.performance.api;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.performance.reporter.c f252638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableState<KPerfStatus> f252639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final buc.d f252640d;

    public g(String r100, com.bytedance.kmp.performance.reporter.c r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        this.f252637a = r100;
        this.f252638b = r101;
        this.f252639c = SnapshotStateKt.mutableStateOf$default(KPerfStatus.FIRST_FRAME, null, 2, null);
        this.f252640d = buc.b.c(0);
    }
}
