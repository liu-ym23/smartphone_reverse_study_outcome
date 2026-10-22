package com.bytedance.dux.window.listener;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import em4.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {
    public static final LifecycleCoroutineScope a(Lifecycle r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return LifecycleKt.getCoroutineScope(r100);
    L5:
        e = move-exception;
        int r101 = d.f473061a;
        d.b("WindowConfigChangeListener", "get coroutineScope error: " + e.getMessage());
        return null;
    }
}
