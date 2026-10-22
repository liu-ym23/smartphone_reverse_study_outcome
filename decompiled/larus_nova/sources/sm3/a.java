package sm3;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import jc1.e;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    public static String b() {
        boolean r100 = false;
        int r101 = e.f498076a;     // Catch: Exception -> L5
        Method r102 = a().getDeclaredMethod("isDouyinLight", new Class[0]);     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r100 = ((Boolean) r102.invoke(null, new Object[0])).booleanValue();     // Catch: Exception -> L5
    L6:
        if (r100 == false) goto L9;
        return "light";
    L9:
        return "dark";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.android.livesdk.uicomponent.DouyinThemeManager");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
}
