package com.bytedance.common.utility;

import android.content.Context;
import android.content.pm.Signature;
import android.util.DisplayMetrics;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class SignUtils {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_utility_SignUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private static Signature[] getApkSignaturesCompatible(String r100) {
        Class r101 = INVOKESTATIC_com_bytedance_common_utility_SignUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.content.pm.PackageParser");     // Catch: Throwable -> L5
        Object r102 = r101.newInstance();     // Catch: Throwable -> L5
        new DisplayMetrics().setToDefaults();     // Catch: Throwable -> L5
        Class<?> r103 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r104 = r101.getDeclaredMethod("parsePackage", new Class[]{File.class, r103});     // Catch: Throwable -> L5
        r104.setAccessible(true);     // Catch: Throwable -> L5
        Object r105 = r104.invoke(r102, new Object[]{new PolarisFileWrapper(r100), 64});     // Catch: Throwable -> L5
        r101.getDeclaredMethod("collectCertificates", new Class[]{r105.getClass(), r103}).invoke(r102, new Object[]{r105, 64});     // Catch: Throwable -> L5
        return (Signature[]) r105.getClass().getDeclaredField("mSignatures").get(r105);
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Signature[] getAppSignatures(Context r100) {
        return r100.getPackageManager().getPackageInfo(r100.getPackageName(), 64).signatures;
    L4:
        e = move-exception;
        Logger.w("SignUtils", "failed to get package signatures: " + e);
        return null;
    }

    public static boolean checkSignature(Context r100, String r101) {
        Signature[] r102 = getApkSignatures(r100, r101);
        if (r102 != null) goto L5;
        return true;
    L5:
        Signature[] r103 = getAppSignatures(r100);
        if (r103 != null) goto L8;
        return true;
    L8:
        int r104 = r103.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L17;
        Signature r106 = r103[r105];
        int r107 = r102.length;
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L16;
        if (r106.equals(r102[r108]) == true) goto L14;
        r108 = r108 + 1;
        goto L11
    L14:
        return true;
    L16:
        r105 = r105 + 1;
        goto L9
    L17:
        return false;
    }

    public static Signature[] getApkSignatures(Context r100, String r101) {
        Signature[] r102 = r100.getPackageManager().getPackageArchiveInfo(r101, 64).signatures;     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        return getApkSignaturesCompatible(r101);
    L4:
        e = move-exception;
        Logger.w("SignUtils", "failed to get package signatures: " + e);
        r102 = null;
        goto L6
    }
}
