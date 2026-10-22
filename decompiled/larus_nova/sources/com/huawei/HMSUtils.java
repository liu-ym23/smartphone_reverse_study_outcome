package com.huawei;

import android.content.Context;
import com.bytedance.push.utils.f;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.hw.HWPushAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class HMSUtils {
    public HMSUtils() {
    }

    public static boolean isHMSAvailable(Context r100) {
        f.g(HWPushAdapter.TAG, "isHMSAvailableCode = " + isHuaweiMobileServicesAvailable(r100));
        if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r100) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static int isHuaweiMobileServicesAvailable(Context r100) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(r100);
    }
}
