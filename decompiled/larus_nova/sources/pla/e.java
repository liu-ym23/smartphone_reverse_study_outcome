package pla;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class e {
    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.getResources().getConfiguration().orientation != 2) goto L9;
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        wma.b.c("ResourceUtils", "isLandscape error", e);
        goto L9
    }
}
