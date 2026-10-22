package com.bytedance.lynx.webview.util.flipped;

import com.bytedance.librarian.a;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class ModifiedFlipped {
    public ModifiedFlipped() {
    }

    private static native Field getDeclaredField(Object r100, String r101);

    private static native Method getDeclaredMethod(Object r100, String r101, Class<?>[] r102);

    public static native long getLibraryHandleAddress(String r100);

    static {
        Intrinsics.checkNotNullParameter("TTWebViewSdkFlipped", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> TTWebViewSdkFlipped");
        a.c("TTWebViewSdkFlipped");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> TTWebViewSdkFlipped");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.webkit.WebViewFactory");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.webkit.WebViewFactory");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.webkit.WebViewFactory");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.webkit.WebViewFactory");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.webkit.WebViewFactory");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.webkit.WebViewFactory");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.webkit.WebViewFactory");
    }

    public static Field b() {
        Field r100 = null;
        r100 = getDeclaredField(a(), "sProviderLock");     // Catch: Exception -> L5
        r100.setAccessible(true);     // Catch: Exception -> L5
        return r100;
    L5:
        e = move-exception;
        e.toString();
        return r100;
    }

    public static Method c(Class[] r100) {
        Method r101 = null;
        r101 = getDeclaredMethod(a(), "getProviderClass", r100);     // Catch: Exception -> L5
        r101.setAccessible(true);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        e.toString();
        return r101;
    }
}
