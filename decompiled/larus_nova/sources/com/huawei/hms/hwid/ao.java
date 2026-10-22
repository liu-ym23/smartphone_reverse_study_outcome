package com.huawei.hms.hwid;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class ao {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static long a() {
        return Calendar.getInstance().getTimeInMillis();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_hwid_ao_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static View INVOKEVIRTUAL_com_huawei_hms_hwid_ao_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = Thread.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void a(Activity r100) {
        if (aq.a() == false) goto L6;
        b(r100);
        return;
    }

    public static void b(Activity r100) {
        as.b("AccountSdkUtil", "enter initOnApplyWindowInsets", true);
        final ViewGroup r101 = (ViewGroup) r100.getWindow().findViewById(R.id.content);
        if (r101 != null) goto L6;
        as.b("AccountSdkUtil", "rootView is null", true);
        return;
    L6:
        c(r100);
        INVOKEVIRTUAL_com_huawei_hms_hwid_ao_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100.getWindow()).setOnApplyWindowInsetsListener(new AnonymousClass1(r101));
    }

    public static void c(Activity r100) {
        WindowManager.LayoutParams r101 = r100.getWindow().getAttributes();
        Class r102 = INVOKESTATIC_com_huawei_hms_hwid_ao_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.android.view.WindowManagerEx$LayoutParamsEx");     // Catch: Throwable -> L5 InvocationTargetException -> L7 InstantiationException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 ClassNotFoundException -> L11
        Object r103 = r102.getDeclaredConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{r101});     // Catch: Throwable -> L5 InvocationTargetException -> L7 InstantiationException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 ClassNotFoundException -> L11
        r102.getMethod("setDisplaySideMode", new Class[]{Integer.TYPE}).invoke(r103, new Object[]{1});     // Catch: Throwable -> L5 InvocationTargetException -> L7 InstantiationException -> L8 IllegalAccessException -> L9 NoSuchMethodException -> L10 ClassNotFoundException -> L11
    L20:
        return;
    L11:
        as.d("AccountSdkUtil", "ClassNotFoundException setDisplaySideMode", true);
        return;
    L9:
        as.d("AccountSdkUtil", "IllegalAccessException setDisplaySideMode", true);
        return;
    L8:
        as.d("AccountSdkUtil", "InstantiationException setDisplaySideMode", true);
        return;
    L10:
        as.d("AccountSdkUtil", "NoSuchMethodException setDisplaySideMode", true);
        return;
    L7:
        as.d("AccountSdkUtil", "InvocationTargetException setDisplaySideMode", true);
        return;
    L5:
        th = move-exception;
        as.d("AccountSdkUtil", "setDisplaySideMode--".concat(th.getClass().getSimpleName()), true);
    }

    public static void a(ResponseErrorCode r100, Status r101) {
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r100.getParcelable() != null) goto L23;
        as.b("AccountSdkUtil", "parcelable is null", true);
        return;
    L23:
    L19:
        as.d("AccountSdkUtil", "doExecuteIntent ClassCastException", true);
        return;
    L17:
        th = move-exception;
        as.d("AccountSdkUtil", "doExecuteIntent--".concat(th.getClass().getSimpleName()), true);
        return;
    L11:
        if ((r100.getParcelable() instanceof PendingIntent) == false) goto L14;
        as.b("AccountSdkUtil", "doExecute is PendingIntent", true);     // Catch: Throwable -> L17 ClassCastException -> L19
        r101.setPendingIntent((PendingIntent) r100.getParcelable());     // Catch: Throwable -> L17 ClassCastException -> L19
    L14:
        if ((r100.getParcelable() instanceof Intent) == false) goto L25;
        as.b("AccountSdkUtil", "doExecute is Intent", true);     // Catch: Throwable -> L17 ClassCastException -> L19
        r101.setIntent((Intent) r100.getParcelable());     // Catch: Throwable -> L17 ClassCastException -> L19
    L27:
        return;
    L25:
        return;
    L21:
        as.b("AccountSdkUtil", "response or status is null", true);
    }
}
