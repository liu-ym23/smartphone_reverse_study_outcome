package com.bytedance.lynx.webview.internal;

import android.os.Build;
import android.os.Trace;
import android.util.AndroidRuntimeException;
import android.webkit.WebViewDelegate;
import android.webkit.WebViewFactory;
import android.webkit.WebViewFactoryProvider;
import com.bytedance.lynx.webview.util.flipped.ModifiedFlipped;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes21.dex */
public final class n0 {
    public static WebViewFactoryProvider b() {
        Trace.beginSection("WebViewFactory.getProvider()");
        x.b(null);     // Catch: Throwable -> L6 Exception -> L8
        Method r100 = WebViewFactory.class.getDeclaredMethod("getProvider", new Class[0]);     // Catch: Throwable -> L6 Exception -> L8
        r100.setAccessible(true);     // Catch: Throwable -> L6 Exception -> L8
        WebViewFactoryProvider r101 = (WebViewFactoryProvider) r100.invoke(null, new Object[0]);     // Catch: Throwable -> L6 Exception -> L8
        Trace.endSection();
        return r101;
    L6:
        th = move-exception;
        Trace.endSection();
        throw th;
    L8:
        e = move-exception;
        r.c("[Load] SysProviderCreator: getSysProviderForL, exception: ", e);     // Catch: Throwable -> L6
        throw new RuntimeException(e);     // Catch: Throwable -> L6
    }

    public static WebViewFactoryProvider c() {
        Trace.beginSection("WebViewFactory.getProvider()");
        Method r100 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke((Class) Class.class.getDeclaredMethod("forName", new Class[]{String.class}).invoke(null, new Object[]{"android.webkit.WebViewFactory"}), new Object[]{"getProviderClass", new Class[0]});     // Catch: Throwable -> L24 Exception -> L26
        r100.setAccessible(true);     // Catch: Throwable -> L24 Exception -> L26
        Constructor r101 = ((Class) r100.invoke(null, new Object[0])).getDeclaredConstructor(new Class[]{WebViewDelegate.class});     // Catch: Exception -> L9 Throwable -> L24
        r101.setAccessible(true);     // Catch: Exception -> L7 Throwable -> L24
    L12:
        Trace.beginSection("WebViewFactoryProvider invocation");     // Catch: Throwable -> L24 Exception -> L26
        Constructor r102 = WebViewDelegate.class.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L17 Exception -> L19
        r102.setAccessible(true);     // Catch: Throwable -> L17 Exception -> L19
        WebViewFactoryProvider r103 = (WebViewFactoryProvider) r101.newInstance(new Object[]{r102.newInstance(new Object[0])});     // Catch: Throwable -> L17 Exception -> L19
        r.a("[Load] SysProviderCreator: Loaded provider: " + r103);     // Catch: Throwable -> L17 Exception -> L19
        Trace.endSection();     // Catch: Throwable -> L24 Exception -> L26
        Trace.endSection();
        return r103;
    L19:
        e = move-exception;
        r.c("[Load] SysProviderCreator: error instantiating provider: ", e);     // Catch: Throwable -> L17
        throw new AndroidRuntimeException(e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Trace.endSection();     // Catch: Throwable -> L24 Exception -> L26
        throw th;     // Catch: Throwable -> L24 Exception -> L26
    L7:
        e = e;
    L11:
        r.b("[Load] SysProviderCreator: error instantiating provider with static factory method: " + e);     // Catch: Throwable -> L24 Exception -> L26
    L9:
        e = e;
        r101 = null;
    L26:
        e = move-exception;
        r.c("[Load] SysProviderCreator: getSysProviderForM Create system provider error: ", e);     // Catch: Throwable -> L24
        EventStatistics.e(EventType.LOAD_LOAD_SYSTEM_PROVIDER_ERROR, null);     // Catch: Throwable -> L24
        Trace.endSection();
        return null;
    L24:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static WebViewFactoryProvider d() {
        Trace.beginSection("WebViewFactory.getProvider()");
    L33:
        e = move-exception;
        r.c("[Load] SysProviderCreator: getSysProviderForO Create system provider error: ", e);     // Catch: Throwable -> L31
        EventStatistics.e(EventType.LOAD_LOAD_SYSTEM_PROVIDER_ERROR, null);     // Catch: Throwable -> L31
        Trace.endSection();
        return null;
    L5:
        if (TTWebContext.f265201J == true) goto L39;
    L11:
        Method r100 = null;
    L12:
        if (r100 != null) goto L46;
        r100 = ModifiedFlipped.c(new Class[0]);     // Catch: Throwable -> L31 Exception -> L33
        r100.setAccessible(true);     // Catch: Throwable -> L31 Exception -> L33
    L46:
        Method r101 = ((Class) r100.invoke(null, new Object[0])).getMethod("create", new Class[]{WebViewDelegate.class});     // Catch: Exception -> L17 Throwable -> L31
    L19:
        Trace.beginSection("WebViewFactoryProvider invocation");     // Catch: Throwable -> L31 Exception -> L33
        Constructor r102 = WebViewDelegate.class.getDeclaredConstructor(new Class[0]);     // Catch: Throwable -> L24 Exception -> L26
        r102.setAccessible(true);     // Catch: Throwable -> L24 Exception -> L26
        WebViewFactoryProvider r103 = (WebViewFactoryProvider) r101.invoke(null, new Object[]{r102.newInstance(new Object[0])});     // Catch: Throwable -> L24 Exception -> L26
        r.a("[Load] SysProviderCreator: Loaded provider: " + r103);     // Catch: Throwable -> L24 Exception -> L26
        Trace.endSection();     // Catch: Throwable -> L31 Exception -> L33
        Trace.endSection();
        return r103;
    L26:
        e = move-exception;
        r.c("[Load] SysProviderCreator: error instantiating provider: ", e);     // Catch: Throwable -> L24
        throw new AndroidRuntimeException(e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        Trace.endSection();     // Catch: Throwable -> L31 Exception -> L33
        throw th;     // Catch: Throwable -> L31 Exception -> L33
    L17:
        e = move-exception;
        r.b("[Load] SysProviderCreator: error instantiating provider with static factory method: " + e);     // Catch: Throwable -> L31 Exception -> L33
        r101 = null;
        goto L19
    L39:
        r100 = WebViewFactory.class.getDeclaredMethod("getProviderClass", new Class[0]);     // Catch: Throwable -> L10
        r100.setAccessible(true);     // Catch: Throwable -> L9
    L31:
        th = move-exception;
        Trace.endSection();
        throw th;
    }

    public static WebViewFactoryProvider a() {
        Object r100 = x.a();     // Catch: Exception -> L16
        monitor-enter(r100);     // Catch: Exception -> L16
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L13
        if (r101 < 26) goto L8;
        WebViewFactoryProvider r102 = d();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
        return r102;
    L8:
        if (r101 < 23) goto L10;
        r102 = c();     // Catch: Throwable -> L13
        goto L11
    L10:
        r102 = b();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L16
    L16:
        e = move-exception;
        r.c("[Load] SysProviderCreator create SysProvider failed: ", e);
        return null;
    }
}
