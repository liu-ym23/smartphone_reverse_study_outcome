package com.bytedance.mira.plugin.core.func.soloader.impl;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import com.bytedance.mira.plugin.core.func.soloader.elf.ElfParser;
import com.bytedance.mira.plugin.core.func.soloader.utils.LogUtils;
import com.bytedance.mira.plugin.core.func.soloader.utils.SoLoaderUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class BaseSoLoaderImpl implements ISoLoaderImpl {
    private SoLoader.Config mConfig;
    private Method mGetLdLibraryPathMethod;

    public BaseSoLoaderImpl() {
    }

    private void closeQuietly(Closeable r1) {
        if (r1 != null) goto L7;
        return;
    L7:
        r1.close();     // Catch: IOException -> L6
        return;
    }

    private List<String> obtainDependencies(File r3) throws IOException {
        Closeable r0 = null;
        Closeable r1 = new ElfParser(r3);     // Catch: Throwable -> L9
        List<String> r4 = r1.parseNeededDependencies();     // Catch: Throwable -> L7
        Collections.sort(r4);     // Catch: Throwable -> L7
        closeQuietly(r1);
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        closeQuietly(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnSystemLoadOrLoadLibrary(String r18) throws Throwable {
        if (this.mConfig != null) goto L5;
        return false;
    L5:
        String r4 = SoLoaderUtils.getFileName(r18);
        String r5 = this.mConfig.getPkgFromSoName(r4);
        Throwable r7 = null;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 60000, null);
        if (TextUtils.isEmpty(r5) == false) goto L10;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63004, null);
        LogUtils.e(SoLoader.TAG, " get pkg from so name fail,so name=" + r4);
        return false;
    L10:
        if (this.mConfig.getAction().checkPluginReady(r4) == true) goto L13;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63003, null);
        LogUtils.e(SoLoader.TAG, " check plugin ready fail,so name=" + r4);
        return false;
    L13:
        ClassLoader r0 = this.mConfig.getClassLoader(r5);
        if ((r0 instanceof BaseDexClassLoader) == true) goto L17;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63005, null);
        LogUtils.e(SoLoader.TAG, " get classloader from pkg fail,so name=" + r4 + "; pkg=" + r5 + "; classloader=" + r0);
        return false;
    L17:
        BaseDexClassLoader r8 = (BaseDexClassLoader) r0;
        if (r4.startsWith("lib") == true) goto L20;
    L22:
        String r9 = r4;
    L23:
        String r10 = r8.findLibrary(r9);
        if (TextUtils.equals(r10, r18) == true) goto L27;
        LogUtils.e(SoLoader.TAG, "origin path=" + r18 + " >>> real path=" + r10);
    L27:
        if (TextUtils.isEmpty(r10) == false) goto L71;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63006, null);
        Throwable r3 = null;
    L29:
        boolean r1 = false;
    L38:
        if (r1 == false) goto L41;
        return true;
    L41:
        boolean r2 = this.mConfig.getExtraAction().extraWithProcessAndThreadLock(r5, r4);
        LogUtils.e(SoLoader.TAG, "origin path=" + r18 + " >>> real path=" + r10 + " >>> extraResult=" + r2);
        if (r2 == true) goto L48;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63007, null);
        if (r3 != null) goto L47;
        return false;
    L47:
        throw r3;
    L48:
        String r6 = r8.findLibrary(r9);
        if (TextUtils.equals(r6, r18) == true) goto L52;
        LogUtils.e(SoLoader.TAG, "extra after, origin path=" + r18 + " >>> real path=" + r6);
    L52:
        if (TextUtils.isEmpty(r6) == false) goto L55;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63008, null);
        return false;
    L55:
        Iterator<String> r11 = obtainDependencies(new PolarisFileWrapper(r6)).iterator();
    L57:
        if (r11.hasNext() == false) goto L73;
        callOnSystemLoadOrLoadLibrary(r11.next());
        goto L57
    L73:
        boolean r12 = nativeLoad(r6, r8, getLdLibraryPath(r8));     // Catch: Throwable -> L66
        SoLoader.StateManagerWrapper r13 = this.mConfig.getStateWrapper();     // Catch: Throwable -> L66
        if (r12 == false) goto L63;
        int r14 = 62000;
    L64:
        r13.dispatchStateChange(r4, r5, r14, null);     // Catch: Throwable -> L66
        boolean r15 = r12;
    L68:
        if (r7 != null) goto L70;
        return r15;
    L70:
        throw r7;
    L63:
        r14 = 63002;
    L66:
        th = move-exception;
        r7 = th;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63002, r7);
        LogUtils.e(SoLoader.TAG, "load fail, real path=" + r6 + ", err info=" + Log.getStackTraceString(r7));
        r15 = false;
        goto L68
    L71:
        r1 = nativeLoad(r10, r8, getLdLibraryPath(r8));     // Catch: Throwable -> L36
        SoLoader.StateManagerWrapper r16 = this.mConfig.getStateWrapper();     // Catch: Throwable -> L36
        if (r1 == false) goto L33;
        int r17 = 61000;
    L34:
        r16.dispatchStateChange(r4, r5, r17, null);     // Catch: Throwable -> L36
        r3 = null;
        goto L38
    L33:
        r17 = 63001;
    L36:
        th = move-exception;
        this.mConfig.getStateWrapper().dispatchStateChange(r4, r5, 63001, th);
        LogUtils.e(SoLoader.TAG, "load fail, real path=" + r10 + ", err info=" + Log.getStackTraceString(th));
        r3 = th;
        goto L29
    L20:
        if (r4.endsWith(".so") == false) goto L22;
        r9 = r4.substring(3, r4.lastIndexOf(".so"));
        goto L23
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean checkPluginLinkedByPkg(String r2) {
        SoLoader.Config r0 = this.mConfig;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getAction().checkPluginLinked(r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public String getLdLibraryPath(Object r3) {
        return (String) this.mGetLdLibraryPathMethod.invoke(r3, new Object[0]);
    L4:
        return null;
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public List<String> getSoListByPkg(String r2) {
        SoLoader.Config r0 = this.mConfig;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getSoListByPkg(r2);
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public String getSoListStrByPkg(String r4) {
        List<String> r5 = getSoListByPkg(r4);
        if (r5 != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r6 = r5.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        String r1 = r6.next();
        if (r0.length() <= 0) goto L12;
        r0.append(":");
    L12:
        r0.append(r1);
        goto L8
    L14:
        return r0.toString();
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean init(SoLoader.Config r6) throws Throwable {
        Method r2 = BaseDexClassLoader.class.getDeclaredMethod("getLdLibraryPath", new Class[0]);     // Catch: Throwable -> L5
        this.mGetLdLibraryPathMethod = r2;     // Catch: Throwable -> L5
        r2.setAccessible(true);     // Catch: Throwable -> L5
    L13:
        System.loadLibrary("soloader");     // Catch: Throwable -> L10
        this.mConfig = r6;
        return true;
    L10:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, "init soloader so error:\n" + Log.getStackTraceString(th));
        throw th;
    L5:
        th = move-exception;
        LogUtils.e(SoLoader.TAG, "init getLdLibraryPath method error:\n" + Log.getStackTraceString(th));
        goto L13
    }
}
