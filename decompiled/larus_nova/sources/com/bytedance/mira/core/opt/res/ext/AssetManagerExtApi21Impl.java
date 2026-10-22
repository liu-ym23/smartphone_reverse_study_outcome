package com.bytedance.mira.core.opt.res.ext;

import android.content.res.AssetManager;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.OSUtil;
import com.bytedance.mira.util.ReflectUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public class AssetManagerExtApi21Impl extends AssetManagerExtImpl {
    private static final String TAG = "AssetManagerExtApi21Impl";
    private static final Method sAddAssetPathMethod = null;
    private static final Method sAddAssetPathNativeMethod = null;
    private static final Method sGetNativeStringBlock = null;
    private static final Method sGetStringBlockCountMethod = null;
    private static final Method sMakeStringBlocksMethod = null;
    private static final Class sStringBlockClazz = null;
    private static final Constructor<?> sStringBlockConstructor = null;
    private static final Field sStringBlocksField = null;

    static {
        sAddAssetPathMethod = ReflectUtils.findDeclaredMethod(AssetManager.class, "addAssetPath", new Class[]{String.class});
        sStringBlocksField = ReflectUtils.findDeclaredField(AssetManager.class, "mStringBlocks");
        sGetStringBlockCountMethod = ReflectUtils.findDeclaredMethod(AssetManager.class, "getStringBlockCount", new Class[0]);
        sGetNativeStringBlock = ReflectUtils.findDeclaredMethod(AssetManager.class, "getNativeStringBlock", new Class[]{Integer.TYPE});
        Class<?> r100 = null;
        Method r101 = ReflectUtils.findDeclaredMethod(AssetManager.class, "makeStringBlocks", new Class[]{Class.forName("[Landroid.content.res.StringBlock;")});     // Catch: Throwable -> L5
    L6:
        sMakeStringBlocksMethod = r101;
        if (OSUtil.isAndroidLM() == false) goto L10;
        Method r102 = ReflectUtils.findDeclaredMethod(AssetManager.class, "addAssetPathNative", new Class[]{String.class});
    L13:
        sAddAssetPathNativeMethod = r102;
        Class<?> r103 = Class.forName("android.content.res.StringBlock");     // Catch: Throwable -> L16
        Constructor<?> r104 = ReflectUtils.findDeclaredConstructor(r103, new Class[]{Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L16
        r100 = r103;
    L17:
        sStringBlockClazz = r100;
        sStringBlockConstructor = r104;
        return;
    L16:
        r104 = null;
        goto L17
    L10:
        if (OSUtil.isAndroidNMR1() == false) goto L12;
        r102 = ReflectUtils.findDeclaredMethod(AssetManager.class, "addAssetPathNative", new Class[]{String.class, Boolean.TYPE});
        goto L13
    L12:
        r102 = null;
    L5:
        r101 = null;
        goto L6
    }

    public AssetManagerExtApi21Impl() {
    }

    private boolean makeStringBlocks(AssetManager r110) {
        if (r110 != null) goto L6;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> makeStringBlocks err, manager is null. manager=" + r110, null);
        return false;
    L6:
        Field r100 = sStringBlocksField;
        if (r100 == null) goto L33;
        Method r101 = sGetStringBlockCountMethod;
        if (r101 == null) goto L33;
        Class r102 = sStringBlockClazz;
        if (r102 == null) goto L33;
        if (sGetNativeStringBlock == null) goto L33;
        if (sStringBlockConstructor == null) goto L33;
        Object r103 = r100.get(r110);     // Catch: Throwable -> L30
        if (r103 == null) goto L20;
        int r104 = Array.getLength(r103);     // Catch: Throwable -> L30
    L21:
        int r105 = ((Integer) r101.invoke(r110, new Object[0])).intValue();     // Catch: Throwable -> L30
        Object r106 = Array.newInstance(r102, r105);     // Catch: Throwable -> L30
        int r107 = 0;
    L23:
        if (r107 >= r105) goto L28;
        if (r107 >= r104) goto L26;
        Array.set(r106, r107, Array.get(r103, r107));     // Catch: Throwable -> L30
    L27:
        r107 = r107 + 1;     // Catch: Throwable -> L30
        goto L23
    L26:
        Array.set(r106, r107, sStringBlockConstructor.newInstance(new Object[]{Long.valueOf(((Long) sGetNativeStringBlock.invoke(r110, new Object[]{Integer.valueOf(r107)})).longValue()), Boolean.TRUE}));     // Catch: Throwable -> L30
        goto L27
    L28:
        sStringBlocksField.set(r110, r106);     // Catch: Throwable -> L30
        return true;
    L20:
        r104 = 0;
    L30:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> makeStringBlocks err, real invoke addAssetsPath err.", th);
        return false;
    L33:
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> makeStringBlocks err, method or field is null.  sStringBlocksField=" + r100 + ", sGetStringBlockCountMethod=" + sGetStringBlockCountMethod + ", sStringBlockClazz=" + sStringBlockClazz + ", sGetNativeStringBlock=" + sGetNativeStringBlock + ", sStringBlockConstructor=" + sStringBlockConstructor, null);
        return false;
    }

    private boolean addAssetPathByJava(AssetManager r100, String r101) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L25;
        Method r102 = sAddAssetPathMethod;
        if (r102 != null) goto L28;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, method or field is null. sAddAssetPathMethod=" + r102, null);
        return false;
    L28:
        monitor-enter(r100);     // Catch: Throwable -> L22
        int r103 = ((Integer) r102.invoke(r100, new Object[]{r101})).intValue();     // Catch: Throwable -> L19
        if (r103 > 0) goto L17;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, real invoke addAssetsPath err. , manager=" + r100 + ", cookie=" + r103, null);     // Catch: Throwable -> L19
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
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, real invoke addAssetsPath err.", th);
        return false;
    L25:
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, manager or path is null. manager=" + r100 + ", path=" + r101, null);
        return false;
    }

    private boolean addAssetPathByNative(AssetManager r100, String r101) {
        if (r100 == null) goto L34;
        if (r101 == null) goto L34;
        Method r102 = sAddAssetPathNativeMethod;
        if (r102 != null) goto L37;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, method or field is null.  sAddAssetPathNativeMethod=" + r102, null);
        return false;
    L37:
        monitor-enter(r100);     // Catch: Throwable -> L31
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L12:
        if (OSUtil.isAndroidLM() == false) goto L15;
        int r103 = ((Integer) r102.invoke(r100, new Object[]{r101})).intValue();     // Catch: Throwable -> L28
    L18:
        if (r103 > 0) goto L23;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathNative err, real invoke addAssetsPath err. , manager=" + r100 + ", cookie=" + r103, null);     // Catch: Throwable -> L28
        monitor-exit(r100);     // Catch: Throwable -> L28
        return false;
    L23:
        if (makeStringBlocks(r100) == true) goto L26;
        monitor-exit(r100);     // Catch: Throwable -> L28
        return false;
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L28
        return true;
    L15:
        if (OSUtil.isAndroidNMR1() == false) goto L17;
        r103 = ((Integer) r102.invoke(r100, new Object[]{r101, Boolean.FALSE})).intValue();     // Catch: Throwable -> L28
        goto L18
    L17:
        r103 = 0;
    L31:
        th = move-exception;
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathNative err, real invoke addAssetsPath err.", th);
        return false;
    L34:
        MiraLogger.e(MiraLogger.TAG_RES, "AssetManagerExtApi21Impl >>> addAssetPathWith err, manager or path is null. manager=" + r100 + ", path=" + r101, null);
        return false;
    }

    @Override // com.bytedance.mira.core.opt.res.ext.IAssetManagerExt
    public boolean addAssetPath(AssetManager r100, String r101) {
        if (addAssetPathByNative(r100, r101) == false) goto L5;
    L8:
        return true;
    L5:
        if (addAssetPathByJava(r100, r101) == true) goto L8;
        return false;
    }
}
