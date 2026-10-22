package com.bytedance.mira.util;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes21.dex */
public class SafeUtils {
    public SafeUtils() {
    }

    public static boolean checkTargetIntentValid(ContextWrapper r100, Intent r101, boolean r102) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L23;
        if (r102 == false) goto L8;
        ResolveInfo r103 = r100.getPackageManager().resolveService(r101, 0);
    L9:
        if (r103 == null) goto L20;
        ActivityInfo r104 = r103.activityInfo;
        if (r104 == null) goto L21;
        ApplicationInfo r105 = r104.applicationInfo;
        if (r105 != null) goto L16;
        return false;
    L16:
        if (r105.uid != r100.getApplicationInfo().uid) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L20:
        return false;
    L8:
        r103 = r100.getPackageManager().resolveActivity(r101, 0);
        goto L9
    L23:
        return false;
    L19:
        return false;
    }
}
