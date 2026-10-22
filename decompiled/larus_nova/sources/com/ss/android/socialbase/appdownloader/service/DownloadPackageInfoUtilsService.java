package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.util.package_info.PackageInfoUtilsImpl;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadPackageInfoUtilsService implements IDownloadPackageInfoUtilsService {
    public DownloadPackageInfoUtilsService() {
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public PackageInfo getPackageInfo(File r100) {
        return PackageInfoUtilsImpl.getPackageInfo(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public String getAppNameByPackageInfo(Context r100, PackageInfo r101, String r102) {
        return PackageInfoUtilsImpl.getAppNameByPackageInfo(r100, r101, r102);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
    public PackageInfo getPackageInfo(Context r100, File r101, int r102) {
        return PackageInfoUtilsImpl.getPackageInfo(r100, r101, r102);
    }
}
