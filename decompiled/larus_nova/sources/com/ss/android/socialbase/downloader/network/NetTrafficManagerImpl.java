package com.ss.android.socialbase.downloader.network;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes38.dex */
public class NetTrafficManagerImpl {
    private static final long BANDWIDTH_LOWER_BOUND = 3;
    private static final int BYTES_TO_BITS = 8;
    private static final double DEFAULT_DECAY_CONSTANT = 0.05d;
    private static final int DEFAULT_GOOD_BANDWIDTH = 2000;
    private static final long DEFAULT_HYSTERESIS_PERCENT = 20;
    private static final int DEFAULT_MODERATE_BANDWIDTH = 550;
    private static final int DEFAULT_POOR_BANDWIDTH = 150;
    private static final double DEFAULT_SAMPLES_TO_QUALITY_CHANGE = 5.0d;
    private static final double HYSTERESIS_BOTTOM_MULTIPLIER = 0.8d;
    private static final double HYSTERESIS_TOP_MULTIPLIER = 1.25d;
    private final AtomicReference<NetworkQuality> currentNetworkQuality;
    private volatile boolean initiateStateChange;
    private final List<NetTrafficManager.NetworkStateChangeListener> listenerList;
    private final ExponentialGeometricAverage mDownloadBandwidth;
    private AtomicReference<NetworkQuality> nextNetworkQuality;
    private int sampleCount;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.NetTrafficManagerImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = null;

        static {
            int[] r100 = new int[NetworkQuality.values().length];
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality = r100;
            r100[NetworkQuality.POOR.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.MODERATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.GOOD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[NetworkQuality.EXCELLENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class ConnectionClassManagerHolder {
        public static final NetTrafficManagerImpl instance = null;

        private ConnectionClassManagerHolder() {
        }

        static {
            instance = new NetTrafficManagerImpl(null);
        }
    }

    public synchronized NetworkQuality getCurrentNetworkQuality() {
        monitor-enter(this);
        ExponentialGeometricAverage r100 = this.mDownloadBandwidth;     // Catch: Throwable -> L15
        if (r100 != null) goto L18;
        NetworkQuality r101 = NetworkQuality.UNKNOWN;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r101;
    L18:
        NetworkQuality r102 = mapBandwidthQuality(r100.getAverage());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L15
        return NetworkQuality.UNKNOWN;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized double getDownloadKBitsPerSecond() {
        monitor-enter(this);
        ExponentialGeometricAverage r100 = this.mDownloadBandwidth;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        double r101 = -1.0d;
    L7:
        monitor-exit(this);
        return r101;
    L6:
        r101 = r100.getAverage();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void notifyListeners() {
        int r100 = this.listenerList.size();     // Catch: Throwable -> L6
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L12;
        ((NetTrafficManager.NetworkStateChangeListener) ListProtector.get(this.listenerList, r101)).onBandwidthStateChange(this.currentNetworkQuality.get());     // Catch: Throwable -> L6
        r101 = r101 + 1;
        goto L3
    L12:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean significantlyOutsideCurrentBand() {
        if (this.mDownloadBandwidth != null) goto L30;
        return false;
    L30:
        int r100 = AnonymousClass1.$SwitchMap$com$ss$android$socialbase$downloader$network$NetworkQuality[this.currentNetworkQuality.get().ordinal()];     // Catch: Throwable -> L27
        double r101 = 150.0d;
        if (r100 != 1) goto L8;
        double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L18:
        double r103 = this.mDownloadBandwidth.getAverage();     // Catch: Throwable -> L27
        if (r103 <= r101) goto L25;
        if (r103 <= (r101 * HYSTERESIS_TOP_MULTIPLIER)) goto L29;
        return true;
    L29:
        return false;
    L25:
        if (r103 >= (r102 * HYSTERESIS_BOTTOM_MULTIPLIER)) goto L29;
        return true;
    L8:
        if (r100 != 2) goto L10;
        r101 = 550.0d;
        r102 = 150.0d;
        goto L18
    L10:
        if (r100 != 3) goto L12;
        r102 = 550.0d;
        r101 = 2000.0d;
        goto L18
    L12:
        if (r100 == 4) goto L14;
        return true;
    L14:
        r101 = 3.4028234663852886E38d;
        r102 = 2000.0d;
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L29
    }

    public double getRealTimeSpeed() {
        ExponentialGeometricAverage r100 = this.mDownloadBandwidth;
        if (r100 != null) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        return r100.getRealTimeSpeed();
    }

    public void reset() {
        ExponentialGeometricAverage r100 = this.mDownloadBandwidth;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.reset();     // Catch: Throwable -> L7
    L5:
        this.currentNetworkQuality.set(NetworkQuality.UNKNOWN);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private NetTrafficManagerImpl() {
        this.mDownloadBandwidth = new ExponentialGeometricAverage(DEFAULT_DECAY_CONSTANT);
        this.initiateStateChange = false;
        this.currentNetworkQuality = new AtomicReference(NetworkQuality.UNKNOWN);
        this.listenerList = new CopyOnWriteArrayList();
    }

    public static NetTrafficManagerImpl getInstance() {
        return ConnectionClassManagerHolder.instance;
    }

    public /* synthetic */ NetTrafficManagerImpl(AnonymousClass1 r100) {
        this();
    }

    private NetworkQuality mapBandwidthQuality(double r100) {
        if (r100 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L7;
        return NetworkQuality.UNKNOWN;
    L7:
        if (r100 >= 150.0d) goto L11;
        return NetworkQuality.POOR;
    L11:
        if (r100 >= 550.0d) goto L15;
        return NetworkQuality.MODERATE;
    L15:
        if (r100 >= 2000.0d) goto L19;
        return NetworkQuality.GOOD;
    L19:
        return NetworkQuality.EXCELLENT;
    }

    public NetworkQuality register(NetTrafficManager.NetworkStateChangeListener r100) {
        if (r100 == null) goto L5;
        this.listenerList.add(r100);
    L5:
        return this.currentNetworkQuality.get();
    }

    public void remove(NetTrafficManager.NetworkStateChangeListener r100) {
        if (r100 == null) goto L5;
        this.listenerList.remove(r100);
        return;
    }

    public synchronized void addBandwidth(long r100, long r101) {
        monitor-enter(this);
        double r102 = ((r100 * 1.0d) / r101) * 8.0d;
        if (r101 != 0) goto L6;
    L25:
        monitor-exit(this);
        return;
    L6:
        if (r102 < 3.0d) goto L25;
        this.mDownloadBandwidth.addMeasurement(r102);     // Catch: Throwable -> L27
        NetworkQuality r103 = getCurrentNetworkQuality();     // Catch: Throwable -> L27
        if (this.initiateStateChange == false) goto L21;
        this.sampleCount++;     // Catch: Throwable -> L27
        if (r103 == this.nextNetworkQuality.get()) goto L14;
        this.initiateStateChange = false;     // Catch: Throwable -> L27
        this.sampleCount = 1;     // Catch: Throwable -> L27
    L14:
        if (this.sampleCount >= 5.0d) goto L16;
    L18:
        monitor-exit(this);
        return;
    L16:
        if (significantlyOutsideCurrentBand() == false) goto L18;
        this.initiateStateChange = false;     // Catch: Throwable -> L27
        this.sampleCount = 1;     // Catch: Throwable -> L27
        this.currentNetworkQuality.set(this.nextNetworkQuality.get());     // Catch: Throwable -> L27
        notifyListeners();     // Catch: Throwable -> L27
        goto L18
    L21:
        if (this.currentNetworkQuality.get() == r103) goto L23;
        this.initiateStateChange = true;     // Catch: Throwable -> L27
        this.nextNetworkQuality = new AtomicReference(r103);     // Catch: Throwable -> L27
    L23:
        monitor-exit(this);
    }
}
