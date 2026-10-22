package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes38.dex */
public class M1UnknownSourcePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent r100 = new Intent("android.settings.SECURITY_SETTINGS");
        r100.addFlags(268435456);
        r100.addFlags(1073741824);
        r100.addFlags(8388608);
        return r100;
    }

    public M1UnknownSourcePlan(Context r100) {
        super(r100, null, null);
    }
}
