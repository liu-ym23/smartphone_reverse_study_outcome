package rg3;

import com.bytedance.android.shopping.prepurchase.arch.exposure.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements f {
    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.f
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    public a() {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.exposure.f
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.a(r100).i(r101);
    }
}
