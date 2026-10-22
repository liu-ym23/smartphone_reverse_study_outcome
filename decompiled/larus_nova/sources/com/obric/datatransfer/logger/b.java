package com.obric.datatransfer.logger;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements a {
    public b() {
    }

    @Override // com.obric.datatransfer.logger.a
    public final void log(TransferLogger.Level r100, String r101, String r102, Throwable r103) {
        Intrinsics.checkNotNullParameter(r100, "level");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "message");
        if (r103 == null) goto L6;
        Log.getStackTraceString(r103);
    L6:
        r100.getLevelValue();
    }
}
