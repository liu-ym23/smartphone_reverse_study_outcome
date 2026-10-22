package qja;

import android.view.Surface;
import java.io.IOException;
import oja.e;
import oja.f;
import oja.g;

/* JADX INFO: loaded from: classes33.dex */
public interface c {

    public interface a {
        void onCompletion();
    }

    public interface b {
        void onError();
    }

    /* JADX INFO: renamed from: qja.c$c, reason: collision with other inner class name */
    public interface InterfaceC7343c {
        void onFirstFrame();
    }

    public interface d {
        void onPrepared();
    }

    void a();

    void b() throws Exception;

    void c();

    void d() throws IOException;

    void e(e r100);

    void f(g r100);

    void g(oja.d r100);

    pja.c getVideoInfo() throws Exception;

    void h(f r100);

    void pause();

    void prepareAsync();

    void release();

    void reset();

    void setSurface(Surface r100);

    void start();

    void stop();
}
