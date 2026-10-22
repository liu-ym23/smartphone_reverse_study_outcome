package com.tencent.connect.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.b.e;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.i;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f461399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Class<?> f461400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f461401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Method f461402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Method f461403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Method f461404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f461405g;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_tencent_connect_a_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean a(Context r100, QQToken r101) {
        return i.a(r100, r101.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context r100, QQToken r101) {
    L7:
        e = move-exception;
        SLog.e("OpenConfig", "checkStatStatus exception: " + e.toString());
        return;
    L3:
        if (a(r100, r101) == false) goto L5;
        f461404f.invoke(f461399a, new Object[]{Boolean.TRUE});     // Catch: Exception -> L7
    L10:
        return;
    L5:
        f461404f.invoke(f461399a, new Object[]{Boolean.FALSE});     // Catch: Exception -> L7
        goto L10
    }

    public static void c(Context r110, QQToken r111) {
        String r100 = "Aqc" + r111.getAppId();
        f461399a = INVOKESTATIC_com_tencent_connect_a_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.tencent.stat.StatConfig");     // Catch: Exception -> L5
        Class<?> r101 = INVOKESTATIC_com_tencent_connect_a_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.tencent.stat.StatService");     // Catch: Exception -> L5
        f461400b = r101;     // Catch: Exception -> L5
        f461401c = r101.getMethod("reportQQ", new Class[]{Context.class, String.class});     // Catch: Exception -> L5
        f461402d = f461400b.getMethod("trackCustomEvent", new Class[]{Context.class, String.class, String[].class});     // Catch: Exception -> L5
        Class<?> r102 = f461400b;     // Catch: Exception -> L5
        Class<?> r103 = Integer.TYPE;     // Catch: Exception -> L5
        f461403e = r102.getMethod("commitEvents", new Class[]{Context.class, r103});     // Catch: Exception -> L5
        Class<?> r104 = f461399a;     // Catch: Exception -> L5
        Class<?> r105 = Boolean.TYPE;     // Catch: Exception -> L5
        f461404f = r104.getMethod("setEnableStatService", new Class[]{r105});     // Catch: Exception -> L5
        b(r110, r111);     // Catch: Exception -> L5
        f461399a.getMethod("setAutoExceptionCaught", new Class[]{r105}).invoke(f461399a, new Object[]{Boolean.FALSE});     // Catch: Exception -> L5
        f461399a.getMethod("setEnableSmartReporting", new Class[]{r105}).invoke(f461399a, new Object[]{Boolean.TRUE});     // Catch: Exception -> L5
        f461399a.getMethod("setSendPeriodMinutes", new Class[]{r103}).invoke(f461399a, new Object[]{1440});     // Catch: Exception -> L5
        Class<?> r112 = INVOKESTATIC_com_tencent_connect_a_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.tencent.stat.StatReportStrategy");     // Catch: Exception -> L5
        f461399a.getMethod("setStatSendStrategy", new Class[]{r112}).invoke(f461399a, new Object[]{r112.getField("PERIOD").get(null)});     // Catch: Exception -> L5
        f461400b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(f461400b, new Object[]{r110, r100, INVOKESTATIC_com_tencent_connect_a_a_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)});     // Catch: Exception -> L5
        f461405g = true;     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        SLog.e("OpenConfig", "start4QQConnect exception: " + e.toString());
    }

    public static void d(Context r110, QQToken r111) {
        if (TextUtils.isEmpty(r111.getOpenId()) == true) goto L6;
        e.a().a(r111.getOpenId(), r111.getAppId(), "2", "1", "11", "0", "0", "0");
    L6:
        if (f461405g == true) goto L8;
        return;
    L8:
        b(r110, r111);
        if (r111.getOpenId() == null) goto L17;
        f461401c.invoke(f461400b, new Object[]{r110, r111.getOpenId()});     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        SLog.e("OpenConfig", "reportQQ exception: " + e.toString());
        return;
    }

    public static void a(Context r100, QQToken r101, String r102, String... r103) {
        if (f461405g == true) goto L5;
        return;
    L5:
        b(r100, r101);
        f461402d.invoke(f461400b, new Object[]{r100, r102, r103});     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        SLog.e("OpenConfig", "trackCustomEvent exception: " + e.toString());
    }
}
