package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f464135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f972a;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9308b() {
        return a(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
    L8:
        com.xiaomi.channel.commonutils.logger.b.d("miui.os.Build ClassNotFound");
        return false;
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized String m9305a() {
        monitor-enter(q.class);
        String r100 = f972a;     // Catch: Throwable -> L23
        if (r100 == null) goto L8;
        monitor-exit(q.class);
        return r100;
    L8:
        String r101 = Build.VERSION.INCREMENTAL;     // Catch: Throwable -> L23
        if (a() > 0) goto L20;
        String r102 = b();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == true) goto L13;
    L12:
        r101 = r102;
        goto L20
    L13:
        r102 = c();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r102 = d();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r102) == false) goto L12;
        r101 = String.valueOf(p.a("ro.product.brand", "Android") + "_" + r101);     // Catch: Throwable -> L23
    L20:
        f972a = r101;     // Catch: Throwable -> L23
        monitor-exit(q.class);
        return r101;
    L23:
        th = move-exception;
        throw th;
    }

    private static String c() {
        String r100 = p.a("ro.build.version.opporom", "");
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r100.startsWith("ColorOS_") == true) goto L8;
        f972a = "ColorOS_".concat(r100);
    L8:
        return f972a;
    }

    private static String d() {
        String r100 = p.a("ro.vivo.os.version", "");
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r100.startsWith("FuntouchOS_") == true) goto L8;
        f972a = "FuntouchOS_".concat(r100);
    L8:
        return f972a;
    }

    public static int a() {
        Class<?> r100 = a(null, "miui.os.Build");     // Catch: Exception -> L12
        if (r100.getField("IS_STABLE_VERSION").getBoolean(null) == false) goto L6;
        return 3;
    L6:
        if (r100.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) == false) goto L10;
        return 2;
    L10:
        return 1;
    L12:
        return 0;
    }

    private static String b() {
        String r100 = p.a(com.alipay.sdk.m.c.a.f25238a, "");
        f972a = r100;
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9306a() {
        return TextUtils.equals((String) av.a("android.os.SystemProperties", MonitorConstants.CONNECT_TYPE_GET, new Object[]{"sys.boot_completed"}), "1");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Context m9304a() {
        return f464135a;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_xiaomi_push_q_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9307a(Context r100) {
        if ((r100.getApplicationInfo().flags & 2) == 0) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return false;
    }

    public static void a(Context r100) {
        f464135a = r100.getApplicationContext();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKEVIRTUAL_com_xiaomi_push_q_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(ClassLoader r100, String r101) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r102 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r103 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static Class<?> a(Context r100, String r101) {
        if (r101 == null) goto L20;
        if (r101.trim().length() == 0) goto L20;
        if (r100 == null) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
    L24:
        return INVOKESTATIC_com_xiaomi_push_q_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);
    L16:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a(String.format("loadClass fail hasContext= %s, errMsg = %s", new Object[]{Boolean.valueOf(r102), th.getLocalizedMessage()}));
        throw new ClassNotFoundException("loadClass fail ", th);
    L11:
        if (Build.VERSION.SDK_INT < 29) goto L24;
        return INVOKEVIRTUAL_com_xiaomi_push_q_com_larus_mirabridge_impl_lancet_MiraReflectLancet_loadClass(r100.getClassLoader(), r101);
    L8:
        r102 = false;
    L20:
        throw new ClassNotFoundException("class is empty");
    }
}
