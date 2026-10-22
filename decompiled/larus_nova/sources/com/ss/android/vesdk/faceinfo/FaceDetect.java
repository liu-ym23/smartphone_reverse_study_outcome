package com.ss.android.vesdk.faceinfo;

import android.graphics.PointF;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes40.dex */
public class FaceDetect {
    private int action;
    private float eyeDistance;
    private FaceExtInfo faceExtInfo;
    private int faceID;
    private float pitch;
    private float[] pointVisibility;
    private PointF[] points;
    private Rect rect;
    private float roll;
    private float score;
    private int trackCount;
    private float yaw;

    public static class FaceExtInfo {
        public PointF[] eyeBrowLeftPoints;
        public PointF[] eyeBrowRightPoints;
        public int eyeCount;
        public PointF[] eyeLeftPoints;
        public PointF[] eyeRightPoints;
        public int eyebrowCount;
        public int irisCount;
        public PointF[] irisLeftPoints;
        public PointF[] irisRightPoints;
        public int lipCount;
        public PointF[] lipPoints;

        public FaceExtInfo() {
        }
    }

    public FaceDetect() {
    }

    public int getAction() {
        return this.action;
    }

    public float getEyeDistance() {
        return this.eyeDistance;
    }

    public FaceExtInfo getFaceExtInfo() {
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

    public void setFaceExtInfo(FaceExtInfo r100) {
        this.faceExtInfo = r100;
    }

    public void setFaceID(int r100) {
        this.faceID = r100;
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
