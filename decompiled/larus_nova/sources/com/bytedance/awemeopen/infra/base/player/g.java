package com.bytedance.awemeopen.infra.base.player;

import android.graphics.Bitmap;
import android.view.Surface;
import android.widget.FrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface g {
    void a(Surface r100);

    boolean b();

    void c(Surface r100, j r101);

    void d(float r100);

    void e(j r100);

    void f(m r100);

    String g();

    long getCurrentPosition();

    long getDuration();

    float getPlaySpeed();

    PlayState getPlayState();

    String getPlayerType();

    long getWatchDuration();

    Bitmap h(long r100);

    void i(FrameLayout r100);

    boolean isPlaying();

    void j(List<j> r100, boolean r101, String r102);

    void k(k r100);

    void pause();

    void release();

    void resume();

    void seekTo(long r100);

    void setIsMute(boolean r100);
}
