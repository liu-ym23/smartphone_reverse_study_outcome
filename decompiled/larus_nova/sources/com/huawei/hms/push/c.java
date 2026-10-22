package com.huawei.hms.push;

import android.os.Bundle;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class c {
    public static byte[] a(Bundle r100, String r101) {
        byte[] r102 = r100.getByteArray(r101);     // Catch: Exception -> L7
        if (r102 == null) goto L6;
        return r102;
    L6:
        return new byte[0];
    L7:
        e = move-exception;
        HMSLog.i(BundleUtil.TAG, "getByteArray exception" + e.getMessage());
        return new byte[0];
    }

    public static String b(Bundle r100, String r101) {
        return r100.getString(r101);
    L4:
        e = move-exception;
        HMSLog.i(BundleUtil.TAG, "getString exception" + e.getMessage());
        return null;
    }

    public static String c(Bundle r100, String r101) {
        String r102 = r100.getString(r101);     // Catch: Exception -> L7
        if (r102 != null) goto L6;
        return "";
    L6:
        return r102;
    L7:
        e = move-exception;
        HMSLog.i(BundleUtil.TAG, "getString exception" + e.getMessage());
        return "";
    }
}
