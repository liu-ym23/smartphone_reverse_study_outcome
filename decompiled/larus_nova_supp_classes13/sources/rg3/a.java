package rg3;

import com.bytedance.android.shopping.prepurchase.arch.exposure.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements f {
    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.f
    public final void d(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
    }

    public a() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.f
    public final void i(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        dm.a.a(r2).i(r3);
    }
}
