package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService;

/* JADX INFO: loaded from: classes38.dex */
public class NetTrafficManager {
    private IDownloadNetTrafficManagerService service;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class ConnectionClassManagerHolder {
        public static final NetTrafficManager instance = null;

        private ConnectionClassManagerHolder() {
        }

        static {
            instance = new NetTrafficManager(null);
        }
    }

    public interface NetworkStateChangeListener {
        void onBandwidthStateChange(NetworkQuality r100);
    }

    public NetworkQuality getCurrentNetworkQuality() {
        return this.service.getCurrentNetworkQuality();
    }

    public double getDownloadKBitsPerSecond() {
        return this.service.getDownloadKBitsPerSecond();
    }

    public double getRealTimeSpeed() {
        return this.service.getRealTimeSpeed();
    }

    public long getTaskRunningTime() {
        return this.service.getTaskRunningTime();
    }

    public void reset() {
        this.service.reset();
    }

    private NetTrafficManager() {
        this.service = (IDownloadNetTrafficManagerService) DownloadServiceManager.getService(IDownloadNetTrafficManagerService.class);
    }

    public static NetTrafficManager getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    public /* synthetic */ NetTrafficManager(AnonymousClass1 r100) {
        this();
    }

    public NetworkQuality register(NetworkStateChangeListener r100) {
        return this.service.register(r100);
    }

    public void remove(NetworkStateChangeListener r100) {
        this.service.remove(r100);
    }

    public void addBandwidth(long r100, long r101) {
        this.service.addBandwidth(r100, r101);
    }
}
