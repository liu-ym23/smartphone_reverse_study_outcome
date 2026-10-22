package com.ss.android.vesdk.algorithm;

import bic.a;
import com.ss.android.ttve.nativePort.e;
import com.ss.android.vesdk.VERectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachFaceDetectResult extends VEScanResult {
    private List<a> points;
    private VERectF rect;
    private float score;

    public VEBachFaceDetectResult() {
    }

    public List<a> getPoints() {
        return this.points;
    }

    public VERectF getRect() {
        return this.rect;
    }

    public float getScore() {
        return this.score;
    }

    public static VEBachFaceDetectResult fromCameraParcel(byte[] r100) {
        e r101 = new e(r100);
        VEBachFaceDetectResult r102 = new VEBachFaceDetectResult();
        float r103 = r101.b();
        float r104 = r101.b();
        float r105 = r101.b();
        float r106 = r101.b();
        r102.setRect(new VERectF(r103, r104, Math.abs(r105 - r103), Math.abs(r106 - r104)));
        r102.setScore(r101.b());
        int r107 = r101.c();
        ArrayList r108 = new ArrayList();
        int r109 = 0;
    L3:
        if (r109 >= r107) goto L5;
        r101.b();
        r101.b();
        r108.add(new a());
        r109 = r109 + 1;
        goto L3
    L5:
        r102.setPoints(r108);
        return r102;
    }

    public void setPoints(List<a> r100) {
        this.points = r100;
    }

    public void setRect(VERectF r100) {
        this.rect = r100;
    }

    public void setScore(float r100) {
        this.score = r100;
    }
}
