package uy4;

import com.bytedance.geckox.logger.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements Logger {
    public o() {
    }

    public final void d(String r1, Object... r2) {
        tt5.a.h(r1, Arrays.toString(r2));
    }

    public final void w(String r1, String r2) {
        tt5.a.k(r1, r2);
    }

    public final void e(String r2, String r3, Throwable r4) {
        tt5.a.e(r2, r3, r4, false);
    }

    public final void w(String r2, String r3, Throwable r4) {
        tt5.a.e(r2, r3, r4, false);
    }
}
