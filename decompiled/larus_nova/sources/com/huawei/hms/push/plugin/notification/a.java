package com.huawei.hms.push.plugin.notification;

import com.huawei.hms.android.HwBuildEx;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a {
    public static boolean a() {
        if (HwBuildEx.VERSION.EMUI_SDK_INT < 21) goto L5;
        return true;
    L5:
        return false;
    }
}
