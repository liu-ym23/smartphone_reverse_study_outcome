package com.optimize.statistics;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public class WindowHelper {
    private static final String PREFIX_CUSTOM_WINDOW = "/CustomWindow";
    private static final String PREFIX_DIALOG_WINDOW = "/DialogWindow";
    private static final String PREFIX_IGNORED_WINDOW = "/Ignored";
    private static final String PREFIX_MAIN_WINDOW = "/MainWindow";
    private static final String PREFIX_POPUP_WINDOW = "/PopupWindow";
    private static boolean mOptExceedLimitMonitor;
    private static boolean sArrayListWindowViews;
    private static boolean sIsInitialized;
    private static Method sItemViewGetDataMethod;
    private static Class<?> sListMenuItemViewClazz;
    private static Class sPhoneWindowClazz;
    static Class sPopupWindowClazz;
    private static boolean sViewArrayWindowViews;
    private static Object sWindowManger;
    private static Field viewsField;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String getMainWindowPrefix() {
        return PREFIX_MAIN_WINDOW;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007f -> B:36:0x007f). Please report as a decompilation issue!!! */
    public static void init() {
        if (sIsInitialized == false) goto L5;
        return;
    L5:
        if (mOptExceedLimitMonitor == true) goto L39;
        Class r100 = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.WindowManagerGlobal");     // Catch: Throwable -> L28
        viewsField = r100.getDeclaredField("mViews");     // Catch: Throwable -> L28
        Field r101 = r100.getDeclaredField("sDefaultWindowManager");     // Catch: Throwable -> L28
        viewsField.setAccessible(true);     // Catch: Throwable -> L28
        if (viewsField.getType() != ArrayList.class) goto L11;
        sArrayListWindowViews = true;     // Catch: Throwable -> L28
    L13:
        r101.setAccessible(true);     // Catch: Throwable -> L28
        sWindowManger = r101.get(null);     // Catch: Throwable -> L28
        goto L34
    L11:
        if (viewsField.getType() != View[].class) goto L13;
        sViewArrayWindowViews = true;     // Catch: Throwable -> L28
    L34:
        sListMenuItemViewClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.view.menu.ListMenuItemView");     // Catch: Throwable -> L29
        sItemViewGetDataMethod = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.view.menu.MenuView$ItemView").getDeclaredMethod("getItemData", new Class[0]);     // Catch: Throwable -> L29
    L39:
        if (Build.VERSION.SDK_INT >= 23) goto L37;
        sPhoneWindowClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.impl.PhoneWindow$DecorView");     // Catch: ClassNotFoundException -> L30
        goto L36
    L37:
        sPhoneWindowClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.PhoneWindow$DecorView");     // Catch: ClassNotFoundException -> L20
    L20:
        sPhoneWindowClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.policy.DecorView");     // Catch: ClassNotFoundException -> L30
    L36:
        if (Build.VERSION.SDK_INT < 23) goto L25;
        sPopupWindowClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.widget.PopupWindow$PopupDecorView");     // Catch: ClassNotFoundException -> L31
        goto L26
    L25:
        sPopupWindowClazz = INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.widget.PopupWindow$PopupViewContainer");     // Catch: ClassNotFoundException -> L31
    L26:
        sIsInitialized = true;
    }

    private WindowHelper() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_optimize_statistics_WindowHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static String getSubWindowPrefix(View r100) {
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof WindowManager.LayoutParams) == false) goto L21;
        int r102 = ((WindowManager.LayoutParams) r101).type;
        if (r102 != 1) goto L8;
        return PREFIX_MAIN_WINDOW;
    L8:
        if (r102 >= 99) goto L14;
        if (r100.getClass() != sPhoneWindowClazz) goto L14;
        return PREFIX_DIALOG_WINDOW;
    L14:
        if (r102 >= 1999) goto L19;
        if (r100.getClass() != sPopupWindowClazz) goto L19;
        return PREFIX_POPUP_WINDOW;
    L19:
        if (r102 >= 2999) goto L21;
        return PREFIX_CUSTOM_WINDOW;
    L21:
        Class<?> r103 = r100.getClass();
        if (r103 != sPhoneWindowClazz) goto L25;
        return PREFIX_MAIN_WINDOW;
    L25:
        if (r103 != sPopupWindowClazz) goto L28;
        return PREFIX_POPUP_WINDOW;
    L28:
        return PREFIX_CUSTOM_WINDOW;
    }

    public static boolean isDecorView(View r100) {
        if (sIsInitialized == true) goto L5;
        init();
    L5:
        Class<?> r101 = r100.getClass();
        if (r101 != sPhoneWindowClazz) goto L8;
    L11:
        return true;
    L8:
        if (r101 == sPopupWindowClazz) goto L11;
        return false;
    }

    public static void setOptExceedLimitMonitor(boolean r100) {
        mOptExceedLimitMonitor = r100;
    }
}
