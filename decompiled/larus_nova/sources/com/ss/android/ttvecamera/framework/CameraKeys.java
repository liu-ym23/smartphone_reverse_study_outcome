package com.ss.android.ttvecamera.framework;

import android.graphics.Rect;
import android.hardware.camera2.CaptureResult;

/* JADX INFO: loaded from: classes38.dex */
public class CameraKeys {
    public static final CaptureResult.Key<int[]> STATISTICS_FACE_IDS = null;
    public static final CaptureResult.Key<int[]> STATISTICS_FACE_LANDMARKS = null;
    public static final CaptureResult.Key<int[]> STATISTICS_FACE_MTK = null;
    public static final CaptureResult.Key<Rect[]> STATISTICS_FACE_RECTANGLES = null;
    public static final CaptureResult.Key<byte[]> STATISTICS_FACE_SCORES = null;

    public CameraKeys() {
    }

    static {
        STATISTICS_FACE_IDS = new CaptureResult.Key("android.statistics.faceIds", int[].class);
        STATISTICS_FACE_LANDMARKS = new CaptureResult.Key("android.statistics.faceLandmarks", int[].class);
        STATISTICS_FACE_RECTANGLES = new CaptureResult.Key("android.statistics.faceRectangles", Rect[].class);
        STATISTICS_FACE_SCORES = new CaptureResult.Key("android.statistics.faceScores", byte[].class);
        STATISTICS_FACE_MTK = new CaptureResult.Key("com.mediatek.facefeature.additionalresult", int[].class);
    }
}
