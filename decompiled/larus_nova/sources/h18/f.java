package h18;

import android.content.Context;
import android.content.res.Configuration;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return b(r100.getResources().getConfiguration());
    }

    @JvmStatic
    public static final boolean b(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if ((r100.uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }
}
