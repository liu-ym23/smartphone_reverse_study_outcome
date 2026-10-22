package com.ss.bytertc.audio.device.router;

import com.bytedance.realx.base.RXLogging;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class AudioRouteController implements IAudioRouteCallback {
    public static int EVENT_ONLY_LOG = 0;
    public static int EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE = 1;
    private static final String TAG = "AudioRouteController";
    private int currentRouting;
    private boolean isMediaMode;
    private ReadWriteLock lock;
    private AudioRouteDeviceManager mAudioRouteDeviceManager;
    private long nativeAudioRouteControllerPtr;
    private Lock rLock;
    private Lock wLock;

    private native void onDeviceEvent(long r100, int r101, boolean r102, String r103);

    private native void onError(long r100, int r101);

    private String getCaptureDeviceName() {
        this.rLock.lock();
    L10:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L4:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        String r100 = "nativePtr is 0";
    L6:
        this.rLock.unlock();
        return r100;
    L8:
        r100 = this.mAudioRouteDeviceManager.getCaptureDeviceName();     // Catch: Throwable -> L10
        goto L6
    }

    private String getRenderDeviceName() {
        this.rLock.lock();
    L10:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L4:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        String r100 = "nativePtr is 0";
    L6:
        this.rLock.unlock();
        return r100;
    L8:
        r100 = this.mAudioRouteDeviceManager.getRenderDeviceName();     // Catch: Throwable -> L10
        goto L6
    }

    private String getSessionInfo() {
        this.rLock.lock();
    L10:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L4:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        String r100 = "nativePtr is 0";
    L6:
        this.rLock.unlock();
        return r100;
    L8:
        r100 = this.mAudioRouteDeviceManager.getSessionInfo();     // Catch: Throwable -> L10
        goto L6
    }

    private int init() {
        this.rLock.lock();
    L14:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L9;
    L6:
        this.rLock.unlock();
        return -1;
    L9:
        if (initAudioRouteDeviceManager() != 0) goto L6;
        int r100 = this.mAudioRouteDeviceManager.getDeviceState();     // Catch: Throwable -> L14
        this.rLock.unlock();
        return r100;
    }

    private int initAudioRouteDeviceManager() {
        int r100 = this.mAudioRouteDeviceManager.init();
        if (r100 == 0) goto L5;
        release();
        RXLogging.e(TAG, "init failed. code: " + r100);
    L5:
        return r100;
    }

    private int release() {
        this.wLock.lock();
        RXLogging.w(TAG, "AudioRouteController: release begin");
        this.nativeAudioRouteControllerPtr = 0;     // Catch: Throwable -> L10
        AudioRouteDeviceManager r100 = this.mAudioRouteDeviceManager;     // Catch: Throwable -> L10
        if (r100 == null) goto L6;
        int r101 = r100.release();     // Catch: Throwable -> L10
        this.mAudioRouteDeviceManager = null;     // Catch: Throwable -> L10
    L7:
        this.currentRouting = -1;     // Catch: Throwable -> L10
        this.isMediaMode = true;     // Catch: Throwable -> L10
        RXLogging.w(TAG, "AudioRouteController: release end");
        this.wLock.unlock();
        return r101;
    L6:
        r101 = 0;
    L10:
        th = move-exception;
        RXLogging.w(TAG, "AudioRouteController: release end");
        this.wLock.unlock();
        throw th;
    }

    private void restartBluetoothSco() {
        this.rLock.lock();
    L13:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        this.rLock.unlock();
        return;
    L8:
        AudioRouteDeviceManager r100 = this.mAudioRouteDeviceManager;     // Catch: Throwable -> L13
        if (r100 == null) goto L11;
        r100.restartBluetoothSco();     // Catch: Throwable -> L13
    L11:
        this.rLock.unlock();
    }

    private void stopBluetoothSco() {
        this.rLock.lock();
    L13:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L9;
        this.rLock.unlock();
        return;
    L9:
        if (this.mAudioRouteDeviceManager == null) goto L11;
        RXLogging.w(TAG, "stopBluetoothSco, begin");     // Catch: Throwable -> L13
        this.mAudioRouteDeviceManager.stopBluetoothSco();     // Catch: Throwable -> L13
    L11:
        this.rLock.unlock();
    }

    private AudioRouteController(long r100) {
        this.currentRouting = -1;
        this.isMediaMode = true;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.lock = r101;
        this.rLock = r101.readLock();
        this.wLock = this.lock.writeLock();
        this.nativeAudioRouteControllerPtr = r100;
        this.mAudioRouteDeviceManager = new AudioRouteDeviceManager(this);
    }

    private void setAudioRouteEnable(boolean r100) {
        this.rLock.lock();
    L13:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        this.rLock.unlock();
        return;
    L8:
        AudioRouteDeviceManager r101 = this.mAudioRouteDeviceManager;     // Catch: Throwable -> L13
        if (r101 == null) goto L11;
        r101.setAudioRouteEnable(r100);     // Catch: Throwable -> L13
    L11:
        this.rLock.unlock();
    }

    private int setUseAudioDeviceCallback(boolean r100) {
        this.rLock.lock();
    L18:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
    L6:
        this.rLock.unlock();
        return -1;
    L8:
        AudioRouteDeviceManager r101 = this.mAudioRouteDeviceManager;     // Catch: Throwable -> L18
        if (r101 == null) goto L16;
        r101.release();     // Catch: Throwable -> L18
        this.mAudioRouteDeviceManager.setUseAudioDeviceCallback(r100, this);     // Catch: Throwable -> L18
        if (initAudioRouteDeviceManager() != 0) goto L6;
        int r102 = this.mAudioRouteDeviceManager.getDeviceState();     // Catch: Throwable -> L18
        this.rLock.unlock();
        return r102;
    L16:
        this.rLock.unlock();
        return 0;
    }

    private int setAudioRoute(int r100, boolean r110) {
        this.rLock.lock();
        RXLogging.w(TAG, "AudioRouteController: setAudioRoute, begin, routing: " + r100 + ", isMediaMode: " + r110);
    L15:
        th = move-exception;
        RXLogging.w(TAG, "AudioRouteController: setAudioRoute, end, routing: " + r100 + ", isMediaMode: " + r110);
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        RXLogging.w(TAG, "AudioRouteController: setAudioRoute, end, routing: " + r100 + ", isMediaMode: " + r110);
        this.rLock.unlock();
        return -5;
    L8:
        this.isMediaMode = r110;     // Catch: Throwable -> L15
        int r101 = this.mAudioRouteDeviceManager.setAudioRoute(r100, r110);     // Catch: Throwable -> L15
        if (r101 != 0) goto L11;
        int r102 = r100;
    L12:
        this.currentRouting = r102;     // Catch: Throwable -> L15
        RXLogging.w(TAG, "AudioRouteController: setAudioRoute, end, routing: " + r100 + ", isMediaMode: " + r110);
        this.rLock.unlock();
        return r101;
    L11:
        r102 = this.currentRouting;     // Catch: Throwable -> L15
        goto L12
    }

    @Override // com.ss.bytertc.audio.device.router.IAudioRouteCallback
    public void onError(int r100, String r101) {
        this.rLock.lock();
    L16:
        th = move-exception;
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        this.rLock.unlock();
        return;
    L8:
        RXLogging.e(TAG, "AudioRouteController: ERROR-" + r100 + ":" + r101);     // Catch: Throwable -> L16
        if (r100 != EVENT_SCO_FAILED_FORCE_TO_MEDIA_MODE) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        onError(this.nativeAudioRouteControllerPtr, r100);     // Catch: Throwable -> L16
    L14:
        this.rLock.unlock();
        return;
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.ss.bytertc.audio.device.router.IAudioRouteCallback
    public void onDeviceEvent(int r110, boolean r111, String r112) {
        this.rLock.lock();
        RXLogging.w(TAG, "onDeviceEvent, begin, deviceType: " + r110 + ", connected: " + r111 + ", deviceInfo:" + r112);
    L11:
        th = move-exception;
        RXLogging.w(TAG, "AudioRouteController: onDeviceEvent, end");
        this.rLock.unlock();
        throw th;
    L5:
        if (this.nativeAudioRouteControllerPtr != 0) goto L8;
        RXLogging.w(TAG, "AudioRouteController: onDeviceEvent, end");
        this.rLock.unlock();
        return;
    L8:
        RXLogging.e(TAG, "AudioRouteController: onDeviceEvent(Java) deviceType:" + r110 + ", connected:" + r111 + ", deviceInfo:" + r112);     // Catch: Throwable -> L11
        onDeviceEvent(this.nativeAudioRouteControllerPtr, r110, r111, r112);     // Catch: Throwable -> L11
        RXLogging.w(TAG, "AudioRouteController: onDeviceEvent, end");
        this.rLock.unlock();
    }
}
