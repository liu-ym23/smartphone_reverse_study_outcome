package com.ss.bytertc.engine.utils;

import android.app.ActivityManager;
import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class CommonUtils {
    public CommonUtils() {
    }

    public static boolean isInForeground(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        String r102 = r100.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r103 = r101.getRunningAppProcesses();
        if (r103 != null) goto L5;
        return false;
    L5:
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r103.iterator();
    L7:
        if (r104.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();
        if (r105.processName.equals(r102) == false) goto L7;
        if (r105.importance != 100) goto L7;
        return true;
    L14:
        return false;
    }
}
