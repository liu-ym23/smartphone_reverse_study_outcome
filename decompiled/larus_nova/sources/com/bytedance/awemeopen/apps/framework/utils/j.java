package com.bytedance.awemeopen.apps.framework.utils;

import android.os.Build;
import com.bytedance.awemeopen.infra.base.env.AoEnv;

/* JADX INFO: loaded from: classes14.dex */
public final class j {
    static {
    }

    public static boolean a() {
        if (AoEnv.j() == true) goto L6;
        return true;
    L6:
        if (Build.VERSION.SDK_INT > 28) goto L9;
        return false;
    L9:
        return true;
    }
}
