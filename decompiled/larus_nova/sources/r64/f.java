package r64;

import android.view.Surface;
import java.util.List;

/* JADX INFO: loaded from: classes46.dex */
public interface f {
    void a(Surface r100);

    void b(List r100, String r101);

    int c();

    void d(float r100);

    float e();

    void f(b r100);

    void g();

    long getCurrentPosition();

    long getDuration();

    String getPlayId();

    void getPlayerType();

    long getWatchDuration();

    boolean h();

    void i(b r100);

    boolean isPlaying();

    void j(com.bytedance.awemeopen.infra.base.player.a r100);

    void pause();

    void release();

    void resume();

    void seekTo(long r100);

    void setIsMute(boolean r100);

    void stop();
}
