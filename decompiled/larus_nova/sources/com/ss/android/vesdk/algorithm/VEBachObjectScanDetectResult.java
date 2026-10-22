package com.ss.android.vesdk.algorithm;

import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.nativePort.e;
import com.ss.android.vesdk.VERectF;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mgc.a;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachObjectScanDetectResult extends VEScanResult {
    private VERectF box;
    private int label;
    private int objId;
    private float prob;
    private VEFrame srcImage;
    private String srcImageKey;

    public VEBachObjectScanDetectResult() {
        this.type = 2;
    }

    public VERectF getBox() {
        return this.box;
    }

    public int getLabel() {
        return this.label;
    }

    public int getObjId() {
        return this.objId;
    }

    public float getProb() {
        return this.prob;
    }

    public VEFrame getSrcImage() {
        return this.srcImage;
    }

    public String getSrcImageKey() {
        return this.srcImageKey;
    }

    public static List<VEBachObjectScanDetectResult> makeList(byte[] r100) {
        e r101 = new e(r100);
        int r102 = r101.c();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        VEBachObjectScanDetectResult r105 = new VEBachObjectScanDetectResult();
        r105.setLabel(r101.c());
        r105.setObjId(r101.c());
        r105.setProb(r101.b());
        VERectF r106 = new VERectF();
        r106.fX = r101.b();
        r106.fY = r101.b();
        r106.fWidth = r101.b();
        r106.fHeight = r101.b();
        r105.setBox(r106);
        r101.c();
        r101.c();
        r105.srcImageKey = r101.g(r101.c());
        r103.add(r105);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public void setBox(VERectF r100) {
        this.box = r100;
    }

    public void setLabel(int r100) {
        this.label = r100;
    }

    public void setObjId(int r100) {
        this.objId = r100;
    }

    public void setProb(float r100) {
        this.prob = r100;
    }

    public void setSrcImage(VEFrame r100) {
        this.srcImage = r100;
    }

    public static VEBachObjectScanDetectResult fromCameraParcel(byte[] r110, ByteBuffer r111, VEFrame r112, a r113) {
        if (r110 != null) goto L5;
        return null;
    L5:
        e r100 = new e(r110);
        VEBachObjectScanDetectResult r114 = new VEBachObjectScanDetectResult();
        r114.setLabel(r100.c());
        r114.setObjId(r100.c());
        r114.setProb(r100.b());
        VERectF r101 = new VERectF();
        r101.fX = r100.b();
        r101.fY = r100.b();
        r101.fWidth = r100.b();
        r101.fHeight = r100.b();
        r114.setBox(r101);
        int r102 = r100.c();
        int r103 = r100.c();
        if (r112 != null) goto L11;
        if (r111 == null) goto L11;
        if (r102 <= 0) goto L11;
        if (r103 <= 0) goto L11;
        r112 = VEFrame.createByteBufferFrame(r111, r102, r103, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_RGBA8, r113);
    L11:
        r114.setSrcImage(r112);
        return r114;
    }
}
