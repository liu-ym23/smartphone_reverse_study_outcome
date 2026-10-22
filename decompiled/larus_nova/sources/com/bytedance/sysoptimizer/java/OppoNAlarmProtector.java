package com.bytedance.sysoptimizer.java;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.livesdkapi.app.AppConstants;
import java.util.Collections;

/* JADX INFO: loaded from: classes22.dex */
public class OppoNAlarmProtector {
    private static boolean sIsInit;

    public OppoNAlarmProtector() {
    }

    public static void install(Context r100) {
        if (Build.VERSION.SDK_INT == 25) goto L5;
        return;
    L5:
        if (Build.MANUFACTURER.equals(AppConstants.CHANNEL_OPPO) == false) goto L14;
        if (r100 != null) goto L9;
        return;
    L9:
        if (sIsInit == false) goto L11;
        return;
    L11:
        sIsInit = BinderServiceWrapperProtector.install(r100, "alarm", Collections.singletonList("set"), "OppoNAlarm", BinderServiceWrapperProtector.VOID_ADMIN_RESULT);
        return;
    }
}
