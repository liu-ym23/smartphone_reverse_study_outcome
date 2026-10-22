package com.ss.android.downloadlib.applink;

import android.os.Build;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;

/* JADX INFO: loaded from: classes34.dex */
public class KllkOptimiseHelper {
    public KllkOptimiseHelper() {
    }

    public static boolean canInvokeAppFormOppoBackground(NativeDownloadModel r100) {
        IAdDownloadCheckerProvider r101 = (IAdDownloadCheckerProvider) DownloadAdRuntimeProvider.getInnerService(IAdDownloadCheckerProvider.class);
        if (RomUtils.isOppo() == true) goto L5;
    L14:
        return false;
    L5:
        if (Build.VERSION.SDK_INT >= 29) goto L14;
        if (r101 == null) goto L14;
        if (r101.isAppBackground() == false) goto L14;
        if (DownloadSettingUtils.getSetting(r100).optInt(DownloadSettingKeys.KEY_INVOKE_APP_FORM_BACKGROUND_SWITCH) != 1) goto L14;
        if (r100.enableNewActivity() == false) goto L14;
        return true;
    }
}
