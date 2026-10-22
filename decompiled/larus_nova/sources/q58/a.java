package q58;

import com.larus.audio.audiov3.audio.player.AudioPlayerState;

/* JADX INFO: loaded from: classes3.dex */
public interface a {
    void a(byte[] r100, int r101);

    int c();

    boolean d();

    boolean e();

    void f(u58.a r100);

    void g(b r100);

    AudioPlayerState getPlayState();

    void pause();

    void resume();

    void setVolume(float r100);

    void start();

    void stop();
}
