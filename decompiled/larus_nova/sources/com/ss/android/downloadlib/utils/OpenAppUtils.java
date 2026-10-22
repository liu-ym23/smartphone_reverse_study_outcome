package com.ss.android.downloadlib.utils;

import android.content.Context;
import android.net.Uri;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.applink.AdInstalledAppOpenSubManager;
import com.ss.android.downloadlib.applink.AdMarketOpenSubManager;

/* JADX INFO: loaded from: classes34.dex */
public class OpenAppUtils {
    private static final String TAG = null;

    public OpenAppUtils() {
    }

    static {
        TAG = "OpenAppUtils";
    }

    public static OpenAppResult tryOpenByPackage(String r100) {
        return tryOpenByPackage(GlobalInfo.getContext(), r100);
    }

    public static OpenAppResult tryOpenByUrl(String r100) {
        return tryOpenByUrl(GlobalInfo.getContext(), r100);
    }

    public static OpenAppResult tryOpenByPackage(Context r100, String r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenMarket", "包名调起外部接口,命中优化场景");
        return AdInstalledAppOpenSubManager.getInstance().tryOpenByPackage(r100, r101);
    }

    public static boolean tryOpenByQuickAppUrl(Context r100, String r101) {
        return InnerOpenAppUtils.tryOpenByQuickAppUrl(r100, r101);
    }

    public static OpenAppResult tryOpenByUrl(Context r100, String r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenMarket", "url调起外部接口,命中优化场景");
        return AdInstalledAppOpenSubManager.getInstance().tryOpenByUrl(r100, r101);
    }

    public static OpenAppResult tryOpenMarket(Context r100, Uri r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenMarket", "通过uri调起商店,命中优化场景,调用来自外部");
        return AdMarketOpenSubManager.getInstance().tryOpenNormalMarket(r100, r101);
    }

    public static OpenAppResult tryOpenMarket(Context r100, String r101) {
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenMarket", "通过包名调起商店,命中优化场景,调用来自外部");
        return AdMarketOpenSubManager.getInstance().tryOpenNormalMarket(r100, r101);
    }
}
