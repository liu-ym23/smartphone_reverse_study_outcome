package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes38.dex */
public class V2DevicePlan extends AbsDevicePlan {
    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public Intent getJumpIntent() {
        Intent r100 = new Intent("com.android.filemanager.OPEN_FOLDER");
        r100.putExtra("com.android.filemanager.OPEN_FOLDER", this.mJumpPath);
        r100.putExtra("com.iqoo.secure", true);
        r100.addFlags(268435456);
        r100.addFlags(32768);
        r100.addFlags(1073741824);
        return r100;
    }

    public V2DevicePlan(Context r100, DownloadSetting r101, String r102) {
        super(r100, r101, r102);
    }
}
