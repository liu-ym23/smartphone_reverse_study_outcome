package com.ss.android.vesdk;

import com.ss.android.ttve.nativePort.TEVideoUtils;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes40.dex */
public class VERTAudioWaveformMgr {
    private static final String TAG = "VERTAudioWaveformMgr";
    private final int mAudioFormat;
    private final int mChannelNum;
    private long mNative;

    public int destroy() {
        long r100 = this.mNative;
        if (r100 != 0) goto L6;
        VELogUtil.e(TAG, "destroy, mNative == 0");
        return -112;
    L6:
        int r101 = TEVideoUtils.deleteRTAudioWaveformMgr(r100);
        this.mNative = 0;
        return r101;
    }

    public int finish() {
        long r100 = this.mNative;
        if (r100 != 0) goto L7;
        VELogUtil.e(TAG, "finish, mNative == 0");
        return -112;
    L7:
        return TEVideoUtils.rtAudioWaveformFinish(r100);
    }

    public int reset() {
        long r100 = this.mNative;
        if (r100 != 0) goto L7;
        VELogUtil.e(TAG, "reset, mNative == 0");
        return -112;
    L7:
        return TEVideoUtils.rtAudioWaveformReset(r100);
    }

    public int getRemainedPoints(float[] r100, int r101, int r102) {
        long r103 = this.mNative;
        if (r103 != 0) goto L7;
        VELogUtil.e(TAG, "getRemainedPoints, mNative == 0");
        return -112;
    L7:
        return TEVideoUtils.rtAudioWaveformGetPoints(r103, r100, r101, r102);
    }

    public int process(short[] r100, int r101, int r110) {
        if (this.mNative != 0) goto L6;
        VELogUtil.e(TAG, "process, mNative == 0");
        return -112;
    L6:
        int r102 = this.mChannelNum;
        if (r102 < 0) goto L23;
        if (r110 < 0) goto L23;
        if ((r110 * r102) > (r100.length - r101)) goto L23;
        if (this.mAudioFormat != 2) goto L23;
        float[][] r103 = (float[][]) Array.newInstance(Float.TYPE, new int[]{r102, r110});
        int r104 = 0;
    L15:
        int r105 = this.mChannelNum;
        if (r104 >= r105) goto L22;
        int r106 = 0;
    L18:
        if (r106 >= r110) goto L20;
        r103[r104][r106] = r100[((this.mChannelNum * r106) + r104) + r101] / 32767.0f;
        r106 = r106 + 1;
        goto L18
    L20:
        r104 = r104 + 1;
        goto L15
    L22:
        return TEVideoUtils.rtAudioWaveformProcess(this.mNative, r103, r105, r110);
    L23:
        VELogUtil.e(TAG, "process param error mChannelNum " + this.mChannelNum + ", bufSize " + r100.length + ", offset " + r101 + ", frameNum " + r110 + ", mAudioFormat " + this.mAudioFormat);
        return -100;
    }

    public int process(float[] r100, int r101, int r102) {
        if (this.mNative != 0) goto L6;
        VELogUtil.e(TAG, "process, mNative == 0");
        return -112;
    L6:
        int r103 = this.mChannelNum;
        if (r103 < 0) goto L23;
        if (r102 < 0) goto L23;
        if ((r102 * r103) > (r100.length - r101)) goto L23;
        if (this.mAudioFormat != 4) goto L23;
        float[][] r104 = (float[][]) Array.newInstance(Float.TYPE, new int[]{r103, r102});
        int r105 = 0;
    L15:
        int r106 = this.mChannelNum;
        if (r105 >= r106) goto L22;
        int r107 = 0;
    L18:
        if (r107 >= r102) goto L20;
        r104[r105][r107] = r100[((this.mChannelNum * r107) + r105) + r101];
        r107 = r107 + 1;
        goto L18
    L20:
        r105 = r105 + 1;
        goto L15
    L22:
        return TEVideoUtils.rtAudioWaveformProcess(this.mNative, r104, r106, r102);
    L23:
        VELogUtil.e(TAG, "process param error mChannelNum " + this.mChannelNum + ", bufSize " + r100.length + ", offset " + r101 + ", frameNum " + r102 + ", mAudioFormat " + this.mAudioFormat);
        return -100;
    }

    public VERTAudioWaveformMgr(int r100, int r101, int r102, float r103, int r104) {
        this.mNative = TEVideoUtils.createRTAudioWaveformMgr(r101, r102, r103, r104);
        this.mChannelNum = r101;
        this.mAudioFormat = r100;
    }
}
