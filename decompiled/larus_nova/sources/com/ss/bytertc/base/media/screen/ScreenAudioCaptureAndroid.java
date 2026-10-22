package com.ss.bytertc.base.media.screen;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.realx.base.ContextUtils;

/* JADX INFO: loaded from: classes40.dex */
public class ScreenAudioCaptureAndroid implements ScreenAudioCaptureObserver {
    private static final String TAG = "ScreenAudioCaptureAndroid";
    private Context mContext;
    private boolean mIsAudioCaptureWorking;
    private long mNativeCaptureObserver;

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onCapturerStarted() {
        RTCScreenAudioNativeFunctions.nativeOnCapturerStarted(this.mNativeCaptureObserver);
    }

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onCapturerStopped() {
        RTCScreenAudioNativeFunctions.nativeOnCapturerStopped(this.mNativeCaptureObserver);
    }

    public void stopCapture() {
        if (this.mIsAudioCaptureWorking == false) goto L16;
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L5:
        if (Build.VERSION.SDK_INT > 28) goto L7;
    L9:
        this.mIsAudioCaptureWorking = false;     // Catch: Exception -> L11
        return;
    L7:
        if (RXScreenCaptureService.serviceStarted.get() == false) goto L9;
        Context r100 = this.mContext;     // Catch: Exception -> L11
        r100.startForegroundService(RXScreenCaptureService.getServiceIntent(r100, 7, null));     // Catch: Exception -> L11
        goto L9
    }

    public void release() {
        stopCapture();
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.mContext != null) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT > 28) goto L8;
        return;
    L8:
        if (RXScreenCaptureService.serviceStarted.get() == false) goto L18;
        Context r100 = this.mContext;     // Catch: Exception -> L11
        r100.startForegroundService(RXScreenCaptureService.getServiceIntent(r100, 8, null));     // Catch: Exception -> L11
        return;
    }

    public void startCapture() {
        Context r100 = ContextUtils.getApplicationContext();     // Catch: Exception -> L13
        this.mContext = r100;     // Catch: Exception -> L13
        if (Build.VERSION.SDK_INT > 28) goto L5;
    L11:
        RTCScreenAudioNativeFunctions.nativeOnCapturerError(this.mNativeCaptureObserver, 1);     // Catch: Exception -> L13
        return;
    L5:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.RECORD_AUDIO") != 0) goto L11;
        ScreenAudioCaptureAndroidManager.INSTANCE().initialize(this.mContext, this);     // Catch: Exception -> L13
        if (RXScreenCaptureService.serviceStarted.get() == false) goto L10;
        Context r101 = this.mContext;     // Catch: Exception -> L13
        r101.startForegroundService(RXScreenCaptureService.getServiceIntent(r101, 6, null));     // Catch: Exception -> L13
    L10:
        this.mIsAudioCaptureWorking = true;     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public ScreenAudioCaptureAndroid(long r100) {
        this.mIsAudioCaptureWorking = false;
        this.mNativeCaptureObserver = r100;
    }

    @Override // com.ss.bytertc.base.media.screen.ScreenAudioCaptureObserver
    public void onAudioFrameCapture(byte[] r100, int r101, int r102, int r110) {
        RTCScreenAudioNativeFunctions.nativeOnAuidoFrameCaptured(this.mNativeCaptureObserver, r100, r101, r102, r110);
    }
}
