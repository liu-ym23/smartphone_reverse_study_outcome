package com.bytedance.mira.plugin.core.func.soloader.impl;

import android.util.Log;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SoLoaderV3Impl extends BaseSoLoaderImpl {
    private Method mNativeLoadMethod;
    private Method mNativeLoadV2Method;

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnRegisterClassLoader(ClassLoader r1) {
        return false;
    }

    public SoLoaderV3Impl() {
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.BaseSoLoaderImpl, com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean init(SoLoader.Config r7) throws Throwable {
        super.init(r7);
    L9:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, "init nativeLoad method error:" + Log.getStackTraceString(th));
    L11:
        return true;
    L5:
        if (SoLoader.getAndroidVersion() >= 28) goto L7;
        Method r0 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});     // Catch: Throwable -> L9
        this.mNativeLoadMethod = r0;     // Catch: Throwable -> L9
        r0.setAccessible(true);     // Catch: Throwable -> L9
    L12:
        goto L11
    L7:
        Method r1 = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class});     // Catch: Throwable -> L9
        this.mNativeLoadV2Method = r1;     // Catch: Throwable -> L9
        r1.setAccessible(true);     // Catch: Throwable -> L9
        goto L12
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean nativeLoad(String r11, ClassLoader r12, String r13) throws Throwable {
        boolean r9 = false;
        if (SoLoader.getAndroidVersion() >= 28) goto L19;
        Method r0 = this.mNativeLoadMethod;
        if (r0 != null) goto L35;
        return false;
    L35:
        String r14 = (String) r0.invoke(null, new Object[]{r11, r12, r13});     // Catch: Throwable -> L16
        StringBuilder r15 = new StringBuilder();     // Catch: Throwable -> L16
        r15.append(r11);     // Catch: Throwable -> L16
        r15.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L16
        if (r14 != null) goto L11;
        r9 = true;
    L11:
        r15.append(r9);     // Catch: Throwable -> L16
        r15.append(" >>> info:");     // Catch: Throwable -> L16
        r15.append(r14);     // Catch: Throwable -> L16
        LogUtils.e(SoLoader.TAG, r15.toString());     // Catch: Throwable -> L16
        if (r14 != null) goto L15;
        return true;
    L15:
        throw new UnsatisfiedLinkError(r14);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r11 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    L19:
        Method r16 = this.mNativeLoadV2Method;
        if (r16 != null) goto L33;
        return false;
    L33:
        String r17 = (String) r16.invoke(null, new Object[]{r11, r12});     // Catch: Throwable -> L30
        StringBuilder r18 = new StringBuilder();     // Catch: Throwable -> L30
        r18.append(r11);     // Catch: Throwable -> L30
        r18.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L30
        if (r17 != null) goto L25;
        r9 = true;
    L25:
        r18.append(r9);     // Catch: Throwable -> L30
        r18.append(" >>> info:");     // Catch: Throwable -> L30
        r18.append(r17);     // Catch: Throwable -> L30
        LogUtils.e(SoLoader.TAG, r18.toString());     // Catch: Throwable -> L30
        if (r17 != null) goto L29;
        return true;
    L29:
        throw new UnsatisfiedLinkError(r17);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r11 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    }
}
