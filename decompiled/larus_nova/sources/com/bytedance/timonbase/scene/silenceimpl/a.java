package com.bytedance.timonbase.scene.silenceimpl;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.PopupWindow;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.timonbase.scene.ScenesDetector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f270891a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f270892b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Class<?> f270893c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f270894d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f270895e = null;

    public a() {
    }

    static {
        f270895e = new a();
        f270894d = a.class.getSimpleName();
        int r100 = Build.VERSION.SDK_INT;     // Catch: ClassNotFoundException -> L12
        if (r100 >= 23) goto L6;
        f270892b = a("com.android.internal.policy.impl.PhoneWindow$DecorView");     // Catch: ClassNotFoundException -> L12
    L9:
        if (r100 < 23) goto L17;
        f270893c = a("android.widget.PopupWindow$PopupDecorView");     // Catch: ClassNotFoundException -> L12
        return;
    L17:
        return;
    L6:
        if (r100 != 23) goto L8;
        f270892b = a("com.android.internal.policy.PhoneWindow$DecorView");     // Catch: ClassNotFoundException -> L12
        goto L9
    L8:
        f270891a = a("com.android.internal.policy.DecorView");     // Catch: ClassNotFoundException -> L12
    L12:
        e = move-exception;
        int r101 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.d(f270894d, e.getMessage(), e.getCause());
        boolean r102 = ScenesDetector.f270865a;
        ScenesDetector.d("DecorViewInfiltrator", -5);
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

    public static void b(Object r100) {
        Class<?> r101 = f270891a;     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (r101 != null) goto L5;
    L7:
        Class<?> r102 = f270892b;     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (r102 != null) goto L10;
    L12:
        Class<?> r103 = f270893c;     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
        if (r103 != null) goto L15;
    L23:
        return;
    L15:
        if (r103.isInstance(r100) != true) goto L23;
        c(r100);     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
        goto L23
    L10:
        if (r102.isInstance(r100) != true) goto L12;
        e(r100);     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
        goto L23
    L5:
        if (r101.isInstance(r100) != true) goto L7;
        d(r100);     // Catch: NoSuchFieldException -> L18 IllegalAccessException -> L20
    L20:
        e = move-exception;
        int r104 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.d(f270894d, e.getMessage(), e.getCause());
        boolean r105 = ScenesDetector.f270865a;
        ScenesDetector.d("infiltrateFor: illegalAccess", -3);
        return;
    L18:
        e = move-exception;
        int r106 = com.bytedance.timonbase.b.f270799a;
        com.bytedance.timonbase.b.d(f270894d, e.getMessage(), e.getCause());
        boolean r107 = ScenesDetector.f270865a;
        ScenesDetector.d("infiltrateFor: noSuchField", -4);
    }

    public static void c(Object r100) {
        Class<?> r101 = f270893c;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Field r102 = r101.getDeclaredField("this$0");
        r102.setAccessible(true);
        Object r103 = r102.get(r100);
        Field r104 = PopupWindow.class.getDeclaredField("mTouchInterceptor");
        r104.setAccessible(true);
        r104.set(r103, new c((View.OnTouchListener) r104.get(r103)));
    }

    public static void d(Object r100) {
        Class<?> r101 = f270891a;
        if (r101 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        Field r102 = r101.getDeclaredField("mWindow");
        r102.setAccessible(true);
        Object r103 = r102.get(r100);
        if (r103 == null) goto L13;
        Window r104 = (Window) r103;
        Window.Callback r105 = r104.getCallback();
        if (r104.getCallback() != null) goto L10;
        boolean r106 = ScenesDetector.f270865a;
        ScenesDetector.d("Window.Callback is null, forbidSilence invoke", -6);
        return;
    L10:
        r104.setCallback(new d(r105));
        return;
    L13:
        throw new TypeCastException("null cannot be cast to non-null type android.view.Window");
    }

    public static void e(Object r100) {
        Class<?> r101 = f270892b;
        if (r101 == null) goto L16;
        Field r102 = r101.getDeclaredField("this$0");
        if (r102 == null) goto L16;
        r102.setAccessible(true);
        Object r103 = r102.get(r100);
        if (r103 == null) goto L14;
        Window r104 = (Window) r103;
        Window.Callback r105 = r104.getCallback();
        if (r104.getCallback() != null) goto L11;
        boolean r106 = ScenesDetector.f270865a;
        ScenesDetector.d("Window.Callback is null, forbidSilence invoke", -6);
        return;
    L11:
        r104.setCallback(new d(r105));
        return;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type android.view.Window");
    L16:
        throw new NoSuchFieldException("can't find PhoneWindow");
    }
}
