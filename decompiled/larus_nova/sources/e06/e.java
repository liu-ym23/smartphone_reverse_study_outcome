package e06;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f470644a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
    }

    static {
    }

    public static boolean b(Context r100) {
        if (TextUtils.isEmpty(f470644a) == true) goto L71;
        String r101 = f470644a;
    L61:
        if (r101 != null) goto L63;
        return false;
    L63:
        if (StringsKt.contains$default(r101, ":", false, 2, null) == false) goto L66;
        return false;
    L66:
        return Intrinsics.areEqual(r101, r100.getPackageName());
    L71:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        String r102 = null;
    L12:
        f470644a = r102;
        if (TextUtils.isEmpty(r102) == true) goto L73;
        r101 = f470644a;
        goto L61
    L73:
        Object r103 = a().getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L20
        if (r103 == null) goto L19;
        String r104 = (String) r103;     // Catch: Throwable -> L20
    L22:
        f470644a = r104;
        if (TextUtils.isEmpty(r104) == true) goto L76;
        r101 = f470644a;
        goto L61
    L76:
        BufferedReader r105 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L33
        int r106 = r105.read();     // Catch: Throwable -> L32
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L32
    L28:
        if (r106 <= 0) goto L30;
        r107.append((char) r106);     // Catch: Throwable -> L32
        r106 = r105.read();     // Catch: Throwable -> L32
        goto L28
    L30:
        String r108 = r107.toString();     // Catch: Throwable -> L32
    L69:
        r105.close();     // Catch: Exception -> L38
    L39:
        f470644a = r108;
        if (TextUtils.isEmpty(r108) == true) goto L78;
        r101 = f470644a;
        goto L61
    L78:
        Object r109 = r100.getSystemService("activity");     // Catch: Exception -> L68
        if (r109 == null) goto L58;
        List<ActivityManager.RunningAppProcessInfo> r110 = ((ActivityManager) r109).getRunningAppProcesses();     // Catch: Exception -> L68
        if (r110 == null) goto L59;
        if (r110.size() == 0) goto L59;
        int r111 = Process.myPid();     // Catch: Exception -> L68
        Iterator<ActivityManager.RunningAppProcessInfo> r112 = r110.iterator();     // Catch: Exception -> L68
    L51:
        if (r112.hasNext() == false) goto L59;
        ActivityManager.RunningAppProcessInfo r113 = r112.next();     // Catch: Exception -> L68
        if (r113.pid != r111) goto L51;
        String r114 = r113.processName;     // Catch: Exception -> L68
        if (r114 == null) goto L51;
        r101 = r114;
    L60:
        f470644a = r101;
        goto L61
    L58:
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L68
    L59:
        r101 = "";
    L34:
        r108 = null;
        if (r105 == null) goto L39;
    L33:
        r105 = null;
        goto L34
    L19:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
        r104 = null;
        goto L22
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L11;
        r102 = Application.getProcessName();     // Catch: Throwable -> L9
        goto L12
    }
}
