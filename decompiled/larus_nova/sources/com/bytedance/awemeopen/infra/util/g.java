package com.bytedance.awemeopen.infra.util;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g {
    public static final void a(Lifecycle r100, j r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "observer");
        r101.f198966a = false;
        r100.addObserver(r101.f198967b);
        r101.f198966a = true;
    }
}
