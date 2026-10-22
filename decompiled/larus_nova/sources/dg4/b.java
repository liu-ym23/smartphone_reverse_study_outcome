package dg4;

import android.app.Application;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f468391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f468392b;

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

    public static int b() {
        int r100 = f468391a;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        d();
        int r101 = f468391a;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static int c() {
        int r100 = f468392b;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        d();
        int r101 = f468392b;
        if (r101 > 0) goto L10;
        return 0;
    L10:
        return r101;
    }

    public static void d() {
        Application r100 = uf4.a.a();
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);     // Catch: Exception -> L14
        if ((r101 instanceof WindowManager) == true) goto L6;
        r101 = null;
    L6:
        WindowManager r102 = (WindowManager) r101;     // Catch: Exception -> L14
        if (r102 == null) goto L12;
        Display r103 = r102.getDefaultDisplay();     // Catch: Exception -> L14
        if (r103 == null) goto L11;
        Point r104 = new Point();     // Catch: Exception -> L14
        r103.getRealSize(r104);     // Catch: Exception -> L14
        f468391a = r104.y;     // Catch: Exception -> L14
        f468392b = r104.x;     // Catch: Exception -> L14
    L17:
        return;
    L11:
        return;
    L12:
        Resources r105 = r100.getResources();     // Catch: Exception -> L14
        DisplayMetrics r106 = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics());     // Catch: Exception -> L14
        f468391a = r106.heightPixels;     // Catch: Exception -> L14
        f468392b = r106.widthPixels;     // Catch: Exception -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    }

    static {
    }
}
