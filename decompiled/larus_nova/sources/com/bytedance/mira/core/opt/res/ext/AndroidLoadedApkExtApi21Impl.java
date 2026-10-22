package com.bytedance.mira.core.opt.res.ext;

import android.app.ActivityThread;
import android.app.LoadedApk;
import android.content.res.Resources;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public class AndroidLoadedApkExtApi21Impl extends AndroidLoadedApkExtImpl {
    private static final String TAG = "AndroidRLoadedApkManager";
    private static final Field mOverlayDirsField = null;
    private static final Field mResDirField = null;
    private static final Field mSplitResDirsField = null;

    static {
        mResDirField = ReflectUtils.findDeclaredField(LoadedApk.class, "mResDir");
        mSplitResDirsField = ReflectUtils.findDeclaredField(LoadedApk.class, "mSplitResDirs");
        mOverlayDirsField = ReflectUtils.findDeclaredField(LoadedApk.class, "mOverlayDirs");
    }

    public AndroidLoadedApkExtApi21Impl() {
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt
    public String[] getSplitDirsByLoadedApk(Object r100) {
        if (r100 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidRLoadedApkManager getSplitDirsByLoadedApk method, loadedApk is null, loadedApk=" + r100);
        return null;
    L6:
        Field r101 = mSplitResDirsField;
        if (r101 != null) goto L13;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidRLoadedApkManager getSplitDirsByLoadedApk method, filed or method is null, mSplitResDirsField=" + r101);
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
        if (OSUtil.isAndroidOHigher() == false) goto L9;
        return ((LoadedApk) r100).getResources();
    L9:
        return ((LoadedApk) r100).getResources((ActivityThread) r101);
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAndroidLoadedApkExt
    public boolean injectLoadedApk(Object r100, Object r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        Field r102 = mResDirField;
        if (r102 == null) goto L19;
        Field r103 = mSplitResDirsField;
        if (r103 == null) goto L19;
        Field r104 = mOverlayDirsField;
        if (r104 == null) goto L19;
        r102.set(r101, r102.get(r100));     // Catch: Throwable -> L16
        r103.set(r101, r103.get(r100));     // Catch: Throwable -> L16
        r104.set(r101, r104.get(r100));     // Catch: Throwable -> L16
        return true;
    L16:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidRLoadedApkManager injectLoadedApk method, set value exception", th);
        return false;
    L19:
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidRLoadedApkManager injectLoadedApk method, filed or method is null, mResDirField=" + r102 + " ,mSplitResDirsField=" + mSplitResDirsField + " ,mOverlayDirsField=" + mOverlayDirsField);
        return false;
    L21:
        MiraLogger.e(MiraLogger.TAG_RES, "AndroidRLoadedApkManager injectLoadedApk method, hostLoadedApk or pluginLoadedApk is null, hostLoadedApk=" + r100 + " ,pluginLoadedApk=" + r101);
        return false;
    }
}
