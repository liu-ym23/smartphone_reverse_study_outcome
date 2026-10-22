package com.ss.android.ugc.aweme.live.alphaplayer.player;

import android.view.Surface;
import com.ss.android.ugc.aweme.live.alphaplayer.model.VideoInfo;
import com.ss.android.ugc.aweme.live.alphaplayer.player.IMediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes40.dex */
public interface IMediaPlayer<T extends IMediaPlayer> {

    public interface OnCompletionListener<T> {
        void a(AbsPlayer r100);
    }

    public interface OnErrorListener<T> {
        void a(AbsPlayer r100, int r101, int r102, String r103);
    }

    public interface OnFirstFrameListener<T> {
        void a(AbsPlayer r100);
    }

    public interface OnPreparedListener<T> {
        void a(IMediaPlayer r100);
    }

    void a();

    void b() throws Exception;

    String c();

    void d(OnFirstFrameListener<T> r100);

    void e(OnErrorListener<T> r100);

    void f(OnPreparedListener<T> r100);

    void g(OnCompletionListener<T> r100);

    int getCurrentPosition();

    VideoInfo getVideoInfo() throws Exception;

    boolean isPlaying();

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void seekTo(int r100);

    void setDataSource(String r100) throws IOException;

    void setLooping(boolean r100);

    void setSurface(Surface r100);

    void start();

    void stop();
}
