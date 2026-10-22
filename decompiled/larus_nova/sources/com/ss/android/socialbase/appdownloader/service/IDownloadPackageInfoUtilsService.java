package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadPackageInfoUtilsService {

    public static class DefaultDownloadPackageInfoUtilsService implements IDownloadPackageInfoUtilsService {
        public DefaultDownloadPackageInfoUtilsService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public String getAppNameByPackageInfo(Context r100, PackageInfo r101, String r102) {
            return null;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public PackageInfo getPackageInfo(Context r100, File r101, int r102) {
            return null;
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadPackageInfoUtilsService
        public PackageInfo getPackageInfo(File r100) {
            return new PackageInfo();
        }
    }

    String getAppNameByPackageInfo(Context r100, PackageInfo r101, String r102);

    PackageInfo getPackageInfo(Context r100, File r101, int r102);

    PackageInfo getPackageInfo(File r100);
}
