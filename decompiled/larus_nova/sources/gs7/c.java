package gs7;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f482449a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f482450b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f482451c = null;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    static {
        Method[] r100 = a().getMethods();     // Catch: ClassNotFoundException -> L20
        int r101 = r100.length;     // Catch: ClassNotFoundException -> L20
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L32;
        Method r103 = r100[r102];     // Catch: ClassNotFoundException -> L20
        String r104 = r103.getName();     // Catch: ClassNotFoundException -> L20
        if (r104.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L8;
        f482449a = r103;     // Catch: ClassNotFoundException -> L20
    L19:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104.equals("set") == true) goto L19;
        if (r104.equals("getLong") == true) goto L19;
        if (r104.equals("getInt") == false) goto L17;
        f482450b = r103;     // Catch: ClassNotFoundException -> L20
        goto L19
    L17:
        if (r104.equals("getBoolean") == false) goto L19;
        f482451c = r103;     // Catch: ClassNotFoundException -> L20
        goto L19
    L32:
        return;
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public static String b(String r100) {
        Method r101 = f482449a;
        if (r101 != null) goto L15;
        return "";
    L15:
        return (String) r101.invoke(null, new Object[]{r100, ""});
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return "";
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    public static int c(String r100, int r101) {
        Method r102 = f482450b;
        if (r102 != null) goto L15;
        return r101;
    L15:
        return ((Integer) r102.invoke(null, new Object[]{r100, Integer.valueOf(r101)})).intValue();
    L10:
        e = move-exception;
        e.printStackTrace();
    L14:
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
