package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.util.DecryptUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes38.dex */
public class V3DevicePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        String r100 = this.mSetting.optString("s");
        String r101 = DecryptUtils.decrypt(this.mSetting.optString("ag"), r100);
        String r102 = DecryptUtils.decrypt(this.mSetting.optString("ah"), r100);
        String r103 = DecryptUtils.decrypt(this.mSetting.optString("ai"), r100);
        String r104 = DecryptUtils.decrypt(this.mSetting.optString("aj"), r100);
        Intent r105 = new Intent();
        r105.putExtra(r101, this.mJumpPath);
        r105.putExtra(r102, "*/*");
        r105.putExtra(r103, true);
        r105.setAction(r104);
        r105.addFlags(268435456);
        r105.addFlags(32768);
        return r105;
    }

    public V3DevicePlan(Context r100, DownloadSetting r101, String r102) {
        super(r100, r101, r102);
    }
}
