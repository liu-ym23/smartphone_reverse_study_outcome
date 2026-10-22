package fm3;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public static boolean b() {
        int r1 = jc1.e.a;     // Catch: Exception -> L16
        Class r2 = a();     // Catch: Exception -> L16
        Object r3 = null;
        if (r2 == null) goto L6;
        Method r4 = r2.getDeclaredMethod("isDouyinLight", new Class[0]);     // Catch: Exception -> L16
    L7:
        if (r4 == null) goto L9;
        r4.setAccessible(true);     // Catch: Exception -> L16
    L9:
        if (r4 == null) goto L11;
        r3 = r4.invoke(null, new Object[0]);     // Catch: Exception -> L16
    L11:
        if (r3 == null) goto L14;
        return ((Boolean) r3).booleanValue();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");     // Catch: Exception -> L16
    L6:
        r4 = null;
        goto L7
    L18:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");
    }

    static {
    }
}
