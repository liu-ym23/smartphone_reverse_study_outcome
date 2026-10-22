package com.ss.android.ugc.aweme.base.common;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.base.api.ILiveBusinessBaseService;
import el9.a;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import wm0.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/base/common/ServiceCache;", "", "<init>", "()V", "livebusiness_base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ServiceCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f449996a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f449997b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ServiceCache f449998c = null;

    private ServiceCache() {
    }

    static {
        f449998c = new ServiceCache();
        f449996a = LazyKt.lazy(ServiceCache$serviceMap$2.INSTANCE);
        f449997b = LazyKt.lazy(ServiceCache$sdkServiceMap$2.INSTANCE);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static IBaseService b(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        IBaseService r101 = (IBaseService) ((ConcurrentHashMap) f449996a.getValue()).get(r100);
        if (r101 != null) goto L26;
        f449998c.getClass();
        Object r102 = null;
        ServiceImpl r103 = (ServiceImpl) r100.getAnnotation(ServiceImpl.class);     // Catch: Exception -> L13
        if (r103 == null) goto L22;
        String r104 = r103.value();     // Catch: Exception -> L13
        if (r104 == null) goto L22;
        Object r105 = a(r104).newInstance();     // Catch: Exception -> L13
        if (r105 == null) goto L22;
        r102 = r100.cast(r105);     // Catch: Exception -> L13
    L22:
        IBaseService r106 = (IBaseService) r102;
        if (r106 == null) goto L25;
        f449998c.getClass();
        ((ConcurrentHashMap) f449996a.getValue()).put(r100, r106);
        r101 = r106;
        goto L26
    L25:
        DynamicProxy.f449995a.getClass();
        Intrinsics.checkNotNullParameter(r100, "clz");
        r101 = (IBaseService) Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, new DynamicProxy$get$1());
    L13:
        e = move-exception;
        if ((!Intrinsics.areEqual(r100, ILiveBusinessBaseService.class)) == false) goto L22;
        b r107 = ((ILiveBusinessBaseService) IBaseServiceKt.a(ILiveBusinessBaseService.class)).getLiveMonitorService();
        if (r107 == null) goto L19;
        JSONObject r108 = new JSONObject();
        r108.put("clazz", r100.getName());
        r108.put("trace", new Throwable());
        Unit r109 = Unit.INSTANCE;
        r107.monitorEvent("ttlive_live_servicecache_generatedAnnotation_error", r108, null, null);
    L19:
        pm0.a r110 = ((ILiveBusinessBaseService) IBaseServiceKt.a(ILiveBusinessBaseService.class)).getALogService();
        if (r110 == null) goto L22;
        r110.e("ServiceCache:getGeneratedAnnotation_error", "clazz(" + r100.getName() + ") trace(" + new Throwable().getStackTrace() + ')', e);
    L26:
        if (r101 == null) goto L29;
        return r101;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }
}
