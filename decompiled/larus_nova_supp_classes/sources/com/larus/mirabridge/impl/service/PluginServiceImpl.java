package com.larus.mirabridge.impl.service;

import al9.a;
import android.util.EventsUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.bean.PluginLoadResult;
import com.larus.mirabridge.api.plugin.service.IPluginInternalService;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.larus.mirabridge.api.pluginservice.ITTOfficePluginService;
import com.larus.mirabridge.impl.LoadingManager;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.SingletonProvider;
import fl9.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\fH\u0016J\u001c\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\fH\u0016J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e\"\u0004\b\u0000\u0010\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160\f2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u001a\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0015H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0016J(\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020)0(\"\u0004\b\u0000\u0010\u00162\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160\fH\u0016J\u0012\u0010*\u001a\u0004\u0018\u00010\u001e2\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010,\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0007H\u0016J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u00100\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\u0007H\u0002J\u0012\u00101\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u00062"}, d2 = {"Lcom/larus/mirabridge/impl/service/PluginServiceImpl;", "Lcom/larus/mirabridge/api/plugin/service/IPluginService;", "<init>", "()V", "declare", "Lcom/larus/mirabridge/api/plugin/service/IPluginInternalService;", "TAG", XmlPullParser.NO_NAMESPACE, "count", XmlPullParser.NO_NAMESPACE, "pluginMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/larus/mirabridge/api/bean/PluginInfo;", "getPluginMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "activatePluginMap", "getActivatePluginMap", "getPluginPageNameSet", XmlPullParser.NO_NAMESPACE, "isSPIAvailable", XmlPullParser.NO_NAMESPACE, "T", "pluginService", "deactivateSPIService", XmlPullParser.NO_NAMESPACE, "startPluginListActivity", "activity", "Landroid/app/Activity;", "getPlugin", "Lcom/larus/mirabridge/api/plugin/IPluginLoadTask;", "clz", "silent", "getPluginByName", "pluginPackageName", "loadPluginNew", "pluginLoadBuilder", "Lcom/larus/mirabridge/api/bean/PluginLoadBuilder$PluginLoadConfig;", "bindPluginNew", "bindService", "Lkotlin/Pair;", "Lcom/larus/mirabridge/api/bean/PluginLoadResult;", "loadLibrary", "soName", "deletePluginFile", "preloadLibrary", "isPluginReady", "isPlugin", "getSoOwner", "unInstallPlugin", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class PluginServiceImpl implements IPluginService {
    public final IPluginInternalService a;
    public final String b;
    public final ConcurrentHashMap<Class<?>, a<?>> c;
    public final ConcurrentHashMap<Class<?>, a<?>> d;

    @Override // com.larus.mirabridge.api.plugin.service.IPluginService
    public final Set<String> b() {
        Collection<a<?>> r0 = this.c.values();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(((a) r2.next()).a);
        goto L4
    L6:
        Set<String> r3 = CollectionsKt.toSet(r1);
        FLogger.a.d(this.b, "插件包名列表是:" + r3);
        return r3;
    }

    public PluginServiceImpl() {
        this.a = (IPluginInternalService) ServiceManager.get().getService(IPluginInternalService.class);
        this.b = "PluginLoadManager";
        ConcurrentHashMap<Class<?>, a<?>> r0 = new ConcurrentHashMap();
        this.c = r0;
        this.d = new ConcurrentHashMap();
        r0.put(IDoraPluginService.class, new a("com.larus.mira.dora", IDoraPluginService.class, "com.larus.mira.dora.DoraPluginServiceImpl", false));
        r0.put(ITTOfficePluginService.class, new a("com.bytedance.ee.plugin.ttoffice", ITTOfficePluginService.class, "com.bytedance.ee.plugin.ttoffice.TTOfficePluginServiceImpl", false));
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginService
    public final ConcurrentHashMap<Class<?>, a<?>> d() {
        return this.c;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class e(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
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
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
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

    @Override // com.larus.mirabridge.api.plugin.service.IPluginService
    public final void a(PluginLoadBuilder.c r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginLoadBuilder");
        Lazy r0 = LoadingManager.a;
        LoadingManager.e(r2);
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginService
    public <T> Pair<Boolean, PluginLoadResult> bindService(Class<T> r9) {
        Intrinsics.checkNotNullParameter(r9, "clz");
        if (r9.isInterface() == true) goto L6;
        FLogger.a.i(this.b, "bindService not interface " + r9);
        return new Pair(Boolean.FALSE, PluginLoadResult.NOT_INTERFACE);
    L6:
        a<?> r3 = this.c.get(r9);
        if (r3 != null) goto L10;
        FLogger.a.i(this.b, "bindService not register " + r9);
        return new Pair(Boolean.FALSE, PluginLoadResult.NOT_REGISTER);
    L10:
        a<?> r4 = this.d.get(r9);
        if (r4 != null) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == false) goto L37;
        FLogger.a.i(this.b, "bindService already bind " + r9);
        return new Pair(Boolean.TRUE, PluginLoadResult.SUCCESS);
    L37:
        Class r6 = e(r3.c);     // Catch: ClassNotFoundException -> L35
        if (r6 == null) goto L25;
        Constructor<T> r7 = r6.getDeclaredConstructor(new Class[0]);     // Catch: ClassNotFoundException -> L35
        if (r7 == null) goto L25;
        T r8 = r7.newInstance(new Object[0]);     // Catch: ClassNotFoundException -> L35
    L26:
        if (r8 != null) goto L30;
        FLogger.a.i(this.b, "bindService constructor error " + r9);     // Catch: ClassNotFoundException -> L35
        return new Pair(Boolean.FALSE, PluginLoadResult.SERVICE_CONSTRUCTOR_ERROR);
    L30:
        if (r9.isInstance(r8) == true) goto L33;
        FLogger.a.i(this.b, "bindService type error " + r9);     // Catch: ClassNotFoundException -> L35
        return new Pair(Boolean.FALSE, PluginLoadResult.SERVICE_TYPE_ERROR);
    L33:
        ServiceManager.get().bind(r9, new SingletonProvider(new b(r8)));     // Catch: ClassNotFoundException -> L35
        String r1 = r3.a;     // Catch: ClassNotFoundException -> L35
        Class<?> r2 = r3.b;     // Catch: ClassNotFoundException -> L35
        String r10 = r3.c;     // Catch: ClassNotFoundException -> L35
        Intrinsics.checkNotNullParameter(r1, "packageName");     // Catch: ClassNotFoundException -> L35
        Intrinsics.checkNotNullParameter(r2, "iService");     // Catch: ClassNotFoundException -> L35
        Intrinsics.checkNotNullParameter(r10, "serviceImpl");     // Catch: ClassNotFoundException -> L35
        a<?> r11 = new a(r1, r2, r10, true);     // Catch: ClassNotFoundException -> L35
        this.c.put(r9, r11);     // Catch: ClassNotFoundException -> L35
        this.d.put(r9, r11);     // Catch: ClassNotFoundException -> L35
        FLogger.a.i(this.b, "bindService success " + r9);     // Catch: ClassNotFoundException -> L35
        return new Pair(Boolean.TRUE, PluginLoadResult.SUCCESS);
    L25:
        r8 = null;
    L35:
        FLogger.a.i(this.b, "bindService class not found " + r9);
        return new Pair(Boolean.FALSE, PluginLoadResult.SERVICE_CLASS_NOT_FOUND);
    L13:
        if (r4.d != true) goto L15;
        r5 = true;
        goto L16
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginService
    public final <T> boolean c(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginService");
        a<?> r4 = this.d.get(r3);
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.d != true) goto L9;
        return true;
    L9:
        return false;
    }
}
