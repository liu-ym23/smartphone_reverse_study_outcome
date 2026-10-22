package com.ss.android.download.api.clean;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.appdownloader.util.package_info.PackageInfoUtils;

/* JADX INFO: loaded from: classes34.dex */
public class CleanApkType extends CleanType {
    public static final String CLEAN_APK_TYPE = "clean_apk_type";

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile
    public String getClassifyType() {
        return CLEAN_APK_TYPE;
    }

    public CleanApkType() {
    }

    public void addCleanItem(Context r100, CleanFile r101) {
        if (r101 == null) goto L19;
        if (r100 == null) goto L23;
        ApkCleanFile r102 = new ApkCleanFile();
        r102.setFolderName(r101.getFolderName());
        r102.setName(r101.getName());
        r102.setAbsolutePath(r101.getAbsolutePath());
        PackageInfo r103 = PackageInfoUtils.getPackageInfo(r100, new PolarisFileWrapper(r101.getAbsolutePath()), 0);     // Catch: Exception -> L14
        if (r103 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r103.packageName) == true) goto L21;
        ApkInfo r104 = new ApkInfo();     // Catch: Exception -> L14
        r104.setAppName(r101.getName());     // Catch: Exception -> L14
        r104.setPackageName(r103.packageName);     // Catch: Exception -> L14
        r104.setVersion(r103.versionName);     // Catch: Exception -> L14
        r102.setApkInfo(r104);     // Catch: Exception -> L14
        boolean r105 = r102.addCleanFile(r101);     // Catch: Exception -> L14
        r102.setParent(this);     // Catch: Exception -> L14
        if (r105 == false) goto L22;
        this.cleanFolders.add(r102);     // Catch: Exception -> L14
        this.size += r101.getSize();     // Catch: Exception -> L14
        return;
    L22:
        return;
    L21:
        return;
    L14:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        return;
    }
}
