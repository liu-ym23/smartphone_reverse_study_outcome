package com.ss.bduploader.util;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class CustomVerify {
    public static final int CUSTOM_VERFIY_STATUS_IS_EXCEPTION = -99996;
    public static final int CUSTOM_VERFIY_STATUS_IS_GET_METHOD_EXCEPTION = -99995;
    private static Method getVerifyStatusMethod;
    private static boolean hasInited;
    private static Method verifyMethod;
    private static Class<?> verifyResultClass;

    static {
        verifyMethod = INVOKESTATIC_com_ss_bduploader_util_CustomVerify_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.bduploader.util.X509Util").getMethod("verifyServerCertificates", new Class[]{byte[][].class, String.class, String.class});     // Catch: Exception -> L5
        Class<?> r100 = INVOKESTATIC_com_ss_bduploader_util_CustomVerify_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.bduploader.util.AndroidCertVerifyResult");     // Catch: Exception -> L5
        verifyResultClass = r100;     // Catch: Exception -> L5
        getVerifyStatusMethod = r100.getMethod("getStatus", new Class[0]);     // Catch: Exception -> L5
    L7:
        hasInited = true;
        return;
    L5:
        e = move-exception;
        e.getMessage();
        goto L7
    }

    public CustomVerify() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_bduploader_util_CustomVerify_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static int doVerify(byte[][] r100, String r101, String r102) {
        Method r103 = verifyMethod;
        if (r103 != null) goto L5;
        return -99995;
    L5:
        if (verifyResultClass != null) goto L7;
        return -99995;
    L7:
        if (getVerifyStatusMethod == null) goto L19;
        return ((Integer) getVerifyStatusMethod.invoke(r103.invoke(null, new Object[]{r100, r101, r102}), new Object[0])).intValue();
    L11:
        th = move-exception;
        th.printStackTrace();
        th.getMessage();
        return -99996;
    L19:
        return -99995;
    }
}
