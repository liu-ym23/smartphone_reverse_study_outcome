package com.huawei.hms.utils;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsApp;

/* JADX INFO: loaded from: classes23.dex */
public class RegionUtils {
    public RegionUtils() {
    }

    private static String a(Context r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.getApplicationContext() != null) goto L7;
        return "";
    L7:
        return GrsApp.getInstance().getIssueCountryCode(r100);
    }

    public static boolean isChinaROM(Context r100) {
        return "CN".equalsIgnoreCase(a(r100));
    }
}
