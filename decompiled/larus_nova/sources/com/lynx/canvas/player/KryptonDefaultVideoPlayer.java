package com.lynx.canvas.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.os.Build;
import android.view.Surface;
import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.KryptonVideoPlayer;
import fna.g;
import gna.a;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonDefaultVideoPlayer implements KryptonVideoPlayer, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener {
    private static final String TAG = "Player default";
    private Context mContext;
    private double mCurrentTimeForPause;
    private int mDuration;
    private int mHeight;
    private final MediaPlayer mPlayer;
    private KryptonVideoPlayer.Listener mPlayerListener;
    private int mRotation;
    private int mWidth;

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public double getCurrentTime() {
        if (this.mPlayer.isPlaying() == true) goto L7;
        return this.mCurrentTimeForPause;
    L7:
        return ((double) this.mPlayer.getCurrentPosition()) / 1000.0d;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean getLooping() {
        return this.mPlayer.isLooping();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public double getPlaybackRate() {
    L7:
        e = move-exception;
        KryptonLLog.e(TAG, "getPlaybackRate exception:" + e.getMessage());
        return 1.0d;
    L3:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        return this.mPlayer.getPlaybackParams().getSpeed();
    L13:
        return 1.0d;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void pause() {
        this.mCurrentTimeForPause = ((double) this.mPlayer.getCurrentPosition()) / 1000.0d;     // Catch: IllegalStateException -> L6
        INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(this.mPlayer);     // Catch: IllegalStateException -> L6
        KryptonVideoPlayer.Listener r100 = this.mPlayerListener;     // Catch: IllegalStateException -> L6
        if (r100 == null) goto L11;
        r100.onPaused(this);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "pause exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void play() {
        INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(this.mPlayer);     // Catch: IllegalStateException -> L6
        KryptonVideoPlayer.Listener r100 = this.mPlayerListener;     // Catch: IllegalStateException -> L6
        if (r100 == null) goto L11;
        r100.onStartPlay(this);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "play exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void prepare() {
        this.mPlayer.prepareAsync();     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "prepareAsync exception: " + e.getMessage());
        callbackWithErrorMessage("prepareAsync exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void release() {
        this.mPlayer.release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "release exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getDuration() {
        return this.mDuration;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getRotation() {
        return this.mRotation;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public int getVideoWidth() {
        return this.mWidth;
    }

    public KryptonDefaultVideoPlayer(Context r100) {
        this.mContext = r100;
        MediaPlayer r101 = new MediaPlayer();
        this.mPlayer = r101;
        r101.setOnPreparedListener(this);
        r101.setOnErrorListener(this);
        r101.setOnCompletionListener(this);
        r101.setOnSeekCompleteListener(this);
        r101.setOnInfoListener(this);
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(MediaPlayer r100) {
        if (g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        a.a(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_lynx_canvas_player_KryptonDefaultVideoPlayer_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(MediaPlayer r100) {
        if (g.d() == true) goto L6;
        r100.start();
        return;
    L6:
        r100.start();
        a.c(r100.hashCode());
    }

    private void callbackWithErrorMessage(String r100) {
        KryptonVideoPlayer.Listener r101 = this.mPlayerListener;
        if (r101 == null) goto L6;
        r101.onError(this, new Error(r100));
        return;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer r100) {
        KryptonVideoPlayer.Listener r101 = this.mPlayerListener;
        if (r101 == null) goto L6;
        r101.onCompletion(this);
        return;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer r100) {
        KryptonLLog.i(TAG, "onPrepared");
        if (this.mPlayerListener == null) goto L6;
        this.mWidth = this.mPlayer.getVideoWidth();
        this.mHeight = this.mPlayer.getVideoHeight();
        this.mDuration = this.mPlayer.getDuration();
        this.mPlayerListener.onPrepared(this);
        return;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer r100) {
        KryptonVideoPlayer.Listener r101 = this.mPlayerListener;
        if (r101 == null) goto L6;
        r101.onSeekComplete(this);
        return;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setCurrentTime(double r100) {
        int r101 = (int) (r100 * 1000.0d);
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "seekTo exception:" + e.getMessage());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L6;
        this.mPlayer.seekTo(r101, 3);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        this.mPlayer.seekTo(r101);     // Catch: Exception -> L8
        goto L11
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setDataSource(String r100) {
        this.mPlayer.reset();     // Catch: Exception -> L9
        this.mCurrentTimeForPause = AudioStats.AUDIO_AMPLITUDE_NONE;     // Catch: Exception -> L9
        this.mPlayer.setDataSource(this.mContext, UriProtector.parse(r100));     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        KryptonLLog.e(TAG, "setDataSource exception: " + e.getMessage());
        callbackWithErrorMessage("setDataSource exception:" + e.getMessage());
        return;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "reset exception: " + e.getMessage());
        callbackWithErrorMessage("reset exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setListener(KryptonVideoPlayer.Listener r100) {
        this.mPlayerListener = r100;
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setLooping(boolean r100) {
        this.mPlayer.setLooping(r100);
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setPlaybackRate(double r100) {
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "setPlaybackRate exception:" + e.getMessage());
        return;
    L4:
        if (Build.VERSION.SDK_INT < 23) goto L6;
        PlaybackParams r101 = this.mPlayer.getPlaybackParams();     // Catch: IllegalStateException -> L8
        r101.setSpeed((float) r100);     // Catch: IllegalStateException -> L8
        this.mPlayer.setPlaybackParams(r101);     // Catch: IllegalStateException -> L8
    L11:
        return;
    L6:
        KryptonLLog.i(TAG, "setPlaybackRate is not supported on API < 23");     // Catch: IllegalStateException -> L8
        goto L11
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setSurface(Surface r100) {
        this.mPlayer.setSurface(r100);     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        KryptonLLog.e(TAG, "setSurface exception:" + e.getMessage());
    }

    @Override // com.lynx.canvas.KryptonVideoPlayer
    public void setVolume(double r100) {
        float r101 = (float) r100;
        this.mPlayer.setVolume(r101, r101);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer r100, int r101, int r102) {
        KryptonLLog.i(TAG, "onError what " + r101 + " extra " + r102);
        callbackWithErrorMessage("what: " + r101 + ", extra: " + r102);
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer r100, int r101, int r102) {
        KryptonLLog.i(TAG, "onInfo what " + r101 + " extra " + r102);
        if (r101 != 3) goto L9;
        KryptonVideoPlayer.Listener r103 = this.mPlayerListener;
        if (r103 == null) goto L11;
        r103.onRenderStart(this);
        return true;
    L11:
        return true;
    L9:
        return false;
    }
}
