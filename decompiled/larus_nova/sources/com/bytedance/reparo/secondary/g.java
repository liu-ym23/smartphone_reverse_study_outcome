package com.bytedance.reparo.secondary;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements SDKMonitor.IGetExtendParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f267484a;

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final String getSessionId() {
        return null;
    }

    @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
    public final Map<String, String> getCommonParams() {
        Map<String, String> r100 = this.f267484a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        HashMap r101 = new HashMap();
        this.f267484a = r101;
        r101.put("device_manufacturer", Build.MANUFACTURER);
        Map<String, String> r102 = this.f267484a;
        String r103 = Build.BRAND;
        String r104 = Build.MODEL;
        if (TextUtils.isEmpty(r104) == false) goto L10;
        if (r103 != null) goto L9;
        r103 = "UNKNOWN";
    L9:
        r104 = r103;
    L14:
        r102.put("device_model", r104);
        return this.f267484a;
    L10:
        if (r103 == null) goto L14;
        if (r104.contains(r103) == true) goto L14;
        r104 = r103 + ' ' + r104;
        goto L14
    }

    public g() {
        this.f267484a = null;
    }
}
