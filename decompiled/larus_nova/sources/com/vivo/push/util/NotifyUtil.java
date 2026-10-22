package com.vivo.push.util;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public class NotifyUtil {
    private static BaseNotifyDataAdapter sNotifyData = null;
    private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static BaseNotifyLayoutAdapter sNotifyLayout = null;
    private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    public NotifyUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_vivo_push_util_NotifyUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context r100) {
        initAdapter(r100);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context r100) {
        initAdapter(r100);
        return sNotifyLayout;
    }

    private static synchronized void initAdapter(Context r100) {
        monitor-enter(NotifyUtil.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (sNotifyData != null) goto L8;
        BaseNotifyDataAdapter r101 = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new k());     // Catch: Throwable -> L12
        sNotifyData = r101;     // Catch: Throwable -> L12
        r101.init(r100);     // Catch: Throwable -> L12
    L8:
        if (sNotifyLayout != null) goto L10;
        BaseNotifyLayoutAdapter r102 = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new l());     // Catch: Throwable -> L12
        sNotifyLayout = r102;     // Catch: Throwable -> L12
        r102.init(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(NotifyUtil.class);
    }

    private static Object getObjectByReflect(String r100, Object r101) {
        Object r102 = null;
        Class r103 = INVOKESTATIC_com_vivo_push_util_NotifyUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: Exception -> L5
    L6:
        if (r103 != null) goto L14;
    L10:
        if (r102 != null) goto L13;
        return r101;
    L13:
        return r102;
    L14:
        r102 = r103.newInstance();     // Catch: Exception -> L9
    L5:
        r103 = null;
        goto L6
    }
}
