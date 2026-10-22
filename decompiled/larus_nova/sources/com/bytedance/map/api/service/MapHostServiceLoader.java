package com.bytedance.map.api.service;

import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.plugin.IMapPluginSpiService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class MapHostServiceLoader {
    private static final String AWEME_MAP_HOST_SERVICE_PROVIDER_CLASS_NAME = "com.bytedance.map.aweme.plugin.MapHostServiceProvider";
    private static final String TAG = "MapHostServiceLoader";
    private final IMapHostServiceProvider mProvider;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private IMapHostServiceProvider createHostServiceProvider() {
        Class r100 = INVOKESTATIC_com_bytedance_map_api_service_MapHostServiceLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(AWEME_MAP_HOST_SERVICE_PROVIDER_CLASS_NAME);     // Catch: Throwable -> L9
        Object r101 = r100.newInstance();     // Catch: Throwable -> L9
        if ((r101 instanceof IMapHostServiceProvider) == true) goto L6;
        MapLogger.i(TAG, "createHostServiceProvider failed: invalid provider=".concat(r100.getName()));     // Catch: Throwable -> L9
        return null;
    L6:
        return (IMapHostServiceProvider) r101;
    L9:
        th = move-exception;
        MapLogger.i(TAG, "createHostServiceProvider failed: provider=com.bytedance.map.aweme.plugin.MapHostServiceProvider, error=" + th.getMessage());
        return null;
    }

    public IMapInstanceService getMapInstanceService() {
        IMapHostServiceProvider r100 = this.mProvider;
        if (r100 != null) goto L5;
        IMapInstanceService r101 = null;
    L6:
        StringBuilder r102 = new StringBuilder("getMapInstanceService: hasProvider=");
        boolean r103 = true;
        if (this.mProvider == null) goto L9;
        boolean r104 = true;
    L10:
        r102.append(r104);
        r102.append(", hasService=");
        if (r101 != null) goto L14;
        r103 = false;
    L14:
        r102.append(r103);
        MapLogger.i(TAG, r102.toString());
        return r101;
    L9:
        r104 = false;
        goto L10
    L5:
        r101 = r100.getMapInstanceService();
        goto L6
    }

    public IMapPluginSpiService getMapPluginSpiService() {
        IMapHostServiceProvider r100 = this.mProvider;
        if (r100 != null) goto L5;
        IMapPluginSpiService r101 = null;
    L6:
        StringBuilder r102 = new StringBuilder("getMapPluginSpiService: hasProvider=");
        boolean r103 = true;
        if (this.mProvider == null) goto L9;
        boolean r104 = true;
    L10:
        r102.append(r104);
        r102.append(", hasService=");
        if (r101 != null) goto L14;
        r103 = false;
    L14:
        r102.append(r103);
        MapLogger.i(TAG, r102.toString());
        return r101;
    L9:
        r104 = false;
        goto L10
    L5:
        r101 = r100.getMapPluginSpiService();
        goto L6
    }

    public MapHostServiceLoader() {
        this.mProvider = createHostServiceProvider();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_map_api_service_MapHostServiceLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
