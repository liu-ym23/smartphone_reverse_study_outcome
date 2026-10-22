package com.ss.android.vesdk.algorithm;

import android.graphics.PointF;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.nativePort.e;
import com.ss.android.vesdk.VERectF;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mgc.a;

/* JADX INFO: loaded from: classes40.dex */
public class VEBachObjectScanResult extends VEScanResult {
    private VERectF box;
    private PointF center;
    private String firstLevelLabel;
    private boolean isValid;
    private String label;
    private float prob;
    private String secondLevelLabel;
    private VEFrame srcImage;
    private String srcImageKey;
    private int trackId;
    private String wikiId;

    public VEBachObjectScanResult() {
        this.isValid = false;
        this.type = 1;
    }

    public VERectF getBox() {
        return this.box;
    }

    public PointF getCenter() {
        return this.center;
    }

    public String getFirstLevelLabel() {
        return this.firstLevelLabel;
    }

    public String getLabel() {
        return this.label;
    }

    public float getProb() {
        return this.prob;
    }

    public String getSecondLevelLabel() {
        return this.secondLevelLabel;
    }

    public VEFrame getSrcImage() {
        return this.srcImage;
    }

    public String getSrcImageKey() {
        return this.srcImageKey;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public String getWikiId() {
        return this.wikiId;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public static VEBachObjectScanResult fromImageParcel(byte[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        e r101 = new e(r100);
        VEBachObjectScanResult r102 = new VEBachObjectScanResult();
        r102.setFirstLevelLabel(r101.g(r101.c()));
        r102.setLabel(r101.g(r101.c()));
        r102.setSecondLevelLabel(r101.g(r101.c()));
        r102.setWikiId(r101.g(r101.c()));
        r102.setProb(r101.b());
        VERectF r103 = new VERectF();
        r103.fX = r101.b();
        r103.fY = r101.b();
        r103.fWidth = r101.b();
        r103.fHeight = r101.b();
        r102.setBox(r103);
        return r102;
    }

    public static List<VEBachObjectScanResult> makeList(byte[] r100) {
        e r101 = new e(r100);
        int r102 = r101.c();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        VEBachObjectScanResult r105 = new VEBachObjectScanResult();
        r105.setTrackId(r101.c());
        r105.setFirstLevelLabel(r101.g(r101.c()));
        r105.setLabel(r101.g(r101.c()));
        r105.setSecondLevelLabel(r101.g(r101.c()));
        r105.setWikiId(r101.g(r101.c()));
        r105.setProb(r101.b());
        VERectF r106 = new VERectF();
        r106.fX = r101.b();
        r106.fY = r101.b();
        r106.fWidth = r101.b();
        r106.fHeight = r101.b();
        r105.setBox(r106);
        PointF r107 = new PointF();
        r107.x = r101.b();
        r107.y = r101.b();
        r105.setCenter(r107);
        r105.setValid(r101.a());
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

    public void setCenter(PointF r100) {
        this.center = r100;
    }

    public void setFirstLevelLabel(String r100) {
        this.firstLevelLabel = r100;
    }

    public void setLabel(String r100) {
        this.label = r100;
    }

    public void setProb(float r100) {
        this.prob = r100;
    }

    public void setSecondLevelLabel(String r100) {
        this.secondLevelLabel = r100;
    }

    public void setSrcImage(VEFrame r100) {
        this.srcImage = r100;
    }

    public void setTrackId(int r100) {
        this.trackId = r100;
    }

    public void setValid(boolean r100) {
        this.isValid = r100;
    }

    public void setWikiId(String r100) {
        this.wikiId = r100;
    }

    public static VEBachObjectScanResult fromCameraParcel(byte[] r110, ByteBuffer r111, VEFrame r112, a r113) {
        e r100 = new e(r110);
        VEBachObjectScanResult r114 = new VEBachObjectScanResult();
        r114.setTrackId(r100.c());
        r114.setFirstLevelLabel(r100.g(r100.c()));
        r114.setLabel(r100.g(r100.c()));
        r114.setSecondLevelLabel(r100.g(r100.c()));
        r114.setWikiId(r100.g(r100.c()));
        r114.setProb(r100.b());
        VERectF r101 = new VERectF();
        r101.fX = r100.b();
        r101.fY = r100.b();
        r101.fWidth = r100.b();
        r101.fHeight = r100.b();
        r114.setBox(r101);
        PointF r102 = new PointF();
        r102.x = r100.b();
        r102.y = r100.b();
        r114.setCenter(r102);
        r114.setValid(r100.a());
        int r103 = r100.c();
        int r104 = r100.c();
        if (r112 != null) goto L8;
        if (r111 == null) goto L8;
        if (r103 <= 0) goto L8;
        if (r104 <= 0) goto L8;
        r112 = VEFrame.createByteBufferFrame(r111, r103, r104, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_RGBA8, r113);
    L8:
        r114.setSrcImage(r112);
        return r114;
    }
}
