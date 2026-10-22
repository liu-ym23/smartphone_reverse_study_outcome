package qf3;

import com.bytedance.android.shopping.mall.LynxMallFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements g {
    public g a;

    public h(LynxMallFragment.b r1) {
        this.a = r1;
    }

    @Override // qf3.g
    public final void a(j r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        g r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
