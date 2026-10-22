package com.huawei.hms.push;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class i {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_push_i_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean a(Context r100) {
        if (new PushPreferences(r100, "push_notify_flag").getBoolean("notify_msg_enable") == false) goto L7;
        return false;
    L7:
        if (e.c() == false) goto L11;
        return ((NotificationManager) r100.getSystemService("notification")).areNotificationsEnabled();
    L11:
        if (Build.VERSION.SDK_INT < 24) goto L15;
        return b(r100);
    L15:
        return b(r100);
    }

    private static boolean b(Context r110) {
        AppOpsManager r100 = (AppOpsManager) r110.getSystemService("appops");
        ApplicationInfo r101 = r110.getApplicationInfo();
        String r111 = r110.getApplicationContext().getPackageName();
        int r102 = r101.uid;
        Class r103 = INVOKESTATIC_com_huawei_hms_push_i_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AppOpsManager.class.getName());     // Catch: Throwable -> L8
        Class<?> r104 = Integer.TYPE;     // Catch: Throwable -> L8
        if (((Integer) r103.getMethod("checkOpNoThrow", new Class[]{r104, r104, String.class}).invoke(r100, new Object[]{Integer.valueOf(((Integer) r103.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(r102), r111})).intValue() == 0) goto L11;
        return false;
    L11:
        return true;
    L12:
        return true;
    }
}
