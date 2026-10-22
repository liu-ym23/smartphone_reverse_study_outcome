package lx;

import com.bytedance.android.latch.LatchProcessOptions;
import com.lynx.tasm.LynxView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends cx.c implements kx.a.b {
    @Override // com.bytedance.android.latch.internal.util.a
    public final void j() {
    }

    @Override // kx.a.b
    public final void y(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public c(kx.b r100, LatchProcessOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Intrinsics.checkNotNullParameter(r101, "processOptions");
        super(r100, r101);
    }
}
