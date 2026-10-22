package ln;

import android.graphics.Rect;
import com.bytedance.android.ec.store.utils.playable.PlayAbleType;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public interface c {

    public static final class a {
        public static void a(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.d(r100);
            return;
        }

        public static void b(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        public static void c(c r100) {
            b r101 = r100.m();
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        public static void d(c r100) {
            r100.v();
            r100.M();
        }

        public static void e(c r100) {
            r100.R();
            r100.x();
        }

        public static void f(c r100) {
            r100.B();
            r100.z();
        }
    }

    void B();

    List<c> L(Rect r100);

    void M();

    PlayAbleType P();

    void R();

    boolean isPlaying();

    void k1(nn.e.a r100);

    b m();

    void pausePlay();

    Rect r();

    void startPlay();

    void stopPlay();

    void v();

    void x();

    void z();
}
