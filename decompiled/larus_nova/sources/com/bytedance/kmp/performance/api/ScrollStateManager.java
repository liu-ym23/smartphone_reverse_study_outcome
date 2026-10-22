package com.bytedance.kmp.performance.api;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.jvm.internal.Intrinsics;
import md6.o1;

/* JADX INFO: loaded from: classes19.dex */
public final class ScrollStateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableState f252603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableIntState f252604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public o1 f252605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScrollStateManager$connection$1 f252606d;

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.kmp.performance.api.ScrollStateManager$connection$1] */
    public ScrollStateManager() {
        this.f252603a = SnapshotStateKt.mutableStateOf$default(new o1(false, false), null, 2, null);
        this.f252604b = SnapshotIntStateKt.mutableIntStateOf(0);
        this.f252605c = new o1(false, false);
        this.f252606d = new ScrollStateManager$connection$1(this);
    }

    public final void a(boolean r100, boolean r101) {
        o1 r102 = new o1(r100, r101);
        if (Intrinsics.areEqual(r102, this.f252605c) == true) goto L6;
        this.f252605c = r102;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        this.f252603a.setValue(r102);
        return;
    }
}
