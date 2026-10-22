package com.bytedance.ee.docsdk.impl.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ActivityUtils {
    public ActivityUtils() {
    }

    public static boolean isActive(Context r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if ((r2 instanceof Activity) == false) goto L12;
        Activity r3 = (Activity) r2;
        if (r3.isDestroyed() == false) goto L10;
    L11:
        return false;
    L10:
        if (r3.isFinishing() == true) goto L11;
        return true;
    L12:
        return true;
    }

    public static boolean isForeground(Activity r1) {
        return isForeground(r1, r1.getClass().getName());
    }

    public static boolean isActive(Activity r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (r2.isDestroyed() == false) goto L8;
        return false;
    L8:
        if (r2.isFinishing() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isForeground(Context r3, String r4) {
        if (r3 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L19;
        List<ActivityManager.RunningTaskInfo> r5 = ((ActivityManager) r3.getSystemService("activity")).getRunningTasks(1);
        if (r5 != null) goto L10;
        return false;
    L10:
        if (r5.size() > 0) goto L12;
        return false;
    L12:
        if (r4.equals(((ActivityManager.RunningTaskInfo) ListProtector.get(r5, 0)).topActivity.getClassName()) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }
}
