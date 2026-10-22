package com.bytedance.bdlocation.service;

import android.content.Context;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.api.IBeaconManager;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.api.IManager;
import com.bytedance.bdlocation.api.IRegionDataCore;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.api.ITraceRouteManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.provider.DefaultBeaconProvider;
import com.bytedance.bdlocation.provider.DefaultBpeaProvider;
import com.bytedance.bdlocation.provider.DefaultRegionDataCore;
import com.bytedance.bdlocation.provider.DefaultShakeProvider;
import com.bytedance.bdlocation.provider.DefaultTraceRouteProvider;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class BDLocationExtrasService {
    private static final String AMAP_CLASS_NAME = "com.bytedance.bdlocation.amap.AMapLocationImpl";
    private static final String BEACON_CLASS_NAME = "com.bytedance.byte_beacon.BeaconManagerImpl";
    private static final String BPEA_CLASS_NAME = "com.bytedance.location_bpea.BPEAManager";
    private static final String BYTE_CLASS_NAME = "com.bytedance.bdlocation.bytelocation.ByteLocationImpl";
    private static final String BYTE_CONTINUOUS_CLASS_NAME = "com.bytedance.bdlocation.bytelocation.ByteContinuousLocationImpl";
    private static final String BYTE_FUSION_CONTINUOUS_CLASS_NAME = "com.bytedance.bdlocation.continuous.ByteFusionContinuousLocationImpl";
    private static final String GMAP_CLASS_NAME = "com.bytedance.bdlocation.glocation.GoogleLocationImpl";
    private static final String H3CORE_CLASS_NAME = "com.uber.h3core.BDLocationH3Core";
    private static final String MOCK_CLASS_NAME = "com.bytedance.bdlocation.locationmock.MockLocationImpl";
    private static final String REGION_DATA_CLASS_NAME = "com.bytedance.region_data.RegionDataCore";
    private static final String SHAKE_CLASS_NAME = "com.bytedance.bdlocation_impl.shake.ShakeManager";
    private static final String TMAP_CLASS_NAME = "com.bytedance.bdlocation.tencent.TencentLocationImpl";
    private static final String TRACEROUTE_CLASS_NAME = "com.bytedance.bdlocation.traceroute.TraceRouterCore";
    private static BaseLocate sAmapLocate;
    private static volatile IBPEALocal sBPEAManager;
    private static IBeaconManager sBeaconManager;
    private static BaseLocate sByteContinuousLocate;
    private static BaseLocate sByteFusionContinuousLocate;
    private static BaseLocate sByteLocate;
    private static BaseLocate sGmapLocate;
    private static IRegionDataCore sIRegionDataCore;
    private static BaseLocate sMockLocate;
    private static IShakeManager sShakeManager;
    private static BaseLocate sSysLocate;
    private static BaseLocate sTmapLocate;
    private static ITraceRouteManager sTraceRouteManager;

    public BDLocationExtrasService() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static synchronized BaseLocate getAmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAmapLocate != null) goto L7;
        sAmapLocate = (BaseLocate) getLocalManager(AMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sAmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    public static IBPEALocal getBPEAManager() {
        IBPEALocal r100 = sBPEAManager;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(BDLocationExtrasService.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (sBPEAManager != null) goto L13;
        if (BDLocationConfig.enableBpea() == false) goto L13;
        sBPEAManager = (IBPEALocal) getLocalManager(BPEA_CLASS_NAME);     // Catch: Throwable -> L18
    L13:
        if (sBPEAManager != null) goto L15;
        sBPEAManager = new DefaultBpeaProvider();     // Catch: Throwable -> L18
    L15:
        IBPEALocal r101 = sBPEAManager;     // Catch: Throwable -> L18
        monitor-exit(BDLocationExtrasService.class);     // Catch: Throwable -> L18
        return r101;
    }

    public static synchronized IBeaconManager getBeaconManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sBeaconManager != null) goto L8;
        sBeaconManager = (IBeaconManager) getLocalManager(BEACON_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sBeaconManager != null) goto L10;
        sBeaconManager = new DefaultBeaconProvider();     // Catch: Throwable -> L13
    L10:
        IBeaconManager r100 = sBeaconManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getByteContinuousLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteContinuousLocate != null) goto L7;
        sByteContinuousLocate = (BaseLocate) getLocalManager(BYTE_CONTINUOUS_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sByteContinuousLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getByteFusionContinuousLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteFusionContinuousLocate != null) goto L7;
        sByteFusionContinuousLocate = (BaseLocate) getLocalManager(BYTE_FUSION_CONTINUOUS_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sByteFusionContinuousLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getByteLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteLocate != null) goto L7;
        sByteLocate = (BaseLocate) getLocalManager(BYTE_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sByteLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getGmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sGmapLocate != null) goto L7;
        sGmapLocate = (BaseLocate) getLocalManager(GMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sGmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getMockLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMockLocate != null) goto L7;
        sMockLocate = (BaseLocate) getLocalManager(MOCK_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sMockLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    public static ILocate getNewAMapLocate() {
        return (ILocate) getLocalManager(AMAP_CLASS_NAME);
    }

    public static synchronized IRegionDataCore getRegionDataCore() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sIRegionDataCore != null) goto L8;
        sIRegionDataCore = (IRegionDataCore) getLocalManager(REGION_DATA_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sIRegionDataCore != null) goto L10;
        sIRegionDataCore = new DefaultRegionDataCore();     // Catch: Throwable -> L13
    L10:
        IRegionDataCore r100 = sIRegionDataCore;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    public static synchronized IShakeManager getShakeManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sShakeManager != null) goto L8;
        sShakeManager = (IShakeManager) getLocalManager(SHAKE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sShakeManager != null) goto L10;
        sShakeManager = new DefaultShakeProvider();     // Catch: Throwable -> L13
    L10:
        IShakeManager r100 = sShakeManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    private static synchronized BaseLocate getTmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTmapLocate != null) goto L7;
        sTmapLocate = (BaseLocate) getLocalManager(TMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r100 = sTmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    public static synchronized ITraceRouteManager getTraceRouteManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sTraceRouteManager != null) goto L8;
        sTraceRouteManager = (ITraceRouteManager) getLocalManager(TRACEROUTE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sTraceRouteManager != null) goto L10;
        sTraceRouteManager = new DefaultTraceRouteProvider();     // Catch: Throwable -> L13
    L10:
        ITraceRouteManager r100 = sTraceRouteManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_bdlocation_service_BDLocationExtrasService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static IBPEALocal getBPEAManagerWithTag(boolean r100) {
        if (r100 == false) goto L6;
        return new DefaultBpeaProvider();
    L6:
        return getBPEAManager();
    }

    private static IManager getLocalManager(String r100) {
        IManager r101 = null;
        IManager r102 = (IManager) INVOKESTATIC_com_bytedance_bdlocation_service_BDLocationExtrasService_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{BDLocationConfig.getContext()});     // Catch: Throwable -> L8
        Logger.d("getLocalManager:" + r100);     // Catch: Throwable -> L6
        return r102;
    L6:
        th = th;
        r101 = r102;
    L9:
        Logger.i("BDLocationExtrasService getLocalManager error：" + th.toString());
        return r101;
    L8:
        th = th;
        goto L9
    }

    private static synchronized BaseLocate getSysLocate(Context r100) {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSysLocate != null) goto L7;
        sSysLocate = new SystemBaseLocationImpl(r100);     // Catch: Throwable -> L10
    L7:
        BaseLocate r101 = sSysLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r101;
    }

    private static void setAmapLocate(BaseLocate r100) {
        sAmapLocate = r100;
    }

    private static void setByteLocate(BaseLocate r100) {
        sByteLocate = r100;
    }

    private static void setGmapLocate(BaseLocate r100) {
        sGmapLocate = r100;
    }

    public static void setShakeManager(IShakeManager r100) {
        sShakeManager = r100;
    }

    public static synchronized BaseLocate getLocate(Context r100, int r101) {
        monitor-enter(BDLocationExtrasService.class);
        switch(r101) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L5:
        BaseLocate r102 = null;
    L18:
        monitor-exit(BDLocationExtrasService.class);
        return r102;
    L6:
        r102 = getByteFusionContinuousLocate();     // Catch: Throwable -> L15
    L20:
        goto L18
    L7:
        r102 = getByteContinuousLocate();     // Catch: Throwable -> L15
        goto L20
    L8:
        r102 = getTmapLocate();     // Catch: Throwable -> L15
        goto L20
    L9:
        r102 = getMockLocate();     // Catch: Throwable -> L15
        goto L20
    L10:
        r102 = getByteLocate();     // Catch: Throwable -> L15
        goto L20
    L11:
        r102 = getGmapLocate();     // Catch: Throwable -> L15
        goto L20
    L12:
        r102 = getAmapLocate();     // Catch: Throwable -> L15
        goto L20
    L13:
        r102 = getSysLocate(r100);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }
}
