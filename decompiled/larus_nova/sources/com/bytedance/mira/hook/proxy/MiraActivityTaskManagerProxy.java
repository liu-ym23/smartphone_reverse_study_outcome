package com.bytedance.mira.hook.proxy;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import com.bytedance.mira.util.MethodUtils;
import com.bytedance.mira.util.OSUtil;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class MiraActivityTaskManagerProxy extends MiraActivityManagerProxy {
    private static final String TAG = "MiraActivityTaskManagerProxy";

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.mira.hook.proxy.MiraActivityManagerProxy, com.bytedance.mira.hook.MiraHook
    public void onHookInstall() {
    L15:
        e = move-exception;
        MiraLogger.e(MiraLogger.TAG_INIT, "MiraActivityTaskManagerProxy hook failed.", e);
        return;
    L4:
        if (OSUtil.isAndroidQHigher() == false) goto L6;
        Object r100 = FieldUtils.readStaticField(INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityTaskManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityTaskManager"), "IActivityTaskManagerSingleton");     // Catch: Exception -> L15
    L8:
        if (INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityTaskManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.util.Singleton").isInstance(r100) == false) goto L20;
        Object r101 = FieldUtils.readField(r100, "mInstance");     // Catch: Exception -> L15
        if (r101 != null) goto L12;
        r101 = MethodUtils.invokeMethod(r100, MonitorConstants.CONNECT_TYPE_GET, new Object[0]);     // Catch: Exception -> L15
    L12:
        if (r101 == null) goto L21;
        setTarget(r101);     // Catch: Exception -> L15
        FieldUtils.writeField(r100, "mInstance", ProxyHelper.createProxy(r101, this));     // Catch: Exception -> L15
        MiraLogger.w(MiraLogger.TAG_INIT, "MiraActivityTaskManagerProxy.hook");     // Catch: Exception -> L15
        return;
    L21:
        return;
    L20:
        return;
    L6:
        r100 = null;
        goto L8
    }

    public MiraActivityTaskManagerProxy() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_mira_hook_proxy_MiraActivityTaskManagerProxy_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
