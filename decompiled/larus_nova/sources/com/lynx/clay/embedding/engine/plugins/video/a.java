package com.lynx.clay.embedding.engine.plugins.video;

import android.content.Context;
import android.view.Surface;
import android.view.View;

/* JADX INFO: loaded from: classes32.dex */
public interface a {

    /* JADX INFO: renamed from: com.lynx.clay.embedding.engine.plugins.video.a$a, reason: collision with other inner class name */
    public interface InterfaceC4551a {
        void onBufferingChange(int r100);

        void onCanPlay();

        void onEnded();

        void onError(int r100, String r101, String r102);

        void onFirstFrame();

        void onPause();

        void onPlay();

        void onPlaying();

        void onPrepared(int r100);

        void onVideoInfos(String r100, long r101);

        void onVideoSizeChanged(int r100, int r101);

        void onWaiting();
    }

    void a();

    void b(boolean r100);

    void c();

    View createView(Context r100);

    void d();

    void dispose();

    void e();

    void enterBackground();

    void enterForeground();

    void f(boolean r100);

    void g();

    int getDuration();

    int getPosition();

    void h(int r100);

    void i(String r100);

    void j(boolean r100);

    void pause();

    void play();

    void seekTo(int r100);

    void setLoop(boolean r100);

    void setMuted(boolean r100);

    void setSpeed(float r100);

    void setSrc(String r100);

    void setSurface(Surface r100);

    void setVolume(double r100);

    void stop();
}
