package kq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface a {

    /* JADX INFO: renamed from: kq1.a$a, reason: collision with other inner class name */
    public static final class C6600a {
        public static /* synthetic */ boolean a(a r100, boolean r101, Boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L5;
            Boolean r104 = Boolean.FALSE;
        L7:
            if ((r103 & 4) == 0) goto L10;
            r102 = Boolean.FALSE;
        L10:
            return r100.e(r101, r104, r102);
        L5:
            r104 = null;
            goto L7
        }
    }

    void b();

    void c(Map<String, String> r100, Episode r101);

    d d();

    boolean e(boolean r100, Boolean r101, Boolean r102);

    Map<String, String> f(Episode r100);
}
