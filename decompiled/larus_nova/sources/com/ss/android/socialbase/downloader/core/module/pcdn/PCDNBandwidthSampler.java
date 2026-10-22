package com.ss.android.socialbase.downloader.core.module.pcdn;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes38.dex */
public class PCDNBandwidthSampler implements DeviceBandwidthSampler.ISampleListener {
    private static final String TAG = "PCDNBandwidthSampler";
    private int mDownloadId;
    private volatile boolean mEnabled;
    private long mLastTimeReading;
    private List<LowSpeedListener> mLowSpeedListeners;
    private int mLowSpeedSampleCount;
    private long mPcdnDegradeBandWidthLimit;
    private int mPcdnDegradeSampleCount;
    private AtomicLong mPcdnTotalBytes;
    private long mPreviousBytes;

    public interface LowSpeedListener {
        void onLowSpeed();
    }

    public void startSampling() {
        this.mEnabled = true;
    }

    public void stopSampling() {
        this.mEnabled = false;
        DeviceBandwidthSampler.getInstance().removeSampleListener(this);
    }

    @Override // com.ss.android.socialbase.downloader.network.DeviceBandwidthSampler.ISampleListener
    public void addSample() {
        if (this.mEnabled == true) goto L5;
        return;
    L5:
        long r100 = SystemClock.uptimeMillis();
        long r101 = this.mPcdnTotalBytes.get();
        long r102 = this.mLastTimeReading;
        if (r102 > 0) goto L9;
        this.mLastTimeReading = r100;
        this.mPreviousBytes = r101;
        return;
    L9:
        addSampleImpl(r101 - this.mPreviousBytes, r100 - r102);
        this.mLastTimeReading = r100;
        this.mPreviousBytes = r101;
    }

    public void addPcdnSample(long r100) {
        this.mPcdnTotalBytes.addAndGet(r100);
    }

    public void register(LowSpeedListener r100) {
        this.mLowSpeedListeners.add(r100);
    }

    private void addSampleImpl(long r100, long r101) {
        if (r101 != 0) goto L5;
        return;
    L5:
        long r102 = r100 / r101;
        if (Logger.debug() == false) goto L9;
        Logger.taskDebug(TAG, this.mDownloadId, "addSampleImpl", "Speed:" + r102 + " byteDiff:" + r100 + " timeDiff:" + r101);
    L9:
        if (r102 >= this.mPcdnDegradeBandWidthLimit) goto L17;
        int r103 = this.mLowSpeedSampleCount + 1;
        this.mLowSpeedSampleCount = r103;
        if (r103 <= this.mPcdnDegradeSampleCount) goto L20;
        Iterator<LowSpeedListener> r104 = this.mLowSpeedListeners.iterator();
    L14:
        if (r104.hasNext() == false) goto L16;
        r104.next().onLowSpeed();
        goto L14
    L16:
        this.mLowSpeedSampleCount = 0;
        return;
    L20:
        return;
    L17:
        this.mLowSpeedSampleCount = 0;
    }

    public PCDNBandwidthSampler(int r100, long r101, int r102) {
        this.mEnabled = false;
        this.mPcdnTotalBytes = new AtomicLong(0);
        this.mLowSpeedListeners = new CopyOnWriteArrayList();
        this.mDownloadId = r100;
        this.mPcdnDegradeBandWidthLimit = r101;
        this.mPcdnDegradeSampleCount = r102;
        if (r101 <= 0) goto L7;
        if (r102 <= 0) goto L8;
        DeviceBandwidthSampler.getInstance().registerSampleListener(this);
        return;
    L8:
        return;
    }
}
