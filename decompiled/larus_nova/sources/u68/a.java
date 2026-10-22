package u68;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.play.f;
import com.larus.audio.call.play.h;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public interface a {

    /* JADX INFO: renamed from: u68.a$a, reason: collision with other inner class name */
    public static final class C7838a {
        public static /* synthetic */ void a(a r100, boolean r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            r101 = false;
        L5:
            r100.k(false, r101, r102);
        }
    }

    public interface b {

        /* JADX INFO: renamed from: u68.a$b$a, reason: collision with other inner class name */
        public static final class C7839a {
            public static /* synthetic */ void a(f r100) {
                r100.f(TtsPlayEndType.NORMAL);
            }
        }

        void a();

        void b(Map<String, String> r100);

        void c();

        void d(h.a r100);

        void e(boolean r100);

        void f(TtsPlayEndType r100);

        void g(byte[] r100);

        void i(byte[] r100);

        void onPaused();

        void onPlayComplete();

        void onResume();
    }

    void a();

    void b();

    void c(boolean r100);

    void d(boolean r100, boolean r101, String r102);

    void e(boolean r100);

    void h();

    void i(b r100);

    boolean isPlaying();

    void j(b r100);

    void k(boolean r100, boolean r101, String r102);

    void pause(String r100);

    void release(boolean r100);

    void resume(String r100);

    void setVolume(float r100);
}
