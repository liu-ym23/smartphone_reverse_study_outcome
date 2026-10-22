package com.ss.bytertc.base.media.screen;

import android.content.Intent;
import android.os.Build;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.video.EglBase;
import com.ss.bytertc.base.media.CapturerObserver;
import com.ss.bytertc.base.media.VideoCapturer;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenVideoCaptureAndroid {
    private static final int ScreenCaptureModelMediaProjection = 0;
    private static final int ScreenCaptureModelMediaProjectionWithForegroundService = 1;
    private static final String TAG = "ScreenVideoCaptureAndroid";
    private EglBase cameraEglBase;
    private CapturerObserver localCapturerObserver;
    private Intent mCaptureScreenIntent;
    private boolean mIsVideoCaptureInited;
    private boolean mIsVideoCaptureWorking;
    private long mNativeCaptureObserver;
    private VideoCapturer mVideoCapturer;
    private EglBase.Context sharedEglGroup;

    public void release() {
        if (this.mVideoCapturer == null) goto L5;
        stopCapture();
        this.mVideoCapturer.dispose();
        this.mVideoCapturer = null;
    L5:
        EglBase r100 = this.cameraEglBase;
        if (r100 == null) goto L8;
        r100.release();
        this.cameraEglBase = null;
    L8:
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
    }

    public void stopCapture() {
        VideoCapturer r100 = this.mVideoCapturer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return;
    L7:
        if (this.mIsVideoCaptureWorking == false) goto L17;
        r100.stopCapture();     // Catch: InterruptedException -> L10
        this.mIsVideoCaptureWorking = false;     // Catch: InterruptedException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static /* synthetic */ long access$000(ScreenVideoCaptureAndroid r100) {
        return r100.mNativeCaptureObserver;
    }

    public static /* synthetic */ VideoCapturer access$100(ScreenVideoCaptureAndroid r100) {
        return r100.mVideoCapturer;
    }

    public static /* synthetic */ boolean access$200(ScreenVideoCaptureAndroid r100) {
        return r100.mIsVideoCaptureInited;
    }

    public static /* synthetic */ boolean access$300(ScreenVideoCaptureAndroid r100) {
        return r100.mIsVideoCaptureWorking;
    }

    public static /* synthetic */ CapturerObserver access$400(ScreenVideoCaptureAndroid r100) {
        return r100.localCapturerObserver;
    }

    private VideoCapturer createVideoCapturer(Intent r100) {
        return new ScreenCapturerAndroid(r100, new AnonymousClass2(this));
    L4:
        e = move-exception;
        LogUtil.e(TAG, "Create VideoCapture fail : " + e.getMessage());
        return null;
    }

    public ScreenVideoCaptureAndroid(long r100, EglBase.Context r101) {
        this.mVideoCapturer = null;
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        this.cameraEglBase = null;
        this.sharedEglGroup = null;
        this.mCaptureScreenIntent = null;
        this.localCapturerObserver = new AnonymousClass1(this);
        this.mNativeCaptureObserver = r100;
        this.sharedEglGroup = r101;
    }

    private void startVideoCapture(int r100, int r101, int r102) {
        VideoCapturer r103 = this.mVideoCapturer;
        if (r103 == null) goto L11;
        r103.startCapture(r100, r101, r102);     // Catch: IllegalArgumentException -> L6
        this.mIsVideoCaptureWorking = true;     // Catch: IllegalArgumentException -> L6
        return;
    L6:
        e = move-exception;
        LogUtil.e(TAG, "VideoCapture startCapture fail : " + e.getMessage());
        return;
    }

    public void changeCaptureFormat(int r100, int r101, int r102) {
        VideoCapturer r103 = this.mVideoCapturer;
        if (r103 != null) goto L5;
        return;
    L5:
        if (this.mIsVideoCaptureInited == true) goto L7;
        return;
    L7:
        if (this.mIsVideoCaptureWorking == false) goto L12;
        r103.changeCaptureFormat(r100, r101, r102);
        return;
    }

    public void startCapture(int r100, int r101, int r102, Intent r103) {
        if (r103 != null) goto L5;
        LogUtil.e(TAG, "startCapture failed, intent is null");
        return;
    L5:
        this.mCaptureScreenIntent = r103;
        VideoCapturer r104 = this.mVideoCapturer;
        if (r104 == null) goto L9;
        r104.dispose();
        this.mVideoCapturer = null;
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
    L9:
        if (Build.VERSION.SDK_INT <= 28) goto L11;
        int r105 = 1;
    L12:
        RTCScreenVideoNativeFunctions.nativeOnCapturerSetType(this.mNativeCaptureObserver, r105);
        this.mVideoCapturer = createVideoCapturer(this.mCaptureScreenIntent);
        if (this.cameraEglBase != null) goto L15;
        this.cameraEglBase = EglBase.CC.create(this.sharedEglGroup);
    L15:
        VideoCapturer r106 = this.mVideoCapturer;
        if (r106 == null) goto L18;
        ((ScreenCapturerAndroid) r106).initialize(this.cameraEglBase.getEglBaseContext(), ContextUtils.getApplicationContext(), this.localCapturerObserver);
        this.mIsVideoCaptureInited = true;
        startVideoCapture(r100, r101, r102);
        return;
    L18:
        this.mIsVideoCaptureInited = false;
        this.mIsVideoCaptureWorking = false;
        return;
    L11:
        r105 = 0;
        goto L12
    }
}
