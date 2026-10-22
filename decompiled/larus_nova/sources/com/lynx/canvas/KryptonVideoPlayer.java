package com.lynx.canvas;

import android.view.Surface;

/* JADX INFO: loaded from: classes32.dex */
public interface KryptonVideoPlayer {

    /* JADX INFO: renamed from: com.lynx.canvas.KryptonVideoPlayer$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static double $default$getPlaybackRate(KryptonVideoPlayer r100) {
            return 1.0d;
        }

        public static void $default$setPlaybackRate(KryptonVideoPlayer r100, double r101) {
        }
    }

    public interface Listener {
        void onCompletion(KryptonVideoPlayer r100);

        boolean onError(KryptonVideoPlayer r100, Object r101);

        void onPaused(KryptonVideoPlayer r100);

        void onPrepared(KryptonVideoPlayer r100);

        void onRenderStart(KryptonVideoPlayer r100);

        void onSeekComplete(KryptonVideoPlayer r100);

        void onStartPlay(KryptonVideoPlayer r100);
    }

    double getCurrentTime();

    int getDuration();

    boolean getLooping();

    double getPlaybackRate();

    int getRotation();

    int getVideoHeight();

    int getVideoWidth();

    boolean isPlaying();

    void pause();

    void play();

    void prepare();

    void release();

    void setCurrentTime(double r100);

    void setDataSource(String r100);

    void setListener(Listener r100);

    void setLooping(boolean r100);

    void setPlaybackRate(double r100);

    void setSurface(Surface r100);

    void setVolume(double r100);
}
