package android.app;

import android.content.pm.ProviderInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActivityThreadCompat {
    public ActivityThreadCompat() {
    }

    public static ActivityThread currentActivityThread() {
        return ActivityThread.currentActivityThread();
    }

    public static List<ProviderInfo> getProviders() {
        ActivityThread r0 = currentActivityThread();
        if (r0 == null) goto L8;
        ActivityThread.AppBindData r1 = r0.mBoundApplication;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.providers;
    L8:
        return null;
    }

    public static boolean installProviders(List<ProviderInfo> r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        ActivityThread r1 = currentActivityThread();
        if (r1 != null) goto L8;
    L11:
        return false;
    L8:
        if (r2.size() <= 0) goto L11;
        r1.installSystemProviders(r1.mBoundApplication.providers);
        return true;
    }

    public static boolean setProviders(List<ProviderInfo> r1) {
        ActivityThread r0 = currentActivityThread();
        if (r0 == null) goto L8;
        ActivityThread.AppBindData r2 = r0.mBoundApplication;
        if (r2 == null) goto L10;
        r2.providers = r1;
        return true;
    L10:
        return false;
    L8:
        return false;
    }
}
