package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadWatchDog;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes38.dex */
public class DeviceBandwidthSampler {
    private static final String TAG = null;
    private static volatile DeviceBandwidthSampler instance;
    private static volatile int sNetworkType;
    private static long sPreviousBytes;
    private final List<ISampleListener> listenerList;
    private volatile long mCurrRunningTime;
    private final SamplingHandler mHandler;
    private long mLastTimeReading;
    private final NetTrafficManager mNetTrafficManager;
    private final AtomicInteger mSamplingCounter;
    private long mStartTime;

    public interface ISampleListener {
        void addSample();
    }

    public class SamplingHandler extends Handler {
        private static final int MSG_START = 1;
        static final long SAMPLE_TIME = 1000;
        final /* synthetic */ DeviceBandwidthSampler this$0;

        public void startSamplingThread() {
            sendEmptyMessage(1);
        }

        public void stopSamplingThread() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            if (r100.what != 1) goto L7;
            this.this$0.addSample();
            sendEmptyMessageDelayed(1, 1000);
            return;
        }

        public SamplingHandler(DeviceBandwidthSampler r100, Looper r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    static {
        TAG = "DeviceBandwidthSampler";
        sNetworkType = 0;
        sPreviousBytes = -1;
        instance = null;
    }

    public static DeviceBandwidthSampler getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DeviceBandwidthSampler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DeviceBandwidthSampler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DeviceBandwidthSampler.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static boolean isMobileNet() {
        if (sNetworkType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isWifi() {
        if (sNetworkType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void addFinalSample() {
        this.mCurrRunningTime = 0;
        addSample();
        sPreviousBytes = -1;
    }

    public boolean isSampling() {
        if (this.mSamplingCounter.get() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void startSampling() {
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "startSampling", "SamplingCounter = " + this.mSamplingCounter);     // Catch: Throwable -> L10
    L7:
        if (this.mSamplingCounter.getAndIncrement() != 0) goto L13;
        this.mHandler.startSamplingThread();     // Catch: Throwable -> L10
        this.mLastTimeReading = SystemClock.uptimeMillis();     // Catch: Throwable -> L10
        this.mStartTime = System.currentTimeMillis();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    public void stopSampling() {
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "stopSampling", "SamplingCounter = " + this.mSamplingCounter);     // Catch: Throwable -> L10
    L7:
        if (this.mSamplingCounter.decrementAndGet() != 0) goto L13;
        this.mHandler.stopSamplingThread();     // Catch: Throwable -> L10
        addFinalSample();     // Catch: Throwable -> L10
        return;
    L13:
        return;
    }

    private DeviceBandwidthSampler() {
        this.listenerList = new CopyOnWriteArrayList();
        this.mCurrRunningTime = 0;
        this.mStartTime = 0;
        this.mNetTrafficManager = NetTrafficManager.getInstance();
        this.mSamplingCounter = new AtomicInteger();
        this.mHandler = new SamplingHandler(this, DownloadWatchDog.getThreadLooper());
    }

    public static long getAllRxBytesWifi() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void updateNetworkStatus() {
        sNetworkType = DownloadUtils.getNetworkType(DownloadComponentManager.getAppContext());
    }

    public void addSample() {
        this.mCurrRunningTime = System.currentTimeMillis() - this.mStartTime;     // Catch: Exception -> L20
        updateNetworkStatus();     // Catch: Exception -> L20
        if (isWifi() == false) goto L5;
        long r100 = getAllRxBytesWifi();     // Catch: Exception -> L20
    L6:
        long r101 = sPreviousBytes;     // Catch: Exception -> L20
        long r102 = r100 - r101;     // Catch: Exception -> L20
        if (r101 < 0) goto L15;
        monitor-enter(this);     // Catch: Exception -> L20
        long r103 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        this.mNetTrafficManager.addBandwidth(r102, r103 - this.mLastTimeReading);     // Catch: Throwable -> L12
        this.mLastTimeReading = r103;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;     // Catch: Exception -> L20
    L15:
        sPreviousBytes = r100;     // Catch: Exception -> L20
        Iterator<ISampleListener> r104 = this.listenerList.iterator();     // Catch: Exception -> L20
    L17:
        if (r104.hasNext() == false) goto L27;
        r104.next().addSample();     // Catch: Exception -> L20
        goto L17
    L27:
        return;
    L5:
        r100 = TrafficStats.getMobileRxBytes();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.printStackTrace();
    }

    public long getTaskRunningTime() {
        return this.mCurrRunningTime;
    }

    public void registerSampleListener(ISampleListener r100) {
        this.listenerList.add(r100);
    }

    public void removeSampleListener(ISampleListener r100) {
        this.listenerList.remove(r100);
    }
}
