package com.huawei.hms.framework.common;

import android.util.Base64;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.secure.android.common.util.SafeBase64;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class SecurityBase64Utils {
    private static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";
    private static volatile boolean isAegisBase64LibraryLoaded;

    public SecurityBase64Utils() {
    }

    private static boolean checkCompatible(String r100) {
        ClassLoader r101 = SecurityBase64Utils.class.getClassLoader();
        if (r101 != null) goto L15;
        return false;
    L15:
        INVOKEVIRTUAL_com_huawei_hms_framework_common_SecurityBase64Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r101, r100);     // Catch: ClassNotFoundException -> L14
        monitor-enter(SecurityBase64Utils.class);     // Catch: ClassNotFoundException -> L14
        isAegisBase64LibraryLoaded = true;     // Catch: Throwable -> L11
        monitor-exit(SecurityBase64Utils.class);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        throw th;     // Catch: ClassNotFoundException -> L14
    L14:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_huawei_hms_framework_common_SecurityBase64Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r104 = r100.loadClass(r101);     // Catch: Throwable -> L8
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r101);
    L12:
        throw th;
    L34:
        Class<?> r105 = r100.loadClass(r101);     // Catch: Throwable -> L17
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L17
    L16:
        return r105;
    L17:
        th = move-exception;
        if (r103 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r101);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.loadClass(r101);
    }

    public static byte[] decode(String r100, int r101) {
        if (isAegisBase64LibraryLoaded == true) goto L12;
        if (checkCompatible(SAFE_BASE64_PATH) == true) goto L12;
        return Base64.decode(r100, r101);
    L10:
        return new byte[0];
    L12:
        return SafeBase64.decode(r100, r101);
    }

    public static String encodeToString(byte[] r100, int r101) {
        if (isAegisBase64LibraryLoaded == true) goto L12;
        if (checkCompatible(SAFE_BASE64_PATH) == true) goto L12;
        return Base64.encodeToString(r100, r101);
    L9:
        return null;
    L12:
        return SafeBase64.encodeToString(r100, r101);
    }
}
