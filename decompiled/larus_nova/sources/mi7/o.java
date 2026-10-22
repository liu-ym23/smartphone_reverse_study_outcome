package mi7;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import ci7.p;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f514109a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r103 = Class.forName("android.app.ActivityThread", false, r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    L34:
        Class<?> r104 = Class.forName("android.app.ActivityThread", false, r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    }

    public static boolean b(Context r100) {
        String r101 = f514109a;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L74;
        r101 = f514109a;
        if (r101 != null) goto L14;
    L17:
        boolean r103 = true;
    L18:
        String r104 = null;
        if (r103 == true) goto L93;
    L28:
        if (r101 != null) goto L30;
    L33:
        boolean r105 = true;
    L34:
        if (r105 == false) goto L74;
        int r106 = Process.myPid();     // Catch: Exception -> L51
        Iterator<ActivityManager.RunningAppProcessInfo> r107 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L51
    L38:
        if (r107.hasNext() == false) goto L91;
        ActivityManager.RunningAppProcessInfo r108 = r107.next();     // Catch: Exception -> L51
        if (r108.pid != r106) goto L38;
        ZlinkDependAbility r109 = p.f23879a;     // Catch: Exception -> L51
        if (r109 != null) goto L44;
    L46:
        boolean r110 = false;
    L47:
        if (r110 == false) goto L49;
        e.a("Process", "processName = " + r108.processName);     // Catch: Exception -> L51
    L49:
        r101 = r108.processName;     // Catch: Exception -> L51
        f514109a = r101;     // Catch: Exception -> L51
        goto L74
    L44:
        if (r109.isDebug() == false) goto L46;
        r110 = true;
    L91:
        BufferedReader r111 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L70
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L64
    L56:
        int r113 = r111.read();     // Catch: Throwable -> L64
        if (r113 <= 0) goto L59;
        r112.append((char) r113);     // Catch: Throwable -> L64
        goto L56
    L59:
        ZlinkDependAbility r114 = p.f23879a;     // Catch: Throwable -> L64
        if (r114 != null) goto L62;
    L65:
        boolean r115 = false;
    L66:
        if (r115 == false) goto L68;
        e.a("Process", "get processName = " + r112.toString());     // Catch: Throwable -> L64
    L68:
        r104 = r112.toString();     // Catch: Throwable -> L64
    L87:
        r111.close();     // Catch: Exception -> L84
    L73:
        r101 = r104;
        f514109a = r101;
        goto L74
    L62:
        if (r114.isDebug() == false) goto L65;
        r115 = true;
    L71:
        if (r111 == null) goto L73;
    L70:
        r111 = null;
    L51:
        e = move-exception;
        e.b("Process", "getCurProcessName error e: " + e);
        goto L91
    L30:
        if (r101.length() == 0) goto L33;
        r105 = false;
        goto L34
    L93:
        Method r116 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L25
        r116.setAccessible(true);     // Catch: Throwable -> L25
        Object r117 = r116.invoke(null, new Object[0]);     // Catch: Throwable -> L25
        if ((r117 instanceof String) == false) goto L27;
        f514109a = (String) r117;     // Catch: Throwable -> L25
    L27:
        r101 = f514109a;
    L25:
        th = move-exception;
        e.b("Process", "getCurProcessName error e: " + th);
        goto L27
    L14:
        if (r101.length() == 0) goto L17;
        r103 = false;
    L74:
        if (r101 != null) goto L76;
    L78:
        if (r101 != null) goto L80;
    L82:
        return false;
    L80:
        if (r101.equals(r100.getPackageName()) == false) goto L82;
        return true;
    L76:
        if (r101.contains(":") == false) goto L78;
        return false;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
