package com.ss.android.socialbase.downloader.service;

import androidx.camera.video.AudioStats;
import com.ss.android.socialbase.downloader.network.NetTrafficManager;
import com.ss.android.socialbase.downloader.network.NetworkQuality;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadNetTrafficManagerService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadNetTrafficManagerService implements IDownloadNetTrafficManagerService {
        public DefaultDownloadNetTrafficManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void addBandwidth(long r100, long r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public double getDownloadKBitsPerSecond() {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public double getRealTimeSpeed() {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public long getTaskRunningTime() {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void remove(NetTrafficManager.NetworkStateChangeListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public void reset() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public NetworkQuality getCurrentNetworkQuality() {
            return NetworkQuality.UNKNOWN;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadNetTrafficManagerService
        public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r100) {
            return NetworkQuality.UNKNOWN;
        }
    }

    void addBandwidth(long r100, long r101);

    NetworkQuality getCurrentNetworkQuality();

    double getDownloadKBitsPerSecond();

    double getRealTimeSpeed();

    long getTaskRunningTime();

    NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r100);

    void remove(NetTrafficManager.NetworkStateChangeListener r100);

    void reset();
}
