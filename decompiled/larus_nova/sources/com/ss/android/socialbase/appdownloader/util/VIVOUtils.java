package com.ss.android.socialbase.appdownloader.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes38.dex */
public class VIVOUtils {
    private static final String SHOULD_INSERT_PASSWORD = "persist.vivo.install.account.verify";

    public VIVOUtils() {
    }

    public static boolean shouldInsertInstallPassword() {
        String r100 = RomUtils.getProp(SHOULD_INSERT_PASSWORD);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return true;
    L6:
        return !"0".equals(r100);
    }
}
