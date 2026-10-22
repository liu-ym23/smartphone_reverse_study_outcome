package org.jetbrains.compose.resources;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b0 {
    public static final String a(z r100, Composer r101) {
        Intrinsics.checkNotNullParameter(r100, "resource");
        r101.startReplaceGroup(1662071163);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1662071163, 0, -1, "org.jetbrains.compose.resources.stringResource (StringResources.android.kt:6)");
    L5:
        String r102 = StringResources_androidKt.stringResource(r100.f525843a, r101, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r101.endReplaceGroup();
        return r102;
    }
}
