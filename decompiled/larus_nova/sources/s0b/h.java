package s0b;

import com.bytedance.geckox.logger.Logger;
import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Logger {
    public h() {
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void d(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        j.f(r100, r101);
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "tr");
        j.c(r100, r101, r102);
    }

    @Override // com.bytedance.geckox.logger.Logger
    public final void w(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "tr");
        j.c(r100, r101, r102);
    }
}
