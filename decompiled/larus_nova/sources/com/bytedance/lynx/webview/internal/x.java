package com.bytedance.lynx.webview.internal;

import android.os.Build;
import android.webkit.WebViewFactory;
import com.bytedance.lynx.webview.glue.TTWebProviderWrapper;
import com.bytedance.lynx.webview.util.flipped.ModifiedFlipped;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes21.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f265372a = null;

    public x() {
    }

    static {
        f265372a = x.class.getSimpleName();
    }

    public static Object a() throws Exception {
        if (TTWebContext.f265201J == true) goto L21;
    L7:
        Field r100 = null;
    L9:
        if (Build.VERSION.SDK_INT >= 30) goto L11;
    L14:
        if (r100 != null) goto L16;
        r100 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke((Class) Class.class.getDeclaredMethod("forName", new Class[]{String.class}).invoke(null, new Object[]{"android.webkit.WebViewFactory"}), new Object[]{"sProviderLock"});
    L16:
        if (r100 == null) goto L20;
        r100.setAccessible(true);
        return r100.get(null);
    L20:
        throw new NullPointerException("getProviderLock reflection fails");
    L11:
        if (TTWebContext.h().getContext().getApplicationInfo().targetSdkVersion < 30) goto L14;
        if (r100 != null) goto L14;
        r100 = ModifiedFlipped.b();
        goto L16
    L21:
        r100 = WebViewFactory.class.getDeclaredField("sProviderLock");     // Catch: Throwable -> L6
        goto L9
    }

    public static void b(TTWebProviderWrapper r100) {
        Object r101 = a();     // Catch: Exception -> L11
        monitor-enter(r101);     // Catch: Exception -> L11
        Field r102 = WebViewFactory.class.getDeclaredField("sProviderInstance");     // Catch: Throwable -> L8
        r102.setAccessible(true);     // Catch: Throwable -> L8
        r102.set(null, r100);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    L11:
        e = move-exception;
        l17.k.b(new String[]{f265372a, "safeSetProvider error: " + e.toString()});
    }

    public static boolean c(TTWebProviderWrapper r100) {
        Object r101 = a();     // Catch: Exception -> L15
        monitor-enter(r101);     // Catch: Exception -> L15
        Field r102 = WebViewFactory.class.getDeclaredField("sProviderInstance");     // Catch: Throwable -> L12
        r102.setAccessible(true);     // Catch: Throwable -> L12
        if (r102.get(null) != null) goto L10;
        r102.set(null, r100);     // Catch: Throwable -> L12
        monitor-exit(r101);     // Catch: Throwable -> L12
        return true;
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
    L17:
        return false;
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L15
    L15:
        e = move-exception;
        l17.k.b(new String[]{f265372a, "safeSetProvider error: " + e.toString()});
        goto L17
    }
}
