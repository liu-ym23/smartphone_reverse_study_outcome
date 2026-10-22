package fi4;

import android.net.Uri;
import android.view.Surface;
import gi4.t;

/* JADX INFO: loaded from: classes15.dex */
public interface e {
    void c();

    void d(Uri r100);

    void e();

    void f(t r100);

    int getPlayedDuration();

    boolean isPlaying();

    boolean isPrepared();

    void pause();

    void play();

    void release();

    void setSurface(Surface r100);

    void stop();
}
