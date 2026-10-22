package ff9;

import kd9.w0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public interface x {

    public static final class a {
        public static /* synthetic */ void a(x r100, boolean r101, JSONObject r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = null;
        L8:
            r100.b(r101, r102);
        }
    }

    void a(com.larus.im.service.audio.m r100);

    void b(boolean r100, JSONObject r101);

    void c(boolean r100);

    void d(com.larus.im.service.audio.m r100);

    void e(w0 r100);

    void f(w0 r100);

    void initialize();

    void pause();

    void resume();

    void start();
}
