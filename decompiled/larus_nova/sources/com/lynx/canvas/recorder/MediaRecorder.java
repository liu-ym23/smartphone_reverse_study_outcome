package com.lynx.canvas.recorder;

import android.view.Surface;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonMediaRecorder;
import com.lynx.canvas.KryptonMediaRecorderService;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes32.dex */
public class MediaRecorder implements KryptonMediaRecorder.Listener {
    public static final String TAG = "KryptonMediaRecorder";
    private final KryptonApp mKryptonApp;
    private volatile long mNativePtr;
    private KryptonMediaRecorder mRecorderImpl;

    private native void nativeNotifyClipEndWithError(long r100, String r101);

    private native void nativeNotifyClipEndWithResult(long r100, String r101, String r102, float r103, long r104);

    private native void nativeNotifyFlushRecord(long r100);

    private native void nativeNotifyStartError(long r100, String r101);

    private native void nativeNotifyStopWithError(long r100, String r101);

    private native void nativeNotifyStopWithResult(long r100, String r101, String r102, float r103, long r104);

    private KryptonMediaRecorder createMediaRecorder() {
        KryptonMediaRecorderService r100 = (KryptonMediaRecorderService) this.mKryptonApp.getService(KryptonMediaRecorderService.class);
        if (r100 != null) goto L6;
        KryptonLLog.e("KryptonMediaRecorder", "media recorder service not found");
        return null;
    L6:
        KryptonMediaRecorder r101 = r100.createMediaRecorder();
        if (r101 != null) goto L10;
        KryptonLLog.e("KryptonMediaRecorder", "service create media recorder return null");
        return null;
    L10:
        return r101;
    }

    public long lastPresentationTime() {
        return this.mRecorderImpl.lastPresentationTime();
    }

    public void pauseRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "pause record");
        this.mRecorderImpl.pauseRecord();
    }

    public void resumeRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "resume record");
        this.mRecorderImpl.resumeRecord();
    }

    public Surface startRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "start record");
        return this.mRecorderImpl.startRecord();
    }

    public void stopRecord() {
        KryptonLLog.i("KryptonMediaRecorder", "stop record");
        this.mRecorderImpl.stopRecord();
    }

    public boolean clipVideo(long[] r100) {
        KryptonLLog.i("KryptonMediaRecorder", "clip video");
        return this.mRecorderImpl.clipVideo(r100);
    }

    public synchronized void destroy(boolean r100) {
        monitor-enter(this);
        KryptonLLog.i("KryptonMediaRecorder", MapMonitorConst.EVENT_DESTROY);     // Catch: Throwable -> L6
        this.mNativePtr = 0;     // Catch: Throwable -> L6
        this.mRecorderImpl.destroy(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordFlush(KryptonMediaRecorder r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativePtr == 0) goto L6;
        nativeNotifyFlushRecord(this.mNativePtr);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public MediaRecorder(long r100, KryptonApp r101) {
        this.mNativePtr = r100;
        this.mKryptonApp = r101;
        KryptonMediaRecorder r102 = createMediaRecorder();
        this.mRecorderImpl = r102;
        r102.setListener(this);
    }

    public static MediaRecorder create(long r100, KryptonApp r101) {
        return new MediaRecorder(r100, r101);
    }

    public void onAudioSample(ByteBuffer r100, int r101) {
        this.mRecorderImpl.onAudioSample(r100, r101);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEndWithError(KryptonMediaRecorder r100, String r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder clip end with error " + r101);     // Catch: Throwable -> L9
        nativeNotifyClipEndWithError(this.mNativePtr, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStartError(KryptonMediaRecorder r100, String r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder start error " + r101);     // Catch: Throwable -> L9
        nativeNotifyStartError(this.mNativePtr, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStopWithError(KryptonMediaRecorder r100, String r101) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.w("KryptonMediaRecorder", "on recorder stop with error " + r101);     // Catch: Throwable -> L9
        nativeNotifyStopWithError(this.mNativePtr, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public void configAudio(int r100, int r101, int r102) {
        KryptonLLog.i("KryptonMediaRecorder", "use audio");
        this.mRecorderImpl.configAudio(r100, r101, r102);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onClipVideoEnd(KryptonMediaRecorder r110, String r111, String r112, float r113, long r114) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.i("KryptonMediaRecorder", "on recorder clip end with result. duration:" + r113 + ", size:" + r114);     // Catch: Throwable -> L9
        nativeNotifyClipEndWithResult(this.mNativePtr, r111, r112, r113, r114);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    @Override // com.lynx.canvas.KryptonMediaRecorder.Listener
    public synchronized void onRecordStop(KryptonMediaRecorder r110, String r111, String r112, float r113, long r114) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativePtr == 0) goto L7;
        KryptonLLog.i("KryptonMediaRecorder", "on recorder stop with result. duration:" + r113 + ", size:" + r114);     // Catch: Throwable -> L9
        nativeNotifyStopWithResult(this.mNativePtr, r111, r112, r113, r114);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
    }

    public void configVideo(String r100, int r101, int r110, int r111, int r112, int r113) {
        this.mRecorderImpl.configVideo(r100, r101, r110, r111, r112, r113);
    }
}
