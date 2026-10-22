package com.huawei.hms.hihealthlite;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiHiHealthLite {
    private HuaweiHiHealthLite() {
    }

    public static LoginFreeAuthController getLoginFreeAuthController(Activity r100) {
        Preconditions.checkNotNull(r100);
        Context r101 = r100.getApplicationContext();
        HiHealthKitClient.getInstance().setContext(r101);
        return new LoginFreeAuthController();
    }

    public static LoginFreeAuthController getLoginFreeAuthController(Context r100) {
        Preconditions.checkNotNull(r100);
        HiHealthKitClient.getInstance().setContext(r100);
        return new LoginFreeAuthController();
    }
}
