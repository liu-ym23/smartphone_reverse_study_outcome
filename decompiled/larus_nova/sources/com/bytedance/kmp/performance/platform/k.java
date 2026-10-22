package com.bytedance.kmp.performance.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;

/* JADX INFO: loaded from: classes19.dex */
public final class k {
    public static final void a(Composer r100) {
        r100.startReplaceGroup(1912916049);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(1912916049, 0, -1, "com.bytedance.kmp.performance.platform.getContainerId (Expected.android.kt:9)");
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r100.endReplaceGroup();
    }
}
