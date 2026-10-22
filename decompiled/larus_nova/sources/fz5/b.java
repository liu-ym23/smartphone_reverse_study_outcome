package fz5;

import android.app.Application;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.timon_monitor_impl.MonitorLifecycleServiceImpl;
import com.bytedance.timon_monitor_impl.call.stastics.ApiStatisticsEventHandler;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import jz5.e;
import jz5.f;
import jz5.g;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f479388a;

    /* JADX INFO: loaded from: classes19.dex */
    public interface a {
        void onCallback();
    }

    /* JADX INFO: renamed from: fz5.b$b, reason: collision with other inner class name */
    public interface InterfaceC5970b {
        void a();

        void b();

        Application getContext();

        String getDeviceId();
    }

    public interface c {
        void a();
    }

    public interface d {
        boolean a(PrivacyEvent r100);
    }

    public b() {
    }

    public void d(MonitorLifecycleServiceImpl.i r100, MonitorLifecycleServiceImpl.j r101) {
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public void g(ApiStatisticsEventHandler r100) {
    }

    public void h(MonitorLifecycleServiceImpl.h r100) {
    }

    public void i(lz5.a r100) {
    }

    public void j() {
    }

    public void setAppLog(jz5.a r100) {
    }

    public void setEventMonitor(jz5.c r100) {
    }

    public void setExceptionMonitor(jz5.d r100) {
    }

    public void setLogger(e r100) {
    }

    public void setRuleEngine(f r100) {
    }

    public void setStore(g r100) {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class b() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.bytedance.helios.sdk.HeliosEnvImpl");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.bytedance.helios.sdk.HeliosEnvImpl");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.bytedance.helios.sdk.HeliosEnvImpl");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.bytedance.helios.sdk.HeliosEnvImpl");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.bytedance.helios.sdk.HeliosEnvImpl");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.bytedance.helios.sdk.HeliosEnvImpl");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.bytedance.helios.sdk.HeliosEnvImpl");
    }

    public static b c() {
        if (f479388a != null) goto L18;
        monitor-enter(b.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f479388a == null) goto L21;
    L12:
        monitor-exit(b.class);     // Catch: Throwable -> L14
        goto L18
    L21:
        Class r100 = b();     // Catch: Exception -> L10 Throwable -> L14
        b r101 = (b) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(r100, new Object[0]);     // Catch: Exception -> L10 Throwable -> L14
    L11:
        f479388a = r101;     // Catch: Throwable -> L14
        goto L12
    L10:
        r101 = new b();     // Catch: Throwable -> L14
    L18:
        return f479388a;
    }
}
