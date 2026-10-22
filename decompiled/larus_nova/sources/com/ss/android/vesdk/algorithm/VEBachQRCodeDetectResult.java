package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.nativePort.e;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachQRCodeDetectResult extends VEScanResult {
    private boolean isQRCode;
    private float zoomFactor;

    public String toString() {
        return "VEBachQRCodeDetectResult{zoomFactor=" + this.zoomFactor + ", isQRCode=" + this.isQRCode + '}';
    }

    public VEBachQRCodeDetectResult() {
    }

    public boolean getIsQRCode() {
        return this.isQRCode;
    }

    public float getZoomFactor() {
        return this.zoomFactor;
    }

    public static VEBachQRCodeDetectResult fromCameraParcel(byte[] r100) {
        e r101 = new e(r100);
        VEBachQRCodeDetectResult r102 = new VEBachQRCodeDetectResult();
        r102.setZoomFactor(r101.b());
        r102.setRetCode(r101.c());
        return r102;
    }

    public static List<VEBachQRCodeDetectResult> makeList(byte[] r100) {
        e r101 = new e(r100);
        int r102 = r101.c();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        VEBachQRCodeDetectResult r105 = new VEBachQRCodeDetectResult();
        r105.setZoomFactor(r101.b());
        r105.setRetCode(r101.c());
        r103.add(r105);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public void setQRCode(boolean r100) {
        this.isQRCode = r100;
    }

    public void setZoomFactor(float r100) {
        this.zoomFactor = r100;
    }
}
