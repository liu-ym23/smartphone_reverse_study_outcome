package com.ss.android.socialbase.appdownloader.ah;

import android.content.Context;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDevicePlan implements IAhDevicePlan {
    private static final String TAG = "AbsDevicePlan";
    protected final Context mContext;
    protected final String mJumpPath;
    protected final DownloadSetting mSetting;

    @Override // com.ss.android.socialbase.appdownloader.ah.IAhDevicePlan
    public boolean isValid() {
        if (this.mContext != null) goto L13;
        return false;
    L13:
        if (getJumpIntent().resolveActivity(this.mContext.getPackageManager()) == null) goto L12;
        return true;
    L12:
        return false;
    L10:
        th = move-exception;
        Logger.globalError(TAG, "isValid", "Check is valid failed: " + th.toString());
        goto L12
    }

    public AbsDevicePlan(Context r100, DownloadSetting r101, String r102) {
        this.mContext = r100;
        this.mSetting = r101;
        this.mJumpPath = r102;
    }
}
