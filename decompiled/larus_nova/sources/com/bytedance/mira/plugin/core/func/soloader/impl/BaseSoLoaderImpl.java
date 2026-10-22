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

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseSoLoaderImpl implements ISoLoaderImpl {
    private SoLoader.Config mConfig;
    private Method mGetLdLibraryPathMethod;

    public BaseSoLoaderImpl() {
    }

    private void closeQuietly(Closeable r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    private List<String> obtainDependencies(File r100) throws IOException {
        Closeable r101 = null;
        ElfParser r102 = new ElfParser(r100);     // Catch: Throwable -> L9
        List<String> r103 = r102.parseNeededDependencies();     // Catch: Throwable -> L7
        Collections.sort(r103);     // Catch: Throwable -> L7
        closeQuietly(r102);
        return r103;
    L7:
        th = th;
        r101 = r102;
    L10:
        closeQuietly(r101);
        throw th;
    L9:
        th = th;
        goto L10
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean callOnSystemLoadOrLoadLibrary(String r110) throws Throwable {
        if (this.mConfig != null) goto L5;
        return false;
    L5:
        String r100 = SoLoaderUtils.getFileName(r110);
        String r101 = this.mConfig.getPkgFromSoName(r100);
        Throwable r102 = null;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, 60000, null);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_PKG_NOT_READY, null);
        LogUtils.e(SoLoader.TAG, " get pkg from so name fail,so name=" + r100);
        return false;
    L10:
        if (this.mConfig.getAction().checkPluginReady(r100) == true) goto L13;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_NOT_READY, null);
        LogUtils.e(SoLoader.TAG, " check plugin ready fail,so name=" + r100);
        return false;
    L13:
        ClassLoader r103 = this.mConfig.getClassLoader(r101);
        if ((r103 instanceof BaseDexClassLoader) == true) goto L17;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_CLASSLOADER_NOT_MATCH, null);
        LogUtils.e(SoLoader.TAG, " get classloader from pkg fail,so name=" + r100 + "; pkg=" + r101 + "; classloader=" + r103);
        return false;
    L17:
        BaseDexClassLoader r104 = (BaseDexClassLoader) r103;
        if (r100.startsWith("lib") == true) goto L20;
    L22:
        String r105 = r100;
    L23:
        String r111 = r104.findLibrary(r105);
        if (TextUtils.equals(r111, r110) == true) goto L27;
        LogUtils.e(SoLoader.TAG, "origin path=" + r110 + " >>> real path=" + r111);
    L27:
        if (TextUtils.isEmpty(r111) == false) goto L71;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_REAL_PATH_NOT_READY, null);
        Throwable r106 = null;
    L29:
        boolean r107 = false;
    L38:
        if (r107 == false) goto L41;
        return true;
    L41:
        boolean r108 = this.mConfig.getExtraAction().extraWithProcessAndThreadLock(r101, r100);
        LogUtils.e(SoLoader.TAG, "origin path=" + r110 + " >>> real path=" + r111 + " >>> extraResult=" + r108);
        if (r108 == true) goto L48;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_EXTRA_NOT_READY, null);
        if (r106 != null) goto L47;
        return false;
    L47:
        throw r106;
    L48:
        String r109 = r104.findLibrary(r105);
        if (TextUtils.equals(r109, r110) == true) goto L52;
        LogUtils.e(SoLoader.TAG, "extra after, origin path=" + r110 + " >>> real path=" + r109);
    L52:
        if (TextUtils.isEmpty(r109) == false) goto L55;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_PLUGIN_REAL_PATH_NOT_READY_AGAIN, null);
        return false;
    L55:
        Iterator<String> r112 = obtainDependencies(new PolarisFileWrapper(r109)).iterator();
    L57:
        if (r112.hasNext() == false) goto L73;
        callOnSystemLoadOrLoadLibrary(r112.next());
        goto L57
    L73:
        boolean r113 = nativeLoad(r109, r104, getLdLibraryPath(r104));     // Catch: Throwable -> L66
        SoLoader.StateManagerWrapper r114 = this.mConfig.getStateWrapper();     // Catch: Throwable -> L66
        if (r113 == false) goto L63;
        int r115 = SoLoader.IStateListener.SO_LOAD_SUCCESS_AGAIN;
    L64:
        r114.dispatchStateChange(r100, r101, r115, null);     // Catch: Throwable -> L66
        boolean r116 = r113;
    L68:
        if (r102 != null) goto L70;
        return r116;
    L70:
        throw r102;
    L63:
        r115 = SoLoader.IStateListener.SO_LOAD_FAIL_AGAIN;
    L66:
        th = move-exception;
        r102 = th;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL_AGAIN, r102);
        LogUtils.e(SoLoader.TAG, "load fail, real path=" + r109 + ", err info=" + Log.getStackTraceString(r102));
        r116 = false;
        goto L68
    L71:
        r107 = nativeLoad(r111, r104, getLdLibraryPath(r104));     // Catch: Throwable -> L36
        SoLoader.StateManagerWrapper r117 = this.mConfig.getStateWrapper();     // Catch: Throwable -> L36
        if (r107 == false) goto L33;
        int r118 = SoLoader.IStateListener.SO_LOAD_SUCCESS;
    L34:
        r117.dispatchStateChange(r100, r101, r118, null);     // Catch: Throwable -> L36
        r106 = null;
        goto L38
    L33:
        r118 = SoLoader.IStateListener.SO_LOAD_FAIL;
    L36:
        th = move-exception;
        this.mConfig.getStateWrapper().dispatchStateChange(r100, r101, SoLoader.IStateListener.SO_LOAD_FAIL, th);
        LogUtils.e(SoLoader.TAG, "load fail, real path=" + r111 + ", err info=" + Log.getStackTraceString(th));
        r106 = th;
        goto L29
    L20:
        if (r100.endsWith(".so") == false) goto L22;
        r105 = r100.substring(3, r100.lastIndexOf(".so"));
        goto L23
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean checkPluginLinkedByPkg(String r100) {
        SoLoader.Config r101 = this.mConfig;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.getAction().checkPluginLinked(r100) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public String getLdLibraryPath(Object r100) {
        return (String) this.mGetLdLibraryPathMethod.invoke(r100, new Object[0]);
    L4:
        return null;
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public List<String> getSoListByPkg(String r100) {
        SoLoader.Config r101 = this.mConfig;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getSoListByPkg(r100);
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public String getSoListStrByPkg(String r100) {
        List<String> r101 = getSoListByPkg(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        StringBuilder r102 = new StringBuilder();
        Iterator<String> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        String r104 = r103.next();
        if (r102.length() <= 0) goto L12;
        r102.append(":");
    L12:
        r102.append(r104);
        goto L8
    L14:
        return r102.toString();
    }

    @Override // com.bytedance.mira.plugin.core.func.soloader.impl.ISoLoaderImpl
    public boolean init(SoLoader.Config r100) throws Throwable {
        Method r101 = BaseDexClassLoader.class.getDeclaredMethod("getLdLibraryPath", new Class[0]);     // Catch: Throwable -> L5
        this.mGetLdLibraryPathMethod = r101;     // Catch: Throwable -> L5
        r101.setAccessible(true);     // Catch: Throwable -> L5
    L13:
        System.loadLibrary("soloader");     // Catch: Throwable -> L10
        this.mConfig = r100;
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
