package com.bytedance.mira.core.opt.res.ext;

import android.content.res.AssetManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class AssetManagerExtApi26Impl extends AssetManagerExtImpl {
    private static final String TAG = "AssetManagerExtApi26Impl";
    private static final Method sAddAssetPathMethod = null;

    static {
        sAddAssetPathMethod = ReflectUtils.findDeclaredMethod(AssetManager.class, "addAssetPath", new Class[]{String.class});
    }

    public AssetManagerExtApi26Impl() {
    }

    private boolean addAssetPathByJava(AssetManager r100, String r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        Method r102 = sAddAssetPathMethod;
        if (r102 != null) goto L28;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi26Impl >>> addAssetPathWith err, method or field is null. sAddAssetPathMethod=" + r102, null);
        return false;
    L28:
        monitor-enter(r100);     // Catch: Throwable -> L22
        int r103 = ((Integer) r102.invoke(r100, new Object[]{r101})).intValue();     // Catch: Throwable -> L19
        if (r103 > 0) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi26Impl >>> addAssetPathWith err, real invoke addAssetsPath err. cookie=" + r103, null);     // Catch: Throwable -> L19
        monitor-exit(r100);     // Catch: Throwable -> L19
        return false;
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return true;
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi26Impl >>> addAssetPathWith err, real invoke addAssetsPath err.", th);
        return false;
    L25:
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi26Impl >>> addAssetPathWith err, manager or path is null. manager=" + r100 + ", path=" + r101, null);
        return false;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAssetManagerExt
    public boolean addAssetPath(AssetManager r100, String r101) {
        return addAssetPathByJava(r100, r101);
    }
}
