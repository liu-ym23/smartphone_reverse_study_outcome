package com.ss.android.vesdk.faceinfo;

import android.graphics.PointF;
import android.graphics.Rect;
import com.ss.android.ttve.nativePort.e;

/* JADX INFO: loaded from: classes40.dex */
public class VEFaceDetect {
    private static final int FACE_KEY_POINT_NUM = 106;
    private int action;
    private float eyeDistance;
    private a faceExtInfo;
    private int faceID;
    private e parcelWrapper;
    private float pitch;
    private float[] pointVisibility;
    private PointF[] points;
    private Rect rect;
    private float roll;
    private float score;
    private int trackCount;
    private float yaw;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PointF[] f455767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PointF[] f455768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public PointF[] f455769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PointF[] f455770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e f455771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f455772f;

        public a() {
            this.f455772f = 0;
        }
    }

    public VEFaceDetect() {
    }

    public void readFromParcel() {
        e r100 = this.parcelWrapper;
        if (r100 != null) goto L5;
        return;
    L5:
        this.rect = new Rect(r100.c(), r100.c(), r100.c(), r100.c());
        this.score = this.parcelWrapper.b();
        this.points = this.parcelWrapper.h(106);
        e r101 = this.parcelWrapper;
        r101.getClass();
        float[] r102 = new float[106];
        int r103 = 0;
    L6:
        if (r103 >= 106) goto L8;
        r102[r103] = r101.b();
        r103 = r103 + 1;
        goto L6
    L8:
        this.pointVisibility = r102;
        this.yaw = this.parcelWrapper.b();
        this.pitch = this.parcelWrapper.b();
        this.roll = this.parcelWrapper.b();
        this.eyeDistance = this.parcelWrapper.b();
        this.faceID = this.parcelWrapper.c();
        this.action = this.parcelWrapper.c();
        this.trackCount = this.parcelWrapper.c();
    }

    public int getAction() {
        return this.action;
    }

    public float getEyeDistance() {
        return this.eyeDistance;
    }

    public a getFaceExtInfo() {
        return this.faceExtInfo;
    }

    public int getFaceID() {
        return this.faceID;
    }

    public float getPitch() {
        return this.pitch;
    }

    public float[] getPointVisibility() {
        return this.pointVisibility;
    }

    public PointF[] getPoints() {
        return this.points;
    }

    public Rect getRect() {
        return this.rect;
    }

    public float getRoll() {
        return this.roll;
    }

    public float getScore() {
        return this.score;
    }

    public int getTrackCount() {
        return this.trackCount;
    }

    public float getYaw() {
        return this.yaw;
    }

    public void setAction(int r100) {
        this.action = r100;
    }

    public void setEyeDistance(float r100) {
        this.eyeDistance = r100;
    }

    public void setFaceExtInfo(a r100) {
        this.faceExtInfo = r100;
    }

    public void setFaceID(int r100) {
        this.faceID = r100;
    }

    public void setParcelWrapper(e r100) {
        this.parcelWrapper = r100;
    }

    public void setPitch(float r100) {
        this.pitch = r100;
    }

    public void setPointVisibility(float[] r100) {
        this.pointVisibility = r100;
    }

    public void setPoints(PointF[] r100) {
        this.points = r100;
    }

    public void setRect(Rect r100) {
        this.rect = r100;
    }

    public void setRoll(float r100) {
        this.roll = r100;
    }

    public void setScore(float r100) {
        this.score = r100;
    }

    public void setTrackCount(int r100) {
        this.trackCount = r100;
    }

    public void setYaw(float r100) {
        this.yaw = r100;
    }
}
