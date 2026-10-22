package y4a;

import android.os.Build;
import android.os.Process;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.setting.AnimaXSettingValue;
import com.lynx.animax.util.AnimaXLog;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f566160a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f566161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f566162c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f566163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f566164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f566165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f566166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f566167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f566168i;

    static {
        String r100 = Build.MODEL.toLowerCase();
        f566160a = r100;
        f566161b = -1;
        f566162c = Arrays.asList(new String[]{"m6 note", "m721c"}).contains(r100);
        f566163d = false;
        f566164e = false;
        f566165f = false;
        f566166g = false;
        f566167h = false;
        f566168i = false;
    }

    public static boolean c() {
        if (f566163d == true) goto L15;
        if (Build.VERSION.SDK_INT < 23) goto L8;
        boolean r100 = Process.is64Bit();     // Catch: Exception -> L16
    L13:
        f566164e = !r100;
        f566163d = true;
    L8:
        Class r101 = a("dalvik.system.VMRuntime");     // Catch: Exception -> L16
        Boolean r102 = (Boolean) r101.getDeclaredMethod("is64Bit", new Class[0]).invoke(r101.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]);     // Catch: Exception -> L16
        if (r102 == null) goto L12;
        r100 = r102.booleanValue();     // Catch: Exception -> L16
        goto L13
    L19:
        r100 = true;
    L12:
        r100 = true;
    L15:
        return f566164e;
    }

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

    public static boolean e(String r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.isEmpty() == true) goto L10;
        if ("1".equals(r100) == false) goto L8;
    L9:
        return true;
    L8:
        if ("true".equalsIgnoreCase(r100) == false) goto L10;
        goto L9
    }

    public static String b(String r100, BaseAbility r101) {
        w4a.c r102 = (w4a.c) r101.f380239c.a(w4a.c.class);
        if (r102 == null) goto L7;
        AnimaXSettingValue r103 = r102.a(r100);
        if (r103 == null) goto L7;
        return r103.b();
    L7:
        return "";
    }

    public static boolean d(String r100, BaseAbility r101) {
        w4a.c r102 = (w4a.c) r101.f380239c.a(w4a.c.class);
        if (r102 != null) goto L27;
        return false;
    L27:
        AnimaXSettingValue r103 = r102.a(r100);     // Catch: Throwable -> L24
        if (r103 != null) goto L9;
        return false;
    L9:
        if (r103.d() == false) goto L13;
        return e(r103.b());
    L13:
        if (r103.c() == false) goto L26;
        Collection<String> r104 = r103.a();     // Catch: Throwable -> L24
        if (r104.isEmpty() == true) goto L28;
        String r105 = f566160a;     // Catch: Throwable -> L24
        if (r105 != null) goto L19;
        return false;
    L19:
        if (r105.isEmpty() == false) goto L21;
        return false;
    L21:
        if (r104.contains(r105) == false) goto L31;
        return true;
    L31:
        return false;
    L28:
        return false;
    L26:
        return false;
    L24:
        th = move-exception;
        AnimaXLog.a("DeviceUtil", "isInSettingList fail, message" + th.getMessage());
        goto L26
    }
}
