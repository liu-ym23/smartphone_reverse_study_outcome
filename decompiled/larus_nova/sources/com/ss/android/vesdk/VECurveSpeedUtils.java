package com.ss.android.vesdk;

import com.ss.android.ttve.nativePort.TEVideoUtils;

/* JADX INFO: loaded from: classes40.dex */
public class VECurveSpeedUtils {
    private static final String TAG = "VECurveSpeedUtils";
    private static final int TIMEBASE = 1000;
    private double mAveSpeed;
    private float[] mCurveSpeedPointX;
    private float[] mCurveSpeedPointY;
    private volatile long mNative;

    public synchronized void destroy() {
        monitor-enter(this);
        VELogUtil.i(TAG, "destroy...");     // Catch: Throwable -> L11
        if (this.mNative != 0) goto L8;
        VELogUtil.e(TAG, "destroy, mNative == 0");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        TEVideoUtils.nativeCurveSpeedDestroy(this.mNative);     // Catch: Throwable -> L11
        this.mNative = 0;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public double getAveCurveSpeed() {
        if (this.mNative != 0) goto L6;
        VELogUtil.e(TAG, "getAveCurveSpeed, mNative == 0");
        return -112.0d;
    L6:
        double r100 = TEVideoUtils.nativeGetAveCurveSpeed(this.mNative);
        this.mAveSpeed = r100;
        return r100;
    }

    public double getCurveSpeedWithSeqDelta(long r100) {
        if (this.mNative != 0) goto L7;
        VELogUtil.e(TAG, "getCurveSpeedWithSeqDelta, mNative == 0");
        return -112.0d;
    L7:
        return TEVideoUtils.nativeGetCurveSpeedWithSeqDelta(this.mNative, r100 * 1000);
    }

    public long mapSeqDeltaToTrimDelta(long r100) {
        if (this.mNative != 0) goto L7;
        VELogUtil.e(TAG, "mapSeqDeltaToTrimDelta, mNative == 0");
        return -112;
    L7:
        return TEVideoUtils.nativeMapSeqDeltaToTrimDelta(this.mNative, r100 * 1000) / 1000;
    }

    public long mapTrimDeltaToSeqDelta(long r100) {
        if (this.mNative != 0) goto L7;
        VELogUtil.e(TAG, "mapTrimDeltaToSeqDelta, mNative == 0");
        return -112;
    L7:
        return TEVideoUtils.nativeMapTrimDeltaToSeqDelta(this.mNative, r100 * 1000) / 1000;
    }

    public void setSeqDuration(long r100) {
        if (this.mNative != 0) goto L6;
        VELogUtil.e(TAG, "setSeqDuration, mNative == 0");
        return;
    L6:
        TEVideoUtils.nativeSetSeqDuration(this.mNative, r100 * 1000);
    }

    public VECurveSpeedUtils(float[] r100, float[] r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (r100.length != r101.length) goto L12;
        if (r100.length < 2) goto L12;
        this.mNative = TEVideoUtils.nativeCreateCurveSpeedUtils(r100, r101);
        this.mCurveSpeedPointX = r100;
        this.mCurveSpeedPointY = r101;
        VELogUtil.d(TAG, "VECurveSpeedUtils ret1 " + setCurveSpeed(r100, r101) + " ret2 " + getAveCurveSpeed());
        return;
    L12:
        this.mNative = 0;
        VELogUtil.e(TAG, "incorrect curve anchors, mNative == 0");
    }

    public static float[] transferTrimPointXtoSeqPointX(float[] r100, float[] r101) {
        int r102 = r100.length;
        float[] r103 = new float[r102];
        int r104 = 0;
        float r105 = 0.0f;
        r103[0] = 0.0f;
    L4:
        if (r104 >= (r102 - 1)) goto L6;
        int r106 = r104 + 1;
        r105 = r105 + ((r100[r106] - r100[r104]) / ((r101[r106] + r101[r104]) * 0.5f));
        r103[r106] = r105;
        r104 = r106;
        goto L4
    L6:
        int r107 = 1;
    L7:
        if (r107 >= r102) goto L9;
        r103[r107] = r103[r107] / r105;
        VELogUtil.d("TAG", "transferTrimPointXtoSeqPointX SeqPointX[" + r107 + "]= " + r103[r107]);
        r107 = r107 + 1;
        goto L7
    L9:
        return r103;
    }

    public int setCurveSpeed(float[] r100, float[] r101) {
        if (r100 == null) goto L16;
        if (r101 == null) goto L16;
        if (r100.length != r101.length) goto L16;
        if (r100.length < 2) goto L16;
        if (this.mNative != 0) goto L15;
        VELogUtil.e(TAG, "setCurveSpeed, mNative == 0");
        return -112;
    L15:
        return TEVideoUtils.nativeSetCurveSpeedData(this.mNative, r100, r101);
    L16:
        VELogUtil.e(TAG, "setCurveSpeed,incorrect curve anchors, mNative == 0");
        return -100;
    }
}
