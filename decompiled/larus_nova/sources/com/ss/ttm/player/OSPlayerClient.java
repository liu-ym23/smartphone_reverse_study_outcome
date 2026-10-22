package com.ss.ttm.player;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class OSPlayerClient extends MediaPlayerClient {
    private boolean mIsUsedNewWindowClient;
    protected MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    protected MediaPlayer.OnCompletionListener mOnCompletionListener;
    protected MediaPlayer.OnErrorListener mOnErrorListener;
    protected MediaPlayer.OnInfoListener mOnInfoListener;
    protected MediaPlayer.OnPreparedListener mOnPreparedListener;
    protected MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    protected MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private android.media.MediaPlayer mPlayer;
    private TTAVWindowClient mWindowClient;
    private MediaPlayer mWrapper;

    public static class WrapOnBufferingUpdateListener implements android.media.MediaPlayer.OnBufferingUpdateListener {
        private MediaPlayer.OnBufferingUpdateListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100, MediaPlayer r101) {
            this.mWrapper = r101;
            this.mListener = r100;
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(android.media.MediaPlayer r100, int r101) {
            this.mListener.onBufferingUpdate(this.mWrapper, r101);
        }
    }

    public static class WrapOnCompletionListener implements android.media.MediaPlayer.OnCompletionListener {
        private MediaPlayer.OnCompletionListener mListener;
        private MediaPlayer mWrapper;

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(android.media.MediaPlayer r100) {
            this.mListener.onCompletion(this.mWrapper);
        }

        public WrapOnCompletionListener(MediaPlayer.OnCompletionListener r100, MediaPlayer r101) {
            this.mWrapper = r101;
            this.mListener = r100;
        }
    }

    public static class WrapOnErrorListener implements android.media.MediaPlayer.OnErrorListener {
        private MediaPlayer.OnErrorListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnErrorListener(MediaPlayer.OnErrorListener r100, MediaPlayer r101) {
            this.mWrapper = r101;
            this.mListener = r100;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(android.media.MediaPlayer r100, int r101, int r102) {
            return this.mListener.onError(this.mWrapper, r101, r102);
        }
    }

    public static class WrapOnInfoListener implements android.media.MediaPlayer.OnInfoListener {
        private MediaPlayer.OnInfoListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnInfoListener(MediaPlayer.OnInfoListener r100, MediaPlayer r101) {
            this.mWrapper = r101;
            this.mListener = r100;
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(android.media.MediaPlayer r100, int r101, int r102) {
            return this.mListener.onInfo(this.mWrapper, r101, r102);
        }
    }

    public static class WrapOnPreparedListener implements android.media.MediaPlayer.OnPreparedListener {
        private MediaPlayer.OnPreparedListener mListener;
        private MediaPlayer mWrapper;

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(android.media.MediaPlayer r100) {
            this.mListener.onPrepared(this.mWrapper);
        }

        public WrapOnPreparedListener(MediaPlayer.OnPreparedListener r100, MediaPlayer r101) {
            this.mListener = r100;
            this.mWrapper = r101;
        }
    }

    public static class WrapOnSeekCompleteListener implements android.media.MediaPlayer.OnSeekCompleteListener {
        private MediaPlayer.OnSeekCompleteListener mListener;
        private MediaPlayer mWrapper;

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(android.media.MediaPlayer r100) {
            this.mListener.onSeekComplete(this.mWrapper);
        }

        public WrapOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100, MediaPlayer r101) {
            this.mListener = r100;
            this.mWrapper = r101;
        }
    }

    public static class WrapOnVideoSizeChangedListener implements android.media.MediaPlayer.OnVideoSizeChangedListener {
        private MediaPlayer.OnVideoSizeChangedListener mListener;
        private MediaPlayer mWrapper;

        public WrapOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100, MediaPlayer r101) {
            this.mListener = r100;
            this.mWrapper = r101;
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(android.media.MediaPlayer r100, int r101, int r102) {
            this.mListener.onVideoSizeChanged(this.mWrapper, r101, r102);
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void preDemux() {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prevClose() {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo r100) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int r100, int r101) {
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener r100) {
    }

    private void _doSetVideoScalingMode() {
        if (this.mIsUsedNewWindowClient == false) goto L6;
        this.mPlayer.setVideoScalingMode(2);
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getCurrentPosition();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getDuration();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L12;
    L11:
        return null;
    L12:
        android.media.MediaPlayer.TrackInfo[] r101 = r100.getTrackInfo();     // Catch: Exception -> L6
    L7:
        if (r101 == null) goto L11;
        MediaPlayer.TrackInfo[] r102 = new MediaPlayer.TrackInfo[r101.length];
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r103) goto L11;
        r102[r105] = new MediaPlayer.TrackInfo(r101[r104]);
        r104 = r104 + 1;
        r105 = r105 + 1;
    L6:
        r101 = null;
        goto L7
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getVideoHeight();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return 0;
    L8:
        return r100.getVideoWidth();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return r100.isLooping();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L8;
    L6:
        return false;
    L8:
        return r100.isPlaying();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L9;
        INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L13;
        r100.prepare();     // Catch: IOException -> L6 IllegalStateException -> L8
    L15:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L9;
        r100.prepareAsync();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 != null) goto L13;
        return;
    L13:
        r100.release();     // Catch: Throwable -> L7 Exception -> L12
    L7:
        th = move-exception;
        this.mPlayer = null;
        throw th;
    L10:
        this.mPlayer = null;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        ThreadMethodProxy.start(new PthreadThreadV2(new AnonymousClass1(this), "SPlayerClient"));
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L9;
        r100.reset();     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L9;
        INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        android.media.MediaPlayer r100 = this.mPlayer;
        if (r100 == null) goto L9;
        INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    public OSPlayerClient() {
        this.mIsUsedNewWindowClient = false;
        this.mWindowClient = null;
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_pause(android.media.MediaPlayer r100) {
        if (fna.g.d() == true) goto L6;
        r100.pause();
        return;
    L6:
        r100.pause();
        gna.a.a(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_start(android.media.MediaPlayer r100) {
        if (fna.g.d() == true) goto L6;
        r100.start();
        return;
    L6:
        r100.start();
        gna.a.c(r100.hashCode());
    }

    public static void INVOKEVIRTUAL_com_ss_ttm_player_OSPlayerClient_com_obric_performance_power_monitor_audio_MediaPlayerLancet_stop(android.media.MediaPlayer r100) {
        if (fna.g.d() == true) goto L6;
        r100.stop();
        return;
    L6:
        r100.stop();
        gna.a.a(r100.hashCode());
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L9;
        r101.deselectTrack(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 != null) goto L10;
        return -1;
    L10:
        return r101.getSelectedTrack(r100);
    L7:
        return 0;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L9;
        r101.seekTo(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(r100);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.setDisplay(r100);     // Catch: Exception -> L7
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L9;
        r101.setLooping(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100) {
        this.mOnBufferingUpdateListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnBufferingUpdateListener(new WrapOnBufferingUpdateListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener r100) {
        this.mOnCompletionListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnCompletionListener(new WrapOnCompletionListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener r100) {
        this.mOnErrorListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnErrorListener(new WrapOnErrorListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener r100) {
        this.mOnInfoListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnInfoListener(new WrapOnInfoListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener r100) {
        this.mOnPreparedListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnPreparedListener(new WrapOnPreparedListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100) {
        this.mOnSeekCompleteListener = r100;
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnSeekCompleteListener(new WrapOnSeekCompleteListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L6;
        r101.setOnVideoSizeChangedListener(new WrapOnVideoSizeChangedListener(r100, this.mWrapper));
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams r100) {
        if (Build.VERSION.SDK_INT < 23) goto L22;
        android.media.PlaybackParams r101 = new android.media.PlaybackParams();
        float r102 = r100.getSpeed();
        if (r102 <= 0.0f) goto L7;
        r101.setSpeed(r102);
    L7:
        int r103 = r100.getAudioFallbackMode();
        if (r103 < 0) goto L10;
        r101.setAudioFallbackMode(r103);
    L10:
        float r104 = r100.getPitch();
        if (r104 <= 0.0f) goto L13;
        r101.setPitch(r104);
    L13:
        android.media.MediaPlayer r105 = this.mPlayer;
        if (r105 == null) goto L23;
        r105.setPlaybackParams(r101);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    L23:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean r100) {
        android.media.MediaPlayer r101 = this.mPlayer;
        if (r101 == null) goto L9;
        r101.setScreenOnWhilePlaying(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface r100) {
        this.mPlayer.setSurface(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWindowClient(TTAVWindowClient r100) {
        this.mIsUsedNewWindowClient = true;
        _doSetVideoScalingMode();
        TTAVWindowClient r101 = this.mWindowClient;
        if (r101 == null) goto L6;
        if (r101 == r100) goto L6;
        r101.unbindMediaClient(this);
    L6:
        if (r100 == null) goto L8;
        r100.bindMediaClient(this);
    L8:
        this.mWindowClient = r100;
    }

    public static final synchronized OSPlayerClient create(MediaPlayer r100, Context r101) {
        monitor-enter(OSPlayerClient.class);
        OSPlayerClient r102 = new OSPlayerClient();     // Catch: Throwable -> L7
        r102.mPlayer = new android.media.MediaPlayer();     // Catch: Throwable -> L7
        r102.mWrapper = r100;     // Catch: Throwable -> L7
        monitor-exit(OSPlayerClient.class);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int r100, int r101) {
        android.media.MediaPlayer r102 = this.mPlayer;
        if (r102 == null) goto L9;
        r102.seekTo(r100);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context r100, Uri r101) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(r100, r101);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface r100, int r101) {
        setSurface(r100);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float r100, float r101) {
        android.media.MediaPlayer r102 = this.mPlayer;
        if (r102 == null) goto L9;
        r102.setVolume(r100, r101);     // Catch: Exception -> L6
        return;
    L10:
        return;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context r100, int r101) {
        this.mPlayer.setWakeMode(r100, r101);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor r100, long r101, long r110) throws IllegalStateException, IllegalArgumentException, IOException {
        this.mPlayer.setDataSource(r100, r101, r110);
        _doSetVideoScalingMode();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context r100, Uri r101, Map<String, String> r102) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException {
        this.mPlayer.setDataSource(r100, r101, r102);
        _doSetVideoScalingMode();
    }
}
