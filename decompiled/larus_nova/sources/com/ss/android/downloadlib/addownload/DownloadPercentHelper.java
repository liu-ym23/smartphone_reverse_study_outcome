package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.utils.DownloadProgressOptHelper;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadPercentHelper {
    public DownloadPercentHelper() {
    }

    private static boolean enable(int r100) {
        NativeDownloadModel r101 = ModelManager.getInstance().getNativeModelByInfoId(r100);
        if (r101 == null) goto L22;
        if (DownloadInsideHelper.isGameUnionLive(r101.getModel()) == false) goto L22;
        JSONObject r102 = DownloadSettingUtils.getAdSettingJson();
        if (r102 == null) goto L16;
        if (r102.optInt(DownloadSettingKeys.PAUSE_OPTIMISE_PRETEND_DOWNLOAD_PERCENT_SWITCH, 0) == 1) goto L11;
    L13:
        return false;
    L11:
        if (r102.optInt(DownloadSettingKeys.PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L13;
        return true;
    L16:
        if (DownloadSettingUtils.getSetting(r101).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_PRETEND_DOWNLOAD_PERCENT_SWITCH, 0) == 1) goto L18;
    L20:
        return false;
    L18:
        if (DownloadSettingUtils.getSetting(r101).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L20;
        return true;
    L22:
        if (DownloadSetting.obtain(r100).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_PRETEND_DOWNLOAD_PERCENT_SWITCH, 0) == 1) goto L24;
    L26:
        return false;
    L24:
        if (DownloadSetting.obtain(r100).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_SWITCH, 0) != 1) goto L26;
        return true;
    }

    public static DownloadShortInfo handleDownloadShortInfoSize(DownloadShortInfo r100) {
        if (r100 != null) goto L4;
    L7:
        return r100;
    L4:
        if (enable((int) r100.f408261id) == false) goto L7;
        r100.currentBytes = getCurrBytes((int) r100.f408261id, r100.currentBytes, r100.totalBytes);
        goto L7
    }

    public static long getCurrBytes(int r100, long r101, long r102) {
        if (enable(r100) == true) goto L6;
        return r101;
    L6:
        if (r101 > 0) goto L9;
        return 0;
    L9:
        if (r102 > 0) goto L12;
        return r101;
    L12:
        return (r102 * ((long) handlePercent(r100, (int) ((r101 * 100) / r102), r102))) / 100;
    }

    public static int handlePercent(int r110, int r111, long r112) {
        NativeDownloadModel r100 = ModelManager.getInstance().getNativeModelByInfoId(r110);
        int r101 = 1;
        int r102 = 0;
        if (r100 != null) goto L5;
    L43:
        if (r111 <= 0) goto L56;
        if (r111 >= 100) goto L56;
        if (enable(r110) == false) goto L56;
        if (r100 != null) goto L49;
    L51:
        double r113 = r111;
    L52:
        if (r102 >= r101) goto L55;
        r113 = Math.sqrt(r113) * 10.0d;
        r102 = r102 + 1;
        goto L52
    L55:
        return (int) r113;
    L49:
        if (DownloadInsideHelper.isGameUnionLive(r100.getModel()) == false) goto L51;
    L56:
        return r111;
    L5:
        if (DownloadInsideHelper.checkProgressOptOpen(r100) == true) goto L7;
    L10:
        if (r111 != 0) goto L18;
        if (r100.hasDoRandomClickStartPercent.compareAndSet(false, true) == false) goto L18;
        if (DownloadInsideHelper.checkEnableRandomClickStartPercent(r100, r112) == false) goto L18;
        int r114 = DownloadProgressOptHelper.getInstance().getRandomStartPercent(DownloadInsideHelper.getRandomClickStartPercentStrategy(r100), r111);
        r100.setRandomClickStartPercent(r114);
        return r114;
    L18:
        if (DownloadInsideHelper.checkDownloadPretendNewStrategyEnable(r100) == false) goto L39;
        if (r111 < r100.getRandomClickStartPercent()) goto L39;
        if (r111 <= 0) goto L39;
        if (r111 >= 100) goto L39;
        int r115 = DownloadInsideHelper.getDownloadPretendNewStrategy(r100);
        if (r115 <= 0) goto L43;
        if (r115 == 1) goto L37;
        if (r115 == 2) goto L60;
        if (r115 == 3) goto L59;
        if (r115 != 4) goto L61;
        int r103 = DownloadInsideHelper.getDownloadPretendNewFirstHalfStrategy(r100);
        int r116 = DownloadInsideHelper.getDownloadPretendNewStrategyFirstHalfRoundsValue(r100);
        return DownloadProgressOptHelper.getInstance().getOptProgress(4, r111, 0, r103, DownloadInsideHelper.getDownloadPretendNewSecondHalfStrategy(r100), r116);
    L61:
        return 0;
    L59:
        return DownloadProgressOptHelper.getInstance().getOptProgress(3, r111, 0, 0, 0, 0);
    L60:
        return DownloadProgressOptHelper.getInstance().getOptProgress(2, r111, DownloadInsideHelper.getDownloadPretendNewStrategyRoundsValue(r100), 0, 0, 0);
    L37:
        return DownloadProgressOptHelper.getInstance().getOptProgress(1, r111, DownloadInsideHelper.getDownloadPretendNewStrategyRoundsValue(r100), 0, 0, 0);
    L39:
        if (r111 < r100.getRandomClickStartPercent()) goto L41;
        r101 = DownloadSetting.obtain(r110).optInt(DownloadSettingKeys.PAUSE_OPTIMISE_PRETEND_DOWNLOAD_PERCENT_ROUNDS, 1);
        goto L43
    L41:
        return r100.getRandomClickStartPercent();
    L7:
        if (GlobalInfo.getDownloadProgressHandleFactory() == null) goto L10;
        return GlobalInfo.getDownloadProgressHandleFactory().handleProgress(r111, r112);
    }
}
