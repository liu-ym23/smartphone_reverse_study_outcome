package com.huawei.hms.hwid;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.adapter.AvailableAdapter;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public static int a() {
        return 40004000;
    }

    public static void a(Activity r100, AvailableAdapter.AvailableCallBack r101) {
        as.b("HmsAccountKitVersionCheckUtil", "====== HMSSDK version: 61100301 ======", true);
        Context r102 = r100.getApplicationContext();
        int r103 = a();
        as.b("HmsAccountKitVersionCheckUtil", "check minVersion:" + r103, true);
        AvailableAdapter r104 = new AvailableAdapter(r103);
        int r105 = r104.isHuaweiMobileServicesAvailable(r102);
        if (r105 != 0) goto L6;
        r101.onComplete(r105);
        return;
    L6:
        if (r104.isUserResolvableError(r105) == false) goto L8;
        r104.startResolution(r100, r101);
        return;
    L8:
        r101.onComplete(r105);
    }
}
