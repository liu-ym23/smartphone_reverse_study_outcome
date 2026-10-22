package xw9;

import android.content.Context;
import android.provider.Settings;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class h {
    static {
    }

    public static boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Settings.System.getInt(r100.getContentResolver(), "accelerometer_rotation") == 1) goto L10;
    L13:
        boolean r101 = false;
    L15:
        return !r101;
    L10:
        r101 = true;
    L6:
        e = move-exception;
        FLogger.f375446a.e("OrientationLockUtils", "isAutoRotationEnabled error1: " + e);
        if (Settings.System.getInt(r100.getContentResolver(), "accelerometer_rotation") != 1) goto L13;
    L11:
        e = move-exception;
        FLogger.f375446a.e("OrientationLockUtils", "isAutoRotationEnabled error2: " + e);
        goto L13
    }
}
