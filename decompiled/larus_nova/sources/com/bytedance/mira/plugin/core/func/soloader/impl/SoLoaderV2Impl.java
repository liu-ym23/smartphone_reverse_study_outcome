package com.bytedance.mira.plugin.core.func.soloader.impl;

import android.util.Log;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class SoLoaderV2Impl extends BaseSoLoaderImpl {
    private Method mNativeLoadMethod;

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnRegisterClassLoader(ClassLoader r100) {
        return true;
    }

    public SoLoaderV2Impl() {
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.BaseSoLoaderImpl, com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean init(SoLoader.Config r100) throws Throwable {
        super.init(r100);
        Method r101 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});     // Catch: Throwable -> L5
        this.mNativeLoadMethod = r101;     // Catch: Throwable -> L5
        r101.setAccessible(true);     // Catch: Throwable -> L5
    L7:
        return true;
    L5:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, "init nativeLoad method error:" + Log.getStackTraceString(th));
        goto L7
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean nativeLoad(String r100, ClassLoader r101, String r102) throws Throwable {
        Method r103 = this.mNativeLoadMethod;
        boolean r104 = false;
        if (r103 != null) goto L17;
        return false;
    L17:
        String r105 = (String) r103.invoke(null, new Object[]{r100, r101, r102});     // Catch: Throwable -> L14
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L14
        r106.append(r100);     // Catch: Throwable -> L14
        r106.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L14
        if (r105 != null) goto L9;
        r104 = true;
    L9:
        r106.append(r104);     // Catch: Throwable -> L14
        r106.append(" >>> info:");     // Catch: Throwable -> L14
        r106.append(r105);     // Catch: Throwable -> L14
        LogUtils.e(SoLoader.TAG, r106.toString());     // Catch: Throwable -> L14
        if (r105 != null) goto L13;
        return true;
    L13:
        throw new UnsatisfiedLinkError(r105);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r100 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    }
}
