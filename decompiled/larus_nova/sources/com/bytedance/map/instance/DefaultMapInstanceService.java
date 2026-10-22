package com.bytedance.map.instance;

import com.bytedance.map.api.IMapService;
import com.bytedance.map.api.data.MapInfoConst;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public class DefaultMapInstanceService {
    private static final String TAG = "DefaultMapInstanceService";

    public DefaultMapInstanceService() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_map_instance_DefaultMapInstanceService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private String describeMapService(IMapService r100) {
        if (r100 != null) goto L5;
        return "null";
    L5:
        return r100.getClass().getName();
    }

    private IMapService getInstance(String r100) {
        MapLogger.i(TAG, "getInstance start: name=" + r100);
        IMapService r101 = null;
        Object r102 = INVOKESTATIC_com_bytedance_map_instance_DefaultMapInstanceService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();     // Catch: Throwable -> L12
        if ((r102 instanceof IMapService) == false) goto L6;
        r101 = (IMapService) r102;     // Catch: Throwable -> L12
    L14:
        MapLogger.i(TAG, "getInstance finish: name=" + r100 + ", service=" + describeMapService(r101));
        return r101;
    L6:
        StringBuilder r103 = new StringBuilder("getInstance invalid service: name=");     // Catch: Throwable -> L12
        r103.append(r100);     // Catch: Throwable -> L12
        r103.append(", actual=");     // Catch: Throwable -> L12
        if (r102 != null) goto L9;
        String r104 = "null";
    L10:
        r103.append(r104);     // Catch: Throwable -> L12
        MapLogger.i(TAG, r103.toString());     // Catch: Throwable -> L12
        goto L14
    L9:
        r104 = r102.getClass().getName();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        MapLogger.i(TAG, "getInstance failed: name=" + r100 + ", error=" + th.getMessage());
        th.printStackTrace();
        goto L14
    }

    public IMapService createMapService(int r100) {
        MapLogger.i(TAG, "createMapService start: mapType=" + r100);
        if (r100 != 0) goto L5;
        IMapService r101 = getInstance(MapInfoConst.AMAP_2D_CLASS_NAME);
    L12:
        MapLogger.i(TAG, "createMapService primary result: mapType=" + r100 + ", service=" + describeMapService(r101));
        if (r101 != null) goto L15;
        r101 = getInstance(MapInfoConst.BAIDU_CLASS_NAME);
        MapLogger.i(TAG, "createMapService baidu fallback result: service=" + describeMapService(r101));
    L15:
        if (r101 != null) goto L17;
        r101 = getInstance(MapInfoConst.AMAP_2D_CLASS_NAME);
        MapLogger.i(TAG, "createMapService amap2d fallback result: service=" + describeMapService(r101));
    L17:
        MapLogger.i(TAG, "createMapService finish: mapType=" + r100 + ", service=" + describeMapService(r101));
        return r101;
    L5:
        if (r100 != 1) goto L7;
        r101 = getInstance(MapInfoConst.AMAP_CLASS_NAME);
        goto L12
    L7:
        if (r100 == 4) goto L9;
        r101 = null;
        goto L12
    L9:
        r101 = getInstance(MapInfoConst.BAIDU_CLASS_NAME);
        goto L12
    }
}
