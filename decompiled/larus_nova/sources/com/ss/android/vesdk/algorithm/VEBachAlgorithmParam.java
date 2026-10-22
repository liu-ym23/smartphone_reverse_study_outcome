package com.ss.android.vesdk.algorithm;

import android.graphics.Bitmap;
import com.ss.android.ttve.nativePort.TEBundle;
import com.ss.android.vesdk.VESize;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachAlgorithmParam extends VEBaseAlgorithmParam {
    public String algorithmConfig;
    public Bitmap bitmap;
    public String graphName;
    private boolean isScanAsync;
    public boolean isUpdateAlgorithm;
    private VESize mScanSize;
    public String picturePath;
    public int reqHeight;
    public int reqWidth;

    public VEBachAlgorithmParam() {
        this(8, "Bach", false);
    }

    @Override // com.ss.android.vesdk.algorithm.VEBaseAlgorithmParam
    public TEBundle getBundle() {
        TEBundle r100 = super.getBundle();
        r100.setString("algorithmConfig", this.algorithmConfig);
        r100.setBool("isScanAsync", this.isScanAsync);
        VESize r101 = this.mScanSize;
        if (r101 == null) goto L5;
        r100.setInt("ScanWidth", r101.width);
        r100.setInt("ScanHeight", this.mScanSize.height);
    L5:
        return r100;
    }

    public String getAlgorithmConfig() {
        return this.algorithmConfig;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getPicturePath() {
        return this.picturePath;
    }

    public VESize getScanSize() {
        return this.mScanSize;
    }

    public boolean isScanAsync() {
        return this.isScanAsync;
    }

    public void setEnableScanAsync(boolean r100) {
        this.isScanAsync = r100;
    }

    public void setScanSize(int r100, int r101) {
        this.mScanSize = new VESize(r100, r101);
    }

    public VEBachAlgorithmParam(int r100, String r101, boolean r102) {
        super(r100, r101, r102);
        this.isScanAsync = true;
        this.isUpdateAlgorithm = false;
    }
}
