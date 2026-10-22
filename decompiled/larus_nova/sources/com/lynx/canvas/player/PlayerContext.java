package com.lynx.canvas.player;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonReflectLoader;
import com.lynx.canvas.KryptonSettingsService;
import com.lynx.canvas.KryptonVideoPlayer;
import com.lynx.canvas.KryptonVideoPlayerService;
import com.lynx.canvas.SurfaceTextureWrapper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public class PlayerContext implements KryptonVideoPlayer.Listener {
    private static final int CAN_DRAW = 3;
    private static final int CAN_PLAY = 0;
    private static final int END = 1;
    private static final int ERROR = 2;
    private static final int PAUSED = 6;
    private static final int SEEK_END = 4;
    private static final int START_PLAY = 5;
    private static final String TAG = "PlayerContext";
    private static final String USE_CUSTOM_PLAYER = "useCustomPlayer";
    private Context mContext;
    private double mCurrentTime;
    private double mCurrentTimeCache;
    private final KryptonApp mKryptonApp;
    private Looper mLooperTriggerLoad;
    long mNativePtr;
    private Map<String, String> mOptions;
    private volatile boolean mPrepared;
    KryptonVideoPlayer mVideoPlayer;

    private static native void nativeNotifyPlayerState(long r100, int r101, int[] r102, String r103);

    private boolean checkTTEngineHardwareDecodeDisabled() {
        String r100 = Build.MODEL;
        boolean r101 = false;
        KryptonSettingsService r102 = (KryptonSettingsService) this.mKryptonApp.getService(KryptonSettingsService.class);     // Catch: Throwable -> L10
        if (r102 == null) goto L12;
        Collection r103 = (Collection) r102.objectValueForKey("TT_VIDEO_HARDWARE_DECODE_BLACK_LIST", null);     // Catch: Throwable -> L10
        if (r103 == null) goto L12;
        if (r103.contains(r100.toLowerCase()) == false) goto L12;
        r101 = true;
    L12:
        KryptonLLog.i(TAG, "checkTTEngineHardwareDecodeDisabled = " + r101 + " for " + r100);
        return r101;
    L10:
        th = move-exception;
        KryptonLLog.w(TAG, "checkTTEngineHardwareDecodeDisabled error " + th.toString());
        goto L12
    }

    private KryptonVideoPlayer createPlayer() {
        Map<String, String> r100 = this.mOptions;
        boolean r101 = false;
        if (r100 == null) goto L8;
        String r102 = r100.get(USE_CUSTOM_PLAYER);
        if (r102 == null) goto L7;
        r101 = Boolean.parseBoolean(r102);
    L7:
        KryptonLLog.i(TAG, "create player options: " + this.mOptions);
    L8:
        if (r101 == false) goto L15;
        KryptonVideoPlayerService r103 = (KryptonVideoPlayerService) this.mKryptonApp.getService(KryptonVideoPlayerService.class);
        if (r103 != null) goto L12;
        r103 = (KryptonVideoPlayerService) KryptonReflectLoader.inst().getHybridServiceInstance(KryptonVideoPlayerService.class);
    L12:
        if (r103 == null) goto L14;
        KryptonLLog.i(TAG, "create player using custom player service");
    L16:
        if (r103 != null) goto L18;
        r103 = new AnonymousClass1(this);
    L18:
        Boolean r104 = Boolean.valueOf(checkTTEngineHardwareDecodeDisabled());
        Map<String, String> r105 = this.mOptions;
        if (r105 == null) goto L22;
        r105.put("disable_tt_engine_hardware_decode", r104.toString());
    L25:
        return r103.createVideoPlayer(this.mOptions);
    L22:
        if (r104.booleanValue() == false) goto L25;
        HashMap r106 = new HashMap();
        this.mOptions = r106;
        r106.put("disable_tt_engine_hardware_decode", "true");
        goto L25
    L14:
        KryptonLLog.i(TAG, "create player using system player service, as custom player service is not set");
        goto L16
    L15:
        KryptonLLog.i(TAG, "create player using default player service");
        r103 = null;
        goto L16
    }

    public double getCurrentTime() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 != null) goto L7;
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L7:
        return r100.getCurrentTime();
    }

    public boolean getLoop() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.getLooping();
    }

    public double getPlaybackRate() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 != null) goto L7;
        return 1.0d;
    L7:
        return r100.getPlaybackRate();
    }

    public void pause() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isPlaying() == false) goto L10;
        this.mVideoPlayer.pause();
        return;
    }

    public void play() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.play();
    }

    public void release() {
        KryptonVideoPlayer r100 = this.mVideoPlayer;
        if (r100 == null) goto L5;
        r100.setListener(null);
        this.mVideoPlayer.release();
        this.mVideoPlayer = null;
    L5:
        this.mNativePtr = 0;
    }

    public static /* synthetic */ Context access$000(PlayerContext r100) {
        return r100.mContext;
    }

    public static /* synthetic */ double access$100(PlayerContext r100) {
        return r100.mCurrentTimeCache;
    }

    private void loadInternal(String r100) {
        if (this.mVideoPlayer != null) goto L6;
        this.mVideoPlayer = createPlayer();
        this.mLooperTriggerLoad = Looper.myLooper();
        this.mVideoPlayer.setListener(this);
    L6:
        if (this.mVideoPlayer != null) goto L9;
        KryptonLLog.e(TAG, "service create video player return null");
        return;
    L9:
        KryptonLLog.i(TAG, "load url " + r100);
        this.mVideoPlayer.setDataSource(r100);
        this.mVideoPlayer.prepare();
    }

    public void load(String r100) {
        loadInternal(r100);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onCompletion(KryptonVideoPlayer r100) {
        callbackOnThreadTriggerLoad(1, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPaused(KryptonVideoPlayer r100) {
        callbackOnThreadTriggerLoad(6, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onPrepared(KryptonVideoPlayer r100) {
        this.mPrepared = true;
        callbackOnThreadTriggerLoad(0, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onRenderStart(KryptonVideoPlayer r100) {
        callbackOnThreadTriggerLoad(3, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onSeekComplete(KryptonVideoPlayer r100) {
        callbackOnThreadTriggerLoad(4, null);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public void onStartPlay(KryptonVideoPlayer r100) {
        callbackOnThreadTriggerLoad(5, null);
    }

    public void setCurrentTime(double r100) {
        if (this.mVideoPlayer != null) goto L5;
    L9:
        this.mCurrentTimeCache = r100;
        return;
    L5:
        if (this.mPrepared == false) goto L9;
        this.mVideoPlayer.setCurrentTime(r100);
    }

    public void setLoop(boolean r100) {
        KryptonVideoPlayer r101 = this.mVideoPlayer;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setLooping(r100);
    }

    public void setPlaybackRate(double r100) {
        KryptonVideoPlayer r101 = this.mVideoPlayer;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setPlaybackRate(r100);
    }

    public void setVolume(double r100) {
        KryptonVideoPlayer r101 = this.mVideoPlayer;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVolume(r100);
    }

    public void setupSurface(SurfaceTextureWrapper r100) {
        this.mVideoPlayer.setSurface(r100.getSurface());
    }

    private void callbackOnThreadTriggerLoad(final int r100, final String r101) {
        new Handler(this.mLooperTriggerLoad).post(new AnonymousClass2(this, r100, r101));
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer.Listener
    public boolean onError(KryptonVideoPlayer r100, Object r101) {
        if (r101 == null) goto L5;
        callbackOnThreadTriggerLoad(2, r101.toString());
        return false;
    L5:
        callbackOnThreadTriggerLoad(2, "Internal error");
        return false;
    }

    private PlayerContext(long r100, KryptonApp r101, Map<String, String> r102) {
        this.mCurrentTime = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mNativePtr = r100;
        this.mKryptonApp = r101;
        this.mContext = r101.getContext();
        this.mOptions = r102;
        this.mPrepared = false;
        this.mCurrentTimeCache = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public static PlayerContext create(long r100, KryptonApp r101, Object r102) {
        return new PlayerContext(r100, r101, (Map) r102);
    }

    public static /* synthetic */ void access$200(long r100, int r101, int[] r102, String r103) {
        nativeNotifyPlayerState(r100, r101, r102, r103);
    }
}
