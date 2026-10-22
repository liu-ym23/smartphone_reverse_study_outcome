package com.vivo.push.util;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f462588a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f462589b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f462590c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f462591d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f462592e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f462593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f462594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f462595h;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        f462588a = ah.b("ro.vivo.product.overseas", BdpAppEventConstant.NO).equals(BdpAppEventConstant.YES);
        f462589b = b("rom_1.0");
        f462590c = b("rom_2.0");
        f462591d = b("rom_2.5");
        f462592e = b("rom_3.0");
        f462594g = null;
        f462595h = null;
    }

    public static synchronized String a() {
        monitor-enter(m.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f462594g == null) goto L7;
    L11:
        t.d("Device", "sRomProperty1 : " + f462594g + " ; sRomProperty2 : " + f462595h);     // Catch: Throwable -> L21
        String r100 = a(f462594g);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r100) == true) goto L15;
        monitor-exit(m.class);
        return r100;
    L15:
        String r101 = a(f462595h);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r101) == true) goto L19;
        monitor-exit(m.class);
        return r101;
    L19:
        monitor-exit(m.class);
        return null;
    L7:
        if (f462595h != null) goto L11;
        Method r102 = INVOKESTATIC_com_vivo_push_util_m_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class});     // Catch: Exception -> L10 Throwable -> L21
        f462593f = r102;     // Catch: Exception -> L10 Throwable -> L21
        r102.setAccessible(true);     // Catch: Exception -> L10 Throwable -> L21
        f462594g = (String) f462593f.invoke(null, new Object[]{"ro.vivo.rom", "@><@"});     // Catch: Exception -> L10 Throwable -> L21
        f462595h = (String) f462593f.invoke(null, new Object[]{"ro.vivo.rom.version", "@><@"});     // Catch: Exception -> L10 Throwable -> L21
    L10:
        t.b("Device", "getRomCode error");     // Catch: Throwable -> L21
        goto L11
    }

    public static boolean b() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        t.d("Device", "Build.MANUFACTURER is null");
        return false;
    L6:
        t.d("Device", "Build.MANUFACTURER is " + r100);
        if (r100.toLowerCase().contains("bbk") == false) goto L9;
        return true;
    L9:
        if (r100.toLowerCase().startsWith(DimLocationCheckUtil.VIVO) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vivo_push_util_m_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Matcher r101 = PatternProtector.compile("rom_([\\d]*).?([\\d]*)", 2).matcher(r100);
        if (r101.find() == false) goto L13;
        StringBuilder r102 = new StringBuilder();
        r102.append(r101.group(1));
        if (TextUtils.isEmpty(r101.group(2)) == false) goto L10;
        String r103 = "0";
    L11:
        r102.append(r103);
        return r102.toString();
    L10:
        r103 = r101.group(2).substring(0, 1);
        goto L11
    L13:
        return null;
    }

    private static boolean b(String r100) {
        String r101 = ah.b("ro.vivo.rom", "");
        String r102 = ah.b("ro.vivo.rom.version", "");
        t.d("Device", "ro.vivo.rom = " + r101 + " ; ro.vivo.rom.version = " + r102);
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.contains(r100) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L6;
        return true;
    }

    public static String a(String r100, String r101) {
        String r102 = (String) INVOKESTATIC_com_vivo_push_util_m_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L4
    L6:
        if (r102 != null) goto L8;
        return r101;
    L8:
        if (r102.length() != 0) goto L11;
        return r101;
    L11:
        return r102;
    L4:
        e = move-exception;
        e.printStackTrace();
        r102 = r101;
        goto L6
    }
}
