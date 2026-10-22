package com.volcengine.zeus.service;

import android.app.Service;
import android.content.ComponentName;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.Plugin;
import com.volcengine.zeus.service.server.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.volcengine.zeus.util.FieldUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class PluginService extends Service implements lqc.a {
    private static final String TAG = "PluginService";

    public class a implements InvocationHandler {
        public final /* synthetic */ PluginService a;

        public a(PluginService r1) {
            this.a = r1;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r2, Method r3, Object[] r4) throws Throwable {
            String r5 = r3.getName();
            r5.getClass();
            if (r5.equals("getForegroundServiceType") == true) goto L11;
            if (r5.equals("stopServiceToken") == true) goto L8;
            return null;
        L8:
            ServiceManager r6 = ServiceManager.getInstance();
            PluginService r7 = this.a;
            return Boolean.valueOf(r6.realStopService(new ComponentName(r7, r7.getClass().getName())));
        L11:
            return 0;
        }
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public Object createActivityManagerProxy() throws ClassNotFoundException {
        return Proxy.newProxyInstance(getClassLoader(), new Class[]{INVOKESTATIC_com_volcengine_zeus_service_PluginService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.IActivityManager")}, new a(this));
    }

    public PluginService() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_volcengine_zeus_service_PluginService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    @Override // lqc.a
    public void attach(Plugin r3) {
        attachBaseContext(ZeusTransformUtils.wrapperContext2Application(Zeus.getAppApplication(), r3.mPkgName));
        FieldUtils.writeField(this, "mActivityManager", createActivityManagerProxy());     // Catch: Exception -> L9
        FieldUtils.writeField(this, "mClassName", getClass().getName());     // Catch: Exception -> L9
        FieldUtils.writeField(this, "mApplication", Zeus.getAppApplication());     // Catch: Exception -> L9
        if (getApplicationInfo().targetSdkVersion >= 5) goto L6;
        boolean r0 = true;
    L7:
        FieldUtils.writeField(this, "mStartCompatibility", Boolean.valueOf(r0));     // Catch: Exception -> L9
        return;
    L6:
        r0 = false;
    L9:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "hook activityManager failed!", e);
    }
}
