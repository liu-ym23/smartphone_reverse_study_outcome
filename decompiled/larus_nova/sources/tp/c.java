package tp;

import android.graphics.Rect;
import com.bytedance.android.ec.window.base.utils.playable.WindowPlayAbleType;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public interface c {

    public static final class a {
        public static void a(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        public static void b(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }

        public static void c(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.c(r100);
            return;
        }

        public static void d(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.e(r100);
            return;
        }

        public static void e(c r100) {
            r100.v();
            r100.M();
        }

        public static boolean f(c r100) {
            boolean r101 = r100.g0();
            r100.U0();
            return r101;
        }

        public static void g(c r100) {
            r100.R();
            r100.x();
        }

        public static void h(c r100) {
            r100.B();
            r100.z();
        }
    }

    void B();

    boolean D3();

    List<c> L(Rect r100);

    void M();

    WindowPlayAbleType P();

    void R();

    void U0();

    boolean g0();

    boolean isPlaying();

    b m();

    void o2(b r100);

    void pausePlay();

    Rect r();

    boolean resumePlay();

    void startPlay();

    void stopPlay();

    void v();

    void x();

    void z();
}
