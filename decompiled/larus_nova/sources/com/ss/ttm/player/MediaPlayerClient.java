package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public abstract class MediaPlayerClient {
    public static final int IsAudioVoiceWaitTimeout = 1;
    public static final int IsBuffering = 0;
    public static final int MAX_LOG_LINES = 40;

    public MediaPlayerClient() {
    }

    public abstract void deselectTrack(int r100);

    public abstract int getCurrentPosition();

    public String getDataSource() {
        return null;
    }

    public double getDoubleOption(int r100, double r101) {
        return r101;
    }

    public abstract int getDuration();

    public float getFloatOption(int r100, float r101) {
        return r101;
    }

    public int getIntOption(int r100, int r101) {
        return r101;
    }

    public long getLongOption(int r100, long r101) {
        return r101;
    }

    public Object getObjectOption(int r100) {
        return null;
    }

    public abstract int getSelectedTrack(int r100);

    public String getStringOption(int r100) {
        return null;
    }

    public String getSubtitleContent(int r100) {
        return null;
    }

    public abstract MediaPlayer.TrackInfo[] getTrackInfo();

    public abstract int getType();

    public abstract int getVideoHeight();

    public int getVideoType() {
        return 0;
    }

    public abstract int getVideoWidth();

    public abstract boolean isLooping();

    public boolean isMute() {
        return false;
    }

    public abstract boolean isPlaying();

    public void mouseEvent(int r100, int r101, int r102) {
    }

    public abstract void pause();

    public abstract void preDemux();

    public abstract void prepare();

    public abstract void prepareAsync();

    public abstract void prevClose();

    public abstract void release();

    public abstract void releaseAsync();

    public abstract void reset();

    public void rotateCamera(float r100, float r101) {
    }

    public abstract void seekTo(int r100);

    public void seekTo(int r100, int r101) {
    }

    public abstract void selectTrack(int r100);

    public void setABRStrategy(ABRStrategy r100) {
    }

    public void setAIBarrageInfo(MaskInfo r100) {
    }

    public void setAudioProcessor(AudioProcessor r100) {
    }

    public void setCacheFile(String r100, int r101) {
    }

    public abstract void setDataSource(Context r100, Uri r101) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(Context r100, Uri r101, Map<String, String> r102) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(IMediaDataSource r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDataSource(FileDescriptor r100, long r101, long r102) throws IllegalStateException, IllegalArgumentException, IOException;

    public abstract void setDataSource(String r100) throws IllegalArgumentException, SecurityException, IllegalStateException, IOException;

    public abstract void setDisplay(SurfaceHolder r100);

    public int setDoubleOption(int r100, double r101) {
        return -1;
    }

    public int setFloatOption(int r100, float r101) {
        return -1;
    }

    public int setFloatOptionArray(int[] r100, float[] r101) {
        return -1;
    }

    public abstract void setFrameMetadataListener(FrameMetadataListener r100);

    public int setIntOption(int r100, int r101) {
        return -1;
    }

    public int setIntOptionArray(int[] r100, int[] r101) {
        return -1;
    }

    public void setIsMute(boolean r100) {
    }

    public void setLoadControl(LoadControl r100) {
    }

    public int setLongOption(int r100, long r101) {
        return -1;
    }

    public int setLongOptionArray(int[] r100, long[] r101) {
        return -1;
    }

    public abstract void setLooping(boolean r100);

    public void setMaskInfo(MaskInfo r100) {
    }

    public abstract void setMediaTransport(MediaTransport r100);

    public abstract void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener r100);

    public abstract void setOnCompletionListener(MediaPlayer.OnCompletionListener r100);

    public abstract void setOnErrorListener(MediaPlayer.OnErrorListener r100);

    public abstract void setOnExternInfoListener(MediaPlayer.OnExternInfoListener r100);

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener r100, Handler r101) {
    }

    public abstract void setOnInfoListener(MediaPlayer.OnInfoListener r100);

    public void setOnLogListener(MediaPlayer.OnLogListener r100) {
    }

    public abstract void setOnPreparedListener(MediaPlayer.OnPreparedListener r100);

    public abstract void setOnSARChangedListener(MediaPlayer.onSARChangedListener r100);

    public abstract void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener r100);

    public abstract void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener r100);

    public void setPanoVideoControlModel(int r100) {
    }

    public abstract void setPlaybackParams(PlaybackParams r100);

    public abstract void setScreenOnWhilePlaying(boolean r100);

    public void setStrategyParamsTransport(StrategyParamsTransport r100) {
    }

    public int setStringOption(int r100, String r101) {
        return -1;
    }

    public int setStringOptionArray(int[] r100, String[] r101) {
        return -1;
    }

    public void setSubInfo(SubInfo r100) {
    }

    public abstract void setSurface(Surface r100);

    public abstract void setSurfaceTimeOut(Surface r100, int r101);

    public void setTraitObject(int r100, TraitObject r101) {
    }

    public abstract void setVolume(float r100, float r101);

    public abstract void setWakeMode(Context r100, int r101);

    public void setupMediaCodec() {
    }

    public abstract void start();

    public abstract void stop();

    public abstract void switchStream(int r100, int r101);

    public abstract void takeScreenshot(MediaPlayer.OnScreenshotListener r100);

    public void setWindowClient(TTAVWindowClient r100) {
        throw new RuntimeException("Not implements");
    }
}
