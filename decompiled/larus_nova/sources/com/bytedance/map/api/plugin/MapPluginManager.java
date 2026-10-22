package com.bytedance.map.api.plugin;

import android.content.Context;
import android.os.SystemClock;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.bytedance.map.api.service.MapHostServiceLoader;

/* JADX INFO: loaded from: classes21.dex */
public class MapPluginManager {
    private static final String TAG = "MapPluginManager";
    private static boolean sHasInstalledAndLoaded;
    private Context mContext;
    private final MapHostServiceLoader mHostServiceLoader;
    private IMapPluginSpiService mPluginSpiService;

    /* JADX INFO: renamed from: com.bytedance.map.api.plugin.MapPluginManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class MonitorPluginActionListener implements MapPluginActionListener {
        private boolean mHasReadyResult;
        private final MapPluginActionListener mListener;
        private final long mReadyStartTime;

        @Override // com.bytedance.map.api.plugin.MapPluginActionListener
        public void onFail() {
            MapLogger.i(MapPluginManager.TAG, "onFail: readyDuration=" + MapPluginManager.access$100(this.mReadyStartTime));
            uploadReady(false);
            MapPluginActionListener r100 = this.mListener;
            if (r100 == null) goto L6;
            r100.onFail();
            return;
        }

        @Override // com.bytedance.map.api.plugin.MapPluginActionListener
        public void onSuccess() {
            MapLogger.i(MapPluginManager.TAG, "onSuccess: readyDuration=" + MapPluginManager.access$100(this.mReadyStartTime));
            uploadReady(true);
            MapPluginManager.access$202(true);
            MapPluginActionListener r100 = this.mListener;
            if (r100 == null) goto L6;
            r100.onSuccess();
            return;
        }

        private MonitorPluginActionListener(MapPluginActionListener r100) {
            this.mListener = r100;
            this.mReadyStartTime = SystemClock.elapsedRealtime();
        }

        private void uploadReady(boolean r100) {
            if (this.mHasReadyResult == false) goto L5;
            return;
        L5:
            this.mHasReadyResult = true;
            MapPluginManager.access$300(r100, this.mReadyStartTime);
        }

        public /* synthetic */ MonitorPluginActionListener(MapPluginActionListener r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private void initPluginService() {
        MapLogger.i(TAG, "initPluginService: use host plugin spi service");
        IMapPluginSpiService r100 = this.mHostServiceLoader.getMapPluginSpiService();
        this.mPluginSpiService = r100;
        if (r100 != null) goto L5;
        MapLogger.i(TAG, "initPluginService: host plugin spi service is null");
        return;
    L5:
        MapLogger.i(TAG, "initPluginService: host plugin spi service=".concat(r100.getClass().getName()));
    }

    public boolean isMapPluginInstalled() {
        IMapPluginSpiService r100 = this.mPluginSpiService;
        if (r100 == null) goto L6;
        boolean r101 = r100.isPluginReady();
        MapLogger.i(TAG, "isMapPluginInstalled: spi ready=" + r101);
        return r101;
    L6:
        MapLogger.i(TAG, "isMapPluginInstalled: plugin service is null");
        return false;
    }

    public MapPluginManager(Context r100) {
        this.mHostServiceLoader = new MapHostServiceLoader();
        this.mContext = r100;
        initPluginService();
    }

    public static /* synthetic */ long access$100(long r100) {
        return getDuration(r100);
    }

    public static /* synthetic */ boolean access$202(boolean r100) {
        sHasInstalledAndLoaded = r100;
        return r100;
    }

    private static long getDuration(long r100) {
        if (r100 > 0) goto L7;
        return -1;
    L7:
        return SystemClock.elapsedRealtime() - r100;
    }

    private void onListenerFail(MapPluginActionListener r100) {
        if (r100 == null) goto L5;
        r100.onFail();
        return;
    }

    private void onListenerSuccess(MapPluginActionListener r100) {
        if (r100 == null) goto L5;
        r100.onSuccess();
        return;
    }

    public void installAndLoadMapPlugin(MapPluginActionListener r100) {
        long r101 = SystemClock.elapsedRealtime();
        IMapPluginSpiService r102 = this.mPluginSpiService;
        if (r102 != null) goto L6;
        MapLogger.i(TAG, "installAndLoadMapPlugin failed: plugin service is null");
        uploadPluginReady(false, r101);
        onListenerFail(r100);
        return;
    L6:
        boolean r103 = r102.isPluginReady();
        MapLogger.i(TAG, "installAndLoadMapPlugin: cached=" + sHasInstalledAndLoaded + ", spiReady=" + r103 + ", service=" + this.mPluginSpiService.getClass().getName());
        if (sHasInstalledAndLoaded == true) goto L12;
        if (r103 == true) goto L12;
        MapLogger.i(TAG, "installAndLoadMapPlugin: ensure plugin ready start");
        this.mPluginSpiService.ensurePluginReady(this.mContext, new MonitorPluginActionListener(r100, null));
        return;
    L12:
        onListenerSuccess(r100);
        sHasInstalledAndLoaded = true;
    }

    public static /* synthetic */ void access$300(boolean r100, long r101) {
        uploadPluginReady(r100, r101);
    }

    private static void uploadPluginReady(boolean r100, long r101) {
        long r102 = getDuration(r101);
        MapLogger.i(TAG, "uploadReady: success=" + r100 + ", duration=" + r102);
        MapMonitor.uploadPluginState(MapMonitorConst.PLUGIN_READY, r100, r102);
    }
}
