package com.ss.android.vesdk;

import android.app.ActivityManager;
import android.content.Context;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes40.dex */
public class TEMemMonitor {
    private ActivityManager mActivityManager;
    private Context mContext;

    private double getAvailMemorybyService() {
        ActivityManager.MemoryInfo r100 = new ActivityManager.MemoryInfo();
        this.mActivityManager.getMemoryInfo(r100);
        return r100.availMem;
    }

    private double getTotalMemorybyService() {
        ActivityManager.MemoryInfo r100 = new ActivityManager.MemoryInfo();
        this.mActivityManager.getMemoryInfo(r100);
        return r100.totalMem;
    }

    public double sample() {
        double r100 = getAvailMemorybyService();
        double r101 = getTotalMemorybyService();
        if (r101 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L6:
        return with2PointDouble(((r101 - r100) * 100.0d) / r101);
    }

    public TEMemMonitor(Context r100) {
        this.mContext = r100;
        this.mActivityManager = (ActivityManager) r100.getSystemService("activity");
    }

    private double with2PointDouble(double r100) {
        return Math.round(r100 * 100.0d) / 100.0d;
    }
}
