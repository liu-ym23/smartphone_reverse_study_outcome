package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes38.dex */
public class AndroidUnknownSourcePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent r100 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", UriProtector.parse("package:" + this.mContext.getPackageName()));
        r100.addFlags(1073741824);
        r100.addFlags(8388608);
        r100.addFlags(268435456);
        return r100;
    }

    public AndroidUnknownSourcePlan(Context r100) {
        super(r100, null, null);
    }
}
