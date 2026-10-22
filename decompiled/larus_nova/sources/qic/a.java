package qic;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.ss.ttm.player.PlaybackParams;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.VideoEngineInfos;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.net.TTVNetClient;
import nic.f;
import nic.j;
import nic.l;
import nic.p;

/* JADX INFO: loaded from: classes40.dex */
public interface a {
    void A(TTVNetClient r100);

    void B(d r100);

    PlaybackParams a();

    VideoInfo b();

    VideoEngineInfos c(String r100);

    long d();

    void e(TTVideoEngine r100);

    TTVideoEngine f();

    tic.a g();

    int getCurrentPosition();

    int getDuration();

    Resolution getResolution();

    VideoModel getVideoModel();

    p getVideoStateInquirer();

    int getWatchedDuration();

    Bitmap h();

    void i(boolean r100);

    boolean isPaused();

    boolean isPlaying();

    boolean isPrepared();

    boolean isReleased();

    boolean isShouldPlay();

    boolean isStarted();

    void j(boolean r100);

    boolean k();

    void l(j r100);

    void m(f r100);

    void n(nic.c r100);

    void o(boolean r100);

    int p(boolean r100);

    void pause();

    void play();

    void prepare();

    void q(l r100);

    boolean r();

    void release();

    void s(int r100);

    void seekTo(long r100);

    void setLoop(boolean r100);

    void setMute(boolean r100);

    void setPlayEntity(tic.a r100);

    void setPlaybackParams(PlaybackParams r100);

    void setRenderMode(int r100);

    void setResolution(Resolution r100, boolean r101);

    void setStartTime(int r100);

    void setSurface(Surface r100);

    void setSurfaceHolder(SurfaceHolder r100);

    void setVolume(float r100, float r101);

    void t(boolean r100);

    void u();

    boolean v();

    void w(boolean r100);

    void x(boolean r100);

    boolean y();

    d z();
}
