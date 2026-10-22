package uy4;

import com.bytedance.geckox.logger.Logger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements Logger {
    public o() {
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void d(String r100, Object... r101) {
        tt5.a.h(r100, Arrays.toString(r101));
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void w(String r100, String r101) {
        tt5.a.k(r100, r101);
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void e(String r100, String r101, Throwable r102) {
        tt5.a.e(r100, r101, r102, false);
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void w(String r100, String r101, Throwable r102) {
        tt5.a.e(r100, r101, r102, false);
    }
}
