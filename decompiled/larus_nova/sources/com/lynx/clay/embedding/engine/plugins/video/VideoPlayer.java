package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes32.dex */
public class VideoPlayer implements com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a {
    private static final int DEFAULT_POSITION_INTERVAL = 166;
    private static final int MIN_POSITION_INTERVAL = 15;
    private static final String TAG = "VideoPlayer";
    private final ClayPluginContext ClayPluginContext;
    private Handler mainHandler;
    private long nativePtr;
    private SurfaceTexture surfaceTexture;
    private boolean updatePosition;
    private int updatePositionInterval;
    private final Runnable updatePositionRunnable;
    private Timer updatePositionTimer;
    private TimerTask updatePositionTimerTask;
    private com.lynx.clay.embedding.engine.plugins.video.a videoEngine;
    private d videoRenderer;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayer f380891a;

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = this.f380891a.getPosition();     // Catch: Throwable -> L6
            if (r100 < 0) goto L9;
            this.f380891a.onPositionUpdated(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(VideoPlayer r100) {
            this.f380891a = r100;
        }
    }

    public class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoPlayer f380892a;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (VideoPlayer.access$000(this.f380892a) == false) goto L9;
            VideoPlayer.access$200(this.f380892a).post(VideoPlayer.access$100(this.f380892a));     // Catch: Throwable -> L6
            return;
        }

        public b(VideoPlayer r100) {
            this.f380892a = r100;
        }
    }

    private static native void nativeOnBufferingChange(long r100, int r101);

    private static native void nativeOnCanPlay(long r100);

    private static native void nativeOnEnded(long r100);

    private static native void nativeOnError(long r100, int r101, String r102, String r103);

    private static native void nativeOnFirstFrame(long r100);

    private static native void nativeOnPause(long r100);

    private static native void nativeOnPlay(long r100);

    private static native void nativeOnPlaying(long r100);

    private static native void nativeOnPositionUpdated(long r100, int r101);

    private static native void nativeOnPrepared(long r100, int r101);

    private static native void nativeOnVideoInfos(long r100, String r101, long r102);

    private static native void nativeOnVideoSizeChanged(long r100, int r101, int r102);

    private static native void nativeOnWaiting(long r100);

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onEnded() {
        this.updatePosition = false;
        nativeOnEnded(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onPause() {
        this.updatePosition = false;
        nativeOnPause(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onPlay() {
        this.updatePosition = true;
        nativeOnPlay(this.nativePtr);
    }

    private void ensureVideoRenderer() {
        boolean r100 = false;
        if (this.surfaceTexture == null) goto L5;
        boolean r101 = true;
    L6:
        d r102 = this.videoRenderer;
        if (r102 != null) goto L9;
    L14:
        if (r101 == false) goto L16;
        d r103 = new f(this.surfaceTexture);
    L17:
        this.videoRenderer = r103;
        r103.a(this.ClayPluginContext.f380756a, this.videoEngine);
        return;
    L16:
        r103 = new e();
        goto L17
    L9:
        if (r102.c() == 1) goto L11;
        r100 = true;
    L11:
        if (r100 != r101) goto L13;
        this.videoRenderer.dispose();
        goto L14
    L13:
        return;
    L5:
        r101 = false;
        goto L6
    }

    private void stopTimer() {
        TimerTask r100 = this.updatePositionTimerTask;
        if (r100 == null) goto L6;
        r100.cancel();
        this.updatePositionTimerTask = null;
        return;
    }

    public int getDuration() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getDuration();
    }

    public int getPosition() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getPosition();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onCanPlay() {
        nativeOnCanPlay(this.nativePtr);
    }

    public void onEnterBackground() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L11;
        r100.enterBackground();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        c5a.c.d(6, TAG, "onEnterBackground error:" + th.toString());
        return;
    }

    public void onEnterForeground() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L11;
        r100.enterForeground();     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        c5a.c.d(6, TAG, "onEnterForeground error:" + th.toString());
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onFirstFrame() {
        nativeOnFirstFrame(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onPlaying() {
        nativeOnPlaying(this.nativePtr);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onWaiting() {
        nativeOnWaiting(this.nativePtr);
    }

    public void pause() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L6;
        r100.pause();
        return;
    }

    public void play() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L6;
        r100.play();
        return;
    }

    public void stop() {
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L6;
        r100.stop();
        return;
    }

    private void startTimer() {
        stopTimer();
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L9;
        r100.g();
        if (this.updatePositionTimer != null) goto L7;
        this.updatePositionTimer = new PthreadTimer("o/VideoPlayer");
    L7:
        b r101 = new b(this);
        this.updatePositionTimerTask = r101;
        this.updatePositionTimer.schedule(r101, 0, this.updatePositionInterval);
        return;
    }

    public void didUpdateAttributes() {
        ensureVideoRenderer();
        com.lynx.clay.embedding.engine.plugins.video.a r100 = this.videoEngine;
        if (r100 == null) goto L6;
        r100.d();
        return;
    }

    public void onDestroy() {
        stopTimer();
        Timer r100 = this.updatePositionTimer;
        if (r100 == null) goto L5;
        r100.cancel();
        this.updatePositionTimer = null;
    L5:
        d r101 = this.videoRenderer;
        if (r101 == null) goto L8;
        r101.detach();
        this.videoRenderer.dispose();
        this.videoRenderer = null;
    L8:
        com.lynx.clay.embedding.engine.plugins.video.a r102 = this.videoEngine;
        if (r102 == null) goto L11;
        r102.dispose();
        this.videoEngine = null;
    L11:
        this.nativePtr = 0;
    }

    public void onCompletion() {
        onEnded();
    }

    public VideoPlayer(ClayPluginContext r100) {
        this.updatePositionRunnable = new a(this);
        this.updatePositionInterval = 166;
        this.updatePosition = false;
        this.ClayPluginContext = r100;
        Context r101 = r100.f380756a.getContext();
        this.mainHandler = new Handler(r101.getMainLooper());
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r5a.a.a(r101) == true) goto L14;
    L9:
        com.lynx.clay.embedding.engine.plugins.video.a r102 = new VideoEngineMPImpl(this);     // Catch: Throwable -> L12
    L10:
        this.videoEngine = r102;
        startTimer();
        return;
    L14:
        r102 = new com.lynx.clay.embedding.engine.plugins.video.b(r101, this);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L12
        goto L9
    }

    public static VideoPlayer Create(ClayPluginContext r100) {
        return new VideoPlayer(r100);
    }

    public static /* synthetic */ boolean access$000(VideoPlayer r100) {
        return r100.updatePosition;
    }

    public static /* synthetic */ Runnable access$100(VideoPlayer r100) {
        return r100.updatePositionRunnable;
    }

    public static /* synthetic */ Handler access$200(VideoPlayer r100) {
        return r100.mainHandler;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onBufferingChange(int r100) {
        nativeOnBufferingChange(this.nativePtr, r100);
    }

    public void onPositionUpdated(int r100) {
        nativeOnPositionUpdated(this.nativePtr, r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onPrepared(int r100) {
        nativeOnPrepared(this.nativePtr, r100);
    }

    public void seekTo(int r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.seekTo(r100);
        return;
    }

    public void setAutoplay(boolean r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void setCache(boolean r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.f(r100);
        return;
    }

    public void setInitTime(int r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.h(r100);
        return;
    }

    public void setLoop(boolean r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.setLoop(r100);
        return;
    }

    public void setMuted(boolean r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.setMuted(r100);
        return;
    }

    public void setNativePtr(long r100) {
        this.nativePtr = r100;
    }

    public void setPreloadKey(String r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.i(r100);
        return;
    }

    public void setReuseEngine(boolean r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.j(r100);
        return;
    }

    public void setSpeed(float r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.setSpeed(r100);
        return;
    }

    public void setSrc(String r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.setSrc(r100);
        return;
    }

    public void setSurfaceTexture(SurfaceTexture r100) {
        this.surfaceTexture = r100;
    }

    public void setTimeUpdateInterval(int r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        stopTimer();
        if (r100 >= 15) goto L8;
        r100 = 15;
    L8:
        this.updatePositionInterval = r100;
        startTimer();
    }

    public void setVolume(double r100) {
        com.lynx.clay.embedding.engine.plugins.video.a r101 = this.videoEngine;
        if (r101 == null) goto L6;
        r101.setVolume(r100);
        return;
    }

    public void onError(int r100, int r101) {
        onError(r100, "", "");
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onVideoInfos(String r100, long r101) {
        nativeOnVideoInfos(this.nativePtr, r100, r101);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onVideoSizeChanged(int r100, int r101) {
        nativeOnVideoSizeChanged(this.nativePtr, r100, r101);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.video.a.InterfaceC4551a
    public void onError(int r100, String r101, String r102) {
        this.updatePosition = false;
        nativeOnError(this.nativePtr, r100, r101, r102);
    }

    public void updateVideoBound(int r100, int r101, int r102, int r103) {
        c5a.c.d(6, TAG, String.format("updateVideoBound x=%d, y=%d, w=%d, h=%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)}));
        d r104 = this.videoRenderer;
        if (r104 == null) goto L6;
        r104.b(r100, r101, r102, r103);
        return;
    }
}
