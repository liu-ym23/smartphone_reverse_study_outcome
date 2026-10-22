package com.ss.android.socialbase.appdownloader.util.package_info;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public class PackageInfoUtils {
    public PackageInfoUtils() {
    }

    public static PackageInfo getPackageInfo(File r100) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getPackageInfo(r100);
    }

    public static String getAppNameByPackageInfo(Context r100, PackageInfo r101, String r102) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getAppNameByPackageInfo(r100, r101, r102);
    }

    public static PackageInfo getPackageInfo(Context r100, File r101, int r102) {
        return ((IDownloadPackageInfoUtilsService) AppDownloadServiceManager.getService(IDownloadPackageInfoUtilsService.class)).getPackageInfo(r100, r101, r102);
    }
}
