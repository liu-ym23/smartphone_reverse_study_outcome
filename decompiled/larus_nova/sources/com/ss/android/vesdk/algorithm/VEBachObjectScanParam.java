package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.TEBundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachObjectScanParam extends VEBachAlgorithmParam {
    public static final int SCAN_OBJECT_AND_SCRIPT = 2;
    public static final int SCAN_OBJECT_DETECT = 0;
    public static final int SCAN_SCRIPT = 1;
    public int maxObjectNum;
    public int maxTrackNum;
    public int objectDetectIntervalTimeMs;
    public int scanType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ScanType {
    }

    public VEBachObjectScanParam() {
        this(12, "ObjectScan", false);
    }

    @Override // com.ss.android.vesdk.algorithm.VEBachAlgorithmParam, com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setInt("ScanType", this.scanType);
        r100.setInt("ObjectDetectIntervalTimeMs", this.objectDetectIntervalTimeMs);
        r100.setInt("MaxTrackNum", this.maxTrackNum);
        r100.setInt("MaxObjectNum", this.maxObjectNum);
        return r100;
    }

    public VEBachObjectScanParam(int r100, String r101, boolean r102) {
        super(r100, r101, r102);
        this.scanType = 2;
        this.objectDetectIntervalTimeMs = 1000;
        this.maxTrackNum = 3;
        this.maxObjectNum = 3;
    }
}
