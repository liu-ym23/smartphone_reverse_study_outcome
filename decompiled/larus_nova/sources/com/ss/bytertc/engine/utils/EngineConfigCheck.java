package com.ss.bytertc.engine.utils;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.bytertc.engine.data.EngineConfig;

/* JADX INFO: loaded from: classes40.dex */
public class EngineConfigCheck {
    public static final int ENGINE_CONFIG_INVALID_APP_ID = 1;
    public static final int ENGINE_CONFIG_INVALID_CONTEXT = 3;
    public static final int ENGINE_CONFIG_INVALID_NATIVE_LIB_PATH = 2;
    public static final int ENGINE_CONFIG_VALID = 0;

    public EngineConfigCheck() {
    }

    public static int checkValid(EngineConfig r100) {
        if (TextUtils.isEmpty(r100.appID) == false) goto L7;
        return 1;
    L7:
        if (TextUtils.isEmpty(r100.nativeLoadPath) == true) goto L15;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.nativeLoadPath);
        if (r101.exists() == true) goto L11;
        return 2;
    L11:
        if (r101.isDirectory() == true) goto L15;
        return 2;
    L15:
        if (r100.context != null) goto L18;
        return 3;
    L18:
        return 0;
    }
}
