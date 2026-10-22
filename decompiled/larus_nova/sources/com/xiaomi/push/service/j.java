package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes41.dex */
public class j {
    public static ComponentName a(Context r100, Intent r101) {
        if (r101 == null) goto L16;
        ResolveInfo r102 = r100.getPackageManager().resolveActivity(r101, 65536);     // Catch: Exception -> L13
        if (r102 != null) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r102.activityInfo.targetActivity) == false) goto L9;
        String r103 = r102.activityInfo.name;     // Catch: Exception -> L13
    L10:
        return new ComponentName(r102.activityInfo.packageName, r103);
    L9:
        r103 = r102.activityInfo.targetActivity;     // Catch: Exception -> L13
    L18:
        return null;
    L16:
        return null;
    }

    public static boolean a(Context r100, ComponentName r101) {
        new Intent().setComponent(r101);     // Catch: Exception -> L5
        r100.getPackageManager().getActivityInfo(r101, 128);     // Catch: Exception -> L5
        return true;
    L5:
        return false;
    }
}
