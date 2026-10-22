package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.framework.common.EmuiUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f277503a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f277504b;

    public static class a {
        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_com_huawei_hms_hwid_aq$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
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

        public static Class<?> a(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L6;
            return null;
        L6:
            if (EmuiUtil.BUILDEX_VERSION.equals(r100) == false) goto L8;
        L13:
            return INVOKESTATIC_com_huawei_hms_hwid_aq$a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
        L12:
            return null;
        L8:
            if (EmuiUtil.IMMERSION_STYLE.equals(r100) == true) goto L13;
            return null;
        }

        public static Object a(String r100, String r101) {
            Class<?> r102 = a(r100);
            if (r102 != null) goto L5;
            return null;
        L5:
            if (TextUtils.isEmpty(r101) == false) goto L8;
            return null;
        L8:
            if (EmuiUtil.BUILDEX_VERSION.equals(r100) == true) goto L10;
            return null;
        L10:
            if (EmuiUtil.EMUI_SDK_INT.equals(r101) == true) goto L20;
            return null;
        L20:
            Field r103 = r102.getDeclaredField(r101);     // Catch: SecurityException -> L15 NoSuchFieldException -> L16 IllegalArgumentException -> L17 IllegalAccessException -> L18
            AccessibleObject.setAccessible(new Field[]{r103}, true);     // Catch: SecurityException -> L15 NoSuchFieldException -> L16 IllegalArgumentException -> L17 IllegalAccessException -> L18
        L29:
            return r103.get(r102);
        L18:
            as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
            return null;
        L17:
            as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
            return null;
        L16:
            as.c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
            return null;
        L15:
            as.b("ReflectionUtils", "not security int method getStaticFieldObj", true);
            return null;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean a() {
        if (f277504b < 21) goto L5;
        return true;
    L5:
        return false;
    }

    private static void c() {
        Class r100 = INVOKESTATIC_com_huawei_hms_hwid_aq_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L21 RuntimeException -> L22
        String r101 = (String) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{com.alipay.sdk.m.c.a.f25238a});     // Catch: Exception -> L21 RuntimeException -> L22
        if (r101 != null) goto L6;
    L24:
        return;
    L6:
        if (r101.contains("EmotionUI_3.0") == false) goto L9;
        f277503a = 30;     // Catch: Exception -> L21 RuntimeException -> L22
        goto L24
    L9:
        if (r101.contains("EmotionUI_3.1") == false) goto L12;
        f277503a = 31;     // Catch: Exception -> L21 RuntimeException -> L22
        goto L24
    L12:
        if (r101.contains("EmotionUI_4.0") == false) goto L15;
        f277503a = 40;     // Catch: Exception -> L21 RuntimeException -> L22
        goto L24
    L15:
        if (r101.contains("EmotionUI_4.1") == false) goto L18;
        f277503a = 41;     // Catch: Exception -> L21 RuntimeException -> L22
        goto L24
    L18:
        if (r101.contains("EmotionUI_5.0") == false) goto L24;
        f277503a = 50;     // Catch: Exception -> L21 RuntimeException -> L22
    L22:
        as.d("EmuiUtil", "RuntimeException getEmuiType.", true);
        return;
    L21:
        as.d("EmuiUtil", "getEmuiType Exception.", true);
    }

    private static int d() {
        Object r100 = a.a(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (r100 == null) goto L8;
        f277504b = ((Integer) r100).intValue();     // Catch: ClassCastException -> L6
    L6:
        as.d("EmuiUtil", "getEMUIVersionCode is not a number", true);
    L8:
        return f277504b;
    }

    private static void b() {
        int r100 = d();
        f277504b = r100;
        if (r100 < 17) goto L6;
        f277503a = 90;
    L6:
        if (r100 < 11) goto L9;
        f277503a = 50;
    L21:
        if (f277503a != (-1)) goto L24;
        c();
        return;
    L24:
        return;
    L9:
        if (r100 < 10) goto L12;
        f277503a = 41;
        goto L21
    L12:
        if (r100 < 9) goto L15;
        f277503a = 40;
        goto L21
    L15:
        if (r100 < 8) goto L18;
        f277503a = 31;
        goto L21
    L18:
        if (r100 < 7) goto L21;
        f277503a = 30;
        goto L21
    }

    static {
        b();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_hwid_aq_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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
}
