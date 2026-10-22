package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.InternalExpressDetectInfo;
import com.ss.bytertc.engine.InternalRectangle;
import com.ss.bytertc.engine.video.ExpressionDetectInfo;
import com.ss.bytertc.engine.video.ExpressionDetectResult;
import com.ss.bytertc.engine.video.FaceDetectionResult;
import com.ss.bytertc.engine.video.IFaceDetectionObserver;
import com.ss.bytertc.engine.video.RTCVideoEffect;
import com.ss.bytertc.engine.video.Rectangle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class RTCFaceDetectionObserver {
    private static final String TAG = "RTCFaceDetectionObserver";
    private WeakReference<RTCVideoEffect> mVideoEffect;

    public RTCFaceDetectionObserver(RTCVideoEffect r100) {
        this.mVideoEffect = new WeakReference(r100);
    }

    public void OnExpressionDetectResult(int r110, int r210, InternalExpressDetectInfo[] r211) {
        WeakReference<RTCVideoEffect> r100 = this.mVideoEffect;
        if (r100 == null) goto L7;
        RTCVideoEffect r101 = r100.get();
        if (r101 == null) goto L7;
        IFaceDetectionObserver r102 = r101.getFaceDetectionObserver();
    L8:
        if (r102 != null) goto L10;
        return;
    L10:
        ExpressionDetectResult r103 = new ExpressionDetectResult();
        r103.detectResult = r110;
        if (r110 != 0) goto L18;
        if (r211 == null) goto L17;
        if (r210 <= 0) goto L17;
        r103.detectInfo = new ExpressionDetectInfo[r210];
        r103.faceCount = r210;
        int r104 = 0;
    L15:
        if (r104 >= r210) goto L19;
        InternalExpressDetectInfo r105 = r211[r104];
        r103.detectInfo[r104] = new ExpressionDetectInfo(r105.age, r105.boyProb, r105.attractive, r105.happyScore, r105.sadScore, r105.angryScore, r105.surpriseScore, r105.arousal, r105.valence);
        r104 = r104 + 1;
    L19:
        r102.onExpressionDetectResult(r103);
        return;
    L17:
        r103.detectInfo = null;
        goto L19
    L18:
        r103.detectInfo = null;
    L7:
        r102 = null;
        goto L8
    }

    public void OnFaceDetectResult(int r100, int r101, int r102, int r103, InternalRectangle[] r104, long r110) {
        WeakReference<RTCVideoEffect> r105 = this.mVideoEffect;
        if (r105 == null) goto L7;
        RTCVideoEffect r106 = r105.get();
        if (r106 == null) goto L7;
        IFaceDetectionObserver r107 = r106.getFaceDetectionObserver();
    L8:
        if (r107 != null) goto L10;
        return;
    L10:
        FaceDetectionResult r108 = new FaceDetectionResult();
        r108.imageWidth = r101;
        r108.imageHeight = r102;
        r108.frameTimestampUs = r110;
        r108.detectResult = r100;
        if (r104 != null) goto L13;
    L17:
        r108.faces = null;
    L18:
        r107.onFaceDetectResult(r108);
        return;
    L13:
        if (r104.length <= 0) goto L17;
        r108.faces = new Rectangle[r104.length];
        int r109 = 0;
    L15:
        if (r109 >= r103) goto L18;
        Rectangle[] r111 = r108.faces;
        InternalRectangle r112 = r104[r109];
        r111[r109] = new Rectangle(r112.f456191x, r112.f456192y, r112.width, r112.height);
        r109 = r109 + 1;
    L7:
        r107 = null;
        goto L8
    }
}
