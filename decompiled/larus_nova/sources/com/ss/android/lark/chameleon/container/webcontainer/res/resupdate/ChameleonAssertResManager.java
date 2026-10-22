package com.ss.android.lark.chameleon.container.webcontainer.res.resupdate;

import android.app.Application;
import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.api.ChameleonConfig;
import com.ss.android.lark.chameleon.api.ResConfig;
import com.ss.android.lark.chameleon.container.webcontainer.util.Storage;
import com.ss.android.lark.chameleon.container.webcontainer.util.StorageUtils;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.FileUtils;
import com.ss.android.lark.chameleon.util.LzmaUtils;
import com.ss.android.lark.chameleon.util.PackageUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonAssertResManager;", "", "()V", "ASSET_FOLDER", "", "TAG", "localChameleonResInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ss/android/lark/chameleon/container/webcontainer/res/resupdate/ChameleonResInfo;", "extractSimAssetToLocal", "", "chameleonConfig", "Lcom/ss/android/lark/chameleon/api/ChameleonConfig;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "destFile", "Ljava/io/File;", "getAssetFilePath", "getLocalAssetFileName", "getLocalAssetPath", "getResInfo", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ChameleonAssertResManager {
    public static final String ASSET_FOLDER = "assets";
    public static final ChameleonAssertResManager INSTANCE = null;
    public static final String TAG = "CML_TAG_AssertResManager";
    private static ConcurrentHashMap<String, ChameleonResInfo> localChameleonResInfoMap;

    private ChameleonAssertResManager() {
    }

    static {
        INSTANCE = new ChameleonAssertResManager();
        localChameleonResInfoMap = new ConcurrentHashMap();
    }

    private final String getLocalAssetPath(ChameleonConfig r100) {
        Application r101 = Env.getApplication();
        if (r100 == null) goto L6;
        String r102 = r100.getBizName();
        if (r102 == null) goto L6;
    L8:
        return StorageUtils.composeStoragePath(r101, ChameleonResConstants.WEBCONAINER_ROOT_DIR, r102, Storage.Type.INNER_FILES, new String[]{ASSET_FOLDER});
    L6:
        r102 = "";
        goto L8
    }

    private final File getAssetFilePath(ChameleonConfig r100, Context r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(getLocalAssetPath(r100), getLocalAssetFileName(r100, r101));
        File r103 = r102.getParentFile();
        boolean r104 = false;
        if (r103 != null) goto L5;
    L7:
        if (r104 == true) goto L11;
        File r105 = r102.getParentFile();
        if (r105 == null) goto L11;
        r105.mkdirs();
    L11:
        return r102;
    L5:
        if (r103.exists() != true) goto L7;
        r104 = true;
        goto L7
    }

    private final String getLocalAssetFileName(ChameleonConfig r100, Context r101) {
        StringBuilder r102 = new StringBuilder(PackageUtils.getAppVersionName(r101));
        r102.append("-");
        if (r100 == null) goto L8;
        ResConfig r103 = r100.getResConfig();
        if (r103 == null) goto L8;
        String r104 = r103.getOfflineZipName();
        if (r104 == null) goto L8;
    L9:
        r102.append(r104);
        return r102.toString();
    L8:
        r104 = "";
        goto L9
    }

    public final ChameleonResInfo getResInfo(ChameleonConfig r110, Context r111) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = null;
        if (r110 == null) goto L59;
        String r101 = r110.getBizName();
        if (r101 == null) goto L59;
        String r102 = ThreadMethodProxy.currentThread().getName();
        if (r110.getResConfig() != null) goto L10;
        Log.i(TAG, "getResInfo, chameleonConfig resConfig is null, return");
        return new ChameleonResInfo(null, null, 3, null);
    L10:
        ChameleonAssertResManager r103 = INSTANCE;
        File r112 = r103.getAssetFilePath(r110, r111);
        if (r112.exists() == false) goto L18;
        ChameleonResInfo r104 = localChameleonResInfoMap.get(r110.getBizName());
        if (r104 == null) goto L15;
        r100 = r104.getVersion();
    L15:
        if (r100 != null) goto L63;
        ChameleonResInfo r105 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r110, r112.getAbsolutePath());
        localChameleonResInfoMap.put(r101, r105);
        return r105;
    L63:
        return r104;
    L18:
        Log.i(TAG, "getResInfo: appId is " + r101 + " local asset not exist,begin copy thread:" + r102);
        monitor-enter(ChameleonAssertResManager.class);
    L55:
        th = move-exception;
        throw th;
    L21:
        if (r112.exists() == false) goto L31;
        ChameleonResInfo r106 = localChameleonResInfoMap.get(r110.getBizName());     // Catch: Throwable -> L55
        if (r106 == null) goto L25;
        r100 = r106.getVersion();     // Catch: Throwable -> L55
    L25:
        if (r100 != null) goto L29;
        r106 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r110, r112.getAbsolutePath());     // Catch: Throwable -> L55
        if (r106 == null) goto L29;
        localChameleonResInfoMap.put(r101, r106);     // Catch: Throwable -> L55
    L29:
        monitor-exit(ChameleonAssertResManager.class);
        return r106;
    L31:
        String r107 = r103.getLocalAssetPath(r110);     // Catch: Throwable -> L55
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L55
        r113.append(System.currentTimeMillis());     // Catch: Throwable -> L55
        ResConfig r114 = r110.getResConfig();     // Catch: Throwable -> L55
        if (r114 == null) goto L34;
        String r115 = r114.getOfflineZipName();     // Catch: Throwable -> L55
    L35:
        r113.append(r115);     // Catch: Throwable -> L55
        PolarisFileWrapper r116 = new PolarisFileWrapper(r107, r113.toString());     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: clean directory thread:" + r102);     // Catch: IOException -> L38 Throwable -> L55
        FileUtils.cleanDirectory(r116.getParentFile());     // Catch: IOException -> L38 Throwable -> L55
    L40:
        ResConfig r108 = r110.getResConfig();     // Catch: Throwable -> L55
        if (r108 == null) goto L44;
        String r109 = r108.getOfflineZipName();     // Catch: Throwable -> L55
        if (r109 == null) goto L44;
    L46:
        if (FileUtils.copyAssets(r111, r109, r116.getAbsolutePath()) == true) goto L48;
    L52:
        r116.deleteOnExit();     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: asset copy to local fails thread:" + r102);     // Catch: Throwable -> L55
        ChameleonResInfo r117 = new ChameleonResInfo(null, null, 3, null);     // Catch: Throwable -> L55
        monitor-exit(ChameleonAssertResManager.class);
        return r117;
    L48:
        if (r116.exists() == false) goto L52;
        r116.renameTo(r112);     // Catch: Throwable -> L55
        Log.i(TAG, "getResInfo: rename to :" + r112.getAbsolutePath() + " thread:" + r102);     // Catch: Throwable -> L55
        ChameleonResInfo r118 = ChameleonResUtils.INSTANCE.getResInfoOf7z(r110, r112.getAbsolutePath());     // Catch: Throwable -> L55
        localChameleonResInfoMap.put(r101, r118);     // Catch: Throwable -> L55
        monitor-exit(ChameleonAssertResManager.class);
        return r118;
    L44:
        r109 = "";
        goto L46
    L38:
        e = move-exception;
        Log.e(TAG, r102 + " => getResInfo: clean directory fails : " + e);     // Catch: Throwable -> L55
        goto L40
    L34:
        r115 = null;
    L59:
        return new ChameleonResInfo(null, null, 3, null);
    }

    public final boolean extractSimAssetToLocal(ChameleonConfig r100, Context r101, File r102) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "destFile");
        Log.i(TAG, "extractSimAssetToLocal: begin extract local assets");
        if (LzmaUtils.extract7z(getAssetFilePath(r100, r101).getAbsolutePath(), r102.getAbsolutePath()) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
