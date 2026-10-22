package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes38.dex */
public class O1DevicePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent r100 = new Intent(DownloadConstants.LOWER_OPPO + ".filemanager.intent.action.BROWSER_FILE");
        r100.putExtra("CurrentDir", this.mJumpPath);
        r100.putExtra("CurrentMode", 1);
        r100.addFlags(268435456);
        r100.addFlags(32768);
        r100.addFlags(1073741824);
        return r100;
    }

    public O1DevicePlan(Context r100, DownloadSetting r101, String r102) {
        super(r100, r101, r102);
    }
}
