package w4a;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.animax.service.IAnimaXService;
import com.lynx.animax.service.IAutoRegisterAnimaXService;
import com.lynx.animax.util.AnimaXLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f558276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f558277c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<e, Map<Class<? extends IAnimaXService>, IAnimaXService>> f558278a;

    static {
        f558277c = new String[]{"com.lynx.animax.service.AnimaXFrescoImageService", "com.lynx.animax.monitor.common.AnimaXCommonMonitorService"};
    }

    public static a b() {
        if (f558276b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f558276b != null) goto L9;
        f558276b = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f558276b;
    }

    public a() {
        ConcurrentHashMap r100 = new ConcurrentHashMap();
        this.f558278a = r100;
        r100.put(e.f558281b, new ConcurrentHashMap());
        String[] r101 = f558277c;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L13;
        String r104 = r101[r103];
        Class r105 = a(r104);     // Catch: Exception -> L10
        if (IAutoRegisterAnimaXService.class.isAssignableFrom(r105) == true) goto L8;
        AnimaXLog.d("AnimaXServiceCenter", "Class " + r104 + " does not implement IAutoRegisterAnimaXService");     // Catch: Exception -> L10
    L12:
        r103 = r103 + 1;
        goto L3
    L8:
        IAutoRegisterAnimaXService r106 = (IAutoRegisterAnimaXService) r105.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L10
        c(r106.getAutoRegisterServiceScope(), r106.getServiceClass(), r106);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        AnimaXLog.a("AnimaXServiceCenter", "Failed to auto-register service " + r104 + ": " + e.toString());
        goto L12
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

    public final void c(e r100, Class<? extends IAnimaXService> r101, IAnimaXService r102) {
        Map r103 = (Map) ((ConcurrentHashMap) this.f558278a).get(r100);
        if (r103 != null) goto L5;
        r103 = new ConcurrentHashMap();
        ((ConcurrentHashMap) this.f558278a).put(r100, r103);
    L5:
        boolean r104 = r103.containsKey(r101);
        if (r104 == true) goto L8;
        r103.put(r101, r102);
    L8:
        AnimaXLog.b("AnimaXServiceCenter", String.format("Register service %s with instance %s in scope %s, result: %s", new Object[]{r101.getSimpleName(), r102, r100, Boolean.valueOf(!r104)}));
    }
}
