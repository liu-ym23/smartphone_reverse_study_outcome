package com.huawei.hms.healthlite;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.huawei.hms.hihealthlite.HiHealthKitClient;
import com.huawei.hms.hihealthlite.activity.HealthKitLoginFreeActivity;

/* JADX INFO: loaded from: classes23.dex */
public class aabd {
    private static volatile aabd aaba;

    /* JADX INFO: renamed from: aab, reason: collision with root package name */
    private HiHealthKitClient f277486aab;

    public aabd() {
        this.f277486aab = HiHealthKitClient.getInstance();
    }

    public static aabd aab() {
        if (aaba != null) goto L15;
        monitor-enter(aabd.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (aaba != null) goto L9;
        aaba = new aabd();     // Catch: Throwable -> L11
    L9:
        monitor-exit(aabd.class);     // Catch: Throwable -> L11
    L15:
        return aaba;
    }

    public Intent aab(String[] r100, String r101, String r102, String r103, String r104) {
        Intent r105 = new Intent(this.f277486aab.getContext(), HealthKitLoginFreeActivity.class);
        r105.putExtra(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r100);
        r105.putExtra("state", r101);
        r105.putExtra("clientId", r102);
        r105.putExtra("signature", r104);
        r105.putExtra("deepLinkUrl", r103);
        return r105;
    }
}
