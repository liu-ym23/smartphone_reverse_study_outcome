package ss7;

import android.content.Context;
import com.alipay.zoloz.toyger.SgomInfoManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f543413a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f543414b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f543415c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f543416d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f543417e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f543418f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f543419g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f543420h = "0";

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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

    public static void b(Context r110, boolean r111) {
        SgomInfoManager.IReport r100 = SgomInfoManager.sReportCrash;
        if (f543413a == true) goto L31;
        f543420h = "0";
        Class<?> r101 = a("face.security.device.api.FaceSecDevice");     // Catch: ClassNotFoundException -> L11
        Class<?> r102 = a("face.security.device.api.FaceSecInitListener");     // Catch: ClassNotFoundException -> L10
        f543420h = "1";     // Catch: ClassNotFoundException -> L9
    L16:
        f543414b = r101;
        f543415c = r102;
        if (r101 != null) goto L64;
    L30:
        f543413a = true;
        goto L31
    L64:
        f543416d = r101.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L28
        f543418f = f543414b.getMethod(EffectConfiguration.KEY_LX, new Class[0]);     // Catch: Throwable -> L28
        f543417e = f543414b.getMethod("lp", new Class[]{Integer.TYPE, String.class});     // Catch: Throwable -> L28
        f543419g = f543414b.getMethod("getVersion", new Class[0]);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        r100.onReport("securityDevcie", "initError", th, new String[0]);
    L9:
        Class<?> r112 = r102;
        Class<?> r103 = r101;
    L58:
        r103 = a("net.security.device.api.SecurityDevice");     // Catch: ClassNotFoundException -> L14
        r112 = a("net.security.device.api.SecurityInitListener");     // Catch: ClassNotFoundException -> L14
        f543420h = "2";     // Catch: ClassNotFoundException -> L14
        r101 = r103;
        r102 = r112;
    L14:
        e = move-exception;
        r101 = r103;
        r102 = r112;
        r100.onReport("securityDevcie", "initError", e, new String[0]);
    L10:
        r103 = r101;
        r112 = null;
    L11:
        r103 = null;
        r112 = null;
    L31:
        Class<?> r104 = f543414b;
        if (r104 == null) goto L67;
        Class<?> r105 = f543415c;
        if (r105 == null) goto L68;
        if (r110 != null) goto L37;
        return;
    L37:
        if (f543416d != null) goto L62;
        return;
    L62:
        Method r106 = r104.getMethod("initWithOptions", new Class[]{Context.class, String.class, Map.class, r105});     // Catch: Throwable -> L46
        if (r111 == false) goto L43;
        HashMap r107 = new HashMap();     // Catch: Throwable -> L46
        r107.put("IPv6", "1");     // Catch: Throwable -> L46
    L44:
        r106.invoke(f543416d, new Object[]{r110, "sh89cbf2cahs0962df17ef1b9821240a", r107, null});     // Catch: Throwable -> L46
        return;
    L43:
        r107 = null;
    L50:
        th = move-exception;
        if (r100 == null) goto L70;
        r100.onReport("securityDevcie", "initError", th, new String[0]);
        return;
    L70:
        return;
    L48:
        f543414b.getMethod("init", new Class[]{Context.class, String.class, f543415c}).invoke(f543416d, new Object[]{r110, "sh89cbf2cahs0962df17ef1b9821240a", null});     // Catch: Throwable -> L50
        return;
    L68:
        return;
    }

    public static void c(int r100, String r101) {
        SgomInfoManager.IReport r102 = SgomInfoManager.sReportCrash;
        Object r103 = f543416d;
        if (r103 == null) goto L16;
        Method r104 = f543417e;
        if (r104 != null) goto L14;
        return;
    L14:
        r104.invoke(r103, new Object[]{Integer.valueOf(r100), r101});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (r102 == null) goto L17;
        r102.onReport("securityDevcie", "lpError", th, new String[0]);
        return;
    L17:
        return;
    }
}
