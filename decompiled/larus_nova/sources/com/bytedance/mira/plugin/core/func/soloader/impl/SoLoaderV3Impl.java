package com.bytedance.mira.plugin.core.func.soloader.impl;

import android.util.Log;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class SoLoaderV3Impl extends BaseSoLoaderImpl {
    private Method mNativeLoadMethod;
    private Method mNativeLoadV2Method;

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnRegisterClassLoader(ClassLoader r100) {
        return false;
    }

    public SoLoaderV3Impl() {
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.BaseSoLoaderImpl, com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean init(SoLoader.Config r100) throws Throwable {
        super.init(r100);
    L9:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, "init nativeLoad method error:" + Log.getStackTraceString(th));
    L11:
        return true;
    L5:
        if (SoLoader.getAndroidVersion() >= 28) goto L7;
        Method r101 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});     // Catch: Throwable -> L9
        this.mNativeLoadMethod = r101;     // Catch: Throwable -> L9
        r101.setAccessible(true);     // Catch: Throwable -> L9
    L12:
        goto L11
    L7:
        Method r102 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class});     // Catch: Throwable -> L9
        this.mNativeLoadV2Method = r102;     // Catch: Throwable -> L9
        r102.setAccessible(true);     // Catch: Throwable -> L9
        goto L12
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean nativeLoad(String r110, ClassLoader r111, String r112) throws Throwable {
        boolean r100 = false;
        if (SoLoader.getAndroidVersion() >= 28) goto L19;
        Method r101 = this.mNativeLoadMethod;
        if (r101 != null) goto L35;
        return false;
    L35:
        String r113 = (String) r101.invoke(null, new Object[]{r110, r111, r112});     // Catch: Throwable -> L16
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L16
        r114.append(r110);     // Catch: Throwable -> L16
        r114.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L16
        if (r113 != null) goto L11;
        r100 = true;
    L11:
        r114.append(r100);     // Catch: Throwable -> L16
        r114.append(" >>> info:");     // Catch: Throwable -> L16
        r114.append(r113);     // Catch: Throwable -> L16
        LogUtils.e(SoLoader.TAG, r114.toString());     // Catch: Throwable -> L16
        if (r113 != null) goto L15;
        return true;
    L15:
        throw new UnsatisfiedLinkError(r113);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r110 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    L19:
        Method r115 = this.mNativeLoadV2Method;
        if (r115 != null) goto L33;
        return false;
    L33:
        String r116 = (String) r115.invoke(null, new Object[]{r110, r111});     // Catch: Throwable -> L30
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L30
        r117.append(r110);     // Catch: Throwable -> L30
        r117.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L30
        if (r116 != null) goto L25;
        r100 = true;
    L25:
        r117.append(r100);     // Catch: Throwable -> L30
        r117.append(" >>> info:");     // Catch: Throwable -> L30
        r117.append(r116);     // Catch: Throwable -> L30
        LogUtils.e(SoLoader.TAG, r117.toString());     // Catch: Throwable -> L30
        if (r116 != null) goto L29;
        return true;
    L29:
        throw new UnsatisfiedLinkError(r116);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r110 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    }
}
