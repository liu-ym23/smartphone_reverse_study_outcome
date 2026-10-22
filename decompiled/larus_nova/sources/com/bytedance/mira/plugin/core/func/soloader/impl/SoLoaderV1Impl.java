package com.bytedance.mira.plugin.core.func.soloader.impl;

import android.util.Log;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes21.dex */
public class SoLoaderV1Impl extends BaseSoLoaderImpl {
    private final List<String> mAllLdPaths;
    private Method mNativeLoadMethod;
    private final Lock readLock;
    private final ReentrantReadWriteLock rwl;
    private final Lock writeLock;

    private String buildAllLdLibraryPath() {
        this.readLock.lock();     // Catch: Throwable -> L12
        StringBuilder r100 = new StringBuilder();     // Catch: Throwable -> L12
        Iterator<String> r101 = this.mAllLdPaths.iterator();     // Catch: Throwable -> L12
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();     // Catch: Throwable -> L12
        if (r100.length() <= 0) goto L8;
        r100.append(":");     // Catch: Throwable -> L12
    L8:
        r100.append(r102);     // Catch: Throwable -> L12
        goto L4
    L9:
        String r103 = r100.toString();     // Catch: Throwable -> L12
        this.readLock.unlock();
        return r103;
    L12:
        this.readLock.unlock();
        return null;
    }

    public SoLoaderV1Impl() {
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        this.rwl = r100;
        this.readLock = r100.readLock();
        this.writeLock = r100.writeLock();
        this.mAllLdPaths = new ArrayList();
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnRegisterClassLoader(ClassLoader r100) {
        this.writeLock.lock();     // Catch: Throwable -> L5
        String[] r101 = getLdLibraryPath(r100).split(":");     // Catch: Throwable -> L5
        this.mAllLdPaths.addAll(Arrays.asList(r101));     // Catch: Throwable -> L5
    L3:
        this.writeLock.unlock();
        return true;
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
    public boolean nativeLoad(String r100, ClassLoader r110, String r111) throws Throwable {
        Method r101 = this.mNativeLoadMethod;
        boolean r102 = false;
        if (r101 != null) goto L17;
        return false;
    L17:
        String r112 = (String) r101.invoke(null, new Object[]{r100, r110, buildAllLdLibraryPath()});     // Catch: Throwable -> L14
        LogUtils.e(SoLoader.TAG, "params ld path =" + r111);     // Catch: Throwable -> L14
        LogUtils.e(SoLoader.TAG, "all ld path =" + buildAllLdLibraryPath());     // Catch: Throwable -> L14
        StringBuilder r113 = new StringBuilder();     // Catch: Throwable -> L14
        r113.append(r100);     // Catch: Throwable -> L14
        r113.append(" >>> invoke nativeLoad method result:");     // Catch: Throwable -> L14
        if (r112 != null) goto L9;
        r102 = true;
    L9:
        r113.append(r102);     // Catch: Throwable -> L14
        r113.append(" >>> info:");     // Catch: Throwable -> L14
        r113.append(r112);     // Catch: Throwable -> L14
        LogUtils.e(SoLoader.TAG, r113.toString());     // Catch: Throwable -> L14
        if (r112 != null) goto L13;
        return true;
    L13:
        throw new UnsatisfiedLinkError(r112);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, r100 + " >>> invoke nativeLoad method error:" + Log.getStackTraceString(th));
        throw th;
    }
}
