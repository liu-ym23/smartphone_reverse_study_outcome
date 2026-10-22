package com.ss.android.downloadlib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.utils.MarketUriUtils;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.DownloadConstants;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class InnerOpenAppUtils {
    public InnerOpenAppUtils() {
    }

    private static Uri jointIgnoreInterceptInMarketScheme(Uri r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.JOINT_IGNORE_INTERCEPT_IN_SCHEME, 0) != 1) goto L16;
        String r101 = MarketUriUtils.getPackageNameFromUri(r100);
        if (r101 != null) goto L8;
        return r100;
    L8:
        DownloadModel r102 = ModelManager.getInstance().getDownloadModel(r101);
        if (r102 != null) goto L12;
        return r100;
    L12:
        if (DownloadInsideHelper.callSceneIsAdComplianceData(r102) == true) goto L14;
        return r100;
    L14:
        return r100.buildUpon().appendQueryParameter(DownloadConstants.MARKET_IGNORE_INTERCEPT, "1").build();
    L16:
        return r100;
    }

    public static OpenAppResult tryOpenByPackage(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r100 != null) goto L8;
        r100 = GlobalInfo.getContext();
    L8:
        Intent r102 = ToolUtils.getLaunchIntentForPackage(r100, r101);
        if (r102 == null) goto L11;
        r102.putExtra("start_only_for_android", true);
        if (DownloadSettingUtils.checkSpecialAppLinkPackageName(r101) == false) goto L26;
        if (DownloadSettingUtils.checkSpecialAppLinkOptOpen(null) == false) goto L26;
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, EventConstants.ExtraJson.TAOBAO_APPLINK_OPT_SCENE, 7);
        DownloadInsideHelper.upgradeSpecialApplinkIntent(r102, null, r103);
    L26:
        if (DownloadSettingUtils.enableBpeaCert(0) == false) goto L21;
        GlobalInfo.getDownloadBpeaCertFactory().startActivityByBpea(r100, r102, 1);     // Catch: Exception -> L24
    L23:
        return new OpenAppResult(3);
    L21:
        r100.startActivity(r102);     // Catch: Exception -> L24
        goto L23
    L25:
        return new OpenAppResult(4, 23);
    L11:
        return new OpenAppResult(4, 22);
    L5:
        return new OpenAppResult(4, 11);
    }

    public static boolean tryOpenByQuickAppUrl(Context r100, String r101) {
        if (r100 != null) goto L16;
        return false;
    L16:
        Uri r102 = UriProtector.parse(r101);     // Catch: Throwable -> L13
        if (com.ss.android.downloadlib.applink.MarketUriUtils.isMarketUri(r102) == false) goto L8;
        r102 = jointIgnoreInterceptInMarketScheme(r102);     // Catch: Throwable -> L13
    L8:
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Throwable -> L13
        r103.setData(r102);     // Catch: Throwable -> L13
        r103.addFlags(268435456);     // Catch: Throwable -> L13
        r103.putExtra("open_url", r101);     // Catch: Throwable -> L13
        r103.putExtra("start_only_for_android", true);     // Catch: Throwable -> L13
        if (DownloadSettingUtils.enableBpeaCert(0) == false) goto L11;
        GlobalInfo.getDownloadBpeaCertFactory().startActivityByBpea(r100, r103, 1);     // Catch: Throwable -> L13
    L12:
        return true;
    L11:
        r100.startActivity(r103);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static OpenAppResult tryOpenByUrl(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
        if (r100 != null) goto L8;
        r100 = GlobalInfo.getContext();
    L8:
        Uri r102 = UriProtector.parse(r101);
        if (com.ss.android.downloadlib.applink.MarketUriUtils.isMarketUri(r102) == false) goto L11;
        r102 = jointIgnoreInterceptInMarketScheme(UriProtector.parse(r101));
    L11:
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r103.setData(r102);
        r103.addFlags(268435456);
        r103.putExtra("open_url", r101);
        r103.putExtra("start_only_for_android", true);
        r103.addFlags(67108864);
        if (DownloadSettingUtils.checkSpecialAppLinkOpenUrlScheme(r102.getScheme()) == false) goto L17;
        if (DownloadSettingUtils.checkSpecialAppLinkOptOpen(null) == false) goto L17;
        JSONObject r104 = new JSONObject();
        ToolUtils.safePut(r104, EventConstants.ExtraJson.TAOBAO_APPLINK_OPT_SCENE, 8);
        DownloadInsideHelper.upgradeSpecialApplinkIntent(r103, null, r104);
    L17:
        if (ToolUtils.isInstalledApp(r100, r103) == false) goto L28;
        if (DownloadSettingUtils.enableBpeaCert(0) == false) goto L22;
        GlobalInfo.getDownloadBpeaCertFactory().startActivityByBpea(r100, r103, 1);     // Catch: Exception -> L25
    L24:
        return new OpenAppResult(1);
    L22:
        r100.startActivity(r103);     // Catch: Exception -> L25
        goto L24
    L26:
        return new OpenAppResult(2);
    L28:
        return new OpenAppResult(2, 24);
    L5:
        return new OpenAppResult(2, 21);
    }
}
