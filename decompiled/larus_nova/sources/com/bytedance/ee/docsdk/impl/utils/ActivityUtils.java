package com.bytedance.ee.docsdk.impl.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class ActivityUtils {
    public ActivityUtils() {
    }

    public static boolean isActive(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == false) goto L12;
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L10;
    L11:
        return false;
    L10:
        if (r101.isFinishing() == true) goto L11;
        return true;
    L12:
        return true;
    }

    public static boolean isForeground(Activity r100) {
        return isForeground(r100, r100.getClass().getName());
    }

    public static boolean isActive(Activity r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.isDestroyed() == false) goto L8;
        return false;
    L8:
        if (r100.isFinishing() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean isForeground(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        List<ActivityManager.RunningTaskInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningTasks(1);
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.size() > 0) goto L12;
        return false;
    L12:
        if (r101.equals(((ActivityManager.RunningTaskInfo) ListProtector.get(r102, 0)).topActivity.getClassName()) == false) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }
}
