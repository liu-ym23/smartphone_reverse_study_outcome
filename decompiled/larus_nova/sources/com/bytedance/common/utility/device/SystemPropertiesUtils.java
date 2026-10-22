package com.bytedance.common.utility.device;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes15.dex */
public final class SystemPropertiesUtils {
    public static volatile boolean hasProxy = true;
    private static SystemPropertiesProxy proxy;

    static {
        proxy = new SystemPropertiesProxy();
    }

    public static String getSystemProperty(String r100) {
        if (hasProxy == false) goto L9;
        return proxy.get(r100);
    L6:
        th = move-exception;
        Logger.e("SystemPropertiesUtils", "android.os.SystemProperties reflect fail.", th);
        return CmdSystemProperties.getSystemProperty(r100);
    L9:
        return CmdSystemProperties.getSystemProperty(r100);
    }
}
