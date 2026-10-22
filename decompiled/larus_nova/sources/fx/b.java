package fx;

import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.ies.web.jsbridge2.d0;
import cx.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends c implements ex.a.b {
    @Override // ex.a.b
    public final void f(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "jsBridge2");
    }

    @Override // com.bytedance.android.latch.internal.util.a
    public final void j() {
    }

    public b(ex.b r100, LatchProcessOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Intrinsics.checkNotNullParameter(r101, "processOptions");
        super(r100, r101);
    }
}
