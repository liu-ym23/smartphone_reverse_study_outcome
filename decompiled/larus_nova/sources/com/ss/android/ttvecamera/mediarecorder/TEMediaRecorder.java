package com.ss.android.ttvecamera.mediarecorder;

import android.media.MediaCodec;
import android.media.MediaMetadataRetriever;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.b;
import f06.c;
import f06.d;
import g06.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TEMediaRecorder {
    private static final SparseIntArray ORIENTATIONS = null;
    public static final int PAUSE = 2;
    public static final int RESUME = 3;
    private static final int ROTATION_DEGREE_0 = 0;
    private static final int ROTATION_DEGREE_180 = 180;
    private static final int ROTATION_DEGREE_270 = 270;
    private static final int ROTATION_DEGREE_30 = 30;
    private static final int ROTATION_DEGREE_360 = 360;
    private static final int ROTATION_DEGREE_90 = 90;
    public static final int START = 0;
    public static final int STOP = 1;
    private static final String TAG = "TEMediaRecorder";
    public static final int TER_INIT_IO_ERROR = -604;
    public static final int TER_RUNNING_TIME_ERROR = -606;
    public static final int TER_STATE_ERROR = -605;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    private int mBitRate;
    private boolean mEnableStatus;
    private ErrorCallback mErrorCallback;
    private String mFolderPath;
    private int mFrameRate;
    private MediaRecorder mMediaRecorder;
    private int mOrientaton;
    private TEFrameSizei mPreviewSize;
    private int mState;
    private List<TEFrameSizei> mSupportSizes;
    private String mVideoFile;
    private Size mVideoSize;
    private Surface mVideoSurface;

    public interface ErrorCallback {
        void onError(int r100);
    }

    public void prepare() {
    }

    static {
        SparseIntArray r100 = new SparseIntArray();
        ORIENTATIONS = r100;
        r100.append(0, 90);
        r100.append(1, 0);
        r100.append(2, 270);
        r100.append(3, 180);
    }

    private void adjustRecordSize() {
        List<TEFrameSizei> r100 = this.mSupportSizes;
        if (r100 == null) goto L9;
        TEFrameSizei r101 = this.mPreviewSize;
        if (r101 == null) goto L10;
        TECameraUtils.calcPreviewSize(r100, r101, TECameraSettings.TEPreviewSizeStrategy.DEFAULT);
        return;
    L10:
        return;
    }

    private void clearInvalidFile() throws IOException {
        String r100 = this.mVideoFile;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L26;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mVideoFile);
        TELogUtils.d(TAG, "file length = " + r101.length());
        if (r101.exists() == true) goto L9;
    L12:
        MediaMetadataRetriever r102 = new MediaMetadataRetriever();
        r102.setDataSource(this.mVideoFile);     // Catch: IllegalArgumentException -> L15
        CastLongProtector.parseLong(com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(r102, 9));     // Catch: IllegalArgumentException -> L15
    L21:
        r102.release();     // Catch: IOException -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L15:
        deleteFile();
        TELogUtils.e(TAG, "cannot access the file");
        goto L21
    L9:
        if (r101.length() != 0) goto L12;
        r101.delete();
        this.mVideoFile = "";
        TELogUtils.d(TAG, "invalid video file deleted!");
        return;
    }

    private void startBackgroundThread() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("MediaRecorderBackground");
        this.mBackgroundThread = r100;
        ThreadMethodProxy.start(r100);
        this.mBackgroundHandler = new Handler(this.mBackgroundThread.getLooper());
    }

    private void stopBackgroundThread() {
        HandlerThread r100 = this.mBackgroundThread;
        if (r100 == null) goto L12;
        r100.quitSafely();
        ThreadMethodProxy.join(this.mBackgroundThread);     // Catch: InterruptedException -> L7
        this.mBackgroundThread = null;     // Catch: InterruptedException -> L7
        this.mBackgroundHandler = null;     // Catch: InterruptedException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public Surface createRecordSurface() {
        if (this.mVideoSurface != null) goto L6;
        this.mVideoSurface = MediaCodec.createPersistentInputSurface();
    L6:
        return this.mVideoSurface;
    }

    public void deleteFile() {
        String r100 = this.mVideoFile;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L11;
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mVideoFile);
        TELogUtils.d(TAG, "file length = " + r101.length());
        if (r101.exists() == false) goto L12;
        r101.delete();
        this.mVideoFile = "";
        TELogUtils.d(TAG, "invalid video file deleted!");
        return;
    L12:
        return;
    }

    public void release() throws IOException {
        TELogUtils.d(TAG, "[schedule] releaseMediaRecorder");
        if (this.mMediaRecorder == null) goto L13;
        TELogUtils.v(TAG, "Releasing media recorder.");
        this.mMediaRecorder.reset();     // Catch: IllegalStateException -> L7
    L9:
        clearInvalidFile();
        com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_release(this.mMediaRecorder);
        this.mMediaRecorder = null;
        stopBackgroundThread();
        return;
    L7:
        e = move-exception;
        TELogUtils.e(TAG, "media recorder maybe has been released! msg=" + e.getMessage());
        handleError(-605);
        goto L9
    }

    public void stopRecord() {
        if (this.mState == 1) goto L6;
        this.mBackgroundHandler.post(new AnonymousClass2(this));
        this.mState = 1;
        return;
    }

    public TEMediaRecorder() {
        this.mEnableStatus = false;
        this.mState = -1;
        this.mVideoSurface = null;
        this.mVideoSize = new Size(1280, 720);
        this.mFrameRate = 30;
        this.mBitRate = 10000000;
        this.mOrientaton = 0;
        this.mMediaRecorder = new MediaRecorder();
        startBackgroundThread();
    }

    public boolean pause() {
        this.mMediaRecorder.pause();     // Catch: Throwable -> L6 IllegalStateException -> L8
        TELogUtils.d(TAG, "pauseRecord end");
        return true;
    L8:
        TELogUtils.e(TAG, "mMediaRecorder pause state error");     // Catch: Throwable -> L6
        handleError(-605);     // Catch: Throwable -> L6
        TELogUtils.d(TAG, "pauseRecord end");
        return false;
    L6:
        th = move-exception;
        TELogUtils.d(TAG, "pauseRecord end");
        throw th;
    }

    public boolean resume() {
        TELogUtils.d(TAG, "[schedule] resume recording");
        this.mMediaRecorder.resume();     // Catch: Throwable -> L6 IllegalStateException -> L8
        TELogUtils.d(TAG, "resume end");
        return true;
    L6:
        th = move-exception;
        TELogUtils.d(TAG, "resume end");
        throw th;
    L8:
        TELogUtils.e(TAG, "mMediaRecorder resume state error");     // Catch: Throwable -> L6
        handleError(-605);     // Catch: Throwable -> L6
        TELogUtils.d(TAG, "resume end");
        return false;
    }

    public void start() throws IOException {
        com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_start(this.mMediaRecorder);     // Catch: Throwable -> L5 RuntimeException -> L7 IllegalStateException -> L8
        TELogUtils.d(TAG, "Recording starts!");     // Catch: Throwable -> L5 RuntimeException -> L7 IllegalStateException -> L8
    L4:
        TELogUtils.d(TAG, "start end");
        return;
    L5:
        th = move-exception;
        TELogUtils.d(TAG, "start end");
        throw th;
    L8:
        TELogUtils.e(TAG, "mMediaRecorder prepare not well!");     // Catch: Throwable -> L5
        clearInvalidFile();     // Catch: Throwable -> L5
        handleError(-605);     // Catch: Throwable -> L5
    L7:
        TELogUtils.e(TAG, "start error: runtime");     // Catch: Throwable -> L5
        deleteFile();     // Catch: Throwable -> L5
        handleError(-606);     // Catch: Throwable -> L5
        goto L4
    }

    public void stop() {
        com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_stop(this.mMediaRecorder);     // Catch: Throwable -> L5 RuntimeException -> L7 IllegalStateException -> L9
    L4:
        TELogUtils.d(TAG, "stopRecord end");
        return;
    L5:
        th = move-exception;
        TELogUtils.d(TAG, "stopRecord end");
        throw th;
    L9:
        TELogUtils.e(TAG, "mMediaRecorder stop state error");     // Catch: Throwable -> L5
        handleError(-605);     // Catch: Throwable -> L5
    L7:
        e = move-exception;
        TELogUtils.e(TAG, "going to clean up the invalid output file, exception message = " + e.getMessage());     // Catch: Throwable -> L5
        deleteFile();     // Catch: Throwable -> L5
        handleError(-606);     // Catch: Throwable -> L5
        goto L4
    }

    private static void com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_release(MediaRecorder r110) throws IOException {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100501, "android/media/MediaRecorder", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100501, "android/media/MediaRecorder", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100501, "android/media/MediaRecorder", "release", r110, r101, null, r111, true);
    }

    private static void com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_start(MediaRecorder r110) throws IOException {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100502, "android/media/MediaRecorder", "start", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100502, "android/media/MediaRecorder", "start", r110, r101, null, r111, false);
        return;
    L6:
        r110.start();
        r100.a(100502, "android/media/MediaRecorder", "start", r110, r101, null, r111, true);
    }

    private static void com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaRecorder_stop(MediaRecorder r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100503, "android/media/MediaRecorder", "stop", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100503, "android/media/MediaRecorder", "stop", r110, r101, null, r111, false);
        return;
    L6:
        r110.stop();
        r100.a(100503, "android/media/MediaRecorder", "stop", r110, r101, null, r111, true);
    }

    private void handleError(int r100) {
        ErrorCallback r101 = this.mErrorCallback;
        if (r101 == null) goto L6;
        r101.onError(r100);
        return;
    }

    public void setErrorCallback(ErrorCallback r100) {
        this.mErrorCallback = r100;
    }

    public void setFileName(String r100) throws IOException {
        if (r100 != null) goto L4;
    L5:
        TELogUtils.e(TAG, "empty file name");
    L6:
        clearInvalidFile();
        this.mVideoFile = r100;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        goto L5
    }

    public void setPreviewSize(TEFrameSizei r100) {
        this.mPreviewSize = r100;
    }

    public void setSupportSizes(List<TEFrameSizei> r100) {
        this.mSupportSizes = r100;
    }

    public void startRecord(int r100) {
        this.mOrientaton = r100;
        if (this.mState == 0) goto L6;
        this.mBackgroundHandler.post(new AnonymousClass1(this));
        this.mState = 0;
        return;
    }

    private static String com_ss_android_ttvecamera_mediarecorder_TEMediaRecorder_android_media_MediaMetadataRetriever_extractMetadata(MediaMetadataRetriever r110, int r111) throws IOException {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        b r112 = new b();
        a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public int getImageRotation(int r100, int r101) {
        TELogUtils.d(TAG, "getImageRotation: mSensorOrientation = " + r100);
        int r102 = 0;
        if (r101 <= 330) goto L5;
    L22:
        int r103 = (r102 + r100) % 360;
        TELogUtils.d(TAG, "getImageRotation: imageRotation = " + r103);
        return r103;
    L5:
        if (r101 < 30) goto L22;
        if (r101 <= 60) goto L13;
        if (r101 >= 120) goto L13;
        r102 = 90;
    L13:
        if (r101 <= 150) goto L18;
        if (r101 >= 210) goto L18;
        r102 = 180;
    L18:
        if (r101 <= 240) goto L22;
        if (r101 >= 300) goto L22;
        r102 = 270;
        goto L22
    }

    public void setRecorderSetting(int r100, int r101, int r102, int r103) {
        this.mVideoSize = new Size(r100, r101);
        this.mFrameRate = r102;
        this.mBitRate = r103;
    }
}
