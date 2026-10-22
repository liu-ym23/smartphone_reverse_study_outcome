package ve4;

import ca4.c;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.manager.BdpRuntimeProvider;
import com.bytedance.bdp.bdpbase.service.BdpServiceImplInfo;
import com.bytedance.bdp.bdpbase.service.IBdpService;
import com.bytedance.caijing.sdk.infra.base.core.di.CJPluginAbilityService;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f554342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BdpRuntimeProvider f554343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IBdpService> f554344c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IBdpService> f554345d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, IBdpService> f554346e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f554347f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C7990a f554348g = null;

    /* JADX INFO: renamed from: ve4.a$a, reason: collision with other inner class name */
    public static final class C7990a {
        public C7990a() {
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter("CJServiceManager", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
        }
    }

    public a() {
    }

    static {
        f554342a = new a();
        f554343b = new BdpRuntimeProvider();
        f554344c = new ConcurrentHashMap();
        f554345d = new ConcurrentHashMap();
        f554346e = new ConcurrentHashMap();
        f554347f = true;
        f554348g = new C7990a();
    }

    public static ICJService a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (f554347f == true) goto L12;
        ICJService r101 = (ICJService) BdpManager.getInst().getService(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if (Proxy.isProxyClass(r101.getClass()) == false) goto L13;
        C7990a r102 = f554348g;
        String r103 = "[getService] " + r100.getName() + " instance is proxy";
        r102.getClass();
        Intrinsics.checkNotNullParameter("CJServiceManager", "tag");
        Intrinsics.checkNotNullParameter(r103, "msg");
        return r101;
    L13:
        return r101;
    L12:
        return c(r100);
    }

    public static ICJService c(Class r100) {
        String r101 = r100.getName();
        ConcurrentHashMap<String, IBdpService> r102 = f554346e;
        IBdpService r103 = r102.get(r101);
        if (r103 != null) goto L5;
        BdpRuntimeProvider r104 = f554343b;
        ConcurrentHashMap<String, IBdpService> r105 = f554344c;
        ICJService r106 = b(r100, r104, r105);
        if (r106 == null) goto L10;
        r102.put(r101, r106);
        return r106;
    L10:
        CJPluginAbilityService r107 = (CJPluginAbilityService) b(CJPluginAbilityService.class, r104, r105);
        if (r107 == null) goto L20;
        c r108 = r107.getPluginRuntimeProvider();
        if (r108 == null) goto L19;
        ICJService r109 = b(r100, r108, f554345d);
        if (r109 == null) goto L18;
        r102.put(r101, r109);
        return r109;
    L18:
        f554348g.a("serviceImpl " + r101 + " not in pluginProvider");
        return null;
    L19:
        f554348g.a("pluginProvider is null");
        return null;
    L20:
        f554348g.a("Not PluginMode cjPluginAbilityService is null");
        return null;
    L5:
        return (ICJService) r103;
    }

    public static ICJService d(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ICJService r101 = a(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new Error("CJServiceManager getServiceImplFail: " + r100.getName() + " . Check if necessary caijing components are missing.");
    }

    public static ICJService b(Class r100, c r101, ConcurrentHashMap r102) {
        Map<String, BdpServiceImplInfo> r103 = r101.getServiceClassMap();
        if (r103 != null) goto L6;
        f554348g.a("serviceClassMap null, return null");
        return null;
    L6:
        BdpServiceImplInfo r104 = r103.get(r100.getName());
        if (r104 != null) goto L43;
    L39:
        return null;
    L43:
        String r105 = r104.getServiceName();     // Catch: Exception -> L36
        Object r106 = r102.get(r105);     // Catch: Exception -> L36
        if (r106 != null) goto L11;
        monitor-enter(r104);     // Catch: Exception -> L36
        IBdpService r107 = (IBdpService) r102.get(r105);     // Catch: Throwable -> L33
        if (r107 == null) goto L18;
        ICJService r108 = (ICJService) r107;     // Catch: Throwable -> L33
        monitor-exit(r104);     // Catch: Exception -> L36
        return r108;
    L18:
        f554348g.a("createNewInstance: " + r105);     // Catch: Throwable -> L33
        a r109 = f554342a;     // Catch: Throwable -> L33
        Class<?> r110 = r104.getService();     // Catch: Throwable -> L33
        r109.getClass();     // Catch: Throwable -> L33
        if (r110 != null) goto L41;
    L25:
        Object r111 = null;
    L26:
        if (r111 == null) goto L30;
        r102.put(r105, (ICJService) r111);     // Catch: Throwable -> L33
        ICJService r112 = (ICJService) r111;     // Catch: Throwable -> L33
        monitor-exit(r104);     // Catch: Exception -> L36
        return r112;
    L30:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L33
        monitor-exit(r104);     // Catch: Exception -> L36
    L38:
        f554348g.a("getServiceInternal fail，return null");
        goto L39
    L41:
        r111 = r110.newInstance();     // Catch: Exception -> L23 Throwable -> L33
    L23:
        e = move-exception;
        f554348g.a("createNewInstance exception" + e.getMessage());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        throw th;     // Catch: Exception -> L36
    L11:
        return (ICJService) r106;
    L36:
        e = move-exception;
        f554348g.a("getServiceInternal fail, " + e.getMessage());
        goto L38
    }
}
