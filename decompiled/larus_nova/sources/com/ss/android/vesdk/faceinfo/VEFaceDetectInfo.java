package com.ss.android.vesdk.faceinfo;

import android.graphics.PointF;
import com.ss.android.ttve.nativePort.e;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceDetectInfo {
    private static final String TAG = "VEFaceDetectInfo";
    private int faceCount;
    private VEFaceDetect[] info;
    private e parcelWrapper;

    public VEFaceDetectInfo() {
    }

    public void readFromParcel() {
        this.faceCount = this.parcelWrapper.c();
        VELogUtil.d(TAG, "face count = " + this.faceCount);
        this.info = new VEFaceDetect[this.faceCount];
        int r100 = 0;
    L4:
        if (r100 >= this.faceCount) goto L6;
        VEFaceDetect r101 = new VEFaceDetect();
        r101.setParcelWrapper(this.parcelWrapper);
        r101.readFromParcel();
        this.info[r100] = r101;
        r100 = r100 + 1;
        goto L4
    L6:
        int r102 = this.parcelWrapper.c();
        VELogUtil.d(TAG, "faceExtFlag = " + r102);
        if (r102 != 0) goto L9;
        return;
    L9:
        int r103 = 0;
    L11:
        if (r103 >= this.faceCount) goto L28;
        VEFaceDetect.a r104 = new VEFaceDetect.a();
        e r105 = this.parcelWrapper;
        r104.f455771e = r105;
        r104.f455772f = r102;
        if (r105 == null) goto L27;
        if ((r102 & 1) == 0) goto L19;
        r105.c();
        r104.f455767a = r104.f455771e.h(22);
        r104.f455771e.h(22);
        VELogUtil.d("FaceExtInfo", "first left eye point = " + r104.f455767a[0].x + " X " + r104.f455767a[0].y);
    L19:
        if ((r104.f455772f & 2) == 0) goto L22;
        r104.f455771e.c();
        r104.f455768b = r104.f455771e.h(13);
        r104.f455771e.h(13);
        VELogUtil.d("FaceExtInfo", "first left eyebrow point = " + r104.f455768b[0].x + " X " + r104.f455768b[0].y);
    L22:
        if ((r104.f455772f & 4) == 0) goto L25;
        r104.f455771e.c();
        r104.f455769c = r104.f455771e.h(64);
        VELogUtil.d("FaceExtInfo", "first lip point = " + r104.f455769c[0].x + " X " + r104.f455769c[0].y);
    L25:
        if ((r104.f455772f & 8) == 0) goto L27;
        r104.f455771e.c();
        r104.f455770d = r104.f455771e.h(20);
        r104.f455771e.h(20);
        VELogUtil.d("FaceExtInfo", "first left iris point = " + r104.f455770d[0].x + " X " + r104.f455770d[0].y);
    L27:
        this.info[r103].setFaceExtInfo(r104);
        r103 = r103 + 1;
        goto L11
    }

    public VEFaceDetect[] getInfo() {
        return this.info;
    }

    public static VEFaceDetectInfo covert(FaceDetectInfo r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.getInfo() == null) goto L19;
        VEFaceDetectInfo r101 = new VEFaceDetectInfo();
        VEFaceDetect[] r102 = new VEFaceDetect[r100.getInfo().length];
        FaceDetect[] r103 = r100.getInfo();
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r105 >= r104) goto L12;
        FaceDetect r107 = r103[r105];
        VEFaceDetect r108 = new VEFaceDetect();
        r108.setRect(r107.getRect());
        r108.setPoints(r107.getPoints());
        r108.setAction(r107.getAction());
        r108.setEyeDistance(r107.getEyeDistance());
        if (r107.getFaceExtInfo() == null) goto L11;
        VEFaceDetect.a r109 = new VEFaceDetect.a();
        int r110 = r107.getFaceExtInfo().eyebrowCount;
        r109.f455768b = r107.getFaceExtInfo().eyeBrowLeftPoints;
        PointF[] r111 = r107.getFaceExtInfo().eyeBrowRightPoints;
        int r112 = r107.getFaceExtInfo().eyeCount;
        r109.f455767a = r107.getFaceExtInfo().eyeLeftPoints;
        PointF[] r113 = r107.getFaceExtInfo().eyeRightPoints;
        int r114 = r107.getFaceExtInfo().lipCount;
        r109.f455770d = r107.getFaceExtInfo().irisLeftPoints;
        PointF[] r115 = r107.getFaceExtInfo().irisRightPoints;
        int r116 = r107.getFaceExtInfo().irisCount;
        r108.setFaceExtInfo(r109);
    L11:
        r108.setFaceID(r107.getFaceID());
        r108.setPitch(r107.getPitch());
        r108.setPointVisibility(r107.getPointVisibility());
        r108.setRoll(r107.getRoll());
        r108.setYaw(r107.getYaw());
        r108.setScore(r107.getScore());
        r108.setTrackCount(r107.getTrackCount());
        r102[r106] = r108;
        r105 = r105 + 1;
        r106 = r106 + 1;
        goto L7
    L12:
        r101.setInfo(r102);
        return r101;
    L19:
        return null;
    }

    public void setInfo(VEFaceDetect[] r100) {
        this.info = r100;
    }

    public void setParcelWrapper(e r100) {
        this.parcelWrapper = r100;
    }
}
