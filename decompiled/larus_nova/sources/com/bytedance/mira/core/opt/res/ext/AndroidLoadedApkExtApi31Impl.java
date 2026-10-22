package com.bytedance.mira.core.opt.res.ext;

import android.app.LoadedApk;
import android.content.res.Resources;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidLoadedApkExtApi31Impl extends AndroidLoadedApkExtImpl {
    private static final String TAG = "AndroidLoadedApkManager";
    private static final Field mLegacyOverlayDirsField = null;
    private static final Field mOverlayPathsField = null;
    private static final Field mResDirField = null;
    private static final Field mSplitResDirsField = null;

    static {
        mResDirField = ReflectUtils.findDeclaredField(LoadedApk.class, "mResDir");
        mSplitResDirsField = ReflectUtils.findDeclaredField(LoadedApk.class, "mSplitResDirs");
        mLegacyOverlayDirsField = ReflectUtils.findDeclaredField(LoadedApk.class, "mLegacyOverlayDirs");
        mOverlayPathsField = ReflectUtils.findDeclaredField(LoadedApk.class, "mOverlayPaths");
    }

    public AndroidLoadedApkExtApi31Impl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt
    public String[] getSplitDirsByLoadedApk(Object r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidLoadedApkManager getSplitDirsByLoadedApk method, loadedApk is null, loadedApk=" + r100);
        return null;
    L6:
        Field r101 = mSplitResDirsField;
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidLoadedApkManager getSplitDirsByLoadedApk method, filed or method is null, mSplitResDirsField=" + r101);
        return null;
    L13:
        return (String[]) r101.get(r100);
    L12:
        return null;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt
    public Resources buildResources(Object r100, Object r101) {
        if ((r100 instanceof LoadedApk) == true) goto L5;
        return null;
    L5:
        return ((LoadedApk) r100).getResources();
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt
    public boolean injectLoadedApk(Object r100, Object r101) {
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        Field r102 = mResDirField;
        if (r102 == null) goto L21;
        Field r103 = mSplitResDirsField;
        if (r103 == null) goto L21;
        Field r104 = mLegacyOverlayDirsField;
        if (r104 == null) goto L21;
        Field r105 = mOverlayPathsField;
        if (r105 == null) goto L21;
        r102.set(r101, r102.get(r100));     // Catch: Throwable -> L18
        r103.set(r101, r103.get(r100));     // Catch: Throwable -> L18
        r104.set(r101, r104.get(r100));     // Catch: Throwable -> L18
        r105.set(r101, r105.get(r100));     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidLoadedApkManager injectLoadedApk method, set value exception", th);
        return false;
    L21:
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidLoadedApkManager injectLoadedApk method, filed or method is null, mResDirField=" + r102 + " ,mSplitResDirsField=" + mSplitResDirsField + " ,mLegacyOverlayDirsField=" + mLegacyOverlayDirsField + " ,mOverlayPathsField=" + mOverlayPathsField);
        return false;
    L23:
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidLoadedApkManager injectLoadedApk method, hostLoadedApk or pluginLoadedApk is null, hostLoadedApk=" + r100 + " ,pluginLoadedApk=" + r101);
        return false;
    }
}
