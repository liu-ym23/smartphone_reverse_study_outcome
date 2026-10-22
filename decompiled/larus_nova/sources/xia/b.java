package xia;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    static {
    }

    public static boolean a(Context r100, ComponentName r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "componentName");
        PackageManager r102 = r100.getPackageManager();
        boolean r103 = !r102.getApplicationInfo(r101.getPackageName(), 0).enabled;
    L6:
        if (r103 == false) goto L8;
        return false;
    L8:
        int r104 = r102.getComponentEnabledSetting(r101);
        if (r104 == 0) goto L23;
        if (r104 != 1) goto L20;
        return true;
    L23:
        boolean r105 = r102.getActivityInfo(r101, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L14 Exception -> L22
    L13:
        return r105;
    L14:
        r105 = r102.getServiceInfo(r101, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L16 Exception -> L22
    L16:
        r105 = r102.getReceiverInfo(r101, 0).enabled;     // Catch: PackageManager.NameNotFoundException -> L18 Exception -> L22
    L18:
        r105 = r102.getProviderInfo(r101, 0).enabled;     // Catch: Exception -> L22
    L20:
        return false;
    L5:
        r103 = true;
        goto L6
    }
}
