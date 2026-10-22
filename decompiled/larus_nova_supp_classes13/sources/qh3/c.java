package qh3;

import com.bytedance.android.shopping.sku.inner.container.SkuEmptyContainerActivity;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements com.bytedance.android.shopping.sku.inner.container.a {
    public final /* synthetic */ e a;
    public final /* synthetic */ Ref.ObjectRef b;

    @Override // com.bytedance.android.shopping.sku.inner.container.a
    public final void a(SkuEmptyContainerActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        Ref.ObjectRef r0 = this.b;
        r0.element = this.a.a(r3.getSupportFragmentManager());
    }

    public c(e r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }
}
