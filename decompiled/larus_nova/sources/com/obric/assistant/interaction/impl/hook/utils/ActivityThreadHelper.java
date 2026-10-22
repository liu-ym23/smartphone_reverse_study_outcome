package com.obric.assistant.interaction.impl.hook.utils;

import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import hea.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityThreadHelper {
    private static final String TAG = "ActivityThreadHelper";
    private static Object sActivityThread;
    private static Class sClassForActivityThread;

    public ActivityThreadHelper() {
    }

    public static /* synthetic */ void a(Object r100) {
        lambda$currentActivityThread$0(r100);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static Object currentActivityThread() {
        if (sActivityThread != null) goto L36;
        monitor-enter(ActivityThreadHelper.class);     // Catch: Exception -> L37
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L37
    L7:
        if (sActivityThread != null) goto L13;
        if (sClassForActivityThread != null) goto L11;
        sClassForActivityThread = INVOKESTATIC_com_obric_assistant_interaction_impl_hook_utils_ActivityThreadHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread");     // Catch: Throwable -> L32
    L11:
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L32
    L13:
        if (sActivityThread == null) goto L15;
    L30:
        monitor-exit(ActivityThreadHelper.class);     // Catch: Throwable -> L32
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        final Object r100 = new Object();     // Catch: Throwable -> L32
        y.b().post(new a(r100));     // Catch: Throwable -> L32
        if (sActivityThread != null) goto L30;
        monitor-enter(r100);     // Catch: Throwable -> L32
        r100.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L24
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L22
        goto L36
    L24:
        e = move-exception;
        FLogger.f375446a.e(TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L36:
        return sActivityThread;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_assistant_interaction_impl_hook_utils_ActivityThreadHelper_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static /* synthetic */ void lambda$currentActivityThread$0(Object r100) {
        sActivityThread = MethodUtils.invokeStaticMethod(sClassForActivityThread, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L10 Exception -> L12
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
    L32:
        return;
    L7:
        th = move-exception;
        throw th;
    L10:
        th = move-exception;
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L25
        throw th;
    L25:
        th = move-exception;
        throw th;
    L12:
        e = move-exception;
        FLogger.f375446a.e(TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);     // Catch: Throwable -> L10
        monitor-enter(r100);
        r100.notify();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }
}
