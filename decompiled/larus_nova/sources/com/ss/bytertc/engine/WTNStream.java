package com.ss.bytertc.engine;

import com.ss.bytertc.engine.adapter.VideoSinkAdapter;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.NativeWTNStreamEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class WTNStream implements IWTNStream {
    private static final String TAG = "WTNStream";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    NativeWTNStreamEventHandler mNativeHandler;
    private long mNativeWTNStream;
    private final ReentrantReadWriteLock mReadWriteLock;
    private WeakReference<IWTNStreamEventHandler> mWTNStreamEventHandler;

    public void destroy() {
        this.mJniWriteLock.lock();
        NativeWTNStreamFunctions.nativeDestroy(this.mNativeWTNStream);     // Catch: Throwable -> L6
        this.mNativeWTNStream = 0;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    public IWTNStreamEventHandler getWTNStreamEventHandler() {
        return this.mWTNStreamEventHandler.get();
    }

    public WTNStream(long r100) {
        this.mNativeWTNStream = 0;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNativeWTNStream = r100;
        this.mNativeHandler = new NativeWTNStreamEventHandler(this);
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public void enableWTNRemoteAudioFrameCallback(boolean r100) {
        this.mJniReadLock.lock();
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L7;
        LogUtil.e(TAG, "native engine is invalid, enableWTNRemoteAudioFrameCallback failed.");     // Catch: Throwable -> L10
    L7:
        LogUtil.d(TAG, "enableWTNRemoteAudioFrameCallback...");     // Catch: Throwable -> L10
        NativeWTNStreamFunctions.nativeEnableWTNRemoteAudioFrameCallback(this.mNativeWTNStream, r100);     // Catch: Throwable -> L10
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int registerWTNAudioFrameObserver(IWTNAudioFrameObserver r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native engine is invalid, registerWTNAudioFrameObserver failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
    L7:
        this.mJniReadLock.unlock();
        return r101;
    L9:
        LogUtil.d(TAG, "registerWTNAudioFrameObserver...");     // Catch: Throwable -> L11
        r101 = NativeWTNStreamFunctions.nativeRegisterWTNAudioFrameObserver(this.mNativeWTNStream, r100);     // Catch: Throwable -> L11
        goto L7
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNStreamEventHandler(IWTNStreamEventHandler r100) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeWTNStream != 0) goto L8;
        LogUtil.e(TAG, "native WTNStream is invalid, setWTNStreamEventHandler failed.");     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return -1;
    L8:
        this.mWTNStreamEventHandler = new WeakReference(r100);     // Catch: Throwable -> L16
        if (r100 != null) goto L13;
        int r101 = NativeWTNStreamFunctions.nativeSetWTNStreamEventHandler(this.mNativeWTNStream, null);     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return r101;
    L13:
        int r102 = NativeWTNStreamFunctions.nativeSetWTNStreamEventHandler(this.mNativeWTNStream, this.mNativeHandler);     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteAudioPlaybackVolume(String r100, int r101) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native engine is invalid, setWTNRemoteAudioPlaybackVolume failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
    L7:
        this.mJniReadLock.unlock();
        return r102;
    L9:
        LogUtil.d(TAG, "setWTNRemoteAudioPlaybackVolume...public stream id: " + r100 + ", volume: " + r101);     // Catch: Throwable -> L11
        r102 = NativeWTNStreamFunctions.nativeSetWTNRemoteAudioPlaybackVolume(this.mNativeWTNStream, r100, r101);     // Catch: Throwable -> L11
        goto L7
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteVideoCanvas(String r110, VideoCanvas r111) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native engine is invalid, setWTNRemoteVideoCanvas failed.");     // Catch: Throwable -> L11
        int r112 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
    L7:
        this.mJniReadLock.unlock();
        return r112;
    L9:
        LogUtil.d(TAG, "setWTNRemoteVideoCanvas...public stream id: " + r110);     // Catch: Throwable -> L11
        r112 = NativeWTNStreamFunctions.nativeSetWTNRemoteVideoCanvas(this.mNativeWTNStream, r110, r111.renderView, r111.renderMode, r111.backgroundColor, r111.renderRotation.value());     // Catch: Throwable -> L11
        goto L7
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int subscribeWTNAudioStream(String r100, boolean r101) {
        this.mJniReadLock.lock();
    L12:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native WTNStream is invalid, subscribeWTNAudioStream failed.");     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return -1;
    L9:
        LogUtil.d(TAG, "subscribeWTNAudioStream...public stream id: " + r100 + ", subscribe: " + r101);     // Catch: Throwable -> L12
        int r102 = NativeWTNStreamFunctions.nativeSubscribeWTNAudioStream(this.mNativeWTNStream, r100, r101);     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int subscribeWTNVideoStream(String r100, boolean r101) {
        this.mJniReadLock.lock();
    L12:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native WTNStream is invalid, subscribeWTNVideoStream failed.");     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return -1;
    L9:
        LogUtil.d(TAG, "subscribeWTNVideoStream...public stream id: " + r100 + ", subscribe: " + r101);     // Catch: Throwable -> L12
        int r102 = NativeWTNStreamFunctions.nativeSubscribeWTNVideoStream(this.mNativeWTNStream, r100, r101);     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.IWTNStream
    public int setWTNRemoteVideoSink(String r110, IVideoSink r111, RemoteVideoSinkConfig r112) {
        this.mJniReadLock.lock();
    L15:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeWTNStream != 0) goto L9;
        LogUtil.e(TAG, "native engine is invalid, setWTNRemoteVideoSink failed.");     // Catch: Throwable -> L15
        int r113 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L15
    L7:
        this.mJniReadLock.unlock();
        return r113;
    L9:
        LogUtil.d(TAG, "setWTNRemoteVideoSink...public stream id: " + r110);     // Catch: Throwable -> L15
        if (r111 == null) goto L12;
        VideoSinkAdapter r100 = new VideoSinkAdapter(r111);     // Catch: Throwable -> L15
    L13:
        r113 = NativeWTNStreamFunctions.nativeSetWTNRemoteVideoSink(this.mNativeWTNStream, r110, r100, r112.pixelFormat.value(), r112.position.getValue(), r112.applyRotation.getValue(), r112.mirrorType.getValue());     // Catch: Throwable -> L15
        goto L7
    L12:
        r100 = null;
        goto L13
    }
}
